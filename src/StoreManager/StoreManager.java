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
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		
		JList ordersJList = new JList();
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

        initializeOrdersJList();
	}

    private void initializeOrdersJList() {
        EntityManager em = new EntityManagerContainer().getEm();
        Collection<Order> orders = em.createNamedQuery("Order.findAll", Order.class).getResultList();
        em.close();
    }

}
