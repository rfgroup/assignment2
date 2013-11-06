package WidgetOrder;
/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */


import javax.persistence.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;

import WidgetOrder.Entity.Order;
import WidgetOrder.Entity.Widget;

public class WidgetOrder extends JFrame {

    //private data members

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JList<Widget> listView;
    private Widget selectedWidget;

    public static void main(String[] args) {

        //Fetching Widgets from DB to load into JList
        new CreateFixtures().run();
        Vector<Widget> items = new Vector<Widget>();
        final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Collection<Widget> widgets = em.createNamedQuery("Widget.findAll", Widget.class).getResultList();
        for (Widget widget : widgets) {
            items.add(widget);
        }

        //start GUI
        WidgetOrder frame = new WidgetOrder(items);
        frame.setVisible(true);

    }

    /**
     * Create the frame.
     */
    public WidgetOrder(Vector<Widget> input_list) {

        //creating frame

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 603, 366);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Setting up scrollbar for JList

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(396, 30, 19, 261);
        contentPane.add(scrollBar);

        //creating JList with the Widgets from the DB

        listView = new JList<Widget>(input_list);
        listView.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedWidget = listView.getSelectedValue();
            }
        });
        listView.setBounds(33, 30, 381, 261);
        contentPane.add(listView);

        //creating button with an action listener that adds the order to the DB

        JButton btnProcessOrder = new JButton("Process Order");
        btnProcessOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(textField.getText());
                    String customerName = textField_1.getText();
                    Order order = new Order(customerName,quantity);
                    order.addWidget(selectedWidget);

                    final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
                    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                    EntityManager em = factory.createEntityManager();
                    em.getTransaction().begin();
                    em.persist(order);
                    em.getTransaction().commit();
                    Query q = em.createQuery("select w from Widget w");
                    List<Widget> widgetInventory = q.getResultList();
                    q = em.createQuery("select o from CustomerOrder o");
                    List<Order> ordersFromDB = q.getResultList();
                    for (Order or : ordersFromDB)
                        System.out.println(or);
                    for (Widget w : widgetInventory)
                        System.out.println(w);
                    em.close();


                } catch (NullPointerException v) {
                    System.err.println("NullPointerException: Please Enter a Customer Name and a Desired Quanity");
                } catch (NumberFormatException v) {
                    System.err.println("Please Enter Customer Name and Quanity");
                }
            }
        });
        btnProcessOrder.setBounds(424, 268, 123, 23);
        contentPane.add(btnProcessOrder);

        //creating textfields for gui

        textField = new JTextField();
        textField.setBounds(437, 206, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(437, 150, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        //creating labels

        JLabel lblEnterQty = new JLabel("Enter Qty");
        lblEnterQty.setBounds(455, 181, 53, 14);
        contentPane.add(lblEnterQty);

        JLabel lblSelectYourWidget = new JLabel("Select Your Widget");
        lblSelectYourWidget.setBounds(137, 11, 137, 14);
        contentPane.add(lblSelectYourWidget);

        JLabel lblEnterCustomerName = new JLabel("Enter Customer Name");
        lblEnterCustomerName.setBounds(424, 125, 137, 14);
        contentPane.add(lblEnterCustomerName);
    }


}
