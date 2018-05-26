package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;


public class BookManage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField BookNameTxt;
	private JTextField PublishNameTxt;
	private JTextField AuthorNameTxt;
	private JTextField PriceTxt;
	private JButton jb_add;
	private JButton jb_fix;
	private JButton jb_del;
	private JTextField YorNTxt;
	private JLabel label_5;
	private JTextField textField_1;
	private JButton jb_reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManage frame = new BookManage();
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
	public BookManage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookManage.class.getResource("/icon/allfix.png")));
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(BookManage.class.getResource("/icon/name.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 64, 90, 43);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(263, 65, 441, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton jb_Search = new JButton("\u641C\u7D22");
		jb_Search.setForeground(new Color(0, 191, 255));
		jb_Search.setIcon(new ImageIcon(BookManage.class.getResource("/icon/search (2).png")));
		jb_Search.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_Search.setBounds(751, 64, 123, 43);
		contentPane.add(jb_Search);
		
		table = new JTable();
		table.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u7F16\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u662F\u5426\u501F\u51FA"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.setRowHeight(30);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setBounds(15, 139, 973, 164);
		contentPane.add(table);
		
		label = new JLabel("\u4E66\u540D");
		label.setForeground(new Color(0, 191, 255));
		label.setIcon(new ImageIcon(BookManage.class.getResource("/icon/name.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(337, 337, 80, 43);
		contentPane.add(label);
		
		label_1 = new JLabel("\u51FA\u7248\u793E");
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setIcon(new ImageIcon(BookManage.class.getResource("/icon/publishSystem.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(649, 335, 99, 43);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u4F5C\u8005");
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setIcon(new ImageIcon(BookManage.class.getResource("/icon/author (1).png")));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(25, 433, 90, 43);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u4EF7\u683C");
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setIcon(new ImageIcon(BookManage.class.getResource("/icon/price.png")));
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(337, 433, 80, 43);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\u662F\u5426\u501F\u51FA");
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setIcon(new ImageIcon(BookManage.class.getResource("/icon/question-mark-o.png")));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(649, 429, 116, 43);
		contentPane.add(label_4);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setBounds(428, 345, 172, 35);
		contentPane.add(BookNameTxt);
		BookNameTxt.setColumns(10);
		
		PublishNameTxt = new JTextField();
		PublishNameTxt.setColumns(10);
		PublishNameTxt.setBounds(787, 345, 172, 35);
		contentPane.add(PublishNameTxt);
		
		AuthorNameTxt = new JTextField();
		AuthorNameTxt.setColumns(10);
		AuthorNameTxt.setBounds(126, 437, 172, 35);
		contentPane.add(AuthorNameTxt);
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		PriceTxt.setBounds(428, 437, 172, 35);
		contentPane.add(PriceTxt);
		
		jb_add = new JButton("\u589E\u52A0");
		jb_add.setForeground(new Color(0, 191, 255));
		jb_add.setIcon(new ImageIcon(BookManage.class.getResource("/icon/add.png")));
		jb_add.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_add.setBounds(135, 530, 123, 43);
		contentPane.add(jb_add);
		
		jb_fix = new JButton("\u4FEE\u6539");
		jb_fix.setForeground(new Color(0, 191, 255));
		jb_fix.setIcon(new ImageIcon(BookManage.class.getResource("/icon/allfix.png")));
		jb_fix.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_fix.setBounds(317, 530, 123, 43);
		contentPane.add(jb_fix);
		
		jb_del = new JButton("\u5220\u9664");
		jb_del.setForeground(new Color(0, 191, 255));
		jb_del.setIcon(new ImageIcon(BookManage.class.getResource("/icon/del.png")));
		jb_del.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_del.setBounds(516, 530, 123, 43);
		contentPane.add(jb_del);
		
		YorNTxt = new JTextField();
		YorNTxt.setColumns(10);
		YorNTxt.setBounds(787, 437, 172, 35);
		contentPane.add(YorNTxt);
		
		label_5 = new JLabel("\u7F16\u53F7");
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setIcon(new ImageIcon(BookManage.class.getResource("/icon/num.png")));
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(25, 337, 90, 43);
		contentPane.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 345, 172, 35);
		contentPane.add(textField_1);
		
		jb_reset = new JButton("\u91CD\u7F6E");
		jb_reset.setForeground(new Color(0, 191, 255));
		jb_reset.setIcon(new ImageIcon(BookManage.class.getResource("/icon/Reset.png")));
		jb_reset.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_reset.setBounds(721, 530, 123, 43);
		contentPane.add(jb_reset);

	}
}
