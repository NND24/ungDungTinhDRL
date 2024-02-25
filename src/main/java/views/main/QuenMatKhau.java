package views.main;

import utils.GenerateVerifyCode;
import utils.SendEmail;
import controllers.TaiKhoanCtrl;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class QuenMatKhau extends javax.swing.JFrame {

    public static String maTaiKhoan;
    public static String verifyCode;

    public QuenMatKhau() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        guiButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DangNhapButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        taiKhoanTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quên mật khẩu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 250));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        guiButton.setBackground(new java.awt.Color(51, 153, 255));
        guiButton.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        guiButton.setForeground(new java.awt.Color(255, 255, 255));
        guiButton.setText("Gửi");
        guiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit.png"))); // NOI18N

        DangNhapButton1.setBackground(new java.awt.Color(51, 153, 255));
        DangNhapButton1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        DangNhapButton1.setForeground(new java.awt.Color(255, 255, 255));
        DangNhapButton1.setText("Quay lại");
        DangNhapButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DangNhapButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DangNhapButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangNhapButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tài khoản");

        taiKhoanTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(DangNhapButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(179, 179, 179))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(taiKhoanTextField))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(taiKhoanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DangNhapButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
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

    private void guiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiButtonActionPerformed
        try {
            verifyCode = GenerateVerifyCode.generateRandomCode();
            String email = emailTextField.getText();
            String userId = taiKhoanTextField.getText();

            if (email.isEmpty() || userId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc email không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (TaiKhoanCtrl.kiemTraEmailCoTonTai(email) == false) {
                JOptionPane.showMessageDialog(null, "Email không có trong hệ thống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (TaiKhoanCtrl.kiemTraTaiKhoanCoTonTai(userId) == false) {
                JOptionPane.showMessageDialog(null, "Tài khoản không có trong hệ thống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (TaiKhoanCtrl.kiemTraEmailCoDungTaiKhoan(email, userId) == false) {
                JOptionPane.showMessageDialog(null, "Email không đúng với tài khoản!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    SendEmail.sendEmail(verifyCode, email);
                    maTaiKhoan = userId;

                    new VerifyCode().setVisible(true);
                    this.setVisible(false);
                } catch (MessagingException | UnsupportedEncodingException ex) {
                    Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guiButtonActionPerformed

    private void DangNhapButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhapButton1ActionPerformed
        this.setVisible(false);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_DangNhapButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangNhapButton1;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton guiButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField taiKhoanTextField;
    // End of variables declaration//GEN-END:variables
}
