package arrays;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PublicKeyGeneration {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, CertificateException, IOException {


        String publicKeyB64 = "MIIBITANBgkqhkiG9w0BAQEFAAOCAQ4AMIIBCQKCAQBV8xakN/wOsB6qHpyMigk/5PrSxxd6tKTJsyMIq5f9npzZue0mI4H2o8toYImtRk6VHhcldo0t7UwsQXmFMk7D"
                + "i3C53Xwfk7yEFSkXGpdtp/7fbqNnjVoJl/EPcgoDsTPrHYF/HgtmbhzuYvYeY1zpV0d2uYpFxAuqkE9FreuuH0iI8xODFe5NzRevXH116elwdCGINeAecHKgiWe"
                + "bGpRPml0lagrfi0qoQvNScmi/WIN2nFcI3sQFCq3HNYDBKDhO0AEKPB2FjvoEheJJwTs5URCYsJglYyxEUon3w6KuhVa+hzYJUAgNTCsrAhQCUlX4+5LOGlwI5gonm1DYvJJZAgMBAAEB";

        byte[] decoded = Base64.getDecoder().decode(publicKeyB64);
        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(decoded);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey generatePublic = (RSAPublicKey) kf.generatePublic(spec);

        System.out.println("Public key : " + generatePublic.toString());
        BigInteger modulus = generatePublic.getModulus();
        System.out.println(modulus);
        BigInteger exponent = generatePublic.getPublicExponent();
        System.out.println(exponent);

        String publicKeyString =
                Base64.getEncoder().encodeToString(generatePublic.getEncoded());

        System.out.println("public key = "+ publicKeyString);

        byte[] keyBytes = Files.readAllBytes(Paths.get("/Users/kapilarora/Downloads/ds/src/arrays/googlecert.pem"));

        X509Certificate myCert = (X509Certificate)CertificateFactory
                .getInstance("X509")
                .generateCertificate(
                        // string encoded with default charset
                        new ByteArrayInputStream(keyBytes)
                );
        myCert.checkValidity();
        System.out.println("Date : " + myCert.getNotAfter());

       // X509Certificate certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(decoded));
    }
}
