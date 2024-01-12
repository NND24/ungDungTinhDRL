package utils;

import java.util.Random;

public class GenerateVerifyCode {

    public static String generateRandomCode() {
        int codeLength = 6;
        String digits = "0123456789";
        Random random = new Random();

        StringBuilder codeBuilder = new StringBuilder(codeLength);

        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(digits.length());
            char digit = digits.charAt(index);
            codeBuilder.append(digit);
        }

        return codeBuilder.toString();
    }

}
