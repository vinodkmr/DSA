package com.core.java.test;

import org.jpos.iso.*;
import org.jpos.iso.packager.GenericPackager;

import java.io.InputStream;
import java.util.BitSet;
import java.util.Iterator;

public class ISOTest {
    public static void main(String[] args) throws ISOException {

        InputStream is = new ISOTest().getResourceAsStream();
        GenericPackager packager = new GenericPackager(is);

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setMTI("1100");
        isoMsg.set(2, "373953192351004");
        isoMsg.set(3, "004800");
        isoMsg.set(4, "000000038801");
        isoMsg.set(7, "0821164357");
        isoMsg.set(11, "000130");
        isoMsg.set(12, "230821114357");
        isoMsg.set(14,"2601");
        isoMsg.set(19,"840");
        isoMsg.set(22,"1000S0600110");
//        isoMsg.set(24,"100");
        isoMsg.set(25,"1900");
        isoMsg.set(26,"9399");
        isoMsg.set(27,"6");
        isoMsg.set(37,"5374        ");
        isoMsg.set(41,"001     ");
        isoMsg.set(49, "840");
        isoMsg.set(43,"=Onondaga County - Taxes\\421 Montgomery Street\\Syracuse\\13202     NY 840");
        isoMsg.set(47,"AXITDCE 01 CH 01 HBT01 STC03000SM 02  MPS01                            ");
        //isoMsg.set(generateSubMsg());
        String DE60 = "C1E7C1C1C470000000F1F2F3F4F5404040404040404040404040404040F1F6A6898294967C8885839699974B839694F3F1F5F4F3F5F2F2F3F740404040404040404040";
        isoMsg.set(new ISOBinaryField(60,ISOUtil.hex2byte(DE60)));
        isoMsg.set(63,"AXAD42303                        ");
        byte[] result = isoMsg.pack();
        dump(isoMsg);
       // isoMsg.dump(System.out, "");
        //System.out.println(ISOUtil.hexdump(result));
        String hexString = ISOUtil.hexString(result);
        System.out.println(hexString);
    }

    private static void dump(ISOMsg isoMsg) {
        isoMsg.dump(System.out,"");
        System.out.println( "<isomsg>");
        for (int i = 0; i < isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                System.out.print("<field id=\""+i+"\" value=\"");
                String string = i == 2 || i == 3?
                     ISOUtil.protect(isoMsg.getString(i)): isoMsg.getString(i);
                    System.out.println(string+"\">");

            }
        }
        System.out.println("</isomsg>");
     }


    static String generateDE60(){
        StringBuilder sb = new StringBuilder();
        return sb.append("AX").append("AAD").append("7000").append("90514               ").append("heamex@hecorp.com").append("3154352226          ").toString();
    }
    private static ISOComponent generateSubMsg() throws ISOException {
        ISOMsg isoMsg = new ISOMsg(60);
        isoMsg.set(0,"AX");
        isoMsg.set(1,"AAD");
        isoMsg.set(3,"90514               ");
        isoMsg.set(4,"heamex@hecorp.com");
        isoMsg.set(5,"3154352226          ");
        isoMsg.recalcBitMap();
        BitSet bset = (BitSet) isoMsg.getValue(-1);
        System.out.println("BitMap : " + bset.toString());

       /* isoMsg.set(8,"58");
        isoMsg.set(9,"19485A77C88858396999");*/
        return isoMsg;
    }

    InputStream  getResourceAsStream() {
        return getClass().getResourceAsStream("/amex.xml");
    }
}
