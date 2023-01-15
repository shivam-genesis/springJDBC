package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int change(Student student) {
		String query = "update student set name=?,city=? where id=?";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query, studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// select all student data
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}