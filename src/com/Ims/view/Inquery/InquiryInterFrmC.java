package com.Ims.view.Inquery;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InquiryInterFrmC extends JInternalFrame {
	private JTable table;
	private JTextField InPublishTxt;

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
		setBounds(100, 100, 647, 335);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(8, 101, 631, 184);
		table.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		table.setRowHeight(30);
		table.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u7F16\u53F7", "\u4E66\u540D", "\u51FA\u7248\u793E", "\u4F5C\u8005", "\u4EF7\u683C"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(143);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
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
		jb_Search.setIcon(new ImageIcon(InquiryInterFrmC.class.getResource("/icon/search (2).png")));
		jb_Search.setBounds(403, 15, 129, 37);
		getContentPane().add(jb_Search);

	}
}
