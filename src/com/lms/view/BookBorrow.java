package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class BookBorrow extends JFrame {

	private JPanel contentPane;
	private JTextField BookNumTxt;
	private JTable table;
	private JTextField UserNum;
	private JTextField Time;
	private JTextField BookNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookBorrow frame = new BookBorrow();
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
	public BookBorrow() {
		setResizable(false);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookBorrow.class.getResource("/icon/book.png")));
		setTitle("\u501F\u4E66");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1003, 630);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u4E66\u53F7");
		label.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/book.png")));
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(126, 64, 132, 43);
		panel.add(label);
		
		BookNumTxt = new JTextField();
		BookNumTxt.setColumns(10);
		BookNumTxt.setBounds(263, 65, 441, 42);
		panel.add(BookNumTxt);
		
		JButton button = new JButton("\u641C\u7D22");
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/search (2).png")));
		button.setForeground(new Color(0, 191, 255));
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(751, 64, 123, 43);
		panel.add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"\u7F16\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u662F\u5426\u501F\u51FA"},
				},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowHeight(30);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		table.setBounds(15, 139, 973, 164);
		panel.add(table);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		label_1.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/num.png")));
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(285, 335, 123, 43);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u501F\u9605\u65F6\u95F4");
		label_2.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/time.png")));
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(620, 335, 132, 43);
		panel.add(label_2);
		
		UserNum = new JTextField();
		UserNum.setColumns(10);
		UserNum.setBounds(423, 339, 172, 35);
		panel.add(UserNum);
		
		Time = new JTextField();
		Time.setColumns(10);
		Time.setBounds(767, 339, 172, 35);
		panel.add(Time);
		
		JButton jb_Comfirm = new JButton("\u786E\u5B9A");
		jb_Comfirm.setBackground(Color.WHITE);
		jb_Comfirm.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/confirm (2).png")));
		jb_Comfirm.setForeground(new Color(0, 191, 255));
		jb_Comfirm.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_Comfirm.setBounds(279, 516, 139, 43);
		panel.add(jb_Comfirm);
		
		JLabel label_6 = new JLabel("\u4E66\u53F7");
		label_6.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/name.png")));
		label_6.setForeground(new Color(0, 191, 255));
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(25, 337, 90, 43);
		panel.add(label_6);
		
		BookNum = new JTextField();
		BookNum.setBackground(Color.WHITE);
		BookNum.setEditable(false);
		BookNum.setColumns(10);
		BookNum.setBounds(106, 339, 172, 35);
		panel.add(BookNum);
		
		JButton jb_Cancel = new JButton("\u53D6\u6D88");
		jb_Cancel.setBackground(Color.WHITE);
		jb_Cancel.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/cancel.png")));
		jb_Cancel.setForeground(new Color(0, 191, 255));
		jb_Cancel.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_Cancel.setBounds(582, 516, 139, 43);
		panel.add(jb_Cancel);
	}

}
