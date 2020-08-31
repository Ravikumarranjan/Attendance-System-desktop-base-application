package com.deepsingh44.blogspot.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.blogspot.dao.TeacherDao;
import com.deepsingh44.blogspot.model.Teacher;
import com.deepsingh44.blogspot.utility.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tid;
	private JPasswordField tpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		Util.setLookAndFeel();
		// setUndecorated(true);
		setTitle("Teacher Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 456);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 0));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(25, 52, 227, 336);
		contentPane.add(panel);
		panel.setLayout(null);

		ImageIcon im = new ImageIcon(Login.class.getResource("/com/deepsingh44/blogspot/images/college.jpg"));

		JLabel label = new JLabel(Util.resize(im, 207, 169));
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label.setBounds(10, 11, 207, 169);
		panel.add(label);

		JLabel lblThisIsAn = new JLabel(
				"<html> With the App, teachers can mark attendance of students in their class in no time, without any paperwork. ... Using the app, the teachers can actively engage parents to participate more in their ward's scholastic activities, on a daily basis. </html>",
				JLabel.CENTER);
		lblThisIsAn.setFont(new Font("Serif", Font.PLAIN, 12));
		lblThisIsAn.setForeground(new Color(255, 255, 255));
		lblThisIsAn.setBorder(null);
		lblThisIsAn.setVerticalAlignment(JLabel.TOP);
		lblThisIsAn.setBounds(10, 191, 207, 134);
		panel.add(lblThisIsAn);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(281, 52, 274, 336);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEnterTeacherId = new JLabel("Enter Teacher ID");
		lblEnterTeacherId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterTeacherId.setForeground(Color.WHITE);
		lblEnterTeacherId.setBounds(24, 80, 106, 14);
		panel_1.add(lblEnterTeacherId);

		tid = new JTextField();
		tid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tid.setBounds(24, 96, 220, 30);
		panel_1.add(tid);
		tid.setColumns(10);

		tpass = new JPasswordField();
		tpass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpass.setColumns(10);
		tpass.setBounds(24, 156, 220, 30);
		panel_1.add(tpass);

		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setBounds(24, 140, 106, 14);
		panel_1.add(lblEnterPassword);

		JCheckBox chckbxForgetPassword = new JCheckBox("Forget Password");
		chckbxForgetPassword.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		/*
		 * chckbxForgetPassword.setBackground(new Color(0.0f, 0.0f, 0.0f,
		 * 0.5f));
		 */
		chckbxForgetPassword.setForeground(new Color(255, 255, 255));
		chckbxForgetPassword.setBounds(115, 197, 129, 23);
		panel_1.add(chckbxForgetPassword);

		JButton btnLoginHere = new JButton("Singin");

		btnLoginHere.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLoginHere.setForeground(Color.WHITE);
		btnLoginHere.setBackground(Color.BLUE);
		btnLoginHere.setBounds(10, 278, 119, 30);
		panel_1.add(btnLoginHere);

		JLabel lblLoginDetails = new JLabel("<html><u>Login Details</u></html>");
		lblLoginDetails.setForeground(new Color(255, 255, 255));
		lblLoginDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginDetails.setBounds(89, 24, 92, 14);
		panel_1.add(lblLoginDetails);

		JButton btnSignup = new JButton("Signup");
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignup.setBackground(new Color(0, 153, 51));
		btnSignup.setBounds(145, 278, 119, 30);
		panel_1.add(btnSignup);
		ImageIcon ic = new ImageIcon(Login.class.getResource("/com/deepsingh44/blogspot/images/group.jpg"));

		JLabel lblNewLabel = new JLabel(Util.resize(ic, 604, 456));
		lblNewLabel.setBounds(0, 0, 604, 456);
		contentPane.add(lblNewLabel);

		// add event here

		// login button click code
		btnLoginHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get value from field first
				if (valid()) {
					// after validation check teacher is valid or not from
					// database

					TeacherDao td=TeacherDao.geTeacherDao();
					Teacher teacher=td.login(Integer.parseInt(id), pass);
					
					if(teacher!=null){
						Util.showMessage(Login.this, "Successfully login");
						HomePage hp=new HomePage(teacher);
						hp.setVisible(true);
						dispose();
					}else{
						Util.showError(Login.this, "Login failed");
					}
				}

			}
		});

		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
			}
		});

	}

	private String id, pass;

	private boolean valid() {
		id = tid.getText();
		pass = String.valueOf(tpass.getPassword());

		if (id.isEmpty()) {
			Util.showWarning(this, "please enter id");
			tid.requestFocus();
			return false;
		} else if (pass.isEmpty()) {
			Util.showWarning(this, "please enter password");
			tpass.requestFocus();
			return false;
		} else {
			return true;
		}
	}
}
