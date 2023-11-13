package com.core.java.test;

import org.jpos.iso.*;
import org.jpos.iso.packager.GenericPackager;

import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Random;

import static com.core.java.test.DE60Creation.concatenate;

public class IsoTestWorking {
    private static final String AMEX_SELLER_DETAILS_PREPENDER = "\\";

    public static void main(String[] args) throws ISOException, IOException {

        InputStream is = new IsoTestWorking().getResourceAsStream();
        //GenericPackager packager = new GenericPackager(is);
        GenericPackager packager = new GenericPackager("jar:amex.xml");

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setMTI("1100");
        isoMsg.set(2, "379343478569046");
        isoMsg.set(3, "004800");
        isoMsg.set(4, ISOUtil.padleft("12100",12,'0'));
        isoMsg.set(7, "0922083535");
        String stan = String.valueOf(new Random().nextInt(900000) + 100000);
        System.out.println("stan "+stan);
        isoMsg.set(11, stan);
        isoMsg.set(12, "230922020536");
        isoMsg.set(14,"2601");
        isoMsg.set(19,"356");
        isoMsg.set(22,"100010600110");
        isoMsg.set(24,"100");
        isoMsg.set(25,"1900");
        isoMsg.set(26,"4812");
        isoMsg.set(27,"6");
        isoMsg.set(37,"326508009001");
        isoMsg.set(41,"45719023");
        isoMsg.set(42,ISOUtil.padright("0277164851",15,' '));
        isoMsg.set(43,"Wibmo=Test Merchant\\Rashtra Bhavan\\Delhi\\110006    DL IND");
//        isoMsg.set(43,buildDE43());
        isoMsg.set(49, "356");

//        isoMsg.set(47,"AXITDCE 01 CH 01 HBT01 STC03000SM 02  MPS01                            ");
        String DE60 = "C1E7C1C1C470000000F1F2F3F4F5404040404040404040404040404040F1F6A6898294967C8885839699974B839694F3F1F5F4F3F5F2F2F3F740404040404040404040";
        isoMsg.set(60,DE60);
        isoMsg.set(61,buildDE61());
        isoMsg.set(63,"AXAD56007                        ");

        BitSet bs = new BitSet();
		byte[] cit2 = ISOUtil.asciiToEbcdic("0");
		byte[] cit3 = ISOUtil.asciiToEbcdic("0");
		byte[] cit4 = ISOUtil.asciiToEbcdic("0");
		byte[] cit5 = ISOUtil.asciiToEbcdic("0");
		bs.set(2);// field60_2_sellerID
		bs.set(3);// field60_2_sellerID
		bs.set(4);// field60_2_sellerID
		bs.set(5);// field60_2_sellerID
		byte[] bitmap = new byte[4]; // need first 4
		System.arraycopy(ISOUtil.bitSet2byte(bs), 0, bitmap, 0, 4);
		isoMsg.set(113,concatenate(ISOUtil.asciiToEbcdic("AXAED1"),bitmap,cit2, cit3,cit4,cit5));
        isoMsg.set(123,mine());
        byte[] result = isoMsg.pack();


//        System.out.println(ISOUtil.hexdump(result));
//        isoMsg.dump(System.out,"");
        String hexString = ISOUtil.hexString(result);
        System.out.println("--------------------------------------------------");
        System.out.println(hexString);


        String hex = "F1F1F1F0723000020AD08010F1F5F3F7F3F9F5F3F1F9F2F3F5F1F0F0F4F0F0F4F8F0F0F0F0F0F0F0F0F0F3F8F8F0F1F0F9F1F1F1F5F4F3F5F7F0F0F0F1F3F5F2F3F0F8F2F1F1F1F4F3F5F7F1F5F0F0F0F0F0F2F5F4F4F3F4F2F2F5F0F5F3F7F44040404040404040F1F8F1F0F0F14040404040F4F0F2F2F7F8F1F8F0F14040404040F0F1E4F8F4F0F1F3F643314537433143314334373030303030303046394630463546314634343034303430343034303430343034303430343034303430343034303430463146373838383538313934383541373743383838353833393639393937344238333936393446334631463546344633463546324632463246363430343034303430343034303430343034303430";
        //"F1F1F1F0723000020AD08010F1F5F3F7F3F9F5F3F1F9F2F3F5F1F0F0F4F0F0F4F8F0F0F0F0F0F0F0F0F0F3F8F8F0F1F0F8F2F1F1F6F4F3F5F7F0F0F0F1F2F9F2F3F0F8F2F1F1F1F4F3F5F7F1F5F0F0F0F0F0F2F5F2F0F6F2F9F5F8F4F5F3F7F44040404040404040F1F8F1F0F0F14040404040F4F0F2F2F7F8F1F8F0F14040404040F0F1E4F8F4F0F0F6F8C1E7C1C1C470000000F9F0F5F1F4404040404040404040404040404040F1F78885819485A77C8885839699974B839694F3F1F5F4F3F5F2F2F2F640404040404040404040";
        byte[] bytes = ISOUtil.hex2byte(hex);
        String hexdump = ISOUtil.hexdump(bytes);
//        System.out.println(hexdump);
        ISOMsg m = new ISOMsg ();
        m.setPackager(packager);
        m.unpack (hexdump.getBytes());
//        System.out.println(m.getString(3));

//        m.dump(System.out, "");
        //System.out.println(m);
    }

    private static byte[] buildDE123() throws ISOException {
        byte[] ax = ISOUtil.asciiToEbcdic("AX");
        byte[] atd = ISOUtil.asciiToEbcdic("ATD");
        BitSet cryptBs = new BitSet();
        cryptBs.set(1);
        byte[] bitmap1 = new byte[2]; // need first 4
        System.arraycopy(ISOUtil.bitSet2byte(cryptBs), 0, bitmap1, 0, 2);
        BitSet parent = new BitSet();
        parent.set(2);// crypto

        byte[] cryptoBytes = ISOUtil.asciiToEbcdic("AgAAAGQDrmEx5r0AmbHTg0AAAAA=");

        ISOField crypto  = new ISOField(113, new String(concatenate(bitmap1, cryptoBytes)));
        IFE_LLLBINARY pack = new IFE_LLLBINARY(113,"");
        byte[] pack1 = pack.pack(crypto);

        byte[] bitmap = new byte[4]; // need first 4
        System.arraycopy(ISOUtil.bitSet2byte(parent), 0, bitmap, 0, 4);
        return  concatenate(ax, atd, bitmap,ISOUtil.asciiToEbcdic("031"),bitmap1, ISOUtil.asciiToEbcdic("AgAAAGQDrmEx5r0AmbHTg0AAAAA="));
//        return  concatenate(ax, atd, bitmap,pack1);

    }

    private static byte[] mine() throws ISOException {
        byte[] ax = ISOUtil.asciiToEbcdic("AX");
        byte[] atd = ISOUtil.asciiToEbcdic("ATD");

        BitSet outserBitmapBitset = new BitSet();
        outserBitmapBitset.set(2); //indicating 123.2

        byte[] bitmapOuter = new byte[4]; // need first 4
        System.arraycopy(ISOUtil.bitSet2byte(outserBitmapBitset), 0, bitmapOuter, 0, 4);

        BitSet ecommCryptoBitset = new BitSet();
        ecommCryptoBitset.set(1); //inner bitmap 123.2.1

        byte[] ecommCryptoBitmap = new byte[2]; // need first 4
        System.arraycopy(ISOUtil.bitSet2byte(ecommCryptoBitset), 0, ecommCryptoBitmap, 0, 2);

        byte[] cryptoBytes =  ISOUtil.asciiToEbcdic("AgAAAGQDrmEx5r0AmbHTg0AAAAA=");

        byte[] bitmapPlusCrypto = concatenate(ecommCryptoBitmap,cryptoBytes);

        ISOBinaryField crypto  = new ISOBinaryField(113, bitmapPlusCrypto);
        IFE_LLLBINARY packagerCrypto = new IFE_LLLBINARY(999, "Crypto");
        byte[] field_123_2_1 = packagerCrypto.pack(crypto);

        System.out.println("Chillum");
        byte[] concatenate = concatenate(ax, atd, bitmapOuter, field_123_2_1);
        System.out.println(ISOUtil.hexdump(concatenate));
        return concatenate;
    }

    private static byte[] buildDE61() {
        byte[] primaryID   = ISOUtil.asciiToEbcdic("AX");
        byte[] secondaryID = ISOUtil.asciiToEbcdic("ASK");
        byte[] eci = ISOUtil.asciiToEbcdic("05");
        byte[] aevvLiteral = ISOUtil.asciiToEbcdic("AEVV");
        byte[] aevv = java.util.Base64.getDecoder().decode("AAABBWcSNIdjeUZThmNHAAAAAAA=");
        byte[] xidLiteral = ISOUtil.asciiToEbcdic("XID");
        byte[] xid = ISOUtil.asciiToEbcdic("AAABBWcSNIdjeUZThmNHAAAAAAA=");
        return concatenate(primaryID, secondaryID, eci, aevvLiteral, aevv, xidLiteral, xid);
    }

    private static String buildDE43() throws ISOException {
//        return "=Test Merchant                        \\Rashtra Bhavan              \\Delhi        \\110006   DL IND";
        StringBuilder sb = new StringBuilder();
        sb.append("=Test Merchant");
        sb.append(AMEX_SELLER_DETAILS_PREPENDER).append("Rashtra Bhavan");
        sb.append(AMEX_SELLER_DETAILS_PREPENDER).append("Delhi");
        sb.append(AMEX_SELLER_DETAILS_PREPENDER).append(ISOUtil.padright("110006", 10, ' '));
        sb.append(ISOUtil.padright("DL",3, ' '));
        sb.append(ISOUtil.padright("IND",3, ' '));
        String string = sb.toString();
        System.out.println(string);
        return string;
    }


    InputStream  getResourceAsStream() throws IOException {
        return getClass().getResourceAsStream("/amex.xml");
    }

}
