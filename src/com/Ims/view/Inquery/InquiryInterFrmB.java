package com.Ims.view.Inquery;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.lms.Dbutil.Dbutil;
import com.lms.dao.InquriyDao;
import javax.swing.JScrollPane;

public class InquiryInterFrmB extends JInternalFrame {
	Dbutil dbutil = new Dbutil();
	InquriyDao id = new  InquriyDao();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InquiryInterFrmB frame = new InquiryInterFrmB();
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
	public InquiryInterFrmB() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setFrameIcon(new ImageIcon(InquiryInterFrmB.class.getResource("/icon/2 (1).png")));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u5DF2\u88AB\u501F\u51FA\u7684\u4E66\u672C");
		setBounds(0, 0, 1019, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmA.class.getResource("/icon/result.png")));
		lblNewLabel.setBounds(28, 2, 148, 34);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 46, 615, 175);
		scrollPane.getViewport().setBackground(Color.white);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C", "\u662F\u5426\u501F\u51FA"
			}
		));
		table.getTableHeader().setFont(new Font("Dialog", 0, 19));
		table.getTableHeader().setBackground(Color.white);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		Filltable();
	}
	public void Filltable() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection connection =null;
		try {
			connection = dbutil.getcon();
			ResultSet rs = id.InquityB(connection);
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
