package com.Ims.view.Inquery;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class InquiryInterFrmF extends JInternalFrame {
	private JTextField InNameSearchTxt;
	private JTextField Money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InquiryInterFrmE frame = new InquiryInterFrmE();
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
	public InquiryInterFrmF() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setTitle("\u67E5\u8BE2\u67D0\u4EBA\u88AB\u7F5A\u6B3E\u7684\u603B\u989D");
		setFrameIcon(new ImageIcon(InquiryInterFrmF.class.getResource("/icon/6.png")));
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 647, 335);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/name.png")));
		lblNewLabel.setBounds(58, 71, 81, 36);
		getContentPane().add(lblNewLabel);
		
		InNameSearchTxt = new JTextField();
		InNameSearchTxt.setBounds(154, 72, 264, 36);
		getContentPane().add(InNameSearchTxt);
		InNameSearchTxt.setColumns(10);
		
		JButton Inquiry = new JButton("\u67E5\u8BE2");
		Inquiry.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/search (2).png")));
		Inquiry.setBounds(469, 70, 123, 36);
		getContentPane().add(Inquiry);
		
		JLabel label_1 = new JLabel("\u5E94\u8FD8\u91D1\u989D");
		label_1.setIcon(new ImageIcon(InquiryInterFrmF.class.getResource("/icon/price.png")));
		label_1.setBounds(58, 168, 129, 36);
		getContentPane().add(label_1);
		
		Money = new JTextField();
		Money.setEditable(false);
		Money.setBounds(247, 169, 237, 36);
		getContentPane().add(Money);
		Money.setColumns(10);
	}

}
