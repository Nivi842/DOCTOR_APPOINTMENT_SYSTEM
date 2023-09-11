package com.amdocs.dao;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.exceptions.DoctorNotFoundException;
import com.amdocs.model.Doctor;

public interface Doctordao {
	
	Doctor findBydoctor(String doctor_name) throws DoctorNotFoundException, SQLException; 
	
	boolean insert(Doctor doctor) throws SQLException;

	List<Doctor> displayAllDoctor() throws SQLException;

	Doctor findByUsername(String user_name) throws DoctorNotFoundException, SQLException;



	

	


	
	


}
