package hibernate.one.to.one.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	
	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	// @OneToOne and @JoinColumn Annotations thorough explanation:
	// Right now we are in the class "Instructor" and we have created
	// a reference data type object - "InstructorDetail instructorDetail".
	// By adding the Hibernate @OneToOne and @JoinColumn annotations
	// we are specifying that this object represents a
	// Foreign Key Column from the Database, with a One to One mapping.
	// Meaning this Object contains the Primary Keys of only 1 other Object
	// Unlike the One to Many mapping, where our Object can contain the 
	// Primary Keys of multiple other Objects
		// And as we already know a Foreign Key Column in a Table,
		// is used to point to another Table's Primary Keys.
		// By having a column in Table(X), which contains the Primary Key 
		// column of Table(Y), we are linking Table(X) to Table(Y).
	// @OneToOne Annotation "cascade" parameter
	// The Cascade parameter specifies what type of Cascading we will
	// apply to the related Entity/Object. In this case whatever we do,
	// with the Instructor Object (modify, delete, save, detach and etc) will
	// also apply/happen to the InstructorDetail Entity/Object.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_details_id")
	private InstructorDetail instructorDetail;
	
	// Constructors
	
	public Instructor() {}
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	
	// toString method
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + 
				", firstName=" + firstName +
				", lastName=" + lastName +
				", email=" + email +
				", instructor_details_id=" + instructorDetail + "]";
	}
	
	// Fields' Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	
	
}
