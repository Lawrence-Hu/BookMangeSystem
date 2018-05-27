package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BookBack extends JFrame {

	private JPanel contentPane;
	private JTextField s_bookIdTxt;
	private JTextField bookIdTxt;
	private JTextField bookNameTxt;
	private JTextField publishTxt;
	private JTextField readerIdTxt;
	private JTextField readerNameTxt;
	private JTextField borrowTimeTxt;
	private JTextField moneyTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookBack frame = new BookBack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookBack() {
		setTitle("\u8FD8\u4E66\u7BA1\u7406\u4E2D\u5FC3");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookBack.class.getResource("/icon/back.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		setLocation(450, 200);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		label.setIcon(new ImageIcon(BookBack.class.getResource("/icon/book.png")));
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(111, 64, 142, 43);
		contentPane.add(label);
		
		s_bookIdTxt = new JTextField();
		s_bookIdTxt.setColumns(10);
		s_bookIdTxt.setBounds(267, 66, 441, 42);
		contentPane.add(s_bookIdTxt);
		
		JButton s_jbSearch = new JButton("\u641C\u7D22");
		s_jbSearch.setIcon(new ImageIcon(BookBack.class.getResource("/icon/search (2).png")));
		s_jbSearch.setForeground(new Color(0, 191, 255));
		s_jbSearch.setFont(new Font("宋体", Font.PLAIN, 20));
		s_jbSearch.setBounds(755, 65, 123, 43);
		contentPane.add(s_jbSearch);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		label_1.setIcon(new ImageIcon(BookBack.class.getResource("/icon/num.png")));
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(111, 180, 116, 43);
		contentPane.add(label_1);
		
		bookIdTxt = new JTextField();
		bookIdTxt.setEditable(false);
		bookIdTxt.setColumns(10);
		bookIdTxt.setBounds(240, 186, 172, 35);
		contentPane.add(bookIdTxt);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label_2.setIcon(new ImageIcon(BookBack.class.getResource("/icon/name.png")));
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(559, 180, 121, 43);
		contentPane.add(label_2);
		
		bookNameTxt = new JTextField();
		bookNameTxt.setEditable(false);
		bookNameTxt.setColumns(10);
		bookNameTxt.setBounds(694, 186, 172, 35);
		contentPane.add(bookNameTxt);
		
		JLabel label_3 = new JLabel("\u51FA \u7248 \u793E");
		label_3.setIcon(new ImageIcon(BookBack.class.getResource("/icon/job.png")));
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(111, 281, 116, 43);
		contentPane.add(label_3);
		
		publishTxt = new JTextField();
		publishTxt.setEditable(false);
		publishTxt.setColumns(10);
		publishTxt.setBounds(241, 287, 172, 35);
		contentPane.add(publishTxt);
		
		JLabel label_4 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		label_4.setIcon(new ImageIcon(BookBack.class.getResource("/icon/num.png")));
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(559, 281, 116, 43);
		contentPane.add(label_4);
		
		readerIdTxt = new JTextField();
		readerIdTxt.setEnabled(false);
		readerIdTxt.setColumns(10);
		readerIdTxt.setBounds(694, 287, 172, 35);
		contentPane.add(readerIdTxt);
		
		JLabel label_5 = new JLabel("\u8BFB\u8005\u59D3\u540D");
		label_5.setIcon(new ImageIcon(BookBack.class.getResource("/icon/name.png")));
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(111, 379, 121, 43);
		contentPane.add(label_5);
		
		readerNameTxt = new JTextField();
		readerNameTxt.setEditable(false);
		readerNameTxt.setColumns(10);
		readerNameTxt.setBounds(240, 385, 172, 35);
		contentPane.add(readerNameTxt);
		
		JLabel label_6 = new JLabel("\u501F\u4E66\u65F6\u95F4");
		label_6.setIcon(new ImageIcon(BookBack.class.getResource("/icon/time.png")));
		label_6.setForeground(new Color(0, 191, 255));
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(559, 379, 116, 43);
		contentPane.add(label_6);
		
		borrowTimeTxt = new JTextField();
		borrowTimeTxt.setEditable(false);
		borrowTimeTxt.setColumns(10);
		borrowTimeTxt.setBounds(694, 385, 172, 35);
		contentPane.add(borrowTimeTxt);
		
		JButton jb_backBook = new JButton("\u786E\u8BA4\u8FD8\u4E66");
		jb_backBook.setIcon(new ImageIcon(BookBack.class.getResource("/icon/trues-active.png")));
		jb_backBook.setForeground(new Color(0, 191, 255));
		jb_backBook.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_backBook.setBounds(267, 552, 165, 43);
		contentPane.add(jb_backBook);
		
		JButton jb_return = new JButton("\u8FD4\u56DE\u4E0A\u7EA7");
		jb_return.setIcon(new ImageIcon(BookBack.class.getResource("/icon/Reset.png")));
		jb_return.setForeground(new Color(0, 191, 255));
		jb_return.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_return.setBounds(565, 552, 172, 43);
		contentPane.add(jb_return);
		
		JLabel label_7 = new JLabel("\u5E94\u7F34\u7F5A\u6B3E");
		label_7.setIcon(new ImageIcon(BookBack.class.getResource("/icon/price.png")));
		label_7.setForeground(new Color(0, 191, 255));
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(111, 449, 116, 43);
		contentPane.add(label_7);
		
		moneyTxt = new JTextField();
		moneyTxt.setEditable(false);
		moneyTxt.setForeground(Color.RED);
		moneyTxt.setFont(new Font("宋体", Font.BOLD, 16));
		moneyTxt.setColumns(10);
		moneyTxt.setBounds(240, 454, 144, 35);
		contentPane.add(moneyTxt);
		
		JLabel lblNewLabel = new JLabel("\u5143");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(398, 462, 72, 18);
		contentPane.add(lblNewLabel);
	}
}
