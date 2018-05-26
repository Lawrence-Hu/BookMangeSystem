package com.lms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Meun {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meun window = new Meun();
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
	public Meun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u56FE\u4E66\u7EF4\u62A4");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 930, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{133, 199, 220, 199, 0};
		gridBagLayout.rowHeights = new int[]{57, 63, 50, 43, 50, 59, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton jb_BookManager = new JButton("\u56FE\u4E66\u7EF4\u62A4");
		jb_BookManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				BookManageInterFrm bFrm = new BookManageInterFrm();
//				bFrm.setVisible(true);
//				table.add(bFrm);
//				
			
			}
		});
		
//		JDesktopPane table = new JDesktopPane();
//		table.setBounds(0, 0, 908, 488);
//		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(Meun.class.getResource("/icon/title.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		jb_BookManager.setHorizontalAlignment(SwingConstants.LEADING);
		jb_BookManager.setIcon(new ImageIcon(Meun.class.getResource("/icon/book.png")));
		jb_BookManager.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_BookManager = new GridBagConstraints();
		gbc_jb_BookManager.fill = GridBagConstraints.BOTH;
		gbc_jb_BookManager.insets = new Insets(0, 0, 5, 5);
		gbc_jb_BookManager.gridx = 1;
		gbc_jb_BookManager.gridy = 2;
		frame.getContentPane().add(jb_BookManager, gbc_jb_BookManager);
		
		JButton jb_UserManager = new JButton("\u7528\u6237\u7EF4\u62A4");
		jb_UserManager.setIcon(new ImageIcon(Meun.class.getResource("/icon/user-set.png")));
		jb_UserManager.setHorizontalAlignment(SwingConstants.LEADING);
		jb_UserManager.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_UserManager = new GridBagConstraints();
		gbc_jb_UserManager.fill = GridBagConstraints.BOTH;
		gbc_jb_UserManager.insets = new Insets(0, 0, 5, 0);
		gbc_jb_UserManager.gridx = 3;
		gbc_jb_UserManager.gridy = 2;
		frame.getContentPane().add(jb_UserManager, gbc_jb_UserManager);
		
		JButton jb_Brorrow = new JButton("\u501F    \u4E66");
		jb_Brorrow.setIcon(new ImageIcon(Meun.class.getResource("/icon/borrow.png")));
		jb_Brorrow.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Brorrow.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_Brorrow = new GridBagConstraints();
		gbc_jb_Brorrow.fill = GridBagConstraints.BOTH;
		gbc_jb_Brorrow.insets = new Insets(0, 0, 5, 5);
		gbc_jb_Brorrow.gridx = 1;
		gbc_jb_Brorrow.gridy = 4;
		frame.getContentPane().add(jb_Brorrow, gbc_jb_Brorrow);
		
		JButton jb_Back = new JButton("\u8FD8    \u4E66");
		jb_Back.setIcon(new ImageIcon(Meun.class.getResource("/icon/back.png")));
		jb_Back.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Back.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_Back = new GridBagConstraints();
		gbc_jb_Back.fill = GridBagConstraints.BOTH;
		gbc_jb_Back.insets = new Insets(0, 0, 5, 0);
		gbc_jb_Back.gridx = 3;
		gbc_jb_Back.gridy = 4;
		frame.getContentPane().add(jb_Back, gbc_jb_Back);
		
		JButton jb_Search = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		jb_Search.setIcon(new ImageIcon(Meun.class.getResource("/icon/search.png")));
		jb_Search.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Search.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_Search = new GridBagConstraints();
		gbc_jb_Search.fill = GridBagConstraints.BOTH;
		gbc_jb_Search.insets = new Insets(0, 0, 0, 5);
		gbc_jb_Search.gridx = 1;
		gbc_jb_Search.gridy = 6;
		frame.getContentPane().add(jb_Search, gbc_jb_Search);
		
		JButton jb_Exit = new JButton("\u9000    \u51FA");
		jb_Exit.setIcon(new ImageIcon(Meun.class.getResource("/icon/exit.png")));
		jb_Exit.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Exit.setBackground(Color.WHITE);
		GridBagConstraints gbc_jb_Exit = new GridBagConstraints();
		gbc_jb_Exit.fill = GridBagConstraints.BOTH;
		gbc_jb_Exit.gridx = 3;
		gbc_jb_Exit.gridy = 6;
		frame.getContentPane().add(jb_Exit, gbc_jb_Exit);


		

		

	}
}
