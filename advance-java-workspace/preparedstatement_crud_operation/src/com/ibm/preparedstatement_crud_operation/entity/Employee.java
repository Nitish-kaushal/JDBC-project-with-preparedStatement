package com.ibm.preparedstatement_crud_operation.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

	public class Employee implements Serializable{
		private int id;
		private String name;
		private String email;
		private Long phone;
		private LocalDate doj;
		//constructor ⌘N 
		public Employee() {
			super();
		}
		
		public Employee(int id, String name, String email, long phone, LocalDate doj) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone= phone;
			this.doj = doj;
		}
		/*
		 *@nitish kaushal
		 */
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getPhone() {
			return phone;
		}
		public void setPhone(Long phone) {
			this.phone = phone;
		}
		public LocalDate getDoj() {
			return doj;
		}
		public void setDoj(LocalDate doj) {
			this.doj = doj;
		}
		@Override
		public int hashCode() {
			return Objects.hash(id, name, email, phone, doj);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return Objects.equals(doj, other.doj) && Objects.equals(email, other.email) && id == other.id
					&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
		}
		//toString() method 
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", doj=" + doj + "]";
		}
	
		}
		

