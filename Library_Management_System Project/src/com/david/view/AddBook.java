package com.david.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.david.dao.BookDao;
import com.david.dao.BookDaoImpl;
import com.david.vo.Book;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField titleText;
	private JTextField authorText;
	private JTextField publisherText;
	private JComboBox codeBox;
	private JTextField pagesText;
	private JTextField isbnText;
	private JButton addBt;
	private JButton backBt;
	private String[] CODE_ITEM =   {"00 총류", "10 철학", "20 종교", 
			"30 사회과학", "40 자연과학", "50 기술과학", "60 예술", 
			"70 언어", "80 문학", "90 역사"};

	private BookDao dao = BookDaoImpl.getInstance();
	private JTextField priceText;
	
	
	public static void showAddBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AddBook() {
		initialize();
	}

	public void initialize() {
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel book_id = new JLabel("도 서 명");
		book_id.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id.setHorizontalAlignment(SwingConstants.CENTER);
		book_id.setBounds(79, 33, 79, 25);
		contentPane.add(book_id);
		
		JLabel book_id_1 = new JLabel("저    자");
		book_id_1.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1.setBounds(79, 68, 79, 25);
		contentPane.add(book_id_1);
		
		JLabel book_id_1_1 = new JLabel("출 판 사");
		book_id_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1_1.setBounds(79, 100, 79, 25);
		contentPane.add(book_id_1_1);
		
		codeBox = new JComboBox();
		codeBox.setModel(new DefaultComboBoxModel(CODE_ITEM));
		codeBox.setFont(new Font("D2Coding", Font.PLAIN, 16));
		codeBox.setBounds(182, 135, 169, 25);
		contentPane.add(codeBox);
		
		JLabel book_id_1_1_1 = new JLabel("분류코드");
		book_id_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1_1_1.setBounds(79, 135, 79, 25);
		contentPane.add(book_id_1_1_1);
		
		JLabel book_id_1_1_1_1 = new JLabel("페이지수");
		book_id_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1_1_1_1.setBounds(79, 204, 79, 25);
		contentPane.add(book_id_1_1_1_1);
		
		titleText = new JTextField();
		titleText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		titleText.setBounds(182, 33, 169, 25);
		contentPane.add(titleText);
		titleText.setColumns(10);
		
		authorText = new JTextField();
		authorText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		authorText.setColumns(10);
		authorText.setBounds(182, 70, 169, 25);
		contentPane.add(authorText);
		
		publisherText = new JTextField();
		publisherText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		publisherText.setColumns(10);
		publisherText.setBounds(182, 102, 169, 25);
		contentPane.add(publisherText);
		
		pagesText = new JTextField();
		pagesText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		pagesText.setColumns(10);
		pagesText.setBounds(182, 206, 169, 25);
		contentPane.add(pagesText);
		
		JLabel book_id_1_1_1_1_1 = new JLabel("I S B N");
		book_id_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1_1_1_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1_1_1_1_1.setBounds(79, 239, 79, 25);
		contentPane.add(book_id_1_1_1_1_1);
		
		isbnText = new JTextField();
		isbnText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		isbnText.setColumns(10);
		isbnText.setBounds(182, 241, 169, 25);
		contentPane.add(isbnText);
		
		addBt = new JButton("Add");
		addBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: 데이터베이스 연동
				//성공 시 다이어그램 하나 띄어주기
				
				String title = titleText.getText();
				String author = authorText.getText();
				int price = Integer.parseInt(priceText.getText());
				int pages = Integer.parseInt(pagesText.getText());
				String code = (String)codeBox.getSelectedItem();
				int recode = replace(code);
				long isbn = Integer.parseInt(isbnText.getText());
				String publisher = publisherText.getText();
				
				Book book = new Book(title, isbn, author, publisher, pages, price, recode);
				
				int result = dao.insert(book);
				if(result == 1) {
					//성공
					System.out.println("북 인서트 성공");
				} else {
					System.out.println("북 인서트 실패");
				}
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		addBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		addBt.setBackground(Color.BLACK);
		addBt.setForeground(Color.WHITE);
		addBt.setBounds(109, 290, 97, 36);
		contentPane.add(addBt);
		
		backBt = new JButton("Back");
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		backBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		backBt.setBackground(Color.BLACK);
		backBt.setForeground(Color.WHITE);
		backBt.setBounds(234, 290, 97, 36);
		contentPane.add(backBt);
		
		JLabel book_id_1_1_1_1_2 = new JLabel("가    격");
		book_id_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		book_id_1_1_1_1_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		book_id_1_1_1_1_2.setBounds(79, 170, 79, 25);
		contentPane.add(book_id_1_1_1_1_2);
		
		priceText = new JTextField();
		priceText.setFont(new Font("D2Coding", Font.PLAIN, 16));
		priceText.setColumns(10);
		priceText.setBounds(182, 172, 169, 25);
		contentPane.add(priceText);
		

	}
	
	int replace(String code) {
		int result = 0;
		StringBuffer sb = new StringBuffer(code);
		String recode = sb.substring(0, 2);
		result = Integer.parseInt(recode);
		return result;
	}
}
