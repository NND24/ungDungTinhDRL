package views.list;

import controllers.CoVanTestCtrl;
import controllers.PhanCongCtrl;
import controllers.LopTestCtrl;
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
import utils.DialogHelper;
import utils.Validator;

public class DSPhanCong extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<PhanCongModel> dsPhanCong = new ArrayList<>();
    List<LopModelTest> dsLop = new ArrayList<>();
    List<CoVanTestModel> dsCoVan = new ArrayList<>();
    List<NamHocModel> dsNamHoc = new ArrayList<>();

    public DSPhanCong() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSPhanCong.getModel();

            hienThiDSCoVan();
            hienThiDSLop();
            hienThiTatCaPhanCong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCoVan() {
        try {
            dsCoVan = CoVanTestCtrl.timTatCaCoVan();
            cmbCoVan.removeAllItems();

            dsCoVan.forEach(cv -> {
                cmbCoVan.addItem(cv.getHoTen());
            });
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
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
                pc.getNamHoc(), trangThai});
        });
    }

    private void lamMoi() {
        cmbCoVan.setSelectedIndex(0);
        cmbLop.setSelectedIndex(0);
        cmbNamHoc.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhanCong = new javax.swing.JTable();
        ThemButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        SuaButton = new javax.swing.JButton();
        xuatDSButton = new javax.swing.JButton();
        NhapMoiButton = new javax.swing.JButton();
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
        setTitle("Danh sách dịch vụ cận lâm sàn");

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

        SuaButton.setBackground(new java.awt.Color(0, 102, 255));
        SuaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuaButton.setForeground(new java.awt.Color(255, 255, 255));
        SuaButton.setText("Sửa");
        SuaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuaButton.setPreferredSize(new java.awt.Dimension(70, 30));
        SuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaButtonActionPerformed(evt);
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

        cmbNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022-2023", "2023-2024" }));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(320, 320, 320))))
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
                    .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, Short.MAX_VALUE)
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

    private void NhapMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapMoiButtonActionPerformed
        try {
            lamMoi();
            hienThiTatCaPhanCong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapMoiButtonActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        try {
            if (!txtMaPhanCong.getText().isEmpty()) {
                DialogHelper.showError("Phân công đã tồn tại. Vui lòng nhập mới");
            } else {
                int phanCongIndex = cmbCoVan.getSelectedIndex();
                String maCoVan = dsCoVan.get(phanCongIndex).getMaCoVan();
                String maLop = cmbLop.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                // int maNamHoc = Integer.parseInt(dsNamHoc.get(namHocIndex).getMaNamHoc());
                int maNamHoc = 1;
                int trangThai = cmbTrangThai.getSelectedIndex();

                PhanCongModel phanCong = new PhanCongModel(maCoVan, maLop, maNamHoc, trangThai);
                PhanCongCtrl.themPhanCong(phanCong);
                hienThiTatCaPhanCong();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn xóa phân công này!");

        if (flag) {
            try {
                int maPhanCong = Integer.parseInt(txtMaPhanCong.getText());
                PhanCongCtrl.xoaPhanCong(maPhanCong);
                hienThiTatCaPhanCong();
                DialogHelper.showMessage("Xóa phân công thành công");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed
        try {
            boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn sửa phân công này!");

            if (flag) {
                int maPhanCong = Integer.parseInt(txtMaPhanCong.getText());
                int phanCongIndex = cmbCoVan.getSelectedIndex();
                String maCoVan = dsCoVan.get(phanCongIndex).getMaCoVan();
                String maLop = cmbLop.getSelectedItem().toString();
                int namHocIndex = cmbNamHoc.getSelectedIndex();
                // int maNamHoc = Integer.parseInt(dsNamHoc.get(namHocIndex).getMaNamHoc());
                int maNamHoc = 2;
                int trangThai = cmbTrangThai.getSelectedIndex();

                PhanCongModel phanCong = new PhanCongModel(maCoVan, maLop, maNamHoc, maPhanCong, trangThai);
                PhanCongCtrl.capNhatPhanCong(phanCong);
                hienThiTatCaPhanCong();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuaButtonActionPerformed

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

    private void xuatDSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatDSButtonActionPerformed
        PhanCongCtrl.xuatFileExcel(dsPhanCong, "src/main/java/files/DSPhanCong.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_xuatDSButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSPhanCong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NhapMoiButton;
    private javax.swing.JButton SuaButton;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton XoaButton;
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
    private javax.swing.JButton xuatDSButton;
    // End of variables declaration//GEN-END:variables
}
