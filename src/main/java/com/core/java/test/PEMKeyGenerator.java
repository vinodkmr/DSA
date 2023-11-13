package com.core.java.test;

import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

public class PEMKeyGenerator {

    public static void main(String[] args) {
        try {
            // Generate Key Pair
            KeyPair keyPair = generateKeyPair();

            // Export and write public and private keys to files
            writeKeyToFile("public_key.pem", keyPair.getPublic());
            writeKeyToFile("private_key.pem", keyPair.getPrivate());

            System.out.println("Public and private keys written to files successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // You can adjust the key size as needed
        return keyPairGenerator.generateKeyPair();
    }

    private static void writeKeyToFile(String fileName, Key key) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            String keyType;
            if (key instanceof PublicKey) {
                keyType = "PUBLIC KEY";
            } else if (key instanceof PrivateKey) {
                keyType = "PRIVATE KEY";
            } else {
                throw new IllegalArgumentException("Unsupported key type");
            }

            byte[] keyBytes = key.getEncoded();
            String base64Key = Base64.getEncoder().encodeToString(keyBytes);

            StringBuilder pemFormat = new StringBuilder();
            pemFormat.append("-----BEGIN ").append(keyType).append("-----\n");
            pemFormat.append(base64Key).append("\n");
            pemFormat.append("-----END ").append(keyType).append("-----\n");

            fileWriter.write(pemFormat.toString());
        }
    }
}
