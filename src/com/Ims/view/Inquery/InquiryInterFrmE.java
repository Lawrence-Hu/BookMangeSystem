package com.Ims.view.Inquery;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class InquiryInterFrmE extends JInternalFrame {
	private JTextField InNameTxt;
	private JTextField InBookNameTxt;
	private JTextField BackTime;

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
	public InquiryInterFrmE() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setTitle("\u67E5\u8BE2\u67D0\u5B66\u751F\u5F52\u8FD8\u67D0\u4E66\u7684\u65E5\u671F");
		setFrameIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/5.png")));
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 647, 335);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/name.png")));
		lblNewLabel.setBounds(54, 15, 81, 36);
		getContentPane().add(lblNewLabel);
		
		InNameTxt = new JTextField();
		InNameTxt.setBounds(150, 20, 264, 31);
		getContentPane().add(InNameTxt);
		InNameTxt.setColumns(10);
		
		InBookNameTxt = new JTextField();
		InBookNameTxt.setColumns(10);
		InBookNameTxt.setBounds(150, 69, 264, 31);
		getContentPane().add(InBookNameTxt);
		
		JLabel label = new JLabel("\u4E66\u540D");
		label.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/book (3).png")));
		label.setBounds(54, 64, 81, 36);
		getContentPane().add(label);
		
		JButton jb_Search = new JButton("\u67E5\u8BE2");
		jb_Search.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/search (2).png")));
		jb_Search.setBounds(467, 41, 123, 36);
		getContentPane().add(jb_Search);
		
		JLabel label_1 = new JLabel("\u8FD8\u4E66\u65E5\u671F");
		label_1.setIcon(new ImageIcon(InquiryInterFrmE.class.getResource("/icon/time.png")));
		label_1.setBounds(65, 176, 129, 36);
		getContentPane().add(label_1);
		
		BackTime = new JTextField();
		BackTime.setEditable(false);
		BackTime.setBounds(234, 176, 237, 36);
		getContentPane().add(BackTime);
		BackTime.setColumns(10);
	}

}
