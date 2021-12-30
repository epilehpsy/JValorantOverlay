package felpud0.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import felpud0.controller.Controller;
import felpud0.valorantAPI.CuentaMMR;
import felpud0.valorantAPI.CuentaStandard;
import felpud0.valorantAPI.ValorantGetter;

import javax.swing.border.MatteBorder;
import java.awt.Color;

public class SetupWin implements ActionListener {

	private JFrame frame;
	private JTextField nickTF;
	private JTextField tagTF;
	private JTextField nameTagTF;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel contenedorLayers;
	private ButtonGroup radioGroup;
	private JButton goButton;

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
		
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {10, 0, 0, 10};
		gbl_panel.rowHeights = new int[] {5, 0, 5};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		contenedorLayers = new JPanel();
		GridBagConstraints gbc_contenedorLayers = new GridBagConstraints();
		gbc_contenedorLayers.insets = new Insets(0, 0, 5, 5);
		gbc_contenedorLayers.fill = GridBagConstraints.VERTICAL;
		gbc_contenedorLayers.gridx = 1;
		gbc_contenedorLayers.gridy = 1;
		panel.add(contenedorLayers, gbc_contenedorLayers);
		contenedorLayers.setLayout(new CardLayout(0, 0));
		
		JLayeredPane separatedNickTag = new JLayeredPane();
		contenedorLayers.add(separatedNickTag, "card0");
		GridBagLayout gbl_separatedNickTag = new GridBagLayout();
		gbl_separatedNickTag.columnWidths = new int[]{0, 49};
		gbl_separatedNickTag.columnWeights = new double[]{0.0, 0.0};
		gbl_separatedNickTag.rowWeights = new double[]{0.0, 0.0};
		separatedNickTag.setLayout(gbl_separatedNickTag);
		
		JLabel nickL = new JLabel("Nick:");
		GridBagConstraints gbc_nickL = new GridBagConstraints();
		gbc_nickL.anchor = GridBagConstraints.EAST;
		gbc_nickL.insets = new Insets(0, 0, 5, 5);
		gbc_nickL.gridx = 0;
		gbc_nickL.gridy = 0;
		separatedNickTag.add(nickL, gbc_nickL);
		
		nickTF = new JTextField();
		GridBagConstraints gbc_nickTF = new GridBagConstraints();
		gbc_nickTF.anchor = GridBagConstraints.WEST;
		gbc_nickTF.insets = new Insets(0, 0, 5, 0);
		gbc_nickTF.gridx = 1;
		gbc_nickTF.gridy = 0;
		separatedNickTag.add(nickTF, gbc_nickTF);
		nickTF.setColumns(15);
		
		JLabel tagL = new JLabel("Tag:");
		GridBagConstraints gbc_tagL = new GridBagConstraints();
		gbc_tagL.anchor = GridBagConstraints.EAST;
		gbc_tagL.insets = new Insets(0, 0, 0, 5);
		gbc_tagL.gridx = 0;
		gbc_tagL.gridy = 1;
		separatedNickTag.add(tagL, gbc_tagL);
		
		tagTF = new JTextField();
		GridBagConstraints gbc_tagTF = new GridBagConstraints();
		gbc_tagTF.anchor = GridBagConstraints.WEST;
		gbc_tagTF.gridx = 1;
		gbc_tagTF.gridy = 1;
		separatedNickTag.add(tagTF, gbc_tagTF);
		tagTF.setColumns(5);
		
		JLayeredPane togNameTag = new JLayeredPane();
		contenedorLayers.add(togNameTag, "card1");
		GridBagLayout gbl_togNameTag = new GridBagLayout();
		gbl_togNameTag.columnWeights = new double[]{0.0, 1.0};
		gbl_togNameTag.rowWeights = new double[]{0.0};
		togNameTag.setLayout(gbl_togNameTag);
		
		JLabel lblNewLabel = new JLabel("NameTag:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		togNameTag.add(lblNewLabel, gbc_lblNewLabel);
		
		nameTagTF = new JTextField();
		GridBagConstraints gbc_nameTagTF = new GridBagConstraints();
		gbc_nameTagTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTagTF.gridx = 1;
		gbc_nameTagTF.gridy = 0;
		togNameTag.add(nameTagTF, gbc_nameTagTF);
		nameTagTF.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Search Method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 0);
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0};
		gbl_panel_2.columnWeights = new double[]{0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		 radioGroup = new ButtonGroup();
		 rdbtnNewRadioButton = new JRadioButton("Name; Tag");
		 rdbtnNewRadioButton.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		panel_2.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		radioGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(this);
		
		 rdbtnNewRadioButton_1 = new JRadioButton("Name#Tag");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		panel_2.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		radioGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(this);


		 rdbtnNewRadioButton_2 = new JRadioButton("Test");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 2;
		panel_2.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		radioGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(this);

		
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.rowHeights = new int[]{0, 5};
		gbl_panel_4.columnWeights = new double[]{0.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
		
		goButton = new JButton("Go!");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actionGo();
			}
		});
		GridBagConstraints gbc_goButton = new GridBagConstraints();
		gbc_goButton.insets = new Insets(0, 0, 5, 0);
		gbc_goButton.gridx = 0;
		gbc_goButton.gridy = 0;
		panel_4.add(goButton, gbc_goButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your profile!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1);
	}
	
	private void actionGo() {
		
		ValorantGetter vg=null;
		if (rdbtnNewRadioButton.isSelected()) {
			vg = Controller.getController().stablishPlayer(nickTF.getText(),tagTF.getText());
		}else if (rdbtnNewRadioButton_1.isSelected()) {
			vg = Controller.getController().stablishPlayer(nameTagTF.getText());
		}
		
		if (vg==null) {
			//TODO: Alerta, mal formateado
			JOptionPane.showMessageDialog(frame, "Bad formated nametag.","Format Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		CuentaStandard cs = Controller.getController().accountInfo();
		if (cs==null) {
			//TODO: Alerta, jugador no encontrado.
			JOptionPane.showMessageDialog(frame, "The player: " + vg.getNameTag() + " wasn't found.","Player not found.",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//TODO: Todo bien, sigamos haciendo cosas.
		goButton.setText("Please wait...");
		Window.main(null);
		frame.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object oe = e.getSource();
		CardLayout cl = (CardLayout) (contenedorLayers.getLayout());
		if (oe == rdbtnNewRadioButton) {
			cl.show(contenedorLayers, "card0");
		} else if (oe == rdbtnNewRadioButton_1) {
			cl.show(contenedorLayers, "card1");
		}
			
	}
	

}
