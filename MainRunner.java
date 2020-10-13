package com.luv2code.hibernate.demo;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class MainRunner {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		
		try {
			
//			InstructorDetail instructorDetail=new InstructorDetail("Learn to drive","Driving");
//			
//			Instructor instructor=new Instructor("Megna","Nikade","meghu@gmail.com");
//			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			//session.save(instructor);
			
			InstructorDetail insDetail=session.get(InstructorDetail.class,1);
			System.out.println("****************Instructor Detail*************");
			System.out.println(insDetail);
			
			
			System.out.println("************Related Instructor*********");
			System.out.println(insDetail.getInstructor());
			session.getTransaction().commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
				
		
	}

}
