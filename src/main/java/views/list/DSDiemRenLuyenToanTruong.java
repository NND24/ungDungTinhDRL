package views.list;

import controllers.DiemRenLuyenCtrl;
import controllers.PhanCongCtrl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DiemRenLuyenModel;
import views.main.DangNhap;

public class DSDiemRenLuyenToanTruong extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    String coVanCham = "";

    public DSDiemRenLuyenToanTruong() {
        initComponents();
        tableModel = (DefaultTableModel) tblDSDiemRenLuyen.getModel();
        hienThiDSLop();
    }

    private void hienThiDSLop() {
        try {
            List<String> dsLop = PhanCongCtrl.timDSLop(DangNhap.currentUserId);

//            cmbTKLop.removeAllItems();
//            cmbTKLop.addItem("---Lớp---");
//            dsLop.forEach(lop -> {
//                cmbTKLop.addItem(lop);
//            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenToanTruong.class.getName()).log(Level.SEVERE, null, ex);
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
        String tenLop = cmbTKLop.getSelectedItem().toString();
        if (!tenLop.equals("---Lớp---")) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            String hocKy = "";
            if (currentMonth == 9 || currentMonth == 10 || currentMonth == 11 || currentMonth == 12 || currentMonth == 1) {
                hocKy = "1";
            } else {
                hocKy = "2";
            }

            String namHoc = "";
            if (currentMonth == 9 || currentMonth == 10 || currentMonth == 11 || currentMonth == 12 || currentMonth == 1) {
                if (currentMonth == 1) {
                    namHoc = (currentYear - 1) + "-" + currentYear;

                } else {
                    namHoc = currentYear + "-" + (currentYear + 1);
                }

            } else {
                namHoc = (currentYear - 1) + "-" + currentYear;
            }

            dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", tenLop, hocKy, namHoc);
            tableModel.setRowCount(0);

            dsDiemRenLuyen.forEach(drl -> {
                tableModel.addRow(new Object[]{
                    drl.getMaSinhVien(), drl.getHoTen(),
                    drl.getD1(), drl.getD2(), drl.getD3(),
                    drl.getD4(), drl.getD5(), drl.getTongDiem(),
                    drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                    drl.getTrangThaiCham()});

                if (drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn đã chấm")) {
                    coVanCham = drl.getTrangThaiCham();
                }
            });

        } else {
            lamMoi();
            tblDSDiemRenLuyen.removeAll();
        }
    }

    void lamMoi() {
        txtMaSinhVien.setText("");
        txtHoTen.setText("");
        txtTieuChi1.setText("");
        txtTieuChi2.setText("");
        txtTieuChi3.setText("");
        txtTieuChi4.setText("");
        txtTieuChi5.setText("");
        txtTongDiem.setText("");
        txtXepLoai.setText("");
        txtHocKy.setText("");
        txtNamHoc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lamMoiButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDiemRenLuyen = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTieuChi1 = new javax.swing.JTextField();
        txtTieuChi2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTieuChi3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTieuChi4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTieuChi5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtXepLoai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongDiem = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cmbTKKhoa = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmbTKLop = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbTKNamHoc = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmbTKHocKy = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN ");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1048, Short.MAX_VALUE)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        tblDSDiemRenLuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm tiêu chí 1", "Điểm tiêu chí 2", "Điểm tiêu chí 3", "Điểm tiêu chí 4", "Điểm tiêu chí 5", "Tổng điểm", "Xếp loại", "Học kỳ", "Năm học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
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
        jLabel26.setText("DANH SÁCH ĐIỂM RÈN LUYỆN");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Khoa");

        cmbTKKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Khoa---", "Công nghệ thông tin", "Viễn thông" }));
        cmbTKKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKKhoaActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Lớp");

        cmbTKLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Lớp---", "D21CQCN01-N", "D21CQCN02-N" }));
        cmbTKLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKLopActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Năm học");

        cmbTKNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Năm học---", "2022-2023", "2023-2024" }));
        cmbTKNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNamHocActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Học kỳ");

        cmbTKHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Học kỳ---", "1", "2" }));
        cmbTKHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKHocKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTieuChi3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(44, 44, 44)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(cmbTKKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
                .addContainerGap())
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
            txtHoTen.setText(drl.getHoTen());
            txtTieuChi1.setText(Float.toString(drl.getD1()));
            txtTieuChi2.setText(Integer.toString(drl.getD2()));
            txtTieuChi3.setText(Integer.toString(drl.getD3()));
            txtTieuChi4.setText(Integer.toString(drl.getD4()));
            txtTieuChi5.setText(Integer.toString(drl.getD5()));
            txtTongDiem.setText(Float.toString(drl.getTongDiem()));
            txtXepLoai.setText(drl.getXepLoai());
            txtHocKy.setText(drl.getHocKy());
            txtNamHoc.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_tblDSDiemRenLuyenMouseClicked

    private void lamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiButtonActionPerformed
        lamMoi();
    }//GEN-LAST:event_lamMoiButtonActionPerformed

    private void cmbTKNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNamHocActionPerformed
        try {
            String tuKhoa = txtTimKiem.getText();
            String lop = cmbTKLop.getSelectedItem().toString();
            String namHoc = cmbTKNamHoc.getSelectedItem().toString();
            String hocKy = cmbTKHocKy.getSelectedItem().toString();

            if (lop.equals("---Lớp---")) {
                lop = "";
            }
            if (namHoc.equals("---Năm học---")) {
                namHoc = "";
            }
            if (hocKy.equals("---Học kỳ---")) {
                hocKy = "";
            }

            dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, namHoc, hocKy);
            hienThiDSDiem();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenToanTruong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTKNamHocActionPerformed

    private void cmbTKLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKLopActionPerformed
        try {
            if (cmbTKLop.getSelectedItem() != null) {
                String tuKhoa = txtTimKiem.getText();
                String lop = cmbTKLop.getSelectedItem().toString();
                String namHoc = cmbTKNamHoc.getSelectedItem().toString();
                String hocKy = cmbTKHocKy.getSelectedItem().toString();

                if (lop.equals("---Lớp---")) {
                    lop = "";
                }
                if (namHoc.equals("---Năm học---")) {
                    namHoc = "";
                }
                if (hocKy.equals("---Học kỳ---")) {
                    hocKy = "";
                }

                dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, namHoc, hocKy);
                hienThiDSDiem();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenToanTruong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTKLopActionPerformed

    private void cmbTKHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKHocKyActionPerformed
        try {
            String tuKhoa = txtTimKiem.getText();
            String lop = cmbTKLop.getSelectedItem().toString();
            String namHoc = cmbTKNamHoc.getSelectedItem().toString();
            String hocKy = cmbTKHocKy.getSelectedItem().toString();

            if (lop.equals("---Lớp---")) {
                lop = "";
            }
            if (namHoc.equals("---Năm học---")) {
                namHoc = "";
            }
            if (hocKy.equals("---Học kỳ---")) {
                hocKy = "";
            }

            dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, namHoc, hocKy);
            hienThiDSDiem();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenToanTruong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTKHocKyActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        try {
            String tuKhoa = txtTimKiem.getText();
            String lop = cmbTKLop.getSelectedItem().toString();
            String namHoc = cmbTKNamHoc.getSelectedItem().toString();
            String hocKy = cmbTKHocKy.getSelectedItem().toString();

            if (lop.equals("---Lớp---")) {
                lop = "";
            }
            if (namHoc.equals("---Năm học---")) {
                namHoc = "";
            }
            if (hocKy.equals("---Học kỳ---")) {
                hocKy = "";
            }

            dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, namHoc, hocKy);
            hienThiDSDiem();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenToanTruong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void cmbTKKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTKKhoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTKHocKy;
    private javax.swing.JComboBox<String> cmbTKKhoa;
    private javax.swing.JComboBox<String> cmbTKLop;
    private javax.swing.JComboBox<String> cmbTKNamHoc;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiButton;
    private javax.swing.JTable tblDSDiemRenLuyen;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtTieuChi1;
    private javax.swing.JTextField txtTieuChi2;
    private javax.swing.JTextField txtTieuChi3;
    private javax.swing.JTextField txtTieuChi4;
    private javax.swing.JTextField txtTieuChi5;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongDiem;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
