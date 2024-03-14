package utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateCode {

    public static String generateIdTaiKhoan() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);

        String randomString = Integer.toString(randomNumber);
        return randomString;
    }

    public static String layKhoa(String chuoi) {
        // Sử dụng biểu thức chính quy để tìm chuỗi số
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(chuoi);

        // Nếu tìm thấy, lấy số đầu tiên
        if (matcher.find()) {
            return matcher.group();
        }

        // Nếu không tìm thấy số nào, trả về null hoặc chuỗi rỗng tùy theo yêu cầu của bạn
        return null;
    }
}
