package com.Ims.view.Inquery;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class InquiryInterFrmB extends JInternalFrame {
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
		setBounds(100, 100, 647, 335);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(8, 36, 631, 197);
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
		lblNewLabel.setBounds(28, 2, 148, 34);
		getContentPane().add(lblNewLabel);

	}

}
