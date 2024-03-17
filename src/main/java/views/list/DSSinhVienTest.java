package views.list;

import models.SinhVienModelTest;
import controllers.SinhVienCtrlTest;
import controllers.TaiKhoanCtrl;
import controllers.LopCtrlTest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.LopModelTest;
import models.TaiKhoanModel;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSSinhVienTest extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    List<SinhVienModelTest> dsSinhVien = new ArrayList<>();
    List<LopModelTest> dsLop = new ArrayList<>();

    public DSSinhVienTest() {
        initComponents();
        tableModel = (DefaultTableModel) dsSinhVienTable.getModel();
        hienThiDSSinhVien();
        hienThiDSLop();
    }

    private void hienThiDSSinhVien() {
        try {
            dsSinhVien = SinhVienCtrlTest.timTatCaSinhVien();
            tableModel.setRowCount(0);

            dsSinhVien.forEach(sv -> {
                String trangThaiHoc = "";
                if (sv.getDaNghiHoc().equals("0")) {
                    trangThaiHoc = "Còn học";
                } else {
                    trangThaiHoc = "Đã nghỉ";
                }
                tableModel.addRow(new Object[]{
                    sv.getMaSinhVien(), sv.getTenLop(),
                    sv.getHoTen(), sv.getChucVu(), sv.getGioiTinh(),
                    sv.getNgaySinh(), sv.getCanCuoc(),
                    sv.getQueQuan(), sv.getSoDienThoai(),
                    sv.getEmail(), trangThaiHoc});
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLop() {
        try {
            dsLop = LopCtrlTest.timTatCaLopHienThi();
            cmbLop.removeAllItems();
            dsLop.forEach(lop -> {
                cmbLop.addItem(lop.getTenLop());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        txtMaSinhVien.setText("");
        HoTenTextField.setText("");
        txtEmail.setText("");
        queQuanTextField.setText("");
        GioiTinhComboBox.setSelectedIndex(0);
        chucVuComboBox.setSelectedIndex(0);
        ngaySinhTextField.setText("");
        canCuocTextField.setText("");
        soDienThoaiTextField.setText("");
        cmbDaNghiHoc.setSelectedIndex(0);
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
        suaThongTinSinhVienButton = new javax.swing.JButton();
        xoaSinhVienButton = new javax.swing.JButton();
        themSinhVienButton = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        HoTenTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        chucVuComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        canCuocTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        soDienThoaiTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ngaySinhTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        queQuanTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LocKhoaComboBox = new javax.swing.JComboBox<>();
        TimKiemTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsSinhVienTable = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        GioiTinhComboBox = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cmbLop = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cmbDaNghiHoc = new javax.swing.JComboBox<>();

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
        jLabel1.setText("THÔNG TIN SINH VIÊN");

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

        suaThongTinSinhVienButton.setBackground(new java.awt.Color(0, 102, 255));
        suaThongTinSinhVienButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suaThongTinSinhVienButton.setForeground(new java.awt.Color(255, 255, 255));
        suaThongTinSinhVienButton.setText("Sửa thông tin");
        suaThongTinSinhVienButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suaThongTinSinhVienButton.setPreferredSize(new java.awt.Dimension(125, 25));
        suaThongTinSinhVienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaThongTinSinhVienButtonActionPerformed(evt);
            }
        });

        xoaSinhVienButton.setBackground(new java.awt.Color(0, 102, 255));
        xoaSinhVienButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xoaSinhVienButton.setForeground(new java.awt.Color(255, 255, 255));
        xoaSinhVienButton.setText("Xóa sinh viên");
        xoaSinhVienButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xoaSinhVienButton.setPreferredSize(new java.awt.Dimension(98, 25));
        xoaSinhVienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSinhVienButtonActionPerformed(evt);
            }
        });

        themSinhVienButton.setBackground(new java.awt.Color(0, 102, 255));
        themSinhVienButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        themSinhVienButton.setForeground(new java.awt.Color(255, 255, 255));
        themSinhVienButton.setText("Thêm sinh viên");
        themSinhVienButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        themSinhVienButton.setPreferredSize(new java.awt.Dimension(120, 25));
        themSinhVienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSinhVienButtonActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(themSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(xoaSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(suaThongTinSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaThongTinSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themSinhVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        chucVuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinh viên", "Ban cán sự" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        txtEmail.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày sinh");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Quê quán");

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH SINH VIÊN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Lọc");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 696, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TimKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LocKhoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocKhoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TimKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dsSinhVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Chức vụ", "Lớp", "Giới tính", "Năm sinh", "Căn cước", "Địa chỉ", "Số điện thoại", "Email", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dsSinhVienTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsSinhVienTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsSinhVienTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsSinhVienTable);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Chức vụ");

        GioiTinhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Lớp");

        cmbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLopActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Đã nghỉ học");

        cmbDaNghiHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn học", "Đã nghỉ" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canCuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(41, 41, 41)
                        .addComponent(GioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(queQuanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDaNghiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chucVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(HoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(GioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chucVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canCuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(queQuanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDaNghiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void themSinhVienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSinhVienButtonActionPerformed
        try {
            int lopIndex = cmbLop.getSelectedIndex();
            int maLop = Integer.parseInt(dsLop.get(lopIndex).getMaLop());
            String tenLop = cmbLop.getSelectedItem().toString();
            String khoa = dsLop.get(lopIndex).getKhoa();
            String nganh = dsLop.get(lopIndex).getNganh();
            String soLuongNguoiFormatted = String.format("%03d", (SinhVienCtrlTest.timSinhVienTheoLop(tenLop).size() + 1));
            String maSinhVien = "N" + khoa.substring(2) + "DC" + nganh + soLuongNguoiFormatted;
            String maTaiKhoan = GenerateCode.generateIdTaiKhoan();
            String hoTen = HoTenTextField.getText();
            java.util.Date ngaySinh = dateFormat.parse(ngaySinhTextField.getText());
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

            String gioiTinh = Integer.toString(GioiTinhComboBox.getSelectedIndex());
            String soDienThoai = soDienThoaiTextField.getText();
            String canCuoc = canCuocTextField.getText();
            String email = maSinhVien.toLowerCase() + "@student.ptithcm.edu.vn";
            String matKhau = maSinhVien.toLowerCase() + "#" + ngaySinhTextField.getText().replace("/", "");
            String queQuan = queQuanTextField.getText();
            String chucVu = chucVuComboBox.getSelectedItem().toString();
            String maChucVu = "";
            if (chucVu.equals("Sinh viên")) {
                maChucVu = "SV";
            } else {
                maChucVu = "BCS";
            }
            String daNghiHoc = Integer.toString(cmbDaNghiHoc.getSelectedIndex());

            TaiKhoanModel tk = new TaiKhoanModel(maTaiKhoan, maSinhVien, matKhau, maChucVu);
            SinhVienModelTest sv = new SinhVienModelTest(maSinhVien, maTaiKhoan, maLop, hoTen, email, gioiTinh, sqlNgaySinh, soDienThoai, canCuoc, queQuan, daNghiHoc);

            if (!txtMaSinhVien.getText().isEmpty()) {
                DialogHelper.showError("Sinh viên đã tồn tại. Vui lòng nhập mới");
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
                    TaiKhoanCtrl.themTaiKhoan(tk);
                    SinhVienCtrlTest.themSinhVien(sv);
                    hienThiDSSinhVien();
                    lamMoi();
                    DialogHelper.showMessage("Thêm sinh viên thành công!");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themSinhVienButtonActionPerformed

    private void dsSinhVienTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsSinhVienTableMouseClicked
        int selectedIndex = dsSinhVienTable.getSelectedRow();
        if (selectedIndex >= 0) {
            SinhVienModelTest sv = dsSinhVien.get(selectedIndex);

            txtMaSinhVien.setText(sv.getMaSinhVien());
            txtEmail.setText(sv.getEmail());
            HoTenTextField.setText(sv.getHoTen());
            queQuanTextField.setText(sv.getQueQuan());
            GioiTinhComboBox.setSelectedIndex(Integer.parseInt(sv.getGioiTinh()));
            chucVuComboBox.setSelectedItem(sv.getChucVu());
            ngaySinhTextField.setText(dateFormat.format(sv.getNgaySinh()));
            canCuocTextField.setText(sv.getCanCuoc());
            soDienThoaiTextField.setText(sv.getSoDienThoai());
            cmbDaNghiHoc.setSelectedIndex(Integer.parseInt(sv.getDaNghiHoc()));
        }
    }//GEN-LAST:event_dsSinhVienTableMouseClicked

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        SinhVienCtrlTest.xuatFileExcel(dsSinhVien, "src/main/java/files/DSSinhVien.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void xoaSinhVienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSinhVienButtonActionPerformed
        try {
            String maSinhVien = txtMaSinhVien.getText();
            String maTaiKhoan = SinhVienCtrlTest.layMaTaiKhoanSV(maSinhVien);
            SinhVienCtrlTest.xoaSinhVien(maSinhVien);
            TaiKhoanCtrl.xoaTaiKhoan(maTaiKhoan);

            hienThiDSLop();
            DialogHelper.showMessage("Xóa sinh viên thành công!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xoaSinhVienButtonActionPerformed

    private void suaThongTinSinhVienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaThongTinSinhVienButtonActionPerformed
        try {
            String maSinhVien = txtMaSinhVien.getText();
            String hoTen = HoTenTextField.getText();
            java.util.Date ngaySinh = dateFormat.parse(ngaySinhTextField.getText());
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

            String gioiTinh = Integer.toString(GioiTinhComboBox.getSelectedIndex());
            String soDienThoai = soDienThoaiTextField.getText();
            String canCuoc = canCuocTextField.getText();
            String queQuan = queQuanTextField.getText();
            int lopIndex = cmbLop.getSelectedIndex();
            int maLop = Integer.parseInt(dsLop.get(lopIndex).getMaLop());
            String chucVu = chucVuComboBox.getSelectedItem().toString();
            String daNghiHoc = Integer.toString(cmbDaNghiHoc.getSelectedIndex());

            SinhVienModelTest sv = new SinhVienModelTest(maSinhVien, maLop, hoTen, chucVu, gioiTinh, soDienThoai, canCuoc, queQuan, daNghiHoc, sqlNgaySinh);
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
                try {
                    SinhVienCtrlTest.capNhatSinhVien(sv);
                    hienThiDSSinhVien();
                    DialogHelper.showMessage("Cập nhật sinh viên thành công!");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suaThongTinSinhVienButtonActionPerformed

    private void cmbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLopActionPerformed

    }//GEN-LAST:event_cmbLopActionPerformed

    private void lamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiButtonActionPerformed
        lamMoi();
        hienThiDSLop();
    }//GEN-LAST:event_lamMoiButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GioiTinhComboBox;
    private javax.swing.JTextField HoTenTextField;
    private javax.swing.JComboBox<String> LocKhoaComboBox;
    private javax.swing.JTextField TimKiemTextField;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JTextField canCuocTextField;
    private javax.swing.JComboBox<String> chucVuComboBox;
    private javax.swing.JComboBox<String> cmbDaNghiHoc;
    private javax.swing.JComboBox<String> cmbLop;
    private javax.swing.JTable dsSinhVienTable;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiButton;
    private javax.swing.JTextField ngaySinhTextField;
    private javax.swing.JTextField queQuanTextField;
    private javax.swing.JTextField soDienThoaiTextField;
    private javax.swing.JButton suaThongTinSinhVienButton;
    private javax.swing.JButton themSinhVienButton;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JButton xoaSinhVienButton;
    // End of variables declaration//GEN-END:variables
}
