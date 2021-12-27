package felpud0.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Insets;

public class Window {

	private JFrame frame;

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
	
	private BufferedImage getImageFromUrl(String url) throws IOException {
		
        URL ourl = new URL(url);
        BufferedImage image = ImageIO.read(ourl);
        
        return image;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
 
		
		frame = new JFrame();
		frame.setBounds(0, 0, 545, 145);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("raze.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		String path = "https://external-preview.redd.it/nD3AjGMpXjsCO9vbkKry-1kBfwQBGloaiWD7Ko51WlE.jpg?auto=webp&s=0c73f187b73eef9e9aef21b2813fcd939a4e75f5";
        System.out.println("Get Image from " + path);
        URL url;
		try {
			url = new URL(path);
	        BufferedImage image = ImageIO.read(url);
	        JLabel label = new JLabel();
	        label.setSize(new Dimension(frame.getHeight(), frame.getHeight()));
	        label.setPreferredSize(new Dimension(frame.getHeight(), frame.getHeight()));
	        Image dimg = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon imageIcon = new ImageIcon(dimg);
	        label.setIcon(imageIcon);

	        GridBagConstraints gbc_label = new GridBagConstraints();
	        gbc_label.insets = new Insets(0, 0, 0, 0);
	        gbc_label.gridx = 0;
	        gbc_label.fill = GridBagConstraints.BOTH;
	        gbc_label.gridy = 0;
	        frame.getContentPane().add(label, gbc_label);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
