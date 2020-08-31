package com.deepsingh44.blogspot.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.deepsingh44.blogspot.dao.TeacherDao;
import com.deepsingh44.blogspot.model.Teacher;
import com.deepsingh44.blogspot.utility.Util;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Profile extends JInternalFrame {
	private JTextField tname;
	private JTextField tid;
	private JTextField ttechnology;
	private JPasswordField tpassword;
	private JTextField timage;

	/**
	 * Create the frame.
	 */
	private String profileimage = null;

	public Profile(Teacher teacher) {
		setTitle("Teacher Profile");
		setIconifiable(true);
		setClosable(true);
		setBounds(150, 10, 566, 470);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 0, 550, 440);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(33, 11, 482, 392);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(21, 11, 141, 119);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		if (!teacher.getImage().equals("")) {
			// teacher

			profileimage = teacher.getImage();
			try {
				URL url = Thread.currentThread().getContextClassLoader().getResource(".");
				File root = new File(url.toURI());
				System.out.println(root);
				String location = root + File.separator + "profile" + File.separator + profileimage;
				System.out.println(location);
				lblNewLabel.setIcon(Util.resize(new ImageIcon(location), 141, 119));
			} catch (Exception e) {
				Util.log(Profile.class, e.toString());
			}

		} else {

			ImageIcon ic = new ImageIcon(Profile.class.getResource("/com/deepsingh44/blogspot/images/student.jpg"));
			lblNewLabel.setIcon(Util.resize(ic, 141, 119));
		}

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Serif", Font.BOLD, 12));
		lblName.setBounds(183, 11, 88, 14);
		panel_1.add(lblName);
		lblName.setForeground(new Color(255, 255, 255));

		tname = new JTextField();
		tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tname.setBounds(183, 29, 267, 30);
		panel_1.add(tname);
		tname.setColumns(10);

		JLabel lblTeacherId = new JLabel("Teacher Id");
		lblTeacherId.setFont(new Font("Serif", Font.BOLD, 12));
		lblTeacherId.setBounds(183, 82, 88, 14);
		panel_1.add(lblTeacherId);
		lblTeacherId.setForeground(Color.WHITE);

		tid = new JTextField();
		tid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tid.setEnabled(false);
		tid.setBounds(183, 100, 267, 30);
		panel_1.add(tid);
		tid.setColumns(10);

		JLabel lblName_1 = new JLabel("Technology");
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblName_1.setBounds(27, 161, 88, 14);
		panel_1.add(lblName_1);

		ttechnology = new JTextField();
		ttechnology.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ttechnology.setColumns(10);
		ttechnology.setBounds(27, 179, 194, 30);
		panel_1.add(ttechnology);

		JLabel lblName_1_1 = new JLabel("Password");
		lblName_1_1.setForeground(Color.WHITE);
		lblName_1_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblName_1_1.setBounds(256, 161, 88, 14);
		panel_1.add(lblName_1_1);

		tpassword = new JPasswordField();
		tpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpassword.setColumns(10);
		tpassword.setBounds(256, 179, 194, 30);
		panel_1.add(tpassword);

		JButton btnUpdateProfile = new JButton("Update Profile");

		btnUpdateProfile.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdateProfile.setForeground(new Color(255, 255, 255));
		btnUpdateProfile.setBackground(new Color(0, 0, 255));
		btnUpdateProfile.setBounds(162, 324, 165, 30);
		panel_1.add(btnUpdateProfile);

		JLabel lblName_1_2 = new JLabel("Upload Profile Image");
		lblName_1_2.setForeground(Color.WHITE);
		lblName_1_2.setFont(new Font("Serif", Font.BOLD, 12));
		lblName_1_2.setBounds(27, 229, 122, 14);
		panel_1.add(lblName_1_2);

		timage = new JTextField();
		timage.setColumns(10);
		timage.setEnabled(false);
		timage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		timage.setBounds(27, 247, 317, 30);
		panel_1.add(timage);

		JButton btnBrowse = new JButton("Browse");

		btnBrowse.setBounds(354, 247, 96, 30);
		panel_1.add(btnBrowse);

		// set all details here of teacher
		tid.setText(String.valueOf(teacher.getId()));
		tname.setText(teacher.getName());
		ttechnology.setText(teacher.getTechnology());
		tpassword.setText(teacher.getPassword());

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				int callback = jFileChooser.showOpenDialog(Profile.this);
				if (callback == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					String filelocation = file.getAbsolutePath();

					try {
						FileInputStream fi = new FileInputStream(filelocation);
						URL url = Thread.currentThread().getContextClassLoader().getResource(".");
						File root = new File(url.toURI());
						File folder = new File(root, "profile");
						folder.mkdir();

						FileOutputStream fo = new FileOutputStream(
								folder.getAbsolutePath() + File.separator + "profile.jpg");
						int i = 0;
						while ((i = fi.read()) != -1) {
							fo.write(i);
						}
						fo.close();
						fi.close();
						profileimage = "profile.jpg";
						timage.setText(filelocation);
					} catch (Exception e) {
						Util.log(Profile.class, e.toString());
					}
				}
			}
		});

		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update image name into database and other information
				if (valid()) {
					TeacherDao teacherDao = TeacherDao.geTeacherDao();
					teacher.setName(name);
					teacher.setPassword(pass);
					teacher.setTechnology(technology);
					teacher.setImage(profileimage);
					int i = teacherDao.update(teacher);
					if (i > 0) {
						Util.showMessage(Profile.this, "Successfully Update");
					} else {
						Util.showError(Profile.this, "Update Failed");
					}
				}

			}
		});

	}

	private String name, technology, pass;

	private boolean valid() {
		name = tname.getText();
		technology = ttechnology.getText();
		pass = String.valueOf(tpassword.getPassword());

		if (name.equals("")) {
			Util.showWarning(Profile.this, "please enter name");
			tname.requestFocus();
			return false;
		} else if (technology.equals("")) {
			Util.showWarning(Profile.this, "please enter technology");
			ttechnology.requestFocus();
			return false;
		} else if (pass.equals("")) {
			Util.showWarning(Profile.this, "please enter password");
			tpassword.requestFocus();
			return false;
		} else {
			return true;
		}
	}

}
