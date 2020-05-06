package us.deathmarine.luyten;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = -5691181006363313993L;
    Icon pack;
    Icon java_image;
    Icon image_image;
    Icon css_image;
    Icon html_image;
    Icon javascript_image;
    Icon yml_image;
    Icon file_image;

    public CellRenderer() {
        this.pack = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/package_obj.png")));

        this.image_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/image.png")));

        this.java_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/java.png")));

        this.css_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/css.png")));

        this.html_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/html.png")));

        this.javascript_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/js.png")));

        this.yml_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/yml.png")));

        this.file_image = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/file.png")));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getChildCount() > 0) {
            setIcon(this.pack);

        } else if (getFileName(node).endsWith(".class") || getFileName(node).endsWith(".java")) {
            setIcon(this.java_image);

        } else if (getFileName(node).endsWith(".png") || getFileName(node).endsWith(".jpg") || getFileName(node).endsWith(".gif") || getFileName(node).endsWith(".tiff")) {
            setIcon(this.image_image);

        } else if (getFileName(node).endsWith(".js")) {
            setIcon(this.javascript_image);

        } else if (getFileName(node).endsWith(".html")) {
            setIcon(this.html_image);

        } else if (getFileName(node).endsWith(".css")) {
            setIcon(this.css_image);

        } else if (getFileName(node).endsWith(".yml") || getFileName(node).endsWith(".yaml")) {
            setIcon(this.yml_image);

        } else {
            setIcon(this.file_image);
        }

        return this;
    }

    public String getFileName(DefaultMutableTreeNode node) {
        return ((TreeNodeUserObject) node.getUserObject()).getOriginalName();
    }

}
