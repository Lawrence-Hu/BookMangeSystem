package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.lms.Dbutil.Dbutil;
import com.lms.dao.BookManageDao;
import com.lms.dao.BorrowDao;
import com.lms.model.Book;
import com.lms.model.User;
import com.lms.util.JDateChooser;
import com.lms.util.StringUtil;
import com.lms.util.isDate;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookBorrow extends JFrame {

	private JPanel contentPane;
	private JTextField Search_bno_Txt;
	private JTextField User_no_Txt;
	private JTextField bTime_Txt;
	private JTextField B_no_Txt;
	private JTable table;
	Dbutil dbutil = new Dbutil();
	BookManageDao bmd = new BookManageDao();
	BorrowDao bb = new BorrowDao();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
		setLocation(450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("\u4E66\u53F7");
		label.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/book.png")));
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(143, 85, 132, 43);
		contentPane.add(label);
		
		Search_bno_Txt = new JTextField();
		Search_bno_Txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int keyChar=arg0.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
					
				} else {
					arg0.consume();  
				}
			}
		});
		Search_bno_Txt.setColumns(10);
		Search_bno_Txt.setBounds(280, 86, 441, 42);
		contentPane.add(Search_bno_Txt);
		
		JButton jb_search = new JButton("\u641C\u7D22");
		jb_search.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/search (2).png")));
		jb_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bnoString = new String(Search_bno_Txt.getText());
				if(StringUtil.isEmpty(bnoString)) {
					JOptionPane.showMessageDialog(null, "请输入书号！");
					return;
				}
				else {
					int num=Integer.valueOf(bnoString);
					Book book = new Book();
					book.setBno(num);
					Connection conn =null;
					try {
						conn = dbutil.getcon();
						if(!bmd.islive(conn, book.getBno())) {
							JOptionPane.showMessageDialog(null, "无该图书");
							return;
							}
						else {
							Filltable(book);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		jb_search.setFocusPainted(false);
		jb_search.setBorderPainted(false);
		jb_search.setForeground(new Color(0, 191, 255));
		jb_search.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_search.setBackground(Color.WHITE);
		jb_search.setBounds(768, 85, 123, 43);
		contentPane.add(jb_search);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(302, 356, 123, 43);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u501F\u9605\u65F6\u95F4");
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(599, 356, 132, 43);
		contentPane.add(label_2);
		
		User_no_Txt = new JTextField();
		User_no_Txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int keyChar=arg0.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
					
				} else {
					arg0.consume();  
				}
			}
		});
		User_no_Txt.setColumns(10);
		User_no_Txt.setBounds(403, 360, 172, 35);
		contentPane.add(User_no_Txt);
		
		bTime_Txt = new JTextField();
		bTime_Txt.setColumns(10);
		bTime_Txt.setBounds(718, 360, 172, 35);
		contentPane.add(bTime_Txt);
		
		JButton jb_Comfirm = new JButton("\u786E\u5B9A");
		jb_Comfirm.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/trues-active.png")));
		jb_Comfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				try {
					connection = dbutil.getcon();
					Integer id = new Integer(User_no_Txt.getText());
					Integer bno = new Integer(B_no_Txt.getText());
					String bdate = bTime_Txt.getText();
					Date date = df.parse(bdate);
					Book book =new Book();
					book.setBno(bno);
					if(bb.isExisUser(connection, id)){
						if(!bb.isOut(connection, bno)) {
							if(!bb.OverLimit(connection, id)) {
								bb.Borrow(connection, bno, id, bdate);
								bb.Update(connection, bno);
								JOptionPane.showMessageDialog(null, "借书成功！");
								Filltable(book);
								}
							else {
								JOptionPane.showMessageDialog(null, "您已借了5本未还，不能借书");
								return;
							}
						}  
						else {
							JOptionPane.showMessageDialog(null, "该书已借出,借书失败！");
							return;
						}
					}
				  else {
					  JOptionPane.showMessageDialog(null, "无该用户 借书失败！");
					  return;
				  }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "借书失败请检查输入信息是否为空或有错！");
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
		jb_Comfirm.setFocusPainted(false);
		jb_Comfirm.setBorderPainted(false);
		jb_Comfirm.setForeground(new Color(0, 191, 255));
		jb_Comfirm.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_Comfirm.setBackground(Color.WHITE);
		jb_Comfirm.setBounds(296, 537, 139, 43);
		contentPane.add(jb_Comfirm);
		
		JLabel label_3 = new JLabel("\u4E66\u53F7");
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(42, 358, 90, 43);
		contentPane.add(label_3);
		
		B_no_Txt = new JTextField();
		B_no_Txt.setEditable(false);
		B_no_Txt.setColumns(10);
		B_no_Txt.setBackground(Color.WHITE);
		B_no_Txt.setBounds(123, 360, 172, 35);
		contentPane.add(B_no_Txt);
		
		JButton jb_Cancel = new JButton("\u53D6\u6D88");
		jb_Cancel.setIcon(new ImageIcon(BookBorrow.class.getResource("/icon/Reset.png")));
		jb_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookBorrow.this.dispose();
			}
		});
		jb_Cancel.setFocusPainted(false);
		jb_Cancel.setBorderPainted(false);
		jb_Cancel.setForeground(new Color(0, 191, 255));
		jb_Cancel.setFont(new Font("宋体", Font.PLAIN, 20));
		jb_Cancel.setBackground(Color.WHITE);
		jb_Cancel.setBounds(599, 537, 139, 43);
		contentPane.add(jb_Cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 149, 973, 192);
		scrollPane.getViewport().setBackground(Color.white);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r= table.getSelectedRow();
				bTime_Txt.setText(df.format(new Date()));
				B_no_Txt.setText(table.getValueAt(r, 0).toString());
		}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u662F\u5426\u501F\u51FA"
			}
		));
		table.getTableHeader().setFont(new Font("Dialog", 0, 19));
		table.getTableHeader().setBackground(Color.white);
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
	}
	public void Filltable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs = bmd.Search(connection, book);
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
}
