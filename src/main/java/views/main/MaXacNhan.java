package views.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import controllers.TaiKhoanCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.DialogHelper;

public class MaXacNhan extends javax.swing.JFrame {

    public static String maTaiKhoan;

    public MaXacNhan() {
        initComponents();

        txtMaXacNhan.addActionListener(new ActionListener() {
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
        btnXacNhan = new javax.swing.JButton();
        lblMaXacNhan = new javax.swing.JLabel();
        lblKiemTraEmail = new javax.swing.JLabel();
        txtMaXacNhan = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mã Xác Nhận");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnXacNhan.setBackground(new java.awt.Color(51, 153, 255));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lblMaXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblMaXacNhan.setForeground(new java.awt.Color(255, 0, 0));
        lblMaXacNhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaXacNhan.setText("Mã Xác Nhận");

        lblKiemTraEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblKiemTraEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKiemTraEmail.setText("Kiểm tra Email của bạn để lấy mã");

        txtMaXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.setPreferredSize(new java.awt.Dimension(90, 30));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaXacNhan)
                    .addComponent(lblKiemTraEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblMaXacNhan)
                .addGap(18, 18, 18)
                .addComponent(lblKiemTraEmail)
                .addGap(30, 30, 30)
                .addComponent(txtMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        String theCode = QuenMatKhau.verifyCode;
        String inputCode = txtMaXacNhan.getText();
        if (theCode.equalsIgnoreCase(inputCode)) {
            try {
                this.setVisible(false);
                new DangNhap().setVisible(false);
                new DoiMatKhauMoi().setVisible(true);

                String tenDangNhap = QuenMatKhau.userName;
                maTaiKhoan = TaiKhoanCtrl.layMaTaiKhoan(tenDangNhap);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MaXacNhan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Mã không hợp lệ!");
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaXacNhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblKiemTraEmail;
    private javax.swing.JLabel lblMaXacNhan;
    private javax.swing.JTextField txtMaXacNhan;
    // End of variables declaration//GEN-END:variables
}
