package views.list;

import controllers.NamHocCtrl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.NamHocModel;
import utils.DialogHelper;
import utils.Validator;

public class DSNamHoc extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NamHocModel> dsNamHoc;

    public DSNamHoc() {
        initComponents();
        tableModel = (DefaultTableModel) tblDSNamHoc.getModel();

        hienThiDSNamHoc();
    }

    private void hienThiDSNamHoc() {
        try {
            dsNamHoc = NamHocCtrl.timTatCaNamHoc();

            tableModel.setRowCount(0);
            dsNamHoc.forEach(namHoc -> {
                String trangThai = "";
                if (namHoc.getTrangThaiHienThi() == 0) {
                    trangThai = "Ẩn";
                } else {
                    trangThai = "Hiển thị";
                }

                tableModel.addRow(new Object[]{
                    namHoc.getMaNamHoc(), namHoc.getNamHoc(), trangThai});
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        txtMaNamHoc.setText("");
        txtNamHoc.setText("");
        cmbTrangThaiHienThi.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTrangThaiHienThi = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNamHoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNamHoc = new javax.swing.JTextField();
        btnXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách năm học");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Năm học");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái");

        cmbTrangThaiHienThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ẩn", "Hiển thị" }));

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

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(80, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        tblDSNamHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã năm học", "Năm học", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNamHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNamHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNamHoc);

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH NĂM HỌC");

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã năm học");

        txtMaNamHoc.setEditable(false);

        btnXuat.setBackground(new java.awt.Color(0, 102, 255));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất ");
        btnXuat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat.setPreferredSize(new java.awt.Dimension(70, 30));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThaiHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTrangThaiHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            String maNamHoc = txtMaNamHoc.getText();
            String namHoc = txtNamHoc.getText();
            int trangThai = cmbTrangThaiHienThi.getSelectedIndex();

            if (!maNamHoc.isEmpty()) {
                DialogHelper.showError("Năm học đã tồn tại. Vui lòng nhập mới");
            } else if (namHoc.isEmpty()) {
                DialogHelper.showError("Năm học không được bỏ trống");
            } else if (!Validator.kiemTraNamHoc(namHoc)) {
                DialogHelper.showError("Năm học không đúng định dạng");
            } else {
                NamHocModel nh = new NamHocModel(namHoc, trangThai);
                NamHocCtrl.themNamHoc(nh);
                DialogHelper.showMessage("Thêm năm học thành công!");
                hienThiDSNamHoc();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNamHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa năm học này?")) {
            try {
                String maNamHoc = txtMaNamHoc.getText();
                if (NamHocCtrl.kiemTraNamHocDaDuocSuDung(maNamHoc)) {
                    DialogHelper.showError("Năm học đã được sử dụng không thể xóa");
                } else {
                    NamHocCtrl.xoaNamHoc(maNamHoc);
                    hienThiDSNamHoc();
                    lamMoi();
                    DialogHelper.showMessage("Xóa năm học thành công");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa năm học này?")) {
                int maNamHoc = Integer.parseInt(txtMaNamHoc.getText());
                String namHoc = txtNamHoc.getText();
                int trangThai = cmbTrangThaiHienThi.getSelectedIndex();

                if (namHoc.isEmpty()) {
                    DialogHelper.showError("Năm học không được bỏ trống");
                } else if (!Validator.kiemTraNamHoc(namHoc)) {
                    DialogHelper.showError("Năm học không đúng định dạng");
                } else {
                    NamHocModel nh = new NamHocModel(maNamHoc, namHoc, trangThai);
                    NamHocCtrl.capNhatNamHoc(nh);
                    DialogHelper.showMessage("Cập nhật năm học thành công!");
                    hienThiDSNamHoc();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNamHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDSNamHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNamHocMouseClicked
        int selectedIndex = tblDSNamHoc.getSelectedRow();
        if (selectedIndex >= 0) {
            NamHocModel namHoc = dsNamHoc.get(selectedIndex);

            txtMaNamHoc.setText(Integer.toString(namHoc.getMaNamHoc()));
            txtNamHoc.setText(namHoc.getNamHoc());
            cmbTrangThaiHienThi.setSelectedIndex(namHoc.getTrangThaiHienThi());
        }
    }//GEN-LAST:event_tblDSNamHocMouseClicked

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        NamHocCtrl.xuatFileExcel(dsNamHoc, "src/main/java/files/DSNamHoc.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        hienThiDSNamHoc();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSNamHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cmbTrangThaiHienThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSNamHoc;
    private javax.swing.JTextField txtMaNamHoc;
    private javax.swing.JTextField txtNamHoc;
    // End of variables declaration//GEN-END:variables
}
