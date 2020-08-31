package com.deepsingh44.blogspot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deepsingh44.blogspot.model.Batch;
import com.deepsingh44.blogspot.model.Student;
import com.deepsingh44.blogspot.utility.Util;

public class StudentDao {
	private BatchDao batchDao = new BatchDao();
	private static StudentDao studentDao = new StudentDao();

	public static StudentDao getStudentDao() {
		return studentDao;
	}

	public int insert(Student student) {
		int i = 0;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setBoolean(4, student.isStatus());

			int bi = BatchDao.getBatchDao().insert(student.getId(), student.getBatch());

			if (bi > 0) {
				i = ps.executeUpdate();
			}

		} catch (Exception e) {
			Util.log(StudentDao.class, e.toString());
		}
		return i;
	}

	public Student getStudentById(String id) {
		Student student = null;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from student where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(id);
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStatus(false);
			}
		} catch (Exception e) {
			Util.log(StudentDao.class, e.toString());
		}
		return student;
	}

	public Student findStudent(String name_or_id) {
		Student student = null;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from student where id=? or name like ?");
			ps.setString(1, name_or_id);
			ps.setString(2, name_or_id + "%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStatus(false);
				Batch batch = batchDao.getBatch(student.getId());
				student.setBatch(batch);
			}
		} catch (Exception e) {
			Util.log(StudentDao.class, e.toString());
		}
		return student;

	}

}
