package views.list;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DiemRenLuyenModel;
import models.NamHocModel;
import models.SinhVienModel;
import controllers.DiemRenLuyenCtrl;
import controllers.NamHocCtrl;
import controllers.PhieuDRLCtrl;
import controllers.SinhVienCtrl;
import models.PhieuDRLModel;
import views.main.DangNhap;
import views.main.FormChamDiemSV;
import utils.DialogHelper;
import utils.Validator;

public class DSDiemRenLuyenCaNhan extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    private List<NamHocModel> dsNamHoc = new ArrayList<>();

    public DSDiemRenLuyenCaNhan() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSDiemRenLuyen.getModel();
            hienThiDSNamHoc();
            cmbTKNamHoc.setSelectedItem("---Năm học---");
            hienThiTatCaDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNamHoc() {
        try {
            dsNamHoc = NamHocCtrl.timNamHocHienThi();

            cmbTKNamHoc.removeAllItems();
            dsNamHoc.forEach(nh -> {
                cmbTKNamHoc.addItem(nh.getNamHoc());
            });
            cmbTKNamHoc.addItem("---Năm học---");
            cmbTKHocKy.setSelectedItem("---Học kỳ---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSDiem() {
        tableModel.setRowCount(0);

        dsDiemRenLuyen.forEach(drl -> {
            tableModel.addRow(new Object[]{
                drl.getMaSinhVien(), drl.getHoTen(),
                drl.getD1(), drl.getD2(), drl.getD3(),
                drl.getD4(), drl.getD5(), drl.getTongDiem(),
                drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                drl.getTrangThaiCham()});
        });
    }

    private void hienThiTatCaDRL() throws ClassNotFoundException {
        SinhVienModel sv = SinhVienCtrl.timSinhVienTheoTenDangNhap(DangNhap.username);
        if (sv != null) {
            dsDiemRenLuyen = DiemRenLuyenCtrl.timTatCaDiemCuaSV(sv.getMaSinhVien());
            if (thayDoiTrangThaiKhongTB("Hết thời gian chấm")) {
                dsDiemRenLuyen = DiemRenLuyenCtrl.timTatCaDiemCuaSV(sv.getMaSinhVien());
            }
            tableModel.setRowCount(0);

            dsDiemRenLuyen.forEach(drl -> {
                tableModel.addRow(new Object[]{
                    drl.getMaSinhVien(), drl.getHoTen(),
                    drl.getD1(), drl.getD2(), drl.getD3(),
                    drl.getD4(), drl.getD5(), drl.getTongDiem(),
                    drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                    drl.getTrangThaiCham()});
            });
        }
    }

    private void lamMoi() {
        try {
            txtMaSinhVien.setText("");
            hoTenTextField.setText("");
            btnDiemTieuChi1.setText("");
            btnDiemTieuChi2.setText("");
            btnDiemTieuChi3.setText("");
            btnDiemTieuChi4.setText("");
            btnDiemTieuChi5.setText("");
            txtTongDiem.setText("");
            txtXepLoai.setText("");
            txtHocKy.setText("");
            txtNamHoc.setText("");
            cmbTKNamHoc.setSelectedItem("---Năm học---");
            cmbTKHocKy.setSelectedItem("---Học kỳ---");
            hienThiTatCaDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void timKiemDanhSachDRL() {
        try {
            SinhVienModel sv = SinhVienCtrl.timSinhVienTheoTenDangNhap(DangNhap.username);
            if (cmbTKNamHoc.getSelectedItem() != null && sv != null) {
                String lop = sv.getMaLop();
                String tuKhoa = sv.getMaSinhVien();
                int namHocIndex = cmbTKNamHoc.getSelectedIndex();
                int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                String hocKy = cmbTKHocKy.getSelectedItem().toString();

                if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || hocKy.equals("---Học kỳ---")) {
                    dsDiemRenLuyen.clear();
                    hienThiDSDiem();
                } else {
                    dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, maNamHoc, hocKy);
                    if (thayDoiTrangThaiKhongTB("Hết thời gian chấm")) {
                        dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, maNamHoc, hocKy);
                    }
                    hienThiDSDiem();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean thayDoiTrangThaiKhongTB(String trangThaiCham) {
        boolean flag = false;
        if (!dsDiemRenLuyen.isEmpty()) {
            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                try {
                    if (!drl.getTrangThaiCham().equals("Hết thời gian chấm") && Validator.isBeforeToday(drl.getNgayKetThuc())) {
                        DiemRenLuyenModel diemRenLuyenBCS = DiemRenLuyenCtrl.timDRLDayDu(drl.getMaSinhVien(), drl.getHocKy(), drl.getNamHoc(), "CoVan");
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(drl.getMaSinhVien(), drl.getHocKy(), drl.getNamHoc());
                        if (diemRenLuyenBCS.getXepLoai() == null && diemRenLuyenBCS.getTongDiem() == 0) {
                            DiemRenLuyenModel diem = new DiemRenLuyenModel(maPhieuDRL, "CoVan", "Kém", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                            DiemRenLuyenCtrl.chamDiemRenLuyen(diem);
                        }
                        PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, trangThaiCham);
                        PhieuDRLCtrl.capNhatTrangThaiCham(phieu);
                        flag = true;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnXemDiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hoTenTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbTKHocKy = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbTKNamHoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDiemRenLuyen = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnDiemTieuChi1 = new javax.swing.JTextField();
        btnDiemTieuChi2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDiemTieuChi3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDiemTieuChi4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnDiemTieuChi5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtXepLoai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongDiem = new javax.swing.JTextField();

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
        setPreferredSize(new java.awt.Dimension(1140, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(111, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN ");

        btnXemDiem.setBackground(new java.awt.Color(0, 102, 255));
        btnXemDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXemDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDiem.setText("Xem/chấm điểm");
        btnXemDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXemDiem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDiemActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(120, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
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
                .addComponent(btnXemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnXemDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);
        txtMaSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        hoTenTextField.setEditable(false);
        hoTenTextField.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("DANH SÁCH ĐIỂM RÈN LUYỆN");

        cmbTKHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "---Học kỳ---" }));
        cmbTKHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKHocKyActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Năm học");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Học kì");

        cmbTKNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNamHocActionPerformed(evt);
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
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(8, 8, 8))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblDSDiemRenLuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm tiêu chí 1", "Điểm tiêu chí 2", "Điểm tiêu chí 3", "Điểm tiêu chí 4", "Điểm tiêu chí 5", "Tổng điểm", "Xếp loại", "Học kỳ", "Năm học", "Trạng thái chấm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDiemRenLuyen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSDiemRenLuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDiemRenLuyenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSDiemRenLuyen);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiêu chí 1");

        btnDiemTieuChi1.setEditable(false);
        btnDiemTieuChi1.setBackground(new java.awt.Color(255, 255, 255));

        btnDiemTieuChi2.setEditable(false);
        btnDiemTieuChi2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiêu chí 2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiêu chí 3");

        btnDiemTieuChi3.setEditable(false);
        btnDiemTieuChi3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiêu chí 4");

        btnDiemTieuChi4.setEditable(false);
        btnDiemTieuChi4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiêu chí 5");

        btnDiemTieuChi5.setEditable(false);
        btnDiemTieuChi5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng điểm");

        txtNamHoc.setEditable(false);
        txtNamHoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Xếp loại");

        txtXepLoai.setEditable(false);
        txtXepLoai.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Học kỳ");

        txtHocKy.setEditable(false);
        txtHocKy.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Năm học");

        txtTongDiem.setEditable(false);
        txtTongDiem.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 58, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSDiemRenLuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDiemRenLuyenMouseClicked
        int selectedIndex = tblDSDiemRenLuyen.getSelectedRow();
        if (selectedIndex >= 0) {
            DiemRenLuyenModel drl = dsDiemRenLuyen.get(selectedIndex);

            txtMaSinhVien.setText(drl.getMaSinhVien());
            hoTenTextField.setText(drl.getHoTen());
            btnDiemTieuChi1.setText(Float.toString(drl.getD1()));
            btnDiemTieuChi2.setText(Integer.toString(drl.getD2()));
            btnDiemTieuChi3.setText(Integer.toString(drl.getD3()));
            btnDiemTieuChi4.setText(Integer.toString(drl.getD4()));
            btnDiemTieuChi5.setText(Integer.toString(drl.getD5()));
            txtTongDiem.setText(Float.toString(drl.getTongDiem()));
            txtXepLoai.setText(drl.getXepLoai());
            txtHocKy.setText(drl.getHocKy());
            txtNamHoc.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_tblDSDiemRenLuyenMouseClicked

    private void btnXemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDiemActionPerformed
        String maSinhVien = txtMaSinhVien.getText();
        if (maSinhVien.isEmpty()) {
            DialogHelper.showError("Chưa chọn học kỳ, năm học muốn xem. Vui lòng chọn");
        } else {
            FormChamDiemSV.Instance.maSVTextField.setText("");

            FormChamDiemSV.Instance.maSVTextField.setText(maSinhVien);
            FormChamDiemSV.Instance.nameTextField.setText(hoTenTextField.getText());
            FormChamDiemSV.Instance.semesterTextField.setText(txtHocKy.getText());
            FormChamDiemSV.Instance.scholasticTextField.setText(txtNamHoc.getText());
        }
    }//GEN-LAST:event_btnXemDiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void cmbTKNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNamHocActionPerformed
        if (cmbTKNamHoc.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            hienThiDSDiem();
        }
    }//GEN-LAST:event_cmbTKNamHocActionPerformed

    private void cmbTKHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKHocKyActionPerformed
        if (cmbTKHocKy.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            hienThiDSDiem();
        }
    }//GEN-LAST:event_cmbTKHocKyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnDiemTieuChi1;
    private javax.swing.JTextField btnDiemTieuChi2;
    private javax.swing.JTextField btnDiemTieuChi3;
    private javax.swing.JTextField btnDiemTieuChi4;
    private javax.swing.JTextField btnDiemTieuChi5;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXemDiem;
    private javax.swing.JComboBox<String> cmbTKHocKy;
    private javax.swing.JComboBox<String> cmbTKNamHoc;
    private javax.swing.JTextField hoTenTextField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSDiemRenLuyen;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtTongDiem;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
