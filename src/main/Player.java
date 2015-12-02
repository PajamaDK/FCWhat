package main;

public class Player {
	
	private String id,name;
	private double salary;


public Player(String id, String name, double salary){
	this.id = id;
	this.name = name;
	this.salary = salary;
}
public String getId(){
	return this.id;
}
public String getName(){
	return this.name;
}
public void setSalary(double salary){
	this.salary = salary;
}
public double getSalary(){
	return this.salary;
}


//class end.
}


