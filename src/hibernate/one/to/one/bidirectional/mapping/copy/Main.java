package hibernate.one.to.one.bidirectional.mapping.copy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) {
		
		// create and populate InstructorDetail object
		InstructorDetail tempInstructorDetail = new InstructorDetail("CrazyGoodChannel", "sky-diving");
		
		// create and populate Instructor object
		Instructor tempInstructor = new Instructor("Hue", "Jackman", "huejack@marvelmail.com");
		
		// inject InstructorDetail object into Instructor object
		tempInstructorDetail.setInstructor(tempInstructor);
		
		// create session factory
		// IMPORTANT: this time we add 2 annotated classes - Instructor and InstructorDetail
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Instructor.class).
				buildSessionFactory();
		
		// start a new session
		Session session = sessionFactory.getCurrentSession();
		
		// begin a transaction
		session.beginTransaction();
		
		// IMPORTANT (if this line is not written, then tempInstructorDetail and instructorDetail Objects
		// will be saved to Database, but they will not be linked to each other (no foreign key value will be set to Instructor,
		// thus the 2 objects/tables will have no link between each other)
		// Setting InstructorDetail field in Instructor object,
		// in order to be able to map Instructor and InstructorDetail Objects to each other
		tempInstructorDetail.getInstructor().setInstructorDetail(tempInstructorDetail);
		
		// save "instructor" object to Database
		// IMPORTANT: because we have a OneToOne mapping relationship
		// coupled with Cascading of all operations
		// the InstructorDetail object will also be saved automatically 
		session.save(tempInstructorDetail);
		
		// end transaction and save changes
		session.getTransaction().commit();
	}
	
}
