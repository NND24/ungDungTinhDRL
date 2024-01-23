package views.main;

import controllers.TaiKhoanCtrl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DoiMatKhauMoi extends javax.swing.JFrame {

    public DoiMatKhauMoi() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewPasswordTextField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        RetypePasswordTextField = new javax.swing.JPasswordField();
        HienThiCheckBox = new javax.swing.JCheckBox();
        ComfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Đổi mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Mật Khẩu Mới");

        NewPasswordTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NewPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPasswordTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Xác nhận Mật Khẩu");

        RetypePasswordTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        HienThiCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        HienThiCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        HienThiCheckBox.setText("Hiển thị mật khẩu");
        HienThiCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HienThiCheckBoxActionPerformed(evt);
            }
        });

        ComfirmButton.setBackground(new java.awt.Color(51, 153, 255));
        ComfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ComfirmButton.setForeground(new java.awt.Color(255, 255, 255));
        ComfirmButton.setText("Xác nhận");
        ComfirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HienThiCheckBox)
                            .addComponent(RetypePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ComfirmButton)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(158, 158, 158))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RetypePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HienThiCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComfirmButton)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComfirmButtonActionPerformed
        // TODO add your handling code here:
        String userId = QuenMatKhau.maTaiKhoan;

        char[] newPasswordChars = NewPasswordTextField.getPassword();
        String newPassword = String.valueOf(newPasswordChars);

        char[] retypePasswordChars = RetypePasswordTextField.getPassword();
        String retypePassword = String.valueOf(retypePasswordChars);

        if (newPassword.isEmpty() || retypePassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và mật khẩu nhập lại không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            if (retypePassword.equals(newPassword)) {
                try {
                    TaiKhoanCtrl.doiMatKhau(userId, newPassword);
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công, đăng nhập lại vào hệ thống!");
                    this.setVisible(false);
                    new DangNhap().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DoiMatKhauMoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nhập lại không giống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_ComfirmButtonActionPerformed

    private void HienThiCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HienThiCheckBoxActionPerformed
        // TODO add your handling code here:
        if (HienThiCheckBox.isSelected()) {
            NewPasswordTextField.setEchoChar((char) 0);
            RetypePasswordTextField.setEchoChar((char) 0);
        } else {
            NewPasswordTextField.setEchoChar('*');
            RetypePasswordTextField.setEchoChar('*');
        }
    }//GEN-LAST:event_HienThiCheckBoxActionPerformed

    private void NewPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewPasswordTextFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauMoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ComfirmButton;
    private javax.swing.JCheckBox HienThiCheckBox;
    private javax.swing.JPasswordField NewPasswordTextField;
    private javax.swing.JPasswordField RetypePasswordTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
