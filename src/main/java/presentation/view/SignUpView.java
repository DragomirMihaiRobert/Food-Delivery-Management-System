package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JTextField name;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lbName;
	private JLabel signUpLabel;
	private JButton signUpBttn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		signUpLabel = new JLabel("Sign Up");
		signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signUpLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		signUpLabel.setBounds(116, 29, 200, 39);
		contentPane.add(signUpLabel);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		username.setColumns(10);
		username.setBounds(220, 136, 96, 19);
		contentPane.add(username);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(104, 140, 91, 13);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(104, 178, 91, 13);
		contentPane.add(lblPassword);
		
		signUpBttn = new JButton("SIGN UP");
		signUpBttn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		signUpBttn.setBounds(220, 218, 96, 21);
		contentPane.add(signUpBttn);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		password.setBounds(220, 176, 96, 19);
		contentPane.add(password);
		
		lbName = new JLabel("Name:");
		lbName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbName.setBounds(104, 102, 91, 13);
		contentPane.add(lbName);
		
		name = new JTextField();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		name.setBounds(220, 100, 96, 19);
		contentPane.add(name);
	}
	public String getPassword(){
		return new String(password.getPassword());
	}
	public String getUsername(){
		return username.getText();
	}
	public String getName(){
		return name.getText();
	}

	public void addSignUpBttnListener(ActionListener actionListener){
		signUpBttn.addActionListener(actionListener);
	}

	public void showError(String error){
		JOptionPane.showMessageDialog(this, error);
	}

}
