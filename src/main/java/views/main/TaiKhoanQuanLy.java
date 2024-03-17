package views.main;

import models.QuanLyModel;
import models.TaiKhoanModel;
import controllers.QuanLyCtrl;
import controllers.TaiKhoanCtrl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class TaiKhoanQuanLy extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<QuanLyModel> dsQuanLy = new ArrayList<>();

    public TaiKhoanQuanLy() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) dsQuanLyTable.getModel();
            hienThiDSQuanLy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void lamMoi() {
        txtMaQuanLy.setText("");
        hoTenTextField.setText("");
        emailTextField.setText("");
        queQuanTextField.setText("");
        GioiTinhComboBox.setSelectedIndex(0);
        ngaySinhTextField.setText("");
        canCuocTextField.setText("");
        soDienThoaiTextField.setText("");
    }

    private void hienThiDSQuanLy() throws ClassNotFoundException {
        dsQuanLy = QuanLyCtrl.timTatCaQuanLy();
        tableModel.setRowCount(0);

        dsQuanLy.forEach(ql -> {
            tableModel.addRow(new Object[]{
                ql.getMaQuanLy(), ql.getHoTen(),
                ql.getEmail(), ql.getGioiTinh(), ql.getSoDienThoai(),
                ql.getNgaySinh(), ql.getCanCuoc(), ql.getQueQuan(),});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lamMoiButton = new javax.swing.JButton();
        suaButton = new javax.swing.JButton();
        xoaButton = new javax.swing.JButton();
        themButton = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaQuanLy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hoTenTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        canCuocTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        soDienThoaiTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ngaySinhTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        queQuanTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnDoiMatKhau = new javax.swing.JButton();
        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        retypePasswordField = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnDoiTenDangNhap = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();

        jFrame1.setBackground(new java.awt.Color(51, 255, 51));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN QUẢN LÝ");

        lamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        lamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        lamMoiButton.setText("Làm mới");
        lamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lamMoiButton.setPreferredSize(new java.awt.Dimension(100, 25));
        lamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiButtonActionPerformed(evt);
            }
        });

        suaButton.setBackground(new java.awt.Color(0, 102, 255));
        suaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suaButton.setForeground(new java.awt.Color(255, 255, 255));
        suaButton.setText("Sửa thông tin");
        suaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suaButton.setPreferredSize(new java.awt.Dimension(125, 25));
        suaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaButtonActionPerformed(evt);
            }
        });

        xoaButton.setBackground(new java.awt.Color(0, 102, 255));
        xoaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xoaButton.setForeground(new java.awt.Color(255, 255, 255));
        xoaButton.setText("Xóa quản lý");
        xoaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xoaButton.setPreferredSize(new java.awt.Dimension(98, 25));
        xoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaButtonActionPerformed(evt);
            }
        });

        themButton.setBackground(new java.awt.Color(0, 102, 255));
        themButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        themButton.setForeground(new java.awt.Color(255, 255, 255));
        themButton.setText("Thêm quản lý");
        themButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        themButton.setPreferredSize(new java.awt.Dimension(120, 25));
        themButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themButtonActionPerformed(evt);
            }
        });

        btnXuatDSBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDSBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDSBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDSBenhNhan.setText("Xuất danh sách");
        btnXuatDSBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDSBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDSBenhNhan.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXuatDSBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSBenhNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(themButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(suaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã quản lý");

        txtMaQuanLy.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        hoTenTextField.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        emailTextField.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày sinh");

        ngaySinhTextField.setEditable(false);
        ngaySinhTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ngaySinhTextFieldFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Quê quán");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("ĐỔI MẬT KHẨU");

        btnDoiMatKhau.setBackground(new java.awt.Color(0, 102, 255));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDoiMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiMatKhau.setPreferredSize(new java.awt.Dimension(110, 25));
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mật khẩu cũ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mật khẩu mới");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhập lại mật khẩu");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel9.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("ĐỔI TÊN ĐĂNG NHẬP");

        btnDoiTenDangNhap.setBackground(new java.awt.Color(0, 102, 255));
        btnDoiTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiTenDangNhap.setText("Đổi tên đăng nhập");
        btnDoiTenDangNhap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDoiTenDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiTenDangNhap.setPreferredSize(new java.awt.Dimension(110, 25));
        btnDoiTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTenDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(btnDoiTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnDoiTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tên đăng nhập mới");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mật khẩu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(txtTenDangNhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(210, 210, 210))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(retypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtGioiTinh.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queQuanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(36, 36, 36)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(canCuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canCuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queQuanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
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
    }// </editor-fold>//GEN-END:initComponents

    private void themButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themButtonActionPerformed
        try {
            String soLuongNguoiFormatted = String.format("%03d", (QuanLyCtrl.timTatCaQuanLy().size() + 1));
            String maQuanLy = "admin" + GenerateCode.generateIdTaiKhoan();
            String idTaiKhoan = GenerateCode.generateIdTaiKhoan();
            String hoTen = hoTenTextField.getText();
            java.util.Date ngaySinh = sdf.parse(ngaySinhTextField.getText());
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

            String gioiTinh = GioiTinhComboBox.getSelectedItem().toString();
            String soDienThoai = soDienThoaiTextField.getText();
            String canCuoc = canCuocTextField.getText();
            String email = maQuanLy.toLowerCase() + "@ptithcm.edu.vn";
            String matKhau = maQuanLy.toLowerCase() + "#" + ngaySinhTextField.getText().replace("/", "");
            String queQuan = queQuanTextField.getText();
            String chucVu = "QL";

            if (!txtMaQuanLy.getText().isEmpty()) {
                DialogHelper.showError("Quản lý đã tồn tại. Vui lòng nhập mới");
            } else if (hoTen.isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống!");
            } else if (ngaySinhTextField.getText().isEmpty()) {
                DialogHelper.showError("Ngày sinh không được để trống!");
            } else if (!Validator.isValidDate(ngaySinhTextField.getText())) {
                DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
            } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
            } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
            } else {
                try {
                    TaiKhoanModel tk = new TaiKhoanModel(idTaiKhoan, maQuanLy, matKhau, chucVu);
                    TaiKhoanCtrl.themTaiKhoan(tk);

                    QuanLyModel sv = new QuanLyModel(maQuanLy, idTaiKhoan, hoTen, email, gioiTinh, soDienThoai, canCuoc, queQuan, sqlNgaySinh);
                    QuanLyCtrl.themQuanLy(sv);
                    lamMoi();
                    hienThiDSQuanLy();
                    DialogHelper.showMessage("Thêm quản lý thành công");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themButtonActionPerformed

    private void xoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaButtonActionPerformed
        try {
            boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn xóa quản lý này");

            if (flag) {
                String maQuanLy = txtMaQuanLy.getText();
                QuanLyCtrl.xoaQuanLy(maQuanLy);
                TaiKhoanCtrl.xoaTaiKhoan(maQuanLy);
                lamMoi();
                hienThiDSQuanLy();
                DialogHelper.showMessage("Xóa quản lý thành công");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xoaButtonActionPerformed

    private void suaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaButtonActionPerformed
        try {
            String maQuanLy = txtMaQuanLy.getText();
            String hoTen = hoTenTextField.getText();
            String email = emailTextField.getText();
            java.util.Date ngaySinh = sdf.parse(ngaySinhTextField.getText());
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());
            String gioiTinh = GioiTinhComboBox.getSelectedItem().toString();
            String soDienThoai = soDienThoaiTextField.getText();
            String canCuoc = canCuocTextField.getText();
            String queQuan = queQuanTextField.getText();

            if (hoTen.isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống!");
            } else if (ngaySinhTextField.getText().isEmpty()) {
                DialogHelper.showError("Ngày sinh không được để trống!");
            } else if (!Validator.isValidDate(ngaySinhTextField.getText())) {
                DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
            } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
            } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
            } else {
                boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn sửa quản lý này");

                if (flag) {
                    QuanLyModel ql = new QuanLyModel(maQuanLy, hoTen, email, gioiTinh, soDienThoai, canCuoc, queQuan, sqlNgaySinh);
                    QuanLyCtrl.capNhatQuanLy(ql);
                    lamMoi();
                    hienThiDSQuanLy();
                    DialogHelper.showMessage("Sửa quản lý thành công");
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suaButtonActionPerformed

    private void lamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiButtonActionPerformed
        try {
            lamMoi();
            hienThiDSQuanLy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lamMoiButtonActionPerformed

    private void ngaySinhTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ngaySinhTextFieldFocusLost
        if (!Validator.isValidDate(ngaySinhTextField.getText())) {
            DialogHelper.showError("Ngày sinh không hợp lệ. Vui lòng nhập lại!");
            ngaySinhTextField.requestFocus();
        }
    }//GEN-LAST:event_ngaySinhTextFieldFocusLost

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        QuanLyCtrl.xuatFileExcel(dsQuanLy, "src/main/java/files/DSQuanLy.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        char[] oldPasswordChars = oldPasswordField.getPassword();
        String oldPassword = String.valueOf(oldPasswordChars);
        char[] newPasswordChars = newPasswordField.getPassword();
        String newPassword = String.valueOf(newPasswordChars);
        char[] retypePasswordChars = retypePasswordField.getPassword();
        String retypePassword = String.valueOf(retypePasswordChars);
        String maSinhVien = txtMaSinhVien.getText();
        if (newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (retypePassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (oldPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (!newPassword.equals(retypePassword)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không giống nhập lại mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (TaiKhoanCtrl.kiemTraMatKhauCuSV(maSinhVien, oldPassword)) {
                    TaiKhoanCtrl.doiMatKhau(maTaiKhoan, newPassword);
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                    oldPasswordField.setText("");
                    newPasswordField.setText("");
                    retypePasswordField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDoiTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTenDangNhapActionPerformed
        String maSinhVien = txtMaSinhVien.getText();
        String tenDangNhapMoi = txtTenDangNhap.getText();
        char[] matKhauChars = txtMatKhau.getPassword();
        String matKhau = String.valueOf(matKhauChars);
        if (matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (maSinhVien.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (tenDangNhapMoi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

            System.out.println(maSinhVien + " " + matKhau + " " + tenDangNhap + " " + maTaiKhoan);
            try {
                if (TaiKhoanCtrl.kiemTraMatKhauCuSV(maSinhVien, matKhau)) {
                    SinhVienCtrlTest.doiTenDangNhapSV(tenDangNhap, maTaiKhoan);
                    DialogHelper.showMessage("Đổi tên đăng nhập thành công");
                    txtTenDangNhap.setText("");
                    txtMatKhau.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Mật khẩu không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnDoiTenDangNhapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnDoiTenDangNhap;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JTextField canCuocTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField hoTenTextField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton lamMoiButton;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField ngaySinhTextField;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JTextField queQuanTextField;
    private javax.swing.JPasswordField retypePasswordField;
    private javax.swing.JTextField soDienThoaiTextField;
    private javax.swing.JButton suaButton;
    private javax.swing.JButton themButton;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtMaQuanLy;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JButton xoaButton;
    // End of variables declaration//GEN-END:variables
}
