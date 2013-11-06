package StoreManager;

import WidgetOrder.Entity.EntityManagerContainer;
import WidgetOrder.Entity.Order;
import WidgetOrder.Entity.Widget;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.util.Collection;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class StoreManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreManager window = new StoreManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeOrdersJList();
	}

    private void initializeOrdersJList() {
        EntityManager em = new EntityManagerContainer().getEm();
        Collection<Order> orders = em.createNamedQuery("Order.findAll", Order.class).getResultList();
        em.close();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JList ordersJList = new JList(orders.toArray());
        ordersJList.setFixedCellHeight(50);
        ordersJList.setCellRenderer(new OrderListCellRenderer());

        scrollPane.setViewportView(ordersJList);
    }

}
