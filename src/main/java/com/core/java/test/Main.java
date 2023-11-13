package com.core.java.test;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "AuthorizationRequestParam=F1F1F0F0723425E008E28012F1F5F3F7F3F9F5F3F1F9F2F3F5F1F0F0F4F0F0F4F8F0F0F0F0F0F0F0F0F0F3F8F8F0F1F0F9F1F1F1F5F4F3F5F7F0F0F0F1F4F1F2F3F0F8F2F1F1F1F4F3F5F7F2F6F0F1F8F4F0F1F0F0F0E2F0F6F0F0F1F1F0F1F0F0F1F9F0F0F9F3F9F9F6F5F3F7F44040404040404040F0F0F14040404040F4F0F2F2F7F8F1F8F0F14040404040F7F27ED69596958481878140C396A495A3A8406040E381A785A2E0F4F2F140D49695A38796948599A840E2A3998585A3E0E2A8998183A4A285E0F1F3F2F0F24040404040D5E840F8F4F0F0F7F1C1E7C9E3C4C3C540F0F140C3C840F0F140C8C2E3F0F140E2E3C3F0F3F0F0F0E2D440F0F24040D4D7E2F0F140404040404040404040404040404040404040404040404040404040F8F4F0F0F6F4C1E7C1C1C470000000F5F6F7F8F9404040404040404040404040404040F1F38182837CA6898294964B839694F3F1F5F4F3F5F2F2F3F740404040404040404040F0F3F3C1E7C1C4F4F2F3F0F3404040404040404040404040404040404040404040404040");
        Request request = new Request.Builder()
                .url("https://qwww318.americanexpress.com/IPPayments/inter/CardAuthorization.do")
                .method("POST", body)
                .addHeader("AcceptLanguage", "en us")
                .addHeader("ContentType", "plain/text")
                .addHeader("UserAgent", "Application")
                .addHeader("Host", "qwww318.americanexpress.com")
                .addHeader("ContentLength", "500")
                .addHeader("country", "356")
                .addHeader("region", "JAPA")
                .addHeader("message", "ISO GCAG")
                .addHeader("MerchNbr", "0277164851")
                .addHeader("RtInd", "050")
                .addHeader("origin", "Wibmo")
                .addHeader("Content-Type", "text/plain")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
