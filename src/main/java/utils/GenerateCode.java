package utils;

import java.util.Random;

public class GenerateCode {

    public static String generateIdTaiKhoan() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);

        String randomString = Integer.toString(randomNumber);
        return randomString;
    }

}
