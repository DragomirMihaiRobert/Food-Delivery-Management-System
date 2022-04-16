package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class SearchView extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblKeywordInThe;
	private JLabel lblMinimumRating;
	private JLabel lblMaximumPrice;
	private JLabel lblMaximumNumberOf;
	private JLabel lblMinimumNumberOf;
	private JLabel lblMaximumGramsOf;
	private JLabel lblMaximumGramsOf_1;
	private JTextField keyword;
	private JTextField rating;
	private JTextField price;
	private JTextField calories;
	private JTextField proteins;
	private JTextField fat;
	private JTextField sodium;
	private JButton searchBttn;

	public SearchView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Search for Products ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(133, 25, 147, 35);
		contentPane.add(lblNewLabel);
		
		lblKeywordInThe = new JLabel("Keyword in the title:");
		lblKeywordInThe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKeywordInThe.setBounds(26, 70, 182, 24);
		contentPane.add(lblKeywordInThe);
		
		lblMinimumRating = new JLabel("Minimum rating:");
		lblMinimumRating.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinimumRating.setBounds(26, 104, 182, 24);
		contentPane.add(lblMinimumRating);
		
		lblMaximumPrice = new JLabel("Maximum price:");
		lblMaximumPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaximumPrice.setBounds(26, 138, 182, 24);
		contentPane.add(lblMaximumPrice);
		
		lblMaximumNumberOf = new JLabel("Maximum number of calories:");
		lblMaximumNumberOf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaximumNumberOf.setBounds(26, 172, 194, 24);
		contentPane.add(lblMaximumNumberOf);
		
		lblMinimumNumberOf = new JLabel("Minimum grams of proteins:");
		lblMinimumNumberOf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinimumNumberOf.setBounds(26, 206, 182, 24);
		contentPane.add(lblMinimumNumberOf);
		
		lblMaximumGramsOf = new JLabel("Maximum grams of fat:");
		lblMaximumGramsOf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaximumGramsOf.setBounds(26, 240, 182, 24);
		contentPane.add(lblMaximumGramsOf);
		
		lblMaximumGramsOf_1 = new JLabel("Maximum grams of sodium:");
		lblMaximumGramsOf_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaximumGramsOf_1.setBounds(26, 274, 182, 24);
		contentPane.add(lblMaximumGramsOf_1);
		
		keyword = new JTextField();
		keyword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		keyword.setBounds(241, 70, 118, 19);
		contentPane.add(keyword);
		keyword.setColumns(10);
		
		rating = new JTextField();
		rating.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rating.setColumns(10);
		rating.setBounds(241, 104, 118, 19);
		contentPane.add(rating);
		
		price = new JTextField();
		price.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		price.setColumns(10);
		price.setBounds(241, 138, 118, 19);
		contentPane.add(price);
		
		calories = new JTextField();
		calories.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		calories.setColumns(10);
		calories.setBounds(241, 172, 118, 19);
		contentPane.add(calories);
		
		proteins = new JTextField();
		proteins.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		proteins.setColumns(10);
		proteins.setBounds(241, 206, 118, 19);
		contentPane.add(proteins);
		
		fat = new JTextField();
		fat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fat.setColumns(10);
		fat.setBounds(241, 240, 118, 19);
		contentPane.add(fat);
		
		sodium = new JTextField();
		sodium.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sodium.setColumns(10);
		sodium.setBounds(241, 274, 118, 19);
		contentPane.add(sodium);

		searchBttn = new JButton("SEARCH");
		searchBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		searchBttn.setBounds(241, 315, 118, 21);
		contentPane.add(searchBttn);
	}

	public void addSearchBttnActionListener(ActionListener actionListener){
		searchBttn.addActionListener(actionListener);
	}

	public int getFat(){
		if(fat.getText().equals(""))
			return Integer.MAX_VALUE;
		return Integer.parseInt(fat.getText());
	}

	public int getSodium(){
		if(sodium.getText().equals(""))
			return Integer.MAX_VALUE;
		return Integer.parseInt(sodium.getText());
	}


	public int getProteins(){
		if(proteins.getText().equals(""))
			return 0;
		return Integer.parseInt(proteins.getText());
	}

	public int getCalories(){
		if(calories.getText().equals(""))
			return Integer.MAX_VALUE;
		return Integer.parseInt(calories.getText());
	}


	public int getPrice(){
		if(price.getText().equals(""))
			return Integer.MAX_VALUE;
		return Integer.parseInt(price.getText());
	}


	public float getRaiting(){
		if(rating.getText().equals(""))
			return 0;
		return Float.parseFloat(rating.getText());
	}

	public String getKeyword(){
		return keyword.getText();
	}

}
