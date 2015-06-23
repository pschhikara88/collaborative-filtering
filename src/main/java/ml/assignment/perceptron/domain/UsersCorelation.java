package ml.assignment.perceptron.domain;

import java.util.Arrays;

public class UsersCorelation {
	
	String[] users;
	float corelation;
	
	
	
	public UsersCorelation() {
		super();
		this.users = new String[2];
	}
	
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public float getCorelation() {
		return corelation;
	}
	public void setCorelation(float corelation) {
		this.corelation = corelation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(users);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersCorelation other = (UsersCorelation) obj;
		if (!Arrays.equals(users, other.users))
			return false;
		return true;
	}
	
	
	

}
