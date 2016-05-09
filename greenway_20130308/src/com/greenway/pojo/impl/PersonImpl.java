package com.greenway.pojo.impl;

import com.greenway.pojo.inter.Person;

public class PersonImpl implements Person{
    private String name;
    private int age;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void info() {
		// TODO Auto-generated method stub
		System.out.println("my name is:"+name+",age is:"+age);
	}

	public void run() {
		// TODO Auto-generated method stub
		if(age<45){
			System.out.println("i am young,i can run fast");
		}
		else{
			System.out.println("i am old,i can not run fast");
		}
	}

}
