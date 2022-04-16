package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateCompositeItemView extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblSelectTitle;
    private JTextField title;
    private JButton createButton;

    public CreateCompositeItemView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Create Composite Menu Item");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setToolTipText("");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 47, 416, 27);
        contentPane.add(lblNewLabel);

        lblSelectTitle = new JLabel("Select Title:");
        lblSelectTitle.setToolTipText("");
        lblSelectTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblSelectTitle.setBounds(10, 84, 208, 27);
        contentPane.add(lblSelectTitle);

        title = new JTextField();
        title.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        title.setBounds(165, 84, 208, 22);
        contentPane.add(title);
        title.setColumns(10);

        createButton = new JButton("CREATE");
        createButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        createButton.setBounds(75, 121, 298, 21);
        contentPane.add(createButton);
    }
    public void addCreateButtonActionListener(ActionListener actionListener){
        createButton.addActionListener(actionListener);
    }
    public String getTitle(){
        return title.getText();
    }

}
