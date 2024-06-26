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

public class SinhVien extends javax.swing.JFrame {

    public static SinhVien Instance;
    public JLabel tenUser;

    public SinhVien() {
        initComponents();

        Instance = this;

        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    LayeredPane.removeAll();
                    LayeredPane.add(dsSinhVienPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 1) {
                    LayeredPane.removeAll();
                    LayeredPane.add(dsDiemToanTruongPanel);
                    LayeredPane.repaint();
                    LayeredPane.revalidate();
                } else if (index == 2) {
                    LayeredPane.removeAll();
                    LayeredPane.add(taiKhoanSinhVienPanel);
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
                        Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayeredPane = new javax.swing.JLayeredPane();
        dsSinhVienPanel = new javax.swing.JTabbedPane();
        dSDiemRenLuyenSVPanel = new javax.swing.JPanel();
        dSDiemRenLuyenSV1 = new views.list.DSDiemRenLuyenCaNhan();
        formChamDiem1 = new views.main.FormChamDiemSV();
        dsDiemToanTruongPanel = new javax.swing.JTabbedPane();
        dSDiemRenLuyenToanTruong1 = new views.list.DSDiemRenLuyenToanTruong();
        taiKhoanSinhVienPanel = new javax.swing.JTabbedPane();
        taiKhoanSinhVien1 = new views.main.TaiKhoanSinhVien();
        header = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        scrollPaneWin112 = new view.custom.scroll.ScrollPane();
        menu1 = new view.custom.menu.MenuSinhVien();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ ĐIỂM RÈN LUYỆN PTITHCM");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        LayeredPane.setBackground(new java.awt.Color(255, 255, 255));
        LayeredPane.setMinimumSize(new java.awt.Dimension(1140, 647));
        LayeredPane.setPreferredSize(new java.awt.Dimension(1674, 647));
        LayeredPane.setLayout(new java.awt.CardLayout());

        dsSinhVienPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsSinhVienPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsSinhVienPanel.setPreferredSize(new java.awt.Dimension(1674, 650));

        javax.swing.GroupLayout dSDiemRenLuyenSVPanelLayout = new javax.swing.GroupLayout(dSDiemRenLuyenSVPanel);
        dSDiemRenLuyenSVPanel.setLayout(dSDiemRenLuyenSVPanelLayout);
        dSDiemRenLuyenSVPanelLayout.setHorizontalGroup(
            dSDiemRenLuyenSVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dSDiemRenLuyenSVPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dSDiemRenLuyenSV1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        dSDiemRenLuyenSVPanelLayout.setVerticalGroup(
            dSDiemRenLuyenSVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dSDiemRenLuyenSVPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dSDiemRenLuyenSV1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        dsSinhVienPanel.addTab("Danh sách điểm rèn luyện", dSDiemRenLuyenSVPanel);
        dsSinhVienPanel.addTab("Chấm điểm rèn luyện", formChamDiem1);

        LayeredPane.add(dsSinhVienPanel, "card2");

        dsDiemToanTruongPanel.setBackground(new java.awt.Color(255, 255, 255));
        dsDiemToanTruongPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dsDiemToanTruongPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        dsDiemToanTruongPanel.addTab("Danh sách điểm rèn luyện toàn trường", dSDiemRenLuyenToanTruong1);

        LayeredPane.add(dsDiemToanTruongPanel, "card2");

        taiKhoanSinhVienPanel.setBackground(new java.awt.Color(255, 255, 255));
        taiKhoanSinhVienPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taiKhoanSinhVienPanel.setPreferredSize(new java.awt.Dimension(1674, 650));
        taiKhoanSinhVienPanel.addTab("Tài khoản cá nhân", taiKhoanSinhVien1);

        LayeredPane.add(taiKhoanSinhVienPanel, "card2");

        header.setBackground(new java.awt.Color(20, 80, 55));
        header.setPreferredSize(new java.awt.Dimension(1140, 62));

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

        menu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu1.setMinimumSize(new java.awt.Dimension(196, 242));
        menu1.setPreferredSize(new java.awt.Dimension(196, 242));
        scrollPaneWin112.setViewportView(menu1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-ptit 50x50.png"))); // NOI18N

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(LayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                SinhVien main = new SinhVien();

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
    private views.list.DSDiemRenLuyenCaNhan dSDiemRenLuyenSV1;
    private javax.swing.JPanel dSDiemRenLuyenSVPanel;
    private views.list.DSDiemRenLuyenToanTruong dSDiemRenLuyenToanTruong1;
    private javax.swing.JTabbedPane dsDiemToanTruongPanel;
    private javax.swing.JTabbedPane dsSinhVienPanel;
    private views.main.FormChamDiemSV formChamDiem1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private view.custom.menu.MenuSinhVien menu1;
    private view.custom.scroll.ScrollPane scrollPaneWin112;
    private javax.swing.JPanel sideMenu;
    private views.main.TaiKhoanSinhVien taiKhoanSinhVien1;
    private javax.swing.JTabbedPane taiKhoanSinhVienPanel;
    // End of variables declaration//GEN-END:variables

}
