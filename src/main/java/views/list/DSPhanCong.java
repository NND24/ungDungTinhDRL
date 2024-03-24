package views.list;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.CoVanTestModel;
import models.LopModelTest;
import models.NamHocModel;
import models.PhanCongModel;
import controllers.CoVanTestCtrl;
import controllers.PhanCongCtrl;
import controllers.LopTestCtrl;
import controllers.NamHocCtrl;
import utils.DialogHelper;

public class DSPhanCong extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    private List<PhanCongModel> dsPhanCong = new ArrayList<>();
    private List<LopModelTest> dsLop = new ArrayList<>();
    private List<CoVanTestModel> dsCoVan = new ArrayList<>();
    private List<NamHocModel> dsNamHoc = new ArrayList<>();

    public DSPhanCong() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSPhanCong.getModel();

            hienThiDSCoVan();
            hienThiDSLop();
            hienThiDSNamHoc();
            hienThiTatCaPhanCong();
            cmbCoVan.setSelectedItem("---Cố vấn---");
            cmbLop.setSelectedItem("---Lớp---");
            cmbNamHoc.setSelectedItem("---Năm học---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCoVan() {
        try {
            dsCoVan = CoVanTestCtrl.timTatCaCoVanConLam();
            cmbCoVan.removeAllItems();

            dsCoVan.forEach(cv -> {
                cmbCoVan.addItem(cv.getHoTen());
            });
            cmbCoVan.addItem("---Cố vấn---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLop() {
        try {
            dsLop = LopTestCtrl.timTatCaLopHienThi();
            cmbLop.removeAllItems();

            dsLop.forEach(lop -> {
                cmbLop.addItem(lop.getMaLop());
            });
            cmbLop.addItem("---Lớp---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaPhanCong() throws ClassNotFoundException {
        dsPhanCong = PhanCongCtrl.timTatCaPhanCong();

        tableModel.setRowCount(0);

        dsPhanCong.forEach(pc -> {
            String trangThai = "";
            if (pc.getTrangThaiHienThi() == 1) {
                trangThai = "Hiển thị";
            } else {
                trangThai = "Ẩn";
            }
            tableModel.addRow(new Object[]{pc.getMaPhanCong(), pc.getTenCoVan(),
                pc.getMaLop(), pc.getNamHoc(), trangThai});
        });
    }

    private void lamMoi() {
        cmbCoVan.setSelectedIndex(0);
        cmbLop.setSelectedIndex(0);
        cmbNamHoc.setSelectedIndex(0);
        cmbCoVan.setSelectedItem("---Cố vấn---");
        cmbLop.setSelectedItem("---Lớp---");
        cmbNamHoc.setSelectedItem("---Năm học---");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhanCong = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbLop = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbCoVan = new javax.swing.JComboBox<>();
        cmbNamHoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTrangThai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhanCong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách phân công");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 436));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên cố vấn");

        tblDSPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phân công", "Tên cố vấn", "Lớp", "Năm học", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPhanCong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSPhanCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPhanCongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPhanCong);

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

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(70, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(0, 102, 255));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất danh sách");
        btnXuat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Lớp");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Năm học");

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH PHÂN CÔNG");

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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Trạng thái");

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ẩn", "Hiển thị" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã phân công");

        txtMaPhanCong.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 39, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            lamMoi();
            hienThiTatCaPhanCong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (!txtMaPhanCong.getText().isEmpty()) {
                DialogHelper.showError("Phân công đã tồn tại. Vui lòng nhập mới");
            } else if (cmbCoVan.getSelectedItem().equals("---Cố vấn---")) {
                DialogHelper.showError("Vui lòng chọn cố vấn");
            } else if (cmbLop.getSelectedItem().equals("---Lớp---")) {
                DialogHelper.showError("Vui lòng chọn lớp");
            } else if (cmbNamHoc.getSelectedItem().equals("---Năm học---")) {
                DialogHelper.showError("Vui lòng chọn năm học");
            } else {
                int phanCongIndex = cmbCoVan.getSelectedIndex();
                String maCoVan = dsCoVan.get(phanCongIndex).getMaCoVan();
                String maLop = cmbLop.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                int trangThai = cmbTrangThai.getSelectedIndex();

                if (PhanCongCtrl.kiemTraLopNamHocDaPhanCong(maLop, maNamHoc)) {
                    DialogHelper.showError("Phân công đã tồn tại. Vui lòng nhập mới");
                } else {
                    PhanCongModel phanCong = new PhanCongModel(maCoVan, maLop, maNamHoc, trangThai);
                    PhanCongCtrl.themPhanCong(phanCong);
                    lamMoi();
                    hienThiTatCaPhanCong();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa phân công này!")) {
            try {
                int maPhanCong = Integer.parseInt(txtMaPhanCong.getText());
                PhanCongCtrl.xoaPhanCong(maPhanCong);
                lamMoi();
                hienThiTatCaPhanCong();
                DialogHelper.showMessage("Xóa phân công thành công");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa phân công này!")) {
                if (cmbCoVan.getSelectedItem().equals("---Cố vấn---")) {
                    DialogHelper.showError("Vui lòng chọn cố vấn");
                } else if (cmbLop.getSelectedItem().equals("---Lớp---")) {
                    DialogHelper.showError("Vui lòng chọn lớp");
                } else if (cmbNamHoc.getSelectedItem().equals("---Năm học---")) {
                    DialogHelper.showError("Vui lòng chọn năm học");
                } else {
                    int maPhanCong = Integer.parseInt(txtMaPhanCong.getText());
                    int phanCongIndex = cmbCoVan.getSelectedIndex();
                    String maCoVan = dsCoVan.get(phanCongIndex).getMaCoVan();
                    String maLop = cmbLop.getSelectedItem().toString();
                    int namHocIndex = cmbNamHoc.getSelectedIndex();
                    int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                    int trangThai = cmbTrangThai.getSelectedIndex();

                    if (PhanCongCtrl.kiemTraLopNamHocDaPhanCong(maLop, maNamHoc)) {
                        DialogHelper.showError("Phân công đã tồn tại. Vui lòng nhập mới");
                    } else {
                        PhanCongModel phanCong = new PhanCongModel(maCoVan, maLop, maNamHoc, maPhanCong, trangThai);
                        PhanCongCtrl.capNhatPhanCong(phanCong);
                        lamMoi();
                        hienThiTatCaPhanCong();
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDSPhanCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhanCongMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSPhanCong.getSelectedRow();
        if (selectedIndex >= 0) {
            PhanCongModel pc = dsPhanCong.get(selectedIndex);
            txtMaPhanCong.setText(Integer.toString(pc.getMaPhanCong()));
            cmbCoVan.setSelectedItem(pc.getTenCoVan());
            cmbLop.setSelectedItem(pc.getMaLop());
            cmbNamHoc.setSelectedItem(pc.getNamHoc());
            cmbTrangThai.setSelectedIndex(pc.getTrangThaiHienThi());
        }
    }//GEN-LAST:event_tblDSPhanCongMouseClicked

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        PhanCongCtrl.xuatFileExcel(dsPhanCong, "src/main/java/files/DSPhanCong.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSPhanCong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cmbCoVan;
    private javax.swing.JComboBox<String> cmbLop;
    private javax.swing.JComboBox<String> cmbNamHoc;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSPhanCong;
    private javax.swing.JTextField txtMaPhanCong;
    // End of variables declaration//GEN-END:variables
}
