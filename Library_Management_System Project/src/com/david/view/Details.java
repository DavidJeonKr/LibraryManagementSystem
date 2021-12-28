package com.david.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.david.dao.BookDao;
import com.david.dao.BookDaoImpl;
import com.david.dao.Conn;
import com.david.vo.IssueBook;
import com.david.vo.ReturnBook;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Details extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	
	private BookDao dao = BookDaoImpl.getInstance();
	
	private static final String[] COLUMN = {"도서번호","회원번호","도서명","이름","대여일"};
	private static final String[] COLUMN1 = {"도서번호","회원번호","도서명","이름","대여일","반납일"};
	private JTable table1;
	private JTable table2;
	
	
	public static void showdetails(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details frame = new Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Details() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 592);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 10, 645, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblReturnBookDetails = new JLabel("Return Book Details");
		lblReturnBookDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBookDetails.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblReturnBookDetails.setBounds(12, 270, 645, 15);
		contentPane.add(lblReturnBookDetails);
		
		JButton backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		backBt.setBackground(Color.black);
		backBt.setForeground(Color.white);
		backBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backBt.setBounds(560, 6, 97, 23);
		contentPane.add(backBt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 35, 646, 218);
		contentPane.add(scrollPane);
		//테이블1(issue)
		table1 = new JTable();
		issueBook();
		table1.setModel(model);
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(11, 295, 646, 218);
		contentPane.add(scrollPane_1);
		//테이블2(return)
		table2 = new JTable();
		returnBook();
		table2.setModel(model);
		scrollPane_1.setViewportView(table2);
	}
	
	public void issueBook() {
		List<IssueBook> list = dao.select();
		model = new DefaultTableModel(null, COLUMN);
		for(IssueBook i : list) {
			Object[] rowdata = {i.getBook_seq(),i.getUser_seq(),i.getBname(),i.getUname(),i.getDateofissue()};
			model.addRow(rowdata);
		}
	}
	public void returnBook() {
		List<ReturnBook> list = dao.selectReturnBooks();
		model = new DefaultTableModel(null, COLUMN1);
		for(ReturnBook r : list) {
			Object[] rowdata = {r.getBook_seq(),r.getUser_seq(),r.getBname(),r.getUname(),r.getDateofissue(),r.getDateofreturn()};
			model.addRow(rowdata);
		}
		
		
	}
}
