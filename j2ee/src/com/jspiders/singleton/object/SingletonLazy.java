package com.jspiders.singleton.object;

public class SingletonLazy {
		static SingletonLazy object;
		static int count;
		 private SingletonLazy() {
			count++;
		}
		 public static SingletonLazy getobject() {
			 if (object == null) {
				object = new SingletonLazy();
			}
			 System.out.println("Object created" +count+ "times");
			 return object;
		 }
}
