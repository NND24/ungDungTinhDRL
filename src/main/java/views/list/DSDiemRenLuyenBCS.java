package views.list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DiemRenLuyenModel;
import models.NamHocModel;
import models.PhieuDRLModel;
import models.SinhVienModel;
import controllers.DiemRenLuyenCtrl;
import controllers.NamHocCtrl;
import controllers.PhieuDRLCtrl;
import controllers.SinhVienCtrl;
import views.main.DangNhap;
import views.main.FormChamDiemBCS;
import utils.DialogHelper;
import utils.Validator;

public class DSDiemRenLuyenBCS extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
    private List<NamHocModel> dsNamHoc = new ArrayList<>();
    private String trangThaiChamDiem;

    public DSDiemRenLuyenBCS() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDanhSachDRL.getModel();
            hienThiDSNamHoc();
            cmbTKNamHoc.setSelectedItem("---Năm học---");
            hienThiDRLHienTai();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDiemRenLuyenCaNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNamHoc() {
        try {
            dsNamHoc = NamHocCtrl.timNamHocHienThi();

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
                drl.getTrangThaiCham()
            });
        }
        trangThaiChamDiem = "";
        for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
            if (drl.getTrangThaiCham().equalsIgnoreCase("Ban cán sự kết thúc chấm")
                    || drl.getTrangThaiCham().equalsIgnoreCase("Cố vấn đã chấm")
                    || drl.getTrangThaiCham().equalsIgnoreCase("Hết thời gian chấm")) {
                trangThaiChamDiem = drl.getTrangThaiCham();
                break;
            }
        }
    }

    private void hienThiDRLHienTai() throws ClassNotFoundException {
        SinhVienModel sv = SinhVienCtrl.timSinhVienTheoTenDangNhap(DangNhap.username);
        if (sv != null) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            String hocKy = currentMonth >= 9 && currentMonth <= 1 ? "1" : "2";

            String namHoc = (currentMonth >= 9 || currentMonth == 1)
                    ? ((currentMonth == 1) ? (currentYear - 1) + "-" + currentYear : currentYear + "-" + (currentYear + 1))
                    : (currentYear - 1) + "-" + currentYear;

            cmbTKNamHoc.setSelectedItem(namHoc);
            cmbTKHocKy.setSelectedItem(hocKy);
            dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", sv.getMaLop(), hocKy, namHoc);
            thayDoiTrangThaiKhongTB("Hết thời gian chấm");
            dsDiemRenLuyen = DiemRenLuyenCtrl.timDiemCuaLop("", sv.getMaLop(), hocKy, namHoc);
            hienThiDSDiem();
        }
    }

    private void lamMoi() {
        txtMaSinhVien.setText("");
        txtHoTen.setText("");
        txtDiemTieuChi1.setText("");
        txtDiemTieuChi2.setText("");
        txtDiemTieuChi3.setText("");
        txtDiemTieuChi4.setText("");
        txtDiemTieuChi5.setText("");
        txtTongDiem.setText("");
        txtXepLoai.setText("");
        txtHocKy.setText("");
        txtNamHoc.setText("");
    }

    private void timKiemDanhSachDRL() {
        try {
            SinhVienModel sv = SinhVienCtrl.timSinhVienTheoTenDangNhap(DangNhap.username);
            if (cmbTKNamHoc.getSelectedItem() != null && sv != null) {
                String lop = sv.getMaLop();
                String tuKhoa = txtTimKiem.getText();
                int namHocIndex = cmbTKNamHoc.getSelectedIndex();
                if (namHocIndex >= 0 && namHocIndex < dsNamHoc.size()) {
                    int maNamHoc = dsNamHoc.get(namHocIndex).getMaNamHoc();
                    String hocKy = cmbTKHocKy.getSelectedItem().toString();

                    if (cmbTKNamHoc.getSelectedItem().toString().equals("---Năm học---") || hocKy.equals("---Học kỳ---")) {
                        dsDiemRenLuyen.clear();
                        tableModel.setRowCount(0);
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
        if (dsDiemRenLuyen.isEmpty() || cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            DialogHelper.showError("Chưa chọn năm học, học kỳ muốn thao tác");
        } else {
            String hocKy = "";
            String namHoc = "";
            boolean flagMesage = false;
            for (DiemRenLuyenModel sv : dsDiemRenLuyen) {
                try {
                    if (trangThaiChamDiem.equalsIgnoreCase("Ban cán sự kết thúc chấm")
                            || trangThaiChamDiem.equalsIgnoreCase("Cố vấn đã chấm")
                            || trangThaiChamDiem.equalsIgnoreCase("Hết thời gian chấm")
                            || Validator.isBeforeToday(sv.getNgayKetThuc())) {
                        DialogHelper.showError("Hết thời gian chấm điểm. Vui lòng liên hệ với cố vấn học tập!");
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
        if (dsDiemRenLuyen.isEmpty() || cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
        } else {
            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                try {
                    if (!drl.getTrangThaiCham().equals("Hết thời gian chấm") && Validator.isBeforeToday(drl.getNgayKetThuc())) {
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

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnXemDiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnKetThucCham = new javax.swing.JButton();
        btnChamLai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnXemDSKQ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachDRL = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDiemTieuChi1 = new javax.swing.JTextField();
        txtDiemTieuChi2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiemTieuChi3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDiemTieuChi4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDiemTieuChi5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtXepLoai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongDiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbTKNamHoc = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cmbTKHocKy = new javax.swing.JComboBox<>();

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
        setPreferredSize(new java.awt.Dimension(1140, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐIỂM RÈN LUYỆN");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(btnXemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(btnKetThucCham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sinh viên");

        txtMaSinhVien.setEditable(false);
        txtMaSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("DANH SÁCH ĐIỂM RÈN LUYỆN CỦA LỚP");

        btnXemDSKQ.setBackground(new java.awt.Color(0, 102, 255));
        btnXemDSKQ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXemDSKQ.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDSKQ.setText("Xuất danh sách kết quả");
        btnXemDSKQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXemDSKQ.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXemDSKQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSKQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXemDSKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnXemDSKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblDanhSachDRL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDanhSachDRL.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDanhSachDRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachDRLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachDRL);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiêu chí 1");

        txtDiemTieuChi1.setEditable(false);
        txtDiemTieuChi1.setBackground(new java.awt.Color(255, 255, 255));

        txtDiemTieuChi2.setEditable(false);
        txtDiemTieuChi2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiêu chí 2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiêu chí 3");

        txtDiemTieuChi3.setEditable(false);
        txtDiemTieuChi3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiêu chí 4");

        txtDiemTieuChi4.setEditable(false);
        txtDiemTieuChi4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiêu chí 5");

        txtDiemTieuChi5.setEditable(false);
        txtDiemTieuChi5.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Năm học");

        cmbTKNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNamHocActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Học kì");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel14))
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(50, 50, 50)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel4))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtTongDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9)
                                .addComponent(jLabel13))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel16)
                        .addGap(46, 46, 46)
                        .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
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
                    .addComponent(txtDiemTieuChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiemTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemTieuChi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiemTieuChi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiemTieuChi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTKNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cmbTKHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachDRLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachDRLMouseClicked
        int selectedIndex = tblDanhSachDRL.getSelectedRow();
        if (selectedIndex >= 0) {
            DiemRenLuyenModel drl = dsDiemRenLuyen.get(selectedIndex);

            txtMaSinhVien.setText(drl.getMaSinhVien());
            txtHoTen.setText(drl.getHoTen());
            txtDiemTieuChi1.setText(Float.toString(drl.getD1()));
            txtDiemTieuChi2.setText(Integer.toString(drl.getD2()));
            txtDiemTieuChi3.setText(Integer.toString(drl.getD3()));
            txtDiemTieuChi4.setText(Integer.toString(drl.getD4()));
            txtDiemTieuChi5.setText(Integer.toString(drl.getD5()));
            txtTongDiem.setText(Float.toString(drl.getTongDiem()));
            txtXepLoai.setText(drl.getXepLoai());
            txtHocKy.setText(drl.getHocKy());
            txtNamHoc.setText(drl.getNamHoc());
        }
    }//GEN-LAST:event_tblDanhSachDRLMouseClicked

    private void btnXemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDiemActionPerformed
        String maSinhVien = txtMaSinhVien.getText();
        if (maSinhVien.isEmpty()) {
            DialogHelper.showError("Chưa chọn học kỳ, năm học muốn xem. Vui lòng chọn");
        } else {
            FormChamDiemBCS.Instance.maSVTextField.setText("");

            FormChamDiemBCS.Instance.maSVTextField.setText(txtMaSinhVien.getText());
            FormChamDiemBCS.Instance.nameTextField.setText(txtHoTen.getText());
            FormChamDiemBCS.Instance.semesterTextField.setText(txtHocKy.getText());
            FormChamDiemBCS.Instance.scholasticTextField.setText(txtNamHoc.getText());
        }
    }//GEN-LAST:event_btnXemDiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        cmbTKNamHoc.setSelectedItem("---Năm học---");
        cmbTKHocKy.setSelectedItem("---Học kỳ---");
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void cmbTKHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKHocKyActionPerformed
        if (cmbTKHocKy.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            timKiemDanhSachDRL();
        }
    }//GEN-LAST:event_cmbTKHocKyActionPerformed

    private void btnKetThucChamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucChamActionPerformed
        thayDoiTrangThaiCham("Sinh viên kết thúc chấm", "Kết thúc");
    }//GEN-LAST:event_btnKetThucChamActionPerformed

    private void btnChamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamLaiActionPerformed
        thayDoiTrangThaiCham("Sinh viên đã chấm", "Chấm lại");
    }//GEN-LAST:event_btnChamLaiActionPerformed

    private void cmbTKNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNamHocActionPerformed
        if (cmbTKNamHoc.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            cmbTKHocKy.setSelectedItem("---Học kỳ---");
            timKiemDanhSachDRL();
        }
    }//GEN-LAST:event_cmbTKNamHocActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        if (cmbTKNamHoc.getSelectedItem() != null && !cmbTKNamHoc.getSelectedItem().equals("---Năm học---") && !cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            timKiemDanhSachDRL();
        } else if (cmbTKNamHoc.getSelectedItem().equals("---Năm học---") || cmbTKHocKy.getSelectedItem().equals("---Học kỳ---")) {
            dsDiemRenLuyen.clear();
            timKiemDanhSachDRL();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void btnXemDSKQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSKQActionPerformed
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
    }//GEN-LAST:event_btnXemDSKQActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamLai;
    private javax.swing.JButton btnKetThucCham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXemDSKQ;
    private javax.swing.JButton btnXemDiem;
    private javax.swing.JComboBox<String> cmbTKHocKy;
    private javax.swing.JComboBox<String> cmbTKNamHoc;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSachDRL;
    private javax.swing.JTextField txtDiemTieuChi1;
    private javax.swing.JTextField txtDiemTieuChi2;
    private javax.swing.JTextField txtDiemTieuChi3;
    private javax.swing.JTextField txtDiemTieuChi4;
    private javax.swing.JTextField txtDiemTieuChi5;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongDiem;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
