package StoreManager;

import WidgetOrder.Entity.Widget;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/5/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreManager {
    private JPanel main;
    DefaultListModel model = new DefaultListModel();
    JList list1 = new JList(model);

    public void start() {
        JFrame frame = new JFrame("StoreManager");
        frame.setContentPane(new StoreManager().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        init();
    }

    private void init() {
        model.addElement(new Widget(43, "name", "desc"));
    }
}
