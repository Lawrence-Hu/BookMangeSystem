package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.lms.Dbutil.Dbutil;
import com.lms.dao.BookManageDao;
import com.lms.model.Book;
import com.lms.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


public class BookManage extends JFrame {

	private JPanel contentPane;
	private JTextField SearchTxt;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField bnameTxt;
	private JTextField PublishNameTxt;
	private JTextField AuthorNameTxt;
	private JTextField PriceTxt;
	private JButton jb_add;
	private JButton jb_fix;
	private JButton jb_del;
	private JTextField YorNTxt;
	private JLabel label_5;
	private JTextField Bno;
	private JButton jb_reset;
	private JScrollPane scrollPane;
	private JTable bookTable;
	Dbutil dbutil = new Dbutil();
	BookManageDao bmd = new BookManageDao();
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
		setResizable(false);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookManage.class.getResource("/icon/allfix.png")));
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		setLocation(450, 200);
		contentPane = new JPanel();		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u53F7");
		lblNewLabel.setBounds(168, 64, 90, 43);
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(BookManage.class.getResource("/icon/name.png")));
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		SearchTxt = new JTextField();
		SearchTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int keyChar=arg0.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
					
				} else {
					arg0.consume();  
				}
			}
		});
		SearchTxt.setBounds(263, 65, 441, 42);
		contentPane.add(SearchTxt);
		SearchTxt.setColumns(10);
		
		JButton jb_Search = new JButton("\u641C\u7D22");
		jb_Search.setBackground(Color.WHITE);
		jb_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SearchTxt.getText().equals(null)||SearchTxt.getText().equals("")) {
					Filltable();
				}
				else {
				String bnoString = new String(SearchTxt.getText());
				int num=Integer.valueOf(bnoString);
				Book book = new Book();
				book.setBno(num);
				Filltable(book);
			}
			}
		});
		jb_Search.setFocusPainted(false);
		jb_Search.setBorderPainted(false);
		jb_Search.setBounds(751, 64, 123, 43);
		jb_Search.setForeground(new Color(0, 191, 255));
		jb_Search.setIcon(new ImageIcon(BookManage.class.getResource("/icon/search (2).png")));
		jb_Search.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(jb_Search);
		
		label = new JLabel("\u4E66\u540D");
		label.setBounds(337, 337, 80, 43);
		label.setForeground(new Color(0, 191, 255));
		label.setIcon(new ImageIcon(BookManage.class.getResource("/icon/name.png")));
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label);
		
		label_1 = new JLabel("\u51FA\u7248\u793E");
		label_1.setBounds(649, 335, 99, 43);
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setIcon(new ImageIcon(BookManage.class.getResource("/icon/publishSystem.png")));
		label_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u4F5C\u8005");
		label_2.setBounds(25, 433, 90, 43);
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setIcon(new ImageIcon(BookManage.class.getResource("/icon/author (1).png")));
		label_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u4EF7\u683C");
		label_3.setBounds(337, 433, 80, 43);
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setIcon(new ImageIcon(BookManage.class.getResource("/icon/price.png")));
		label_3.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label_3);
		
		label_4 = new JLabel("\u662F\u5426\u501F\u51FA");
		label_4.setBounds(649, 429, 116, 43);
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setIcon(new ImageIcon(BookManage.class.getResource("/icon/question-mark-o.png")));
		label_4.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label_4);
		
		bnameTxt = new JTextField();
		bnameTxt.setBounds(428, 345, 172, 35);
		contentPane.add(bnameTxt);
		bnameTxt.setColumns(10);
		
		PublishNameTxt = new JTextField();
		PublishNameTxt.setBounds(787, 345, 172, 35);
		PublishNameTxt.setColumns(10);
		contentPane.add(PublishNameTxt);
		
		AuthorNameTxt = new JTextField();
		AuthorNameTxt.setBounds(126, 437, 172, 35);
		AuthorNameTxt.setColumns(10);
		contentPane.add(AuthorNameTxt);
		
		PriceTxt = new JTextField();
		
		PriceTxt.setBounds(428, 437, 172, 35);
		PriceTxt.setColumns(10);
		contentPane.add(PriceTxt);
		
		jb_add = new JButton("\u589E\u52A0");
		jb_add.setBackground(Color.WHITE);
		jb_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String bname = new String(bnameTxt.getText());	
				if(StringUtil.isEmpty(bname)) {
					JOptionPane.showMessageDialog(null, "请输入书名！");
					return;
				}
				Float price;
				if(!isNumber(PriceTxt.getText()) ||StringUtil.isEmpty(PriceTxt.getText())) {
					JOptionPane.showMessageDialog(null, "请输入正确的价格！");
					return;
				}else {
					price = new Float(PriceTxt.getText());
				}
				String author =  new String(AuthorNameTxt.getText());
				if(StringUtil.isEmpty(author)) {
					JOptionPane.showMessageDialog(null, "请输入作者名！");
					return;
				}
				String publish =  new String(PublishNameTxt.getText());
				if(StringUtil.isEmpty(publish)) {
					JOptionPane.showMessageDialog(null, "请输入出版社！");
					return;
				}
				String yesornot = "否";
				Book book = new Book(bname, publish, author, price, yesornot);
				Connection connection = null;
				try {
					connection = dbutil.getcon();
					bmd.Add(connection, book);
					JOptionPane.showMessageDialog(null, "增加图书成功！");
					Filltable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "增加图书失败！");	
					e1.printStackTrace();
				}finally{
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_add.setFocusPainted(false);
		jb_add.setBorderPainted(false);
		jb_add.setBounds(135, 530, 123, 43);
		jb_add.setForeground(new Color(0, 191, 255));
		jb_add.setIcon(new ImageIcon(BookManage.class.getResource("/icon/add.png")));
		jb_add.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(jb_add);
		
		jb_fix = new JButton("\u4FEE\u6539");
		jb_fix.setBackground(Color.WHITE);
		jb_fix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer bno = new Integer(Bno.getText());	
					String bname = new String(bnameTxt.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请检查输入的书号或书名是否输入正确！");
					return;
				}
				Float price;
				if(!isNumber(PriceTxt.getText()) ||StringUtil.isEmpty(PriceTxt.getText())) {
					JOptionPane.showMessageDialog(null, "请输入正确的价格！");
					return;
				}else {
					price = new Float(PriceTxt.getText());
				}		
				String author =  new String(AuthorNameTxt.getText());
				if(StringUtil.isEmpty(author)) {
					JOptionPane.showMessageDialog(null, "请输入作者名！");
					return;
				}				
				String publish =  new String(PublishNameTxt.getText());
				if(StringUtil.isEmpty(publish)) {
					JOptionPane.showMessageDialog(null, "请输入出版社！");
					return;
				}
				Integer bno = new Integer(Bno.getText());	
				String bname = new String(bnameTxt.getText());
				Book book = new Book(bno,bname, publish, author, price);
				Connection connection = null;				
				try {
					connection = dbutil.getcon();
					bmd.Update(connection, book);
					JOptionPane.showMessageDialog(null, "修改图书成功！");
					Filltable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "修改图书失败！");
					e1.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_fix.setFocusPainted(false);
		jb_fix.setBorderPainted(false);
		jb_fix.setBounds(317, 530, 123, 43);
		jb_fix.setForeground(new Color(0, 191, 255));
		jb_fix.setIcon(new ImageIcon(BookManage.class.getResource("/icon/allfix.png")));
		jb_fix.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(jb_fix);
		
		jb_del = new JButton("\u5220\u9664");
		jb_del.setBackground(Color.WHITE);
		jb_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Bno.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请选择要删除的书本！");
					return;
				}
				Integer bno = new Integer(Bno.getText());	
				Connection connection = null;
				try {
					connection = dbutil.getcon();
					if(bmd.isNotBack(connection, bno)) {
						JOptionPane.showMessageDialog(null, "该书还未换不能删除！");
						return;
					}
					else {
					bmd.Delete(connection,bno);
					JOptionPane.showMessageDialog(null, "删除成功！");
					Filltable();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {	
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_del.setFocusPainted(false);
		jb_del.setBorderPainted(false);
		jb_del.setBounds(516, 530, 123, 43);
		jb_del.setForeground(new Color(0, 191, 255));
		jb_del.setIcon(new ImageIcon(BookManage.class.getResource("/icon/del.png")));
		jb_del.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(jb_del);
		
		YorNTxt = new JTextField();
		YorNTxt.setBackground(Color.WHITE);
		YorNTxt.setEditable(false);
		YorNTxt.setBounds(787, 437, 172, 35);
		YorNTxt.setColumns(10);
		contentPane.add(YorNTxt);
		
		label_5 = new JLabel("\u7F16\u53F7");
		label_5.setBounds(25, 337, 90, 43);
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setIcon(new ImageIcon(BookManage.class.getResource("/icon/num.png")));
		label_5.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(label_5);
		
		Bno = new JTextField();
		Bno.setBackground(Color.WHITE);
		Bno.setEditable(false);
		Bno.setBounds(126, 345, 172, 35);
		Bno.setColumns(10);
		contentPane.add(Bno);
		
		jb_reset = new JButton("\u91CD\u7F6E");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchTxt.setText("");
				bnameTxt.setText("");
				Bno.setText("");
				PriceTxt.setText("");
				PublishNameTxt.setText("");
				AuthorNameTxt.setText("");
				YorNTxt.setText("");
			}
		});
		jb_reset.setFocusPainted(false);
		jb_reset.setBorderPainted(false);
		jb_reset.setBackground(Color.WHITE);
		jb_reset.setBounds(721, 530, 123, 43);
		jb_reset.setForeground(new Color(0, 191, 255));
		jb_reset.setIcon(new ImageIcon(BookManage.class.getResource("/icon/Reset.png")));
		jb_reset.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		contentPane.add(jb_reset);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 121, 973, 192);
		scrollPane.getViewport().setBackground(Color.white);
		contentPane.add(scrollPane);
		
		bookTable = new JTable();
		bookTable.setFont(new Font("宋体", Font.PLAIN, 20));
		bookTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r= bookTable.getSelectedRow();
				Bno.setText(bookTable.getValueAt(r, 0).toString());
				bnameTxt.setText(bookTable.getValueAt(r, 1).toString());
				PublishNameTxt.setText(bookTable.getValueAt(r, 2).toString());
				AuthorNameTxt.setText(bookTable.getValueAt(r, 3).toString());
				PriceTxt.setText(bookTable.getValueAt(r, 4).toString());
				YorNTxt.setText(bookTable.getValueAt(r, 5).toString());
		}
		});
		bookTable.setBackground(Color.WHITE);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u662F\u5426\u501F\u51FA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getTableHeader().setFont(new Font("Dialog", 0, 19));
		bookTable.getTableHeader().setBackground(Color.white);
		bookTable.setRowHeight(30);
		scrollPane.setViewportView(bookTable);
	}
	
	public void Filltable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs = bmd.Search(connection, book);
			ResultSet rs1 = bmd.Search(connection, book);
			if(rs.next()) {
			while (rs1.next()) {
					Vector v = new Vector();
					v.add(rs.getInt("bno"));
					v.add(rs.getString("bname"));
					v.add(rs.getString("publish"));
					v.add(rs.getString("author"));
					v.add(rs.getFloat("price"));
					v.add(rs.getString("ishere"));
					dtm.addRow(v);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "无该图书！");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	}
	public void Filltable() {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs = bmd.SearchAll(connection);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("bno"));
				v.add(rs.getString("bname"));
				v.add(rs.getString("publish"));
				v.add(rs.getString("author"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("ishere"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	}
	
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public  boolean isNumber(String str){  
        String reg = "[0-9]+(.[0-9]+)?";  
        return str.matches(reg);  
    }
	
}