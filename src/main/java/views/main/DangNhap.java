package views.main;

import controllers.TaiKhoanCtrl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DangNhap extends javax.swing.JFrame {

    public static String currentUserId;

    public DangNhap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        taiKhoanTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        DangNhapButton = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        quenMatKhauLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 250));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tài khoản");

        taiKhoanTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        taiKhoanTextField.setText("n21dccn013");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Mật khẩu");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordField.setText("123456789");

        DangNhapButton.setBackground(new java.awt.Color(51, 153, 255));
        DangNhapButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DangNhapButton.setForeground(new java.awt.Color(255, 255, 255));
        DangNhapButton.setText("Đăng nhập");
        DangNhapButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DangNhapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DangNhapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangNhapButtonActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(255, 255, 255));
        check.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        check.setText("Hiển thị mật khẩu");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        quenMatKhauLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quenMatKhauLabel.setText("Quên mật khẩu?");
        quenMatKhauLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quenMatKhauLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quenMatKhauLabelMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(quenMatKhauLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(taiKhoanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(passwordField))))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(DangNhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(taiKhoanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check)
                    .addComponent(quenMatKhauLabel))
                .addGap(18, 18, 18)
                .addComponent(DangNhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DangNhapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhapButtonActionPerformed
        try {
            String userId = taiKhoanTextField.getText().trim();

            char[] passwordChars = passwordField.getPassword();
            String password = String.valueOf(passwordChars).trim();
            if (userId.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (TaiKhoanCtrl.kiemTraTaiKhoanCoTonTai(userId) == false) {
                JOptionPane.showMessageDialog(this, "Tài khoản không có trong hệ thống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String chucVu = TaiKhoanCtrl.dangNhap(userId, password);

                    if (chucVu.equalsIgnoreCase("SV")) {
                        currentUserId = userId;
                        new SinhVien().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("BCS")) {
                        currentUserId = userId;
                        new BanCanSu().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("CV")) {
                        currentUserId = userId;
                        new CoVan().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("QL")) {
                        currentUserId = userId;
                        new QuanLy().setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu bị sai!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DangNhapButtonActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        if (check.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_checkActionPerformed

    private void quenMatKhauLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quenMatKhauLabelMouseClicked
        this.setVisible(false);
        new QuenMatKhau().setVisible(true);
    }//GEN-LAST:event_quenMatKhauLabelMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangNhapButton;
    private javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel quenMatKhauLabel;
    private javax.swing.JTextField taiKhoanTextField;
    // End of variables declaration//GEN-END:variables
}
