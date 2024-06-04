package views.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import models.DiemRenLuyenModel;
import models.CoVanModel;
import models.PhieuDRLModel;
import controllers.DiemRenLuyenCtrl;
import controllers.CoVanCtrl;
import controllers.PhieuDRLCtrl;
import java.awt.Point;
import javax.swing.SwingUtilities;
import utils.DialogHelper;
import utils.Validator;

public class FormChamDiemCVHT extends javax.swing.JPanel {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static FormChamDiemCVHT Instance;
    public JTextField maSVTextField;
    public JTextField nameTextField;
    public JTextField semesterTextField;
    public JTextField scholasticTextField;

    private String trangThai = "";
    private Date ngayKetThuc;

    public FormChamDiemCVHT() {
        initComponents();

        Instance = this;
        maSVTextField = txtMaSinhVien;
        nameTextField = txtHoTen;
        semesterTextField = txtHocKy;
        scholasticTextField = txtNamHoc;

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        SwingUtilities.invokeLater(() -> {
            jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
        });
    }

    private void lamMoi() {
        sv11TextField.setText("0");
        sv12TextField.setText("0");
        sv13TextField.setText("0");
        sv14TextField.setText("0");
        sv15TextField.setText("0");
        sv1TextField.setText("0");

        sv21TextField.setText("0");
        sv22TextField.setText("0");
        sv23TextField.setText("0");
        sv2TextField.setText("0");

        sv31TextField.setText("0");
        sv32TextField.setText("0");
        sv33TextField.setText("0");
        sv34TextField.setText("0");
        sv35TextField.setText("0");
        sv3TextField.setText("0");

        sv41TextField.setText("0");
        sv42TextField.setText("0");
        sv43TextField.setText("0");
        sv44TextField.setText("0");
        sv45TextField.setText("0");
        sv46TextField.setText("0");
        sv4TextField.setText("0");

        sv51TextField.setText("0");
        sv52TextField.setText("0");
        sv53TextField.setText("0");
        sv5TextField.setText("0");

        svTongTextField.setText("0");

        bcs11TextField.setText("0");
        bcs12TextField.setText("0");
        bcs13TextField.setText("0");
        bcs14TextField.setText("0");
        bcs15TextField.setText("0");
        bcs1TextField.setText("0");

        bcs21TextField.setText("0");
        bcs22TextField.setText("0");
        bcs23TextField.setText("0");
        bcs2TextField.setText("0");

        bcs31TextField.setText("0");
        bcs32TextField.setText("0");
        bcs33TextField.setText("0");
        bcs34TextField.setText("0");
        bcs35TextField.setText("0");
        bcs3TextField.setText("0");

        bcs41TextField.setText("0");
        bcs42TextField.setText("0");
        bcs43TextField.setText("0");
        bcs44TextField.setText("0");
        bcs45TextField.setText("0");
        bcs46TextField.setText("0");
        bcs4TextField.setText("0");

        bcs51TextField.setText("0");
        bcs52TextField.setText("0");
        bcs53TextField.setText("0");
        bcs5TextField.setText("0");

        bcsTongTextField.setText("0");

        cv11TextField.setText("0");
        cv12TextField.setText("0");
        cv13TextField.setText("0");
        cv14TextField.setText("0");
        cv15TextField.setText("0");
        cv1TextField.setText("0");

        cv21TextField.setText("0");
        cv22TextField.setText("0");
        cv23TextField.setText("0");
        cv2TextField.setText("0");

        cv31TextField.setText("0");
        cv32TextField.setText("0");
        cv33TextField.setText("0");
        cv34TextField.setText("0");
        cv35TextField.setText("0");
        cv3TextField.setText("0");

        cv41TextField.setText("0");
        cv42TextField.setText("0");
        cv43TextField.setText("0");
        cv44TextField.setText("0");
        cv45TextField.setText("0");
        cv46TextField.setText("0");
        cv4TextField.setText("0");

        cv51TextField.setText("0");
        cv52TextField.setText("0");
        cv53TextField.setText("0");
        cv5TextField.setText("0");

        cvTongTextField.setText("0");
    }

    private void dienDiem() {
        int bcs11 = Integer.parseInt(bcs11TextField.getText());
        int bcs12 = Integer.parseInt(bcs12TextField.getText());
        int bcs13 = Integer.parseInt(bcs13TextField.getText());
        float bcs14 = Float.parseFloat(bcs14TextField.getText());
        int bcs15 = Integer.parseInt(bcs15TextField.getText());
        float bcs1 = Float.parseFloat(bcs1TextField.getText());

        int bcs21 = Integer.parseInt(bcs21TextField.getText());
        int bcs22a = Integer.parseInt(bcs22TextField.getText());
        int bcs23a = Integer.parseInt(bcs23TextField.getText());
        int bcs2 = Integer.parseInt(bcs2TextField.getText());

        int bcs31 = Integer.parseInt(bcs31TextField.getText());
        int bcs32 = Integer.parseInt(bcs32TextField.getText());
        int bcs33 = Integer.parseInt(bcs33TextField.getText());
        int bcs34 = Integer.parseInt(bcs34TextField.getText());
        int bcs35 = Integer.parseInt(bcs35TextField.getText());
        int bcs3 = Integer.parseInt(bcs3TextField.getText());

        int bcs41 = Integer.parseInt(bcs41TextField.getText());
        int bcs42 = Integer.parseInt(bcs42TextField.getText());
        int bcs43 = Integer.parseInt(bcs43TextField.getText());
        int bcs44 = Integer.parseInt(bcs44TextField.getText());
        int bcs45 = Integer.parseInt(bcs45TextField.getText());
        int bcs46 = Integer.parseInt(bcs46TextField.getText());
        int bcs4 = Integer.parseInt(bcs4TextField.getText());

        int bcs51 = Integer.parseInt(bcs51TextField.getText());
        int bcs52 = Integer.parseInt(bcs52TextField.getText());
        int bcs53 = Integer.parseInt(bcs53TextField.getText());
        int bcs5 = Integer.parseInt(bcs5TextField.getText());

        float tongDiem = Float.parseFloat(bcsTongTextField.getText());

        cv11TextField.setText(Integer.toString(bcs11));
        cv12TextField.setText(Integer.toString(bcs12));
        cv13TextField.setText(Integer.toString(bcs13));
        cv14TextField.setText(Float.toString(bcs14));
        cv15TextField.setText(Integer.toString(bcs15));
        cv1TextField.setText(Float.toString(bcs1));

        cv21TextField.setText(Integer.toString(bcs21));
        cv22TextField.setText(Integer.toString(bcs22a));
        cv23TextField.setText(Integer.toString(bcs23a));
        cv2TextField.setText(Integer.toString(bcs2));

        cv31TextField.setText(Integer.toString(bcs31));
        cv32TextField.setText(Integer.toString(bcs32));
        cv33TextField.setText(Integer.toString(bcs33));
        cv34TextField.setText(Integer.toString(bcs34));
        cv35TextField.setText(Integer.toString(bcs35));
        cv3TextField.setText(Integer.toString(bcs3));

        cv41TextField.setText(Integer.toString(bcs41));
        cv42TextField.setText(Integer.toString(bcs42));
        cv43TextField.setText(Integer.toString(bcs43));
        cv44TextField.setText(Integer.toString(bcs44));
        cv45TextField.setText(Integer.toString(bcs45));
        cv46TextField.setText(Integer.toString(bcs46));
        cv4TextField.setText(Integer.toString(bcs4));

        cv51TextField.setText(Integer.toString(bcs51));
        cv52TextField.setText(Integer.toString(bcs52));
        cv53TextField.setText(Integer.toString(bcs53));
        cv5TextField.setText(Integer.toString(bcs5));

        cvTongTextField.setText(Float.toString(tongDiem));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        formChamDiemCVHTPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        sv11TextField = new javax.swing.JTextField();
        sv14TextField = new javax.swing.JTextField();
        sv15TextField = new javax.swing.JTextField();
        sv1TextField = new javax.swing.JTextField();
        bcs11TextField = new javax.swing.JTextField();
        bcs13TextField = new javax.swing.JTextField();
        bcs14TextField = new javax.swing.JTextField();
        bcs15TextField = new javax.swing.JTextField();
        bcs1TextField = new javax.swing.JTextField();
        cv11TextField = new javax.swing.JTextField();
        cv13TextField = new javax.swing.JTextField();
        cv14TextField = new javax.swing.JTextField();
        cv15TextField = new javax.swing.JTextField();
        cv1TextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSinhVien = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        sv21TextField = new javax.swing.JTextField();
        bcs21TextField = new javax.swing.JTextField();
        cv21TextField = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel82 = new javax.swing.JLabel();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        sv22TextField = new javax.swing.JTextField();
        sv23TextField = new javax.swing.JTextField();
        sv2TextField = new javax.swing.JTextField();
        bcs22TextField = new javax.swing.JTextField();
        bcs23TextField = new javax.swing.JTextField();
        bcs2TextField = new javax.swing.JTextField();
        cv22TextField = new javax.swing.JTextField();
        cv23TextField = new javax.swing.JTextField();
        cv2TextField = new javax.swing.JTextField();
        jTextArea5 = new javax.swing.JTextArea();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        jTextArea7 = new javax.swing.JTextArea();
        jTextArea8 = new javax.swing.JTextArea();
        jTextArea9 = new javax.swing.JTextArea();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        sv31TextField = new javax.swing.JTextField();
        bcs31TextField = new javax.swing.JTextField();
        cv31TextField = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        sv3TextField = new javax.swing.JTextField();
        bcs3TextField = new javax.swing.JTextField();
        cv3TextField = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        sv32TextField = new javax.swing.JTextField();
        sv33TextField = new javax.swing.JTextField();
        sv34TextField = new javax.swing.JTextField();
        sv35TextField = new javax.swing.JTextField();
        bcs32TextField = new javax.swing.JTextField();
        bcs33TextField = new javax.swing.JTextField();
        bcs34TextField = new javax.swing.JTextField();
        bcs35TextField = new javax.swing.JTextField();
        cv32TextField = new javax.swing.JTextField();
        cv33TextField = new javax.swing.JTextField();
        cv34TextField = new javax.swing.JTextField();
        cv35TextField = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jTextArea11 = new javax.swing.JTextArea();
        jLabel109 = new javax.swing.JLabel();
        jTextArea12 = new javax.swing.JTextArea();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jTextArea13 = new javax.swing.JTextArea();
        jLabel113 = new javax.swing.JLabel();
        jTextArea14 = new javax.swing.JTextArea();
        jLabel114 = new javax.swing.JLabel();
        jTextArea15 = new javax.swing.JTextArea();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jTextArea16 = new javax.swing.JTextArea();
        jTextArea17 = new javax.swing.JTextArea();
        jLabel117 = new javax.swing.JLabel();
        jTextArea18 = new javax.swing.JTextArea();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jTextArea19 = new javax.swing.JTextArea();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        sv41TextField = new javax.swing.JTextField();
        sv42TextField = new javax.swing.JTextField();
        sv43TextField = new javax.swing.JTextField();
        sv44TextField = new javax.swing.JTextField();
        sv45TextField = new javax.swing.JTextField();
        sv46TextField = new javax.swing.JTextField();
        sv4TextField = new javax.swing.JTextField();
        sv51TextField = new javax.swing.JTextField();
        sv52TextField = new javax.swing.JTextField();
        sv53TextField = new javax.swing.JTextField();
        sv5TextField = new javax.swing.JTextField();
        svTongTextField = new javax.swing.JTextField();
        bcs43TextField = new javax.swing.JTextField();
        bcs4TextField = new javax.swing.JTextField();
        bcs5TextField = new javax.swing.JTextField();
        bcsTongTextField = new javax.swing.JTextField();
        bcs41TextField = new javax.swing.JTextField();
        bcs42TextField = new javax.swing.JTextField();
        bcs44TextField = new javax.swing.JTextField();
        bcs45TextField = new javax.swing.JTextField();
        bcs46TextField = new javax.swing.JTextField();
        bcs51TextField = new javax.swing.JTextField();
        bcs52TextField = new javax.swing.JTextField();
        bcs53TextField = new javax.swing.JTextField();
        cv43TextField = new javax.swing.JTextField();
        cv4TextField = new javax.swing.JTextField();
        cv5TextField = new javax.swing.JTextField();
        cvTongTextField = new javax.swing.JTextField();
        cv41TextField = new javax.swing.JTextField();
        cv42TextField = new javax.swing.JTextField();
        cv44TextField = new javax.swing.JTextField();
        cv45TextField = new javax.swing.JTextField();
        cv46TextField = new javax.swing.JTextField();
        cv51TextField = new javax.swing.JTextField();
        cv52TextField = new javax.swing.JTextField();
        cv53TextField = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        cv13aTextFiel1 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        sv13TextField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnChamDiem = new javax.swing.JButton();
        btnDienDiem = new javax.swing.JButton();
        jTextArea20 = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        sv12TextField = new javax.swing.JTextField();
        bcs12TextField = new javax.swing.JTextField();
        cv12TextField = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        cv13aTextFiel2 = new javax.swing.JLabel();
        cv13aTextFiel3 = new javax.swing.JLabel();
        cv13aTextFiel4 = new javax.swing.JLabel();
        cv13aTextFiel5 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1140, 2700));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1140, 616));

        formChamDiemCVHTPanel.setBackground(new java.awt.Color(255, 255, 255));
        formChamDiemCVHTPanel.setPreferredSize(new java.awt.Dimension(1348, 2700));
        formChamDiemCVHTPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formChamDiemCVHTPanelMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nội dung đánh giá");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Điểm quy định");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Điểm đánh giá");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sinh viên");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tập thể lớp");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CVHT");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TT");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Tiêu chí 1. Đánh giá về ý thức tham gia học tập");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("1.1");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("  Ý thức và thái độ trong học tập:");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("3 điểm");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("  Đi học đầy đủ, đúng giờ, nghiêm túc trong giờ học, giờ thực hành");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("1.2");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Kết quả học tập trong kỳ học ");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("a) Có kết quả học tập xếp loại Xuất sắc ");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("b) Có kết quả học tập đạt loại Giỏi");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("c) Có kết quả học tập đạt loại Khá ");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("d) Có kết quả học tập đạt loại Trung bình ");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("e) Có kết quả học tập đạt loại dưới Trung bình");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("g) Học lại (phần lý thuyết/ thực hành)");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Ý thức chấp hành tốt nội quy về các kỳ thi");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Sinh viên bị trừ điểm trong các trường hợp/1 lần vi phạm:");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("a) Không đủ điều kiện dự thi/bị cấm thi cho mỗi học phần (lý thuyết/ thực hành)");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("b) Bị lập biên bản khiển trách khi thi kết thúc học phần");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("c) Bị lập biên bản cảnh cáo khi thi kết thúc học phần");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("1.3");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setText(" Ý thức và thái độ tham gia các hoạt động ngoại khóa, các sự kiện liên quan \nđến nghiên cứu khoa học, học thuật, chuyên môn, Câu lạc bộ (0,5 điểm/1 sự \nkiện, hoạt động tham gia, tổng điểm không vượt quá 2 điểm)");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setPreferredSize(new java.awt.Dimension(500, 64));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(2);
        jTextArea2.setText("Tinh thần vượt khó, phấn đấu vươn lên trong học tập (có ĐTBCTL học kỳ sau \nlớn hơn học kỳ trước đó; đối với sinh viên năm thứ nhất, học kỳ 1 không có \nđiểm dưới 2,5)");
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Mức điểm tối đa Tiêu chí 1");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("1.4");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("1.5");
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("10 điểm");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("8 điểm");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("6 điểm");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("4 điểm");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("0 điểm");
        jLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("- 1 điểm");
        jLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("4 điểm");
        jLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("- 2 điểm");
        jLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("- 3 điểm");
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("- 3 điểm");
        jLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("2 điểm");
        jLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("1 điểm");
        jLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("20 điểm");
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv11TextField.setEditable(false);
        sv11TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv14TextField.setEditable(false);
        sv14TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv15TextField.setEditable(false);
        sv15TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv1TextField.setEditable(false);
        sv1TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs11TextField.setEditable(false);
        bcs11TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs13TextField.setEditable(false);
        bcs13TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs14TextField.setEditable(false);
        bcs14TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs15TextField.setEditable(false);
        bcs15TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs1TextField.setEditable(false);
        bcs1TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv1TextField.setEditable(false);
        cv1TextField.setBackground(new java.awt.Color(240, 240, 240));
        cv1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã số sinh viên:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("Họ và tên:");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setText("Ngày sinh:");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setText("Lớp:");

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));

        txtMaSinhVien.setEditable(false);
        txtMaSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        txtMaSinhVien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtMaSinhVienAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setBackground(new java.awt.Color(255, 255, 255));

        txtLop.setEditable(false);
        txtLop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Tiêu chí 2: Đánh giá về ý thức chấp hành nội quy, quy chế, quy định của Học viện");
        jLabel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("2.1");
        jLabel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("15 điểm");
        jLabel74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv21TextField.setEditable(false);
        sv21TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs21TextField.setEditable(false);
        bcs21TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("- Sinh viên bị trừ điểm trong các trường hợp:");
        jLabel76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("2.2");
        jLabel79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("a) Không đóng học phí theo quy định");
        jLabel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("b) Không thực hiện quy định về công tác ngoại trú, nội trú.");
        jLabel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea3.setRows(3);
        jTextArea3.setText("a) Thực hiện nghiệp túc các buổi họp lớp/ sinh hoạt đoàn thể do \nHọc viện/Khoa/Viện, CVHT, Lớp/Chi đoàn tổ chức (tùy thuộc vào \nsố buổi tổ chức sinh hoạt, họp)");
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("b) Vắng 01 buổi họp lớp/ sinh hoạt đoàn thể (không lý do)");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea4.setRows(2);
        jTextArea4.setText("a) Tham gia các buổi hội thảo việc làm, định hướng nghề nghiệp do Học viện \ntổ chức (1 điểm/1 sự kiện tham gia, tổng điểm không vượt quá 5 điểm)");
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("b) Vắng 01 buổi họp lớp/ sinh hoạt đoàn thể (không lý do)");
        jLabel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("2.3");
        jLabel84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Mức điểm tối đa Tiêu chí 2");
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("- 15 điểm");
        jLabel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("- 5 điểm");
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("5 điểm");
        jLabel90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("- 1 điểm");
        jLabel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("5 điểm");
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("- 2 điểm");
        jLabel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("25 điểm");
        jLabel94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv22TextField.setEditable(false);
        sv22TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv22TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv23TextField.setEditable(false);
        sv23TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv23TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv2TextField.setEditable(false);
        sv2TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs22TextField.setEditable(false);
        bcs22TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs22TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs23TextField.setEditable(false);
        bcs23TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs23TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs2TextField.setEditable(false);
        bcs2TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv22TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv23TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv2TextField.setEditable(false);
        cv2TextField.setBackground(new java.awt.Color(240, 240, 240));
        cv2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea5.setRows(4);
        jTextArea5.setText("Tham gia đầy đủ các hoạt động chính trị, xã hội, các hoạt động văn hóa, văn \nnghệ, thể thao, phong trào tình nguyện, các buổi sinh hoạt chuyên đề do Học \nviện, lớp/chi đoàn, địa phương nơi cư trú  tổ chức  (2 điểm/1 hoạt động, tổng \nđiểm không vượt quá 10 điểm)");
        jTextArea5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea5.setMinimumSize(new java.awt.Dimension(500, 84));

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextArea6.setRows(2);
        jTextArea6.setText("Tiêu chí 3. Đánh giá về ý thức và kết quả tham gia hoạt động chính trị- xã hội, văn hóa, văn nghệ, thể thao, phòng chống tội phạm và\ncác tệ nạn xã hội ");
        jTextArea6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("3.1");
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel95.setPreferredSize(new java.awt.Dimension(2, 77));

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea7.setRows(3);
        jTextArea7.setText("Tham gia công tác xã hội như: hiến máu nhân đạo, ủng hộ người nghèo gặp \nthiên tai lũ lụt và các công tác xã hội khác (1 điểm/1 hoạt động tham gia, tổng \nđiểm không vượt quá 4 điểm)");
        jTextArea7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea8.setEditable(false);
        jTextArea8.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea8.setRows(2);
        jTextArea8.setText("Tuyên truyền tích cực hình ảnh về Trường/Khoa trên các trang mạng xã \nhội (1 điểm/1 hoạt động, tổng điểm không vượt quá 3 điểm)");
        jTextArea8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea9.setRows(3);
        jTextArea9.setText("Tích cực tham gia các hoạt động phòng, chống tội phạm, các tệ nạn xã hội, \nphát hiện và báo cáo kịp thời những hành vi có liên quan đến ma túy, các tệ \nnạn xã hội khác");
        jTextArea9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea10.setEditable(false);
        jTextArea10.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea10.setRows(2);
        jTextArea10.setText("Đưa các thông tin sai lệch, thông tin chưa được kiểm chứng, đăng bình luận \nkhông chính xác, thiếu tích cực về Học viện/ Khoa/ ngành đang học.");
        jTextArea10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel96.setText("Mức điểm tối đa Tiêu chí 3");
        jLabel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("3.2");
        jLabel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("3.3");
        jLabel98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("3.4");
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("3.5");
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("10 điểm");
        jLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv31TextField.setEditable(false);
        sv31TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs31TextField.setEditable(false);
        bcs31TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("20 điểm");
        jLabel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv3TextField.setEditable(false);
        sv3TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv3TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs3TextField.setEditable(false);
        bcs3TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs3TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv3TextField.setEditable(false);
        cv3TextField.setBackground(new java.awt.Color(240, 240, 240));
        cv3TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("4 điểm");
        jLabel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("3 điểm");
        jLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("3 điểm");
        jLabel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("- 10 điểm");
        jLabel107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv32TextField.setEditable(false);
        sv32TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv33TextField.setEditable(false);
        sv33TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv34TextField.setEditable(false);
        sv34TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv35TextField.setEditable(false);
        sv35TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs32TextField.setEditable(false);
        bcs32TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs33TextField.setEditable(false);
        bcs33TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs34TextField.setEditable(false);
        bcs34TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs35TextField.setEditable(false);
        bcs35TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel108.setText("Tiêu chí 4. Đánh giá ý thức công dân trong quan hệ cộng đồng ");
        jLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea11.setEditable(false);
        jTextArea11.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea11.setRows(2);
        jTextArea11.setText("Chấp hành nghiêm chỉnh chủ trương của Đảng, chính sách, pháp luật của \nNhà nước, Học viện và của địa phương nơi cư trú");
        jTextArea11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("4.1");
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea12.setEditable(false);
        jTextArea12.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea12.setRows(3);
        jTextArea12.setText("Tích cực tham gia tuyên truyền chủ trương của Đảng, chính sách, pháp luật \ncủa Nhà nước, Học viện  và quy định của địa phương nơi cư trú; có ý thức \nthực hiện giữ gìn vệ sinh chung");
        jTextArea12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("4.2");
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel111.setText("Có mối quan hệ đúng mực với Thầy/ Cô, cán bộ, nhân viên Học viện");
        jLabel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("4.3");
        jLabel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea13.setEditable(false);
        jTextArea13.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea13.setColumns(20);
        jTextArea13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea13.setRows(3);
        jTextArea13.setText("Có mối quan hệ tốt với bạn bè trong lớp và mọi người xung quanh; có tinh \nthần đoàn kết, chia sẻ, giúp đỡ nhau trong học tập và các vấn đề khác trong \ncộng đồng");
        jTextArea13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("4.4");
        jLabel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea14.setEditable(false);
        jTextArea14.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea14.setColumns(20);
        jTextArea14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea14.setRows(2);
        jTextArea14.setText("Được biểu dương khen thưởng trong các hoạt động liên quan đến ý thức \ncông dân trong quan hệ cộng đồng");
        jTextArea14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("4.5");
        jLabel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea15.setEditable(false);
        jTextArea15.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea15.setColumns(20);
        jTextArea15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea15.setRows(2);
        jTextArea15.setText("Vi phạm an ninh, trật tự xã hội; an toàn giao thông (có giấy báo của các cơ \nquan hữu quan)");
        jTextArea15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("4.6");
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel116.setText("Mức điểm tối đa Tiêu chí 4");
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea16.setEditable(false);
        jTextArea16.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea16.setColumns(20);
        jTextArea16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea16.setRows(2);
        jTextArea16.setText("Tiêu chí 5. Đánh giá về ý thức và kết quả tham gia phụ trách lớp, các đoàn thể trong nhà trường, thành tích đặc biệt trong học \ntập và rèn luyện ");
        jTextArea16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea17.setEditable(false);
        jTextArea17.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea17.setColumns(20);
        jTextArea17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea17.setRows(5);
        jTextArea17.setText("Sinh viên được Học viện phân công làm lớp trưởng, lớp phó; bí thư, phó bí thư \nchi đoàn, BCH đoàn Học viện/khoa; BCH Hội sinh viên Học viện/khoa; chủ \nnhiệm, phó chủ nhiệm các các Câu lạc bộ, đội nhóm trực thuộc Học viện/khoa \nđược tập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành nhiệm vụ. \n");
        jTextArea17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("5.1");
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea18.setEditable(false);
        jTextArea18.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea18.setColumns(20);
        jTextArea18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea18.setRows(3);
        jTextArea18.setText("Thành viên tham gia các Câu lạc bộ, đội nhóm trực thuộc Học viện /khoa được\ntập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành tốt nhiệm vụ; sinh \nviên tham gia tổ chức các chương trình, là cộng tác viên tham gia tích cực vào \ncác hoạt động chung cấp Học viện, khoa.");
        jTextArea18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("5.2");
        jLabel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel119.setText("Sinh viên đạt thành tích đặc biệt trong học tập, rèn luyện:");
        jLabel119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel120.setText("- Đạt giải thưởng trong nghiên cứu khoa học, các cuộc thi Olympic các cấp.");
        jLabel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea19.setEditable(false);
        jTextArea19.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea19.setColumns(20);
        jTextArea19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea19.setRows(2);
        jTextArea19.setText("- Đạt huy chương, giấy khen, giải thưởng các cấp về văn hóa, văn nghệ, thể \nthao, phòng chống các tệ nạn xã hội, hoạt động vì cộng đồng...\n");
        jTextArea19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("5.3");
        jLabel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel124.setText("Mức điểm tối đa Tiêu chí 5");
        jLabel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel126.setText("TỔNG CỘNG");
        jLabel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("8 điểm");
        jLabel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("5 điểm");
        jLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("5 điểm");
        jLabel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("5 điểm");
        jLabel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("2 điểm");
        jLabel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("- 5 điểm");
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("25 điểm");
        jLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("4 điểm");
        jLabel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("3 điểm");
        jLabel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("3 điểm");
        jLabel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel137.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("10 điểm");
        jLabel137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("100");
        jLabel138.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv41TextField.setEditable(false);
        sv41TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv42TextField.setEditable(false);
        sv42TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv43TextField.setEditable(false);
        sv43TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv44TextField.setEditable(false);
        sv44TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv45TextField.setEditable(false);
        sv45TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv46TextField.setEditable(false);
        sv46TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv4TextField.setEditable(false);
        sv4TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv51TextField.setEditable(false);
        sv51TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv52TextField.setEditable(false);
        sv52TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv53TextField.setEditable(false);
        sv53TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv5TextField.setEditable(false);
        sv5TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        svTongTextField.setEditable(false);
        svTongTextField.setBackground(new java.awt.Color(240, 240, 240));
        svTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs43TextField.setEditable(false);
        bcs43TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs4TextField.setEditable(false);
        bcs4TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs5TextField.setEditable(false);
        bcs5TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcsTongTextField.setEditable(false);
        bcsTongTextField.setBackground(new java.awt.Color(240, 240, 240));
        bcsTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs41TextField.setEditable(false);
        bcs41TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs42TextField.setEditable(false);
        bcs42TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs44TextField.setEditable(false);
        bcs44TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs45TextField.setEditable(false);
        bcs45TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs46TextField.setEditable(false);
        bcs46TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs51TextField.setEditable(false);
        bcs51TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs52TextField.setEditable(false);
        bcs52TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs53TextField.setEditable(false);
        bcs53TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv4TextField.setEditable(false);
        cv4TextField.setBackground(new java.awt.Color(240, 240, 240));
        cv4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv5TextField.setEditable(false);
        cv5TextField.setBackground(new java.awt.Color(240, 240, 240));
        cv5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cvTongTextField.setEditable(false);
        cvTongTextField.setBackground(new java.awt.Color(240, 240, 240));
        cvTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setText("Học kỳ:");

        txtHocKy.setEditable(false);
        txtHocKy.setBackground(new java.awt.Color(255, 255, 255));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setText("Năm học:");

        txtNamHoc.setEditable(false);
        txtNamHoc.setBackground(new java.awt.Color(255, 255, 255));

        cv13aTextFiel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13TextField.setEditable(false);
        sv13TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("d) Bị lập biên bản đình chỉ khi thi kết thúc học phần");
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("- 4 điểm");
        jLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("CHI TIẾT ĐIỂM RÈN LUYỆN ");

        btnChamDiem.setBackground(new java.awt.Color(0, 102, 255));
        btnChamDiem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnChamDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnChamDiem.setText("Chấm điểm");
        btnChamDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChamDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamDiemActionPerformed(evt);
            }
        });

        btnDienDiem.setBackground(new java.awt.Color(0, 102, 255));
        btnDienDiem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDienDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnDienDiem.setText("Tự động điền điểm");
        btnDienDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDienDiem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnDienDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDienDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                .addComponent(btnDienDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnChamDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnChamDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDienDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextArea20.setEditable(false);
        jTextArea20.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea20.setColumns(20);
        jTextArea20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea20.setRows(2);
        jTextArea20.setText("Thực hiện nghiêm túc các nội quy, quy chế, các quy định hiện hành trong \nHọc viện.");
        jTextArea20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea20.setMinimumSize(new java.awt.Dimension(406, 38));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel143.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel144.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12TextField.setEditable(false);
        sv12TextField.setBackground(new java.awt.Color(240, 240, 240));
        sv12TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs12TextField.setEditable(false);
        bcs12TextField.setBackground(new java.awt.Color(240, 240, 240));
        bcs12TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13aTextFiel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13aTextFiel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13aTextFiel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13aTextFiel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel171.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout formChamDiemCVHTPanelLayout = new javax.swing.GroupLayout(formChamDiemCVHTPanel);
        formChamDiemCVHTPanel.setLayout(formChamDiemCVHTPanelLayout);
        formChamDiemCVHTPanelLayout.setHorizontalGroup(
            formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jTextArea20, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                            .addComponent(jLabel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextArea3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextArea4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv22TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs22TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv22TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                .addComponent(sv23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv13aTextFiel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                .addComponent(sv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cv13aTextFiel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                .addComponent(sv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv13aTextFiel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cv13aTextFiel4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cv13aTextFiel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(sv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bcs11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bcs12TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cv12TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel62))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel69))
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel139)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel140)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextArea10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextArea7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextArea8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextArea9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, 0)
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, 0)
                                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, 0)
                                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bcs33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bcs32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bcs34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, 0)
                                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(sv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(bcs35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(cv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextArea16, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jTextArea12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jTextArea11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jTextArea13, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                    .addComponent(jTextArea14, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                                    .addComponent(jTextArea15, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, 0)
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(sv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, 0)
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bcs45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bcs46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, 0)
                                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jTextArea18, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jTextArea17, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextArea19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(svTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcsTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cvTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 208, Short.MAX_VALUE))
        );
        formChamDiemCVHTPanelLayout.setVerticalGroup(
            formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel69)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel70)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sv12TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bcs12TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv12TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cv13aTextFiel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv13aTextFiel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addComponent(cv13aTextFiel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(cv13aTextFiel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1, 1, 1)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cv13aTextFiel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bcs14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bcs15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv15TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bcs21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel171, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cv22TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs22TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv22TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel146, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv23TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel174, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bcs2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcs32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextArea11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextArea12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextArea13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jTextArea16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bcs51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel134, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextArea18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bcs53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formChamDiemCVHTPanelLayout.createSequentialGroup()
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextArea19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemCVHTPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(svTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcsTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cvTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(formChamDiemCVHTPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChamDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamDiemActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn lưu điểm")) {
            if (txtMaSinhVien.getText().isEmpty()) {
                DialogHelper.showError("Chưa chọn sinh viên");
            } else if (Validator.isBeforeToday(ngayKetThuc)
                    || trangThai.equalsIgnoreCase("Hết thời gian chấm")) {
                DialogHelper.showMessage("Hết thời gian chấm");
            } else if (trangThai.equalsIgnoreCase("Sinh viên đang chấm")
                    || trangThai.equalsIgnoreCase("Sinh viên đã chấm")
                    || trangThai.equalsIgnoreCase("Sinh viên kết thúc chấm")) {
                DialogHelper.showError("Ban cán sự chưa chấm điểm\nNếu muốn chấm điểm thay đổi trạng thái chấm điểm của ban cán sự");
            } else {
                try {
                    if (!Validator.isIntegerString(cv11TextField.getText())) {
                        DialogHelper.showError("Mục 1.1 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv12TextField.getText())) {
                        DialogHelper.showError("Mục 1.2 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv13TextField.getText())) {
                        DialogHelper.showError("Mục 1.3 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isDecimalString(cv14TextField.getText())) {
                        DialogHelper.showError("Mục 1.4 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv15TextField.getText())) {
                        DialogHelper.showError("Mục 1.5 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv21TextField.getText())) {
                        DialogHelper.showError("Mục 2.1 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv22TextField.getText())) {
                        DialogHelper.showError("Mục 2.2a không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv23TextField.getText())) {
                        DialogHelper.showError("Mục 2.3a không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv31TextField.getText())) {
                        DialogHelper.showError("Mục 3.1 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv32TextField.getText())) {
                        DialogHelper.showError("Mục 3.2 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv33TextField.getText())) {
                        DialogHelper.showError("Mục 3.3 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv34TextField.getText())) {
                        DialogHelper.showError("Mục 3.4 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv35TextField.getText())) {
                        DialogHelper.showError("Mục 3.5 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv41TextField.getText())) {
                        DialogHelper.showError("Mục 4.1 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv42TextField.getText())) {
                        DialogHelper.showError("Mục 4.2 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv43TextField.getText())) {
                        DialogHelper.showError("Mục 4.3 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv44TextField.getText())) {
                        DialogHelper.showError("Mục 4.4 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv45TextField.getText())) {
                        DialogHelper.showError("Mục 4.5 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv46TextField.getText())) {
                        DialogHelper.showError("Mục 4.6 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv51TextField.getText())) {
                        DialogHelper.showError("Mục 5.1 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv52TextField.getText())) {
                        DialogHelper.showError("Mục 5.2 không hợp lệ. Vui lòng nhập lại!");
                    } else if (!Validator.isIntegerString(cv53TextField.getText())) {
                        DialogHelper.showError("Mục 5.3 không hợp lệ. Vui lòng nhập lại!");
                    } else {
                        String maSinhVien = txtMaSinhVien.getText();
                        String hocKy = txtHocKy.getText();
                        String namHoc = txtNamHoc.getText();
                        String maPhieuDRL = DiemRenLuyenCtrl.timMaPhieuDRL(maSinhVien, hocKy, namHoc);

                        String nguoiCham = "CoVan";
                        String trangThaiCham = "Cố vấn đã chấm";
                        CoVanModel cv = CoVanCtrl.timCoVanTheoTenDangNhap(DangNhap.username);
                        String maCoVanCham = cv.getMaCoVan();

                        float cv1 = Float.parseFloat(cv1TextField.getText());
                        int cv2 = Integer.parseInt(cv2TextField.getText());
                        int cv3 = Integer.parseInt(cv3TextField.getText());
                        int cv4 = Integer.parseInt(cv4TextField.getText());
                        int cv5 = Integer.parseInt(cv5TextField.getText());
                        float tongDiem = Float.parseFloat(cvTongTextField.getText());
                        String xepLoai = "";
                        if (tongDiem >= 90) {
                            xepLoai = "Xuất sắc";
                        } else if (tongDiem >= 80) {
                            xepLoai = "Tốt";
                        } else if (tongDiem >= 65) {
                            xepLoai = "Khá";
                        } else if (tongDiem >= 50) {
                            xepLoai = "Trung bình";
                        } else if (tongDiem >= 35) {
                            xepLoai = "Yếu";
                        } else {
                            xepLoai = "Kém";
                        }
                        int cv11 = Integer.parseInt(cv11TextField.getText());
                        int cv12 = Integer.parseInt(cv12TextField.getText());
                        int cv13 = Integer.parseInt(cv13TextField.getText());
                        float cv14 = Float.parseFloat(cv14TextField.getText());
                        int cv15 = Integer.parseInt(cv15TextField.getText());

                        int cv21 = Integer.parseInt(cv21TextField.getText());
                        int cv22 = Integer.parseInt(cv22TextField.getText());
                        int cv23 = Integer.parseInt(cv23TextField.getText());

                        int cv31 = Integer.parseInt(cv31TextField.getText());
                        int cv32 = Integer.parseInt(cv32TextField.getText());
                        int cv33 = Integer.parseInt(cv33TextField.getText());
                        int cv34 = Integer.parseInt(cv34TextField.getText());
                        int cv35 = Integer.parseInt(cv35TextField.getText());

                        int cv41 = Integer.parseInt(cv41TextField.getText());
                        int cv42 = Integer.parseInt(cv42TextField.getText());
                        int cv43 = Integer.parseInt(cv43TextField.getText());
                        int cv44 = Integer.parseInt(cv44TextField.getText());
                        int cv45 = Integer.parseInt(cv45TextField.getText());
                        int cv46 = Integer.parseInt(cv46TextField.getText());

                        int cv51 = Integer.parseInt(cv51TextField.getText());
                        int cv52 = Integer.parseInt(cv52TextField.getText());
                        int cv53 = Integer.parseInt(cv53TextField.getText());

                        if (maSinhVien.isEmpty()) {
                            DialogHelper.showError("Mã sinh viên không được để trống");
                        } else if (hocKy.isEmpty()) {
                            DialogHelper.showError("Học kỳ không được để trống");
                        } else if (namHoc.isEmpty()) {
                            DialogHelper.showError("Năm học không được để trống");
                        } else if (nguoiCham.isEmpty()) {
                            DialogHelper.showError("Người chấm không được để trống");
                        } else if (xepLoai.isEmpty()) {
                            DialogHelper.showError("Xếp loại không được để trống");
                        } else if (cv11 != 0 && (cv11 < 0 || cv11 > 3)) {
                            DialogHelper.showError("Mục 1.1 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv12 != 0 && !(cv12 == -1 || cv12 == 0 || cv12 == 4 || cv12 == 6 || cv12 == 8 || cv12 == 10)) {
                            DialogHelper.showError("Mục 1.2 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv13 != 0 && !(cv13 == 0 || cv13 == 1 || cv13 == 2 || cv13 == 4)) {
                            DialogHelper.showError("Mục 1.3 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv14 != 0 && (cv14 < 0 || cv14 > 2)) {
                            DialogHelper.showError("Mục 1.4 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv15 != 0 && (cv15 != 1)) {
                            DialogHelper.showError("Mục 1.5 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv21 != 0 && (cv21 != 10 || cv21 != 15)) {
                            DialogHelper.showError("Mục 2.1 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv22 != 0 && (cv22 < 0 || cv22 > 5)) {
                            DialogHelper.showError("Mục 2.2a không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv23 != 0 && (cv23 < 0 || cv23 > 5)) {
                            DialogHelper.showError("Mục 2.3a không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv31 != 0 && (cv31 < 0 || cv31 > 10)) {
                            DialogHelper.showError("Mục 3.1 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv32 != 0 && (cv32 < 0 || cv32 > 4)) {
                            DialogHelper.showError("Mục 3.2 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv33 != 0 && (cv33 < 0 || cv33 > 3)) {
                            DialogHelper.showError("Mục 3.3 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv34 != 0 && (cv34 < 0 || cv34 > 3)) {
                            DialogHelper.showError("Mục 3.4 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv35 != 0 && (cv35 != -10)) {
                            DialogHelper.showError("Mục 3.5 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv41 != 0 && (cv41 < 0 || cv41 > 8)) {
                            DialogHelper.showError("Mục 4.1 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv42 != 0 && (cv42 < 0 || cv42 > 5)) {
                            DialogHelper.showError("Mục 4.2 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv43 != 0 && (cv43 < 0 || cv43 > 5)) {
                            DialogHelper.showError("Mục 4.3 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv44 != 0 && (cv44 < 0 || cv44 > 5)) {
                            DialogHelper.showError("Mục 4.4 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv45 != 0 && (cv45 < 0 || cv45 > 2)) {
                            DialogHelper.showError("Mục 4.5 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv46 != 0 && (cv46 != -5)) {
                            DialogHelper.showError("Mục 4.6 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv51 != 0 && (cv51 < 0 || cv51 > 4)) {
                            DialogHelper.showError("Mục 5.1 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv52 != 0 && (cv52 < 0 || cv52 > 3)) {
                            DialogHelper.showError("Mục 5.2 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv53 != 0 && (cv53 < 0 || cv53 > 3)) {
                            DialogHelper.showError("Mục 5.3 không hợp lệ. Vui lòng nhập lại!");
                        } else if (cv1 != 0 && (cv1 < 0 || cv1 > 20)) {
                            DialogHelper.showError("Tổng điểm tiêu chí 1 không chính xác");
                        } else if (cv2 != 0 && (cv2 < 0 || cv2 > 25)) {
                            DialogHelper.showError("Tổng điểm tiêu chí 2 không chính xác");
                        } else if (cv3 != 0 && (cv3 < 0 || cv3 > 20)) {
                            DialogHelper.showError("Tổng điểm tiêu chí 3 không chính xác");
                        } else if (cv4 != 0 && (cv4 < 0 || cv4 > 25)) {
                            DialogHelper.showError("Tổng điểm tiêu chí 4 không chính xác");
                        } else if (cv5 != 0 && (cv5 < 0 || cv5 > 10)) {
                            DialogHelper.showError("Tổng điểm tiêu chí 5 không chính xác");
                        } else if (tongDiem != 0 && (tongDiem < 0 || tongDiem > 100)) {
                            DialogHelper.showError("Tổng điểm không chính xác");
                        } else if (cv1 + cv2 + cv3 + cv4 + cv5 != tongDiem) {
                            DialogHelper.showError("Tổng điểm các chỉ tiêu không bằng tổng điểm. Vui lòng nhập lại!");
                        } else {
                            try {
                                DiemRenLuyenModel drl = new DiemRenLuyenModel(maPhieuDRL, nguoiCham, xepLoai, tongDiem, cv11, cv12, cv13, cv14, cv15, cv1, cv21, cv22, cv23, cv2, cv31, cv32, cv33, cv34, cv35, cv3, cv41, cv42, cv43, cv44, cv45, cv46, cv4, cv51, cv52, cv53, cv5);
                                DiemRenLuyenCtrl.chamDiemRenLuyen(drl);
                                PhieuDRLModel phieu = new PhieuDRLModel(maPhieuDRL, maCoVanCham, trangThaiCham);
                                PhieuDRLCtrl.capNhatTrangThaiCham(phieu);
                                DialogHelper.showMessage("Chấm điểm thành công!");
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(FormChamDiemCVHT.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormChamDiemCVHT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnChamDiemActionPerformed

    private void txtMaSinhVienAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMaSinhVienAncestorAdded
        try {
            String maSinhVien = txtMaSinhVien.getText();
            String hocKy = txtHocKy.getText();
            String namHoc = txtNamHoc.getText();
            lamMoi();
            DiemRenLuyenModel diemRenLuyenSV = DiemRenLuyenCtrl.timDRLDayDu(maSinhVien, hocKy, namHoc, "SinhVien");
            if (diemRenLuyenSV != null) {
                trangThai = diemRenLuyenSV.getTrangThaiCham();
                ngayKetThuc = diemRenLuyenSV.getNgayKetThuc();
                txtNgaySinh.setText(dateFormat.format(diemRenLuyenSV.getNgaySinh()));
                txtLop.setText(diemRenLuyenSV.getMaLop());

                sv11TextField.setText(Integer.toString(diemRenLuyenSV.getD11()));
                sv12TextField.setText(Integer.toString(diemRenLuyenSV.getD12()));
                sv13TextField.setText(Integer.toString(diemRenLuyenSV.getD13()));
                sv14TextField.setText(Float.toString(diemRenLuyenSV.getD14()));
                sv15TextField.setText(Integer.toString(diemRenLuyenSV.getD15()));
                sv1TextField.setText(Float.toString(diemRenLuyenSV.getD1()));

                sv21TextField.setText(Integer.toString(diemRenLuyenSV.getD21()));
                sv22TextField.setText(Integer.toString(diemRenLuyenSV.getD22()));
                sv23TextField.setText(Integer.toString(diemRenLuyenSV.getD23()));
                sv2TextField.setText(Integer.toString(diemRenLuyenSV.getD2()));

                sv31TextField.setText(Integer.toString(diemRenLuyenSV.getD31()));
                sv32TextField.setText(Integer.toString(diemRenLuyenSV.getD32()));
                sv33TextField.setText(Integer.toString(diemRenLuyenSV.getD33()));
                sv34TextField.setText(Integer.toString(diemRenLuyenSV.getD34()));
                sv35TextField.setText(Integer.toString(diemRenLuyenSV.getD35()));
                sv3TextField.setText(Integer.toString(diemRenLuyenSV.getD3()));

                sv41TextField.setText(Integer.toString(diemRenLuyenSV.getD41()));
                sv42TextField.setText(Integer.toString(diemRenLuyenSV.getD42()));
                sv43TextField.setText(Integer.toString(diemRenLuyenSV.getD43()));
                sv44TextField.setText(Integer.toString(diemRenLuyenSV.getD44()));
                sv45TextField.setText(Integer.toString(diemRenLuyenSV.getD45()));
                sv46TextField.setText(Integer.toString(diemRenLuyenSV.getD46()));
                sv4TextField.setText(Integer.toString(diemRenLuyenSV.getD4()));

                sv51TextField.setText(Integer.toString(diemRenLuyenSV.getD51()));
                sv52TextField.setText(Integer.toString(diemRenLuyenSV.getD52()));
                sv53TextField.setText(Integer.toString(diemRenLuyenSV.getD53()));
                sv5TextField.setText(Integer.toString(diemRenLuyenSV.getD5()));

                svTongTextField.setText(Float.toString(diemRenLuyenSV.getTongDiem()));
            }

            DiemRenLuyenModel diemRenLuyenBCS = DiemRenLuyenCtrl.timDRLDayDu(maSinhVien, hocKy, namHoc, "BanCanSu");
            if (diemRenLuyenBCS != null) {
                bcs11TextField.setText(Integer.toString(diemRenLuyenBCS.getD11()));
                bcs12TextField.setText(Integer.toString(diemRenLuyenBCS.getD12()));
                bcs13TextField.setText(Integer.toString(diemRenLuyenBCS.getD13()));
                bcs14TextField.setText(Float.toString(diemRenLuyenBCS.getD14()));
                bcs15TextField.setText(Integer.toString(diemRenLuyenBCS.getD15()));
                bcs1TextField.setText(Float.toString(diemRenLuyenBCS.getD1()));

                bcs21TextField.setText(Integer.toString(diemRenLuyenBCS.getD21()));
                bcs22TextField.setText(Integer.toString(diemRenLuyenBCS.getD22()));
                bcs23TextField.setText(Integer.toString(diemRenLuyenBCS.getD23()));
                bcs2TextField.setText(Integer.toString(diemRenLuyenBCS.getD2()));

                bcs31TextField.setText(Integer.toString(diemRenLuyenBCS.getD31()));
                bcs32TextField.setText(Integer.toString(diemRenLuyenBCS.getD32()));
                bcs33TextField.setText(Integer.toString(diemRenLuyenBCS.getD33()));
                bcs34TextField.setText(Integer.toString(diemRenLuyenBCS.getD34()));
                bcs35TextField.setText(Integer.toString(diemRenLuyenBCS.getD35()));
                bcs3TextField.setText(Integer.toString(diemRenLuyenBCS.getD3()));

                bcs41TextField.setText(Integer.toString(diemRenLuyenBCS.getD41()));
                bcs42TextField.setText(Integer.toString(diemRenLuyenBCS.getD42()));
                bcs43TextField.setText(Integer.toString(diemRenLuyenBCS.getD43()));
                bcs44TextField.setText(Integer.toString(diemRenLuyenBCS.getD44()));
                bcs45TextField.setText(Integer.toString(diemRenLuyenBCS.getD45()));
                bcs46TextField.setText(Integer.toString(diemRenLuyenBCS.getD46()));
                bcs4TextField.setText(Integer.toString(diemRenLuyenBCS.getD4()));

                bcs51TextField.setText(Integer.toString(diemRenLuyenBCS.getD51()));
                bcs52TextField.setText(Integer.toString(diemRenLuyenBCS.getD52()));
                bcs53TextField.setText(Integer.toString(diemRenLuyenBCS.getD53()));
                bcs5TextField.setText(Integer.toString(diemRenLuyenBCS.getD5()));

                bcsTongTextField.setText(Float.toString(diemRenLuyenBCS.getTongDiem()));
            }

            DiemRenLuyenModel diemRenLuyenCoVan = DiemRenLuyenCtrl.timDRLDayDu(maSinhVien, hocKy, namHoc, "CoVan");
            if (diemRenLuyenCoVan != null) {
                cv11TextField.setText(Integer.toString(diemRenLuyenCoVan.getD11()));
                cv12TextField.setText(Integer.toString(diemRenLuyenCoVan.getD12()));
                cv13TextField.setText(Integer.toString(diemRenLuyenCoVan.getD13()));
                cv14TextField.setText(Float.toString(diemRenLuyenCoVan.getD14()));
                cv15TextField.setText(Integer.toString(diemRenLuyenCoVan.getD15()));
                cv1TextField.setText(Float.toString(diemRenLuyenCoVan.getD1()));

                cv21TextField.setText(Integer.toString(diemRenLuyenCoVan.getD21()));
                cv22TextField.setText(Integer.toString(diemRenLuyenCoVan.getD22()));
                cv23TextField.setText(Integer.toString(diemRenLuyenCoVan.getD23()));
                cv2TextField.setText(Integer.toString(diemRenLuyenCoVan.getD2()));

                cv31TextField.setText(Integer.toString(diemRenLuyenCoVan.getD31()));
                cv32TextField.setText(Integer.toString(diemRenLuyenCoVan.getD32()));
                cv33TextField.setText(Integer.toString(diemRenLuyenCoVan.getD33()));
                cv34TextField.setText(Integer.toString(diemRenLuyenCoVan.getD34()));
                cv35TextField.setText(Integer.toString(diemRenLuyenCoVan.getD35()));
                cv3TextField.setText(Integer.toString(diemRenLuyenCoVan.getD3()));

                cv41TextField.setText(Integer.toString(diemRenLuyenCoVan.getD41()));
                cv42TextField.setText(Integer.toString(diemRenLuyenCoVan.getD42()));
                cv43TextField.setText(Integer.toString(diemRenLuyenCoVan.getD43()));
                cv44TextField.setText(Integer.toString(diemRenLuyenCoVan.getD44()));
                cv45TextField.setText(Integer.toString(diemRenLuyenCoVan.getD45()));
                cv46TextField.setText(Integer.toString(diemRenLuyenCoVan.getD46()));
                cv4TextField.setText(Integer.toString(diemRenLuyenCoVan.getD4()));

                cv51TextField.setText(Integer.toString(diemRenLuyenCoVan.getD51()));
                cv52TextField.setText(Integer.toString(diemRenLuyenCoVan.getD52()));
                cv53TextField.setText(Integer.toString(diemRenLuyenCoVan.getD53()));
                cv5TextField.setText(Integer.toString(diemRenLuyenCoVan.getD5()));

                cvTongTextField.setText(Float.toString(diemRenLuyenCoVan.getTongDiem()));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormChamDiemSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMaSinhVienAncestorAdded

    private void btnDienDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDienDiemActionPerformed
        if (txtMaSinhVien.getText().isEmpty()) {
            DialogHelper.showError("Chưa chọn sinh viên");
        } else {
            dienDiem();
        }
    }//GEN-LAST:event_btnDienDiemActionPerformed

    private void formChamDiemCVHTPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formChamDiemCVHTPanelMouseExited
        if (!Validator.isIntegerString(cv11TextField.getText())) {
        } else if (!Validator.isIntegerString(cv12TextField.getText())) {
        } else if (!Validator.isIntegerString(cv13TextField.getText())) {
        } else if (!Validator.isDecimalString(cv14TextField.getText())) {
        } else if (!Validator.isIntegerString(cv15TextField.getText())) {
        } else if (!Validator.isIntegerString(cv21TextField.getText())) {
        } else if (!Validator.isIntegerString(cv22TextField.getText())) {
        } else if (!Validator.isIntegerString(cv23TextField.getText())) {
        } else if (!Validator.isIntegerString(cv31TextField.getText())) {
        } else if (!Validator.isIntegerString(cv32TextField.getText())) {
        } else if (!Validator.isIntegerString(cv33TextField.getText())) {
        } else if (!Validator.isIntegerString(cv34TextField.getText())) {
        } else if (!Validator.isIntegerString(cv35TextField.getText())) {
        } else if (!Validator.isIntegerString(cv41TextField.getText())) {
        } else if (!Validator.isIntegerString(cv42TextField.getText())) {
        } else if (!Validator.isIntegerString(cv43TextField.getText())) {
        } else if (!Validator.isIntegerString(cv44TextField.getText())) {
        } else if (!Validator.isIntegerString(cv45TextField.getText())) {
        } else if (!Validator.isIntegerString(cv46TextField.getText())) {
        } else if (!Validator.isIntegerString(cv51TextField.getText())) {
        } else if (!Validator.isIntegerString(cv52TextField.getText())) {
        } else if (!Validator.isIntegerString(cv53TextField.getText())) {
        } else {
            if (!cv11TextField.getText().isEmpty() && !cv12TextField.getText().isEmpty() && !cv13TextField.getText().isEmpty()
                    && !cv14TextField.getText().isEmpty() && !cv15TextField.getText().isEmpty() && !cv1TextField.getText().isEmpty()
                    && !cv21TextField.getText().isEmpty() && !cv22TextField.getText().isEmpty() && !cv23TextField.getText().isEmpty()
                    && !cv2TextField.getText().isEmpty() && !cv31TextField.getText().isEmpty()
                    && !cv32TextField.getText().isEmpty() && !cv33TextField.getText().isEmpty() && !cv34TextField.getText().isEmpty()
                    && !cv35TextField.getText().isEmpty() && !cv3TextField.getText().isEmpty() && !cv41TextField.getText().isEmpty()
                    && !cv42TextField.getText().isEmpty() && !cv43TextField.getText().isEmpty() && !cv44TextField.getText().isEmpty()
                    && !cv45TextField.getText().isEmpty() && !cv46TextField.getText().isEmpty() && !cv4TextField.getText().isEmpty()
                    && !cv51TextField.getText().isEmpty() && !cv52TextField.getText().isEmpty() && !cv53TextField.getText().isEmpty()
                    && !cv5TextField.getText().isEmpty() && !cvTongTextField.getText().isEmpty()) {
                int d11 = Integer.parseInt(cv11TextField.getText());
                int d12 = Integer.parseInt(cv12TextField.getText());
                int d13 = Integer.parseInt(cv13TextField.getText());
                float d14 = Float.parseFloat(cv14TextField.getText());
                int d15 = Integer.parseInt(cv15TextField.getText());
                float d1 = d11 + d12 + d13 + d14 + d15;
                cv1TextField.setText(Float.toString(d1));

                int d21 = Integer.parseInt(cv21TextField.getText());
                int d22 = Integer.parseInt(cv22TextField.getText());
                int d23 = Integer.parseInt(cv23TextField.getText());
                int d2 = d21 + d22 + d23;
                cv2TextField.setText(Integer.toString(d2));

                int d31 = Integer.parseInt(cv31TextField.getText());
                int d32 = Integer.parseInt(cv32TextField.getText());
                int d33 = Integer.parseInt(cv33TextField.getText());
                int d34 = Integer.parseInt(cv34TextField.getText());
                int d35 = Integer.parseInt(cv35TextField.getText());
                int d3 = d31 + d32 + d33 + d34 + d35;
                cv3TextField.setText(Integer.toString(d3));

                int d41 = Integer.parseInt(cv41TextField.getText());
                int d42 = Integer.parseInt(cv42TextField.getText());
                int d43 = Integer.parseInt(cv43TextField.getText());
                int d44 = Integer.parseInt(cv44TextField.getText());
                int d45 = Integer.parseInt(cv45TextField.getText());
                int d46 = Integer.parseInt(cv46TextField.getText());
                int d4 = d41 + d42 + d43 + d44 + d45 + d46;
                cv4TextField.setText(Integer.toString(d4));

                int d51 = Integer.parseInt(cv51TextField.getText());
                int d52 = Integer.parseInt(cv52TextField.getText());
                int d53 = Integer.parseInt(cv53TextField.getText());
                int d5 = d51 + d52 + d53;
                cv5TextField.setText(Integer.toString(d5));

                cvTongTextField.setText(Float.toString(d1 + d2 + d3 + d4 + d5));
            }
        }
    }//GEN-LAST:event_formChamDiemCVHTPanelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bcs11TextField;
    private javax.swing.JTextField bcs12TextField;
    private javax.swing.JTextField bcs13TextField;
    private javax.swing.JTextField bcs14TextField;
    private javax.swing.JTextField bcs15TextField;
    private javax.swing.JTextField bcs1TextField;
    private javax.swing.JTextField bcs21TextField;
    private javax.swing.JTextField bcs22TextField;
    private javax.swing.JTextField bcs23TextField;
    private javax.swing.JTextField bcs2TextField;
    private javax.swing.JTextField bcs31TextField;
    private javax.swing.JTextField bcs32TextField;
    private javax.swing.JTextField bcs33TextField;
    private javax.swing.JTextField bcs34TextField;
    private javax.swing.JTextField bcs35TextField;
    private javax.swing.JTextField bcs3TextField;
    private javax.swing.JTextField bcs41TextField;
    private javax.swing.JTextField bcs42TextField;
    private javax.swing.JTextField bcs43TextField;
    private javax.swing.JTextField bcs44TextField;
    private javax.swing.JTextField bcs45TextField;
    private javax.swing.JTextField bcs46TextField;
    private javax.swing.JTextField bcs4TextField;
    private javax.swing.JTextField bcs51TextField;
    private javax.swing.JTextField bcs52TextField;
    private javax.swing.JTextField bcs53TextField;
    private javax.swing.JTextField bcs5TextField;
    private javax.swing.JTextField bcsTongTextField;
    private javax.swing.JButton btnChamDiem;
    private javax.swing.JButton btnDienDiem;
    private javax.swing.JTextField cv11TextField;
    private javax.swing.JTextField cv12TextField;
    private javax.swing.JTextField cv13TextField;
    private javax.swing.JLabel cv13aTextFiel1;
    private javax.swing.JLabel cv13aTextFiel2;
    private javax.swing.JLabel cv13aTextFiel3;
    private javax.swing.JLabel cv13aTextFiel4;
    private javax.swing.JLabel cv13aTextFiel5;
    private javax.swing.JTextField cv14TextField;
    private javax.swing.JTextField cv15TextField;
    private javax.swing.JTextField cv1TextField;
    private javax.swing.JTextField cv21TextField;
    private javax.swing.JTextField cv22TextField;
    private javax.swing.JTextField cv23TextField;
    private javax.swing.JTextField cv2TextField;
    private javax.swing.JTextField cv31TextField;
    private javax.swing.JTextField cv32TextField;
    private javax.swing.JTextField cv33TextField;
    private javax.swing.JTextField cv34TextField;
    private javax.swing.JTextField cv35TextField;
    private javax.swing.JTextField cv3TextField;
    private javax.swing.JTextField cv41TextField;
    private javax.swing.JTextField cv42TextField;
    private javax.swing.JTextField cv43TextField;
    private javax.swing.JTextField cv44TextField;
    private javax.swing.JTextField cv45TextField;
    private javax.swing.JTextField cv46TextField;
    private javax.swing.JTextField cv4TextField;
    private javax.swing.JTextField cv51TextField;
    private javax.swing.JTextField cv52TextField;
    private javax.swing.JTextField cv53TextField;
    private javax.swing.JTextField cv5TextField;
    private javax.swing.JTextField cvTongTextField;
    private javax.swing.JPanel formChamDiemCVHTPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextArea16;
    private javax.swing.JTextArea jTextArea17;
    private javax.swing.JTextArea jTextArea18;
    private javax.swing.JTextArea jTextArea19;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea20;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField sv11TextField;
    private javax.swing.JTextField sv12TextField;
    private javax.swing.JTextField sv13TextField;
    private javax.swing.JTextField sv14TextField;
    private javax.swing.JTextField sv15TextField;
    private javax.swing.JTextField sv1TextField;
    private javax.swing.JTextField sv21TextField;
    private javax.swing.JTextField sv22TextField;
    private javax.swing.JTextField sv23TextField;
    private javax.swing.JTextField sv2TextField;
    private javax.swing.JTextField sv31TextField;
    private javax.swing.JTextField sv32TextField;
    private javax.swing.JTextField sv33TextField;
    private javax.swing.JTextField sv34TextField;
    private javax.swing.JTextField sv35TextField;
    private javax.swing.JTextField sv3TextField;
    private javax.swing.JTextField sv41TextField;
    private javax.swing.JTextField sv42TextField;
    private javax.swing.JTextField sv43TextField;
    private javax.swing.JTextField sv44TextField;
    private javax.swing.JTextField sv45TextField;
    private javax.swing.JTextField sv46TextField;
    private javax.swing.JTextField sv4TextField;
    private javax.swing.JTextField sv51TextField;
    private javax.swing.JTextField sv52TextField;
    private javax.swing.JTextField sv53TextField;
    private javax.swing.JTextField sv5TextField;
    private javax.swing.JTextField svTongTextField;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtNgaySinh;
    // End of variables declaration//GEN-END:variables
}
