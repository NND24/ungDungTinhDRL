package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
        // Kiểm tra chiều dài của số CCCD và xem xét xem nó có chứa chỉ chữ số hay không
        if (!cccdNumber.matches("\\d{12}")) {
            return false;
        }

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

    public static boolean isDecimalString(String input) {
        String regex = "^\\d*\\.?\\d+$";

        return Pattern.matches(regex, input);
    }

    public static boolean isValidDate(String inputDate) {
        // Định dạng ngày tháng năm
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Không chấp nhận ngày tháng năm không hợp lệ (ví dụ: 31/02/2024)
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(inputDate);

            // Lấy thời gian hiện tại
            Calendar currentDate = Calendar.getInstance();
            // Lấy năm hiện tại
            int currentYear = currentDate.get(Calendar.YEAR);

            // Lấy thời gian nhập vào
            Calendar inputDateCal = Calendar.getInstance();
            inputDateCal.setTime(date);
            // Lấy năm nhập vào
            int inputYear = inputDateCal.get(Calendar.YEAR);

            // Kiểm tra năm và tuổi
            int age = currentYear - inputYear;
            // Kiểm tra xem tuổi có lớn hơn hoặc bằng 18 không
            if (age >= 18) {
                // Kiểm tra xem ngày tháng nhập vào có phải là ngày tháng hợp lệ không
                return inputDate.equals(sdf.format(date));
            }
        } catch (ParseException e) {
            // Ngày tháng không hợp lệ
            return false;
        }
        // Nếu không thỏa mãn các điều kiện trên, trả về false
        return false;
    }

    public static boolean isBeforeToday(Date providedDate) {
        Date today = new Date();
        return providedDate.before(today);
    }

    public static boolean kiemTraNamHoc(String year) {
        String yearPattern = "^\\d{4}-(\\d{4})$";

        if (Pattern.matches(yearPattern, year)) {
            String[] years = year.split("-");

            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);

            if (kiemTraNam(startYear) && kiemTraNam(endYear)) {
                return endYear - startYear == 1;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean kiemTraNam(int year) {
        return year >= 1000 && year <= 9999; // Năm hợp lệ nằm trong khoảng từ 1000 đến 9999
    }
}
