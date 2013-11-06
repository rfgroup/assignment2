package StoreManager;

import WidgetOrder.Entity.EntityManagerContainer;
import WidgetOrder.Entity.Order;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JList;

import java.util.Collection;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Title: StoreManager</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Michael Haas
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */
public class StoreManager {

	private JFrame frmStoreManager;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreManager window = new StoreManager();
					window.frmStoreManager.setVisible(true);
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
        // Fetch all orders from the DB and sort by date to fulfill first come first serve
        EntityManager em = new EntityManagerContainer().getEm();
        Collection<Order> orders = em.createNamedQuery("Order.findAll", Order.class).getResultList();
        Collections.sort((List<Order>) orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getCreated() == null || o2.getCreated() == null) {
                    return 0;
                }
                return o1.getCreated().compareTo(o2.getCreated());
            }
        });
        em.close();

		frmStoreManager = new JFrame();
		frmStoreManager.setTitle("Store Manager");
		frmStoreManager.setBounds(100, 100, 600, 500);
		frmStoreManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmStoreManager.getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frmStoreManager.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JList ordersJList = new JList(orders.toArray());
        ordersJList.setFixedCellHeight(50);
        ordersJList.setCellRenderer(new OrderListCellRenderer());
		scrollPane.setViewportView(ordersJList);
		
		JLabel lblNewLabel = new JLabel("Orders marked red have more widgets ordered than there is in inventory.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 13;
		frmStoreManager.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
	}
}
