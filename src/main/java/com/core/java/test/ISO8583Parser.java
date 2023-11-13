package com.core.java.test;

import java.util.HashMap;
import java.util.Map;

public class ISO8583Parser {
    public static void main(String[] args) {
        String hexMessage = "F1F1F1F0723000020AD08010F1F5F3F7F3F9F5F3F1F9F2F3F5F1F0F0F4F0F0F4F8F0F0F0F0F0F0F0F0F3F8F8F0F1F0F8F2F1F1F6F4F3F5F7F0F0F0F1F2F9F2F3F0F8F2F1F1F1F4F3F5F7F1F5F0F0F0F0F2F5F2F3F8F8F9F1F4F8F5F3F7F44040404040404040F1F8F1F0F0F14040404040F4F0F2F2F7F8F1F8F0F14040404040F0F1E4F8F4F0F0F6F8C1E7C1C1C470000000F9F0F5F1F4404040404040404040404040404040F1F78885819485A77C8885839699974B839694F3F1F5F4F3F5F2F2F2F640404040404040404040";

        Map<Integer, String> fields = parseISO8583(hexMessage);
        for (Map.Entry<Integer, String> entry : fields.entrySet()) {
            System.out.println("Field " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<Integer, String> parseISO8583(String hexMessage) {
        Map<Integer, String> fields = new HashMap<>();

        int index = 0;
        while (index < hexMessage.length()) {
            String fieldLengthHex = hexMessage.substring(index, index + 4);
            int fieldLength = Integer.parseInt(fieldLengthHex, 16);

            int fieldNumber = (index / 8) + 1; // Assuming each field is 8 characters long
            String fieldDataHex = hexMessage.substring(index + 4, index + 4 + (fieldLength * 2));
            fields.put(fieldNumber, fieldDataHex);

            index += 4 + (fieldLength * 2);
        }

        return fields;
    }
}
