package com.david.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu.Separator;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
// 로딩 구현
public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	int s;
	Thread th;

	public static void showloading() {
		Loading frame = new Loading();
		new Loading().setVisible(true);
		frame.setVisible(true);
	}

	public Loading() {
		initialize();
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("D2Coding", Font.PLAIN, 16));
		progressBar.setBounds(62, 110, 306, 38);
		progressBar.setStringPainted(true);
		contentPane.add(progressBar);

		setUploading();

	}

	public void setUploading() {
		this.setVisible(false);
		th.start();
	}

	public void run() {
		try {
			for (int i = 0; i < 200; i++) {
				s = s + 1;
				int m = progressBar.getMaximum();
				int v = progressBar.getValue();
				if (v < m) {
					progressBar.setValue(progressBar.getValue() + 1);
				} else {
					i = 201;
					setVisible(false);
					new Home().setVisible(true);
				}
				Thread.sleep(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
