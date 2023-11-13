package com.core.java.test;

import org.jpos.iso.ISOUtil;

public class StringToUnsignedBinary {
    public static void main(String[] args) {
        // Input string
        String inputString = "AJkBCVWDAwAAAdRcNWETdAAAAAA="; // Replace with your input string

        // Convert the input string to a byte array
        byte[] byteArray = ISOUtil.hex2byte(inputString);

        // Print the unsigned binary number as a string
        String unsignedBinary = byteArrayToUnsignedBinary(byteArray);
        System.out.println("Unsigned Binary: " + unsignedBinary);
    }

    // Convert a byte array to an unsigned binary string
    private static String byteArrayToUnsignedBinary(byte[] byteArray) {
        StringBuilder binaryString = new StringBuilder();
        for (byte b : byteArray) {
            int unsignedValue = Byte.toUnsignedInt(b);
            String binary = Integer.toBinaryString(unsignedValue);
            // Pad with leading zeros to ensure 8 bits per byte
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            binaryString.append(binary);
        }
        return binaryString.toString();
    }
}
