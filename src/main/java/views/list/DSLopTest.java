package views.list;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.LopModelTest;
import controllers.LopTestCtrl;
import utils.DialogHelper;

public class DSLopTest extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    private List<LopModelTest> dsLop;

    public DSLopTest() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) tblDSLop.getModel();

            dsLop = LopTestCtrl.timTatCaLop();
            hienThiDSLop();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
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

    private void lamMoi() {
        try {
            dsLop = LopTestCtrl.timTatCaLop();
            txtMaLop.setText("");
            txtKhoa.setText("");
            cmbTrangThai.setSelectedIndex(0);
            cmbNganh.setSelectedIndex(0);
            txtTimKiem.setText("");
            txtMaLop.setEnabled(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
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
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKhoa = new javax.swing.JTextField();
        cmbNganh = new javax.swing.JComboBox<>();
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
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Khóa");

        cmbNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Ngành---", "Công nghệ thông tin", "Kỹ thuật điện tử viễn thông" }));

        btnXuatDSBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDSBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDSBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDSBenhNhan.setText("Xuất danh sách");
        btnXuatDSBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDSBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDSBenhNhan.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXuatDSBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSBenhNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            String maLop = txtMaLop.getText();
            String nganh = cmbNganh.getSelectedItem().toString();
            String maNganh = "";
            if (nganh.equals("Công nghệ thông tin")) {
                maNganh = "CN";
            } else {
                maNganh = "KTDTVT";
            }
            String khoa = txtKhoa.getText();
            int trangThai = cmbTrangThai.getSelectedIndex();

            if (!txtMaLop.isEnabled()) {
                DialogHelper.showError("Lớp đã tồn tại. Vui lòng thêm mới");
            } else {
                LopModelTest lop = new LopModelTest(maLop, maNganh, "", khoa, trangThai);
                LopTestCtrl.themLop(lop);
                lamMoi();
                hienThiDSLop();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa lớp này")) {
                String maLop = txtMaLop.getText();
                String nganh = cmbNganh.getSelectedItem().toString();
                String maNganh = "";
                if (nganh.equals("Công nghệ thông tin")) {
                    maNganh = "CN";
                } else {
                    maNganh = "VT";
                }
                String khoa = txtKhoa.getText();
                int trangThai = cmbTrangThai.getSelectedIndex();

                LopModelTest lop = new LopModelTest(maLop, maNganh, "", khoa, trangThai);
                LopTestCtrl.capNhatLop(lop);
                lamMoi();
                hienThiDSLop();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa lớp này")) {
            try {
                String maLop = txtMaLop.getText();
                LopTestCtrl.xoaLop(maLop);
                lamMoi();
                hienThiDSLop();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        LopTestCtrl.xuatFileExcel(dsLop, "src/main/java/files/DSLop.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void tblDSLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSLopMouseClicked
        int selectedIndex = tblDSLop.getSelectedRow();
        if (selectedIndex >= 0) {
            txtMaLop.setEnabled(false);
            LopModelTest lop = dsLop.get(selectedIndex);

            txtMaLop.setText(lop.getMaLop());
            txtKhoa.setText(lop.getKhoa());
            cmbTrangThai.setSelectedIndex(lop.getTrangThaiHienThi());
            cmbNganh.setSelectedItem(lop.getTenNganh());
        }
    }//GEN-LAST:event_tblDSLopMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        hienThiDSLop();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        try {
            String tuKhoa = txtTimKiem.getText();

            if (tuKhoa.isEmpty()) {
                dsLop = LopTestCtrl.timTatCaLopHienThi();
                hienThiDSLop();
                return;
            }

            dsLop = LopTestCtrl.timKiemLop(tuKhoa);
            hienThiDSLop();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSLopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSLopTest().setVisible(true);
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
    private javax.swing.JTable tblDSLop;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
