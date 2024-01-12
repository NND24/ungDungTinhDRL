package views.main;

import views.main.QuanLy;
import views.main.VerifyCode;
import utils.GenerateVerifyCode;
import utils.SendEmail;
import controllers.DangNhapCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class DangNhap extends javax.swing.JFrame {

    public static String currentUserEmail;

    public DangNhap() {
        initComponents();
        EmailTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhapButtonActionPerformed(e);
            }
        });

        PasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhapButtonActionPerformed(e);
            }
        });
    }

    private boolean kiemTraEmail(String email) {
        boolean flag = false;
        try {
            flag = DangNhapCtrl.kiemTraEmailCoTonTai(email);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnhBG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        QuenMKButton = new javax.swing.JButton();
        DangNhapButton = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 563));
        setResizable(false);

        AnhBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DangNhap.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email");

        EmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Mật khẩu");

        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        QuenMKButton.setBackground(new java.awt.Color(255, 102, 102));
        QuenMKButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        QuenMKButton.setForeground(new java.awt.Color(255, 255, 255));
        QuenMKButton.setText("Quên mật khẩu");
        QuenMKButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        QuenMKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuenMKButtonActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Quên mật khẩu?");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(check)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EmailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                    .addComponent(PasswordField))))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(QuenMKButton)
                        .addGap(62, 62, 62)
                        .addComponent(DangNhapButton)
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuenMKButton)
                    .addComponent(DangNhapButton))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(AnhBG)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(AnhBG))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        if (check.isSelected()) {
            PasswordField.setEchoChar((char) 0);
        } else {
            PasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_checkActionPerformed

    private void DangNhapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhapButtonActionPerformed
        // TODO add your handling code here:
        String email = EmailTextField.getText();
        currentUserEmail = email;
        char[] passwordChars = PasswordField.getPassword();
        String password = String.valueOf(passwordChars);
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (kiemTraEmail(email) == false) {
            JOptionPane.showMessageDialog(this, "Email không có trong hệ thống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                boolean flag = DangNhapCtrl.dangNhap(email, password);
                System.out.println(flag);
                if (flag == true) {
//                    currentUserEmail = email;
                    new QuanLy().setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu bị sai!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_DangNhapButtonActionPerformed

    public static String verifyCode;

    private void QuenMKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuenMKButtonActionPerformed
        // TODO add your handling code here:
        verifyCode = GenerateVerifyCode.generateRandomCode();
        String email = EmailTextField.getText();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống!");
        } else if (kiemTraEmail(email) == false) {
            JOptionPane.showMessageDialog(this, "Email không có trong hệ thống!");
        } else {
            try {
                SendEmail.sendEmail(verifyCode, email);
            } catch (MessagingException | UnsupportedEncodingException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
            new VerifyCode().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_QuenMKButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhBG;
    private javax.swing.JButton DangNhapButton;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton QuenMKButton;
    private javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
