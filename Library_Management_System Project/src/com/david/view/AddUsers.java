package com.david.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.david.dao.UsersDao;
import com.david.dao.UsersDaoImpl;
import com.david.vo.Users;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.awt.event.ActionEvent;

public class AddUsers extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JLabel stdname_2;
	private JTextField user_birthText;
	private JLabel stdname_4;
	private JTextField user_phoneText;
	private JLabel stdname_5;
	private JTextField user_mailText;
	private JLabel stdname_6;
	private JTextField user_addressText;
	private JButton addBt;
	private JButton backBt;
	
	private UsersDao dao = UsersDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showaddStudent(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUsers frame = new AddUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddUsers() {
		setTitle("Add User");
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel stdname = new JLabel("이    름");
		stdname.setHorizontalAlignment(SwingConstants.CENTER);
		stdname.setFont(new Font("D2Coding", Font.PLAIN, 16));
		stdname.setBounds(79, 33, 79, 25);
		contentPane.add(stdname);
		
		userNameText = new JTextField();
		userNameText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		userNameText.setColumns(10);
		userNameText.setBounds(170, 32, 169, 25);
		contentPane.add(userNameText);
		
		stdname_2 = new JLabel("주민번호");
		stdname_2.setHorizontalAlignment(SwingConstants.CENTER);
		stdname_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		stdname_2.setBounds(79, 70, 79, 25);
		contentPane.add(stdname_2);
		
		user_birthText = new JTextField();
		user_birthText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		user_birthText.setColumns(10);
		user_birthText.setBounds(170, 69, 169, 25);
		contentPane.add(user_birthText);
		
		stdname_4 = new JLabel("전화번호");
		stdname_4.setHorizontalAlignment(SwingConstants.CENTER);
		stdname_4.setFont(new Font("D2Coding", Font.PLAIN, 16));
		stdname_4.setBounds(79, 106, 79, 25);
		contentPane.add(stdname_4);
		
		user_phoneText = new JTextField();
		user_phoneText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		user_phoneText.setColumns(10);
		user_phoneText.setBounds(170, 105, 169, 25);
		contentPane.add(user_phoneText);
		
		stdname_5 = new JLabel("E-MAIL");
		stdname_5.setHorizontalAlignment(SwingConstants.CENTER);
		stdname_5.setFont(new Font("D2Coding", Font.PLAIN, 16));
		stdname_5.setBounds(79, 142, 79, 25);
		contentPane.add(stdname_5);
		
		user_mailText = new JTextField();
		user_mailText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		user_mailText.setColumns(10);
		user_mailText.setBounds(170, 141, 169, 25);
		contentPane.add(user_mailText);
		
		stdname_6 = new JLabel("주    소");
		stdname_6.setHorizontalAlignment(SwingConstants.CENTER);
		stdname_6.setFont(new Font("D2Coding", Font.PLAIN, 16));
		stdname_6.setBounds(12, 178, 79, 25);
		contentPane.add(stdname_6);
		
		user_addressText = new JTextField();
		user_addressText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		user_addressText.setColumns(10);
		user_addressText.setBounds(89, 177, 333, 25);
		contentPane.add(user_addressText);
		
		addBt = new JButton("Add");
		addBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: 공백일 시 특정 메시지 띄우기 - 예외처리
				String user_name = userNameText.getText();
				String user_birth = user_birthText.getText();
				String user_phone = user_phoneText.getText();
				String user_mail = user_mailText.getText();
				String user_address = user_addressText.getText();
			
				Users user = new Users(user_name, user_birth, user_phone, user_mail, user_address);
				int result = dao.insert(user);
				if (result == 1) {
					System.out.println("add user 성공");
					setVisible(false);
					new Home().setVisible(true);
				} else {
					System.out.println("add user 실패");
				}
				
				
				
			}
		});
		addBt.setForeground(Color.WHITE);
		addBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		addBt.setBackground(Color.BLACK);
		addBt.setBounds(114, 245, 97, 36);
		contentPane.add(addBt);
		
		backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		backBt.setForeground(Color.WHITE);
		backBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backBt.setBackground(Color.BLACK);
		backBt.setBounds(223, 247, 97, 36);
		contentPane.add(backBt);
	}

}
