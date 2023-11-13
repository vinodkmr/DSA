package com.core.java.test;

import org.jpos.iso.*;
import org.jpos.iso.packager.GenericPackager;

import java.util.Arrays;
import java.util.BitSet;

public class DE60Creation {

    public static void main(String[] args) throws ISOException {
        String hex = "F1F1F1F0723000020AD08010F1F5F3F7F3F9F5F3F1F9F2F3F5F1F0F0F4F0F0F4F8F0F0F0F0F0F0F0F0F0F3F8F8F0F1F0F9F1F1F1F5F4F3F5F7F0F0F0F1F4F2F2F3F0F8F2F1F1F1F4F3F5F7F1F5F0F0F0F0F0F2F5F5F0F0F8F6F3F5F2F5F3F7F44040404040404040F1F8F1F0F0F14040404040F4F0F2F2F7F8F1F8F0F14040404040F0F1E4F8F4F0F0F6F7C1E7C1C1C470000000F1F2F3F4F5404040404040404040404040404040F1F6A6898294967C8885839699974B839694F3F1F5F4F3F5F2F2F3F740404040404040404040";
        GenericPackager p = new GenericPackager("jar:amex.xml");
      /*  ISOMsg m = new ISOMsg();
        m.setPackager(p);
        m.unpack(ISOUtil.hex2byte(hex));
        m.dump(System.out, "");*/

        byte[] primaryID   = ISOUtil.asciiToEbcdic("AX");
        byte[] secondaryID = ISOUtil.asciiToEbcdic("AAD");

        BitSet bs = new BitSet();

        byte[] field60_2_sellerID = ISOUtil.asciiToEbcdic(ISOUtil.padright("12345", 20, ' '));
        bs.set(2);// field60_2_sellerID
        System.out.println(ISOUtil.hexdump(field60_2_sellerID));
        ISOField email  = new ISOField(40, "wibmo@hecorp.com");
        IFE_LLCHAR packagerEmail = new IFE_LLCHAR(40, "");
        bs.set(3);// field60_3_email
        byte[] field60_3_email = packagerEmail.pack(email);
        System.out.println(ISOUtil.hexdump(field60_3_email));
        byte[] field60_4_sellerPhone = ISOUtil.asciiToEbcdic(ISOUtil.padright("3154352237", 20, ' '));
        bs.set(4);// field60_4_sellerPhone
//        System.out.println(ISOUtil.hexdump(field60_4_sellerPhone));
        /*bs.set(5);
        bs.set(6);
        bs.set(7);*/
        byte[] bitmap = new byte[4]; // need first 4
        System.arraycopy(ISOUtil.bitSet2byte(bs), 0, bitmap, 0, 4);
        System.out.println(ISOUtil.hexdump(bitmap));

        ISOMsg m = new ISOMsg();
        GenericPackager p1 = new GenericPackager("src/main/resources/iso87ascii60.xml");
        m.setPackager(p1);
        // concat arrays primaryID, secondaryID,bitmap,field60_2_sellerID,
        // field60_3_email, field60_4_sellerPhone
        // put it in de60
        byte[] concatenate = concatenate(primaryID, secondaryID, bitmap, field60_2_sellerID, field60_3_email, field60_4_sellerPhone
              /*  , ISOUtil.asciiToEbcdic("99999999999"),
                ISOUtil.asciiToEbcdic("Y"),ISOUtil.asciiToEbcdic("000002561008144")*/);

        m.set(60,concatenate);
        byte[] x = m.pack();
        m.dump(System.out,"");
        System.out.println("last");
        //  System.out.println(ISOUtil.hexdump(x));
       // System.out.println(ISOUtil.hexString(x));
        System.out.println(ISOUtil.hexString(concatenate));
    }


    // https://www.techiedelight.com/merge-multiple-arrays-java/
    public static byte[] concatenate(byte[]... arrays) {
        int finalLength = 0;
        for (byte[] array : arrays) {
            finalLength += array.length;
        }

        byte[] dest    = null;
        int    destPos = 0;

        for (byte[] array : arrays) {
            if (dest == null) {
                dest = Arrays.copyOf(array, finalLength);
                destPos = array.length;
            }
            else {
                System.arraycopy(array, 0, dest, destPos, array.length);
                destPos += array.length;
            }
        }
        return dest;
    }
}
