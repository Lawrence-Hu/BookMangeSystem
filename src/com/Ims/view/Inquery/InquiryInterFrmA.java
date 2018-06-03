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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JScrollPane;

public class InquiryInterFrmA extends JInternalFrame {
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
	public InquiryInterFrmA() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setFrameIcon(new ImageIcon(InquiryInterFrmA.class.getResource("/icon/1.png")));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u8D85\u671F\u7684\u501F\u4E66\u8BB0\u5F55");
		setBounds(0, 0, 1019, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmA.class.getResource("/icon/result.png")));
		lblNewLabel.setBounds(28, 2, 148, 34);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 39, 986, 198);
		scrollPane.getViewport().setBackground(Color.white);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u8D85\u671F(\u5929\uFF09"
			}
		));
		table.getTableHeader().setFont(new Font("Dialog", 0, 19));
		table.getTableHeader().setBackground(Color.white);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		Filltable();
		
	}
	public void Filltable() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String rdate = df.format(new Date());
		try {
			connection = dbutil.getcon();
			ResultSet rs1 = id.InquityA(connection, rdate);
			if(rs1.next()) {
				ResultSet rs = id.InquityA(connection, rdate);
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getInt("bno"));
					v.add(rs.getString("bname"));
					v.add(rs.getString("publish"));
					v.add(rs.getString("author"));
					v.add(rs.getFloat("price"));
					v.add(rs.getString("day"));
					dtm.addRow(v);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "无超期书籍！");
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
