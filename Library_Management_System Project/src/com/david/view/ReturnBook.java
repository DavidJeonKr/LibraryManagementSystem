package com.david.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.david.dao.BookDao;
import com.david.dao.BookDaoImpl;
import com.david.vo.Book;
import com.david.vo.IssueBook;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField book_seqText;
	private JTextField user_seqText;
	private JButton btnNewButton;
	private JLabel book_title;
	private JLabel lableee;
	private JTextField book_nameText;
	private JTextField user_nameText;
	private JButton btnReturn;
	private JButton btnBack;
	private JTextField issue_dateText;
	private JTextField return_dateText;
	private BookDao bookdao = BookDaoImpl.getInstance();

	public static void showreturnbook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReturnBook() {
		setTitle("Return Book");
		initialize();

	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 246);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("도서번호:");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 41, 80, 15);
		contentPane.add(lblNewLabel);

		book_seqText = new JTextField();
		book_seqText.setBounds(94, 38, 88, 21);
		contentPane.add(book_seqText);
		book_seqText.setColumns(10);

		JLabel lable = new JLabel("회원번호:");
		lable.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lable.setBounds(194, 41, 80, 15);
		contentPane.add(lable);

		user_seqText = new JTextField();
		user_seqText.setColumns(10);
		user_seqText.setBounds(284, 38, 88, 21);
		contentPane.add(user_seqText);

		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date today = new Date();
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				int book_seq = Integer.parseInt(book_seqText.getText());
				int user_seq = Integer.parseInt(user_seqText.getText());

				IssueBook issueBook = bookdao.selectIssueBook(book_seq, user_seq);
				book_nameText.setText(issueBook.getBname());
				user_nameText.setText(issueBook.getUname());
				issue_dateText.setText("" + issueBook.getDateofissue());
				return_dateText.setText("" + date.format(today));

			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnNewButton.setBounds(384, 32, 95, 33);
		contentPane.add(btnNewButton);

		book_title = new JLabel("도 서 명:");
		book_title.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_title.setBounds(12, 84, 80, 15);
		contentPane.add(book_title);

		lableee = new JLabel("이    름:");
		lableee.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lableee.setBounds(194, 84, 80, 15);
		contentPane.add(lableee);

		book_nameText = new JTextField();
		book_nameText.setColumns(10);
		book_nameText.setBounds(94, 81, 88, 21);
		contentPane.add(book_nameText);

		user_nameText = new JTextField();
		user_nameText.setColumns(10);
		user_nameText.setBounds(284, 81, 88, 21);
		contentPane.add(user_nameText);

		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: DATE 구현 실패...
				Date issueday = new Date();
				Date returnday = new Date();
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				int book_seq = Integer.parseInt(book_seqText.getText());
				int user_seq = Integer.parseInt(user_seqText.getText());
				String bname = book_nameText.getText();
				String uname = user_nameText.getText();
				
//				issueday = date.parse(dateofissue);
//				returnday = date.parse(dateofreturn);

				com.david.vo.ReturnBook returnBook = new com.david.vo.ReturnBook(book_seq, user_seq, bname, uname);

				int result = bookdao.returnbook(returnBook);
				if (result == 1) {
					System.out.println("성공했따!!");
					deleteIssueBook();
					setVisible(false);
					new Home().setVisible(true);
				} else {
					System.out.println("실패당!");
				}

			}
		});
		btnReturn.setBackground(Color.BLACK);
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnReturn.setBounds(284, 112, 150, 33);
		contentPane.add(btnReturn);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Home().setVisible(true);

			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnBack.setBounds(284, 155, 150, 33);
		contentPane.add(btnBack);

		JLabel lblNewLabel_2_1 = new JLabel("대 여 일:");
		lblNewLabel_2_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(12, 137, 80, 15);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("반 납 일:");
		lblNewLabel_2_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(12, 171, 80, 15);
		contentPane.add(lblNewLabel_2_1_1);

		issue_dateText = new JTextField();
		issue_dateText.setColumns(10);
		issue_dateText.setBounds(94, 134, 180, 21);
		contentPane.add(issue_dateText);

		return_dateText = new JTextField();
		return_dateText.setColumns(10);
		return_dateText.setBounds(94, 168, 180, 21);
		contentPane.add(return_dateText);
	}

	void deleteIssueBook() {
		// delete issuebook
		int no = Integer.parseInt(book_seqText.getText());
		bookdao.deleteIssue(no);

		
		
	}
}