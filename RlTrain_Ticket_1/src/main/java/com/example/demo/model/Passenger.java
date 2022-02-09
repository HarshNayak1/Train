package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Passenger;

@Entity
public class Passenger implements Comparable<Passenger> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	
	
	private  String name;
	
	private char gender;
	
	private int age;
	
	public Passenger() {
		
	}

	public Passenger(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Passenger passenger) {

		return this.getAge() - passenger.getAge();
	}

	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", passenger_name=" + name + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	
}
