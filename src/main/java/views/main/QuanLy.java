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
import views.list.*;

public class QuanLy extends javax.swing.JFrame {

    public static QuanLy Instance;
    public JLabel tenUser;

    public QuanLy() {
        initComponents();

        Instance = this;

        menuQuanLy.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    LayeredPane.removeAll();
                    LayeredPane.add(dsDiemToanTruongPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 1) {
                    new DSPhanCong().setVisible(true);
                    new DSPhanCong().setAlwaysOnTop(true);
                } else if (index == 2) {
                    LayeredPane.removeAll();
                    LayeredPane.add(taoPhieuDRLPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 3) {
                    if (subIndex == 1) {
                        LayeredPane.removeAll();
                        LayeredPane.add(dsCoVanPanel);
                        LayeredPane.repaint();
                        LayeredPane.revalidate();
                    } else if (subIndex == 2) {
                        LayeredPane.removeAll();
                        LayeredPane.add(dsSinhVienPanel);
                        LayeredPane.repaint();
                        LayeredPane.revalidate();
                    } else if (subIndex == 3) {
                        new DSKhoa().setVisible(true);
                        new DSKhoa().setAlwaysOnTop(true);
                    } else if (subIndex == 4) {
                        new DSNganh().setVisible(true);
                        new DSNganh().setAlwaysOnTop(true);
                    } else if (subIndex == 5) {
                        new DSLop().setVisible(true);
                        new DSLop().setAlwaysOnTop(true);
                    } else if (subIndex == 6) {
                        new DSNamHoc().setVisible(true);
                        new DSNamHoc().setAlwaysOnTop(true);
                    }
                } else if (index == 4) {
                    if (subIndex == 1) {
                        LayeredPane.removeAll();
                        LayeredPane.add(dsQuanLyPanel);
                        LayeredPane.repaint();
                        LayeredPane.revalidate();
                    } else if (subIndex == 2) {
                        new DSChucVu().setVisible(true);
                        new DSChucVu().setAlwaysOnTop(true);
                    }
                } else if (index == 5) {
                    LayeredPane.removeAll();
                    LayeredPane.add(taiKhoanQuanLyPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 6) {
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
                        Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayeredPane = new javax.swing.JLayeredPane();
        dsDiemToanTruongPanel = new javax.swing.JTabbedPane();
        dSDiemRenLuyenToanTruong1 = new views.list.DSDiemRenLuyenToanTruong();
        taiKhoanQuanLyPanel = new javax.swing.JTabbedPane();
        taiKhoanQuanLy1 = new views.main.TaiKhoanQuanLy();
        taoPhieuDRLPanel = new javax.swing.JTabbedPane();
        taoPhieuDRL1 = new views.main.TaoPhieuDRL();
        dsSinhVienPanel = new javax.swing.JTabbedPane();
        dSSinhVienTest2 = new views.list.DSSinhVien();
        dsCoVanPanel = new javax.swing.JTabbedPane();
        dSCoVanTest1 = new views.list.DSCoVan();
        dsQuanLyPanel = new javax.swing.JTabbedPane();
        dSQuanLy2 = new views.list.DSQuanLy();
        header = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        scrollPaneWin112 = new view.custom.scroll.ScrollPane();
        menuQuanLy = new view.custom.menu.MenuQuanLy();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        LayeredPane.setBackground(new java.awt.Color(255, 255, 255));
        LayeredPane.setPreferredSize(new java.awt.Dimension(1674, 647));
        LayeredPane.setLayout(new java.awt.CardLayout());

        dsDiemToanTruongPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsDiemToanTruongPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsDiemToanTruongPanel.setPreferredSize(new java.awt.Dimension(1140, 650));
        dsDiemToanTruongPanel.addTab("Danh sách điểm rèn luyện toàn trường", dSDiemRenLuyenToanTruong1);

        LayeredPane.add(dsDiemToanTruongPanel, "card2");

        taiKhoanQuanLyPanel.setBackground(new java.awt.Color(255, 255, 255));
        taiKhoanQuanLyPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taiKhoanQuanLyPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        taiKhoanQuanLyPanel.addTab("Tài khoản cá nhân", taiKhoanQuanLy1);

        LayeredPane.add(taiKhoanQuanLyPanel, "card2");

        taoPhieuDRLPanel.setBackground(new java.awt.Color(255, 255, 255));
        taoPhieuDRLPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taoPhieuDRLPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        taoPhieuDRLPanel.addTab("Tạo phiếu điểm rèn luyện", taoPhieuDRL1);

        LayeredPane.add(taoPhieuDRLPanel, "card2");

        dsSinhVienPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsSinhVienPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsSinhVienPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        dsSinhVienPanel.addTab("Danh sách sinh viên", dSSinhVienTest2);

        LayeredPane.add(dsSinhVienPanel, "card2");

        dsCoVanPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsCoVanPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsCoVanPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        dsCoVanPanel.addTab("Danh sách cố vấn", dSCoVanTest1);

        LayeredPane.add(dsCoVanPanel, "card2");

        dsQuanLyPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsQuanLyPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsQuanLyPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        dsQuanLyPanel.addTab("Danh sách quản lý", dSQuanLy2);

        LayeredPane.add(dsQuanLyPanel, "card2");

        header.setBackground(new java.awt.Color(20, 80, 55));
        header.setPreferredSize(new java.awt.Dimension(1140, 61));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        sideMenu.setBackground(new java.awt.Color(20, 80, 55));
        sideMenu.setPreferredSize(new java.awt.Dimension(225, 709));

        scrollPaneWin112.setPreferredSize(new java.awt.Dimension(250, 700));
        scrollPaneWin112.setViewportView(menuQuanLy);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 50x50.png"))); // NOI18N

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 709, Short.MAX_VALUE)
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
                QuanLy main = new QuanLy();

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
    private views.list.DSCoVan dSCoVanTest1;
    private views.list.DSDiemRenLuyenToanTruong dSDiemRenLuyenToanTruong1;
    private views.list.DSQuanLy dSQuanLy2;
    private views.list.DSSinhVien dSSinhVienTest2;
    private javax.swing.JTabbedPane dsCoVanPanel;
    private javax.swing.JTabbedPane dsDiemToanTruongPanel;
    private javax.swing.JTabbedPane dsQuanLyPanel;
    private javax.swing.JTabbedPane dsSinhVienPanel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private view.custom.menu.MenuQuanLy menuQuanLy;
    private view.custom.scroll.ScrollPane scrollPaneWin112;
    private javax.swing.JPanel sideMenu;
    private views.main.TaiKhoanQuanLy taiKhoanQuanLy1;
    private javax.swing.JTabbedPane taiKhoanQuanLyPanel;
    private views.main.TaoPhieuDRL taoPhieuDRL1;
    private javax.swing.JTabbedPane taoPhieuDRLPanel;
    // End of variables declaration//GEN-END:variables

}
