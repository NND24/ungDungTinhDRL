package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import models.CoVanModel;
import models.TaiKhoanModel;
import models.KhoaModel;
import controllers.KhoaCtrl;
import controllers.TaiKhoanCtrl;
import controllers.CoVanCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSCoVan extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private List<KhoaModel> dsKhoa = new ArrayList<>();
    private List<CoVanModel> dsCoVan = new ArrayList<>();

    public DSCoVan() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) tblDSCoVan.getModel();

            dsCoVan = CoVanCtrl.timTatCaCoVan();
            hienThiDSKhoa();
            hienThiDSCoVan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSKhoa() {
        try {
            dsKhoa = KhoaCtrl.timTatCaKhoaHienThi();
            cmbKhoa.removeAllItems();
            cmbTKKhoa.removeAllItems();
            dsKhoa.forEach(khoa -> {
                cmbKhoa.addItem(khoa.getTenKhoa());
                cmbTKKhoa.addItem(khoa.getTenKhoa());
            });
            cmbKhoa.addItem("---Khoa---");
            cmbKhoa.setSelectedItem("---Khoa---");
            cmbTKKhoa.addItem("---Khoa---");
            cmbTKKhoa.setSelectedItem("---Khoa---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCoVan() {
        tableModel.setRowCount(0);
        dsCoVan.forEach(cv -> {
            String gioiTinh = "";
            if (cv.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            String trangThai = "";
            if (cv.getDaNghi() == 0) {
                trangThai = "Còn làm";
            } else {
                trangThai = "Đã nghỉ";
            }

            tableModel.addRow(new Object[]{
                cv.getMaCoVan(), cv.getHoTen(),
                gioiTinh, cv.getNgaySinh(),
                cv.getCanCuoc(), cv.getQueQuan(),
                cv.getSoDienThoai(), cv.getEmail(),
                cv.getTenKhoa(), cv.getHocVi(),
                cv.getHocHam(), cv.getChuyenMon(),
                trangThai});
        });
    }

    private void lamMoi() {
        txtMaCoVan.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        cmbGioiTinh.setSelectedIndex(0);
        txtSoDienThoai.setText("");
        txtCanCuoc.setText("");
        txtEmail.setText("");
        txtQueQuan.setText("");
        cmbKhoa.setSelectedIndex(0);
        cmbHocVi.setSelectedIndex(0);
        cmbHocHam.setSelectedIndex(0);
        txtChuyenMon.setText("");
        cmbDaNghi.setSelectedIndex(0);
        cmbKhoa.setSelectedItem("---Khoa---");
    }

    private void timKiemCoVan() {
        try {
            if (cmbTKKhoa.getSelectedItem() != null) {
                String tuKhoa = txtTimKiem.getText();
                int khoaIndex = cmbTKKhoa.getSelectedIndex();
                String maKhoa = "";

                if (cmbTKKhoa.getSelectedItem().equals("---Khoa---")) {
                    maKhoa = "";
                } else {
                    maKhoa = dsKhoa.get(khoaIndex).getMaKhoa();
                }

                if (tuKhoa.isEmpty() && maKhoa.isEmpty()) {
                    dsCoVan = CoVanCtrl.timTatCaCoVan();
                    hienThiDSCoVan();
                    return;
                }

                dsCoVan = CoVanCtrl.timKiemCoVan(tuKhoa, maKhoa);
                hienThiDSCoVan();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
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
        btnSuaThongTin = new javax.swing.JButton();
        btnXoaCoVan = new javax.swing.JButton();
        btnThemCoVan = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaCoVan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cmbKhoa = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTKKhoa = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSCoVan = new javax.swing.JTable();
        cmbHocVi = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cmbHocHam = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtChuyenMon = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cmbDaNghi = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(1140, 616));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 616));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN CỐ VẤN");

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

        btnSuaThongTin.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaThongTin.setPreferredSize(new java.awt.Dimension(125, 25));
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        btnXoaCoVan.setBackground(new java.awt.Color(0, 102, 255));
        btnXoaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaCoVan.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCoVan.setText("Xóa cố vấn");
        btnXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaCoVan.setPreferredSize(new java.awt.Dimension(98, 25));
        btnXoaCoVan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCoVanActionPerformed(evt);
            }
        });

        btnThemCoVan.setBackground(new java.awt.Color(0, 102, 255));
        btnThemCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemCoVan.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCoVan.setText("Thêm cố vấn");
        btnThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemCoVan.setPreferredSize(new java.awt.Dimension(120, 25));
        btnThemCoVan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCoVanActionPerformed(evt);
            }
        });

        btnXuatDSBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDSBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDSBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDSBenhNhan.setText("Xuất danh sách");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã cố vấn");

        txtMaCoVan.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        txtEmail.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày sinh");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Học vị");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Quê quán");

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("DANH SÁCH CỐ VẤN");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Khoa");

        cmbTKKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Khoa");

        tblDSCoVan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã cố vấn", "Họ tên", "Giới tính", "Ngày sinh", "Căn cước", "Quê quán", "Số điện thoại", "Email", "Khoa", "Học vị", "Học hàm", "Chuyên môn", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCoVanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSCoVan);

        cmbHocVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Học vị---", "Thạc sỹ", "Tiến sỹ" }));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Học hàm");

        cmbHocHam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Học hàm---", "Phó giáo sư", "Giáo sư" }));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Chuyên môn");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Trạng thái");

        cmbDaNghi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn làm", "Đã nghỉ" }));

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("(*)");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("(*)");

        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDaNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbHocVi, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(41, 41, 41)
                        .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15))
                    .addComponent(jLabel18)
                    .addComponent(jLabel23))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChuyenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmbHocHam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHocVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHocHam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChuyenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDaNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemCoVanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCoVanActionPerformed
        try {
            if (!txtMaCoVan.getText().isEmpty()) {
                DialogHelper.showError("Cố vấn đã tồn tại. Vui lòng nhập mới");
            } else if (txtHoTen.getText().isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống!");
            } else if (txtNgaySinh.getText().isEmpty()) {
                DialogHelper.showError("Ngày sinh không được để trống!");
            } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
            } else if (txtSoDienThoai.getText().isEmpty()) {
                DialogHelper.showError("Số điện thoại không được để trống!");
            } else if (CoVanCtrl.kiemTraSoDienThoaiTrung("", txtSoDienThoai.getText())) {
                DialogHelper.showError("Số điện thoại đã tồn tại!");
            } else if (!txtSoDienThoai.getText().isEmpty() && !Validator.isValidPhoneNumber(txtSoDienThoai.getText())) {
                DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
            } else if (txtCanCuoc.getText().isEmpty()) {
                DialogHelper.showError("Căn cước không được để trống!");
            } else if (!txtCanCuoc.getText().isEmpty() && !Validator.isValidCccd(txtCanCuoc.getText())) {
                DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
            } else if (CoVanCtrl.kiemTraCanCuocTrung("", txtCanCuoc.getText())) {
                DialogHelper.showError("Căn cước đã tồn tại!");
            } else if (cmbKhoa.getSelectedItem().equals("---Khoa---")) {
                DialogHelper.showError("Chưa chọn khoa!");
            } else {
                try {
                    String hoTen = txtHoTen.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String canCuoc = txtCanCuoc.getText();

                    String soLuongNguoiFormatted = String.format("%03d", (CoVanCtrl.layMaCoVanCuoiCung() + 1));
                    String maCoVan = "cv" + soLuongNguoiFormatted;
                    String maTaiKhoan = GenerateCode.generateIdTaiKhoan();
                    java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
                    java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());
                    int gioiTinh = cmbGioiTinh.getSelectedIndex();
                    String email = maCoVan.toLowerCase() + "@ptithcm.edu.vn";
                    String matKhau = maCoVan.toLowerCase() + "#" + txtNgaySinh.getText().replace("/", "");
                    String queQuan = txtQueQuan.getText();
                    String chucVu = "CV";
                    String hocVi = cmbHocVi.getSelectedItem().toString();
                    if (hocVi.equals("---Học vị---")) {
                        hocVi = "";
                    }
                    String hocHam = cmbHocHam.getSelectedItem().toString();
                    if (hocHam.equals("---Học hàm---")) {
                        hocHam = "";
                    }
                    String chuyenMon = txtChuyenMon.getText();
                    int daNghi = cmbDaNghi.getSelectedIndex();

                    int khoaIndex = cmbKhoa.getSelectedIndex();
                    String maKhoa = dsKhoa.get(khoaIndex).getMaKhoa();
                    String tenKhoa = cmbKhoa.getSelectedItem().toString();

                    TaiKhoanModel tk = new TaiKhoanModel(maTaiKhoan, maCoVan, matKhau, chucVu);
                    TaiKhoanCtrl.themTaiKhoan(tk);

                    CoVanModel cv = new CoVanModel(maCoVan, maTaiKhoan, tenKhoa, hoTen, email, soDienThoai, canCuoc, queQuan, hocVi, hocHam, chuyenMon, maKhoa, gioiTinh, sqlNgaySinh, daNghi);
                    CoVanCtrl.themCoVan(cv);
                    lamMoi();
                    timKiemCoVan();
                    DialogHelper.showMessage("Thêm cố vấn thành công");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemCoVanActionPerformed

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        try {
            if (txtMaCoVan.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn cố vấn muốn chỉnh sửa");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa thông tin cố vấn này!")) {
                if (txtHoTen.getText().isEmpty()) {
                    DialogHelper.showError("Họ tên không được để trống!");
                } else if (txtNgaySinh.getText().isEmpty()) {
                    DialogHelper.showError("Ngày sinh không được để trống!");
                } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                    DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
                } else if (txtSoDienThoai.getText().isEmpty()) {
                    DialogHelper.showError("Số điện thoại không được để trống!");
                } else if (CoVanCtrl.kiemTraSoDienThoaiTrung(txtMaCoVan.getText(), txtSoDienThoai.getText())) {
                    DialogHelper.showError("Số điện thoại đã tồn tại!");
                } else if (!txtSoDienThoai.getText().isEmpty() && !Validator.isValidPhoneNumber(txtSoDienThoai.getText())) {
                    DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
                } else if (txtCanCuoc.getText().isEmpty()) {
                    DialogHelper.showError("Căn cước không được để trống!");
                } else if (!txtCanCuoc.getText().isEmpty() && !Validator.isValidCccd(txtCanCuoc.getText())) {
                    DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
                } else if (CoVanCtrl.kiemTraCanCuocTrung(txtMaCoVan.getText(), txtCanCuoc.getText())) {
                    DialogHelper.showError("Căn cước đã tồn tại!");
                } else if (cmbKhoa.getSelectedItem().equals("---Khoa---")) {
                    DialogHelper.showError("Chưa chọn khoa!");
                } else {
                    String maCoVan = txtMaCoVan.getText();
                    String hoTen = txtHoTen.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String canCuoc = txtCanCuoc.getText();

                    java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
                    java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

                    int gioiTinh = cmbGioiTinh.getSelectedIndex();
                    String email = txtEmail.getText();
                    String queQuan = txtQueQuan.getText();
                    String hocVi = cmbHocVi.getSelectedItem().toString();
                    if (hocVi.equals("---Học vị---")) {
                        hocVi = "";
                    }
                    String hocHam = cmbHocHam.getSelectedItem().toString();
                    if (hocHam.equals("---Học hàm---")) {
                        hocHam = "";
                    }
                    String chuyenMon = txtChuyenMon.getText();
                    int daNghi = cmbDaNghi.getSelectedIndex();

                    int khoaIndex = cmbKhoa.getSelectedIndex();
                    String maKhoa = dsKhoa.get(khoaIndex).getMaKhoa();

                    CoVanModel cv = new CoVanModel(maCoVan, hoTen, email, soDienThoai, canCuoc, queQuan, hocVi, hocHam, chuyenMon, maKhoa, gioiTinh, sqlNgaySinh, daNghi);
                    CoVanCtrl.capNhatCoVan(cv);
                    lamMoi();
                    timKiemCoVan();
                    DialogHelper.showMessage("Sửa cố vấn thành công");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnXoaCoVanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCoVanActionPerformed
        try {
            if (txtMaCoVan.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn cố vấn muốn xóa");
            } else if (CoVanCtrl.kiemTraCoVanDaPhanCong(txtMaCoVan.getText())) {
                DialogHelper.showError("Cố vấn đã được phân công, không thể xóa");
            } else if (CoVanCtrl.kiemTraCoVanDaChamDiem(txtMaCoVan.getText())) {
                DialogHelper.showError("Cố vấn đã chấm điểm, không thể xóa");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa thông tin cố vấn này")) {
                    try {
                        String maCoVan = txtMaCoVan.getText();
                        CoVanCtrl.xoaCoVan(maCoVan);
                        lamMoi();
                        timKiemCoVan();
                        DialogHelper.showMessage("Xóa cố vấn thành công!");
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSCoVan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaCoVanActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        txtTimKiem.setText("");
        cmbTKKhoa.setSelectedItem("---Khoa---");
        hienThiDSCoVan();
        hienThiDSKhoa();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        CoVanCtrl.xuatFileExcel(dsCoVan, "src/main/java/files/DSCoVan.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void tblDSCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCoVanMouseClicked
        int selectedIndex = tblDSCoVan.getSelectedRow();
        if (selectedIndex >= 0) {
            CoVanModel coVan = dsCoVan.get(selectedIndex);

            txtMaCoVan.setText(coVan.getMaCoVan());
            txtHoTen.setText(coVan.getHoTen());
            txtNgaySinh.setText(dateFormat.format(coVan.getNgaySinh()));
            cmbGioiTinh.setSelectedIndex(coVan.getGioiTinh());
            txtSoDienThoai.setText(coVan.getSoDienThoai());
            txtCanCuoc.setText(coVan.getCanCuoc());
            txtEmail.setText(coVan.getEmail());
            txtQueQuan.setText(coVan.getQueQuan());
            cmbKhoa.setSelectedItem(coVan.getTenKhoa());
            String hocVi = "";
            if (coVan.getHocVi().isEmpty() || coVan.getHocVi() == null) {
                hocVi = "---Học vị---";
            } else {
                hocVi = coVan.getHocVi();
            }
            cmbHocVi.setSelectedItem(hocVi);
            String hocHam = "";
            if (coVan.getHocHam().isEmpty() || coVan.getHocHam() == null) {
                hocHam = "---Học hàm---";
            } else {
                hocHam = coVan.getHocHam();
            }
            cmbHocHam.setSelectedItem(hocHam);
            txtChuyenMon.setText(coVan.getChuyenMon());
            cmbDaNghi.setSelectedIndex(coVan.getDaNghi());
        }
    }//GEN-LAST:event_tblDSCoVanMouseClicked

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        timKiemCoVan();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void cmbTKKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKKhoaActionPerformed
        timKiemCoVan();
    }//GEN-LAST:event_cmbTKKhoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnThemCoVan;
    private javax.swing.JButton btnXoaCoVan;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JComboBox<String> cmbDaNghi;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbHocHam;
    private javax.swing.JComboBox<String> cmbHocVi;
    private javax.swing.JComboBox<String> cmbKhoa;
    private javax.swing.JComboBox<String> cmbTKKhoa;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSCoVan;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtChuyenMon;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaCoVan;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
