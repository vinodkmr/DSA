package com.core.java.test;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmexHTTPSTest {
    public static void main(String[] args) throws IOException, ISOException {

        HttpURLConnection conn = post();
        int responseCode = conn.getResponseCode();
        System.out.println("Sending post request : "+ conn.getURL());
        System.out.println("Response code : "+ responseCode);
        readResponse(conn);
    }

    private static void readResponse(HttpURLConnection conn) throws IOException {
        // Reading response from input Stream
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        //printing result from response
        System.out.println(response);
    }

    private InputStream getResourceAsStream() {
        return getClass().getResourceAsStream("/base1.xml");
    }

    private static HttpURLConnection post() throws IOException, ISOException {
        URL url = new URL("https://qwww318.americanexpress.com/IPPayments/inter/CardAuthorization.do");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //SET HEADERS Values on the connection object
        conn.setRequestProperty("POST", "/IPPayments/inter/CardAuthorization.do HTTP/1.1" );
        conn.setRequestProperty("Accept Language", "en us" );
        conn.setRequestProperty("ContentType", "plain/text" );
        conn.setRequestProperty("UserAgent", "Application" );
        conn.setRequestProperty("Host", "qwww318.americanexpress.com");
        conn.setRequestProperty("CacheControl", "no cache" );
        conn.setRequestProperty("Connection", "KeepAlive" );
        conn.setRequestProperty("origin", "" );
        conn.setRequestProperty("country", "" );
        conn.setRequestProperty("region", "" );
        conn.setRequestProperty("message", "" );
        conn.setRequestProperty("MerchNbr", "" );
        conn.setRequestProperty("RtInd", "" );
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);

        String stArgs = getPayload();
        conn.setRequestProperty("ContentLength", String.valueOf(stArgs.length()));

        DataOutputStream out = new
                DataOutputStream(conn.getOutputStream());
        out.writeBytes(stArgs);
        System.out.println(out);
        out.flush();
        out.close();
        return conn;
    }

    private static String getPayload() throws ISOException {
        InputStream is = new AmexHTTPSTest().getResourceAsStream();
        GenericPackager packager = new GenericPackager(is);

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setMTI("0200");
        isoMsg.set("2", "411111111111111");
        byte[] result = isoMsg.pack();
        String hexString = ISOUtil.hexString(result);
        System.out.println("ISO MSg "+hexString);
        //Write payload message as post data
        String stArgs = "AuthorizationRequestParam = "+hexString;
        return stArgs;
    }
}
