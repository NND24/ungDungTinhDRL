package views.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import controllers.TaiKhoanCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.DialogHelper;

public class DangNhap extends javax.swing.JFrame {

    public static String username;

    public DangNhap() {
        initComponents();

        txtTenDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDangNhapActionPerformed(e);
            }
        });

        txtMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDangNhapActionPerformed(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        chkHienThiMatKhau = new javax.swing.JCheckBox();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblDangNhap = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập hệ thống chấm điểm rèn luyện của sinh viên HVCS");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 250));

        lblTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        lblTaiKhoan.setText("Tên đăng nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblMatKhau.setText("Mật khẩu");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnDangNhap.setBackground(new java.awt.Color(51, 153, 255));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        chkHienThiMatKhau.setBackground(new java.awt.Color(250, 250, 250));
        chkHienThiMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkHienThiMatKhau.setText("Hiển thị mật khẩu");
        chkHienThiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienThiMatKhauActionPerformed(evt);
            }
        });

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(51, 153, 255));
        lblQuenMatKhau.setText("Quên mật khẩu?");
        lblQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });

        lblDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(51, 51, 51));
        lblDangNhap.setText("ĐĂNG NHẬP");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 70x70.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkHienThiMatKhau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                .addComponent(lblQuenMatKhau))
                            .addComponent(lblTaiKhoan)
                            .addComponent(lblMatKhau)
                            .addComponent(txtTenDangNhap)
                            .addComponent(txtMatKhau)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblLogo)
                        .addGap(86, 86, 86)
                        .addComponent(lblDangNhap)))
                .addContainerGap())
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
                        .addComponent(lblDangNhap)))
                .addGap(50, 50, 50)
                .addComponent(lblTaiKhoan)
                .addGap(3, 3, 3)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblMatKhau)
                .addGap(3, 3, 3)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkHienThiMatKhau)
                    .addComponent(lblQuenMatKhau))
                .addGap(50, 50, 50)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        try {
            String tenDangNhap = txtTenDangNhap.getText().trim();

            char[] passwordChars = txtMatKhau.getPassword();
            String password = String.valueOf(passwordChars).trim();
            if (tenDangNhap.isEmpty() || password.isEmpty()) {
                DialogHelper.showError("Tên đăng nhập hoặc mật khẩu không được để trống!");
            } else if (TaiKhoanCtrl.kiemTraTaiKhoanCoTonTai(tenDangNhap) == false) {
                DialogHelper.showError("Tên đăng nhập không có trong hệ thống!");
            } else if (TaiKhoanCtrl.kiemTraTaiKhoanConSuDung(tenDangNhap) == false) {
                DialogHelper.showError("Tài khoản không tồn tại!");
            } else {
                try {
                    String chucVu = TaiKhoanCtrl.dangNhap(tenDangNhap, password);

                    if (chucVu.equalsIgnoreCase("SV")) {
                        username = tenDangNhap;
                        new SinhVien().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("BCS")) {
                        username = tenDangNhap;
                        new BanCanSu().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("CV")) {
                        username = tenDangNhap;
                        new CoVan().setVisible(true);
                        this.dispose();
                    } else if (chucVu.equalsIgnoreCase("QL")) {
                        username = tenDangNhap;
                        new QuanLy().setVisible(true);
                        this.dispose();
                    } else {
                        DialogHelper.showError("Tên đăng nhập hoặc mật khẩu bị sai!");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void chkHienThiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienThiMatKhauActionPerformed
        if (chkHienThiMatKhau.isSelected()) {
            txtMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_chkHienThiMatKhauActionPerformed

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        this.setVisible(false);
        new QuenMatKhau().setVisible(true);
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox chkHienThiMatKhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
