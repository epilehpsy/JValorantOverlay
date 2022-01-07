package felpud0.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AttributeSet.ColorAttribute;

import felpud0.controller.Controller;
import felpud0.valorantAPI.CuentaMMR;
import felpud0.valorantAPI.CuentaStandard;
import felpud0.valorantAPI.HistorialPartidas;
import felpud0.valorantAPI.Partida;
import felpud0.valorantAPI.PartidaNormal;

import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;

public class Window {

	private JFrame frame;
	JLabel LRango;
    JLabel rankImg;
    JLabel LLevel;
    private JTable table;
    private JLabel lblNewLabel_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
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
	public Window() {
		initialize();
	}
	
	private BufferedImage getImageFromUrl(String path) throws IOException {
		
        URL url;
		url = new URL(path);
	    BufferedImage image = ImageIO.read(url);
	    return image;
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
		frame.setBounds(0, 0, 545, 145);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(SetupWin.class.getResource("/rsc/valIcon.png"));
		frame.setIconImage(img.getImage());
		frame.setTitle("");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 10, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		
		BufferedImage image;
        rankImg = new JLabel();
        rankImg.setSize(new Dimension(frame.getHeight(), frame.getHeight()));
        rankImg.setPreferredSize(new Dimension(frame.getHeight(), frame.getHeight()));
        try {
			image = getImageFromUrl("https://external-preview.redd.it/nD3AjGMpXjsCO9vbkKry-1kBfwQBGloaiWD7Ko51WlE.jpg?auto=webp&s=0c73f187b73eef9e9aef21b2813fcd939a4e75f5");

	        Image dimg = image.getScaledInstance(rankImg.getWidth(), rankImg.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon imageIcon = new ImageIcon(dimg);
	        rankImg.setIcon(imageIcon);
	        }catch (IOException e) {
	        	
			}
			


        GridBagConstraints gbc_rankImg = new GridBagConstraints();
        gbc_rankImg.insets = new Insets(0, 0, 0, 5);
        gbc_rankImg.gridx = 0;
        gbc_rankImg.fill = GridBagConstraints.BOTH;
        gbc_rankImg.gridy = 0;
        frame.getContentPane().add(rankImg, gbc_rankImg);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 0, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 0;
        frame.getContentPane().add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.rowHeights = new int[]{2, 0};
        gbl_panel.columnWeights = new double[]{1.0, 1.0};
        gbl_panel.rowWeights = new double[]{0.0, 1.0};
        panel.setLayout(gbl_panel);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 0, 5);
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 1;
        panel.add(panel_1, gbc_panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{14, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        JLabel lblNewLabel = new JLabel("Rank:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel_1.add(lblNewLabel, gbc_lblNewLabel);
        
        LRango = new JLabel("null");
        LRango.setForeground(new Color(0, 255, 0));
        LRango.setFont(new Font("Tahoma", Font.BOLD, 20));
        GridBagConstraints gbc_LRango = new GridBagConstraints();
        gbc_LRango.anchor = GridBagConstraints.WEST;
        gbc_LRango.gridwidth = 2;
        gbc_LRango.insets = new Insets(0, 0, 5, 5);
        gbc_LRango.gridx = 0;
        gbc_LRango.gridy = 1;
        panel_1.add(LRango, gbc_LRango);
        
        JLabel lblNewLabel_2 = new JLabel("Level:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        LLevel = new JLabel("null");
        GridBagConstraints gbc_LLevel = new GridBagConstraints();
        gbc_LLevel.anchor = GridBagConstraints.WEST;
        gbc_LLevel.insets = new Insets(0, 0, 5, 0);
        gbc_LLevel.gridx = 1;
        gbc_LLevel.gridy = 2;
        panel_1.add(LLevel, gbc_LLevel);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_2.gridx = 1;
        gbc_panel_2.gridy = 1;
        panel.add(panel_2, gbc_panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{46, 0};
        gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);
        
        lblNewLabel_1 = new JLabel("Last rankeds:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        
        table = new JTable(new String[3][2], new String[] {"ganada?","ptos"});
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        	
        	@Override
        	public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color cbackg;
                Color ctexto;

                if (table.getValueAt(row, 0).equals("WON")) {
                	cbackg = Color.GREEN;
                	ctexto = Color.BLACK;
                }else {
                	cbackg = Color.RED;
                	ctexto = Color.WHITE;
                }
                c.setBackground(cbackg);
                c.setForeground(ctexto);
                return c;        		
        	}
        });
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.anchor = GridBagConstraints.WEST;
        gbc_table.insets = new Insets(0, 0, 5, 0);
        gbc_table.gridx = 0;
        gbc_table.gridy = 2;
        panel_2.add(table, gbc_table);
        
        
        if (Controller.getController().isStablish()) {
        	fillAccountInfo();
        }
        


	}
	
	private void fillAccountInfo() {
		CuentaMMR a = Controller.getController().mmrInfo();
		CuentaStandard cs = Controller.getController().accountInfo();
		LRango.setText(a.getCurrentTierPatch()+" "+a.getRankInTier()+"pts");
		LLevel.setText(cs.getLevel()+"");
		Image img;
		try {
			img = getImageFromUrl(a.getRankImg()).getScaledInstance(frame.getHeight(), frame.getHeight(),  Image.SCALE_SMOOTH);
			rankImg.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rellenarValues();
		frame.setTitle("Details for: "+cs.getName()+"#"+cs.getTag());

		

		
	}
	
	private void rellenarValues() {
//		String[][] val=  new String[6][2];
		int[] hist = Controller.getController().getVG().getHistorialMMR();
		int i = 0;
		for(int j :hist) {
			
			table.setValueAt(j+"", i, 1);
//			val[i][1] = j+"";
			if (j>=0) {
				table.setValueAt("WON", i, 0);
//				val[i][0] = "WON";
			}else {
				table.setValueAt("LOSE", i, 0);
				//val[i][0] = "LOSE";
				
			}
		
			i++;
			if (i==3) break;
		}

//		return val;
	}
}
