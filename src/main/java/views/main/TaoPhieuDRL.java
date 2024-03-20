package views.main;

import controllers.DiemRenLuyenCtrl;
import controllers.PhieuDRLCtrl;
import controllers.LopTestCtrl;
import controllers.SinhVienTestCtrl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.LopModelTest;
import models.NamHocModel;
import models.PhieuDRLModel;
import models.SinhVienTestModel;
import utils.DialogHelper;

public class TaoPhieuDRL extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<PhieuDRLModel> dsPhieuDRL = new ArrayList<>();
    List<LopModelTest> dsLop = new ArrayList<>();
    List<NamHocModel> dsNamHoc = new ArrayList<>();
    List<SinhVienTestModel> dsSinhVien = new ArrayList<>();

    public TaoPhieuDRL() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSPhieuDRL.getModel();

            hienThiDSLop();
            hienThiTatCaPhieuDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLop() {
        try {
            dsLop = LopTestCtrl.timTatCaLopHienThi();
            cmbLop.removeAllItems();

            dsLop.forEach(lop -> {
                cmbLop.addItem(lop.getMaLop());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNamHoc() {
//        try {
//            dsNamHoc = NamHocModel.timTatCaLopHienThi();
//            cmbLop.removeAllItems();
//
//            dsLop.forEach(lop -> {
//                cmbLop.addItem(lop.getTenLop());
//            });
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void hienThiTatCaPhieuDRL() throws ClassNotFoundException {
        dsPhieuDRL = PhieuDRLCtrl.timTatCaPhieuDRL();

        tableModel.setRowCount(0);

        dsPhieuDRL.forEach(phieu -> {
            tableModel.addRow(new Object[]{phieu.getMaLop(), phieu.getNamHoc(), phieu.getHocKy(),
                phieu.getNgayBatDau(), phieu.getNgayKetThuc()});
        });
    }

    private void lamMoi() {
        cmbHocKy.setSelectedIndex(0);
        cmbLop.setSelectedIndex(0);
        cmbNamHoc.setSelectedIndex(0);
        dateChooserEnd.setCalendar(null);
        dateChooserStart.setCalendar(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhieuDRL = new javax.swing.JTable();
        ThemButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        xuatDSButton = new javax.swing.JButton();
        NhapMoiButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbLop = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbHocKy = new javax.swing.JComboBox<>();
        cmbNamHoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách dịch vụ cận lâm sàn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 436));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Học kỳ");

        tblDSPhieuDRL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Lớp", "Năm học", "Học kỳ", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPhieuDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSPhieuDRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPhieuDRLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPhieuDRL);

        ThemButton.setBackground(new java.awt.Color(0, 102, 255));
        ThemButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThemButton.setForeground(new java.awt.Color(255, 255, 255));
        ThemButton.setText("Thêm");
        ThemButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThemButton.setPreferredSize(new java.awt.Dimension(70, 30));
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });

        XoaButton.setBackground(new java.awt.Color(0, 102, 255));
        XoaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        XoaButton.setForeground(new java.awt.Color(255, 255, 255));
        XoaButton.setText("Xóa");
        XoaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        XoaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XoaButton.setPreferredSize(new java.awt.Dimension(70, 30));
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(0, 102, 255));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.setPreferredSize(new java.awt.Dimension(70, 30));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        xuatDSButton.setBackground(new java.awt.Color(0, 102, 255));
        xuatDSButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xuatDSButton.setForeground(new java.awt.Color(255, 255, 255));
        xuatDSButton.setText("Xuất danh sách");
        xuatDSButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        xuatDSButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xuatDSButton.setPreferredSize(new java.awt.Dimension(130, 30));
        xuatDSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatDSButtonActionPerformed(evt);
            }
        });

        NhapMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        NhapMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NhapMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        NhapMoiButton.setText("Làm mới");
        NhapMoiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NhapMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NhapMoiButton.setPreferredSize(new java.awt.Dimension(90, 30));
        NhapMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapMoiButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Lớp");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Năm học");

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH PHIẾU ĐIỂM RÈN LUYỆN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        cmbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        cmbNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022-2023", "2023-2024" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày bắt đầu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ngày kết thúc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(46, 46, 46)
                                .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NhapMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapMoiButtonActionPerformed
        try {
            lamMoi();
            hienThiTatCaPhieuDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapMoiButtonActionPerformed

    private void xuatDSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatDSButtonActionPerformed
        PhieuDRLCtrl.xuatFileExcel(dsPhieuDRL, "src/main/java/files/DSPhieuDRL.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_xuatDSButtonActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            String maLop = cmbLop.getSelectedItem().toString();
            String namHoc = cmbNamHoc.getSelectedItem().toString();
            int maNamHoc;
            if (namHoc.equals("2022-2023")) {
                maNamHoc = 1;
            } else {
                maNamHoc = 2;
            }
            int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
            java.util.Date ngayBatDauUtil = dateChooserStart.getDate();
            java.util.Date ngayKetThucUtil = dateChooserEnd.getDate();
            java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
            java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());
            dsSinhVien = SinhVienTestCtrl.timSinhVienTheoLop(maLop);

            dsSinhVien.forEach(sv -> {
                try {
                    String maPhieuDRL = sv.getMaSinhVien() + maNamHoc + hocKy;
                    PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, ngayBatDau, ngayKetThuc);
                    PhieuDRLCtrl.capNhatPhieuDRL(phieu);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            DialogHelper.showMessage("Cập nhật thành công");
            hienThiTatCaPhieuDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        try {
            String maLop = cmbLop.getSelectedItem().toString();
            String namHoc = cmbNamHoc.getSelectedItem().toString();
            int maNamHoc;
            if (namHoc.equals("2022-2023")) {
                maNamHoc = 1;
            } else {
                maNamHoc = 2;
            }
            int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
            dsSinhVien = SinhVienTestCtrl.timSinhVienTheoLop(maLop);
            boolean flagCheckExist = false;
            for (SinhVienTestModel sv : dsSinhVien) {
                try {
                    String maPhieuDRL = sv.getMaSinhVien() + maNamHoc + hocKy;
                    if (PhieuDRLCtrl.kiemTraDaChamDiem(maPhieuDRL)) {
                        DialogHelper.showError("Đã có sinh viên chấm điểm. Không thể xóa");
                        flagCheckExist = true;
                        break;
                    } else {
                        PhieuDRLCtrl.xoaPhieuDRL(maPhieuDRL);
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!flagCheckExist) {
                DialogHelper.showMessage("Xóa phiếu điểm rèn luyện thành công");
                hienThiTatCaPhieuDRL();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        try {
            String maLop = cmbLop.getSelectedItem().toString();
            String namHoc = cmbNamHoc.getSelectedItem().toString();
            int maNamHoc;
            if (namHoc.equals("2022-2023")) {
                maNamHoc = 1;
            } else {
                maNamHoc = 2;
            }
            int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
            java.util.Date ngayBatDauUtil = dateChooserStart.getDate();
            java.util.Date ngayKetThucUtil = dateChooserEnd.getDate();

            // Kiểm tra nếu một trong hai ngày bắt đầu hoặc kết thúc là null
            if (ngayBatDauUtil == null || ngayKetThucUtil == null) {
                DialogHelper.showError("Vui lòng chọn ngày bắt đầu và kết thúc.");
                return;
            }

            java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
            java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());

            if (ngayBatDau.after(ngayKetThuc)) {
                DialogHelper.showError("Ngày bắt đầu phải trước ngày kết thúc.");
            } else {
                dsSinhVien = SinhVienTestCtrl.timSinhVienTheoLop(maLop);
                boolean flagCheckExist = false;
                for (SinhVienTestModel sv : dsSinhVien) {
                    try {
                        String maPhieuDRL = sv.getMaSinhVien() + maNamHoc + hocKy;
                        if (PhieuDRLCtrl.kiemTraPhieuDaTonTai(maPhieuDRL)) {
                            DialogHelper.showError("Lớp: " + maLop + " đã được tạo phiếu chấm điểm cho học kỳ: " + hocKy + " năm học:" + namHoc);
                            flagCheckExist = true;
                            break;
                        } else {
                            PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, sv.getMaSinhVien(), maNamHoc, hocKy, ngayBatDau, ngayKetThuc);
                            PhieuDRLCtrl.themPhieuDRL(phieu);
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "SinhVien", "Sinh viên đang chấm");
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "BanCanSu", "Sinh viên đang chấm");
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "CoVan", "Sinh viên đang chấm");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (!flagCheckExist) {
                    DialogHelper.showMessage("Tạo phiếu chấm điểm thành công");
                    hienThiTatCaPhieuDRL();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void tblDSPhieuDRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhieuDRLMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSPhieuDRL.getSelectedRow();
        if (selectedIndex >= 0) {
            PhieuDRLModel phieu = dsPhieuDRL.get(selectedIndex);
            cmbLop.setSelectedItem(phieu.getMaLop());
            cmbNamHoc.setSelectedItem(phieu.getNamHoc());
            int hocKyIndex;
            if (phieu.getHocKy() == 1) {
                hocKyIndex = 0;
            } else {
                hocKyIndex = 1;
            }
            cmbHocKy.setSelectedIndex(hocKyIndex);
            dateChooserStart.setDate(phieu.getNgayBatDau());
            dateChooserEnd.setDate(phieu.getNgayKetThuc());
        }
    }//GEN-LAST:event_tblDSPhieuDRLMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoPhieuDRL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NhapMoiButton;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton XoaButton;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JComboBox<String> cmbHocKy;
    private javax.swing.JComboBox<String> cmbLop;
    private javax.swing.JComboBox<String> cmbNamHoc;
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSPhieuDRL;
    private javax.swing.JButton xuatDSButton;
    // End of variables declaration//GEN-END:variables
}
