package utils;

import javax.swing.JOptionPane;

public class DialogHelper {

    // Hiển thị thông báo thông thường
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    // Hiển thị thông báo lỗi
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    // Hiển thị thông báo cảnh báo
    public static void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
    }

    // Hiển thị thông báo yêu cầu xác nhận 
    public static boolean showConfirmation(String message) {
        String[] options = {"Đồng ý", "Thoát"};
        int option = JOptionPane.showOptionDialog(
                null,
                message,
                "Cảnh báo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        return option == JOptionPane.YES_OPTION;
    }
}
