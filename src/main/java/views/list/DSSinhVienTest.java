package views.list;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.KhoaTestModel;
import models.LopModelTest;
import models.TaiKhoanModel;
import models.SinhVienTestModel;
import controllers.KhoaCtrlTest;
import controllers.SinhVienTestCtrl;
import controllers.TaiKhoanCtrl;
import controllers.LopTestCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSSinhVienTest extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private List<SinhVienTestModel> dsSinhVien = new ArrayList<>();
    private List<LopModelTest> dsLop = new ArrayList<>();
    private List<KhoaTestModel> dsKhoa = new ArrayList<>();

    public DSSinhVienTest() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) tblDSSinhVien.getModel();
            hienThiDSKhoa();
            dsSinhVien = SinhVienTestCtrl.timTatCaSinhVien();
            hienThiDSSinhVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSSinhVien() {
        tableModel.setRowCount(0);
        dsSinhVien.forEach(sv -> {
            String trangThaiHoc = "";
            if (sv.getDaNghiHoc().equals("0")) {
                trangThaiHoc = "Còn học";
            } else {
                trangThaiHoc = "Đã nghỉ";
            }
            String gioiTinh = "";
            if (sv.getGioiTinh().equals("0")) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            tableModel.addRow(new Object[]{
                sv.getMaSinhVien(), sv.getMaLop(),
                sv.getHoTen(), sv.getChucVu(), gioiTinh,
                sv.getNgaySinh(), sv.getCanCuoc(),
                sv.getQueQuan(), sv.getSoDienThoai(),
                sv.getEmail(), trangThaiHoc});
        });
    }

    private void hienThiDSLop(String maKhoa) {
        try {
            dsLop = LopTestCtrl.timLopTheoKhoa(maKhoa);
            cmbTKLop.removeAllItems();
            cmbTKLop.addItem("---Lớp---");
            dsLop.forEach(lop -> {
                cmbTKLop.addItem(lop.getMaLop());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSKhoa() {
        try {
            dsKhoa = KhoaCtrlTest.timTatCaKhoaHienThi();
            cmbTKKhoa.removeAllItems();
            dsKhoa.forEach(khoa -> {
                cmbTKKhoa.addItem(khoa.getMaKhoa());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        try {
            dsSinhVien = SinhVienTestCtrl.timTatCaSinhVien();
            txtMaSinhVien.setText("");
            txtHoTen.setText("");
            txtEmail.setText("");
            txtQueQuan.setText("");
            cmbGioiTinh.setSelectedIndex(0);
            cmbChucVu.setSelectedIndex(0);
            txtNgaySinh.setText("");
            txtCanCuoc.setText("");
            txtSoDienThoai.setText("");
            cmbDaNghiHoc.setSelectedIndex(0);
            txtTimKiem.setText("");
            cmbTKLop.setSelectedIndex(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void timKiemDanhSachDRL() {
        try {
            if (cmbTKLop.getSelectedItem() != null) {
                String tuKhoa = txtTimKiem.getText();
                String lop = cmbTKLop.getSelectedItem().toString();

                if (lop.equals("---Lớp---")) {
                    lop = "";
                }

                if (tuKhoa.isEmpty() && lop.isEmpty()) {
                    dsSinhVien = SinhVienTestCtrl.timTatCaSinhVien();
                    hienThiDSSinhVien();
                    return;
                }

                dsSinhVien = SinhVienTestCtrl.timKiemSinhVien(tuKhoa, lop);
                hienThiDSSinhVien();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbChucVu = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTKKhoa = new javax.swing.JComboBox<>();
        cmbTKLop = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSinhVien = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        cmbGioiTinh = new javax.swing.JComboBox<>();
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

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa thông tin");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(125, 25));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa sinh viên");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(98, 25));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm sinh viên");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        cmbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinh viên", "Ban cán sự" }));

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

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Lớp");

        cmbTKKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKKhoaActionPerformed(evt);
            }
        });

        cmbTKLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKLopActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khoa");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblDSSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDSSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSSinhVien);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Chức vụ");

        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Lớp");

        cmbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLopActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Trạng thái");

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
                        .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(41, 41, 41)
                        .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDaNghiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int lopIndex = cmbLop.getSelectedIndex();
            String maLop = cmbLop.getSelectedItem().toString();
            String khoa = dsLop.get(lopIndex).getKhoa();
            String nganh = dsLop.get(lopIndex).getMaNganh();
            String soLuongNguoiFormatted = String.format("%03d", (SinhVienTestCtrl.layMaSinhVienCuoiCuaLop(maLop) + 1));
            String maSinhVien = "N" + khoa.substring(2) + "DC" + nganh + soLuongNguoiFormatted;
            String maTaiKhoan = GenerateCode.generateIdTaiKhoan();
            String hoTen = txtHoTen.getText();
            java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

            String gioiTinh = Integer.toString(cmbGioiTinh.getSelectedIndex());
            String soDienThoai = txtSoDienThoai.getText();
            String canCuoc = txtCanCuoc.getText();
            String email = maSinhVien.toLowerCase() + "@student.ptithcm.edu.vn";
            String matKhau = maSinhVien.toLowerCase() + "#" + txtNgaySinh.getText().replace("/", "");
            String queQuan = txtQueQuan.getText();
            String chucVu = cmbChucVu.getSelectedItem().toString();
            String maChucVu = "";
            if (chucVu.equals("Sinh viên")) {
                maChucVu = "SV";
            } else {
                maChucVu = "BCS";
            }
            String daNghiHoc = Integer.toString(cmbDaNghiHoc.getSelectedIndex());

            TaiKhoanModel tk = new TaiKhoanModel(maTaiKhoan, maSinhVien, matKhau, maChucVu);
            SinhVienTestModel sv = new SinhVienTestModel(maSinhVien, maTaiKhoan, maLop, hoTen, email, gioiTinh, sqlNgaySinh, soDienThoai, canCuoc, queQuan, daNghiHoc);

            if (!txtMaSinhVien.getText().isEmpty()) {
                DialogHelper.showError("Sinh viên đã tồn tại. Vui lòng nhập mới");
            } else if (hoTen.isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống!");
            } else if (txtNgaySinh.getText().isEmpty()) {
                DialogHelper.showError("Ngày sinh không được để trống!");
            } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
            } else if (soDienThoai.isEmpty()) {
                DialogHelper.showError("Số điện không được để trống!");
            } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
            } else if (SinhVienTestCtrl.kiemTraSoDienThoaiTrung("", soDienThoai)) {
                DialogHelper.showError("Số điện thoại đã tồn tại!");
            } else if (canCuoc.isEmpty()) {
                DialogHelper.showError("Căn cước không được để trống!");
            } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
            } else if (SinhVienTestCtrl.kiemTraCanCuocTrung("", canCuoc)) {
                DialogHelper.showError("Căn cước đã tồn tại!");
            } else {
                try {
                    TaiKhoanCtrl.themTaiKhoan(tk);
                    SinhVienTestCtrl.themSinhVien(sv);
                    lamMoi();
                    hienThiDSSinhVien();
                    DialogHelper.showMessage("Thêm sinh viên thành công!");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblDSSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSinhVienMouseClicked
        int selectedIndex = tblDSSinhVien.getSelectedRow();
        if (selectedIndex >= 0) {
            SinhVienTestModel sv = dsSinhVien.get(selectedIndex);

            txtMaSinhVien.setText(sv.getMaSinhVien());
            txtEmail.setText(sv.getEmail());
            txtHoTen.setText(sv.getHoTen());
            txtQueQuan.setText(sv.getQueQuan());
            cmbGioiTinh.setSelectedIndex(Integer.parseInt(sv.getGioiTinh()));
            cmbChucVu.setSelectedItem(sv.getChucVu());
            txtNgaySinh.setText(dateFormat.format(sv.getNgaySinh()));
            txtCanCuoc.setText(sv.getCanCuoc());
            txtSoDienThoai.setText(sv.getSoDienThoai());
            cmbDaNghiHoc.setSelectedIndex(Integer.parseInt(sv.getDaNghiHoc()));
        }
    }//GEN-LAST:event_tblDSSinhVienMouseClicked

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        SinhVienTestCtrl.xuatFileExcel(dsSinhVien, "src/main/java/files/DSSinhVien.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maSinhVien = txtMaSinhVien.getText();
            if (SinhVienTestCtrl.kiemTraSinhVienDaChamDiem(maSinhVien)) {
                DialogHelper.showError("Sinh viên đã chấm điểm. Không thể xóa");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa sinh viên này?")) {
                    String maTaiKhoan = SinhVienTestCtrl.layMaTaiKhoanSV(maSinhVien);
                    SinhVienTestCtrl.xoaSinhVien(maSinhVien);
                    TaiKhoanCtrl.xoaTaiKhoan(maTaiKhoan);
                    DialogHelper.showMessage("Xóa sinh viên thành công!");
                    lamMoi();
                    hienThiDSSinhVien();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (DialogHelper.showConfirmation("Bạn có chắc muốn chỉnh sửa thông tin cho sinh viên này?")) {
                String maSinhVien = txtMaSinhVien.getText();
                String hoTen = txtHoTen.getText();
                java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
                java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

                String gioiTinh = Integer.toString(cmbGioiTinh.getSelectedIndex());
                String soDienThoai = txtSoDienThoai.getText();
                String canCuoc = txtCanCuoc.getText();
                String queQuan = txtQueQuan.getText();
                int lopIndex = cmbLop.getSelectedIndex();
                String maLop = cmbLop.getSelectedItem().toString();
                String chucVu = cmbChucVu.getSelectedItem().toString();
                String daNghiHoc = Integer.toString(cmbDaNghiHoc.getSelectedIndex());

                SinhVienTestModel sv = new SinhVienTestModel(maSinhVien, maLop, hoTen, chucVu, gioiTinh, soDienThoai, canCuoc, queQuan, daNghiHoc, sqlNgaySinh);
                if (hoTen.isEmpty()) {
                    DialogHelper.showError("Họ tên không được để trống!");
                } else if (txtNgaySinh.getText().isEmpty()) {
                    DialogHelper.showError("Ngày sinh không được để trống!");
                } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                    DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
                } else if (soDienThoai.isEmpty()) {
                    DialogHelper.showError("Số điện không được để trống!");
                } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                    DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
                } else if (SinhVienTestCtrl.kiemTraSoDienThoaiTrung(maSinhVien, soDienThoai)) {
                    DialogHelper.showError("Số điện thoại đã tồn tại!");
                } else if (canCuoc.isEmpty()) {
                    DialogHelper.showError("Căn cước không được để trống!");
                } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                    DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
                } else if (SinhVienTestCtrl.kiemTraCanCuocTrung(maSinhVien, canCuoc)) {
                    DialogHelper.showError("Căn cước đã tồn tại!");
                } else {
                    try {
                        SinhVienTestCtrl.capNhatSinhVien(sv);
                        hienThiDSSinhVien();
                        DialogHelper.showMessage("Cập nhật sinh viên thành công!");
                        lamMoi();
                        hienThiDSSinhVien();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSSinhVienTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cmbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLopActionPerformed

    }//GEN-LAST:event_cmbLopActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        hienThiDSSinhVien();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cmbTKKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKKhoaActionPerformed
        int khoaIndex = cmbTKKhoa.getSelectedIndex();
        String maKhoa = dsKhoa.get(khoaIndex).getMaKhoa();
        hienThiDSLop(maKhoa);
    }//GEN-LAST:event_cmbTKKhoaActionPerformed

    private void cmbTKLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKLopActionPerformed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_cmbTKLopActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JComboBox<String> cmbChucVu;
    private javax.swing.JComboBox<String> cmbDaNghiHoc;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbLop;
    private javax.swing.JComboBox<String> cmbTKKhoa;
    private javax.swing.JComboBox<String> cmbTKLop;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSSinhVien;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
