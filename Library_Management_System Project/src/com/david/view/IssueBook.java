package com.david.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.david.dao.BookDao;
import com.david.dao.BookDaoImpl;
import com.david.dao.UsersDao;
import com.david.dao.UsersDaoImpl;
import com.david.vo.Book;
import com.david.vo.Users;

import oracle.security.o3logon.a;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField book_seqText;
	private JTextField a1;
	private JTextField a2;
	private JTextField a3;
	private JTextField a4;
	private JTextField a5;
	private JTextField a6;
	private JTextField a7;
	private JTextField user_seqText;
	private JTextField b1;
	private JTextField b2;
	private JTextField b3;
	private JTextField b4;
	private JTextField b5;

	/**
	 * Launch the application.
	 */
	
	private BookDao bookdao = BookDaoImpl.getInstance();
	private UsersDao userdao = UsersDaoImpl.getInstance();
	public static void showissuebook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IssueBook() {
		setTitle("Issue Book");
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 352);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("도 서 명:");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 75, 77, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("저    자:");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 105, 77, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("출 판 사:");
		lblNewLabel_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(12, 135, 77, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("분류코드:");
		lblNewLabel_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(12, 165, 77, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("페이지수:");
		lblNewLabel_1_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(12, 225, 77, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("I S  B N:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(12, 255, 77, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("가    격:");
		lblNewLabel_1_1_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(12, 195, 77, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		book_seqText = new JTextField();
		book_seqText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_seqText.setBounds(101, 45, 94, 21);
		contentPane.add(book_seqText);
		book_seqText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("도서번호:");
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(12, 45, 77, 20);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: select(int no)을 넘겨서 DAO에서 처리
				int book_seq = Integer.parseInt(book_seqText.getText());
				Book book = bookdao.selectone(book_seq);
				a1.setText(book.getBook_title());
				a2.setText(book.getBook_autor());
				a3.setText(book.getBook_publisher());
				a4.setText(Integer.toString(book.getBook_code()));
				a5.setText(Integer.toString(book.getBook_price()));
				a6.setText(Integer.toString(book.getBook_pages()));
				a7.setText(Long.toString(book.getBook_isbn()));
				
				
				
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnNewButton.setBounds(207, 41, 106, 31);
		contentPane.add(btnNewButton);
		
		a1 = new JTextField();
		a1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a1.setColumns(10);
		a1.setBounds(101, 75, 212, 21);
		contentPane.add(a1);
		
		a2 = new JTextField();
		a2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a2.setColumns(10);
		a2.setBounds(101, 105, 212, 21);
		contentPane.add(a2);
		
		a3 = new JTextField();
		a3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a3.setColumns(10);
		a3.setBounds(101, 135, 212, 21);
		contentPane.add(a3);
		
		a4 = new JTextField();
		a4.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a4.setColumns(10);
		a4.setBounds(101, 165, 212, 21);
		contentPane.add(a4);
		
		a5 = new JTextField();
		a5.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a5.setColumns(10);
		a5.setBounds(101, 195, 212, 21);
		contentPane.add(a5);
		
		a6 = new JTextField();
		a6.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a6.setColumns(10);
		a6.setBounds(101, 225, 212, 21);
		contentPane.add(a6);
		
		a7 = new JTextField();
		a7.setFont(new Font("D2Coding", Font.PLAIN, 16));
		a7.setColumns(10);
		a7.setBounds(101, 255, 212, 21);
		contentPane.add(a7);
		
		JLabel lblNewLabel_2_1 = new JLabel("회원번호:");
		lblNewLabel_2_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(336, 45, 77, 20);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("이    름:");
		lblNewLabel_2_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(336, 75, 77, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("주민번호:");
		lblNewLabel_2_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(336, 105, 77, 20);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("전화번호:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(336, 138, 77, 20);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("E-MAIL:");
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(336, 168, 77, 20);
		contentPane.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_3 = new JLabel("주    소:");
		lblNewLabel_2_1_1_1_3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_3.setBounds(336, 198, 77, 20);
		contentPane.add(lblNewLabel_2_1_1_1_3);
		
		user_seqText = new JTextField();
		user_seqText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		user_seqText.setColumns(10);
		user_seqText.setBounds(425, 45, 94, 21);
		contentPane.add(user_seqText);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user_seq = Integer.parseInt(user_seqText.getText());
				Users user = userdao.selectone(user_seq);
				
				b1.setText(user.getUser_name());
				b2.setText(user.getUser_birth());
				b3.setText(user.getUser_phone());
				b4.setText(user.getUser_mail());
				b5.setText(user.getUser_address());
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnNewButton_1.setBounds(531, 41, 106, 31);
		contentPane.add(btnNewButton_1);
		
		b1 = new JTextField();
		b1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b1.setColumns(10);
		b1.setBounds(425, 75, 212, 21);
		contentPane.add(b1);
		
		b2 = new JTextField();
		b2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b2.setColumns(10);
		b2.setBounds(425, 105, 212, 21);
		contentPane.add(b2);
		
		b3 = new JTextField();
		b3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b3.setColumns(10);
		b3.setBounds(425, 138, 212, 21);
		contentPane.add(b3);
		
		b4 = new JTextField();
		b4.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b4.setColumns(10);
		b4.setBounds(425, 168, 212, 21);
		contentPane.add(b4);
		
		b5 = new JTextField();
		b5.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b5.setColumns(10);
		b5.setBounds(425, 195, 212, 21);
		contentPane.add(b5);
		
		JButton issueBt = new JButton("Issue");
		issueBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: book데이터베이스 users데이터베이스 연동!!
				int result = bookdao.updateissue(book_seqText.getText(), user_seqText.getText(), a1.getText(), b1.getText());
				if (result == 1) {
					System.out.println("이슈북 인서트 성공");
					setVisible(false);
					new Home().setVisible(true);
				} else {
					
					System.out.println("이슈북 인서트 실패");
				}
			}
		});
		issueBt.setBackground(Color.BLACK);
		issueBt.setForeground(Color.WHITE);
		issueBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		issueBt.setBounds(336, 228, 118, 47);
		contentPane.add(issueBt);
		
		JButton backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		backBt.setBackground(Color.BLACK);
		backBt.setForeground(Color.WHITE);
		backBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backBt.setBounds(519, 228, 118, 47);
		contentPane.add(backBt);
	}
}
