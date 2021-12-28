package com.david.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.david.dao.BookDao;
import com.david.dao.BookDaoImpl;
import com.david.dao.DetailsDao;
import com.david.dao.DetailsDaoImpl;
import com.david.vo.Book;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

public class Bookdetails extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField book_seqText;
	private JButton bactkBt;
	private JButton seachBt;
	private JButton deleteBt;
	private DefaultTableModel model;
	private DetailsDao dao = DetailsDaoImpl.getInstance();
	private BookDao bookDao = BookDaoImpl.getInstance();
	private List<Book> list = dao.selectBook();
	private static final String[] COLUMN = { "도서번호", "도서명", "저자", "가격", "페이지수", "코드", "출판사", "ISBN", "반납여부" };

	public static void showBookDetails() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookdetails frame = new Bookdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bookdetails() {
		setTitle("Book Details");
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 85, 560, 266);
		contentPane.add(scrollPane);

		table = new JTable();
		showallbook();
		scrollPane.setViewportView(table);

		bactkBt = new JButton("Back");
		bactkBt.addActionListener(this);
		bactkBt.setForeground(Color.WHITE);
		bactkBt.setBackground(Color.BLACK);
		bactkBt.setFont(new Font("D2Coding", Font.PLAIN, 16));
		bactkBt.setBounds(12, 52, 97, 23);
		contentPane.add(bactkBt);

		book_seqText = new JTextField();
		book_seqText.setBounds(121, 53, 222, 21);
		contentPane.add(book_seqText);
		book_seqText.setColumns(10);

		JLabel lblNewLabel = new JLabel("Book Detaiils");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 10, 560, 32);
		contentPane.add(lblNewLabel);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bactkBt) {
			setVisible(false);
			new Home().setVisible(true);
		}
		// seach버튼 액션
		if (e.getSource() == seachBt) {
			try {
				model = new DefaultTableModel(null, COLUMN);
				int no = Integer.parseInt(book_seqText.getText());
				Book b = bookDao.selectone(no);
				Object[] rowdata = { b.getBook_seq(), b.getBook_title(), b.getBook_autor(), b.getBook_price(),
						b.getBook_pages(), b.getBook_code(), b.getBook_publisher(), b.getBook_isbn(), b.getRent() };
				model.addRow(rowdata);
				table.setModel(model);
			} catch (NumberFormatException e1) {
				showallbook();
			}
			
		}
		// delete버튼 액션
		if (e.getSource() == deleteBt) {
			int response = JOptionPane.showConfirmDialog(this,"정말로 삭제하시겠습니까? 도서번호를 입력해주세요!!", "Confirm",  JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.NO_OPTION) {
				return;
			}
			int no = Integer.parseInt(book_seqText.getText());
			
			int result = dao.deleteBook(no);
			if(result == 1) {
				JOptionPane.showMessageDialog(this, "삭제완료.ㅎㄷㄷ");
				showallbook();
			} else {
				JOptionPane.showMessageDialog(this, "삭제 안됬는데?");
			}
		}

	}

	public void showallbook() {
		model = new DefaultTableModel(null, COLUMN);
		for (Book b : list) {
			Object[] rowdata = { b.getBook_seq(), b.getBook_title(), b.getBook_autor(), b.getBook_price(),
					b.getBook_pages(), b.getBook_code(), b.getBook_publisher(), b.getBook_isbn(), b.getRent() };
			model.addRow(rowdata);
		}
		table.setModel(model);
	}

}
