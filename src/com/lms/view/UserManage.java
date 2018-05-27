package com.lms.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Box.Filler;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.lms.dao.UserDao;
import com.lms.model.User;
import com.lms.util.DbUtil;
import com.lms.util.StringUtil;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserManage extends JFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao UserDao = new UserDao();
	private JPanel contentPane;
	private JTextField s_nameTxt;
	private JTable UserTable;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField nameTxt;
	private JTextField genderTxt;
	private JTextField ageTxt;
	private JTextField jobTxt;
	private JButton jb_add;
	private JButton jb_modify;
	private JButton jb_delete;
	private JTextField bookNumTxt;
	private JLabel label_5;
	private JTextField idTxt;
	private JButton jb_reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManage frame = new UserManage();
					frame.fillTable(new User());
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
	public UserManage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserManage.class.getResource("/icon/allfix.png")));
		setTitle("\u8BFB\u8005\u4FE1\u606F\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		setLocation(450, 200);
		setResizable(false);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(168, 64, 90, 43);
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(UserManage.class.getResource("/icon/name.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		s_nameTxt = new JTextField();
		s_nameTxt.setText("\u641C\u7D22\u6846\u4E3A\u7A7A\u8FDB\u884C\u641C\u7D22\uFF0C\u8FD4\u56DE\u5168\u90E8\u4FE1\u606F");
		s_nameTxt.setForeground(Color.DARK_GRAY);
		s_nameTxt.setFont(new Font("宋体", Font.BOLD, 18));
		s_nameTxt.setBounds(263, 65, 441, 42);
		contentPane.add(s_nameTxt);
		s_nameTxt.setColumns(10);
		
		JButton s_jb_Search = new JButton("\u641C\u7D22");
		s_jb_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String UserName = s_nameTxt.getText();
				User user = new User(UserName);
				System.out.print(""+user.getName());
				UserManage.this.fillTable(user);
				
			}
		});
		s_jb_Search.setBounds(751, 64, 123, 43);
		s_jb_Search.setForeground(new Color(0, 191, 255));
		s_jb_Search.setIcon(new ImageIcon(UserManage.class.getResource("/icon/search (2).png")));
		s_jb_Search.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(s_jb_Search);
		
		label_5 = new JLabel("\u7F16\u53F7");
		label_5.setBounds(25, 337, 90, 43);
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setIcon(new ImageIcon(UserManage.class.getResource("/icon/num.png")));
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label_5);
		
		idTxt = new JTextField();
		idTxt.setText("\u9ED8\u8BA4\u503C");
		idTxt.setFont(new Font("宋体", Font.BOLD, 18));
		idTxt.setBounds(126, 345, 172, 35);
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		contentPane.add(idTxt);
		
		label = new JLabel("\u59D3\u540D");
		label.setBounds(337, 337, 80, 43);
		label.setForeground(new Color(0, 191, 255));
		label.setIcon(new ImageIcon(UserManage.class.getResource("/icon/name.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label);
		
		nameTxt = new JTextField();
		nameTxt.setForeground(Color.DARK_GRAY);
		nameTxt.setFont(new Font("宋体", Font.BOLD, 18));
		nameTxt.setBounds(428, 345, 172, 35);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		label_1 = new JLabel("\u6027\u522B");
		label_1.setBounds(649, 335, 99, 43);
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setIcon(new ImageIcon(UserManage.class.getResource("/icon/gender-male.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label_1);
		
		genderTxt = new JTextField();
		genderTxt.setForeground(Color.DARK_GRAY);
		genderTxt.setFont(new Font("宋体", Font.BOLD, 18));
		genderTxt.setBounds(787, 345, 172, 35);
		genderTxt.setColumns(10);
		contentPane.add(genderTxt);
		
		label_2 = new JLabel("\u5E74\u9F84");
		label_2.setBounds(25, 433, 90, 43);
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setIcon(new ImageIcon(UserManage.class.getResource("/icon/author (1).png")));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label_2);
		
		ageTxt = new JTextField();
		ageTxt.setForeground(Color.DARK_GRAY);
		ageTxt.setFont(new Font("宋体", Font.BOLD, 18));
		ageTxt.setBounds(126, 437, 172, 35);
		ageTxt.setColumns(10);
		contentPane.add(ageTxt);
		
		label_3 = new JLabel("\u804C\u4E1A");
		label_3.setBounds(337, 433, 80, 43);
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setIcon(new ImageIcon(UserManage.class.getResource("/icon/job.png")));
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label_3);
		
		jobTxt = new JTextField();
		jobTxt.setForeground(Color.DARK_GRAY);
		jobTxt.setFont(new Font("宋体", Font.BOLD, 18));
		jobTxt.setBounds(428, 437, 172, 35);
		jobTxt.setColumns(10);
		contentPane.add(jobTxt);
		
		label_4 = new JLabel("\u501F\u4E66\u91CF");
		label_4.setBounds(649, 429, 116, 43);
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setIcon(new ImageIcon(UserManage.class.getResource("/icon/question-mark-o.png")));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(label_4);
		
		bookNumTxt = new JTextField();
		bookNumTxt.setEditable(false);
		bookNumTxt.setForeground(Color.DARK_GRAY);
		bookNumTxt.setFont(new Font("宋体", Font.BOLD, 18));
		bookNumTxt.setBounds(787, 437, 172, 35);
		bookNumTxt.setColumns(10);
		contentPane.add(bookNumTxt);
		
		jb_add = new JButton("\u589E\u52A0");
		jb_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTxt.getText();
				String sex = genderTxt.getText();
				int age = 0;
//				System.out.print(ageTxt.getText());
				String job = jobTxt.getText();
				
				if(StringUtil.isEmpty(name)){
					JOptionPane.showMessageDialog(null, "姓名不能为空");
					return;
				}
				if(StringUtil.isEmpty(sex)){
					JOptionPane.showMessageDialog(null, "性别不能为空");
					return;
				}
				if(StringUtil.isEmpty(ageTxt.getText())){
					JOptionPane.showMessageDialog(null, "年龄不能为空");
					return;
				}else{
					age = new Integer(ageTxt.getText());
				}
				if(StringUtil.isEmpty(job)){
					JOptionPane.showMessageDialog(null, "职业不能为空");
					return;
				}
				User user = new User(name,sex,age,job);
				Connection con = null;
				try {
					con = dbUtil.getCon();
					Boolean rs = UserDao.insertUserInfo(con, user);
					if(!rs){
						JOptionPane.showMessageDialog(null, "添加成功！！");
						UserManage.this.fillTable(new User());
						UserManage.this.resetInfo();
					}else{
						JOptionPane.showMessageDialog(null,"添加失败！！");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"添加失败！！");
				}finally{
					try {
						dbUtil.closeCon(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_add.setBounds(135, 530, 123, 43);
		jb_add.setForeground(new Color(0, 191, 255));
		jb_add.setIcon(new ImageIcon(UserManage.class.getResource("/icon/add.png")));
		jb_add.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(jb_add);
		
		jb_modify = new JButton("\u4FEE\u6539");
		jb_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = new Integer(idTxt.getText());
				String name = nameTxt.getText();
				String sex = genderTxt.getText();
				int age = new Integer(ageTxt.getText());
				String job = jobTxt.getText();
				User User = new User(id,name,sex,age,job);
				Connection con = null;
				try {
					con = dbUtil.getCon();
					Boolean rs = UserDao.updateUserInfo(con, User);
					if(!rs){
						JOptionPane.showMessageDialog(null, "更新成功！！");
						UserManage.this.fillTable(new User());
						UserManage.this.resetInfo();
					}else{
						JOptionPane.showMessageDialog(null,"更新失败！！");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"更新失败！！");
				}finally{
					try {
						dbUtil.closeCon(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_modify.setBounds(317, 530, 123, 43);
		jb_modify.setForeground(new Color(0, 191, 255));
		jb_modify.setIcon(new ImageIcon(UserManage.class.getResource("/icon/allfix.png")));
		jb_modify.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(jb_modify);
		
		jb_delete = new JButton("\u5220\u9664");
		jb_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new Integer(bookNumTxt.getText()) != 0){
					JOptionPane.showMessageDialog(null, "该读者还有图书为归还，不能删除！！");
					return;
				}
				User User = new User(new Integer(idTxt.getText()));
				Connection con = null;
				try {
					con = dbUtil.getCon();
					Boolean rs = UserDao.deleteUserInfo(con, User);
					if(!rs){//成功返回false  excute 无Resultset返回值为false
						JOptionPane.showMessageDialog(null, "删除成功！！");
						UserManage.this.fillTable(new User());
						UserManage.this.resetInfo();
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！！");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "删除失败！！");
					e1.printStackTrace();
				}finally{
					try {
						dbUtil.closeCon(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb_delete.setBounds(516, 530, 123, 43);
		jb_delete.setForeground(new Color(0, 191, 255));
		jb_delete.setIcon(new ImageIcon(UserManage.class.getResource("/icon/del.png")));
		jb_delete.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(jb_delete);
		
		jb_reset = new JButton("\u91CD\u7F6E");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManage.this.resetInfo();
			}
		});
		jb_reset.setBounds(721, 530, 123, 43);
		jb_reset.setForeground(new Color(0, 191, 255));
		jb_reset.setIcon(new ImageIcon(UserManage.class.getResource("/icon/Reset.png")));
		jb_reset.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(jb_reset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 136, 973, 194);
		contentPane.add(scrollPane);
		
		UserTable = new JTable();
		UserTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserTableMousePressed(e);
			}
		});
		scrollPane.setViewportView(UserTable);
		UserTable.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		UserTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u804C\u4E1A", "\u5F53\u524D\u501F\u4E66\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		UserTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		UserTable.setRowHeight(30);
		UserTable.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		
	}
	
	/**
	 * 重置数据
	 */
	private void resetInfo() {
		idTxt.setText("默认值");
		nameTxt.setText("");
		genderTxt.setText("");
		ageTxt.setText("");
		jobTxt.setText("");
		bookNumTxt.setText("");
		
	}

	/**
	 * 向表中添加数据
	 */
	private void fillTable(User User){
		
		DefaultTableModel dtm = (DefaultTableModel) UserTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = UserDao.getUsersInfo(con, User);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getInt("age"));
				v.add(rs.getString("professional"));
				v.add(rs.getInt("num_of_book"));
				dtm.addRow(v);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 鼠标点击事件--UserTable
	 * @param evt
	 */
	private void UserTableMousePressed(java.awt.event.MouseEvent evt) {
		
		int row = UserTable.getSelectedRow();
		this.idTxt.setText((String) UserTable.getValueAt(row, 0).toString());
		this.nameTxt.setText((String) UserTable.getValueAt(row, 1));
		this.genderTxt.setText((String) UserTable.getValueAt(row, 2));
		this.ageTxt.setText((String) UserTable.getValueAt(row, 3).toString());
		this.jobTxt.setText((String) UserTable.getValueAt(row, 4));
		this.bookNumTxt.setText((String) UserTable.getValueAt(row, 5).toString());
	}
}
