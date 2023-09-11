package com.amdocs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.dao.Doctordao;
import com.amdocs.exceptions.DoctorNotFoundException;
import com.amdocs.model.Doctor;
import amdocs_utilities.Databaseconnection;
public class DoctorDaoImpl implements Doctordao {
	private final static String SELECT_ALL = "SELECT * FROM doctors";
	private final static String SELECT_BY_doctor = "SELECT * FROM doctors WHERE doctor_name=?";
	private final static String INSERT = "insert into patient_details (FirstName,LastName,mobile_no,Gender,age,Address,username,password) values(?,?,?,?,?,?,?,?)";
	private final static String SELECT_BY_username = "SELECT * FROM patient_details WHERE username = ?";

	private Connection connection = Databaseconnection.getConnection();

	@Override
	public List<Doctor> displayAllDoctor() throws SQLException {
		List<Doctor> Doctors = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_ALL);
		while (rs.next()) {
			Doctor doctor = new Doctor();
			// Reading the data from the row and setting the data to doctor object
			doctor.sets_no(rs.getInt("s_no"));
			doctor.setdoctor_name(rs.getString("doctor_name"));
			doctor.setavaialabletime(rs.getString("avaialabletime"));
		    doctor.setdoctor_mobile_no(rs.getString("doctor_mobile_no"));
			Doctors.add(doctor);
		}
		rs.close();
		stmt.close();
		return Doctors;
	}

	@Override
	public Doctor findBydoctor(String doctor_name) throws DoctorNotFoundException, SQLException {
		Doctor doctor =null;
		PreparedStatement stmt = connection.prepareStatement(SELECT_BY_doctor);
		stmt.setString(1, doctor_name);
		ResultSet rs = stmt.executeQuery();
		System.out.println("Rs  : "  + rs);
		if(rs.next()) {
			doctor = new Doctor();
			// Reading the data from the row and seting the data to doctor object
			doctor.sets_no(rs.getInt("s_no"));
			doctor.setdoctor_name(rs.getString("doctor_name"));
			doctor.setavaialabletime(rs.getString("avaialabletime"));
			doctor.setdoctor_mobile_no(rs.getString("doctor_mobile_no"));
		}else {
			throw new DoctorNotFoundException("Doctor Not Found With time: " + doctor_name);
		}
		rs.close();
		stmt.close();
		return doctor;
	}
	@Override
	public boolean insert(Doctor doctor) throws SQLException {
		boolean result=false;
		PreparedStatement stmt = connection.prepareStatement(INSERT);
		stmt.setString(1,doctor.getFirstName() );
		stmt.setString(2,doctor.getLastName() );
		stmt.setString(3,doctor.getMobile_no() );
		stmt.setString(4,doctor.getGender() );
		stmt.setInt(5,doctor.getage() );
		stmt.setString(6,doctor.getAddress() );
		stmt.setString(7,doctor.getusername() );
		stmt.setString(8,doctor.getpassword() );
		if(stmt.executeUpdate()>0) {
			result = true;
		}
		stmt.close();
		return result;
	}

	@Override
	public Doctor findByUsername(String user_name) throws DoctorNotFoundException, SQLException {
		Doctor doctor =null;
		PreparedStatement stmt = connection.prepareStatement(SELECT_BY_username);
		stmt.setString(1, user_name);
		ResultSet rs = stmt.executeQuery();
		System.out.println("Rs  : "  + rs);
		if(rs.next()) {
			doctor = new Doctor();
			// Reading the data from the row and seting the data to doctor object
			doctor.setFirstName(rs.getString("FirstName"));
			doctor.setLastName(rs.getString("LastName"));												
			doctor.setmobile_no(rs.getString("mobile_no"));
			doctor.setGender(rs.getString("Gender"));
			doctor.setage(rs.getInt("age"));
			doctor.setAddress(rs.getString("Address"));
			doctor.setusername(rs.getString("username"));
			doctor.setpassword(rs.getString("password"));
			
		}else {
			throw new DoctorNotFoundException("WRONG CREDENTIALS");
		}
		rs.close();
		stmt.close();
		return doctor;
	}

	
	

}
