package com.Ims.view.Inquery;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.lms.Dbutil.Dbutil;
import com.lms.dao.InquriyDao;
import com.lms.model.Book;
import com.lms.view.BookBorrow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InquiryInterFrmC extends JInternalFrame {
	private JTextField InPublishTxt;
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
	public InquiryInterFrmC() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setFrameIcon(new ImageIcon(InquiryInterFrmC.class.getResource("/icon/3 (1).png")));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u67D0\u51FA\u7248\u793E\u51FA\u7248\u7684\u4E66");
		setBounds(0, 0, 1019, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmA.class.getResource("/icon/result.png")));
		lblNewLabel.setBounds(0, 67, 148, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u51FA\u7248\u793E");
		label.setIcon(new ImageIcon(InquiryInterFrmC.class.getResource("/icon/publishSystem.png")));
		label.setBounds(15, 15, 114, 37);
		getContentPane().add(label);
		
		InPublishTxt = new JTextField();
		InPublishTxt.setBounds(132, 15, 241, 37);
		getContentPane().add(InPublishTxt);
		InPublishTxt.setColumns(10);
		
		JButton jb_Search = new JButton("\u67E5\u8BE2");
		jb_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String  publish  = new  String(InPublishTxt.getText());
				Book book = new  Book();
				book.setPublish(publish);
				Filltable(book);
				
			}
		});
		jb_Search.setIcon(new ImageIcon(InquiryInterFrmC.class.getResource("/icon/search (2).png")));
		jb_Search.setBounds(403, 15, 129, 37);
		getContentPane().add(jb_Search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 620, 168);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C"
			}
		));
		scrollPane.setViewportView(table);

	}
	public void Filltable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs1 = id.InquityC(connection,book);
			if(rs1.next()) {
				ResultSet rs = id.InquityC(connection,book);	
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
			else {
				JOptionPane.showMessageDialog(null, "该出版社无任何书籍！");
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
