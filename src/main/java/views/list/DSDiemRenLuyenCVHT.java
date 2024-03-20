package views.list;

import controllers.DiemRenLuyenCtrl;
import controllers.PhanCongCtrl;
import controllers.SinhVienTestCtrl;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DiemRenLuyenModel;
import models.SinhVienTestModel;
import utils.DialogHelper;
import utils.Validator;
import views.main.DangNhap;
import views.main.FormChamDiemCVHT;

public class DSDiemRenLuyenCVHT extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    String coVanCham = "";
    Date ngayHienTai = new Date();
    LocalDate localDate = ngayHienTai.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate ngayTruoc = localDate.plusDays(1);
    Date ngayKetThuc = java.sql.Date.valueOf(ngayTruoc);

    public DSDiemRenLuyenCVHT() {
        initComponents();
        tableModel = (DefaultTableModel) dsDiemRenLuyenTable.getModel();
        hienThiDSLop();
    }

    private void hienThiDSLop() {
        try {
            List<String> dsLop = PhanCongCtrl.timDSLop(DangNhap.username);

            cmbTKLop.removeAllItems();
            cmbTKLop.addItem("---Lớp---");
            dsLop.forEach(lop -> {
                cmbTKLop.addItem(lop);
            });
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

    private void hienThiDRLHienTai() throws ClassNotFoundException {
        SinhVienTestModel sv = SinhVienTestCtrl.timSinhVienTheoTenDangNhap(DangNhap.username);
        if (sv != null) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            String hocKy = currentMonth >= 9 && currentMonth <= 1 ? "1" : "2";

            String namHoc = (currentMonth >= 9 || currentMonth == 1)
                    ? ((currentMonth == 1) ? (currentYear - 1) + "-" + currentYear : currentYear + "-" + (currentYear + 1))
                    : (currentYear - 1) + "-" + currentYear;

            cmbTKNamHoc.setSelectedItem(namHoc);
            cmbTKHocKy.setSelectedItem(hocKy);

            dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", sv.getMaLop(), hocKy, namHoc);
            tableModel.setRowCount(0);

            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                tableModel.addRow(new Object[]{
                    drl.getMaSinhVien(), drl.getHoTen(),
                    drl.getD1(), drl.getD2(), drl.getD3(),
                    drl.getD4(), drl.getD5(), drl.getTongDiem(),
                    drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                    drl.getTrangThaiCham()
                });

                if (drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn đã chấm")
                        || drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn kết thúc chấm")
                        || drl.getTrangThaiCham().equalsIgnoreCase("Ban cán sự kết thúc chấm")) {
                    coVanCham = drl.getTrangThaiCham();
                    ngayKetThuc = drl.getNgayKetThuc();
                    break;
                }
            }
        }
    }

    void lamMoi() {
        maSinhVienTextField.setText("");
        hoTenTextField.setText("");
        diemTieuChi1TextField.setText("");
        diemTieuChi2TextField.setText("");
        diemTieuChi3TextField.setText("");
        diemTieuChi4TextField.setText("");
        diemTieuChi5TextField.setText("");
        tongDiemTextField.setText("");
        xepLoaiTextField.setText("");
        hocKyTextField.setText("");
        namHocTextField.setText("");
    }

    private void timKiemDanhSachDRL() {
        try {
            if (cmbTKLop.getSelectedItem() != null) {
                String tuKhoa = txtTimKiem.getText();
                String lop = cmbTKLop.getSelectedItem().toString();
                String namHoc = cmbTKNamHoc.getSelectedItem().toString();
                String hocKy = cmbTKHocKy.getSelectedItem().toString();

                if (lop.equals("---Lớp---") || namHoc.equals("---Năm học---") || hocKy.equals("---Học kỳ---")) {
                    dsDiemRenLuyen.clear();
                    hienThiDSDiem();
                } else {
                    dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, namHoc, hocKy);
                    hienThiDSDiem();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void thayDoiTrangThaiCham(String trangThaiCham, String loaiThayDoi) {
        if (dsDiemRenLuyen.isEmpty()) {
            DialogHelper.showError("Chưa chọn năm học, học kỳ muốn thao tác");
        } else {
            String hocKy = "";
            String namHoc = "";
            for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
                try {
                    if (coVanCham.equalsIgnoreCase("Hết thời gian chấm điểm")
                            || Validator.isBeforeToday(ngayKetThuc)) {
                        DialogHelper.showError("Hết thời gian chấm điểm. Vui lòng liên hệ với cố vấn học tập!");
                    } else {
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(sv.getMaSinhVien(), sv.getHocKy(), sv.getNamHoc());
                        DiemRenLuyenCtrl.thayDoiTrangThaiCham(trangThaiCham, maPhieuDRL);
                        hocKy = sv.getHocKy();
                        namHoc = sv.getNamHoc();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!coVanCham.equalsIgnoreCase("Hết thời gian chấm điểm")
                    || !Validator.isBeforeToday(ngayKetThuc)) {
                String message = loaiThayDoi + " chấm điểm rèn luyện học kỳ: " + hocKy + ", năm học: " + namHoc;
                DialogHelper.showMessage(message);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        xemDiemButton = new javax.swing.JButton();
        lamMoiButton = new javax.swing.JButton();
        chamLaiButton = new javax.swing.JButton();
        ketThucChamButton = new javax.swing.JButton();
        duyetTatCaButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        maSinhVienTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hoTenTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsDiemRenLuyenTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        diemTieuChi1TextField = new javax.swing.JTextField();
        diemTieuChi2TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        diemTieuChi3TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        diemTieuChi4TextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        diemTieuChi5TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        namHocTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        xepLoaiTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        hocKyTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tongDiemTextField = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        cmbTKHocKy = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cmbTKLop = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmbTKNamHoc = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN ");

        xemDiemButton.setBackground(new java.awt.Color(0, 102, 255));
        xemDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xemDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        xemDiemButton.setText("Xem/chấm điểm");
        xemDiemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xemDiemButton.setPreferredSize(new java.awt.Dimension(120, 25));
        xemDiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemDiemButtonActionPerformed(evt);
            }
        });

        lamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        lamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        lamMoiButton.setText("Làm mới");
        lamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lamMoiButton.setPreferredSize(new java.awt.Dimension(120, 25));
        lamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiButtonActionPerformed(evt);
            }
        });

        chamLaiButton.setBackground(new java.awt.Color(0, 102, 255));
        chamLaiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chamLaiButton.setForeground(new java.awt.Color(255, 255, 255));
        chamLaiButton.setText("Chấm lại");
        chamLaiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chamLaiButton.setPreferredSize(new java.awt.Dimension(120, 25));
        chamLaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamLaiButtonActionPerformed(evt);
            }
        });

        ketThucChamButton.setBackground(new java.awt.Color(0, 102, 255));
        ketThucChamButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ketThucChamButton.setForeground(new java.awt.Color(255, 255, 255));
        ketThucChamButton.setText("Kết thúc chấm");
        ketThucChamButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ketThucChamButton.setPreferredSize(new java.awt.Dimension(120, 25));
        ketThucChamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketThucChamButtonActionPerformed(evt);
            }
        });

        duyetTatCaButton.setBackground(new java.awt.Color(0, 102, 255));
        duyetTatCaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        duyetTatCaButton.setForeground(new java.awt.Color(255, 255, 255));
        duyetTatCaButton.setText("Duyệt tất cả");
        duyetTatCaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        duyetTatCaButton.setPreferredSize(new java.awt.Dimension(120, 25));
        duyetTatCaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duyetTatCaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                .addComponent(xemDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ketThucChamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(chamLaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(duyetTatCaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(xemDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chamLaiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ketThucChamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(duyetTatCaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        maSinhVienTextField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        dsDiemRenLuyenTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dsDiemRenLuyenTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsDiemRenLuyenTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsDiemRenLuyenTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsDiemRenLuyenTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiêu chí 1");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiêu chí 2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiêu chí 3");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiêu chí 4");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiêu chí 5");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng điểm");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Xếp loại");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Học kỳ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Năm học");

        jPanel11.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("DANH SÁCH ĐIỂM RÈN LUYỆN CỦA LỚP");

        cmbTKHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Học kỳ---", "1", "2" }));
        cmbTKHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKHocKyActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Tìm kiếm");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Năm học");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Học kỳ");

        cmbTKLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Lớp---", "D21CQCN01-N", "D21CQCN02-N" }));
        cmbTKLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKLopActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Lớp");

        cmbTKNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Năm học---", "2022-2023", "2023-2024" }));
        cmbTKNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNamHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel28)
                .addGap(6, 6, 6)
                .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(4, 4, 4)
                .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tongDiemTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namHocTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xepLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(diemTieuChi2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(diemTieuChi3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(diemTieuChi5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tongDiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xepLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(namHocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dsDiemRenLuyenTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsDiemRenLuyenTableMouseClicked
        int selectedIndex = dsDiemRenLuyenTable.getSelectedRow();
        if (selectedIndex >= 0) {
            DiemRenLuyenModel drl = dsDiemRenLuyen.get(selectedIndex);

            maSinhVienTextField.setText(drl.getMaSinhVien());
            hoTenTextField.setText(drl.getHoTen());
            diemTieuChi1TextField.setText(Float.toString(drl.getD1()));
            diemTieuChi2TextField.setText(Integer.toString(drl.getD2()));
            diemTieuChi3TextField.setText(Integer.toString(drl.getD3()));
            diemTieuChi4TextField.setText(Integer.toString(drl.getD4()));
            diemTieuChi5TextField.setText(Integer.toString(drl.getD5()));
            tongDiemTextField.setText(Float.toString(drl.getTongDiem()));
            xepLoaiTextField.setText(drl.getXepLoai());
            hocKyTextField.setText(drl.getHocKy());
            namHocTextField.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_dsDiemRenLuyenTableMouseClicked

    private void xemDiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemDiemButtonActionPerformed
        String maSinhVien = maSinhVienTextField.getText();
        if (maSinhVien.isEmpty()) {
            DialogHelper.showError("Chưa chọn học kỳ, năm học muốn xem. Vui lòng chọn");
        } else {
            FormChamDiemCVHT.Instance.maSVTextField.setText("");

            FormChamDiemCVHT.Instance.maSVTextField.setText(maSinhVienTextField.getText());
            FormChamDiemCVHT.Instance.nameTextField.setText(hoTenTextField.getText());
            FormChamDiemCVHT.Instance.semesterTextField.setText(hocKyTextField.getText());
            FormChamDiemCVHT.Instance.scholasticTextField.setText(namHocTextField.getText());
        }
    }//GEN-LAST:event_xemDiemButtonActionPerformed

    private void lamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiButtonActionPerformed
        lamMoi();
    }//GEN-LAST:event_lamMoiButtonActionPerformed

    private void chamLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamLaiButtonActionPerformed
        thayDoiTrangThaiCham("Ban cán sự đã chấm", "Chấm lại");
        hienThiDSDiem();
    }//GEN-LAST:event_chamLaiButtonActionPerformed

    private void ketThucChamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketThucChamButtonActionPerformed
        thayDoiTrangThaiCham("Ban cán sự kết thúc chấm", "Kết thúc");
        hienThiDSDiem();
    }//GEN-LAST:event_ketThucChamButtonActionPerformed

    private void duyetTatCaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duyetTatCaButtonActionPerformed
        String hocKy = cmbTKHocKy.getSelectedItem().toString();
        String namHoc = cmbTKNamHoc.getSelectedItem().toString();
        String lop = cmbTKLop.getSelectedItem().toString();

        if (lop.equals("---Lớp---") || namHoc.equals("---Năm học---") || hocKy.equals("---Học kỳ---")) {
            DialogHelper.showError("Chưa chọn lớp học, năm học, năm học!");
            return;
        }
        if (DialogHelper.showConfirmation("Thao tác này sẽ duyệt điểm của cả lớp. Bạn có chắc muốn thực hiện thao tác này!")) {

            if (Validator.isBeforeToday(ngayKetThuc)
                    || coVanCham.equalsIgnoreCase("Hết thời gian chấm")) {
                DialogHelper.showMessage("Hết thời gian chấm điểm");
            } else if (coVanCham.equalsIgnoreCase("Sinh viên đang chấm")
                    || coVanCham.equalsIgnoreCase("Sinh viên đã chấm")
                    || coVanCham.equalsIgnoreCase("Sinh viên kết thúc chấm")) {
                DialogHelper.showError("Ban cán sự chưa chấm điểm\nNếu muốn chấm điểm thay đổi trạng thái chấm điểm của ban cán sự");
            } else {
                for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                    try {
                        DiemRenLuyenModel diemRenLuyenBCS = DiemRenLuyenCtrl.timDRLDayDu(drl.getMaSinhVien(), hocKy, namHoc, "BanCanSu");
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(diemRenLuyenBCS.getMaSinhVien(), diemRenLuyenBCS.getHocKy(), diemRenLuyenBCS.getNamHoc());
                        String xepLoai = "";
                        if (diemRenLuyenBCS.getTongDiem() >= 90) {
                            xepLoai = "Xuất sắc";
                        } else if (diemRenLuyenBCS.getTongDiem() >= 80) {
                            xepLoai = "Tốt";
                        } else if (diemRenLuyenBCS.getTongDiem() >= 65) {
                            xepLoai = "Khá";
                        } else if (diemRenLuyenBCS.getTongDiem() >= 50) {
                            xepLoai = "Trung bình";
                        } else if (diemRenLuyenBCS.getTongDiem() >= 35) {
                            xepLoai = "Yếu";
                        } else {
                            xepLoai = "Kém";
                        }
                        DiemRenLuyenModel diem = new DiemRenLuyenModel(maPhieuDRL, "CoVan", xepLoai, "Cố vấn đã chấm", diemRenLuyenBCS.getTongDiem(), diemRenLuyenBCS.getD11(), diemRenLuyenBCS.getD12a(), diemRenLuyenBCS.getD12b(), diemRenLuyenBCS.getD12c(), diemRenLuyenBCS.getD12d(), diemRenLuyenBCS.getD12e(), diemRenLuyenBCS.getD12g(), diemRenLuyenBCS.getD13(), diemRenLuyenBCS.getD13a(), diemRenLuyenBCS.getD13b(), diemRenLuyenBCS.getD13c(), diemRenLuyenBCS.getD13d(), diemRenLuyenBCS.getD14(), diemRenLuyenBCS.getD15(), diemRenLuyenBCS.getD1(), diemRenLuyenBCS.getD21(), diemRenLuyenBCS.getD21a(), diemRenLuyenBCS.getD21b(), diemRenLuyenBCS.getD22a(), diemRenLuyenBCS.getD22b(), diemRenLuyenBCS.getD23a(), diemRenLuyenBCS.getD23b(), diemRenLuyenBCS.getD2(), diemRenLuyenBCS.getD31(), diemRenLuyenBCS.getD32(), diemRenLuyenBCS.getD33(), diemRenLuyenBCS.getD34(), diemRenLuyenBCS.getD35(), diemRenLuyenBCS.getD3(), diemRenLuyenBCS.getD41(), diemRenLuyenBCS.getD42(), diemRenLuyenBCS.getD43(), diemRenLuyenBCS.getD44(), diemRenLuyenBCS.getD45(), diemRenLuyenBCS.getD46(), diemRenLuyenBCS.getD4(), diemRenLuyenBCS.getD51(), diemRenLuyenBCS.getD52(), diemRenLuyenBCS.getD53(), diemRenLuyenBCS.getD5());
                        DiemRenLuyenCtrl.chamDiemSV(diem);
                        DiemRenLuyenCtrl.thayDoiTrangThaiCham("Cố vấn đã chấm", maPhieuDRL);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                hienThiDSDiem();
            }
        }
    }//GEN-LAST:event_duyetTatCaButtonActionPerformed

    private void cmbTKNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNamHocActionPerformed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_cmbTKNamHocActionPerformed

    private void cmbTKLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKLopActionPerformed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_cmbTKLopActionPerformed

    private void cmbTKHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKHocKyActionPerformed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_cmbTKHocKyActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        timKiemDanhSachDRL();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chamLaiButton;
    private javax.swing.JComboBox<String> cmbTKHocKy;
    private javax.swing.JComboBox<String> cmbTKLop;
    private javax.swing.JComboBox<String> cmbTKNamHoc;
    private javax.swing.JTextField diemTieuChi1TextField;
    private javax.swing.JTextField diemTieuChi2TextField;
    private javax.swing.JTextField diemTieuChi3TextField;
    private javax.swing.JTextField diemTieuChi4TextField;
    private javax.swing.JTextField diemTieuChi5TextField;
    private javax.swing.JTable dsDiemRenLuyenTable;
    private javax.swing.JButton duyetTatCaButton;
    private javax.swing.JTextField hoTenTextField;
    private javax.swing.JTextField hocKyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ketThucChamButton;
    private javax.swing.JButton lamMoiButton;
    private javax.swing.JTextField maSinhVienTextField;
    private javax.swing.JTextField namHocTextField;
    private javax.swing.JTextField tongDiemTextField;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JButton xemDiemButton;
    private javax.swing.JTextField xepLoaiTextField;
    // End of variables declaration//GEN-END:variables
}
