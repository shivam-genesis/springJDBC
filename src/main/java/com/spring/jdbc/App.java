package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {

		System.out.println("Program Started!!");
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

		Student student = new Student();
		// Insert
		// student.setId(1);
		// student.setName("Shivam Yadav");
		// student.setCity("Ghaziabad");

		// Update
		// student.setId(2);
		// student.setName("Ayush Sharma");
		// student.setCity("Noida");
		// int result = studentDao.change(student);
		// System.out.println(result);

		// Delete
		// int result = studentDao.delete(3);

		// Select
		// Student student = studentDao.getStudent(1);

		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}

		// System.out.println(student);
	}
}