package views.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import controllers.TaiKhoanCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.DialogHelper;

public class DoiMatKhauMoi extends javax.swing.JFrame {

    public DoiMatKhauMoi() {
        initComponents();

        txtMatKhauMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXacNhanActionPerformed(e);
            }
        });

        txtXacNhanMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXacNhanActionPerformed(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMatKhauMoi = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        lblXacNhanMatKhau = new javax.swing.JLabel();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        chkHienThiMatKhau = new javax.swing.JCheckBox();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblDoiMatKhau = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        lblMatKhauMoi.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblMatKhauMoi.setText("Mật Khẩu Mới");

        txtMatKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblXacNhanMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblXacNhanMatKhau.setText("Xác Nhận Mật Khẩu");

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        chkHienThiMatKhau.setBackground(new java.awt.Color(250, 250, 250));
        chkHienThiMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkHienThiMatKhau.setText("Hiển thị mật khẩu");
        chkHienThiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienThiMatKhauActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(51, 153, 255));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.setPreferredSize(new java.awt.Dimension(128, 35));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(128, 35));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lblDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        lblDoiMatKhau.setText("ĐỔI MẬT KHẨU");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 70x70.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(chkHienThiMatKhau)
                    .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatKhauMoi)
                    .addComponent(lblXacNhanMatKhau))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDoiMatKhau)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblDoiMatKhau))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblLogo)))
                .addGap(50, 50, 50)
                .addComponent(lblMatKhauMoi)
                .addGap(3, 3, 3)
                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblXacNhanMatKhau)
                .addGap(3, 3, 3)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(chkHienThiMatKhau)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
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

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        String accountId = MaXacNhan.maTaiKhoan;

        char[] newPasswordChars = txtMatKhauMoi.getPassword();
        String newPassword = String.valueOf(newPasswordChars);

        char[] retypePasswordChars = txtXacNhanMatKhau.getPassword();
        String retypePassword = String.valueOf(retypePasswordChars);

        if (newPassword.isEmpty() || retypePassword.isEmpty()) {
            DialogHelper.showError("Mật khẩu và mật khẩu nhập lại không được để trống");
        } else {
            if (retypePassword.equals(newPassword)) {
                try {
                    TaiKhoanCtrl.doiMatKhau(accountId, newPassword);
                    DialogHelper.showMessage("Đổi mật khẩu thành công, đăng nhập lại vào hệ thống!");
                    this.setVisible(false);
                    new DangNhap().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DoiMatKhauMoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DialogHelper.showError("Xác nhận mật khẩu không trùng với mật khẩu mới. Vui lòng nhập lại!");
            }
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void chkHienThiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienThiMatKhauActionPerformed
        if (chkHienThiMatKhau.isSelected()) {
            txtMatKhauMoi.setEchoChar((char) 0);
            txtXacNhanMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhauMoi.setEchoChar('*');
            txtXacNhanMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_chkHienThiMatKhauActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauMoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JCheckBox chkHienThiMatKhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMatKhauMoi;
    private javax.swing.JLabel lblXacNhanMatKhau;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
