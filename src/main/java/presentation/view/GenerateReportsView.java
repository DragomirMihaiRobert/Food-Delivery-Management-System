package presentation.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GenerateReportsView extends JFrame {

	private JPanel contentPane;
	private JTextField clientsTimesOrdered;
	private JTextField amount;
	private JTextField productsTimesOrdered;
	private JTextField startHour;
	private JTextField endHour;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel;
	private JButton generateReport1Bttn;
	private JButton generateReport2Bttn;
	private JButton generateReport3Bttn;
	private JButton generateReport4Bttn;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel6;
	private JLabel lblNewLabel8;
	private JLabel lblNewLabel9;
	private JLabel lblNewLabel10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateReportsView frame = new GenerateReportsView();
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
	public GenerateReportsView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Generate Reports");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 34, 726, 33);
		contentPane.add(lblNewLabel);
		
		lblNewLabel1 = new JLabel("Time interval of the orders.      start hour:");
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel1.setBounds(10, 77, 271, 26);
		contentPane.add(lblNewLabel1);
		
		lblNewLabel3 = new JLabel("Products ordered more than");
		lblNewLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel3.setBounds(10, 113, 175, 26);
		contentPane.add(lblNewLabel3);
		
		lblNewLabel5 = new JLabel("Clients that have ordered more than");
		lblNewLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel5.setBounds(10, 149, 230, 26);
		contentPane.add(lblNewLabel5);
		
		lblNewLabel6 = new JLabel("times and the value of the order was higher than");
		lblNewLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel6.setBounds(299, 149, 304, 26);
		contentPane.add(lblNewLabel6);
		
		clientsTimesOrdered = new JTextField();
		clientsTimesOrdered.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		clientsTimesOrdered.setBounds(241, 154, 50, 19);
		contentPane.add(clientsTimesOrdered);
		clientsTimesOrdered.setColumns(10);
		
		amount = new JTextField();
		amount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		amount.setColumns(10);
		amount.setBounds(613, 154, 50, 19);
		contentPane.add(amount);
		
		generateReport3Bttn = new JButton("Generate");
		generateReport3Bttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		generateReport3Bttn.setBounds(691, 153, 95, 21);
		contentPane.add(generateReport3Bttn);
		
		lblNewLabel4 = new JLabel("times so far.");
		lblNewLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel4.setBounds(248, 113, 304, 26);
		contentPane.add(lblNewLabel4);
		
		productsTimesOrdered = new JTextField();
		productsTimesOrdered.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		productsTimesOrdered.setColumns(10);
		productsTimesOrdered.setBounds(190, 118, 50, 19);
		contentPane.add(productsTimesOrdered);
		
		lblNewLabel2 = new JLabel("end hour:");
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel2.setBounds(393, 77, 69, 26);
		contentPane.add(lblNewLabel2);
		
		startHour = new JTextField();
		startHour.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		startHour.setColumns(10);
		startHour.setBounds(291, 82, 84, 19);
		contentPane.add(startHour);
		
		endHour = new JTextField();
		endHour.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		endHour.setColumns(10);
		endHour.setBounds(472, 82, 84, 19);
		contentPane.add(endHour);
		
		lblNewLabel8 = new JLabel("Products ordered on date:          day:");
		lblNewLabel8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel8.setBounds(10, 185, 230, 26);
		contentPane.add(lblNewLabel8);
		
		day = new JTextField();
		day.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		day.setColumns(10);
		day.setBounds(241, 189, 50, 19);
		contentPane.add(day);
		
		lblNewLabel9 = new JLabel("month:");
		lblNewLabel9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel9.setBounds(299, 185, 50, 26);
		contentPane.add(lblNewLabel9);
		
		month = new JTextField();
		month.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		month.setColumns(10);
		month.setBounds(351, 189, 50, 19);
		contentPane.add(month);
		
		lblNewLabel10 = new JLabel("year:");
		lblNewLabel10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel10.setBounds(411, 185, 50, 26);
		contentPane.add(lblNewLabel10);
		
		year = new JTextField();
		year.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		year.setColumns(10);
		year.setBounds(454, 189, 50, 19);
		contentPane.add(year);
		
		generateReport4Bttn = new JButton("Generate");
		generateReport4Bttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		generateReport4Bttn.setBounds(691, 189, 95, 21);
		contentPane.add(generateReport4Bttn);
		
		generateReport2Bttn = new JButton("Generate");
		generateReport2Bttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		generateReport2Bttn.setBounds(691, 117, 95, 21);
		contentPane.add(generateReport2Bttn);
		
		generateReport1Bttn = new JButton("Generate");
		generateReport1Bttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		generateReport1Bttn.setBounds(691, 81, 95, 21);
		contentPane.add(generateReport1Bttn);
	}
	public int getStartHour(){
		return Integer.parseInt(startHour.getText());
	}
	public int getEndHour(){
		return Integer.parseInt(endHour.getText());
	}
	public int getAmount(){
		return Integer.parseInt(amount.getText());
	}
	public int getDay(){
		return Integer.parseInt(day.getText());
	}
	public int getMonth(){
		return Integer.parseInt(month.getText());
	}
	public int getYear(){
		return Integer.parseInt(year.getText());
	}
	public int getProductsTimesOrdered(){
		return Integer.parseInt(productsTimesOrdered.getText());
	}
	public int getClientsTimesOrdered(){
		return Integer.parseInt(clientsTimesOrdered.getText());
	}
	public void addGenerateReport1BttnActionListener(ActionListener actionListener){
		generateReport1Bttn.addActionListener(actionListener);
	}
	public void addGenerateReport2BttnActionListener(ActionListener actionListener){
		generateReport2Bttn.addActionListener(actionListener);
	}
	public void addGenerateReport3BttnActionListener(ActionListener actionListener){
		generateReport3Bttn.addActionListener(actionListener);
	}
	public void addGenerateReport4BttnActionListener(ActionListener actionListener){
		generateReport4Bttn.addActionListener(actionListener);
	}
	public void showError(String error){
		JOptionPane.showMessageDialog(this, error);
	}

}
