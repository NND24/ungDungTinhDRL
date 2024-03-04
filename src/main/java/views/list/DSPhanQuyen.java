package views.list;

import controllers.PhanCongCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.NamHocModel;
import models.PhanCongModel;
import utils.Validator;

public class DSPhanQuyen extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<PhanCongModel> dsPhanCong = new ArrayList<>();
//    List<LopModel> dsLop = new ArrayList<>();
//    List<CoVanModel> dsCoVan = new ArrayList<>();
    List<NamHocModel> dsNamHoc = new ArrayList<>();

    public DSPhanQuyen() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSPhanCong.getModel();

            hienThiTatCaPhanCong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCoVan() {
//        try {
//            dsCoVan = CoVanCtrl.timTatNhomDichVuCLS();
//            cmbCoVan.removeAllItems();
//            cmbCoVan.addItem("---Cố vấn---");
//
//            dsCoVan.forEach(cv -> {
//                String coVan = cv.getMaNhomDichVu();
//                cmbCoVan.addItem(coVan);
//            });
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DSPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void hienThiDSLop() {
//        try {
//            dsLop = LopCtrl.timTatNhomDichVuCLS();
//            cmbLop.removeAllItems();
//            cmbLop.addItem("---Lớp---");
//
//            dsLop.forEach(lop -> {
//                cmbLop.addItem(lop.getLop());
//            });
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DSPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void hienThiDSNamHoc() {
//        try {
//            dsNamHoc = NamHocCtrl.timTatNhomDichVuCLS();
//            cmbNamHoc.removeAllItems();
//            cmbNamHoc.addItem("---Năm học---");
//
//            dsNamHoc.forEach(nh -> {
//                String namHoc = nh.getNamHoc();
//                cmbNamHoc.addItem(namHoc);
//            });
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DSPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void hienThiTatCaPhanCong() throws ClassNotFoundException {
        dsPhanCong = PhanCongCtrl.timTatCaPhanCong();

        tableModel.setRowCount(0);

        dsPhanCong.forEach(pc -> {
            tableModel.addRow(new Object[]{pc.getTenCoVan(), pc.getTenLop(),
                pc.getNamHoc()});
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

        jButton3 = new javax.swing.JButton();
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

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách dịch vụ cận lâm sàn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 436));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên cố vấn");

        tblDSPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên cố vấn", "Lớp", "Năm học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        cmbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Lớp---", "D21CQCN01-N", "D21CQCN02-N" }));

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
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        cmbCoVan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Cố vấn---", "cv01" }));

        cmbNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Năm học---", "2022-2023", "2023-2024" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCoVan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cmbNamHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NhapMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapMoiButtonActionPerformed
        try {
            lamMoi();
            hienThiTatCaPhanCong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanQuyen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapMoiButtonActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed

    }//GEN-LAST:event_ThemButtonActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed

    }//GEN-LAST:event_XoaButtonActionPerformed

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed

    }//GEN-LAST:event_SuaButtonActionPerformed

    private void tblDSPhanCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhanCongMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSPhanCong.getSelectedRow();
        if (selectedIndex >= 0) {
            PhanCongModel pc = dsPhanCong.get(selectedIndex);

            cmbCoVan.setSelectedItem(pc.getTenCoVan());
            cmbLop.setSelectedItem(pc.getTenLop());
            cmbNamHoc.setSelectedItem(pc.getNamHoc());
        }
    }//GEN-LAST:event_tblDSPhanCongMouseClicked

    private void xuatDSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatDSButtonActionPerformed

    }//GEN-LAST:event_xuatDSButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSPhanQuyen().setVisible(true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSPhanCong;
    private javax.swing.JButton xuatDSButton;
    // End of variables declaration//GEN-END:variables
}
