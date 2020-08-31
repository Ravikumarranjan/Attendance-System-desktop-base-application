package com.deepsingh44.blogspot.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.blogspot.dao.TeacherDao;
import com.deepsingh44.blogspot.model.Teacher;
import com.deepsingh44.blogspot.utility.Util;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField tid;
	private JPasswordField tpass;
	private JTextField tname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Teacher Register Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 456);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 204, 0));
		panel.setBounds(10, 59, 234, 324);
		contentPane.add(panel);
		panel.setLayout(null);

		ImageIcon im = new ImageIcon(Login.class.getResource("/com/deepsingh44/blogspot/images/college.jpg"));
		JLabel label = new JLabel(Util.resize(im, 207, 169));
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label.setBounds(10, 11, 214, 169);
		panel.add(label);

		JLabel lblThisIsAn = new JLabel(
				"<html> With the App, teachers can mark attendance of students in their class in no time, without any paperwork. ... Using the app, the teachers can actively engage parents to participate more in their ward's scholastic activities, on a daily basis. </html>",
				JLabel.CENTER);
		lblThisIsAn.setFont(new Font("Serif", Font.PLAIN, 12));
		lblThisIsAn.setForeground(new Color(255, 255, 255));
		lblThisIsAn.setBorder(null);
		lblThisIsAn.setVerticalAlignment(JLabel.TOP);
		lblThisIsAn.setBounds(10, 191, 214, 134);
		panel.add(lblThisIsAn);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel_1.setBounds(265, 59, 313, 324);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLoginDetails = new JLabel("<html><u>Register Details</u></html>");
		lblLoginDetails.setForeground(Color.WHITE);
		lblLoginDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginDetails.setBounds(101, 30, 125, 14);
		panel_1.add(lblLoginDetails);

		JLabel lblEnterTeacherId = new JLabel("Enter Teacher ID");
		lblEnterTeacherId.setForeground(Color.WHITE);
		lblEnterTeacherId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterTeacherId.setBounds(47, 85, 106, 14);
		panel_1.add(lblEnterTeacherId);

		tid = new JTextField();
		tid.setColumns(10);
		tid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tid.setBounds(47, 101, 220, 30);
		panel_1.add(tid);

		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterPassword.setBounds(47, 145, 106, 14);
		panel_1.add(lblEnterPassword);

		tpass = new JPasswordField();
		tpass.setColumns(10);
		tpass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpass.setBounds(47, 161, 220, 30);
		panel_1.add(tpass);

		JButton signup = new JButton("Singup");

		signup.setForeground(Color.WHITE);
		signup.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		signup.setBackground(Color.BLUE);
		signup.setBounds(33, 283, 119, 30);
		panel_1.add(signup);

		JButton signin = new JButton("Signin");
		signin.setForeground(Color.WHITE);
		signin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		signin.setBackground(new Color(0, 153, 51));
		signin.setBounds(168, 283, 119, 30);
		panel_1.add(signin);

		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setForeground(Color.WHITE);
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterName.setBounds(47, 209, 106, 14);
		panel_1.add(lblEnterName);

		tname = new JTextField();
		tname.setColumns(10);
		tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tname.setBounds(47, 225, 220, 30);
		panel_1.add(tname);

		ImageIcon im1 = new ImageIcon(Login.class.getResource("/com/deepsingh44/blogspot/images/group.jpg"));
		JLabel lblNewLabel = new JLabel(Util.resize(im1, 588, 417));
		lblNewLabel.setBackground(new Color(0, 153, 102));
		lblNewLabel.setBounds(0, 0, 588, 417);
		contentPane.add(lblNewLabel);

		// add event here
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});

		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					// after validation we want to store data into database.

					// Step 1: create connection
					// Step 2:create database
					// Step 3:create table

					// compose all data into model class
					Teacher teacher = new Teacher();
					teacher.setId(Integer.parseInt(id));
					teacher.setName(name);
					teacher.setPassword(pass);
					teacher.setImage("");
					teacher.setTechnology("");

					// send this model class object to database layer
					TeacherDao teacherDao = TeacherDao.geTeacherDao();
					int i = teacherDao.insert(teacher);

					if (i > 0) {
						Util.showMessage(Register.this, "Successfully Register");
						clear();
					} else {
						Util.showMessage(Register.this, "Registered Failed");
					}

				}
			}
		});
	}

	private void clear(){
		tid.setText("");
		tpass.setText("");
		tname.setText("");
	}
	
	private String id, name, pass;

	private boolean valid() {
		// get data from textfield one
		id = tid.getText();
		// get data from passwordfield two
		pass = String.valueOf(tpass.getPassword());
		// get data from textfield third
		name = tname.getText();

		if (id.isEmpty()) {
			Util.showWarning(this, "please enter teacher id");
			tid.requestFocus();
			return false;
		} else if (pass.isEmpty()) {
			Util.showWarning(this, "please enter teacher password");
			tpass.requestFocus();
			return false;
		} else if (name.isEmpty()) {
			Util.showWarning(this, "please enter teacher name");
			tname.requestFocus();
			return false;
		} else {
			return true;
		}
	}

}
