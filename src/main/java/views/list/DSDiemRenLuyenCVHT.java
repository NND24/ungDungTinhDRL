package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DiemRenLuyenModel;
import models.NamHocModel;
import models.PhieuDRLModel;
import controllers.DiemRenLuyenCtrl;
import controllers.PhanCongCtrl;
import controllers.PhieuDRLCtrl;
import views.main.DangNhap;
import views.main.FormChamDiemCVHT;
import utils.DialogHelper;
import utils.Validator;

public class DSDiemRenLuyenCVHT extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    private List<NamHocModel> dsNamHoc = new ArrayList<>();
    private String trangThaiChamDiem;

    public DSDiemRenLuyenCVHT() {
        initComponents();
        tableModel = (DefaultTableModel) tblDSDiemRenLuyen.getModel();
        hienThiDSLopPhanCong();
        cmbTKHocKy.setSelectedItem("---Học kỳ---");
    }

    private void hienThiDSLopPhanCong() {
        try {
            List<String> dsLop = PhanCongCtrl.timDSLopPhanCong(DangNhap.username);

            cmbTKLop.removeAllItems();
            cmbTKLop.addItem("---Lớp---");
            dsLop.forEach(lop -> {
                cmbTKLop.addItem(lop);
            });

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNamHocPhanCong(String maLop) {
        try {
            dsNamHoc = PhanCongCtrl.timDSNamHocPhanCong(DangNhap.username, maLop);

            cmbTKNamHoc.removeAllItems();
            dsNamHoc.forEach(nh -> {
                cmbTKNamHoc.addItem(nh.getNamHoc());
            });
            cmbTKNamHoc.addItem("---Năm học---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSDiem() {
        tableModel.setRowCount(0);

        for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
            tableModel.addRow(new Object[]{
                drl.getMaSinhVien(), drl.getHoTen(),
                drl.getD1(), drl.getD2(), drl.getD3(),
                drl.getD4(), drl.getD5(), drl.getTongDiem(),
                drl.getXepLoai(), drl.getHocKy(), drl.getNamHoc(),
                drl.getTrangThaiCham()});
        }

        trangThaiChamDiem = "";
        for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
            if (drl.getTrangThaiCham().equalsIgnoreCase("Hết thời gian chấm")) {
                trangThaiChamDiem = drl.getTrangThaiCham();
                break;
            }
        }
    }

    void lamMoi() {
        txtMaSinhVien.setText("");
        txtHoTen.setText("");
        btnDiemTieuChi1.setText("");
        btnDiemTieuChi2.setText("");
        btnDiemTieuChi3.setText("");
        btnDiemTieuChi4.setText("");
        btnDiemTieuChi5.setText("");
        txtTongDiem.setText("");
        txtXepLoai.setText("");
        txtHocKy.setText("");
        txtNamHoc.setText("");
        cmbTKLop.setSelectedItem("---Lớp---");
        cmbTKNamHoc.setSelectedItem("---Năm học---");
        cmbTKHocKy.setSelectedItem("---Học kỳ---");
    }

    private void timKiemDanhSachDRL() {
        try {
            if (cmbTKLop.getSelectedItem() != null && cmbTKNamHoc.getSelectedItem() != null) {
                String tuKhoa = txtTimKiem.getText();
                String lop = cmbTKLop.getSelectedItem().toString();
                int namHocIndex = cmbTKNamHoc.getSelectedIndex();
                if (namHocIndex >= 0 && namHocIndex < dsNamHoc.size()) {
                    int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                    String hocKy = cmbTKHocKy.getSelectedItem().toString();

                    if (lop.equals("---Lớp---") || cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || hocKy.equals("---Học kỳ---")) {
                        dsDiemRenLuyen.clear();
                        hienThiDSDiem();
                    } else {
                        dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, maNamHoc, hocKy);
                        if (thayDoiTrangThaiKhongTB("Hết thời gian chấm")) {
                            dsDiemRenLuyen = DiemRenLuyenCtrl.timKiemDRL(tuKhoa, lop, maNamHoc, hocKy);
                        }
                        hienThiDSDiem();
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCVHT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void thayDoiTrangThaiCham(String trangThaiCham, String loaiThayDoi) {
        if (dsDiemRenLuyen.isEmpty() || cmbTKLop.getSelectedItem().equals("---Lớp---") || cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            DialogHelper.showError("Chưa chọn năm học, học kỳ muốn thao tác");
        } else {
            String hocKy = "";
            String namHoc = "";
            boolean flagMesage = false;
            for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
                try {
                    if (trangThaiChamDiem.equalsIgnoreCase("Hết thời gian chấm")
                            || Validator.isBeforeToday(sv.getNgayKetThuc())) {
                        DialogHelper.showError("Hết thời gian chấm điểm. Vui lòng liên hệ với quản lý!");
                        hocKy = sv.getHocKy();
                        namHoc = sv.getNamHoc();
                        flagMesage = false;
                        break;
                    } else {
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(sv.getMaSinhVien(), sv.getHocKy(), sv.getNamHoc());
                        PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, trangThaiCham);
                        PhieuDRLCtrl.capNhatTrangThaiCham(phieu);
                        hocKy = sv.getHocKy();
                        namHoc = sv.getNamHoc();
                        flagMesage = true;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (flagMesage) {
                String message = loaiThayDoi + " chấm điểm rèn luyện học kỳ: " + hocKy + ", năm học: " + namHoc;
                DialogHelper.showMessage(message);
                timKiemDanhSachDRL();
            }
        }
    }

    private boolean thayDoiTrangThaiKhongTB(String trangThaiCham) {
        boolean flag = false;
        if (dsDiemRenLuyen.isEmpty() || cmbTKLop.getSelectedItem().equals("---Lớp---") || cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
        } else {
            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                try {
                    if (Validator.isBeforeToday(drl.getNgayKetThuc()) && !drl.getTrangThaiCham().equals("Hết thời gian chấm")) {
                        DiemRenLuyenModel diemRenLuyenBCS = DiemRenLuyenCtrl.timDRLDayDu(drl.getMaSinhVien(), drl.getHocKy(), drl.getNamHoc(), "CoVan");
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(drl.getMaSinhVien(), drl.getHocKy(), drl.getNamHoc());
                        if (diemRenLuyenBCS.getXepLoai() == null && diemRenLuyenBCS.getTongDiem() == 0) {
                            DiemRenLuyenModel diem = new DiemRenLuyenModel(maPhieuDRL, "CoVan", "Kém", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                            DiemRenLuyenCtrl.chamDiemRenLuyen(diem);
                        }
                        PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, trangThaiCham);
                        PhieuDRLCtrl.capNhatTrangThaiCham(phieu);
                        flag = true;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnXemDiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnChamLai = new javax.swing.JButton();
        btnKetThucCham = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDiemRenLuyen = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnDiemTieuChi1 = new javax.swing.JTextField();
        btnDiemTieuChi2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDiemTieuChi3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDiemTieuChi4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnDiemTieuChi5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtXepLoai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongDiem = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cmbTKLop = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbTKNamHoc = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmbTKHocKy = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1140, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN ");

        btnXemDiem.setBackground(new java.awt.Color(0, 102, 255));
        btnXemDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXemDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDiem.setText("Xem/chấm điểm");
        btnXemDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXemDiem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDiemActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(120, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnChamLai.setBackground(new java.awt.Color(0, 102, 255));
        btnChamLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChamLai.setForeground(new java.awt.Color(255, 255, 255));
        btnChamLai.setText("Chấm lại");
        btnChamLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChamLai.setPreferredSize(new java.awt.Dimension(120, 25));
        btnChamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamLaiActionPerformed(evt);
            }
        });

        btnKetThucCham.setBackground(new java.awt.Color(0, 102, 255));
        btnKetThucCham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKetThucCham.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThucCham.setText("Kết thúc chấm");
        btnKetThucCham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKetThucCham.setPreferredSize(new java.awt.Dimension(120, 25));
        btnKetThucCham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucChamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(btnXemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnKetThucCham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnChamLai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnXemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnKetThucCham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);
        txtMaSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));

        tblDSDiemRenLuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm tiêu chí 1", "Điểm tiêu chí 2", "Điểm tiêu chí 3", "Điểm tiêu chí 4", "Điểm tiêu chí 5", "Tổng điểm", "Xếp loại", "Học kỳ", "Năm học", "Trạng thái chấm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDiemRenLuyen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSDiemRenLuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDiemRenLuyenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSDiemRenLuyen);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiêu chí 1");

        btnDiemTieuChi1.setEditable(false);
        btnDiemTieuChi1.setBackground(new java.awt.Color(255, 255, 255));

        btnDiemTieuChi2.setEditable(false);
        btnDiemTieuChi2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiêu chí 2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiêu chí 3");

        btnDiemTieuChi3.setEditable(false);
        btnDiemTieuChi3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiêu chí 4");

        btnDiemTieuChi4.setEditable(false);
        btnDiemTieuChi4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiêu chí 5");

        btnDiemTieuChi5.setEditable(false);
        btnDiemTieuChi5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng điểm");

        txtNamHoc.setEditable(false);
        txtNamHoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Xếp loại");

        txtXepLoai.setEditable(false);
        txtXepLoai.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Học kỳ");

        txtHocKy.setEditable(false);
        txtHocKy.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Năm học");

        txtTongDiem.setEditable(false);
        txtTongDiem.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("DANH SÁCH ĐIỂM RÈN LUYỆN CỦA LỚP");

        btnIn.setBackground(new java.awt.Color(0, 102, 255));
        btnIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIn.setForeground(new java.awt.Color(255, 255, 255));
        btnIn.setText("Xuất danh sách kết quả");
        btnIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIn.setPreferredSize(new java.awt.Dimension(120, 25));
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 649, Short.MAX_VALUE)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Lớp");

        cmbTKLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Lớp---" }));
        cmbTKLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKLopActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Năm học");

        cmbTKNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Năm học---" }));
        cmbTKNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNamHocActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Học kỳ");

        cmbTKHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "---Học kỳ---" }));
        cmbTKHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKHocKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(37, 37, 37)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel30)
                        .addGap(60, 60, 60)
                        .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(cmbTKLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSDiemRenLuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDiemRenLuyenMouseClicked
        int selectedIndex = tblDSDiemRenLuyen.getSelectedRow();
        if (selectedIndex >= 0) {
            DiemRenLuyenModel drl = dsDiemRenLuyen.get(selectedIndex);

            txtMaSinhVien.setText(drl.getMaSinhVien());
            txtHoTen.setText(drl.getHoTen());
            btnDiemTieuChi1.setText(Float.toString(drl.getD1()));
            btnDiemTieuChi2.setText(Integer.toString(drl.getD2()));
            btnDiemTieuChi3.setText(Integer.toString(drl.getD3()));
            btnDiemTieuChi4.setText(Integer.toString(drl.getD4()));
            btnDiemTieuChi5.setText(Integer.toString(drl.getD5()));
            txtTongDiem.setText(Float.toString(drl.getTongDiem()));
            txtXepLoai.setText(drl.getXepLoai());
            txtHocKy.setText(drl.getHocKy());
            txtNamHoc.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_tblDSDiemRenLuyenMouseClicked

    private void btnXemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDiemActionPerformed
        String maSinhVien = txtMaSinhVien.getText();
        if (maSinhVien.isEmpty()) {
            DialogHelper.showError("Chưa chọn học kỳ, năm học muốn xem. Vui lòng chọn");
        } else {
            FormChamDiemCVHT.Instance.maSVTextField.setText("");

            FormChamDiemCVHT.Instance.maSVTextField.setText(txtMaSinhVien.getText());
            FormChamDiemCVHT.Instance.nameTextField.setText(txtHoTen.getText());
            FormChamDiemCVHT.Instance.semesterTextField.setText(txtHocKy.getText());
            FormChamDiemCVHT.Instance.scholasticTextField.setText(txtNamHoc.getText());
        }
    }//GEN-LAST:event_btnXemDiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnChamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamLaiActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn cho phép cho ban cán sự chấm lại không?")) {
            thayDoiTrangThaiCham("Ban cán sự đã chấm", "Chấm lại");
            hienThiDSDiem();
        }
    }//GEN-LAST:event_btnChamLaiActionPerformed

    private void btnKetThucChamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucChamActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn kết thúc chấm điểm cho ban cán sự không?")) {
            thayDoiTrangThaiCham("Ban cán sự kết thúc chấm", "Kết thúc");
            hienThiDSDiem();
        }
    }//GEN-LAST:event_btnKetThucChamActionPerformed

    private void cmbTKNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNamHocActionPerformed
        if (cmbTKNamHoc.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        }
    }//GEN-LAST:event_cmbTKNamHocActionPerformed

    private void cmbTKLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKLopActionPerformed
        if (cmbTKLop.getSelectedItem() != null && !cmbTKLop.getSelectedItem().equals("---Lớp---")) {
            String maLop = cmbTKLop.getSelectedItem().toString();
            hienThiDSNamHocPhanCong(maLop);
            timKiemDanhSachDRL();
        }
    }//GEN-LAST:event_cmbTKLopActionPerformed

    private void cmbTKHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKHocKyActionPerformed
        if (cmbTKHocKy.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            txtTimKiem.setText("");
            hienThiDSDiem();
        }
    }//GEN-LAST:event_cmbTKHocKyActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        if (cmbTKNamHoc.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            txtTimKiem.setText("");
            hienThiDSDiem();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        try {
            if (!dsDiemRenLuyen.isEmpty()) {
                for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
                    if (trangThaiChamDiem.equalsIgnoreCase("Hết thời gian chấm")
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenBCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamLai;
    private javax.swing.JTextField btnDiemTieuChi1;
    private javax.swing.JTextField btnDiemTieuChi2;
    private javax.swing.JTextField btnDiemTieuChi3;
    private javax.swing.JTextField btnDiemTieuChi4;
    private javax.swing.JTextField btnDiemTieuChi5;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnKetThucCham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXemDiem;
    private javax.swing.JComboBox<String> cmbTKHocKy;
    private javax.swing.JComboBox<String> cmbTKLop;
    private javax.swing.JComboBox<String> cmbTKNamHoc;
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
    private javax.swing.JTable tblDSDiemRenLuyen;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongDiem;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
