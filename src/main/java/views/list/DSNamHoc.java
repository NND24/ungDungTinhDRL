package views.list;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.NamHocModel;
import controllers.NamHocCtrl;
import utils.DialogHelper;
import utils.Validator;

public class DSNamHoc extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    private List<NamHocModel> dsNamHoc;
    private String namHocTam;

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
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        txtMaNamHoc.setText("");
        txtNamHoc.setText("");
        cmbTrangThaiHienThi.setSelectedIndex(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTrangThaiHienThi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNamHoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNamHoc = new javax.swing.JTextField();
        pnlNutLenh = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách năm học");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Năm học");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái");

        cmbTrangThaiHienThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ẩn", "Hiển thị" }));
        cmbTrangThaiHienThi.setSelectedIndex(1);

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

        pnlNutLenh.setBackground(new java.awt.Color(255, 255, 255));
        pnlNutLenh.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
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
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(70, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnXoa);

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(70, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnSua);

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnLamMoi);

        btnXuat.setBackground(new java.awt.Color(0, 102, 255));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất danh sách");
        btnXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnXuat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThaiHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addComponent(pnlNutLenh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTrangThaiHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(pnlNutLenh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if (!txtMaNamHoc.getText().isEmpty()) {
                DialogHelper.showError("Năm học đã tồn tại. Vui lòng nhập mới");
            } else if (txtNamHoc.getText().isEmpty()) {
                DialogHelper.showError("Năm học không được bỏ trống");
            } else if (!Validator.kiemTraNamHoc(txtNamHoc.getText())) {
                DialogHelper.showError("Năm học không đúng định dạng");
            } else if (NamHocCtrl.kiemTraNamHocTrung(txtNamHoc.getText())) {
                DialogHelper.showError("Năm học đã tồn tại. Vui lòng nhập mới");
            } else {
                String namHoc = txtNamHoc.getText();
                int trangThai = cmbTrangThaiHienThi.getSelectedIndex();

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
        try {
            if (txtMaNamHoc.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn năm học muốn xóa");
            } else {
                int maNamHoc = Integer.parseInt(txtMaNamHoc.getText());
                if (NamHocCtrl.kiemTraNamHocDaDuocSuDung(maNamHoc)) {
                    DialogHelper.showError("Năm học đã được sử dụng không thể xóa");
                } else {
                    if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa năm học này?")) {
                        NamHocCtrl.xoaNamHoc(maNamHoc);
                        hienThiDSNamHoc();
                        lamMoi();
                        DialogHelper.showMessage("Xóa năm học thành công");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaNamHoc.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn năm học muốn chỉnh sửa");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa năm học này?")) {
                if (txtNamHoc.getText().isEmpty()) {
                    DialogHelper.showError("Năm học không được bỏ trống");
                } else if (!Validator.kiemTraNamHoc(txtNamHoc.getText())) {
                    DialogHelper.showError("Năm học không đúng định dạng");
                } else if (!txtNamHoc.getText().equals(namHocTam) && NamHocCtrl.kiemTraNamHocDaDuocSuDung(Integer.parseInt(txtMaNamHoc.getText()))) {
                    DialogHelper.showError("Năm học đã được sử dụng không thể sửa năm học");
                } else {
                    int maNamHoc = Integer.parseInt(txtMaNamHoc.getText());
                    String namHoc = txtNamHoc.getText();
                    int trangThai = cmbTrangThaiHienThi.getSelectedIndex();

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
            namHocTam = namHoc.getNamHoc();
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
    private javax.swing.JPanel pnlNutLenh;
    private javax.swing.JTable tblDSNamHoc;
    private javax.swing.JTextField txtMaNamHoc;
    private javax.swing.JTextField txtNamHoc;
    // End of variables declaration//GEN-END:variables
}
