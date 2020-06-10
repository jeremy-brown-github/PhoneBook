import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	

	@Override
	public int compare(Person P1, Person P2) {
		if (P1.getLastName()!=P2.getLastName()) {
		return P1.getLastName().compareTo(P2.getLastName());
		}
		else if (P1.getFirstName()!=P2.getFirstName()) {
			return P1.getFirstName().compareTo(P2.getFirstName());
		}
		else if (P1.getMiddleName1()!=P2.getMiddleName1()) {
			return P1.getMiddleName1().compareTo(P2.getMiddleName1());
		}
		else {
			return P1.getMiddleName2().compareTo(P2.getMiddleName2());
		}
	}

}
