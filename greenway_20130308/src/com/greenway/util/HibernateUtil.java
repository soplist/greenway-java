package com.greenway.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;




public class HibernateUtil {
	private final static  SessionFactory sessionFactory;
	static{
		try{
			Resource resource=new ClassPathResource("applicationContext.xml");
			BeanFactory factory=new XmlBeanFactory(resource);
			sessionFactory = (SessionFactory)factory.getBean("sessionFactory"); 
			
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static final ThreadLocal session = new ThreadLocal();
	public static Session currentSession()throws HibernateException{
		Session s = (Session)session.get();
		if(s==null){
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	public static void closeSession()throws HibernateException{
		Session s = (Session)session.get();
		session.set(null);
		if(s!=null)
			s.close();
	}
    public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }
}
