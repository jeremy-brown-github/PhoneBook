
public class Person {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName1 == null) ? 0 : middleName1.hashCode());
		result = prime * result + ((middleName2 == null) ? 0 : middleName2.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName1 == null) {
			if (other.middleName1 != null)
				return false;
		} else if (!middleName1.equals(other.middleName1))
			return false;
		if (middleName2 == null) {
			if (other.middleName2 != null)
				return false;
		} else if (!middleName2.equals(other.middleName2))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	private Address address;
	private PhoneNumber phoneNumber;
	private String lastName;
	private String firstName;
	private String middleName1;
	private String middleName2;
	
	public Person () {
	}
	
	public Person (Address address, PhoneNumber phonenumber, String firstName, String lastName) {
		this.address = address;
		this.phoneNumber = phonenumber;
		this.firstName = firstName;
		this.lastName = lastName; 	
	}
	public Person (Address address, PhoneNumber phonenumber, String firstName, String middleName1, String lastName) {
		this.address = address;
		this.phoneNumber = phonenumber;
		this.firstName = firstName;
		this.lastName = lastName; 	
		this.middleName1 = middleName1; 
	}
	public Person (Address address, PhoneNumber phonenumber, String firstName, String middleName1, String middleName2, String lastName) {
		this.address = address;
		this.phoneNumber = phonenumber;
		this.firstName = firstName;
		this.lastName = lastName; 	
		this.middleName1 = middleName1; 
		this.middleName2 = middleName2;
	}
	public String toString() {
		if (middleName1 != null && middleName2!= null)
			return firstName+" "+middleName1+" "+middleName2+" "+lastName+" "+address+", "+phoneNumber;
		else if (middleName1 != null && middleName2 == null) {
			return firstName+" "+middleName1+" "+lastName+" "+address+", "+phoneNumber;
		}
		else {
			return firstName+" "+lastName+" "+address+", "+phoneNumber;
		}
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLastName() {
		return lastName.trim();
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName.trim();
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName1() {
		return middleName1.trim();
	}

	public void setMiddleName1(String middleName1) {
		this.middleName1 = middleName1;
	}

	public String getMiddleName2() {
		return middleName2.trim();
	}

	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}

}
