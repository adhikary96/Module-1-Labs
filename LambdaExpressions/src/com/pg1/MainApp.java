package com.pg1;

import java.util.ArrayList;
import java.util.List;

interface greetable{
	String greet(char[] arr);
}


interface MaxFinder{
	int maximum(int num1, int num2);
}

class calculator{
	int max(int n1, int n2){
		if(n1>n2){
			return n1;
		}else
			return n2;
	}
}

public class MainApp {
	public static void main(String[] args) {
		/*ArrayList<Employee> arr = new ArrayList<Employee>();
		arr.add(new Employee(1000,"anil","Male",24,"Manager",65852));*/
		
		/*List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(500);
		l.add(30);
		l.add(4);
		l.add(50);
		l.add(60141);
		//l.forEach(x->System.out.println(l));
		l.forEach(System.out::println);*/
		
		
		/*MaxFinder m = (x,y)->x>y?x:y;
		int res = m.maximum(10, 20);
		System.out.println(res);*/
		
		/*calculator c = new calculator();
		MaxFinder m = c::max;*/
		
		char[] c = {'w','e','l','c','o','m','e'};
		/*
		String str = new String(c);
		System.out.println(str);*/
		
		greetable g = String::new;
		String str = g.greet(c);
		System.out.println(str);
		
		
	}

}
