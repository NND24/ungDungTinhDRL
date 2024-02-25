package views.main;

import controllers.DiemRenLuyenCtrl;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.DiemRenLuyenModel;
import utils.DialogHelper;

public class FormChamDiemBCS extends javax.swing.JPanel {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static FormChamDiemBCS Instance;
    public JTextField maSVTextField;
    public JTextField nameTextField;
    public JTextField semesterTextField;
    public JTextField scholasticTextField;

    private String trangThai = "";

    public FormChamDiemBCS() {
        initComponents();

        Instance = this;
        maSVTextField = maSinhVienTextField;
        nameTextField = hoTenTextField;
        semesterTextField = hocKyTextField;
        scholasticTextField = namHocTextField;
    }

    private void lamMoi() {
        sv11TextField.setText("0");
        sv12aTextField.setText("0");
        sv12bTextField.setText("0");
        sv12cTextField.setText("0");
        sv12dTextField.setText("0");
        sv12eTextField.setText("0");
        sv12gTextField.setText("0");
        sv13TextField.setText("0");
        sv13aTextField.setText("0");
        sv13bTextField.setText("0");
        sv13cTextField.setText("0");
        sv13dTextField.setText("0");
        sv14TextField.setText("0");
        sv15TextField.setText("0");
        sv1TextField.setText("0");

        sv21TextField.setText("0");
        sv21aTextField.setText("0");
        sv21bTextField.setText("0");
        sv22aTextField.setText("0");
        sv22bTextField.setText("0");
        sv23aTextField.setText("0");
        sv23bTextField.setText("0");
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
        bcs12aTextField.setText("0");
        bcs12bTextField.setText("0");
        bcs12cTextField.setText("0");
        bcs12dTextField.setText("0");
        bcs12eTextField.setText("0");
        bcs12gTextField.setText("0");
        bcs13TextField.setText("0");
        bcs13aTextField.setText("0");
        bcs13bTextField.setText("0");
        bcs13cTextField.setText("0");
        bcs13dTextField.setText("0");
        bcs14TextField.setText("0");
        bcs15TextField.setText("0");
        bcs1TextField.setText("0");

        bcs21TextField.setText("0");
        bcs21aTextField.setText("0");
        bcs21bTextField.setText("0");
        bcs22aTextField.setText("0");
        bcs22bTextField.setText("0");
        bcs23aTextField.setText("0");
        bcs23bTextField.setText("0");
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
        cv12aTextField.setText("0");
        cv12bTextField.setText("0");
        cv12cTextField.setText("0");
        cv12dTextField.setText("0");
        cv12eTextField.setText("0");
        cv12gTextField.setText("0");
        cv13TextField.setText("0");
        cv13aTextField.setText("0");
        cv13bTextField.setText("0");
        cv13cTextField.setText("0");
        cv13dTextField.setText("0");
        cv14TextField.setText("0");
        cv15TextField.setText("0");
        cv1TextField.setText("0");

        cv21TextField.setText("0");
        cv21aTextField.setText("0");
        cv21bTextField.setText("0");
        cv22aTextField.setText("0");
        cv22bTextField.setText("0");
        cv23aTextField.setText("0");
        cv23bTextField.setText("0");
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
        int bcs11 = Integer.parseInt(sv11TextField.getText());
        int bcs12a = Integer.parseInt(sv12aTextField.getText());
        int bcs12b = Integer.parseInt(sv12bTextField.getText());
        int bcs12c = Integer.parseInt(sv12cTextField.getText());
        int bcs12d = Integer.parseInt(sv12dTextField.getText());
        int bcs12e = Integer.parseInt(sv12eTextField.getText());
        int bcs12g = Integer.parseInt(sv12gTextField.getText());
        int bcs13 = Integer.parseInt(sv13TextField.getText());
        int bcs13a = Integer.parseInt(sv13aTextField.getText());
        int bcs13b = Integer.parseInt(sv13bTextField.getText());
        int bcs13c = Integer.parseInt(sv13cTextField.getText());
        int bcs13d = Integer.parseInt(sv13dTextField.getText());
        float bcs14 = Float.parseFloat(sv14TextField.getText());
        int bcs15 = Integer.parseInt(sv15TextField.getText());
        float bcs1 = Float.parseFloat(sv1TextField.getText());

        int bcs21 = Integer.parseInt(sv21TextField.getText());
        int bcs21a = Integer.parseInt(sv21aTextField.getText());
        int bcs21b = Integer.parseInt(sv21bTextField.getText());
        int bcs22a = Integer.parseInt(sv22aTextField.getText());
        int bcs22b = Integer.parseInt(sv22bTextField.getText());
        int bcs23a = Integer.parseInt(sv23aTextField.getText());
        int bcs23b = Integer.parseInt(sv23bTextField.getText());
        int bcs2 = Integer.parseInt(sv2TextField.getText());

        int bcs31 = Integer.parseInt(sv31TextField.getText());
        int bcs32 = Integer.parseInt(sv32TextField.getText());
        int bcs33 = Integer.parseInt(sv33TextField.getText());
        int bcs34 = Integer.parseInt(sv34TextField.getText());
        int bcs35 = Integer.parseInt(sv35TextField.getText());
        int bcs3 = Integer.parseInt(sv3TextField.getText());

        int bcs41 = Integer.parseInt(sv41TextField.getText());
        int bcs42 = Integer.parseInt(sv42TextField.getText());
        int bcs43 = Integer.parseInt(sv43TextField.getText());
        int bcs44 = Integer.parseInt(sv44TextField.getText());
        int bcs45 = Integer.parseInt(sv45TextField.getText());
        int bcs46 = Integer.parseInt(sv46TextField.getText());
        int bcs4 = Integer.parseInt(sv4TextField.getText());

        int bcs51 = Integer.parseInt(sv51TextField.getText());
        int bcs52 = Integer.parseInt(sv52TextField.getText());
        int bcs53 = Integer.parseInt(sv33TextField.getText());
        int bcs5 = Integer.parseInt(sv5TextField.getText());

        float tongDiem = Float.parseFloat(svTongTextField.getText());

        bcs11TextField.setText(Integer.toString(bcs11));
        bcs12aTextField.setText(Integer.toString(bcs12a));
        bcs12bTextField.setText(Integer.toString(bcs12b));
        bcs12cTextField.setText(Integer.toString(bcs12c));
        bcs12dTextField.setText(Integer.toString(bcs12d));
        bcs12eTextField.setText(Integer.toString(bcs12e));
        bcs12gTextField.setText(Integer.toString(bcs12g));
        bcs13TextField.setText(Integer.toString(bcs13));
        bcs13aTextField.setText(Integer.toString(bcs13a));
        bcs13bTextField.setText(Integer.toString(bcs13b));
        bcs13cTextField.setText(Integer.toString(bcs13c));
        bcs13dTextField.setText(Integer.toString(bcs13d));
        bcs14TextField.setText(Float.toString(bcs14));
        bcs15TextField.setText(Integer.toString(bcs15));
        bcs1TextField.setText(Float.toString(bcs1));

        bcs21TextField.setText(Integer.toString(bcs21));
        bcs21aTextField.setText(Integer.toString(bcs21a));
        bcs21bTextField.setText(Integer.toString(bcs21b));
        bcs22aTextField.setText(Integer.toString(bcs22a));
        bcs22bTextField.setText(Integer.toString(bcs22b));
        bcs23aTextField.setText(Integer.toString(bcs23a));
        bcs23bTextField.setText(Integer.toString(bcs23b));
        bcs2TextField.setText(Integer.toString(bcs2));

        bcs31TextField.setText(Integer.toString(bcs31));
        bcs32TextField.setText(Integer.toString(bcs32));
        bcs33TextField.setText(Integer.toString(bcs33));
        bcs34TextField.setText(Integer.toString(bcs34));
        bcs35TextField.setText(Integer.toString(bcs35));
        bcs3TextField.setText(Integer.toString(bcs3));

        bcs41TextField.setText(Integer.toString(bcs41));
        bcs42TextField.setText(Integer.toString(bcs42));
        bcs43TextField.setText(Integer.toString(bcs43));
        bcs44TextField.setText(Integer.toString(bcs44));
        bcs45TextField.setText(Integer.toString(bcs45));
        bcs46TextField.setText(Integer.toString(bcs46));
        bcs4TextField.setText(Integer.toString(bcs4));

        bcs51TextField.setText(Integer.toString(bcs51));
        bcs52TextField.setText(Integer.toString(bcs52));
        bcs53TextField.setText(Integer.toString(bcs53));
        bcs5TextField.setText(Integer.toString(bcs5));

        bcsTongTextField.setText(Float.toString(tongDiem));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        formChamDiemBCSPanel = new javax.swing.JPanel();
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
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        jLabel63 = new javax.swing.JLabel();
        sv11TextField = new javax.swing.JTextField();
        sv12aTextField = new javax.swing.JTextField();
        sv12bTextField = new javax.swing.JTextField();
        sv12cTextField = new javax.swing.JTextField();
        sv12dTextField = new javax.swing.JTextField();
        sv12eTextField = new javax.swing.JTextField();
        sv12gTextField = new javax.swing.JTextField();
        sv13aTextField = new javax.swing.JTextField();
        sv13bTextField = new javax.swing.JTextField();
        sv13cTextField = new javax.swing.JTextField();
        sv14TextField = new javax.swing.JTextField();
        sv15TextField = new javax.swing.JTextField();
        sv1TextField = new javax.swing.JTextField();
        bcs11TextField = new javax.swing.JTextField();
        bcs12aTextField = new javax.swing.JTextField();
        bcs12bTextField = new javax.swing.JTextField();
        bcs12cTextField = new javax.swing.JTextField();
        bcs12dTextField = new javax.swing.JTextField();
        bcs12eTextField = new javax.swing.JTextField();
        bcs12gTextField = new javax.swing.JTextField();
        bcs13TextField = new javax.swing.JTextField();
        bcs13aTextField = new javax.swing.JTextField();
        bcs13bTextField = new javax.swing.JTextField();
        bcs13cTextField = new javax.swing.JTextField();
        bcs14TextField = new javax.swing.JTextField();
        bcs15TextField = new javax.swing.JTextField();
        bcs1TextField = new javax.swing.JTextField();
        cv11TextField = new javax.swing.JTextField();
        cv12aTextField = new javax.swing.JTextField();
        cv12bTextField = new javax.swing.JTextField();
        cv12cTextField = new javax.swing.JTextField();
        cv12dTextField = new javax.swing.JTextField();
        cv12eTextField = new javax.swing.JTextField();
        cv12gTextField = new javax.swing.JTextField();
        cv13TextField = new javax.swing.JTextField();
        cv13aTextField = new javax.swing.JTextField();
        cv13bTextField = new javax.swing.JTextField();
        cv13cTextField = new javax.swing.JTextField();
        cv14TextField = new javax.swing.JTextField();
        cv15TextField = new javax.swing.JTextField();
        cv1TextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        hoTenTextField = new javax.swing.JTextField();
        maSinhVienTextField = new javax.swing.JTextField();
        ngaySinhTextField = new javax.swing.JTextField();
        lopTextField = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        sv21TextField = new javax.swing.JTextField();
        bcs21TextField = new javax.swing.JTextField();
        cv21TextField = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
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
        sv21aTextField = new javax.swing.JTextField();
        sv21bTextField = new javax.swing.JTextField();
        sv22aTextField = new javax.swing.JTextField();
        sv22bTextField = new javax.swing.JTextField();
        sv23aTextField = new javax.swing.JTextField();
        sv23bTextField = new javax.swing.JTextField();
        sv2TextField = new javax.swing.JTextField();
        bcs21aTextField = new javax.swing.JTextField();
        bcs21bTextField = new javax.swing.JTextField();
        bcs22aTextField = new javax.swing.JTextField();
        bcs22bTextField = new javax.swing.JTextField();
        bcs23aTextField = new javax.swing.JTextField();
        bcs23bTextField = new javax.swing.JTextField();
        bcs2TextField = new javax.swing.JTextField();
        cv21aTextField = new javax.swing.JTextField();
        cv21bTextField = new javax.swing.JTextField();
        cv22aTextField = new javax.swing.JTextField();
        cv22bTextField = new javax.swing.JTextField();
        cv23aTextField = new javax.swing.JTextField();
        cv23bTextField = new javax.swing.JTextField();
        cv2TextField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
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
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jLabel109 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea13 = new javax.swing.JTextArea();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea14 = new javax.swing.JTextArea();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea15 = new javax.swing.JTextArea();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextArea16 = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea17 = new javax.swing.JTextArea();
        jLabel117 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTextArea18 = new javax.swing.JTextArea();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
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
        hocKyTextField = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        namHocTextField = new javax.swing.JTextField();
        cv13aTextFiel1 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        sv13TextField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        sv13dTextField = new javax.swing.JTextField();
        bcs13dTextField = new javax.swing.JTextField();
        cv13dTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        dienDiemButton = new javax.swing.JButton();
        luuButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 2700));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(981, 660));

        formChamDiemBCSPanel.setBackground(new java.awt.Color(255, 255, 255));
        formChamDiemBCSPanel.setPreferredSize(new java.awt.Dimension(1348, 2700));
        formChamDiemBCSPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formChamDiemBCSPanelMouseExited(evt);
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

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("1.3");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText(" Ý thức và thái độ tham gia các hoạt động ngoại khóa, các sự kiện liên quan đến nghiên cứu khoa học, \nhọc thuật, chuyên môn, Câu lạc bộ (0,5 điểm/1 sự kiện, hoạt động tham gia, tổng điểm không vượt quá 2 điểm)");
        jTextArea1.setPreferredSize(new java.awt.Dimension(500, 100));
        jScrollPane2.setViewportView(jTextArea1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Tinh thần vượt khó, phấn đấu vươn lên trong học tập (có ĐTBCTL học kỳ sau lớn hơn học kỳ\n trước đó; đối với sinh viên năm thứ nhất, học kỳ 1 không có điểm dưới 2,5)");
        jTextArea2.setPreferredSize(new java.awt.Dimension(500, 104));
        jScrollPane3.setViewportView(jTextArea2);

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

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv11TextField.setEditable(false);
        sv11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12aTextField.setEditable(false);
        sv12aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12bTextField.setEditable(false);
        sv12bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12cTextField.setEditable(false);
        sv12cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12dTextField.setEditable(false);
        sv12dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12eTextField.setEditable(false);
        sv12eTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv12gTextField.setEditable(false);
        sv12gTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13aTextField.setEditable(false);
        sv13aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13bTextField.setEditable(false);
        sv13bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13cTextField.setEditable(false);
        sv13cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv14TextField.setEditable(false);
        sv14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv15TextField.setEditable(false);
        sv15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv1TextField.setEditable(false);
        sv1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs12aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12aTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12aTextFieldFocusLost(evt);
            }
        });

        bcs12bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12bTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12bTextFieldFocusLost(evt);
            }
        });

        bcs12cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12cTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12cTextFieldFocusLost(evt);
            }
        });

        bcs12dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12dTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12dTextFieldFocusLost(evt);
            }
        });

        bcs12eTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12eTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12eTextFieldFocusLost(evt);
            }
        });

        bcs12gTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bcs12gTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bcs12gTextFieldFocusLost(evt);
            }
        });

        bcs13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs13aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs13bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs13cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv11TextField.setEditable(false);
        cv11TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12aTextField.setEditable(false);
        cv12aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12bTextField.setEditable(false);
        cv12bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12cTextField.setEditable(false);
        cv12cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12dTextField.setEditable(false);
        cv12dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12eTextField.setEditable(false);
        cv12eTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv12gTextField.setEditable(false);
        cv12gTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13TextField.setEditable(false);
        cv13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13aTextField.setEditable(false);
        cv13aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13bTextField.setEditable(false);
        cv13bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13cTextField.setEditable(false);
        cv13cTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv14TextField.setEditable(false);
        cv14TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv15TextField.setEditable(false);
        cv15TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv1TextField.setEditable(false);
        cv1TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã số sinh viên:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("Họ và tên:");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setText("Ngày sinh:");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setText("Lớp:");

        maSinhVienTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                maSinhVienTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Tiêu chí 2: Đánh giá về ý thức chấp hành nội quy, quy chế, quy định của Học viện");
        jLabel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("2.1");
        jLabel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("Thực hiện nghiêm túc các nội quy, quy chế, các quy định hiện hành trong Học viện.");
        jLabel73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("15 điểm");
        jLabel74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv21TextField.setEditable(false);
        sv21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv21TextField.setEditable(false);
        cv21TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("- Sinh viên bị trừ điểm trong các trường hợp:");
        jLabel76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("a) Thực hiện nghiệp túc các buổi họp lớp/ sinh hoạt đoàn thể do Học viện/Khoa\n/Viện, CVHT, Lớp/Chi đoàn tổ chức (tùy thuộc vào số buổi tổ chức sinh hoạt, họp)");
        jTextArea3.setPreferredSize(new java.awt.Dimension(490, 104));
        jScrollPane4.setViewportView(jTextArea3);

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("b) Vắng 01 buổi họp lớp/ sinh hoạt đoàn thể (không lý do)");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("a) Tham gia các buổi hội thảo việc làm, định hướng nghề nghiệp do Học viện tổ chức\n (1 điểm/1 sự kiện tham gia, tổng điểm không vượt quá 5 điểm)");
        jTextArea4.setPreferredSize(new java.awt.Dimension(490, 50));
        jScrollPane5.setViewportView(jTextArea4);

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

        sv21aTextField.setEditable(false);
        sv21aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv21bTextField.setEditable(false);
        sv21bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv22aTextField.setEditable(false);
        sv22aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv22bTextField.setEditable(false);
        sv22bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv23aTextField.setEditable(false);
        sv23aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv23bTextField.setEditable(false);
        sv23bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv2TextField.setEditable(false);
        sv2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs21aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs21bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs22aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs22bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs23aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs23bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv21aTextField.setEditable(false);
        cv21aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv21bTextField.setEditable(false);
        cv21bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv22aTextField.setEditable(false);
        cv22aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv22bTextField.setEditable(false);
        cv22bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv23aTextField.setEditable(false);
        cv23aTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv23bTextField.setEditable(false);
        cv23bTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv2TextField.setEditable(false);
        cv2TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("Tham gia đầy đủ các hoạt động chính trị, xã hội, các hoạt động văn hóa, văn \nnghệ, thể thao, phong trào tình nguyện, các buổi sinh hoạt chuyên đề do Học \nviện, lớp/chi đoàn, địa phương nơi cư trú  tổ chức  (2 điểm/1 hoạt động, tổng \nđiểm không vượt quá 10 điểm)");
        jTextArea5.setPreferredSize(new java.awt.Dimension(490, 104));
        jScrollPane6.setViewportView(jTextArea5);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextArea6.setRows(5);
        jTextArea6.setText("Tiêu chí 3. Đánh giá về ý thức và kết quả tham gia hoạt động chính trị- xã hội, văn hóa, văn nghệ, thể thao, phòng chống tội phạm và\ncác tệ nạn xã hội ");
        jTextArea6.setBorder(null);
        jScrollPane7.setViewportView(jTextArea6);

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("3.1");
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel95.setPreferredSize(new java.awt.Dimension(2, 77));

        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setText("Tham gia công tác xã hội như: hiến máu nhân đạo, ủng hộ người nghèo gặp \nthiên tai lũ lụt và các công tác xã hội khác (1 điểm/1 hoạt động tham gia, tổng \nđiểm không vượt quá 4 điểm)");
        jScrollPane8.setViewportView(jTextArea7);

        jScrollPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea8.setRows(5);
        jTextArea8.setText("Tuyên truyền tích cực hình ảnh về Trường/Khoa trên các trang mạng xã \nhội (1 điểm/1 hoạt động, tổng điểm không vượt quá 3 điểm)");
        jScrollPane9.setViewportView(jTextArea8);

        jScrollPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea9.setRows(5);
        jTextArea9.setText("Tích cực tham gia các hoạt động phòng, chống tội phạm, các tệ nạn xã hội, phát \nhiện và báo cáo kịp thời những hành vi có liên quan đến ma túy, các tệ nạn xã \nhội khác");
        jScrollPane10.setViewportView(jTextArea9);

        jScrollPane11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea10.setRows(5);
        jTextArea10.setText("Đưa các thông tin sai lệch, thông tin chưa được kiểm chứng, đăng bình luận \nkhông chính xác, thiếu tích cực về Học viện/ Khoa/ ngành đang học.");
        jScrollPane11.setViewportView(jTextArea10);

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
        sv31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv31TextField.setEditable(false);
        cv31TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("20 điểm");
        jLabel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv3TextField.setEditable(false);
        sv3TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs3TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv3TextField.setEditable(false);
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
        sv32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv33TextField.setEditable(false);
        sv33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv34TextField.setEditable(false);
        sv34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv35TextField.setEditable(false);
        sv35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv32TextField.setEditable(false);
        cv32TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv33TextField.setEditable(false);
        cv33TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv34TextField.setEditable(false);
        cv34TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv35TextField.setEditable(false);
        cv35TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel108.setText("Tiêu chí 4. Đánh giá ý thức công dân trong quan hệ cộng đồng ");
        jLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea11.setRows(5);
        jTextArea11.setText("Chấp hành nghiêm chỉnh chủ trương của Đảng, chính sách, pháp luật của \nNhà nước, Học viện và của địa phương nơi cư trú");
        jScrollPane12.setViewportView(jTextArea11);

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("4.1");
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea12.setRows(5);
        jTextArea12.setText("Tích cực tham gia tuyên truyền chủ trương của Đảng, chính sách, pháp luật \ncủa Nhà nước, Học viện  và quy định của địa phương nơi cư trú; có ý thức \nthực hiện giữ gìn vệ sinh chung\n");
        jTextArea12.setPreferredSize(new java.awt.Dimension(470, 100));
        jScrollPane13.setViewportView(jTextArea12);

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

        jScrollPane14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea13.setColumns(20);
        jTextArea13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea13.setRows(5);
        jTextArea13.setText("Có mối quan hệ tốt với bạn bè trong lớp và mọi người xung quanh; có tinh \nthần đoàn kết, chia sẻ, giúp đỡ nhau trong học tập và các vấn đề khác trong \ncộng đồng\n");
        jScrollPane14.setViewportView(jTextArea13);

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("4.4");
        jLabel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea14.setColumns(20);
        jTextArea14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea14.setRows(5);
        jTextArea14.setText("Được biểu dương khen thưởng trong các hoạt động liên quan đến ý thức \ncông dân trong quan hệ cộng đồng");
        jScrollPane15.setViewportView(jTextArea14);

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("4.5");
        jLabel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea15.setColumns(20);
        jTextArea15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea15.setRows(5);
        jTextArea15.setText("Vi phạm an ninh, trật tự xã hội; an toàn giao thông (có giấy báo của các cơ \nquan hữu quan)");
        jScrollPane16.setViewportView(jTextArea15);

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("4.6");
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel116.setText("Mức điểm tối đa Tiêu chí 4");
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea16.setColumns(20);
        jTextArea16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea16.setRows(5);
        jTextArea16.setText("Tiêu chí 5. Đánh giá về ý thức và kết quả tham gia phụ trách lớp, các đoàn thể trong nhà trường, thành tích đặc biệt trong học \ntập và rèn luyện ");
        jScrollPane17.setViewportView(jTextArea16);

        jScrollPane18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea17.setColumns(20);
        jTextArea17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea17.setRows(5);
        jTextArea17.setText("Sinh viên được Học viện phân công làm lớp trưởng, lớp phó; bí thư, phó bí thư \nchi đoàn, BCH đoàn Học viện/khoa; BCH Hội sinh viên Học viện/khoa; chủ \nnhiệm, phó chủ nhiệm các các Câu lạc bộ, đội nhóm trực thuộc Học viện/khoa \nđược tập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành nhiệm vụ. \n");
        jScrollPane18.setViewportView(jTextArea17);

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("5.1");
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea18.setColumns(20);
        jTextArea18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea18.setRows(5);
        jTextArea18.setText("Thành viên tham gia các Câu lạc bộ, đội nhóm trực thuộc Học viện /khoa được\ntập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành tốt nhiệm vụ; sinh \nviên tham gia tổ chức các chương trình, là cộng tác viên tham gia tích cực vào \ncác hoạt động chung cấp Học viện, khoa.\n");
        jTextArea18.setMinimumSize(new java.awt.Dimension(600, 100));
        jScrollPane19.setViewportView(jTextArea18);

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

        jScrollPane20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea19.setColumns(20);
        jTextArea19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea19.setRows(5);
        jTextArea19.setText("- Đạt huy chương, giấy khen, giải thưởng các cấp về văn hóa, văn nghệ, thể \nthao, phòng chống các tệ nạn xã hội, hoạt động vì cộng đồng...\n");
        jScrollPane20.setViewportView(jTextArea19);

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
        sv41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv42TextField.setEditable(false);
        sv42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv43TextField.setEditable(false);
        sv43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv44TextField.setEditable(false);
        sv44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv45TextField.setEditable(false);
        sv45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv46TextField.setEditable(false);
        sv46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv4TextField.setEditable(false);
        sv4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv51TextField.setEditable(false);
        sv51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv52TextField.setEditable(false);
        sv52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv53TextField.setEditable(false);
        sv53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv5TextField.setEditable(false);
        sv5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        svTongTextField.setEditable(false);
        svTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcsTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv43TextField.setEditable(false);
        cv43TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv4TextField.setEditable(false);
        cv4TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv5TextField.setEditable(false);
        cv5TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cvTongTextField.setEditable(false);
        cvTongTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv41TextField.setEditable(false);
        cv41TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv42TextField.setEditable(false);
        cv42TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv44TextField.setEditable(false);
        cv44TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv45TextField.setEditable(false);
        cv45TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv46TextField.setEditable(false);
        cv46TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv51TextField.setEditable(false);
        cv51TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv52TextField.setEditable(false);
        cv52TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv53TextField.setEditable(false);
        cv53TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setText("Học kỳ:");

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setText("Năm học:");

        cv13aTextFiel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cv13aTextFiel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cv13aTextFiel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13TextField.setEditable(false);
        sv13TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("d) Bị lập biên bản đình chỉ khi thi kết thúc học phần");
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("- 4 điểm");
        jLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sv13dTextField.setEditable(false);
        sv13dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bcs13dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cv13dTextField.setEditable(false);
        cv13dTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("CHI TIẾT ĐIỂM RÈN LUYỆN ");

        dienDiemButton.setBackground(new java.awt.Color(0, 102, 255));
        dienDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dienDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        dienDiemButton.setText("Tự động điền điểm");
        dienDiemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dienDiemButton.setPreferredSize(new java.awt.Dimension(120, 25));
        dienDiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dienDiemButtonActionPerformed(evt);
            }
        });

        luuButton.setBackground(new java.awt.Color(0, 102, 255));
        luuButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        luuButton.setForeground(new java.awt.Color(255, 255, 255));
        luuButton.setText("Lưu");
        luuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 852, Short.MAX_VALUE)
                .addComponent(dienDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(luuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(luuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dienDiemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout formChamDiemBCSPanelLayout = new javax.swing.GroupLayout(formChamDiemBCSPanel);
        formChamDiemBCSPanel.setLayout(formChamDiemBCSPanelLayout);
        formChamDiemBCSPanelLayout.setHorizontalGroup(
            formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane7)
                                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(sv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(bcs21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(cv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jScrollPane4)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 0, Short.MAX_VALUE)))))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv22aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs22aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv22aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv23aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs23aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv23aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bcs45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bcs46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2)
                                            .addComponent(jScrollPane3)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv13aTextFiel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(sv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(bcs13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(sv12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(bcs12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cv12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(sv13dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(sv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(bcs14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(cv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addComponent(bcs13dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(cv13dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bcs33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bcs32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bcs34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cv34TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel62))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel70)
                                            .addComponent(jLabel69))
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(lopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(55, 55, 55)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel139)
                                                .addGap(19, 19, 19)
                                                .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel140)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(namHocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addComponent(sv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(bcs11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(cv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(sv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcs53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(svTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(bcsTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(cvTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        formChamDiemBCSPanelLayout.setVerticalGroup(
            formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel69)
                    .addComponent(maSinhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaySinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139)
                    .addComponent(hocKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel70)
                    .addComponent(hoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140)
                    .addComponent(namHocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(0, 0, 0)
                                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                .addGap(0, 0, 0)
                                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(0, 0, 0)
                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(sv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(bcs11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(cv11TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addGap(0, 0, 0)
                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(0, 0, 0)
                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(sv12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(bcs12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(cv12aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(0, 0, 0)
                                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(sv12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(bcs12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(cv12bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 0, 0)
                                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(sv12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(bcs12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(cv12cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(0, 0, 0)
                                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(sv12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bcs12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(cv12dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, 0)
                                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(sv12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(bcs12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cv12eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 0, 0)
                                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(sv12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(bcs12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cv12gTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cv13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bcs13TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cv13aTextFiel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sv13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bcs13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cv13aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv13bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv13cTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cv13dTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv13dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs13dTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcs14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv14TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcs15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv15TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv15TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv21TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv21aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv21bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cv22aTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bcs22aTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sv22aTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv22bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(sv23aTextField)
                            .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(bcs23aTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                    .addComponent(cv23aTextField))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcs23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cv23bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bcs2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bcs31TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv31TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv31TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcs32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv32TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv33TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sv34TextField)
                    .addComponent(bcs34TextField)
                    .addComponent(cv34TextField))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv35TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bcs41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv41TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv42TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv43TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv44TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv46TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcs45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cv45TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bcs51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv51TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel134, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bcs52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cv52TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formChamDiemBCSPanelLayout.createSequentialGroup()
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bcs53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv53TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcs5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cv5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formChamDiemBCSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(svTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcsTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cvTongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(266, 266, 266))
        );

        jScrollPane1.setViewportView(formChamDiemBCSPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2000, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void luuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuButtonActionPerformed
        if (trangThai.equalsIgnoreCase("Sinh viên đang chấm")) {
            DialogHelper.showError("Sinh viễn vẫn còn đang trong thời gian chấm điểm");
        } else if (trangThai.equalsIgnoreCase("Ban cán sự kết thúc chấm")
                || trangThai.equalsIgnoreCase("Cố vấn kết thúc chấm")
                || trangThai.equalsIgnoreCase("Cố vấn đã chấm")) {
            DialogHelper.showError("Đã hết thời gian chấm điểm");
        } else {
            String maSinhVien = maSinhVienTextField.getText();
            String hocKy = hocKyTextField.getText();
            String namHoc = namHocTextField.getText();
            String nguoiCham = "BanCanSu";
            String trangThaiCham = "Ban cán sự đã chấm";
            float bcs1 = Float.parseFloat(bcs1TextField.getText());
            int bcs2 = Integer.parseInt(bcs2TextField.getText());
            int bcs3 = Integer.parseInt(bcs3TextField.getText());
            int bcs4 = Integer.parseInt(bcs4TextField.getText());
            int bcs5 = Integer.parseInt(bcs5TextField.getText());
            float tongDiem = Float.parseFloat(bcsTongTextField.getText());
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
            int bcs11 = Integer.parseInt(bcs11TextField.getText());
            int bcs12a = Integer.parseInt(bcs12aTextField.getText());
            int bcs12b = Integer.parseInt(bcs12bTextField.getText());
            int bcs12c = Integer.parseInt(bcs12cTextField.getText());
            int bcs12d = Integer.parseInt(bcs12dTextField.getText());
            int bcs12e = Integer.parseInt(bcs12eTextField.getText());
            int bcs12g = Integer.parseInt(bcs12gTextField.getText());
            int bcs13 = Integer.parseInt(bcs13TextField.getText());
            int bcs13a = Integer.parseInt(bcs13aTextField.getText());
            int bcs13b = Integer.parseInt(bcs13bTextField.getText());
            int bcs13c = Integer.parseInt(bcs13cTextField.getText());
            int bcs13d = Integer.parseInt(bcs13dTextField.getText());
            float bcs14 = Float.parseFloat(bcs14TextField.getText());
            int bcs15 = Integer.parseInt(bcs15TextField.getText());

            int bcs21 = Integer.parseInt(bcs21TextField.getText());
            int bcs21a = Integer.parseInt(bcs21aTextField.getText());
            int bcs21b = Integer.parseInt(bcs21bTextField.getText());
            int bcs22a = Integer.parseInt(bcs22aTextField.getText());
            int bcs22b = Integer.parseInt(bcs22bTextField.getText());
            int bcs23a = Integer.parseInt(bcs23aTextField.getText());
            int bcs23b = Integer.parseInt(bcs23bTextField.getText());

            int bcs31 = Integer.parseInt(bcs31TextField.getText());
            int bcs32 = Integer.parseInt(bcs32TextField.getText());
            int bcs33 = Integer.parseInt(bcs33TextField.getText());
            int bcs34 = Integer.parseInt(bcs34TextField.getText());
            int bcs35 = Integer.parseInt(bcs35TextField.getText());

            int bcs41 = Integer.parseInt(bcs41TextField.getText());
            int bcs42 = Integer.parseInt(bcs42TextField.getText());
            int bcs43 = Integer.parseInt(bcs43TextField.getText());
            int bcs44 = Integer.parseInt(bcs44TextField.getText());
            int bcs45 = Integer.parseInt(bcs45TextField.getText());
            int bcs46 = Integer.parseInt(bcs46TextField.getText());

            int bcs51 = Integer.parseInt(bcs51TextField.getText());
            int bcs52 = Integer.parseInt(bcs52TextField.getText());
            int bcs53 = Integer.parseInt(bcs33TextField.getText());

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
            } else if (bcs11 != 0 && (bcs11 < 0 || bcs11 > 3)) {
                DialogHelper.showError("Mục 1.1 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12a != 0 && (bcs12a != 10)) {
                DialogHelper.showError("Mục 1.2a không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12b != 0 && (bcs12b != 8)) {
                DialogHelper.showError("Mục 1.2b không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12c != 0 && (bcs12c != 6)) {
                DialogHelper.showError("Mục 1.2c không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12d != 0 && (bcs12d != 4)) {
                DialogHelper.showError("Mục 1.2d không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12e != 0 && (bcs12e != 0)) {
                DialogHelper.showError("Mục 1.2e không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs12g != 0 && (bcs12g != 100)) {
                DialogHelper.showError("Mục 1.2g không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs13 != 0 && (bcs13 < 0 || bcs13 > 4)) {
                DialogHelper.showError("Mục 1.3 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs13a != 0 && (bcs13a != -2)) {
                DialogHelper.showError("Mục 1.3a không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs13b != 0 && (bcs13b != -2)) {
                DialogHelper.showError("Mục 1.3b không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs13c != 0 && (bcs13c != -3)) {
                DialogHelper.showError("Mục 1.3c không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs13d != 0 && (bcs13d != -4)) {
                DialogHelper.showError("Mục 1.3d không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs14 != 0 && (bcs14 < 0 || bcs14 > 2)) {
                DialogHelper.showError("Mục 1.4 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs15 != 0 && (bcs15 < 0 || bcs15 > 15)) {
                DialogHelper.showError("Mục 1.5 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs21 != 0 && (bcs21 < 0 || bcs21 > 15)) {
                DialogHelper.showError("Mục 2.1 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs21a != 0 && (bcs21a != -15)) {
                DialogHelper.showError("Mục 2.1a không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs21b != 0 && (bcs21b != -5)) {
                DialogHelper.showError("Mục 2.1b không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs22a != 0 && (bcs22a < 0 || bcs22a > 5)) {
                DialogHelper.showError("Mục 2.2a không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs22b != 0 && (bcs22b != -1)) {
                DialogHelper.showError("Mục 2.2b không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs23a != 0 && (bcs23a < 0 || bcs23a > 5)) {
                DialogHelper.showError("Mục 2.3a không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs23b != 0 && (bcs23b != -2)) {
                DialogHelper.showError("Mục 2.3b không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs31 != 0 && (bcs31 < 0 || bcs31 > 10)) {
                DialogHelper.showError("Mục 3.1 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs32 != 0 && (bcs32 < 0 || bcs32 > 4)) {
                DialogHelper.showError("Mục 3.2 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs33 != 0 && (bcs33 < 0 || bcs33 > 3)) {
                DialogHelper.showError("Mục 3.3 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs34 != 0 && (bcs34 < 0 || bcs34 > 3)) {
                DialogHelper.showError("Mục 3.4 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs35 != 0 && (bcs35 != -10)) {
                DialogHelper.showError("Mục 3.5 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs41 != 0 && (bcs41 < 0 || bcs41 > 8)) {
                DialogHelper.showError("Mục 4.1 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs42 != 0 && (bcs42 < 0 || bcs42 > 5)) {
                DialogHelper.showError("Mục 4.2 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs43 != 0 && (bcs43 < 0 || bcs43 > 5)) {
                DialogHelper.showError("Mục 4.3 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs44 != 0 && (bcs44 < 0 || bcs44 > 5)) {
                DialogHelper.showError("Mục 4.4 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs45 != 0 && (bcs45 < 0 || bcs45 > 2)) {
                DialogHelper.showError("Mục 4.5 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs46 != 0 && (bcs46 != -5)) {
                DialogHelper.showError("Mục 4.6 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs51 != 0 && (bcs51 < 0 || bcs51 > 4)) {
                DialogHelper.showError("Mục 5.1 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs52 != 0 && (bcs52 < 0 || bcs52 > 3)) {
                DialogHelper.showError("Mục 5.2 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs53 != 0 && (bcs53 < 0 || bcs53 > 3)) {
                DialogHelper.showError("Mục 5.3 không hợp lệ. Vui lòng nhập lại!");
            } else if (bcs1 != 0 && (bcs1 > 20)) {
                DialogHelper.showError("Tổng điểm tiêu chí 1 không chính xác");
            } else if (bcs2 != 0 && (bcs2 > 25)) {
                DialogHelper.showError("Tổng điểm tiêu chí 2 không chính xác");
            } else if (bcs3 != 0 && (bcs3 > 20)) {
                DialogHelper.showError("Tổng điểm tiêu chí 3 không chính xác");
            } else if (bcs4 != 0 && (bcs4 > 25)) {
                DialogHelper.showError("Tổng điểm tiêu chí 4 không chính xác");
            } else if (bcs5 != 0 && (bcs5 > 10)) {
                DialogHelper.showError("Tổng điểm tiêu chí 5 không chính xác");
            } else if (tongDiem != 0 && (tongDiem > 100)) {
                DialogHelper.showError("Tổng điểm không chính xác");
            } else if (bcs1 + bcs2 + bcs3 + bcs4 + bcs5 != tongDiem) {
                DialogHelper.showError("Tổng điểm các chỉ tiêu không bằng tổng điểm. Vui lòng nhập lại!");
                JOptionPane.showMessageDialog(null, "Tổng điểm các chỉ tiêu không bằng tổng điểm. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (tongDiem == 0) {
                DialogHelper.showError("Chưa nhập điểm. Vui lòng nhập lại!");
            } else {
                try {
                    DiemRenLuyenModel drl = new DiemRenLuyenModel(hocKy, namHoc, nguoiCham, xepLoai, trangThaiCham, tongDiem, bcs11, bcs12a, bcs12b, bcs12c, bcs12d, bcs12e, bcs12g, bcs13, bcs13a, bcs13b, bcs13c, bcs13d, bcs14, bcs15, bcs1, bcs21, bcs21a, bcs21b, bcs22a, bcs22b, bcs23a, bcs23b, bcs2, bcs31, bcs32, bcs33, bcs34, bcs35, bcs3, bcs41, bcs42, bcs43, bcs44, bcs45, bcs46, bcs4, bcs51, bcs52, bcs53, bcs5, maSinhVien);
                    DiemRenLuyenCtrl.chamDiemSV(drl);
                    DiemRenLuyenCtrl.thayDoiTrangThaiCham(trangThaiCham, maSinhVien, hocKy, namHoc);
                    DialogHelper.showMessage("Chấm điểm thành công!");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormChamDiemSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_luuButtonActionPerformed

    private void dienDiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dienDiemButtonActionPerformed
        dienDiem();
    }//GEN-LAST:event_dienDiemButtonActionPerformed

    private void bcs12aTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12aTextFieldFocusLost
        if (!bcs12aTextField.getText().equals("0")) {
            bcs12bTextField.setEditable(false);
            bcs12bTextField.setEnabled(false);
            bcs12cTextField.setEditable(false);
            bcs12cTextField.setEnabled(false);
            bcs12dTextField.setEditable(false);
            bcs12dTextField.setEnabled(false);
            bcs12eTextField.setEditable(false);
            bcs12eTextField.setEnabled(false);
            bcs12gTextField.setEditable(false);
            bcs12gTextField.setEnabled(false);
        } else {
            bcs12bTextField.setEditable(true);
            bcs12bTextField.setEnabled(true);
            bcs12cTextField.setEditable(true);
            bcs12cTextField.setEnabled(true);
            bcs12dTextField.setEditable(true);
            bcs12dTextField.setEnabled(true);
            bcs12eTextField.setEditable(true);
            bcs12eTextField.setEnabled(true);
            bcs12gTextField.setEditable(true);
            bcs12gTextField.setEnabled(true);
        }
    }//GEN-LAST:event_bcs12aTextFieldFocusLost

    private void bcs12bTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12bTextFieldFocusLost
        if (!bcs12bTextField.getText().equals("0")) {
            bcs12aTextField.setEnabled(false);
            bcs12cTextField.setEnabled(false);
            bcs12dTextField.setEnabled(false);
            bcs12eTextField.setEnabled(false);
            bcs12gTextField.setEnabled(false);

            bcs12aTextField.setEditable(false);
            bcs12cTextField.setEditable(false);
            bcs12dTextField.setEditable(false);
            bcs12eTextField.setEditable(false);
            bcs12gTextField.setEditable(false);
        } else {
            bcs12aTextField.setEnabled(true);
            bcs12cTextField.setEnabled(true);
            bcs12dTextField.setEnabled(true);
            bcs12eTextField.setEnabled(true);
            bcs12gTextField.setEnabled(true);

            bcs12aTextField.setEditable(true);
            bcs12cTextField.setEditable(true);
            bcs12dTextField.setEditable(true);
            bcs12eTextField.setEditable(true);
            bcs12gTextField.setEditable(true);
        }
    }//GEN-LAST:event_bcs12bTextFieldFocusLost

    private void bcs12cTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12cTextFieldFocusLost
        if (!bcs12cTextField.getText().equals("0")) {
            bcs12aTextField.setEditable(false);
            bcs12bTextField.setEditable(false);
            bcs12dTextField.setEditable(false);
            bcs12eTextField.setEditable(false);
            bcs12gTextField.setEditable(false);

            bcs12aTextField.setEnabled(false);
            bcs12bTextField.setEnabled(false);
            bcs12dTextField.setEnabled(false);
            bcs12eTextField.setEnabled(false);
            bcs12gTextField.setEnabled(false);
        } else {
            bcs12aTextField.setEditable(true);
            bcs12bTextField.setEditable(true);
            bcs12dTextField.setEditable(true);
            bcs12eTextField.setEditable(true);
            bcs12gTextField.setEditable(true);

            bcs12aTextField.setEnabled(true);
            bcs12bTextField.setEnabled(true);
            bcs12dTextField.setEnabled(true);
            bcs12eTextField.setEnabled(true);
            bcs12gTextField.setEnabled(true);
        }
    }//GEN-LAST:event_bcs12cTextFieldFocusLost

    private void bcs12dTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12dTextFieldFocusLost
        if (!bcs12dTextField.getText().equals("0")) {
            bcs12aTextField.setEditable(false);
            bcs12bTextField.setEditable(false);
            bcs12cTextField.setEditable(false);
            bcs12eTextField.setEditable(false);
            bcs12gTextField.setEditable(false);

            bcs12aTextField.setEnabled(false);
            bcs12bTextField.setEnabled(false);
            bcs12cTextField.setEnabled(false);
            bcs12eTextField.setEnabled(false);
            bcs12gTextField.setEnabled(false);
        } else {
            bcs12aTextField.setEditable(true);
            bcs12bTextField.setEditable(true);
            bcs12cTextField.setEditable(true);
            bcs12eTextField.setEditable(true);
            bcs12gTextField.setEditable(true);

            bcs12aTextField.setEnabled(true);
            bcs12bTextField.setEnabled(true);
            bcs12cTextField.setEnabled(true);
            bcs12eTextField.setEnabled(true);
            bcs12gTextField.setEnabled(true);
        }
    }//GEN-LAST:event_bcs12dTextFieldFocusLost

    private void bcs12eTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12eTextFieldFocusLost
        if (!bcs12eTextField.getText().equals("0")) {
            bcs12aTextField.setEditable(false);
            bcs12bTextField.setEditable(false);
            bcs12cTextField.setEditable(false);
            bcs12dTextField.setEditable(false);
            bcs12gTextField.setEditable(false);

            bcs12aTextField.setEnabled(false);
            bcs12bTextField.setEnabled(false);
            bcs12cTextField.setEnabled(false);
            bcs12dTextField.setEnabled(false);
            bcs12gTextField.setEnabled(false);
        } else {
            bcs12aTextField.setEditable(true);
            bcs12bTextField.setEditable(true);
            bcs12cTextField.setEditable(true);
            bcs12dTextField.setEditable(true);
            bcs12gTextField.setEditable(true);

            bcs12aTextField.setEnabled(true);
            bcs12bTextField.setEnabled(true);
            bcs12cTextField.setEnabled(true);
            bcs12dTextField.setEnabled(true);
            bcs12gTextField.setEnabled(true);
        }
    }//GEN-LAST:event_bcs12eTextFieldFocusLost

    private void bcs12gTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bcs12gTextFieldFocusLost
        if (!bcs12gTextField.getText().equals("0")) {
            bcs12aTextField.setEditable(false);
            bcs12bTextField.setEditable(false);
            bcs12cTextField.setEditable(false);
            bcs12dTextField.setEditable(false);
            bcs12eTextField.setEditable(false);

            bcs12aTextField.setEnabled(false);
            bcs12bTextField.setEnabled(false);
            bcs12cTextField.setEnabled(false);
            bcs12dTextField.setEnabled(false);
            bcs12eTextField.setEnabled(false);
        } else {
            bcs12aTextField.setEditable(true);
            bcs12bTextField.setEditable(true);
            bcs12cTextField.setEditable(true);
            bcs12dTextField.setEditable(true);
            bcs12eTextField.setEditable(true);

            bcs12aTextField.setEnabled(true);
            bcs12bTextField.setEnabled(true);
            bcs12cTextField.setEnabled(true);
            bcs12dTextField.setEnabled(true);
            bcs12eTextField.setEnabled(true);
        }
    }//GEN-LAST:event_bcs12gTextFieldFocusLost

    private void formChamDiemBCSPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formChamDiemBCSPanelMouseExited
        if (!bcs11TextField.getText().isEmpty() && !bcs12aTextField.getText().isEmpty() && !bcs12bTextField.getText().isEmpty()
                && !bcs12cTextField.getText().isEmpty() && !bcs12dTextField.getText().isEmpty() && !bcs12eTextField.getText().isEmpty()
                && !bcs12gTextField.getText().isEmpty() && !bcs13TextField.getText().isEmpty() && !bcs13aTextField.getText().isEmpty()
                && !bcs13bTextField.getText().isEmpty() && !bcs13cTextField.getText().isEmpty() && !bcs13dTextField.getText().isEmpty()
                && !bcs14TextField.getText().isEmpty() && !bcs15TextField.getText().isEmpty() && !bcs1TextField.getText().isEmpty()
                && !bcs21TextField.getText().isEmpty() && !bcs21aTextField.getText().isEmpty() && !bcs21bTextField.getText().isEmpty()
                && !bcs22aTextField.getText().isEmpty() && !bcs22bTextField.getText().isEmpty() && !bcs23aTextField.getText().isEmpty()
                && !bcs23bTextField.getText().isEmpty() && !bcs2TextField.getText().isEmpty() && !bcs31TextField.getText().isEmpty()
                && !bcs32TextField.getText().isEmpty() && !bcs33TextField.getText().isEmpty() && !bcs34TextField.getText().isEmpty()
                && !bcs35TextField.getText().isEmpty() && !bcs3TextField.getText().isEmpty() && !bcs41TextField.getText().isEmpty()
                && !bcs42TextField.getText().isEmpty() && !bcs43TextField.getText().isEmpty() && !bcs44TextField.getText().isEmpty()
                && !bcs45TextField.getText().isEmpty() && !bcs46TextField.getText().isEmpty() && !bcs4TextField.getText().isEmpty()
                && !bcs51TextField.getText().isEmpty() && !bcs52TextField.getText().isEmpty() && !bcs53TextField.getText().isEmpty()
                && !bcs5TextField.getText().isEmpty() && !bcsTongTextField.getText().isEmpty()) {
            int d11 = Integer.parseInt(bcs11TextField.getText());
            int d12a = Integer.parseInt(bcs12aTextField.getText());
            int d12b = Integer.parseInt(bcs12bTextField.getText());
            int d12c = Integer.parseInt(bcs12cTextField.getText());
            int d12d = Integer.parseInt(bcs12dTextField.getText());
            int d12e = Integer.parseInt(bcs12eTextField.getText());
            int d12g = Integer.parseInt(bcs12gTextField.getText());
            int d13 = Integer.parseInt(bcs13TextField.getText());
            int d13a = Integer.parseInt(bcs13aTextField.getText());
            int d13b = Integer.parseInt(bcs13bTextField.getText());
            int d13c = Integer.parseInt(bcs13cTextField.getText());
            int d13d = Integer.parseInt(bcs13dTextField.getText());
            float d14 = Float.parseFloat(bcs14TextField.getText());
            int d15 = Integer.parseInt(bcs15TextField.getText());
            float d1 = d11 + d12a + d12b + d12c + d12d + d12e + d12g + d13 + d13a + d13b + d13c + d13d + d14 + d15;
            bcs1TextField.setText(Float.toString(d1));

            int d21 = Integer.parseInt(bcs21TextField.getText());
            int d21a = Integer.parseInt(bcs21aTextField.getText());
            int d21b = Integer.parseInt(bcs21bTextField.getText());
            int d22a = Integer.parseInt(bcs22aTextField.getText());
            int d22b = Integer.parseInt(bcs22bTextField.getText());
            int d23a = Integer.parseInt(bcs23aTextField.getText());
            int d23b = Integer.parseInt(bcs23bTextField.getText());
            int d2 = d21 + d21a + d21b + d22a + d22b + d23a + d23b;
            bcs2TextField.setText(Integer.toString(d2));

            int d31 = Integer.parseInt(bcs31TextField.getText());
            int d32 = Integer.parseInt(bcs32TextField.getText());
            int d33 = Integer.parseInt(bcs33TextField.getText());
            int d34 = Integer.parseInt(bcs34TextField.getText());
            int d35 = Integer.parseInt(bcs35TextField.getText());
            int d3 = d31 + d32 + d33 + d34 + d35;
            bcs3TextField.setText(Integer.toString(d3));

            int d41 = Integer.parseInt(bcs41TextField.getText());
            int d42 = Integer.parseInt(bcs42TextField.getText());
            int d43 = Integer.parseInt(bcs43TextField.getText());
            int d44 = Integer.parseInt(bcs44TextField.getText());
            int d45 = Integer.parseInt(bcs45TextField.getText());
            int d46 = Integer.parseInt(bcs46TextField.getText());
            int d4 = d41 + d42 + d43 + d44 + d45 + d46;
            bcs4TextField.setText(Integer.toString(d4));

            int d51 = Integer.parseInt(bcs51TextField.getText());
            int d52 = Integer.parseInt(bcs52TextField.getText());
            int d53 = Integer.parseInt(bcs53TextField.getText());
            int d5 = d51 + d52 + d53;
            bcs5TextField.setText(Integer.toString(d5));

            bcsTongTextField.setText(Float.toString(d1 + d2 + d3 + d4 + d5));
        }
    }//GEN-LAST:event_formChamDiemBCSPanelMouseExited

    private void maSinhVienTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_maSinhVienTextFieldAncestorAdded
        try {
            String maSinhVien = maSinhVienTextField.getText();
            String hocKy = hocKyTextField.getText();
            String namHoc = namHocTextField.getText();
            lamMoi();
            DiemRenLuyenModel diemRenLuyenSV = DiemRenLuyenCtrl.timDRLDayDu(maSinhVien, hocKy, namHoc, "SinhVien");
            if (diemRenLuyenSV != null) {
                trangThai = diemRenLuyenSV.getTrangThaiCham();
                ngaySinhTextField.setText(sdf.format(diemRenLuyenSV.getNgaySinh()));
                lopTextField.setText(diemRenLuyenSV.getTenLop());

                sv11TextField.setText(Integer.toString(diemRenLuyenSV.getD11()));
                sv12aTextField.setText(Integer.toString(diemRenLuyenSV.getD12a()));
                sv12bTextField.setText(Integer.toString(diemRenLuyenSV.getD12b()));
                sv12cTextField.setText(Integer.toString(diemRenLuyenSV.getD12c()));
                sv12dTextField.setText(Integer.toString(diemRenLuyenSV.getD12d()));
                sv12eTextField.setText(Integer.toString(diemRenLuyenSV.getD12e()));
                sv12gTextField.setText(Integer.toString(diemRenLuyenSV.getD12g()));
                sv13TextField.setText(Integer.toString(diemRenLuyenSV.getD13()));
                sv13aTextField.setText(Integer.toString(diemRenLuyenSV.getD13a()));
                sv13bTextField.setText(Integer.toString(diemRenLuyenSV.getD13b()));
                sv13cTextField.setText(Integer.toString(diemRenLuyenSV.getD13c()));
                sv13dTextField.setText(Integer.toString(diemRenLuyenSV.getD13d()));
                sv14TextField.setText(Float.toString(diemRenLuyenSV.getD14()));
                sv15TextField.setText(Integer.toString(diemRenLuyenSV.getD15()));
                sv1TextField.setText(Float.toString(diemRenLuyenSV.getD1()));

                sv21TextField.setText(Integer.toString(diemRenLuyenSV.getD21()));
                sv21aTextField.setText(Integer.toString(diemRenLuyenSV.getD21a()));
                sv21bTextField.setText(Integer.toString(diemRenLuyenSV.getD21b()));
                sv22aTextField.setText(Integer.toString(diemRenLuyenSV.getD22a()));
                sv22bTextField.setText(Integer.toString(diemRenLuyenSV.getD22b()));
                sv23aTextField.setText(Integer.toString(diemRenLuyenSV.getD23a()));
                sv23bTextField.setText(Integer.toString(diemRenLuyenSV.getD23b()));
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
                bcs12aTextField.setText(Integer.toString(diemRenLuyenBCS.getD12a()));
                bcs12bTextField.setText(Integer.toString(diemRenLuyenBCS.getD12b()));
                bcs12cTextField.setText(Integer.toString(diemRenLuyenBCS.getD12c()));
                bcs12dTextField.setText(Integer.toString(diemRenLuyenBCS.getD12d()));
                bcs12eTextField.setText(Integer.toString(diemRenLuyenBCS.getD12e()));
                bcs12gTextField.setText(Integer.toString(diemRenLuyenBCS.getD12g()));
                bcs13TextField.setText(Integer.toString(diemRenLuyenBCS.getD13()));
                bcs13aTextField.setText(Integer.toString(diemRenLuyenBCS.getD13a()));
                bcs13bTextField.setText(Integer.toString(diemRenLuyenBCS.getD13b()));
                bcs13cTextField.setText(Integer.toString(diemRenLuyenBCS.getD13c()));
                bcs13dTextField.setText(Integer.toString(diemRenLuyenBCS.getD13d()));
                bcs14TextField.setText(Float.toString(diemRenLuyenBCS.getD14()));
                bcs15TextField.setText(Integer.toString(diemRenLuyenBCS.getD15()));
                bcs1TextField.setText(Float.toString(diemRenLuyenBCS.getD1()));

                bcs21TextField.setText(Integer.toString(diemRenLuyenBCS.getD21()));
                bcs21aTextField.setText(Integer.toString(diemRenLuyenBCS.getD21a()));
                bcs21bTextField.setText(Integer.toString(diemRenLuyenBCS.getD21b()));
                bcs22aTextField.setText(Integer.toString(diemRenLuyenBCS.getD22a()));
                bcs22bTextField.setText(Integer.toString(diemRenLuyenBCS.getD22b()));
                bcs23aTextField.setText(Integer.toString(diemRenLuyenBCS.getD23a()));
                bcs23bTextField.setText(Integer.toString(diemRenLuyenBCS.getD23b()));
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
                cv12aTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12a()));
                cv12bTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12b()));
                cv12cTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12c()));
                cv12dTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12d()));
                cv12eTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12e()));
                cv12gTextField.setText(Integer.toString(diemRenLuyenCoVan.getD12g()));
                cv13TextField.setText(Integer.toString(diemRenLuyenCoVan.getD13()));
                cv13aTextField.setText(Integer.toString(diemRenLuyenCoVan.getD13a()));
                cv13bTextField.setText(Integer.toString(diemRenLuyenCoVan.getD13b()));
                cv13cTextField.setText(Integer.toString(diemRenLuyenCoVan.getD13c()));
                cv13dTextField.setText(Integer.toString(diemRenLuyenCoVan.getD13d()));
                cv14TextField.setText(Float.toString(diemRenLuyenCoVan.getD14()));
                cv15TextField.setText(Integer.toString(diemRenLuyenCoVan.getD15()));
                cv1TextField.setText(Float.toString(diemRenLuyenCoVan.getD1()));

                cv21TextField.setText(Integer.toString(diemRenLuyenCoVan.getD21()));
                cv21aTextField.setText(Integer.toString(diemRenLuyenCoVan.getD21a()));
                cv21bTextField.setText(Integer.toString(diemRenLuyenCoVan.getD21b()));
                cv22aTextField.setText(Integer.toString(diemRenLuyenCoVan.getD22a()));
                cv22bTextField.setText(Integer.toString(diemRenLuyenCoVan.getD22b()));
                cv23aTextField.setText(Integer.toString(diemRenLuyenCoVan.getD23a()));
                cv23bTextField.setText(Integer.toString(diemRenLuyenCoVan.getD23b()));
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
    }//GEN-LAST:event_maSinhVienTextFieldAncestorAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bcs11TextField;
    private javax.swing.JTextField bcs12aTextField;
    private javax.swing.JTextField bcs12bTextField;
    private javax.swing.JTextField bcs12cTextField;
    private javax.swing.JTextField bcs12dTextField;
    private javax.swing.JTextField bcs12eTextField;
    private javax.swing.JTextField bcs12gTextField;
    private javax.swing.JTextField bcs13TextField;
    private javax.swing.JTextField bcs13aTextField;
    private javax.swing.JTextField bcs13bTextField;
    private javax.swing.JTextField bcs13cTextField;
    private javax.swing.JTextField bcs13dTextField;
    private javax.swing.JTextField bcs14TextField;
    private javax.swing.JTextField bcs15TextField;
    private javax.swing.JTextField bcs1TextField;
    private javax.swing.JTextField bcs21TextField;
    private javax.swing.JTextField bcs21aTextField;
    private javax.swing.JTextField bcs21bTextField;
    private javax.swing.JTextField bcs22aTextField;
    private javax.swing.JTextField bcs22bTextField;
    private javax.swing.JTextField bcs23aTextField;
    private javax.swing.JTextField bcs23bTextField;
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
    private javax.swing.JTextField cv11TextField;
    private javax.swing.JTextField cv12aTextField;
    private javax.swing.JTextField cv12bTextField;
    private javax.swing.JTextField cv12cTextField;
    private javax.swing.JTextField cv12dTextField;
    private javax.swing.JTextField cv12eTextField;
    private javax.swing.JTextField cv12gTextField;
    private javax.swing.JTextField cv13TextField;
    private javax.swing.JLabel cv13aTextFiel1;
    private javax.swing.JTextField cv13aTextField;
    private javax.swing.JTextField cv13bTextField;
    private javax.swing.JTextField cv13cTextField;
    private javax.swing.JTextField cv13dTextField;
    private javax.swing.JTextField cv14TextField;
    private javax.swing.JTextField cv15TextField;
    private javax.swing.JTextField cv1TextField;
    private javax.swing.JTextField cv21TextField;
    private javax.swing.JTextField cv21aTextField;
    private javax.swing.JTextField cv21bTextField;
    private javax.swing.JTextField cv22aTextField;
    private javax.swing.JTextField cv22bTextField;
    private javax.swing.JTextField cv23aTextField;
    private javax.swing.JTextField cv23bTextField;
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
    private javax.swing.JButton dienDiemButton;
    private javax.swing.JPanel formChamDiemBCSPanel;
    private javax.swing.JTextField hoTenTextField;
    private javax.swing.JTextField hocKyTextField;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
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
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
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
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
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
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField lopTextField;
    private javax.swing.JButton luuButton;
    private javax.swing.JTextField maSinhVienTextField;
    private javax.swing.JTextField namHocTextField;
    private javax.swing.JTextField ngaySinhTextField;
    private javax.swing.JTextField sv11TextField;
    private javax.swing.JTextField sv12aTextField;
    private javax.swing.JTextField sv12bTextField;
    private javax.swing.JTextField sv12cTextField;
    private javax.swing.JTextField sv12dTextField;
    private javax.swing.JTextField sv12eTextField;
    private javax.swing.JTextField sv12gTextField;
    private javax.swing.JTextField sv13TextField;
    private javax.swing.JTextField sv13aTextField;
    private javax.swing.JTextField sv13bTextField;
    private javax.swing.JTextField sv13cTextField;
    private javax.swing.JTextField sv13dTextField;
    private javax.swing.JTextField sv14TextField;
    private javax.swing.JTextField sv15TextField;
    private javax.swing.JTextField sv1TextField;
    private javax.swing.JTextField sv21TextField;
    private javax.swing.JTextField sv21aTextField;
    private javax.swing.JTextField sv21bTextField;
    private javax.swing.JTextField sv22aTextField;
    private javax.swing.JTextField sv22bTextField;
    private javax.swing.JTextField sv23aTextField;
    private javax.swing.JTextField sv23bTextField;
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
    // End of variables declaration//GEN-END:variables
}
