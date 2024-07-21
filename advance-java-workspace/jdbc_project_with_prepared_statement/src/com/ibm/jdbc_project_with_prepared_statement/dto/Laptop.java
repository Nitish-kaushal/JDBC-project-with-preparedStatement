package com.ibm.jdbc_project_with_prepared_statement.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Laptop implements Serializable,Comparable<Laptop>,Comparator<Laptop>{
	private int id;
	private String name;
	private String color;
	private double price;
	private LocalDate mfd;
	public Laptop() {
		super();
	}
		public Laptop(int id, String name, String color, double price, LocalDate mfd) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mfd = mfd;
	}
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	//to generate hashcode() and equals() method
	@Override
	public int hashCode() {
		return Objects.hash(color, id, mfd, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(mfd, other.mfd)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	// to generate toString method
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", mfd=" + mfd + "]";
	}
	@Override
	public int compare(Laptop o1, Laptop o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int compareTo(Laptop o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
