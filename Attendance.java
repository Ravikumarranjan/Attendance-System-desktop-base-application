package com.deepsingh44.blogspot.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.deepsingh44.blogspot.dao.BatchDao;
import com.deepsingh44.blogspot.model.Batch;
import com.deepsingh44.blogspot.model.Student;
import com.deepsingh44.blogspot.utility.Util;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.sql.Date;

public class Attendance extends JInternalFrame {
	private JTable table;
	private JComboBox ttype, thour, tcourse, tmin;
	private List<Student> students = new ArrayList<Student>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance() {
		setIconifiable(true);
		setTitle("Student Attendance");
		setClosable(true);
		setBounds(150, 10, 566, 470);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 0, 550, 440);
		getContentPane().add(panel);
		panel.setLayout(null);
		String[] cols = { "ID", "NAME", "STATUS" };
		DefaultTableModel dt = new DefaultTableModel(cols, 0);

		table = new JTable(dt) {
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				default:
					return Boolean.class;
				}
			}
		};

		JScrollPane jp = new JScrollPane(table);
		jp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jp.setBounds(242, 11, 298, 376);
		panel.add(jp);

		JButton btnSelectAll = new JButton("Submit");

		btnSelectAll.setFont(new Font("Serif", Font.BOLD, 12));
		btnSelectAll.setForeground(new Color(255, 255, 255));
		btnSelectAll.setBackground(new Color(0, 102, 204));
		btnSelectAll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSelectAll.setBounds(405, 399, 135, 30);
		panel.add(btnSelectAll);

		JButton btnSelectAll_1 = new JButton("Select All");

		btnSelectAll_1.setFont(new Font("Serif", Font.BOLD, 12));
		btnSelectAll_1.setForeground(new Color(255, 255, 255));
		btnSelectAll_1.setBackground(new Color(204, 0, 0));
		btnSelectAll_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSelectAll_1.setBounds(242, 399, 135, 30);
		panel.add(btnSelectAll_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setBounds(10, 11, 222, 376);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Batch Time");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 131, 75, 14);
		panel_1.add(lblNewLabel_2_1);

		thour = new JComboBox();
		thour.setModel(new DefaultComboBoxModel(Util.HOUR));
		thour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		thour.setBounds(10, 146, 100, 30);
		panel_1.add(thour);

		tmin = new JComboBox();
		tmin.setModel(new DefaultComboBoxModel(Util.MIN));
		tmin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tmin.setBounds(120, 146, 81, 30);
		panel_1.add(tmin);

		JLabel lblNewLabel_2_1_1 = new JLabel("Batch Type");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 188, 75, 14);
		panel_1.add(lblNewLabel_2_1_1);

		ttype = new JComboBox();
		ttype.setModel(new DefaultComboBoxModel(Util.TYPE));
		ttype.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ttype.setBounds(10, 203, 190, 30);
		panel_1.add(ttype);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Course");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 75, 75, 14);
		panel_1.add(lblNewLabel_2_1_1_1);

		tcourse = new JComboBox();
		tcourse.setModel(new DefaultComboBoxModel(Util.COURSE));
		tcourse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tcourse.setBounds(10, 90, 190, 30);
		panel_1.add(tcourse);

		JLabel lblBatchDetail = new JLabel("Batch Detail", JLabel.CENTER);
		lblBatchDetail.setForeground(new Color(255, 255, 255));
		lblBatchDetail.setFont(new Font("Serif", Font.BOLD, 14));
		lblBatchDetail.setBounds(57, 30, 100, 19);
		panel_1.add(lblBatchDetail);

		JButton btnGetStudents = new JButton("Get Students");

		btnGetStudents.setBackground(new Color(0, 102, 204));
		btnGetStudents.setForeground(new Color(255, 255, 255));
		btnGetStudents.setFont(new Font("Serif", Font.BOLD, 12));
		btnGetStudents.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGetStudents.setBounds(29, 276, 157, 30);
		panel_1.add(btnGetStudents);

		// add event task here
		btnGetStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (valid()) {

					// search student from database based on course type and
					// time.
					BatchDao batchDao = new BatchDao();
					students = batchDao.getBatchStudents(course, time, type);

					if (students.size() > 0) {
						for (Student student : students) {
							// Batch batch=student.getBatch();
							// System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getEmail()+"\t"+batch.getTime()+"\t"+batch.getType()+"\t"+batch.getCourse());

							dt.addRow(new String[] { student.getId(), student.getName(), null });

						}
					} else {
						Util.showMessage(Attendance.this, "Sorry there is no student");
					}

				}
			}
		});

		btnSelectAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// checked all student here

				if (btnSelectAll_1.getText().equalsIgnoreCase("select all")) {
					btnSelectAll_1.setText("Deselect All");
					if (students.size() > 0) {

						for (Student student : students) {
							student.setStatus(true);
						}
						removeTableData();
						addStudent(students);

					}
				} else {
					btnSelectAll_1.setText("Select All");
					if (students.size() > 0) {

						for (Student student : students) {
							student.setStatus(false);
						}
						removeTableData();
						addStudent(students);

					}
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dt = (DefaultTableModel) table.getModel();

				String student_id = (String) dt.getValueAt(table.getSelectedRow(), 0);
				Optional<Student> std = students.stream().filter(x -> x.getId().equals(student_id)).findAny();
				std.get().setStatus(true);
				
			}
		});

		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				if (students.size() > 0) {

					for (Student student : students) {
						if (student.isStatus()) {
							count++;
						}

					}
					int callback=JOptionPane.showConfirmDialog(Attendance.this,
							"Are you sure you have " + count + " number of student");
					
					//in student file we need to update attendance
					/*6/20/2020 : true
					7/20/2020 : true*/
					if(callback==0){
					URL url = Thread.currentThread().getContextClassLoader().getResource(".");
					try{
						File file=new File(url.toURI());
					
						for (Student student : students) {
							BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file+File.separator+"attendancesheet"+File.separator+student.getId()+File.separator+student.getId()+".txt",true));
							String line=new Date(System.currentTimeMillis())+":"+student.isStatus();
							bufferedWriter.write(line);
							bufferedWriter.newLine();
							bufferedWriter.flush();
							bufferedWriter.close();		
						}
						
						Util.showMessage(Attendance.this, "Successfully Attendance Update");
						
					}catch (Exception e) {
						Util.log(Attendance.class, e.toString());
					}
					
					}
				} else {
					Util.showWarning(Attendance.this, "Sorry there is no student");
				}
			}
		});

	}

	private void addStudent(List<Student> students) {
		for (Student student : students) {
			DefaultTableModel dt = (DefaultTableModel) table.getModel();
			dt.addRow(new Object[] { student.getId(), student.getName(), student.isStatus() });
		}
	}

	private void removeTableData() {
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		int allrows = dt.getRowCount();
		if (allrows > 0) {
			for (int i = allrows - 1; i >= 0; i--) {
				dt.removeRow(i);
			}
		}
	}

	private String time, type, course;

	private boolean valid() {
		course = tcourse.getSelectedItem().toString();
		String h = thour.getSelectedItem().toString();
		String m = tmin.getSelectedItem().toString();
		type = ttype.getSelectedItem().toString();

		if (course.equalsIgnoreCase("course")) {
			Util.showWarning(Attendance.this, "please select course");
			tcourse.requestFocus();
			return false;
		} else if (h.equalsIgnoreCase("hour")) {
			Util.showWarning(Attendance.this, "please select hour");
			thour.requestFocus();
			return false;
		} else if (m.equalsIgnoreCase("min")) {
			Util.showWarning(Attendance.this, "please select minute");
			tmin.requestFocus();
			return false;
		} else if (type.equalsIgnoreCase("type")) {
			Util.showWarning(Attendance.this, "please select type");
			ttype.requestFocus();
			return false;
		} else {
			time = h + ":" + m;
			return true;
		}
	}
}
