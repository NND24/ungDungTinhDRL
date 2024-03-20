package view.custom.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MenuQuanLy extends JComponent {

    public MenuEvent getEvent() {
        return event;
    }

    public void setEvent(MenuEvent event) {
        this.event = event;
    }

    private MenuEvent event;
    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"Xem điểm rèn luyện toàn trường"},
        {"Phân công"},
        {"Tạo phiếu điểm rèn luyện"},
        {"Quản lý chung", "Danh sách giảng viên", "Danh sách sinh viên", "Danh sách ngành", "Danh sách khoa", "Danh sách lớp", "Danh sách năm học"},
        {"Quản lý admin"},
        {"Tài khoản cá nhân"},
        {"Đăng xuất"}};

    public MenuQuanLy() {
        init();
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);
        //  Init MenuItem
        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }

    }

    private Icon getIcon(int index) {
        URL url = getClass().getResource("/raven/menu/" + index + ".png");
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }

    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);
        Icon icon = getIcon(index);
        if (icon != null) {
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        //  Hide menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    if (event != null) {
                        event.selected(index, 0);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setName(index + "");
        panel.setBackground(new Color(18, 99, 63));
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (event != null) {
                        event.selected(index, subItem.getIndex());
                    }
                }
            });
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }
        add(panel, "h 0!", indexZorder + 1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
    }

    private void hideMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D g2 = (Graphics2D) grphcs.create();

        // Điều chỉnh tỉ lệ giữa hai màu trong GradientPaint
        float ratio = 0.5f; // Tỉ lệ của màu Color(29, 151, 108), có thể điều chỉnh tùy ý

        // Tạo GradientPaint với điểm bắt đầu và kết thúc thay đổi để tạo hiệu ứng từ trên xuống dưới (ngược lại)
        GradientPaint gradientPaint = new GradientPaint(
                0, getHeight(), new Color(40, 160, 110),
                0, 0, new Color((int) (40 * ratio), (int) (160 * ratio), (int) (110 * ratio))
        );

        // Đặt lưu đồ màu của đối tượng Graphics2D thành GradientPaint
        g2.setPaint(gradientPaint);

        // Vẽ hình chữ nhật với GradientPaint
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));

        // Đặt màu nền cho JPanel
        setBackground(new Color((int) (29 * ratio), (int) (151 * ratio), (int) (108 * ratio)));

        // Giải phóng đối tượng Graphics2D
        g2.dispose();
    }

}
