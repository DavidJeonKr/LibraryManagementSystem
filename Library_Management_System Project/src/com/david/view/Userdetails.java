package com.david.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.david.dao.DetailsDao;
import com.david.dao.DetailsDaoImpl;
import com.david.dao.UsersDao;
import com.david.dao.UsersDaoImpl;
import com.david.vo.Users;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class Userdetails extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField user_seqText;
	private JTable table;
	private JButton backtBt;
	private JButton seachBt;
	private JButton deleteBt;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private DetailsDao dao = DetailsDaoImpl.getInstance();
	private UsersDao userDao = UsersDaoImpl.getInstance();
	private final String[] COLUMN = { "회원번호", "이름", "주민번호", "전화번호", "E-MAIL", "주소", "반납여부" };
	private List<Users> list = dao.selectUsers();

	public static void showUserDetails() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userdetails frame = new Userdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Userdetails() {
		setTitle("User Details");
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 85, 560, 266);
		contentPane.add(scrollPane);

		table = new JTable();
		showallusers();
		scrollPane.setViewportView(table);

		backtBt = new JButton("Back");
		backtBt.setForeground(Color.WHITE);
		backtBt.addActionListener(this);
		backtBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backtBt.setBackground(Color.BLACK);
		backtBt.setBounds(12, 52, 97, 23);
		contentPane.add(backtBt);

		user_seqText = new JTextField();
		user_seqText.setColumns(10);
		user_seqText.setBounds(121, 53, 222, 21);
		contentPane.add(user_seqText);

		JLabel lblUserDetaiils = new JLabel("User Detaiils");
		lblUserDetaiils.setBackground(Color.WHITE);
		lblUserDetaiils.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDetaiils.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblUserDetaiils.setBounds(12, 10, 560, 32);
		contentPane.add(lblUserDetaiils);

		seachBt = new JButton("Seach");
		seachBt.setForeground(Color.WHITE);
		seachBt.addActionListener(this);
		seachBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		seachBt.setBackground(Color.BLACK);
		seachBt.setBounds(355, 52, 97, 23);
		contentPane.add(seachBt);

		deleteBt = new JButton("Delete");
		deleteBt.setForeground(Color.WHITE);
		deleteBt.addActionListener(this);
		deleteBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		deleteBt.setBackground(Color.BLACK);
		deleteBt.setBounds(475, 52, 97, 23);
		contentPane.add(deleteBt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backtBt) {
			setVisible(false);
			new Home().setVisible(true);
		}
		
		if(e.getSource() == seachBt) {
			try {
			model = new DefaultTableModel(null, COLUMN);
			int no = Integer.parseInt(user_seqText.getText());
			Users u = userDao.selectone(no);
			Object[] rowdata = { u.getUser_seq(), u.getUser_name(), u.getUser_birth(), u.getUser_phone(),
					u.getUser_mail(), u.getUser_address(), u.getUser_rent() };
			model.addRow(rowdata);
			table.setModel(model);
			} catch (NumberFormatException e1) {
				showallusers();
			}
		}
		
		if(e.getSource() == deleteBt) {
			int response = JOptionPane.showConfirmDialog(this,"정말로 삭제하시겠습니까? 도서번호를 입력해주세요!!", "Confirm",  JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION) {
				return;
			}
			int no = Integer.parseInt(user_seqText.getText());
			
			int result = dao.deleteUser(no);
			if(result == 1) {
				JOptionPane.showMessageDialog(this, "삭제완료.ㅎㄷㄷ");
				showallusers();
			} else {
				JOptionPane.showMessageDialog(this, "삭제 안됬는데?");
			}
		}
		
	}

	// "회원번호","이름","주민번호","전화번호","E-MAIL", "주소", "반납여부(0,1)"
	public void showallusers() {
		model = new DefaultTableModel(null, COLUMN);
		for (Users u : list) {
			Object[] rowdata = { u.getUser_seq(), u.getUser_name(), u.getUser_birth(), u.getUser_phone(),
					u.getUser_mail(), u.getUser_address(), u.getUser_rent() };
			model.addRow(rowdata);
		}
		table.setModel(model);
	}

}
