package com.david.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame {
//	private static final String[] IMAGES = { "images/1.png", "images/2.png", "images/3.png", "images/4.png",
//			"images/5.png", "images/6.png" };

	private JPanel contentPane;
	private JLabel image1;
	private JButton b1;
	private JButton b2;

	public static void showhome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.black);
		menuBar.setForeground(Color.white);
		menuBar.setBounds(0, 0, 700, 20);
		contentPane.add(menuBar);

		JMenu menu = new JMenu("Menu");
		menu.setBackground(Color.black);
		menu.setForeground(Color.white);
		menuBar.add(menu);

		JMenuItem bookdetails = new JMenuItem("Book Details");
		bookdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 북 디테일 뷰
				setVisible(false);
				new Bookdetails().setVisible(true);
			}
		});
		bookdetails.setBackground(Color.BLACK);
		bookdetails.setForeground(Color.WHITE);

		menu.add(bookdetails);

		JMenuItem userdtails = new JMenuItem("User Details");
		userdtails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 유저 디테일 뷰
				setVisible(false);
				new Userdetails().setVisible(true);

			}
		});
		userdtails.setBackground(Color.BLACK);
		userdtails.setForeground(Color.WHITE);

		menu.add(userdtails);

		image1 = new JLabel("");
//		ImageIcon image2 = new ImageIcon(IMAGES[0]);
		ImageIcon image2  = new ImageIcon(ClassLoader.getSystemResource("com/david/icons/1.png"));
		Image image3 = image2.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon image4 = new ImageIcon(image3);
		image1 = new JLabel(image4);
		image1.setBounds(10, 32, 200, 150);
		contentPane.add(image1);

		JLabel image1_1 = new JLabel((Icon) null);
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("com/david/icons/2.png"));
		Image i3 = i2.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon i4 = new ImageIcon(i3);
		image1_1 = new JLabel(i4);
		image1_1.setBounds(241, 32, 200, 150);
		contentPane.add(image1_1);

		JLabel image1_2 = new JLabel((Icon) null);
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("com/david/icons/3.png"));
		Image i12 = i11.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
		image1_2 = new JLabel(i13);
		image1_2.setBounds(472, 32, 200, 150);
		contentPane.add(image1_2);

		JLabel image1_3 = new JLabel((Icon) null);
		ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("com/david/icons/4.png"));
		Image i22 = i21.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon i23 = new ImageIcon(i22);
		image1_3 = new JLabel(i23);
		image1_3.setBounds(10, 253, 200, 150);
		contentPane.add(image1_3);

		JLabel image1_1_1 = new JLabel((Icon) null);
		ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("com/david/icons/6.png"));
		Image i32 = i31.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i32);
		image1_1_1 = new JLabel(i33);
		image1_1_1.setBounds(241, 253, 200, 150);
		contentPane.add(image1_1_1);

		JLabel image1_2_1 = new JLabel((Icon) null);
		image1_2_1.setBounds(472, 253, 200, 150);
		contentPane.add(image1_2_1);

		b1 = new JButton("도서 등록");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddBook().setVisible(true);
			}
		});
		b1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(10, 192, 200, 33);
		contentPane.add(b1);

		b2 = new JButton("회원 등록");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddUsers().setVisible(true);
			}
		});
		b2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(241, 192, 200, 33);
		contentPane.add(b2);

		JButton b3 = new JButton("대   여");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IssueBook().setVisible(true);
			}
		});
		b3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(472, 192, 200, 33);
		contentPane.add(b3);

		JButton b4 = new JButton("반   납");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ReturnBook().setVisible(true);
			}
		});
		b4.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(10, 413, 200, 33);
		contentPane.add(b4);

		JButton b5 = new JButton("도서 현황");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Details().setVisible(true);

			}
		});
		b5.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(241, 413, 200, 33);
		contentPane.add(b5);

		JButton b6 = new JButton("?");
		b6.hide();
		b6.setFont(new Font("D2Coding", Font.PLAIN, 16));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(472, 413, 200, 33);
		contentPane.add(b6);
	}
}
