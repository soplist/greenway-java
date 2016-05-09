package com.greenway.pojo.test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
	public static void main(String[] args) {
		Reflection r = new Reflection();
		//Integer i = new Integer(3);
		//r.getDeclaredFields(i);
		DemoClass dc = new DemoClass();
		//Object obj = r.getProperty(dc,"pro1");
		//System.out.println(obj.toString());
		//Object obj=r.getStaticProperty("com.greenway.pojo.test.DemoClass","pro2");
		//System.out.println(obj.toString());
		//Object[] args1 ={3,"abc"};
		Object[] args2 ={3,100,"abc"};
		try {
			//r.invokeMethod(dc, "method1", args1);
			//r.invokeStaticMethod("com.greenway.pojo.test.DemoClass", "method2", args2);
			Object obj = r.newInstance("com.greenway.pojo.test.DemoClass", args2);
			boolean b = r.isInstance(obj, DemoClass.class);
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Object getByArray(Object array, int index) {
		return Array.get(array,index);
	}
	public boolean isInstance(Object obj, Class cls) {
		return cls.isInstance(obj);
	}
	public Object newInstance(String className, Object[] args) throws Exception {
		Class newoneClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
		    argsClass[i] = args[i].getClass();
		}
		Constructor cons = newoneClass.getConstructor(argsClass);
		return cons.newInstance(args);
	}
	public Object invokeStaticMethod(String className, String methodName,
		Object[] args) throws Exception {
		Class ownerClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			 argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(null, args);
	}
	public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
		     argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(owner, args);
	}
	public Object getStaticProperty(String className, String fieldName) {
		try {
	        Class ownerClass = Class.forName(className);
	        Field field = ownerClass.getField(fieldName);
	        Object property = field.get(ownerClass);
	        return property;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	public void getDeclaredFields(Integer i){

		try {
		    Class c = i.getClass();
            Field[] fields = c.getDeclaredFields();
            for(Field f : fields){
                System.out.println(f.getName());
            }
            Field field;
			field = c.getDeclaredField("value");
			field.setAccessible(true);
			System.out.println("value="+field.get(i));
			 
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public Object getProperty(Object owner, String fieldName){
	     try {
		    Class ownerClass = owner.getClass();
		    Field field = ownerClass.getField("pro1");
		    System.out.println(field.getName());
		    Object property = field.get(owner);
		    return property;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
