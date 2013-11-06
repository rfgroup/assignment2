package StoreManager;

import WidgetOrder.Entity.Order;

import javax.swing.*;
import java.awt.*;

/**
 * <p>Title: OrderListCellRenderer </p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Michael Haas
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
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
        // to assume that there is just one widget in the list. If the amount ordered is greater than
        // the quantity in inventory for a widget, mark the background red.
        if (order.getAmountOrdered() > order.getWidgets().iterator().next().getQuantity()) {
            setBackground(Color.RED);
        } else {
            setBackground(list.getBackground());
        }

        setHorizontalAlignment(LEFT);
        setText(value.toString());

        return this;
    }
}
