package views.list;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.LopModel;
import models.NganhModel;
import controllers.LopCtrl;
import controllers.NganhCtrl;
import utils.DialogHelper;
import utils.Validator;

public class DSLop extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    private List<LopModel> dsLop;
    private List<NganhModel> dsNganh;

    public DSLop() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) tblDSLop.getModel();

            dsLop = LopCtrl.timTatCaLop();
            hienThiDSNganh();
            hienThiDSLop();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLop() {
        tableModel.setRowCount(0);
        dsLop.forEach(lop -> {
            String trangThai = "";
            if (lop.getTrangThaiHienThi() == 0) {
                trangThai = "Ẩn";
            } else {
                trangThai = "Hiển thị";
            }

            tableModel.addRow(new Object[]{
                lop.getMaLop(), lop.getTenNganh(), lop.getKhoa(),
                trangThai});
        });
    }

    private void hienThiDSNganh() {
        try {
            dsNganh = NganhCtrl.timTatCaNganhHienThi();
            cmbNganh.removeAllItems();
            dsNganh.forEach(nganh -> {
                cmbNganh.addItem(nganh.getTenNganh());
            });
            cmbNganh.addItem("---Ngành---");
            cmbNganh.setSelectedItem("---Ngành---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        txtMaLop.setText("");
        txtKhoa.setText("");
        cmbTrangThai.setSelectedIndex(1);
        cmbNganh.setSelectedIndex(0);
        txtMaLop.setEnabled(true);
        cmbNganh.setSelectedItem("---Ngành---");
    }

    private void timKiemLop() {
        try {
            String tuKhoa = txtTimKiem.getText();

            if (tuKhoa.isEmpty()) {
                dsLop = LopCtrl.timTatCaLop();
                hienThiDSLop();
                return;
            }

            dsLop = LopCtrl.timKiemLop(tuKhoa);
            hienThiDSLop();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSLop = new javax.swing.JTable();
        txtMaLop = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKhoa = new javax.swing.JTextField();
        cmbNganh = new javax.swing.JComboBox<>();
        pnlNutLenh = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách lớp học");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã Lớp");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ngành");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái");

        tblDSLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã lớp", "Ngành", "Khóa", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSLop);

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ẩn", "Hiển thị" }));
        cmbTrangThai.setSelectedIndex(1);

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH LỚP");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Khóa");

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

        btnXuatDSBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDSBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDSBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDSBenhNhan.setText("Xuất danh sách");
        btnXuatDSBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDSBenhNhan.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXuatDSBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSBenhNhanActionPerformed(evt);
            }
        });
        pnlNutLenh.add(btnXuatDSBenhNhan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addComponent(pnlNutLenh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(pnlNutLenh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
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
            if (cmbNganh.getSelectedItem().equals("---Ngành---")) {
                DialogHelper.showError("Vui lòng chọn ngành!");
            } else if (!txtMaLop.isEnabled()) {
                DialogHelper.showError("Lớp đã tồn tại. Vui lòng thêm mới!");
            } else if (txtMaLop.getText().isEmpty()) {
                DialogHelper.showError("Mã lớp không được bỏ trống!");
            } else if (LopCtrl.kiemTraMaLopDaTonTai(txtMaLop.getText())) {
                DialogHelper.showError("Mã lớp đã tồn tại!");
            } else if (txtKhoa.getText().isEmpty()) {
                DialogHelper.showError("Khóa không được bỏ trống!");
            } else if (!Validator.isIntegerString(txtKhoa.getText())) {
                DialogHelper.showError("Khóa không hợp lệ!");
            } else if (!Validator.kiemTraNam(Integer.parseInt(txtKhoa.getText()))) {
                DialogHelper.showError("Khóa không hợp lệ!");
            } else {
                String maLop = txtMaLop.getText();
                int nganhIndex = cmbNganh.getSelectedIndex();
                String maNganh = dsNganh.get(nganhIndex).getMaNganh();
                String khoa = txtKhoa.getText();
                int trangThai = cmbTrangThai.getSelectedIndex();

                LopModel lop = new LopModel(maLop, maNganh, "", khoa, trangThai);
                LopCtrl.themLop(lop);
                lamMoi();
                timKiemLop();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaLop.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn lớp muốn chỉnh sửa");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa lớp này")) {
                if (cmbNganh.getSelectedItem().equals("---Ngành---")) {
                    DialogHelper.showError("Vui lòng chọn ngành!");
                } else if (txtKhoa.getText().isEmpty()) {
                    DialogHelper.showError("Khóa không được bỏ trống!");
                } else if (!Validator.isIntegerString(txtKhoa.getText())) {
                    DialogHelper.showError("Khóa không hợp lệ!");
                } else if (!Validator.kiemTraNam(Integer.parseInt(txtKhoa.getText()))) {
                    DialogHelper.showError("Khóa không hợp lệ!");
                } else {
                    String maLop = txtMaLop.getText();
                    int nganhIndex = cmbNganh.getSelectedIndex();
                    String maNganh = dsNganh.get(nganhIndex).getMaNganh();
                    String khoa = txtKhoa.getText();
                    int trangThai = cmbTrangThai.getSelectedIndex();

                    LopModel lop = new LopModel(maLop, maNganh, "", khoa, trangThai);
                    LopCtrl.capNhatLop(lop);
                    lamMoi();
                    timKiemLop();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (txtMaLop.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn lớp muốn xóa");
            } else if (LopCtrl.kiemTraLopDaDuocSuDung(txtMaLop.getText())) {
                DialogHelper.showError("Lớp đã có sinh viên không thể xóa!");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa lớp này")) {
                    String maLop = txtMaLop.getText();
                    LopCtrl.xoaLop(maLop);
                    lamMoi();
                    timKiemLop();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DSLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        LopCtrl.xuatFileExcel(dsLop, "src/main/java/files/DSLop.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void tblDSLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSLopMouseClicked
        int selectedIndex = tblDSLop.getSelectedRow();
        if (selectedIndex >= 0) {
            txtMaLop.setEnabled(false);
            LopModel lop = dsLop.get(selectedIndex);

            txtMaLop.setText(lop.getMaLop());
            txtKhoa.setText(lop.getKhoa());
            cmbTrangThai.setSelectedIndex(lop.getTrangThaiHienThi());
            cmbNganh.setSelectedItem(lop.getTenNganh());
        }
    }//GEN-LAST:event_tblDSLopMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        txtTimKiem.setText("");
        timKiemLop();
        hienThiDSNganh();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        timKiemLop();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSLop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JComboBox<String> cmbNganh;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlNutLenh;
    private javax.swing.JTable tblDSLop;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
