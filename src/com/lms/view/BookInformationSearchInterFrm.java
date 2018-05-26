package com.lms.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class BookInformationSearchInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInformationSearchInterFrm frame = new BookInformationSearchInterFrm();
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
	public BookInformationSearchInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
