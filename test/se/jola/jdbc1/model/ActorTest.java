package se.jola.jdbc1.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActorTest {

	@Test
	public void actorsWithSameValueShouldBeEqual(){
		
		final Actor actor1 = new Actor(1, "Pelle", "Chanslös");
		final Actor actor2 = new Actor(1, "Pelle", "Chanslös");
		
		assertEquals(actor1, actor2);
	}
	
	@Test
	public void actorsThatAreEqualShouldHaveSameHashCode(){
		
		final Actor actor1 = new Actor(1, "Pelle", "Chanslös");
		final Actor actor2 = new Actor(1, "Pelle", "Chanslös");
		
		assertEquals(actor1.hashCode(), actor2.hashCode());
	}

}
