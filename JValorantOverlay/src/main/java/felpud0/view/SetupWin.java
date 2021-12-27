package felpud0.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupWin {

	private JFrame frame;
	private JTextField nickTF;
	private JTextField tagTF;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWin window = new SetupWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your nickname!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {10, 0, 0, 10};
		gbl_panel.rowHeights = new int[] {0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JLayeredPane panel_3 = new JLayeredPane();
		panel_1.add(panel_3, "name_191251950512100");
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel nickL = new JLabel("Nick:");
		GridBagConstraints gbc_nickL = new GridBagConstraints();
		gbc_nickL.anchor = GridBagConstraints.EAST;
		gbc_nickL.insets = new Insets(0, 0, 5, 5);
		gbc_nickL.gridx = 0;
		gbc_nickL.gridy = 0;
		panel_3.add(nickL, gbc_nickL);
		
		nickTF = new JTextField();
		GridBagConstraints gbc_nickTF = new GridBagConstraints();
		gbc_nickTF.insets = new Insets(0, 0, 5, 0);
		gbc_nickTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nickTF.gridx = 1;
		gbc_nickTF.gridy = 0;
		panel_3.add(nickTF, gbc_nickTF);
		nickTF.setColumns(10);
		
		JLabel tagL = new JLabel("Tag:");
		GridBagConstraints gbc_tagL = new GridBagConstraints();
		gbc_tagL.anchor = GridBagConstraints.EAST;
		gbc_tagL.insets = new Insets(0, 0, 0, 5);
		gbc_tagL.gridx = 0;
		gbc_tagL.gridy = 1;
		panel_3.add(tagL, gbc_tagL);
		
		tagTF = new JTextField();
		GridBagConstraints gbc_tagTF = new GridBagConstraints();
		gbc_tagTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tagTF.gridx = 1;
		gbc_tagTF.gridy = 1;
		panel_3.add(tagTF, gbc_tagTF);
		tagTF.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_191262102787000");
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWeights = new double[]{0.0, 0.0};
		gbl_layeredPane.rowWeights = new double[]{0.0};
		layeredPane.setLayout(gbl_layeredPane);
		
		JLabel lblNewLabel = new JLabel("NameTag:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		layeredPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		layeredPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWeights = new double[]{0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		panel_2.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		panel_2.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 2;
		panel_2.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.rowHeights = new int[]{0, 30};
		gbl_panel_4.columnWeights = new double[]{0.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnNewButton, gbc_btnNewButton);
	}
}
