package com.amdocs.model;

public class Doctor {
		private String firstName;
		private String lastName;
		private String mobile_no;
		private String Gender;
		private int age;
		private String Address;
		private String username;
		private String password;
		private String user_name;
		private String pass_word;
		private int s_no;
		private String doctor_name;
		private String doctor_mobile_no;
		private String avaialabletime;
		public Doctor( String firstName, String lastName, String mobile_no,String Gender,int age, String Address,String username,String password,String user_name,String pass_word,int s_no,String doctor_name,String avaialabletime,String doctor_mobile_no ) {		
			this.firstName = firstName;
			this.lastName = lastName;
			this.mobile_no= mobile_no;
			this.Gender=Gender;
			this.age= age;
			this.Address = Address;
			this.username = username;
			this.password = password;
			this.user_name = user_name;
			this.pass_word = pass_word;
			this.s_no=s_no;
			this.doctor_name=doctor_name;
			this.avaialabletime=avaialabletime;
			this.doctor_mobile_no=doctor_mobile_no;
			

	 }

		public Doctor() {
			// TODO Auto-generated constructor stub
		}

		public Doctor(String firstName2, String lastName2, String mobile_no2, String gender2, int age2, String address2,
				String username2, String password2) {
			this.firstName = firstName2;
			this.lastName = lastName2;
			this.mobile_no = mobile_no2;
			this.Gender = gender2;
			this.age = age2;
			this.Address = address2;
			this.username = username2;
			this.password = password2;
			
		}

		

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getMobile_no() {
			return mobile_no;
		}

		public void setmobile_no(String mobile_no) {
			this.mobile_no = mobile_no;
		}

		public String getGender() {
			return Gender;
		}
		public void setGender(String Gender) {
			this.Gender = Gender;
		}
		public int getage() {
			return age;
		}
		public void setage(int age) {
			this.age = age;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String Address) {
			this.Address = Address;
		}
		public String getusername() {
			return username;
		}
		public void setusername(String username) {
			this.username = username;
		}
		public String getpassword() {
			return password;
		}
		public void setpassword(String password) {
			this.password = password;
		}
		public String getuser_name() {
			return user_name;
		}
		public void setuser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getpass_word() {
			return pass_word;
		}
		public void setpass_word(String pass_word) {
			this.pass_word = pass_word;
		}
		public int gets_no() {
			return s_no;
		}
		public void sets_no(int s_no) {
			this.s_no = s_no;
		}
		public String getdoctor_name() {
			return doctor_name;
		}
		public void setdoctor_name(String doctor_name) {
			this.doctor_name = doctor_name;
		}
		public String getavaialabletime() {
			return avaialabletime;
		}
		public void setavaialabletime(String avaialabletime) {
			this.avaialabletime = avaialabletime;
		}
		public String getdoctor_mobile_no() {
			return doctor_mobile_no;
		}
		public void setdoctor_mobile_no(String doctor_mobile_no) {
			this.doctor_mobile_no = doctor_mobile_no;
		}
		
		
		@Override
		public String toString() {
			return "doctor [s_no=" + s_no + ", doctor_name=" + doctor_name + ", avaialabletime=" + avaialabletime + " ,doctor_mobile_no="+doctor_mobile_no+"]";
		}

	
		


}
