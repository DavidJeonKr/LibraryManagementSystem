package com.david.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.david.dao.AccountDao;
import com.david.dao.AccountDaoImpl;
import com.david.vo.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField nameText;
	
	AccountDao dao = AccountDaoImpl.getInstance();
	private JPasswordField passwordText;
	
	/**
	 * Launch the application.
	 */
	public static void Showsignup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Signup() {
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 74, 95, 28);
		contentPane.add(lblNewLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		usernameText.setBounds(232, 77, 116, 21);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Create Account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(57, 25, 291, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Name:");
		lblPassword.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblPassword.setBounds(57, 148, 95, 28);
		contentPane.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblPassword_1.setBounds(57, 110, 95, 28);
		contentPane.add(lblPassword_1);
		
		nameText = new JTextField();
		nameText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		nameText.setColumns(10);
		nameText.setBounds(232, 151, 116, 21);
		contentPane.add(nameText);
		
		JButton createBt = new JButton("Create");
		createBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user_name = usernameText.getText();
				String name = nameText.getText();
				String password = passwordText.getText();
				
				Account account = new Account(user_name, name, password);

				int result = dao.insertid(account);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "succesfully Created");
				} else {
					System.out.println(result);
				}
				
				cleantext();
				setVisible(false);
				
				
				
			}
		});
		createBt.setBackground(Color.BLACK);
		createBt.setForeground(Color.WHITE);
		createBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		createBt.setBounds(57, 186, 97, 23);
		contentPane.add(createBt);
		
		JButton backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		backBt.setBackground(Color.BLACK);
		backBt.setForeground(Color.WHITE);
		backBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backBt.setBounds(251, 186, 97, 23);
		contentPane.add(backBt);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(232, 114, 116, 21);
		contentPane.add(passwordText);
	}
	
	void cleantext() {
		usernameText.setText("");
		nameText.setText("");
		passwordText.setText("");
	}
}
