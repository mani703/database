package com.bit.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Lec03 {
	int su = 1234;
}

public class Ex03 {

	public static void main(String[] args) {
//		Lec03 obj = new Lec03();
//		System.out.println(obj.su);
		
		try {
			Class<?> clz = Class.forName("com.bit.db.Lec03");
			Lec03 obj = (Lec03) clz.newInstance();
			Field[] fields = clz.getDeclaredFields();
			System.out.println(fields[0].getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			Class<Lec03> clz = Lec03.class;
			Lec03 obj = clz.newInstance();
			System.out.println(obj.su);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
