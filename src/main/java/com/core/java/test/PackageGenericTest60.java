package com.core.java.test;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

import java.util.BitSet;

public class PackageGenericTest60 {
    public static void main(String[] args) throws Exception {

        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));

        GenericPackager b = new GenericPackager("src/main/resources/iso87ascii60.xml");
        b.setLogger(logger, "msg");

        ISOMsg msg1 = new ISOMsg();

        msg1.setPackager(b);
        msg1.unpack(ISOUtil.hex2byte("3038303030303030303030303030303030303130303931C1E7C1C1C470000000F1F0F6F0F8F0F8F4F6F640404040404040404040F4F0C3D6D9D9C5D66DC5D4D7D9C5E2C16DC3D6D4D7C1D5E86DD4C1C9D36DC6E27CC7D4C1C9D34BC3D6D4F5F5F3F1F0F9F7F7F2F840404040404040404040"));
        msg1.dump(System.out,"");
        System.out.println(ISOUtil.hexdump(msg1.pack()));
        msg1.recalcBitMap();
        BitSet bset = (BitSet) msg1.getValue(-1);
        System.out.println("BitMap : " + bset.toString());
    }
}