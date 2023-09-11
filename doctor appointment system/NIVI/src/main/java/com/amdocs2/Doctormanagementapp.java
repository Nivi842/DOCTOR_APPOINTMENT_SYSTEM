package com.amdocs2;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.amdocs.dao.Doctordao;
import com.amdocs.dao.impl.DoctorDaoImpl;
import com.amdocs.exceptions.DoctorNotFoundException;
import com.amdocs.model.Doctor;

/**
 * Student App
 *
 */
public class Doctormanagementapp {


	private static Doctordao dao = new DoctorDaoImpl();
	private static Scanner scanner = new Scanner(System.in);
    private static char[] findbydoctor;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("************Enter Your choice************");
			System.out.println("1. for register");
			System.out.println("2. for login");
			System.out.println("3. for choose the doctor");
			System.out.println("4. for book an appointment");
			System.out.println("5. for get an appointment number");
			System.out.println("20. exit");
			int ch = Integer.parseInt(scanner.nextLine());
			switch (ch) {
			case 1:
				System.out.println("****Registration Started****");
				addDoctor();
				System.out.println("****Registration Ended****");
				break;
			case 2:
				System.out.println("****you can now login****");
				login();
				System.out.println("****login done****");
				break;
			case 3:
				System.out.println("****choose the doctor now***");
				displayAllDoctor();
				break;
			case 4:
				findBydoctor();
				System.out.println("****Appointment booked with the choosen doctor by you and note the availabletime****");
				break;
			case 5:
				System.out.println("****your appointment number will share to your mobile no****");
				break;
			case 20:
			    System.out.println("****THANK YOU****");
				System.exit(0);
				break;

			default:
				System.exit(0);
		// TODO Auto-generated method stub

	}

}

	}
	
public static void addDoctor() {
		System.out.println("\nEnter FirstName:");
		String firstName = scanner.nextLine();
		System.out.println("\nEnter LastName:");
		String lastName = scanner.nextLine();
		System.out.println("\nEnter mobile_no:");
		String mobile_no = scanner.nextLine();
		System.out.println("\nEnter Gender:");
		String Gender = scanner.nextLine();
		System.out.println("\nEnter age:");
		int age = Integer.parseInt(scanner.nextLine());
		System.out.println("\nEnter address:");
		String address = scanner.nextLine();
		System.out.println("\nEnter username:");
		String username = scanner.nextLine();
		System.out.println("\nEnter password:");
		String password = scanner.nextLine();
		Doctor doctor = new Doctor(firstName,lastName, mobile_no,Gender,age,address,username,password);
		try {
			if(dao.insert(doctor)) {
				System.out.println("Inserted");
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
	private static void login(){
		System.out.println("\nEnter username for login:");
		String user_name = scanner.nextLine();
		System.out.println("\nEnter password for login:");
		String pass_word = scanner.nextLine();
		
		String extractedPassword = null;
		try {
			extractedPassword = (dao).findByUsername(user_name).getpassword();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(pass_word.equals(extractedPassword)) {
			System.out.println("Successful login");
		}else {
			System.out.println("Login failed");
		}
		
	}

	private static void findBydoctor() {
		System.out.println("\nEnter doctor_name:");
		String doctor_name= scanner.nextLine();
		try {
			Doctor findBydoctor = ( dao).findBydoctor(doctor_name);
			System.out.println(findBydoctor);
		} catch (DoctorNotFoundException | SQLException e) {
			System.err.println(e);
		}
	}

	private static void displayAllDoctor() {
		try {
			List<Doctor> displayAlldoctor = dao.displayAllDoctor();
			for (Doctor doctor : displayAlldoctor) {
				System.out.println(doctor);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
		

}

