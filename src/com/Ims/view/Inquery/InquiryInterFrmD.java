package com.Ims.view.Inquery;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.lms.Dbutil.Dbutil;
import com.lms.dao.BookManageDao;
import com.lms.dao.InquriyDao;
import com.lms.model.Book;
import com.lms.model.User;
import com.lms.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class InquiryInterFrmD extends JInternalFrame {
	private JTextField InNameTxt;
	private JTable table;
	Dbutil dbutil = new Dbutil();
	InquriyDao id = new  InquriyDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InquiryInterFrmA frame = new InquiryInterFrmA();
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
	public InquiryInterFrmD() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setTitle("\u67E5\u8BE2\u67D0\u4EBA\u501F\u4E86\u4EC0\u4E48\u4E66");
		setFrameIcon(new ImageIcon(InquiryInterFrmD.class.getResource("/icon/4.png")));
		setClosable(true);
		setIconifiable(true);
		setBounds(0, 0, 1019, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmA.class.getResource("/icon/result.png")));
		lblNewLabel.setBounds(0, 67, 148, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setIcon(new ImageIcon(InquiryInterFrmD.class.getResource("/icon/name.png")));
		label.setBounds(15, 15, 114, 37);
		getContentPane().add(label);
		
		InNameTxt = new JTextField();
		InNameTxt.setBounds(132, 15, 241, 37);
		getContentPane().add(InNameTxt);
		InNameTxt.setColumns(10);
		
		JButton jb_Search = new JButton("\u67E5\u8BE2");
		jb_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = new String(InNameTxt.getText());
				if(StringUtil.isEmpty(name)) {
					JOptionPane.showMessageDialog(null, "输入的姓名不能为空");
				}
				else {
					User user = new User();
					user.setName(name);
					Connection conn = null;
					try {
						conn  = dbutil.getcon();
						if(id.isExisUser(conn, user)){
							Filltable(user);
						}
						else {
							JOptionPane.showMessageDialog(null, "无该用户! 查询失败");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally
					{
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				}
			}
		});
		jb_Search.setIcon(new ImageIcon(InquiryInterFrmC.class.getResource("/icon/search (2).png")));
		jb_Search.setBounds(403, 15, 129, 37);
		getContentPane().add(jb_Search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 116, 605, 169);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C"
			}
		));
		scrollPane.setViewportView(table);

	}
	public void Filltable(User user) {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs = id.InquityD(connection,user);
			ResultSet rs1 = id.InquityD(connection,user);
			if(rs1.next()) {
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getInt("bno"));
					v.add(rs.getString("bname"));
					v.add(rs.getString("publish"));
					v.add(rs.getString("author"));
					v.add(rs.getFloat("price"));
					dtm.addRow(v);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "该读者未借阅任何书本");
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
}
