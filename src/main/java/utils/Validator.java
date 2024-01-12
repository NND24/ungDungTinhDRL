package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^(03[2-9]|05[6-9]|07[0|6-9]|08[1-9]|09[0-9]|01[2-9])[0-9]{7}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidYearOfBirth(String yearOfBirth) {
        try {
            // Kiểm tra chiều dài của năm sinh
            if (yearOfBirth.length() != 4) {
                return false;
            }

            // Kiểm tra xem năm sinh có chứa chỉ chữ số không
            if (!yearOfBirth.matches("\\d+")) {
                return false;
            }

            // Lấy năm hiện tại
            int currentYear = LocalDate.now().getYear();

            // Chuyển đổi năm sinh thành số nguyên
            int birthYear = Integer.parseInt(yearOfBirth);

            // Kiểm tra xem năm sinh bắt đầu từ 1 hoặc 2 và không vượt quá năm hiện tại
            return (yearOfBirth.startsWith("1") || yearOfBirth.startsWith("2")) && birthYear <= currentYear;
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi định dạng năm sinh
            System.err.println("Lỗi: " + e.getMessage());
            return false;
        }
    }

    public static boolean isValidCccd(String cccdNumber) {
        // Kiểm tra chiều dài của số CCCD
        if (cccdNumber.length() != 9 && cccdNumber.length() != 12) {
            return false;
        }

        // Kiểm tra xem số CCCD có chứa chỉ chữ số không
        if (!cccdNumber.matches("\\d+")) {
            return false;
        }

        // Các điều kiện khác tùy thuộc vào quy tắc cụ thể của số CCCD
        // Bạn có thể cần thay đổi hàm này tùy thuộc vào yêu cầu cụ thể
        return true;
    }

    public static boolean isValidBhyt(String soTheBHYT) {
        // Tạo biểu thức chính quy để kiểm tra mã số BHYT
        String regex = "^[0-9]{2}[0-9]{2}[0-9]{6}$";

        // Kiểm tra xem mã số BHYT có đúng định dạng hay không
        boolean isVaild = Pattern.matches(regex, soTheBHYT);

        if (isVaild) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEthnicGroup(String ethnicGroup) {
        // Danh sách 54 dân tộc chính thức của Việt Nam
        List<String> vietnameseEthnicGroups = Arrays.asList(
                "Kinh", "Tày", "Thái", "Mường", "H'Mông", "Nùng", "Dao", "Gia Rai", "Ê Đê",
                "Ba Na", "Xơ Đăng", "Sán Dìu", "Chăm", "Cơ Ho", "Ra Glai", "M'nông", "Hoa",
                "Khơ Mú", "Chu Ru", "Giáy", "Lào", "La Chí", "La Hủ", "Mảng", "Mạ", "Pà Thẻn",
                "Rơ Măm", "Cờ Lao", "Brâu", "Ơ Đu", "Giẻ Triêng", "Cơ Tu", "Tà Ôi", "Măng",
                "Chu Cút", "Chơ Ro", "Lô Lô", "La Ha", "Lự", "Mảng", "M'Yang", "Pilach", "Bana",
                "Ro Mam", "Ngái", "Si La", "Pu Péo", "Rục", "La Dê", "Lự", "Chơ Đăng", "Cơ Lao"
        );

        // Kiểm tra xem dân tộc nhập liệu có trong danh sách 54 dân tộc hay không
        return vietnameseEthnicGroups.contains(ethnicGroup);
    }

    public static boolean isIntegerString(String input) {
        String regex = "^\\d+$";

        return Pattern.matches(regex, input);
    }
}
