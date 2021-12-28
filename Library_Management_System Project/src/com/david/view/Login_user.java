package com.david.view;	

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import com.david.dao.AccountDao;
import com.david.dao.AccountDaoImpl;
import com.david.vo.Account;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login_user {

	private JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;
	
	AccountDao dao = AccountDaoImpl.getInstance();
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_user window = new Login_user();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 64, 72, 27);
		frame.getContentPane().add(lblNewLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		usernameText.setBounds(192, 64, 150, 27);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblPassword.setBounds(108, 101, 72, 27);
		frame.getContentPane().add(lblPassword);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		passwordText.setBounds(192, 101, 150, 27);
		frame.getContentPane().add(passwordText);
		
		JButton logtnBt = new JButton("Login");
		//로그인 버튼 클릭
		logtnBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: 1. username password 검사 실패하면 x
				// 		      맞다면 go
				//      2. loading 프레임 이동
				//		3. home frame으로 이동
				//login check
				String user_name = usernameText.getText();
				String password = passwordText.getText();
				Account account = new Account(user_name, password); 
				int result = dao.checkid(account);
				if (result == 1) {
					frame.setVisible(false);
					new Home().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid Login...!");
				}
				cleantext();
			}
		});
		logtnBt.setBackground(Color.black);
		logtnBt.setForeground(Color.white);
		logtnBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		logtnBt.setBounds(108, 141, 97, 23);
		frame.getContentPane().add(logtnBt);
		
		JButton signupBt = new JButton("Signup");
		signupBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Signup().setVisible(true);
				
			}
		});
		signupBt.setBackground(Color.black);
		signupBt.setForeground(Color.white);
		signupBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		signupBt.setBounds(245, 141, 97, 23);
		frame.getContentPane().add(signupBt);
	}
	
	void cleantext() {
		usernameText.setText("");
		passwordText.setText("");
	}
}
