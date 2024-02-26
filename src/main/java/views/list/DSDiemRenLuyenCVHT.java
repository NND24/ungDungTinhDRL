package views.list;

import controllers.DiemRenLuyenCtrl;
import controllers.PhanCongCtrl;
import controllers.SinhVienCtrlTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DiemRenLuyenModel;
import models.SinhVienModelTest;
import utils.DialogHelper;
import views.main.DangNhap;
import views.main.FormChamDiemBCS;
import views.main.FormChamDiemCVHT;
import views.main.FormChamDiemSV;

public class DSDiemRenLuyenCVHT extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    String coVanCham = "";

    public DSDiemRenLuyenCVHT() {
        initComponents();
        tableModel = (DefaultTableModel) dsDiemRenLuyenTable.getModel();
        hienThiDSLop();
    }

    private void hienThiDSLop() {
        try {
            List<String> dsLop = PhanCongCtrl.timDSLop(DangNhap.currentUserId);

            timKiemLopComboBox.removeAllItems();
            timKiemLopComboBox.addItem("---Lớp---");
            dsLop.forEach(lop -> {
                timKiemLopComboBox.addItem(lop);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDRLHienTai() throws ClassNotFoundException {
        String tenLop = timKiemLopComboBox.getSelectedItem().toString();
        if (!tenLop.equals("---Lớp---")) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            String hocKy = "";
            if (currentMonth == 9 || currentMonth == 10 || currentMonth == 11 || currentMonth == 12 || currentMonth == 1) {
                hocKy = "1";
            } else {
                hocKy = "2";
            }

            String namHoc = "";
            if (currentMonth == 9 || currentMonth == 10 || currentMonth == 11 || currentMonth == 12 || currentMonth == 1) {
                if (currentMonth == 1) {
                    namHoc = (currentYear - 1) + "-" + currentYear;

                } else {
                    namHoc = currentYear + "-" + (currentYear + 1);
                }

            } else {
                namHoc = (currentYear - 1) + "-" + currentYear;
            }

            dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", tenLop, hocKy, namHoc);
            tableModel.setRowCount(0);

            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                tableModel.addRow(new Object[]{
                    drl.getMaSinhVien(), drl.getHoTen(),
                    drl.getD1(), drl.getD2(), drl.getD3(),
                    drl.getD4(), drl.getD5(), drl.getTongDiem(),
                    drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                    drl.getTrangThaiCham()});

                if (drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn kết thúc chấm")) {
                    coVanCham = drl.getTrangThaiCham();
                    break;
                }
            }

        } else {
            lamMoi();
            dsDiemRenLuyenTable.removeAll();
        }
    }

    void lamMoi() {
        maSinhVienTextField.setText("");
        hoTenTextField.setText("");
        diemTieuChi1TextField.setText("");
        diemTieuChi2TextField.setText("");
        diemTieuChi3TextField.setText("");
        diemTieuChi4TextField.setText("");
        diemTieuChi5TextField.setText("");
        tongDiemTextField.setText("");
        xepLoaiTextField.setText("");
        hocKyTextField.setText("");
        namHocTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        xemDiemButton = new javax.swing.JButton();
        lamMoiButton = new javax.swing.JButton();
        chamLaiButton = new javax.swing.JButton();
        ketThucChamButton = new javax.swing.JButton();
        duyetTatCaButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        maSinhVienTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hoTenTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsDiemRenLuyenTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        diemTieuChi1TextField = new javax.swing.JTextField();
        diemTieuChi2TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        diemTieuChi3TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        diemTieuChi4TextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        diemTieuChi5TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        namHocTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        xepLoaiTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        hocKyTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tongDiemTextField = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        timKiemTheoHocKiComboBox = new javax.swing.JComboBox<>();
        TimKiemTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        timKiemLopComboBox = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        timKiemTheoNamHocComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN ");

        xemDiemButton.setBackground(new java.awt.Color(0, 102, 255));
        xemDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xemDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        xemDiemButton.setText("Xem/chấm điểm");
        xemDiemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xemDiemButton.setPreferredSize(new java.awt.Dimension(120, 25));
        xemDiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemDiemButtonActionPerformed(evt);
            }
        });

        lamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        lamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        lamMoiButton.setText("Làm mới");
        lamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lamMoiButton.setPreferredSize(new java.awt.Dimension(120, 25));
        lamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiButtonActionPerformed(evt);
            }
        });

        chamLaiButton.setBackground(new java.awt.Color(0, 102, 255));
        chamLaiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chamLaiButton.setForeground(new java.awt.Color(255, 255, 255));
        chamLaiButton.setText("Chấm lại");
        chamLaiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chamLaiButton.setPreferredSize(new java.awt.Dimension(120, 25));
        chamLaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamLaiButtonActionPerformed(evt);
            }
        });

        ketThucChamButton.setBackground(new java.awt.Color(0, 102, 255));
        ketThucChamButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ketThucChamButton.setForeground(new java.awt.Color(255, 255, 255));
        ketThucChamButton.setText("Kết thúc chấm");
        ketThucChamButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ketThucChamButton.setPreferredSize(new java.awt.Dimension(120, 25));
        ketThucChamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketThucChamButtonActionPerformed(evt);
            }
        });

        duyetTatCaButton.setBackground(new java.awt.Color(0, 102, 255));
        duyetTatCaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        duyetTatCaButton.setForeground(new java.awt.Color(255, 255, 255));
        duyetTatCaButton.setText("Duyệt tất cả");
        duyetTatCaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        duyetTatCaButton.setPreferredSize(new java.awt.Dimension(120, 25));
        duyetTatCaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duyetTatCaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 529, Short.MAX_VALUE)
                .addComponent(xemDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ketThucChamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(chamLaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(duyetTatCaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(xemDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lamMoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chamLaiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ketThucChamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(duyetTatCaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        maSinhVienTextField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        dsDiemRenLuyenTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm tiêu chí 1", "Điểm tiêu chí 2", "Điểm tiêu chí 3", "Điểm tiêu chí 4", "Điểm tiêu chí 5", "Tổng điểm", "Xếp loại", "Học kỳ", "Năm học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dsDiemRenLuyenTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsDiemRenLuyenTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsDiemRenLuyenTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsDiemRenLuyenTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiêu chí 1");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiêu chí 2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiêu chí 3");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiêu chí 4");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiêu chí 5");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng điểm");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Xếp loại");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Học kỳ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Năm học");

        jPanel11.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("DANH SÁCH ĐIỂM RÈN LUYỆN CỦA LỚP");

        timKiemTheoHocKiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        timKiemTheoHocKiComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemTheoHocKiComboBoxActionPerformed(evt);
            }
        });

        TimKiemTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TimKiemTextFieldKeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Tìm kiếm");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Năm học");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Học kì");

        timKiemLopComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Lớp---", "D21CQCN01-N", "D21CQCN02-N" }));
        timKiemLopComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemLopComboBoxActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Lớp");

        timKiemTheoNamHocComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Năm học---", "2022-2023", "2023-2024" }));
        timKiemTheoNamHocComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemTheoNamHocComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TimKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timKiemLopComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel28)
                .addGap(6, 6, 6)
                .addComponent(timKiemTheoNamHocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(4, 4, 4)
                .addComponent(timKiemTheoHocKiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timKiemTheoHocKiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(TimKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(timKiemLopComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(timKiemTheoNamHocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tongDiemTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namHocTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTieuChi3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xepLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(diemTieuChi2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(diemTieuChi3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diemTieuChi4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(diemTieuChi5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tongDiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xepLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(namHocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dsDiemRenLuyenTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsDiemRenLuyenTableMouseClicked
        int selectedIndex = dsDiemRenLuyenTable.getSelectedRow();
        if (selectedIndex >= 0) {
            DiemRenLuyenModel drl = dsDiemRenLuyen.get(selectedIndex);

            maSinhVienTextField.setText(drl.getMaSinhVien());
            hoTenTextField.setText(drl.getHoTen());
            diemTieuChi1TextField.setText(Float.toString(drl.getD1()));
            diemTieuChi2TextField.setText(Integer.toString(drl.getD2()));
            diemTieuChi3TextField.setText(Integer.toString(drl.getD3()));
            diemTieuChi4TextField.setText(Integer.toString(drl.getD4()));
            diemTieuChi5TextField.setText(Integer.toString(drl.getD5()));
            tongDiemTextField.setText(Float.toString(drl.getTongDiem()));
            xepLoaiTextField.setText(drl.getXepLoai());
            hocKyTextField.setText(drl.getHocKy());
            namHocTextField.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_dsDiemRenLuyenTableMouseClicked

    private void xemDiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemDiemButtonActionPerformed
        String maSinhVien = maSinhVienTextField.getText();
        if (maSinhVien.isEmpty()) {
            DialogHelper.showError("Chưa chọn học kỳ, năm học muốn xem. Vui lòng chọn");
        } else {
            FormChamDiemCVHT.Instance.maSVTextField.setText("");

            FormChamDiemCVHT.Instance.maSVTextField.setText(maSinhVienTextField.getText());
            FormChamDiemCVHT.Instance.nameTextField.setText(hoTenTextField.getText());
            FormChamDiemCVHT.Instance.semesterTextField.setText(hocKyTextField.getText());
            FormChamDiemCVHT.Instance.scholasticTextField.setText(namHocTextField.getText());
        }
    }//GEN-LAST:event_xemDiemButtonActionPerformed

    private void lamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiButtonActionPerformed
        lamMoi();
    }//GEN-LAST:event_lamMoiButtonActionPerformed

    private void chamLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamLaiButtonActionPerformed
        String hocKy = "";
        String namHoc = "";
        for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
            try {
                if (coVanCham.equalsIgnoreCase("Cố vấn kết thúc chấm")) {
                    DialogHelper.showError("Hết thời gian chấm. Vui lòng liên hệ với phòng quản lý!");
                } else {
                    DiemRenLuyenCtrl.thayDoiTrangThaiCham("Ban cán sự đã chấm", sv.getMaSinhVien(), sv.getHocKy(), sv.getNamHoc());
                    hocKy = sv.getHocKy();
                    namHoc = sv.getNamHoc();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!coVanCham.equalsIgnoreCase("Cố vấn kết thúc chấm")) {
            String message = "Chấm lại điểm rèn luyện học kỳ: " + hocKy + ", năm học: " + namHoc;
            DialogHelper.showMessage(message);
        }
    }//GEN-LAST:event_chamLaiButtonActionPerformed

    private void ketThucChamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketThucChamButtonActionPerformed
        String hocKy = "";
        String namHoc = "";
        for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
            try {
                if (coVanCham.equalsIgnoreCase("Cố vấn kết thúc chấm")) {
                    DialogHelper.showError("Hết thời gian chấm. Vui lòng liên hệ với phòng quản lý!");
                } else {
                    DiemRenLuyenCtrl.thayDoiTrangThaiCham("Ban cán sự kết thúc chấm", sv.getMaSinhVien(), sv.getHocKy(), sv.getNamHoc());
                    hocKy = sv.getHocKy();
                    namHoc = sv.getNamHoc();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!coVanCham.equalsIgnoreCase("Cố vấn kết thúc chấm")) {
            String message = "Kết thúc chấm điểm rèn luyện học kỳ: " + hocKy + ", năm học: " + namHoc;
            DialogHelper.showMessage(message);
        }
    }//GEN-LAST:event_ketThucChamButtonActionPerformed

    private void duyetTatCaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duyetTatCaButtonActionPerformed
        boolean flag = DialogHelper.showConfirmation("Thao tác này sẽ duyệt điểm của cả lớp. Bạn có chắc muốn thực hiện thao tác này!");

        if (flag) {
            String hocKy = timKiemTheoHocKiComboBox.getSelectedItem().toString();
            String namHoc = timKiemTheoNamHocComboBox.getSelectedItem().toString();
            String lop = timKiemLopComboBox.getSelectedItem().toString();

            if (lop.equals("---Lớp---") || namHoc.equals("---Năm học---")) {
                DialogHelper.showError("Chưa chọn lớp học, năm học!");
            } else {

                boolean coVanDaCham = false;
                for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                    if (drl.getTrangThaiCham().equals("Quản lý kết thúc chấm")) {
                        coVanDaCham = true;
                        break;
                    }
                }

                if (coVanDaCham) {
                    DialogHelper.showError("Đã kết thúc thời gian chấm điểm");
                } else {
                    for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                        try {
                            DiemRenLuyenModel diemRenLuyenBCS = DiemRenLuyenCtrl.timDRLDayDu(drl.getMaSinhVien(), hocKy, namHoc, "BanCanSu");
                            DiemRenLuyenModel diem = new DiemRenLuyenModel(hocKy, namHoc, "CoVan", diemRenLuyenBCS.getXepLoai(), "Cố vấn đã chấm", diemRenLuyenBCS.getTongDiem(), diemRenLuyenBCS.getD11(), diemRenLuyenBCS.getD12a(), diemRenLuyenBCS.getD12b(), diemRenLuyenBCS.getD12c(), diemRenLuyenBCS.getD12d(), diemRenLuyenBCS.getD12e(), diemRenLuyenBCS.getD12g(), diemRenLuyenBCS.getD13(), diemRenLuyenBCS.getD13a(), diemRenLuyenBCS.getD13b(), diemRenLuyenBCS.getD13c(), diemRenLuyenBCS.getD13d(), diemRenLuyenBCS.getD14(), diemRenLuyenBCS.getD15(), diemRenLuyenBCS.getD1(), diemRenLuyenBCS.getD21(), diemRenLuyenBCS.getD21a(), diemRenLuyenBCS.getD21b(), diemRenLuyenBCS.getD22a(), diemRenLuyenBCS.getD22b(), diemRenLuyenBCS.getD23a(), diemRenLuyenBCS.getD23b(), diemRenLuyenBCS.getD2(), diemRenLuyenBCS.getD31(), diemRenLuyenBCS.getD32(), diemRenLuyenBCS.getD33(), diemRenLuyenBCS.getD34(), diemRenLuyenBCS.getD35(), diemRenLuyenBCS.getD3(), diemRenLuyenBCS.getD41(), diemRenLuyenBCS.getD42(), diemRenLuyenBCS.getD43(), diemRenLuyenBCS.getD44(), diemRenLuyenBCS.getD45(), diemRenLuyenBCS.getD46(), diemRenLuyenBCS.getD4(), diemRenLuyenBCS.getD51(), diemRenLuyenBCS.getD52(), diemRenLuyenBCS.getD53(), diemRenLuyenBCS.getD5(), diemRenLuyenBCS.getMaSinhVien());
                            DiemRenLuyenCtrl.chamDiemSV(diem);
                            DiemRenLuyenCtrl.thayDoiTrangThaiCham("Cố vấn đã chấm", diemRenLuyenBCS.getMaSinhVien(), hocKy, namHoc);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_duyetTatCaButtonActionPerformed

    private void timKiemTheoNamHocComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemTheoNamHocComboBoxActionPerformed
        try {
            String tuKhoa = TimKiemTextField.getText();
            String hocKy = timKiemTheoHocKiComboBox.getSelectedItem().toString();
            String namHoc = timKiemTheoNamHocComboBox.getSelectedItem().toString();
            String lop = timKiemLopComboBox.getSelectedItem().toString();

            if (namHoc.equals("---Năm học---")) {
                timKiemTheoHocKiComboBox.setSelectedIndex(0);
                tableModel.setRowCount(0);
            } else {
                dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop(tuKhoa, lop, hocKy, namHoc);
                tableModel.setRowCount(0);

                dsDiemRenLuyen.forEach(drl -> {
                    tableModel.addRow(new Object[]{
                        drl.getMaSinhVien(), drl.getHoTen(),
                        drl.getD1(), drl.getD2(), drl.getD3(),
                        drl.getD4(), drl.getD5(), drl.getTongDiem(),
                        drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                        drl.getTrangThaiCham()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timKiemTheoNamHocComboBoxActionPerformed

    private void timKiemLopComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemLopComboBoxActionPerformed
        if (timKiemLopComboBox.getSelectedItem() != null) {
            String tuKhoa = TimKiemTextField.getText();
            String tenLop = timKiemLopComboBox.getSelectedItem().toString();
            String hocKy = timKiemTheoHocKiComboBox.getSelectedItem().toString();
            String namHoc = timKiemTheoHocKiComboBox.getSelectedItem().toString();

            if (tenLop.equals("---Lớp---")) {
                timKiemTheoNamHocComboBox.setSelectedIndex(0);
                timKiemTheoHocKiComboBox.setSelectedIndex(0);
                tableModel.setRowCount(0);
            } else {
                if (namHoc.equals("---Năm học---")) {
                    try {
                        dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop(tuKhoa, tenLop, hocKy, namHoc);
                        tableModel.setRowCount(0);

                        dsDiemRenLuyen.forEach(drl -> {
                            tableModel.addRow(new Object[]{
                                drl.getMaSinhVien(), drl.getHoTen(),
                                drl.getD1(), drl.getD2(), drl.getD3(),
                                drl.getD4(), drl.getD5(), drl.getTongDiem(),
                                drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                                drl.getTrangThaiCham()});

                            if (drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn đã chấm")) {
                                coVanCham = drl.getTrangThaiCham();
                            }
                        });
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_timKiemLopComboBoxActionPerformed

    private void timKiemTheoHocKiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemTheoHocKiComboBoxActionPerformed
        try {
            String tuKhoa = TimKiemTextField.getText();
            String lop = timKiemLopComboBox.getSelectedItem().toString();
            String hocKy = timKiemTheoHocKiComboBox.getSelectedItem().toString();
            String namHoc = timKiemTheoNamHocComboBox.getSelectedItem().toString();

            if (lop.equals("---Lớp---")) {
                timKiemTheoNamHocComboBox.setSelectedIndex(0);
                timKiemTheoHocKiComboBox.setSelectedIndex(0);
                tableModel.setRowCount(0);
            } else if (namHoc.equals("---Năm học---")) {
                timKiemTheoHocKiComboBox.setSelectedIndex(0);
                tableModel.setRowCount(0);
            } else {
                dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop(tuKhoa, lop, hocKy, namHoc);
                tableModel.setRowCount(0);

                dsDiemRenLuyen.forEach(drl -> {
                    tableModel.addRow(new Object[]{
                        drl.getMaSinhVien(), drl.getHoTen(),
                        drl.getD1(), drl.getD2(), drl.getD3(),
                        drl.getD4(), drl.getD5(), drl.getTongDiem(),
                        drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                        drl.getTrangThaiCham()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timKiemTheoHocKiComboBoxActionPerformed

    private void TimKiemTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimKiemTextFieldKeyPressed
        try {
            String tuKhoa = TimKiemTextField.getText();
            String lop = timKiemLopComboBox.getSelectedItem().toString();
            String hocKy = timKiemTheoHocKiComboBox.getSelectedItem().toString();
            String namHoc = timKiemTheoNamHocComboBox.getSelectedItem().toString();

            if (namHoc.equals("---Năm học---")) {
                timKiemTheoHocKiComboBox.setSelectedIndex(0);
                tableModel.setRowCount(0);
            } else {
                dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop(tuKhoa, lop, hocKy, namHoc);
                tableModel.setRowCount(0);

                dsDiemRenLuyen.forEach(drl -> {
                    tableModel.addRow(new Object[]{
                        drl.getMaSinhVien(), drl.getHoTen(),
                        drl.getD1(), drl.getD2(), drl.getD3(),
                        drl.getD4(), drl.getD5(), drl.getTongDiem(),
                        drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                        drl.getTrangThaiCham()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TimKiemTextFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TimKiemTextField;
    private javax.swing.JButton chamLaiButton;
    private javax.swing.JTextField diemTieuChi1TextField;
    private javax.swing.JTextField diemTieuChi2TextField;
    private javax.swing.JTextField diemTieuChi3TextField;
    private javax.swing.JTextField diemTieuChi4TextField;
    private javax.swing.JTextField diemTieuChi5TextField;
    private javax.swing.JTable dsDiemRenLuyenTable;
    private javax.swing.JButton duyetTatCaButton;
    private javax.swing.JTextField hoTenTextField;
    private javax.swing.JTextField hocKyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ketThucChamButton;
    private javax.swing.JButton lamMoiButton;
    private javax.swing.JTextField maSinhVienTextField;
    private javax.swing.JTextField namHocTextField;
    private javax.swing.JComboBox<String> timKiemLopComboBox;
    private javax.swing.JComboBox<String> timKiemTheoHocKiComboBox;
    private javax.swing.JComboBox<String> timKiemTheoNamHocComboBox;
    private javax.swing.JTextField tongDiemTextField;
    private javax.swing.JButton xemDiemButton;
    private javax.swing.JTextField xepLoaiTextField;
    // End of variables declaration//GEN-END:variables
}
