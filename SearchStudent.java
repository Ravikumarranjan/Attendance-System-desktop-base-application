package com.deepsingh44.blogspot.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import com.deepsingh44.blogspot.dao.StudentDao;
import com.deepsingh44.blogspot.model.Batch;
import com.deepsingh44.blogspot.model.Student;
import com.deepsingh44.blogspot.utility.Util;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SearchStudent extends JInternalFrame {
	private JTextField tnameorid;
	private StudentDao studentDao = new StudentDao();

	private JLabel tavgpercentage, timage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudent frame = new SearchStudent();
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
	public SearchStudent() {
		setIconifiable(true);
		setTitle("Search Student");
		setClosable(true);
		setBounds(150, 10, 566, 470);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 11, 530, 60);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEnterId = new JLabel("Enter Id / Name");
		lblEnterId.setFont(new Font("Serif", Font.BOLD, 12));
		lblEnterId.setBounds(34, 12, 109, 30);
		panel_1.add(lblEnterId);

		tnameorid = new JTextField();
		tnameorid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tnameorid.setBounds(153, 12, 248, 30);
		panel_1.add(tnameorid);
		tnameorid.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnNewButton.setBounds(431, 11, 89, 30);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 82, 530, 347);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblName = new JLabel("Student Detail", JLabel.CENTER);
		lblName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblName.setFont(new Font("Serif", Font.BOLD, 12));
		lblName.setBounds(277, 29, 230, 30);
		panel_2.add(lblName);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(34, 29, 233, 248);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		timage = new JLabel();

		timage.setBounds(41, 11, 150, 150);
		panel_3.add(timage);

		tavgpercentage = new JLabel("Average Percentage", JLabel.CENTER);
		tavgpercentage.setFont(new Font("Serif", Font.BOLD, 14));
		tavgpercentage.setBounds(51, 189, 133, 26);
		panel_3.add(tavgpercentage);

		JLabel lblEmail_3 = new JLabel("Batch Detail", SwingConstants.CENTER);
		lblEmail_3.setFont(new Font("Serif", Font.BOLD, 12));
		lblEmail_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblEmail_3.setBounds(277, 157, 230, 30);
		panel_2.add(lblEmail_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(277, 61, 230, 87);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel tid = new JLabel("ID");
		tid.setBounds(10, 11, 117, 14);
		panel_4.add(tid);

		JLabel tname = new JLabel("Name");
		tname.setBounds(10, 36, 117, 14);
		panel_4.add(tname);

		JLabel temail = new JLabel("Email");
		temail.setBounds(10, 61, 117, 14);
		panel_4.add(temail);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4_1.setBounds(277, 190, 230, 87);
		panel_2.add(panel_4_1);
		panel_4_1.setLayout(null);

		JLabel ttime = new JLabel("Time");
		ttime.setBounds(10, 11, 117, 14);
		panel_4_1.add(ttime);

		JLabel tcourse = new JLabel("Course");
		tcourse.setBounds(10, 35, 117, 14);
		panel_4_1.add(tcourse);

		JLabel ttype = new JLabel("Type");
		ttype.setBounds(10, 59, 117, 14);
		panel_4_1.add(ttype);

		JButton btnNewButton_1 = new JButton("More Attendance Detail");

		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(182, 299, 185, 30);
		panel_2.add(btnNewButton_1);

		// add event here
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (valid()) {

					Student student = studentDao.findStudent(name_or_id);
					if (student != null) {

						tid.setText(student.getId());
						tname.setText(student.getName());
						temail.setText(student.getEmail());
						Batch batch = student.getBatch();
						tcourse.setText(batch.getCourse());
						ttime.setText(batch.getTime());
						ttype.setText(batch.getType());

						calculatePercentage(student);

					} else {
						Util.showError(SearchStudent.this, "This id or name is not exist.");
					}
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (sb != null) {
					JDialog jDialog = new JDialog();
					jDialog.setSize(250, 300);
					jDialog.setLocationRelativeTo(SearchStudent.this);

					JTextArea textArea = new JTextArea();
					jDialog.add(textArea);
					
					textArea.setText(sb.toString());

					jDialog.setVisible(true);

				} else {
					Util.showWarning(SearchStudent.this, "please find a student first");
				}
			}
		});

	}

	private StringBuffer sb;

	private void calculatePercentage(Student student) {
		// read data from file
		try {

			URL url = Thread.currentThread().getContextClassLoader().getResource(".");
			File root = new File(url.toURI());
			String location = root + File.separator + "attendancesheet" + File.separator + student.getId()
					+ File.separator + student.getId() + ".txt";
			BufferedReader br = new BufferedReader(new FileReader(location));

			int totaldays = 0;
			String line = br.readLine();

			int count = 0;
			sb = new StringBuffer();
			while (line != null) {
				sb.append(line).append("\n");
				totaldays++;
				String words[] = line.split(":");
				if (words[1].equalsIgnoreCase("true")) {
					count++;
				}
				line = br.readLine();
			}

			int per = count * 100 / totaldays;

			if (per >= 75) {
				ImageIcon icon = new ImageIcon(
						SearchStudent.class.getResource("/com/deepsingh44/blogspot/images/good.jpg"));
				timage.setIcon(Util.resize(icon, 150, 150));
			} else {
				ImageIcon icon = new ImageIcon(
						SearchStudent.class.getResource("/com/deepsingh44/blogspot/images/bad.jpg"));
				timage.setIcon(Util.resize(icon, 150, 150));
			}
			tavgpercentage.setText(String.valueOf(per) + "%");

		} catch (Exception e) {
			Util.log(SearchStudent.class, e.toString());
		}
	}

	private String name_or_id;

	private boolean valid() {
		name_or_id = tnameorid.getText();
		if (name_or_id.equals("")) {
			Util.showWarning(SearchStudent.this, "please enter name or id of student.");
			tnameorid.requestFocus();
			return false;
		} else {
			return true;
		}
	}
}
