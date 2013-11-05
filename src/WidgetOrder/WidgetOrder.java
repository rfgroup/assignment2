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
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;
import javax.swing.JLabel;

public class WidgetOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WidgetOrder frame = new WidgetOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WidgetOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(396, 30, 19, 261);
		contentPane.add(scrollBar);
		
		JList list = new JList();
		list.setBounds(77, 206, 169, -125);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(33, 30, 381, 261);
		contentPane.add(list_1);
		
		JButton btnProcessOrder = new JButton("Process Order");
		btnProcessOrder.setBounds(424, 268, 123, 23);
		contentPane.add(btnProcessOrder);
		
		textField = new JTextField();
		textField.setBounds(437, 206, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterQty = new JLabel("Enter Qty");
		lblEnterQty.setBounds(455, 181, 53, 14);
		contentPane.add(lblEnterQty);
		
		JLabel lblSelectYourWidget = new JLabel("Select Your Widget");
		lblSelectYourWidget.setBounds(137, 11, 137, 14);
		contentPane.add(lblSelectYourWidget);
		
		textField_1 = new JTextField();
		textField_1.setBounds(437, 150, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterCustomerName = new JLabel("Enter Customer Name");
		lblEnterCustomerName.setBounds(424, 125, 137, 14);
		contentPane.add(lblEnterCustomerName);
	}
}
