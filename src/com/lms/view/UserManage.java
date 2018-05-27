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


public class UserManage extends JFrame {

	private JPanel contentPane;
	private JTextField s_nameTxt;
	private JTable readerTable;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField nameTxt;
	private JTextField genderTxt;
	private JTextField ageTxt;
	private JTextField jobTxt;
	private JButton jb_add;
	private JButton jb_modify;
	private JButton jb_delete;
	private JTextField bookNumTxt;
	private JLabel label_5;
	private JTextField idTxt;
	private JButton jb_reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManage frame = new UserManage();
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
	public UserManage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserManage.class.getResource("/icon/allfix.png")));
		setTitle("\u8BFB\u8005\u4FE1\u606F\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		setLocation(450, 200);
		setResizable(false);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(UserManage.class.getResource("/icon/name.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 64, 90, 43);
		contentPane.add(lblNewLabel);
		
		s_nameTxt = new JTextField();
		s_nameTxt.setBounds(263, 65, 441, 42);
		contentPane.add(s_nameTxt);
		s_nameTxt.setColumns(10);
		
		JButton s_jb_Search = new JButton("\u641C\u7D22");
		s_jb_Search.setForeground(new Color(0, 191, 255));
		s_jb_Search.setIcon(new ImageIcon(UserManage.class.getResource("/icon/search (2).png")));
		s_jb_Search.setFont(new Font("宋体", Font.PLAIN, 20));
		s_jb_Search.setBounds(751, 64, 123, 43);
		contentPane.add(s_jb_Search);
		
		readerTable = new JTable();
		readerTable.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		readerTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u804C\u4E1A", "\u501F\u4E66\u91CF"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		readerTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		readerTable.setRowHeight(30);
		readerTable.setFont(new Font("宋体", Font.PLAIN, 20));
		readerTable.setBounds(15, 139, 973, 164);
		contentPane.add(readerTable);
		
		label_5 = new JLabel("\u7F16\u53F7");
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setIcon(new ImageIcon(UserManage.class.getResource("/icon/num.png")));
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(25, 337, 90, 43);
		contentPane.add(label_5);
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		idTxt.setBounds(126, 345, 172, 35);
		contentPane.add(idTxt);
		
		label = new JLabel("\u59D3\u540D");
		label.setForeground(new Color(0, 191, 255));
		label.setIcon(new ImageIcon(UserManage.class.getResource("/icon/name.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(337, 337, 80, 43);
		contentPane.add(label);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(428, 345, 172, 35);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		label_1 = new JLabel("\u6027\u522B");
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setIcon(new ImageIcon(UserManage.class.getResource("/icon/gender-male.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(649, 335, 99, 43);
		contentPane.add(label_1);
		
		genderTxt = new JTextField();
		genderTxt.setColumns(10);
		genderTxt.setBounds(787, 345, 172, 35);
		contentPane.add(genderTxt);
		
		label_2 = new JLabel("\u5E74\u9F84");
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setIcon(new ImageIcon(UserManage.class.getResource("/icon/author (1).png")));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(25, 433, 90, 43);
		contentPane.add(label_2);
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		ageTxt.setBounds(126, 437, 172, 35);
		contentPane.add(ageTxt);
		
		label_3 = new JLabel("\u804C\u4E1A");
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setIcon(new ImageIcon(UserManage.class.getResource("/icon/job.png")));
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(337, 433, 80, 43);
		contentPane.add(label_3);
		
		jobTxt = new JTextField();
		jobTxt.setColumns(10);
		jobTxt.setBounds(428, 437, 172, 35);
		contentPane.add(jobTxt);
		
		label_4 = new JLabel("\u501F\u4E66\u91CF");
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setIcon(new ImageIcon(UserManage.class.getResource("/icon/question-mark-o.png")));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(649, 429, 116, 43);
		contentPane.add(label_4);
		
		bookNumTxt = new JTextField();
		bookNumTxt.setColumns(10);
		bookNumTxt.setBounds(787, 437, 172, 35);
		contentPane.add(bookNumTxt);
		
		jb_add = new JButton("\u589E\u52A0");
		jb_add.setForeground(new Color(0, 191, 255));
		jb_add.setIcon(new ImageIcon(UserManage.class.getResource("/icon/add.png")));
		jb_add.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_add.setBounds(135, 530, 123, 43);
		contentPane.add(jb_add);
		
		jb_modify = new JButton("\u4FEE\u6539");
		jb_modify.setForeground(new Color(0, 191, 255));
		jb_modify.setIcon(new ImageIcon(UserManage.class.getResource("/icon/allfix.png")));
		jb_modify.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_modify.setBounds(317, 530, 123, 43);
		contentPane.add(jb_modify);
		
		jb_delete = new JButton("\u5220\u9664");
		jb_delete.setForeground(new Color(0, 191, 255));
		jb_delete.setIcon(new ImageIcon(UserManage.class.getResource("/icon/del.png")));
		jb_delete.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_delete.setBounds(516, 530, 123, 43);
		contentPane.add(jb_delete);
		
		jb_reset = new JButton("\u91CD\u7F6E");
		jb_reset.setForeground(new Color(0, 191, 255));
		jb_reset.setIcon(new ImageIcon(UserManage.class.getResource("/icon/Reset.png")));
		jb_reset.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_reset.setBounds(721, 530, 123, 43);
		contentPane.add(jb_reset);

	}
}
