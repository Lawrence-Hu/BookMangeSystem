package com.lms.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class UserManageInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManageInterFrm frame = new UserManageInterFrm();
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
	public UserManageInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
