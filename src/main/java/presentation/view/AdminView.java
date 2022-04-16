package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
	private JPanel contentPane;
	private JButton importProductsBttn;
	private JLabel lblNewLabel;
	private JButton manageProductsBttn;
	private JButton generateReportsBttn;
	
	public AdminView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Admin Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 436, 73);
		contentPane.add(lblNewLabel);

		importProductsBttn = new JButton("Import Products");
		importProductsBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		importProductsBttn.setBounds(128, 84, 191, 37);
		contentPane.add(importProductsBttn);

		manageProductsBttn = new JButton("Manage Products");
		manageProductsBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		manageProductsBttn.setBounds(128, 131, 191, 37);
		contentPane.add(manageProductsBttn);

		generateReportsBttn = new JButton("Generate Reports");
		generateReportsBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		generateReportsBttn.setBounds(128, 175, 191, 37);
		contentPane.add(generateReportsBttn);
	}
	public void addManageProductsBttnActionListener(ActionListener actionListener){
		manageProductsBttn.addActionListener(actionListener);
	}
	public void addGenerateReportsBttnActionListener(ActionListener actionListener){
		generateReportsBttn.addActionListener(actionListener);
	}
	public void addImportProductsBttnActionListener(ActionListener actionListener){
		importProductsBttn.addActionListener(actionListener);
	}
	public void showError(String error){
		JOptionPane.showMessageDialog(this, error);
	}

}
