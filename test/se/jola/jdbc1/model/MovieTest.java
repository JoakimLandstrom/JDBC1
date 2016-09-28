package se.jola.jdbc1.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovieTest {

	@Test
	public void moviesWithSameValueShouldBeEqual() {
		
		final Movie movie1 = new Movie(1, "Star Wash - En dag på stjärntvätten", "1337", "Sci fi");
		final Movie movie2 = new Movie(1, "Star Wash - En dag på stjärntvätten", "1337", "Sci fi");
		
		assertEquals(movie1, movie2);
	}
	
	@Test
	public void moviesThatAreEqualShouldHaveSameHashCode(){
		
		final Movie movie1 = new Movie(1, "Star Wash - En dag på stjärntvätten", "1337", "Sci fi");
		final Movie movie2 = new Movie(1, "Star Wash - En dag på stjärntvätten", "1337", "Sci fi");
		
		assertEquals(movie1.hashCode(), movie2.hashCode());
	}
	
	

}
