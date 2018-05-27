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

public class InquiryInterFrmA extends JInternalFrame {
	private JTable table;

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
