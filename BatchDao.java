package com.deepsingh44.blogspot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deepsingh44.blogspot.model.Batch;
import com.deepsingh44.blogspot.model.Student;
import com.deepsingh44.blogspot.utility.Util;

public class BatchDao {
	private static BatchDao batchDao = new BatchDao();

	public static BatchDao getBatchDao() {
		return batchDao;
	}

	public int insert(String id, Batch batch) {
		int i = 0;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into batch values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, batch.getTime());
			ps.setString(3, batch.getType());
			ps.setString(4, batch.getCourse());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Util.log(Batch.class, e.toString());
		}
		return i;
	}

	public List<Student> getBatchStudents(String course, String time, String type) {
		List<Student> students = new ArrayList<>();
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from batch where time=? and type=? and course=?");
			ps.setString(1, time);
			ps.setString(2, type);
			ps.setString(3, course);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Batch batch = new Batch();
				batch.setStudent_id(rs.getString(1));
				batch.setType(type);
				batch.setCourse(course);
				batch.setTime(time);

				Student student = StudentDao.getStudentDao().getStudentById(batch.getStudent_id());
				student.setBatch(batch);
				students.add(student);
			}

		} catch (Exception e) {
			Util.log(BatchDao.class, e.toString());
		}
		return students;
	}

	public Batch getBatch(String id) {
		Batch batch = null;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from batch where student_id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				batch = new Batch();
				batch.setStudent_id(rs.getString(1));
				batch.setType(rs.getString(2));
				batch.setCourse(rs.getString(3));
				batch.setTime(rs.getString(4));
			}

		} catch (Exception e) {
			Util.log(BatchDao.class, e.toString());
		}
		return batch;

	}
}
