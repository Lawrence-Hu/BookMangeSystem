package com.lms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Toolkit;

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
//					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Meun.class.getResource("/icon/title.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1025, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(Meun.class.getResource("/icon/title.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(328, 86, 286, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton jb_BookManager = new JButton("\u56FE\u4E66\u7EF4\u62A4");
		jb_BookManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManage BM = new BookManage();
				BM.setVisible(true);
			}
		});
		jb_BookManager.setFocusPainted(false);
		jb_BookManager.setBorderPainted(false);
		jb_BookManager.setHorizontalAlignment(SwingConstants.LEADING);
		jb_BookManager.setIcon(new ImageIcon(Meun.class.getResource("/icon/book.png")));
		jb_BookManager.setBackground(Color.WHITE);
		jb_BookManager.setBounds(170, 214, 199, 50);
		frame.getContentPane().add(jb_BookManager);
		
		JButton jb_UserManager = new JButton("\u7528\u6237\u7EF4\u62A4");
		jb_UserManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManage userManage = new UserManage();
				userManage.setVisible(true);
			}
		});
		jb_UserManager.setFocusPainted(false);
		jb_UserManager.setBorderPainted(false);
		jb_UserManager.setIcon(new ImageIcon(Meun.class.getResource("/icon/user-set.png")));
		jb_UserManager.setHorizontalAlignment(SwingConstants.LEADING);
		jb_UserManager.setBackground(Color.WHITE);
		jb_UserManager.setBounds(589, 214, 199, 50);
		frame.getContentPane().add(jb_UserManager);
		
		JButton jb_Brorrow = new JButton("\u501F    \u4E66");
		jb_Brorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookBorrow BB = new BookBorrow();
				BB.setVisible(true);
			}
		});
		jb_Brorrow.setFocusPainted(false);
		jb_Brorrow.setBorderPainted(false);
		jb_Brorrow.setIcon(new ImageIcon(Meun.class.getResource("/icon/borrow.png")));
		jb_Brorrow.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Brorrow.setBackground(Color.WHITE);
		jb_Brorrow.setBounds(170, 307, 199, 50);
		frame.getContentPane().add(jb_Brorrow);
		
		JButton jb_Back = new JButton("\u8FD8    \u4E66");
		jb_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookBack bookBack = new BookBack();
				bookBack.setVisible(true);
			}
		});
		jb_Back.setFocusPainted(false);
		jb_Back.setBorderPainted(false);
		jb_Back.setIcon(new ImageIcon(Meun.class.getResource("/icon/back.png")));
		jb_Back.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Back.setBackground(Color.WHITE);
		jb_Back.setBounds(589, 307, 199, 50);
		frame.getContentPane().add(jb_Back);
		
		JButton jb_Search = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		jb_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquiry inquiry = new Inquiry();
				inquiry.setVisible(true);	
			}
		});
		jb_Search.setFocusPainted(false);
		jb_Search.setBorderPainted(false);
		jb_Search.setIcon(new ImageIcon(Meun.class.getResource("/icon/search.png")));
		jb_Search.setHorizontalAlignment(SwingConstants.LEADING);
		jb_Search.setBackground(Color.WHITE);
		jb_Search.setBounds(170, 416, 199, 50);
		frame.getContentPane().add(jb_Search);
		
		JButton jb_Exit = new JButton("\u9000    \u51FA");
		jb_Exit.setHorizontalAlignment(SwingConstants.LEFT);
		jb_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "确定退出？");
				if(choice == 0){
					frame.dispose();
				}
			}
		});
		jb_Exit.setFocusPainted(false);
		jb_Exit.setBorderPainted(false);
		jb_Exit.setIcon(new ImageIcon(Meun.class.getResource("/icon/exit.png")));
		jb_Exit.setBackground(Color.WHITE);
		jb_Exit.setBounds(589, 416, 199, 50);
		frame.getContentPane().add(jb_Exit);
		
		
	}

	
}