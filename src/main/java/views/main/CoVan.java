package views.main;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.DialogHelper;
import view.custom.menu.MenuEvent;

public class CoVan extends javax.swing.JFrame {

    public static CoVan Instance;
    public JLabel tenUser;

    public CoVan() {
        initComponents();

        Instance = this;

        menuCoVan.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    LayeredPane.removeAll();
                    LayeredPane.add(dsLopSinhVienPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 1) {
                    LayeredPane.removeAll();
                    LayeredPane.add(dsDiemToanTruongPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 2) {
                    LayeredPane.removeAll();
                    LayeredPane.add(taiKhoanCoVanPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 3) {
                    if (DialogHelper.showConfirmation("Bạn có chắc muốn đăng xuất không?")) {
                        new DangNhap().setVisible(true);
                        new DangNhap().setAlwaysOnTop(true);
                        dispose();
                    }
                }
            }
        }
        );
    }

    int width = 250;
    int height = 750;

    void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    try {
                        sideMenu.setSize(i, height);
                        Thread.sleep(0, 5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CoVan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    try {
                        sideMenu.setSize(i, height);
                        Thread.sleep(0, 5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CoVan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayeredPane = new javax.swing.JLayeredPane();
        dsLopSinhVienPanel = new javax.swing.JTabbedPane();
        dSDiemRenLuyenCVHT1 = new views.list.DSDiemRenLuyenCVHT();
        formChamDiemCVHT1 = new views.main.FormChamDiemCVHT();
        dsDiemToanTruongPanel = new javax.swing.JTabbedPane();
        dSDiemRenLuyenToanTruong1 = new views.list.DSDiemRenLuyenToanTruong();
        taiKhoanCoVanPanel = new javax.swing.JTabbedPane();
        taiKhoanCoVan1 = new views.main.TaiKhoanCoVan();
        header = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        menuCoVan = new view.custom.menu.MenuCoVan();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(1365, 709));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        LayeredPane.setBackground(new java.awt.Color(255, 255, 255));
        LayeredPane.setPreferredSize(new java.awt.Dimension(1674, 647));
        LayeredPane.setLayout(new java.awt.CardLayout());

        dsLopSinhVienPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsLopSinhVienPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsLopSinhVienPanel.setPreferredSize(new java.awt.Dimension(1674, 650));

        dSDiemRenLuyenCVHT1.setPreferredSize(new java.awt.Dimension(1140, 647));
        dsLopSinhVienPanel.addTab("Danh sách điểm rèn luyện của các lớp", dSDiemRenLuyenCVHT1);
        dsLopSinhVienPanel.addTab("Chấm điểm rèn luyện", formChamDiemCVHT1);

        LayeredPane.add(dsLopSinhVienPanel, "card2");

        dsDiemToanTruongPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsDiemToanTruongPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsDiemToanTruongPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        dsDiemToanTruongPanel.addTab("Danh sách điểm rèn luyện toàn trường", dSDiemRenLuyenToanTruong1);

        LayeredPane.add(dsDiemToanTruongPanel, "card2");

        taiKhoanCoVanPanel.setBackground(new java.awt.Color(255, 255, 255));
        taiKhoanCoVanPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taiKhoanCoVanPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        taiKhoanCoVanPanel.addTab("Tài khoản cá nhân", taiKhoanCoVan1);

        LayeredPane.add(taiKhoanCoVanPanel, "card2");

        header.setBackground(new java.awt.Color(20, 80, 55));
        header.setPreferredSize(new java.awt.Dimension(114, 61));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        sideMenu.setBackground(new java.awt.Color(20, 80, 55));
        sideMenu.setPreferredSize(new java.awt.Dimension(225, 709));

        menuCoVan.setPreferredSize(new java.awt.Dimension(196, 647));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 50x50.png"))); // NOI18N

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addComponent(menuCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideMenuLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                    .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CoVan main = new CoVan();

                // Lấy kích thước màn hình
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                DisplayMode mode = gd.getDisplayMode();

                // Đặt kích thước cửa sổ là fullscreen
                main.setSize(mode.getWidth(), mode.getHeight());

                // Đặt trạng thái cửa sổ là toàn màn hình
                main.setExtendedState(JFrame.MAXIMIZED_BOTH);

                main.setTitle("QUẢN LÝ ĐIỂM RÈN LUYỆN PTITHCM");
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredPane;
    private views.list.DSDiemRenLuyenCVHT dSDiemRenLuyenCVHT1;
    private views.list.DSDiemRenLuyenToanTruong dSDiemRenLuyenToanTruong1;
    private javax.swing.JTabbedPane dsDiemToanTruongPanel;
    private javax.swing.JTabbedPane dsLopSinhVienPanel;
    private views.main.FormChamDiemCVHT formChamDiemCVHT1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private view.custom.menu.MenuCoVan menuCoVan;
    private javax.swing.JPanel sideMenu;
    private views.main.TaiKhoanCoVan taiKhoanCoVan1;
    private javax.swing.JTabbedPane taiKhoanCoVanPanel;
    // End of variables declaration//GEN-END:variables

}
