package com.deepsingh44.blogspot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deepsingh44.blogspot.model.Teacher;
import com.deepsingh44.blogspot.utility.Util;

public class TeacherDao {
	private static TeacherDao teacherDao = new TeacherDao();

	public static TeacherDao geTeacherDao(){
		return teacherDao;
	}
	
	private TeacherDao() {
	}

	public int insert(Teacher teacher) {
		int i = 0;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into teacher values(?,?,?,?,?)");
			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getName());
			ps.setString(3, teacher.getPassword());
			ps.setString(4, teacher.getTechnology());
			ps.setString(5, teacher.getImage());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Util.log(TeacherDao.class, e.toString());
		}
		return i;
	}

	public Teacher login(int id, String pass) {
		Teacher teacher = null;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from teacher where id=? and password=?");
			ps.setInt(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setPassword(rs.getString(3));
				teacher.setTechnology(rs.getString(4));
				teacher.setImage(rs.getString(5));
			}
		} catch (Exception e) {
			Util.log(TeacherDao.class, e.toString());
		}
		return teacher;
	}

	public int update(Teacher teacher) {
		int i = 0;
		try (Connection con = MyConnection.getMyConnection();) {
			PreparedStatement ps = con
					.prepareStatement("update teacher set name=?,password=?,technology=?,image=? where id=?");
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getPassword());
			ps.setString(3, teacher.getTechnology());
			ps.setString(4, teacher.getImage());
			ps.setInt(5, teacher.getId());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Util.log(TeacherDao.class, e.toString());
		}
		return i;
	}

}
