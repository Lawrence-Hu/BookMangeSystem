package com.lms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Ims.view.Inquery.InquiryInterFrmA;
import com.Ims.view.Inquery.InquiryInterFrmB;
import com.Ims.view.Inquery.InquiryInterFrmC;
import com.Ims.view.Inquery.InquiryInterFrmD;
import com.Ims.view.Inquery.InquiryInterFrmE;
import com.Ims.view.Inquery.InquiryInterFrmF;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class Inquiry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inquiry frame = new Inquiry();
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
	public Inquiry() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("\u67E5\u8BE2\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inquiry.class.getResource("/icon/search.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		setLocation(450, 200);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u67E5\u8BE2           ");
		menu.setBackground(Color.WHITE);
		menu.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/search (2).png")));
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(menu);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1019, 612);
		
		
		JMenuItem Ia = new JMenuItem("\u67E5\u8BE2\u8D85\u671F\u9650\u7684\u501F\u4E66\u8BB0\u5F55");
		Ia.setBackground(Color.WHITE);
		Ia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryInterFrmA inquiryInterFrmA = new InquiryInterFrmA();
				inquiryInterFrmA.setVisible(true);
				desktopPane.add(inquiryInterFrmA);
			}
		});
		Ia.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		Ia.setForeground(new Color(0, 191, 255));
		Ia.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/1.png")));
		menu.add(Ia);
		
		JMenuItem Ib = new JMenuItem("\u67E5\u8BE2\u5DF2\u88AB\u501F\u51FA\u7684\u4E66\u672C");
		Ib.setBackground(Color.WHITE);
		Ib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InquiryInterFrmB inquiryInterFrmB = new InquiryInterFrmB();
				inquiryInterFrmB.setVisible(true);
				desktopPane.add(inquiryInterFrmB);
			}
		});
		Ib.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		Ib.setForeground(new Color(0, 191, 255));
		Ib.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/2 (1).png")));
		menu.add(Ib);
		
		JMenuItem Ic = new JMenuItem("\u67E5\u8BE2\u67D0\u51FA\u7248\u793E\u51FA\u7248\u7684\u4E66");
		Ic.setBackground(Color.WHITE);
		Ic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryInterFrmC inquiryInterFrmC = new InquiryInterFrmC();
				inquiryInterFrmC.setVisible(true);
				desktopPane.add(inquiryInterFrmC);
			}
		});
		Ic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		Ic.setForeground(new Color(0, 191, 255));
		Ic.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/3 (1).png")));
		menu.add(Ic);
		
		JMenuItem Id = new JMenuItem("\u67E5\u8BE2\u67D0\u4EBA\u501F\u4E86\u4EC0\u4E48\u4E66");
		Id.setBackground(Color.WHITE);
		Id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryInterFrmD inquiryInterFrmD = new InquiryInterFrmD();
				inquiryInterFrmD.setVisible(true);
				desktopPane.add(inquiryInterFrmD);
			}
			
		});
		Id.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		Id.setForeground(new Color(0, 191, 255));
		Id.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/4.png")));
		menu.add(Id);
		
		JMenuItem Ie = new JMenuItem("\u67E5\u8BE2\u67D0\u5B66\u751F\u5F52\u8FD8\u67D0\u672C\u4E66\u7684\u65E5\u671F");
		Ie.setBackground(Color.WHITE);
		Ie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryInterFrmE inquiryInterFrmE = new InquiryInterFrmE();
				inquiryInterFrmE.setVisible(true);
				desktopPane.add(inquiryInterFrmE);
			}
		});
		Ie.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		Ie.setForeground(new Color(0, 191, 255));
		Ie.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/5.png")));
		menu.add(Ie);
		
		JMenuItem If = new JMenuItem("\u67E5\u8BE2\u67D0\u540C\u5B66\u88AB\u7F5A\u6B3E\u7684\u603B\u989D");
		If.setBackground(Color.WHITE);
		If.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryInterFrmF inquiryInterFrmF = new InquiryInterFrmF();
				inquiryInterFrmF.setVisible(true);
				desktopPane.add(inquiryInterFrmF);
			}
		});
		If.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		If.setForeground(new Color(0, 191, 255));
		If.setIcon(new ImageIcon(Inquiry.class.getResource("/icon/6.png")));
		menu.add(If);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(desktopPane);

	}
}
