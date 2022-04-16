package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class LogInView extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogIn;
	private JPasswordField password;
	private JTextField username;
	private JButton signInBttn;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblSignUp;
	private JButton signUpBttn;

	public LogInView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(115, 33, 200, 39);
		contentPane.add(lblLogIn);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		username.setBounds(219, 95, 96, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(103, 99, 91, 13);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(103, 144, 91, 13);
		contentPane.add(lblPassword);
		
		signInBttn = new JButton("SIGN IN");
		signInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		signInBttn.setBounds(219, 182, 96, 21);
		contentPane.add(signInBttn);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		password.setBounds(219, 142, 96, 19);
		contentPane.add(password);
		
		lblSignUp = new JLabel("Don'thave an account? Sign up.");
		lblSignUp.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblSignUp.setBounds(321, 228, 142, 13);
		contentPane.add(lblSignUp);
		
		signUpBttn = new JButton("Sign Up");
		signUpBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		signUpBttn.setBounds(348, 247, 85, 21);
		contentPane.add(signUpBttn);
	}
	public String getPassword(){
		return new String(password.getPassword());
	}
	public String getUsername(){
		return username.getText();
	}
	public void addsignInBttnListener(ActionListener actionListener){
		signInBttn.addActionListener(actionListener);
	}
	public void addSignUpBttnListener(ActionListener actionListener){
		signUpBttn.addActionListener(actionListener);
	}
	public void showError(String error){
		JOptionPane.showMessageDialog(this, error);
	}
	
}
