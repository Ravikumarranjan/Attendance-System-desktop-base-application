package com.deepsingh44.blogspot.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.blogspot.model.Teacher;
import com.deepsingh44.blogspot.utility.Util;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private Teacher teacher;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HomePage(Teacher teacher) {
		this.teacher = teacher;
		setTitle("Teacher Home Page");
		Util.setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 900, 594);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmAddStudent = new JMenuItem("Add Student");
		mntmAddStudent
				.setIcon(new ImageIcon(HomePage.class.getResource("/com/deepsingh44/blogspot/images/add_student.png")));
		mntmAddStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnFile.add(mntmAddStudent);

		JMenuItem mntmAttendance = new JMenuItem("Attendance");
		mntmAttendance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnFile.add(mntmAttendance);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmTeacherProfile = new JMenuItem("Teacher Profile");
		mntmTeacherProfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnView.add(mntmTeacherProfile);

		JMenuItem mntmSearchStudent = new JMenuItem("Search Student");
		mntmSearchStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

		mnView.add(mntmSearchStudent);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		// add events here
		// attach AddStudent page here
		mntmAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudent a = new AddStudent();
				desktopPane.add(a);
				a.setVisible(true);
			}
		});

		// attach Attendance page here
		mntmAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Attendance a = new Attendance();
				desktopPane.add(a);
				a.setVisible(true);
			}
		});
		// attach Teacher Profile page here
		mntmTeacherProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pro = new Profile(teacher);
				desktopPane.add(pro);
				pro.setVisible(true);
			}
		});
		// attach Search Student page here
		mntmSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchStudent searchStudent = new SearchStudent();
				desktopPane.add(searchStudent);
				searchStudent.setVisible(true);
			}
		});
	}

}
