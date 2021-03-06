package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {

	public static void main(String[] args) {

		/*
		 * ============== Don't alter the code between lines 24 - 42 ==============
		 */

		Student student1 = new Student("Bob", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Alice", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Wally", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		/*
		 * ========== Don't alter the code above (lines 24 - 42) ===============
		 */

		/***************************************************************************
		 * (1) Get the student with the name "Bob" and print his name to the console. If
		 * "Bob" does not exist, print "No student found". HINT: Store
		 * students.stream()...etc to an Optional<Student> in the case that the student
		 * doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
		 ****************************************************************************/

		// Code your Solution here
		// use optional
		System.out.println("========= ANSWER TO QUESTION 1 ========");

		Optional<Student> hasBob = students.stream().filter(s -> s.getName().equals("Bob")).findFirst();
		System.out.println((hasBob.isPresent() ? hasBob.get().getName() : "Bob not found"));

		/***************************************************************************
		 * (2) Get the student with matching address "1235" and print their name to the
		 * console. If the address does not exist, print "No student found". HINT: Store
		 * students.stream()...etc to an Optional<Student> in the case that the student
		 * doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
		 ****************************************************************************/
		System.out.println("========= ANSWER TO QUESTION 2 ========");

		// Code your Solution here
		Optional<Student> hasAdd = students.stream()
				.filter(s -> s.getAddress().getZipcode().equals("1235"))
				.findFirst();
		System.out.println((hasAdd.isPresent()) ? hasAdd.get().getName() : "No student found");

		/****************************************************************************
		 * (3) Get all the students that have the mobile number "3333" and print their
		 * names to the console.
		 *****************************************************************************/
		System.out.println("========= ANSWER TO QUESTION 3 ========");
		// Code your Solution here
		//several students. so no opt, make it a list of students 
		List<Student> mob = students.stream()
				.filter(s -> s.getMobileNumbers()
						.stream()
						.anyMatch(num -> num.getNumber().equals("3333")))
				.collect(Collectors.toList());
		//call forEAch on the collection and priunt name of each student 
		mob.forEach(s -> System.out.println(s.getName()));
						
				
		
		/***************************************************************************
		 * (4) Get all student having mobile number "1233" and "1234" and print their
		 * names to the console.
		 ***************************************************************************/
		System.out.println("========= ANSWER TO QUESTION 4 ========");
		//two lists: 1233 and 1234 
		//if student is in both lists, print their name 
		
		// Code your Solution here
		List<Student> l1 = students.stream()
				.filter(s -> s.getMobileNumbers()
						.stream()
						.anyMatch(num -> num.getNumber().equals("1233")))
				.collect(Collectors.toList());
		List<Student> l2 = students.stream()
				.filter(s -> s.getMobileNumbers()
						.stream()
						.anyMatch(num -> num.getNumber().equals("1234")))
				.collect(Collectors.toList());
		for(Student s: l1) {
			if(l2.contains(s))
				System.out.println(s.getName());
		}
		/***************************************************************************
		 * (5) Create a List<Student> from the tmpStudents List. Call it studentList.
		 * Hint: Use Collectors.toList(). Print it to the console. Resource:
		 * https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
		 ****************************************************************************/
		TempStudent tmpStud1 = new TempStudent("Bob1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Alice1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		// Code your Solution here, don't touch the code above
		System.out.println("========= ANSWER TO QUESTION 5 ========");
		//tmp studnets is a dumb class 
		//tmpstudent.name gets the name 
		List<Student> studentList = tmpStudents.stream()
				.map(s-> new Student(s.name, s.age, s.address, s.mobileNumbers))
				.collect(Collectors.toList());
		studentList.forEach(s -> System.out.println(s));
		
		
		/***************************************************************************
		 * (6) Convert the List<Student> called studentList that you made in question
		 * (5) to List<String> of just their names. Call this new list "studentNames".
		 * Print it to the console.
		 ****************************************************************************/

		// Code your Solution here
		System.out.println("========= ANSWER TO QUESTION 6 ========");

		List<String> studentNames = studentList.stream()
				.map(s-> s.getName())//in parenthesis, Student::getName bc no params :) 
				.collect(Collectors.toList());
		studentNames.forEach(s-> System.out.println(s));
		/***************************************************************************
		 * (7) Convert List<Students> to a single String called name with just their
		 * names. Print that String to the console.
		 ****************************************************************************/

		// Code your Solution here
		System.out.println("========= ANSWER TO QUESTION 7 ========");

		String name = studentNames.stream()
				.collect(Collectors.joining(", "));
		System.out.println(name);
		/****************************************************************************
		 * (8) Change all the Strings within the List<String> nameList to Upper Case.
		 * Print it to the screen.
		 *****************************************************************************/
		List<String> nameList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");

		// Code your Solution here, don't touch the code above
		System.out.println("========= ANSWER TO QUESTION 8 ========");
		List<String> upper = nameList.stream()
				.map(String::toUpperCase)//String::toUpperCase?
				.collect(Collectors.toList());
		upper.forEach(s-> System.out.println(s));
		/****************************************************************************
		 * (9) Sort List<String> namesList by natural order. Hint: Research .sorted()
		 * method
		 * https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
		 *****************************************************************************/
		
		// Code your Solution here, don't touch the code above
		System.out.println("========= ANSWER TO QUESTION 9 ========");
		List<String> namesList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
		List<String> sorted = nameList.stream()
				.map(String::toUpperCase)//method referencing 
				.sorted()
				.collect(Collectors.toList());
		sorted.forEach(s -> System.out.println(s));
	}

}
