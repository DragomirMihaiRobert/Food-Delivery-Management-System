package presentation.view;

import business.BaseProduct;
import business.MenuItem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddProductView extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField title;
	private JTextField raiting;
	private JTextField price;
	private JTextField proteins;
	private JTextField calories;
	private JTextField sodium;
	private JTextField fat;
	private JLabel titleLbl;
	private JLabel raitingLbl;
	private JLabel priceLbl;
	private JLabel proteinsLbl;
	private JLabel caloriesLbl;
	private JLabel sodiumLbl;
	private JLabel fatLbl;
	private JButton addButton;

	public AddProductView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Add New Product to Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(121, 36, 240, 31);
		contentPane.add(lblNewLabel);
		
		titleLbl = new JLabel("Title:");
		titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		titleLbl.setBounds(55, 78, 56, 22);
		contentPane.add(titleLbl);
		
		title = new JTextField();
		title.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		title.setBounds(121, 81, 240, 19);
		contentPane.add(title);
		title.setColumns(10);
		
		raitingLbl = new JLabel("Raiting:");
		raitingLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		raitingLbl.setBounds(55, 118, 56, 22);
		contentPane.add(raitingLbl);
		
		raiting = new JTextField();
		raiting.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		raiting.setBounds(121, 121, 78, 19);
		contentPane.add(raiting);
		raiting.setColumns(10);
		
		priceLbl = new JLabel("Price:");
		priceLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		priceLbl.setBounds(217, 118, 56, 22);
		contentPane.add(priceLbl);
		
		price = new JTextField();
		price.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		price.setColumns(10);
		price.setBounds(283, 121, 78, 19);
		contentPane.add(price);
		
		proteinsLbl = new JLabel("Proteins:");
		proteinsLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		proteinsLbl.setBounds(55, 150, 56, 22);
		contentPane.add(proteinsLbl);
		
		proteins = new JTextField();
		proteins.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		proteins.setColumns(10);
		proteins.setBounds(121, 153, 78, 19);
		contentPane.add(proteins);
		
		caloriesLbl = new JLabel("Calories:");
		caloriesLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		caloriesLbl.setBounds(217, 150, 56, 22);
		contentPane.add(caloriesLbl);
		
		calories = new JTextField();
		calories.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		calories.setColumns(10);
		calories.setBounds(283, 153, 78, 19);
		contentPane.add(calories);
		
		sodiumLbl = new JLabel("Sodium:");
		sodiumLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sodiumLbl.setBounds(55, 182, 56, 22);
		contentPane.add(sodiumLbl);
		
		sodium = new JTextField();
		sodium.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sodium.setColumns(10);
		sodium.setBounds(121, 185, 78, 19);
		contentPane.add(sodium);
		
		fatLbl = new JLabel("Fat:");
		fatLbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fatLbl.setBounds(217, 182, 56, 22);
		contentPane.add(fatLbl);
		
		fat = new JTextField();
		fat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fat.setColumns(10);
		fat.setBounds(283, 185, 78, 19);
		contentPane.add(fat);
		
		addButton = new JButton("ADD");
		addButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addButton.setBounds(121, 220, 240, 31);
		contentPane.add(addButton);
	}

	public void addAddButtonActionListener(ActionListener actionListener){
		addButton.addActionListener(actionListener);
	}

	public MenuItem getNewMenuItem(){
		String prodTitle = title.getText();
		float prodRating = raiting.getText().isEmpty() ? 0 : Float.parseFloat(raiting.getText());
		int prodCalories = Integer.parseInt(calories.getText());
		int prodProteins = Integer.parseInt(proteins.getText());
		int prodFat = Integer.parseInt(fat.getText());
		int prodSodium = Integer.parseInt(sodium.getText());
		int prodPrice = Integer.parseInt(price.getText());
		return new BaseProduct(prodTitle, prodRating, prodCalories, prodProteins, prodFat, prodSodium, prodPrice);
	}

	public String[] newRow(){
		return new String[]{title.getText(), raiting.getText(), calories.getText(), proteins.getText(), fat.getText(),
							sodium.getText(), price.getText()};
	}

}
