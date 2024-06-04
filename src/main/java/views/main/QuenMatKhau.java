package views.main;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import controllers.TaiKhoanCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.DialogHelper;
import utils.GenerateVerifyCode;
import utils.SendEmail;

public class QuenMatKhau extends javax.swing.JFrame {

    public static String userName;
    public static String verifyCode;

    public QuenMatKhau() {
        initComponents();

        txtTenDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuiActionPerformed(e);
            }
        });

        txtEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuiActionPerformed(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnGui = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        lblTaiKhoan = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quên mật khẩu");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 250));

        lblEmail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnGui.setBackground(new java.awt.Color(51, 153, 255));
        btnGui.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btnGui.setForeground(new java.awt.Color(255, 255, 255));
        btnGui.setText("Gửi");
        btnGui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        btnQuayLai.setBackground(new java.awt.Color(255, 102, 102));
        btnQuayLai.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btnQuayLai.setForeground(new java.awt.Color(255, 255, 255));
        btnQuayLai.setText("Quay lại");
        btnQuayLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        lblTaiKhoan.setText("Tên đăng nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        lblQuenMatKhau.setText("QUÊN MẬT KHẨU");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 70x70.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTaiKhoan)
                            .addComponent(lblEmail)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblLogo)
                        .addGap(50, 50, 50)
                        .addComponent(lblQuenMatKhau)))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblLogo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblQuenMatKhau)))
                .addGap(50, 50, 50)
                .addComponent(lblTaiKhoan)
                .addGap(3, 3, 3)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblEmail)
                .addGap(3, 3, 3)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        try {
            verifyCode = GenerateVerifyCode.generateRandomCode();
            String email = txtEmail.getText();
            String tenDangNhap = txtTenDangNhap.getText();

            if (email.isEmpty() || tenDangNhap.isEmpty()) {
                DialogHelper.showError("Tên đăng nhập hoặc email không được để trống!");
            } else if (TaiKhoanCtrl.kiemTraEmailCoTonTai(email) == false) {
                DialogHelper.showError("Email không có trong hệ thống!");
            } else if (TaiKhoanCtrl.kiemTraTaiKhoanCoTonTai(tenDangNhap) == false) {
                DialogHelper.showError("Tên đăng nhập không có trong hệ thống!");
            } else if (TaiKhoanCtrl.kiemTraEmailCoDungTaiKhoan(email, tenDangNhap) == false) {
                DialogHelper.showError("Email không đúng với tài khoản!");
            } else {
                try {
                    SendEmail.sendEmail(verifyCode, email);
                    userName = tenDangNhap;

                    new MaXacNhan().setVisible(true);
                    this.setVisible(false);
                } catch (MessagingException | UnsupportedEncodingException ex) {
                    Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuiActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        this.setVisible(false);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
