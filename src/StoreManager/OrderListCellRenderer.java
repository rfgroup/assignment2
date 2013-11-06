package StoreManager;

import WidgetOrder.Entity.Order;
import WidgetOrder.Entity.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/5/13
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderListCellRenderer extends JLabel implements ListCellRenderer {

    public OrderListCellRenderer() {
        // Set the JLabel cells to be visible
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Order order = (Order) value;

        // System currently only supports one type of Widget per order, allowing us
        // to assume that there is just one widget in the list.
        if (order.getAmountOrdered() > order.getWidgets().iterator().next().getQuantity()) {
            setBackground(Color.RED);
        } else {
            setBackground(list.getBackground());
        }

        setMinimumSize(new Dimension(-1, 50));
        setSize(400, 100);
        setText(value.toString());

        return this;
    }
}
