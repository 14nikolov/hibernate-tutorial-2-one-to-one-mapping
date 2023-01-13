package hibernate.one.to.one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) {
		
		// create and populate Instructor object
		Instructor instructor = new Instructor("Billy", "Newman", "bnew@loremmail.com");
		
		// create and populate InstructorDetail object
		InstructorDetail instructorDetail = new InstructorDetail("BillyTeachYouDriving", "dancing");
		
		// inject InstructorDetail object into Instructor object
		instructor.setInstructorDetail(instructorDetail);
		
		// create session factory
		// IMPORTANT: this time we add 2 annotated classes - Instructor and InstructorDetail
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		// start a new session
		Session session = sessionFactory.getCurrentSession();
		
		// begin a transaction
		session.beginTransaction();
		
		// save "instructor" object to Database
		// IMPORTANT: because we have a OneToOne mapping relationship
		// coupled with Cascading of all operations
		// the InstructorDetail object will also be saved automatically 
		session.save(instructor);
		
		// end transaction and save changes
		session.getTransaction().commit();
	}
	
}
