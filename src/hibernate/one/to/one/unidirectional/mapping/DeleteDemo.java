package hibernate.one.to.one.unidirectional.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
	
	public static void main(String[] args) {
		
		// Deleting a column from the Instructor Table
		// along with the linked to it column from InstructorDetail Table
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
//		This will not work, because we are deleting by Query
//		session.createQuery("delete Instructor where id=6 ").executeUpdate();
		
//		If we want the Cascade feature of Hibernate to work
//		we have to use the session's "delete()" method
//		This is why we write the code like in the example below
		Instructor tempInstructor = session.get(Instructor.class, 2);
		
		// Checking if the Object is null before proceeding to delete it
		// in other words checking if the column exists in the table, before
		// attempting to delete it, if it does then we will proceed to delete it
		if(tempInstructor!=null) {
		session.delete(tempInstructor);
		}

		
		session.getTransaction().commit();
		
	}
	
}
