package com.deepsingh44.blogspot.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.blogspot.utility.Util;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class Splash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Splash frame = new Splash();
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		Util.setLookAndFeel();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);

		JProgressBar pb = new JProgressBar();
		pb.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pb.setBounds(0, 233, 400, 17);
		pb.setStringPainted(true);
		pb.setIndeterminate(true);
		contentPane.setLayout(null);
		contentPane.add(pb);
		
		JLabel lblStudentAttendanceSystem = new JLabel("Student Attendance System");
		lblStudentAttendanceSystem.setForeground(new Color(255, 255, 255));
		lblStudentAttendanceSystem.setFont(new Font("Serif", Font.BOLD, 20));
		lblStudentAttendanceSystem.setBounds(72, 188, 252, 34);
		contentPane.add(lblStudentAttendanceSystem);
		
		ImageIcon im = new ImageIcon(Splash.class.getResource("/com/deepsingh44/blogspot/images/group.jpg"));
		JLabel lblNewLabel = new JLabel(Util.resize(im, 400, 239));
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel.setBounds(0, 0, 400, 239);
		contentPane.add(lblNewLabel);
		setVisible(true);

		//just a dummy wait for progress...
		for (int i = 0; i <= 100; i++) {
			pb.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//After completion of progress bar open Login Page code here
		if (pb.getValue() == 100) {
			dispose();
			Login login = new Login();
			login.setVisible(true);
			
		}

	}

}
