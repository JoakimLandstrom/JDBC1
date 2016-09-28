package se.jola.jdbc1.model;

public final class Actor {

	private final int actorId;

	private final String firstName;

	private final String lastName;

	public Actor(int actorId, String firstName, String lastName) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getActorId() {
		return actorId;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj instanceof Actor) {

			Actor other = (Actor) obj;

			return actorId == other.actorId && firstName.equals(other.getFirstName())
					&& lastName.equals(other.getLastName());
		}

		return false;
	}

	@Override
	public int hashCode() {

		int hashCode = 1;

		hashCode += 37 * firstName.hashCode();
		hashCode += 37 * lastName.hashCode();

		return hashCode;

	}

}
