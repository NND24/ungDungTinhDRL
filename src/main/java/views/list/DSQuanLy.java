package views.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.QuanLyModel;
import models.TaiKhoanModel;
import controllers.QuanLyCtrl;
import controllers.TaiKhoanCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSQuanLy extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private List<QuanLyModel> dsQuanLy = new ArrayList<>();

    public DSQuanLy() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSQuanLy.getModel();
            dsQuanLy = QuanLyCtrl.timTatCaQuanLy();
            hienThiDSQuanLy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoi() {
        txtMaQuanLy.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtQueQuan.setText("");
        cmbGioiTinh.setSelectedIndex(0);
        txtNgaySinh.setText("");
        txtCanCuoc.setText("");
        txtSoDienThoai.setText("");
        cmbDaNghi.setSelectedIndex(0);
    }

    private void hienThiDSQuanLy() throws ClassNotFoundException {
        tableModel.setRowCount(0);

        dsQuanLy.forEach(ql -> {
            String gioiTinh = "";
            if (ql.getGioiTinh().equals("0")) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            String trangThai = "";
            if (ql.getDaNghi() == 0) {
                trangThai = "Còn làm";
            } else {
                trangThai = "Đã nghỉ";
            }
            tableModel.addRow(new Object[]{
                ql.getMaQuanLy(), ql.getHoTen(),
                ql.getEmail(), gioiTinh, ql.getSoDienThoai(),
                ql.getNgaySinh(), ql.getCanCuoc(), ql.getQueQuan(), trangThai});
        });
    }

    private void timKiemQuanLy() {
        try {
            String tuKhoa = txtTimKiem.getText();

            if (tuKhoa.isEmpty()) {
                dsQuanLy = QuanLyCtrl.timTatCaQuanLy();
                hienThiDSQuanLy();
                return;
            }

            dsQuanLy = QuanLyCtrl.timKiemQuanLy(tuKhoa);
            hienThiDSQuanLy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaQuanLy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSQuanLy = new javax.swing.JTable();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cmbDaNghi = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jFrame1.setBackground(new java.awt.Color(51, 255, 51));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1140, 616));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 616));

        jPanel4.setPreferredSize(new java.awt.Dimension(1140, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN QUẢN LÝ");

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa thông tin");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(125, 25));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa quản lý");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(98, 25));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm quản lý");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(0, 102, 255));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất danh sách");
        btnXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã quản lý");

        txtMaQuanLy.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        txtEmail.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày sinh");

        txtNgaySinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgaySinhFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Quê quán");

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH QUẢN LÝ");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblDSQuanLy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã quản lý", "Họ tên", "Email", "Giới tính", "Số điện thoại", "Ngày sinh", "Căn cước", "Quê quán", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSQuanLyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSQuanLy);

        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Trạng thái");

        cmbDaNghi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn làm", "Đã nghỉ" }));

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("(*)");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("(*)");

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel15))
                            .addComponent(jLabel16)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12))
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel14))
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDaNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDaNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (!txtMaQuanLy.getText().isEmpty()) {
                DialogHelper.showError("Quản lý đã tồn tại. Vui lòng nhập mới");
            } else if (txtHoTen.getText().isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống!");
            } else if (txtNgaySinh.getText().isEmpty()) {
                DialogHelper.showError("Ngày sinh không được để trống!");
            } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
            } else if (txtSoDienThoai.getText().isEmpty()) {
                DialogHelper.showError("Số điện thoại không được để trống!");
            } else if (!txtSoDienThoai.getText().isEmpty() && !Validator.isValidPhoneNumber(txtSoDienThoai.getText())) {
                DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
            } else if (QuanLyCtrl.kiemTraSoDienThoaiTrung("", txtSoDienThoai.getText())) {
                DialogHelper.showError("Số điện thoại đã tồn tại!");
            } else if (txtCanCuoc.getText().isEmpty()) {
                DialogHelper.showError("Căn cước không được để trống!");
            } else if (!txtCanCuoc.getText().isEmpty() && !Validator.isValidCccd(txtCanCuoc.getText())) {
                DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
            } else if (QuanLyCtrl.kiemTraCanCuocTrung("", txtCanCuoc.getText())) {
                DialogHelper.showError("Căn cước đã tồn tại!");
            } else {
                try {
                    String hoTen = txtHoTen.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String canCuoc = txtCanCuoc.getText();

                    String soLuongNguoiFormatted = String.format("%03d", (QuanLyCtrl.layMaQuanLyCuoiCung() + 1));
                    String maQuanLy = "admin" + soLuongNguoiFormatted;
                    String idTaiKhoan = GenerateCode.generateIdTaiKhoan();
                    java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
                    java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

                    String gioiTinh = Integer.toString(cmbGioiTinh.getSelectedIndex());
                    String email = maQuanLy.toLowerCase() + "@ptithcm.edu.vn";
                    String matKhau = maQuanLy.toLowerCase() + "#" + txtNgaySinh.getText().replace("/", "");
                    String queQuan = txtQueQuan.getText();
                    String chucVu = "QL";
                    int daNghi = cmbDaNghi.getSelectedIndex();

                    TaiKhoanModel tk = new TaiKhoanModel(idTaiKhoan, maQuanLy, matKhau, chucVu);
                    TaiKhoanCtrl.themTaiKhoan(tk);

                    QuanLyModel sv = new QuanLyModel(maQuanLy, idTaiKhoan, hoTen, email, gioiTinh, soDienThoai, canCuoc, queQuan, sqlNgaySinh, daNghi);
                    QuanLyCtrl.themQuanLy(sv);
                    lamMoi();
                    timKiemQuanLy();
                    DialogHelper.showMessage("Thêm quản lý thành công");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblDSQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSQuanLyMouseClicked
        int selectedIndex = tblDSQuanLy.getSelectedRow();
        if (selectedIndex >= 0) {
            QuanLyModel ql = dsQuanLy.get(selectedIndex);

            txtMaQuanLy.setText(ql.getMaQuanLy());
            txtHoTen.setText(ql.getHoTen());
            txtQueQuan.setText(ql.getQueQuan());
            cmbGioiTinh.setSelectedIndex(Integer.parseInt(ql.getGioiTinh()));
            txtNgaySinh.setText(dateFormat.format(ql.getNgaySinh()));
            txtCanCuoc.setText(ql.getCanCuoc());
            txtSoDienThoai.setText(ql.getSoDienThoai());
            txtEmail.setText(ql.getEmail());
            cmbDaNghi.setSelectedIndex(ql.getDaNghi());
        }
    }//GEN-LAST:event_tblDSQuanLyMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaQuanLy.getText().isEmpty()) {
            DialogHelper.showError("Vui lòng chọn quản lý muốn xóa");
        } else if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa quản lý này?")) {
            String maQuanLy = txtMaQuanLy.getText();
            QuanLyCtrl.xoaQuanLy(maQuanLy);
            TaiKhoanCtrl.xoaTaiKhoan(maQuanLy);
            lamMoi();
            timKiemQuanLy();
            DialogHelper.showMessage("Xóa quản lý thành công");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaQuanLy.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn quản lý muốn chỉnh sửa");
            } else if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa thông tin quản lý này?")) {
                if (txtHoTen.getText().isEmpty()) {
                    DialogHelper.showError("Họ tên không được để trống!");
                } else if (txtNgaySinh.getText().isEmpty()) {
                    DialogHelper.showError("Ngày sinh không được để trống!");
                } else if (!Validator.isValidDate(txtNgaySinh.getText())) {
                    DialogHelper.showError("Ngày sinh không đúng định dạng! Vui lòng nhập lại.");
                } else if (txtSoDienThoai.getText().isEmpty()) {
                    DialogHelper.showError("Số điện thoại không được để trống!");
                } else if (!txtSoDienThoai.getText().isEmpty() && !Validator.isValidPhoneNumber(txtSoDienThoai.getText())) {
                    DialogHelper.showError("Số điện thoại không hợp lệ! Vui lòng nhập lại số điện thoại");
                } else if (QuanLyCtrl.kiemTraSoDienThoaiTrung(txtMaQuanLy.getText(), txtSoDienThoai.getText())) {
                    DialogHelper.showError("Số điện thoại đã tồn tại!");
                } else if (txtCanCuoc.getText().isEmpty()) {
                    DialogHelper.showError("Căn cước không được để trống!");
                } else if (!txtCanCuoc.getText().isEmpty() && !Validator.isValidCccd(txtCanCuoc.getText())) {
                    DialogHelper.showError("Căn cước không hợp lệ! Vui lòng nhập lại căn cước");
                } else if (QuanLyCtrl.kiemTraCanCuocTrung(txtMaQuanLy.getText(), txtCanCuoc.getText())) {
                    DialogHelper.showError("Căn cước đã tồn tại!");
                } else {
                    String maQuanLy = txtMaQuanLy.getText();
                    String hoTen = txtHoTen.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String canCuoc = txtCanCuoc.getText();
                    String email = txtEmail.getText();
                    java.util.Date ngaySinh = dateFormat.parse(txtNgaySinh.getText());
                    java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());
                    String gioiTinh = Integer.toString(cmbGioiTinh.getSelectedIndex());
                    String queQuan = txtQueQuan.getText();
                    int daNghi = cmbDaNghi.getSelectedIndex();

                    QuanLyModel ql = new QuanLyModel(maQuanLy, hoTen, email, gioiTinh, soDienThoai, canCuoc, queQuan, sqlNgaySinh, daNghi);
                    QuanLyCtrl.capNhatQuanLy(ql);
                    lamMoi();
                    timKiemQuanLy();
                    DialogHelper.showMessage("Sửa quản lý thành công");
                }
            }
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            lamMoi();
            txtTimKiem.setText("");
            hienThiDSQuanLy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtNgaySinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgaySinhFocusLost
        if (!Validator.isValidDate(txtNgaySinh.getText())) {
            DialogHelper.showError("Ngày sinh không hợp lệ. Vui lòng nhập lại!");
            txtNgaySinh.requestFocus();
        }
    }//GEN-LAST:event_txtNgaySinhFocusLost

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        QuanLyCtrl.xuatFileExcel(dsQuanLy, "src/main/java/files/DSQuanLy.xlsx");
        DialogHelper.showMessage("Xuất danh sách thành công!");
    }//GEN-LAST:event_btnXuatActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        timKiemQuanLy();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cmbDaNghi;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSQuanLy;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaQuanLy;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
