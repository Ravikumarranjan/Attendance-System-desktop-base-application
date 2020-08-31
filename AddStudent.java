package com.deepsingh44.blogspot.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.deepsingh44.blogspot.dao.StudentDao;
import com.deepsingh44.blogspot.model.Batch;
import com.deepsingh44.blogspot.model.Student;
import com.deepsingh44.blogspot.utility.Util;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class AddStudent extends JInternalFrame {
	
	private JTextField tname;
	private JTextField tid;
	private JTextField temail;

	private JComboBox tcourse, thours, tmin, ttype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setTitle("Add Student");
		setIconifiable(true);
		setClosable(true);
		setBounds(150, 10, 566, 470);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 21, 212, 397);
		getContentPane().add(panel);
		panel.setLayout(null);

		ImageIcon ic = new ImageIcon(AddStudent.class.getResource("/com/deepsingh44/blogspot/images/student.jpg"));
		JLabel lblNewLabel_3 = new JLabel(Util.resize(ic, 169, 152));
		lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_3.setBounds(20, 21, 169, 152);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("<html><u>Add Student Details</u></html>", JLabel.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setBorder(null);
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_4.setBounds(41, 184, 130, 21);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(
				"<html>Add students to a class team you've already created. You'll also be able to choose if they should receive past assignments in the class. If you're having trouble adding students to your class, check with your IT Admin to make sure you have the right permissions.</html>");
		lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 12));
		lblNewLabel_5.setVerticalAlignment(JLabel.TOP);
		lblNewLabel_5.setBounds(20, 216, 182, 147);
		panel.add(lblNewLabel_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(232, 21, 308, 397);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Name");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(33, 24, 75, 14);
		panel_1.add(lblNewLabel);

		tname = new JTextField();
		tname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tname.setBounds(33, 39, 235, 30);
		panel_1.add(tname);
		tname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter Id");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(33, 80, 75, 14);
		panel_1.add(lblNewLabel_1);

		tid = new JTextField();
		tid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tid.setColumns(10);
		tid.setBounds(33, 95, 235, 30);
		panel_1.add(tid);

		JLabel lblNewLabel_2 = new JLabel("Enter Email");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(33, 136, 75, 14);
		panel_1.add(lblNewLabel_2);

		temail = new JTextField();
		temail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		temail.setColumns(10);
		temail.setBounds(33, 151, 235, 30);
		panel_1.add(temail);

		JLabel lblNewLabel_2_1 = new JLabel("Batch Time");
		lblNewLabel_2_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(33, 192, 75, 14);
		panel_1.add(lblNewLabel_2_1);

		thours = new JComboBox();
		thours.setModel(new DefaultComboBoxModel(Util.HOUR));
		thours.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		thours.setBounds(33, 207, 106, 30);
		panel_1.add(thours);

		tmin = new JComboBox();
		tmin.setModel(new DefaultComboBoxModel(Util.MIN));
		tmin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tmin.setBounds(162, 207, 106, 30);
		panel_1.add(tmin);

		JLabel lblNewLabel_2_1_1 = new JLabel("Batch Type");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(33, 249, 75, 14);
		panel_1.add(lblNewLabel_2_1_1);

		ttype = new JComboBox();
		ttype.setModel(new DefaultComboBoxModel(Util.TYPE));
		ttype.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ttype.setBounds(33, 264, 106, 30);
		panel_1.add(ttype);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Course");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(162, 248, 75, 14);
		panel_1.add(lblNewLabel_2_1_1_1);

		tcourse = new JComboBox();
		tcourse.setModel(new DefaultComboBoxModel(Util.COURSE));
		tcourse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tcourse.setBounds(162, 263, 106, 30);
		panel_1.add(tcourse);

		JButton btnNewButton = new JButton("Add Student");

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 204));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBounds(70, 317, 167, 30);
		panel_1.add(btnNewButton);

		// add event here
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (valid()) {

					// compose data to model class

					Batch batch = new Batch();
					batch.setCourse(course);
					batch.setTime(time);
					batch.setType(type);

					Student student = new Student();
					student.setId(id);
					student.setName(name);
					student.setEmail(email);
					student.setStatus(true);
					// batch associated with student
					student.setBatch(batch);

					// to store these data into database

					StudentDao sd = new StudentDao();
					int i = sd.insert(student);

					if (i > 0) {

						URL url = Thread.currentThread().getContextClassLoader().getResource(".");
						try {
							File root = new File(url.toURI());

							File folder = new File(root, "attendancesheet");
							folder.mkdir();

							File stdid = new File(folder, id);
							stdid.mkdir();

							File file = new File(stdid, id + ".txt");
							file.createNewFile();

							Util.showMessage(AddStudent.this, "Successfully Student Added");
							clear();
						} catch (Exception e) {
							Util.log(AddStudent.class, e.toString());
						}
					} else {
						Util.showError(AddStudent.this, "Student Added Failed");
					}

				}
			}
		});

	}

	private void clear(){
		tid.setText("");
		tname.setText("");
		temail.setText("");
		tcourse.setModel(new DefaultComboBoxModel(Util.COURSE));
		ttype.setModel(new DefaultComboBoxModel(Util.TYPE));
		thours.setModel(new DefaultComboBoxModel(Util.HOUR));
		tmin.setModel(new DefaultComboBoxModel(Util.MIN));
	}
	
	private String name, id, email, time, type, course;

	private boolean valid() {
		name = tname.getText();
		id = tid.getText();
		email = temail.getText();
		String h = thours.getSelectedItem().toString();
		String m = tmin.getSelectedItem().toString();
		time = h + ":" + m;
		type = ttype.getSelectedItem().toString();
		course = tcourse.getSelectedItem().toString();

		if (name.isEmpty()) {
			Util.showWarning(this, "please enter name");
			tname.requestFocus();
			return false;
		} else if (id.isEmpty()) {
			Util.showWarning(this, "please enter id");
			tid.requestFocus();
			return false;
		} else if (email.isEmpty()) {
			Util.showWarning(this, "please enter email");
			temail.requestFocus();
			return false;
		} else if (h.equalsIgnoreCase("hour")) {
			Util.showWarning(this, "please select hour");
			thours.requestFocus();
			return false;
		} else if (m.equalsIgnoreCase("min")) {
			Util.showWarning(this, "please select minute");
			tmin.requestFocus();
			return false;
		} else if (type.equalsIgnoreCase("type")) {
			Util.showWarning(this, "please select type");
			ttype.requestFocus();
			return false;
		} else if (course.equalsIgnoreCase("course")) {
			Util.showWarning(this, "please select course");
			tcourse.requestFocus();
			return false;
		} else {
			return true;
		}

	}
}
