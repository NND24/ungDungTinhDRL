package views.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.LopModel;
import models.NamHocModel;
import models.PhieuDRLModel;
import models.SinhVienModel;
import controllers.DiemRenLuyenCtrl;
import controllers.LopCtrl;
import controllers.NamHocCtrl;
import controllers.PhieuDRLCtrl;
import controllers.SinhVienCtrl;
import models.DiemRenLuyenModel;
import utils.DialogHelper;
import utils.Validator;

public class TaoPhieuDRL extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    DefaultTableModel tableModel2;
    List<PhieuDRLModel> dsPhieuDRL = new ArrayList<>();
    List<PhieuDRLModel> dsChiTietPhieu = new ArrayList<>();
    List<LopModel> dsLop = new ArrayList<>();
    List<NamHocModel> dsNamHoc = new ArrayList<>();
    List<SinhVienModel> dsSinhVien = new ArrayList<>();

    public TaoPhieuDRL() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSPhieuDRL.getModel();
            tableModel2 = (DefaultTableModel) tblChiTietPhieuDRL.getModel();

            hienThiDSLop();
            hienThiDSNamHoc();
            hienThiTatCaPhieuDRL();
            cmbLop.setSelectedItem("---Lớp---");
            cmbNamHoc.setSelectedItem("---Năm học---");
            cmbHocKy.setSelectedItem("---Học kỳ---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLop() {
        try {
            dsLop = LopCtrl.timTatCaLopHienThi();
            cmbLop.removeAllItems();

            dsLop.forEach(lop -> {
                cmbLop.addItem(lop.getMaLop());
            });
            cmbLop.addItem("---Lớp---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNamHoc() {
        try {
            dsNamHoc = NamHocCtrl.timNamHocHienThi();
            cmbNamHoc.removeAllItems();

            dsNamHoc.forEach(namHoc -> {
                cmbNamHoc.addItem(namHoc.getNamHoc());
            });
            cmbNamHoc.addItem("---Năm học---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaPhieuDRL() throws ClassNotFoundException {
        dsPhieuDRL = PhieuDRLCtrl.timTatCaPhieuDRL();

        tableModel.setRowCount(0);

        dsPhieuDRL.forEach(phieu -> {
            tableModel.addRow(new Object[]{phieu.getMaLop(), phieu.getNamHoc(), phieu.getHocKy(),
                phieu.getNgayBatDau(), phieu.getNgayKetThuc()});
        });
    }

    private void hienThiChiTietPhieuDRL(String maLop, String namHoc, int hocKy) throws ClassNotFoundException {
        dsChiTietPhieu = PhieuDRLCtrl.timChiTietPhieu(maLop, namHoc, hocKy);

        tableModel2.setRowCount(0);
        dsChiTietPhieu.forEach(phieu -> {
            tableModel2.addRow(new Object[]{phieu.getMaSinhVien(), phieu.getTenSinhVien(),
                phieu.getMaLop(), phieu.getMaBanCanSuCham() + " " + phieu.getTenBanCanSu(),
                phieu.getMaCoVanCham() + " " + phieu.getTenCoVan(), phieu.getTrangThaiCham()});
        });
    }

    private void lamMoi() {
        cmbHocKy.setSelectedIndex(0);
        cmbLop.setSelectedIndex(0);
        cmbNamHoc.setSelectedIndex(0);
        dateChooserEnd.setCalendar(null);
        dateChooserStart.setCalendar(null);
        tableModel2.setRowCount(0);
        cmbLop.setSelectedItem("---Lớp---");
        cmbNamHoc.setSelectedItem("---Năm học---");
        cmbHocKy.setSelectedItem("---Học kỳ---");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhieuDRL = new javax.swing.JTable();
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
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnXemDSKQ = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietPhieuDRL = new javax.swing.JTable();
        pnlNutLenh = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnNhapMoi = new javax.swing.JButton();
        btnXuatDanhSach = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1140, 753));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 753));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ngày bắt đầu");

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
                .addContainerGap(928, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        cmbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "---Học kỳ---" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày kết thúc");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Học kỳ");

        jPanel7.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("CHI TIẾT PHIẾU ĐIỂM RÈN LUYỆN");

        btnXemDSKQ.setBackground(new java.awt.Color(0, 102, 255));
        btnXemDSKQ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXemDSKQ.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDSKQ.setText("Xuất danh sách kết quả");
        btnXemDSKQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXemDSKQ.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXemDSKQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSKQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXemDSKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnXemDSKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblChiTietPhieuDRL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Lớp", "Ban cán sự chấm", "Cố vấn chấm", "Trạng thái chấm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietPhieuDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tblChiTietPhieuDRL);

        pnlNutLenh.setBackground(new java.awt.Color(255, 255, 255));
        pnlNutLenh.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(70, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnThem);

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(70, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnXoa);

        btnCapNhat.setBackground(new java.awt.Color(0, 102, 255));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnCapNhat);

        btnNhapMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoi.setText("Làm mới");
        btnNhapMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnNhapMoi);

        btnXuatDanhSach.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDanhSach.setText("Xuất danh sách");
        btnXuatDanhSach.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDanhSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDanhSach.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXuatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDanhSachActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnXuatDanhSach);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlNutLenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cmbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel8))
                    .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(pnlNutLenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSPhieuDRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhieuDRLMouseClicked
        int selectedIndex = tblDSPhieuDRL.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                PhieuDRLModel phieu = dsPhieuDRL.get(selectedIndex);
                cmbLop.setSelectedItem(phieu.getMaLop());
                cmbNamHoc.setSelectedItem(phieu.getNamHoc());
                cmbHocKy.setSelectedItem(Integer.toString(phieu.getHocKy()));
                dateChooserStart.setDate(phieu.getNgayBatDau());
                dateChooserEnd.setDate(phieu.getNgayKetThuc());

                hienThiChiTietPhieuDRL(phieu.getMaLop(), phieu.getNamHoc(), phieu.getHocKy());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblDSPhieuDRLMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            java.util.Date ngayBatDauUtil = dateChooserStart.getDate();
            java.util.Date ngayKetThucUtil = dateChooserEnd.getDate();

            // Kiểm tra nếu một trong hai ngày bắt đầu hoặc kết thúc là null
            if (ngayBatDauUtil == null || ngayKetThucUtil == null) {
                DialogHelper.showError("Vui lòng chọn ngày bắt đầu và kết thúc.");
                return;
            }

            java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
            java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());

            if (cmbLop.getSelectedItem().equals("---Lớp---")) {
                DialogHelper.showError("Vui lòng chọn lớp");
            } else if (cmbNamHoc.getSelectedItem().equals("---Năm học---")) {
                DialogHelper.showError("Vui lòng chọn năm học");
            } else if (ngayBatDau.after(ngayKetThuc)) {
                DialogHelper.showError("Ngày bắt đầu phải trước ngày kết thúc.");
            } else if (cmbHocKy.getSelectedItem().equals("---Học kỳ---")) {
                DialogHelper.showError("Vui lòng chọn học kỳ");
            } else {
                String maLop = cmbLop.getSelectedItem().toString();
                String namHoc = cmbNamHoc.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
                dsSinhVien = SinhVienCtrl.timSinhVienTheoLop(maLop);
                boolean flagCheckExist = false;
                for (SinhVienModel sv : dsSinhVien) {
                    try {
                        String maPhieuDRL = sv.getMaSinhVien() + maNamHoc + hocKy;
                        if (PhieuDRLCtrl.kiemTraPhieuDaTonTai(maPhieuDRL)) {
                            DialogHelper.showError("Lớp: " + maLop + " đã được tạo phiếu chấm điểm cho học kỳ: " + hocKy + " năm học: " + namHoc);
                            flagCheckExist = true;
                            break;
                        } else {
                            PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, sv.getMaSinhVien(), maNamHoc, hocKy, "Sinh viên đang chấm", ngayBatDau, ngayKetThuc);
                            PhieuDRLCtrl.themPhieuDRL(phieu);
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "SinhVien");
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "BanCanSu");
                            DiemRenLuyenCtrl.themMoiDRL(maPhieuDRL, "CoVan");
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
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (cmbLop.getSelectedItem().toString().equals("---Lớp---")) {
                DialogHelper.showError("Vui lòng chọn lớp");
            } else if (cmbNamHoc.getSelectedItem().toString().equals("---Năm học---")) {
                DialogHelper.showError("Vui lòng chọn năm học");
            } else if (cmbHocKy.getSelectedItem().toString().equals("---Học kỳ---")) {
                DialogHelper.showError("Vui lòng chọn học kỳ");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa phiếu điểm này?")) {
                String maLop = cmbLop.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
                dsSinhVien = SinhVienCtrl.timSinhVienTheoLop(maLop);
                boolean flagCheckExist = false;
                for (SinhVienModel sv : dsSinhVien) {
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
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            java.util.Date ngayBatDauUtil = dateChooserStart.getDate();
            java.util.Date ngayKetThucUtil = dateChooserEnd.getDate();

            // Kiểm tra nếu một trong hai ngày bắt đầu hoặc kết thúc là null
            if (ngayBatDauUtil == null || ngayKetThucUtil == null) {
                DialogHelper.showError("Vui lòng chọn ngày bắt đầu và kết thúc.");
                return;
            }

            java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
            java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());

            if (cmbLop.getSelectedItem().equals("---Lớp---")) {
                DialogHelper.showError("Vui lòng chọn lớp");
            } else if (cmbNamHoc.getSelectedItem().equals("---Năm học---")) {
                DialogHelper.showError("Vui lòng chọn năm học");
            } else if (ngayBatDau.after(ngayKetThuc)) {
                DialogHelper.showError("Ngày bắt đầu phải trước ngày kết thúc.");
            } else if (cmbHocKy.getSelectedItem().equals("---Học kỳ---")) {
                DialogHelper.showError("Vui lòng chọn học kỳ");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn cập nhật phiếu điểm này?")) {
                String maLop = cmbLop.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                int hocKy = Integer.parseInt(cmbHocKy.getSelectedItem().toString());
                dsSinhVien = SinhVienCtrl.timSinhVienTheoLop(maLop);
                dsSinhVien.forEach(sv -> {
                    try {
                        String maPhieuDRL = sv.getMaSinhVien() + maNamHoc + hocKy;
                        PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, ngayBatDau, ngayKetThuc);
                        PhieuDRLCtrl.capNhatPhieuDRL(phieu);
                        PhieuDRLModel p = new PhieuDRLModel(maPhieuDRL, "Cố vấn đã chấm");
                        PhieuDRLCtrl.capNhatTrangThaiCham(p);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                DialogHelper.showMessage("Cập nhật thành công");
                hienThiTatCaPhieuDRL();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXuatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDanhSachActionPerformed
        PhieuDRLCtrl.xuatFileExcel(dsPhieuDRL, "src/main/java/files/DSPhieuDRL.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDanhSachActionPerformed

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        try {
            lamMoi();
            hienThiTatCaPhieuDRL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void btnXemDSKQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSKQActionPerformed
        try {
            int selectedIndex = tblDSPhieuDRL.getSelectedRow();
            if (selectedIndex >= 0) {
                PhieuDRLModel phieu = dsPhieuDRL.get(selectedIndex);

                String maLop = phieu.getMaLop();
                String namHoc = phieu.getNamHoc();
                int hocKy = phieu.getHocKy();

                List<DiemRenLuyenModel> dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", maLop, Integer.toString(hocKy), namHoc);
                if (!dsDiemRenLuyen.isEmpty()) {
                    for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
                        if (sv.getTrangThaiCham().equalsIgnoreCase("Hết thời gian chấm")
                                || Validator.isBeforeToday(sv.getNgayKetThuc())) {
                            DiemRenLuyenCtrl.xuatFileExcel(dsDiemRenLuyen);
                            DialogHelper.showMessage("Xuất danh sách thành công!");
                            break;
                        } else {
                            DialogHelper.showError("Chưa hoàn tất chấm điểm không thể in danh sách kết quả");
                            break;
                        }
                    }
                } else {
                    DialogHelper.showError("Chưa có danh sách điểm rèn luyện");
                }
            } else {
                DialogHelper.showError("Chưa chọn phiếu điểm rèn luyện muốn in!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaoPhieuDRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXemDSKQActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXemDSKQ;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDanhSach;
    private javax.swing.JComboBox<String> cmbHocKy;
    private javax.swing.JComboBox<String> cmbLop;
    private javax.swing.JComboBox<String> cmbNamHoc;
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlNutLenh;
    private javax.swing.JTable tblChiTietPhieuDRL;
    private javax.swing.JTable tblDSPhieuDRL;
    // End of variables declaration//GEN-END:variables
}
