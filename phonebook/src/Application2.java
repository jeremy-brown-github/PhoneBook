import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application2 {
	public final static String userOpMenu = "Please make a selection below: "+System.lineSeparator()+"1-Add a new record"+System.lineSeparator()+"2-Delete record"+
			System.lineSeparator()+"3-Find record by telephone number"+System.lineSeparator()+"4-Find record by first name"+System.lineSeparator()+
			"5-Find record by last name"+System.lineSeparator()+"6-Update a record"+System.lineSeparator()+"7-Find all records by state"+System.lineSeparator()+
			"8-Find all records by city"+System.lineSeparator()+"9-Sort phonebook"+System.lineSeparator()+"10-Exit"; 
	
	public static Person[] phoneBook = new Person [0];

	public static void main(String[] args) {
		int userResponse = getSelectFormResponse();
		while (userResponse > 0 && userResponse < 11) {
			try {
			if (userResponse == 10) {
				System.out.println("Thank you for using our phonebook, have a nice day");
				break;
			}
			else if (userResponse == 1) {
				System.out.println("Please enter contact info you want to add exactly like this example: John P Doe, 574 Pole ave, St. Peters, MO, 63333, 3148675309");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();		
				try {
				String userInputAddress = getAddressInfo(userInputString); 
				addNewRecord (getPhoneNumber(userInputString), getStreetNumber (userInputAddress), getStreetName (userInputAddress), getStreetType (userInputAddress), 
					getCity (userInputAddress), getState (userInputAddress), getZip (userInputAddress), getNameFromInput(userInputString));
				}catch (StringIndexOutOfBoundsException e){
					System.out.println("Your entry: "+userInputString+System.lineSeparator()+
							"is not formatted correctly. Please enter your contact info like the example");
				}
				userResponse = getSelectFormResponse();
			}
			else if (userResponse == 2) {
				System.out.println("Please enter 10 digit phone number of contact you want to delete: ");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				deleteRecord(userInputString);
				userResponse = getSelectFormResponse(); 
			}
			else if (userResponse == 3) {
				System.out.println("Please enter the phone number for the contact like this example: 8558675309");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				System.out.println(findByPhoneNumber(userInputString).toString());
				userResponse = getSelectFormResponse(); 
			}
			else if (userResponse == 4) {
				System.out.println("Please enter the first name of the contact like this example: Jeremy");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				System.out.println(findByFirstName(userInputString).toString());
				userResponse = getSelectFormResponse(); 
			}
			else if (userResponse == 5) {
				System.out.println("Please enter the last name of the contact like this example: Ronaldson");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				System.out.println(findByLastName(userInputString).toString());
				userResponse = getSelectFormResponse();
			}
			else if (userResponse == 6 ) {
				System.out.println("Please enter the phone number of the contact you want to edit: ");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				Person contactToEdit = findByPhoneNumber(userInputString);
				System.out.println(contactToEdit.toString());
				System.out.println("Enter contact's new phone number: ");
				Scanner userInputNew = new Scanner(System.in);
				PhoneNumber newPhoneNumber = new PhoneNumber(userInputNew.nextLine());
				contactToEdit.setPhoneNumber(newPhoneNumber);
				System.out.println("The contact has been updated: "+ contactToEdit.toString());
				userResponse = getSelectFormResponse(); 
			}
			else if (userResponse == 7) {
				System.out.println("Please enter the state of contacts you are searching for: ");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				for (int i = 0; i < phoneBook.length; i++) {
					if (phoneBook[i].getAddress().getStateAbbreviation().trim().equalsIgnoreCase(userInputString)) {
						System.out.println(phoneBook[i].toString());
					}
				}
				userResponse = getSelectFormResponse();
			}
			else if (userResponse == 9) {
				Arrays.sort(phoneBook, new PersonComparator());
				for (int i =0; i < phoneBook.length; i++) {
					System.out.println(phoneBook[i].toString());
				}
				if (phoneBook.length==0) {
					System.out.println("the phonebook is empty");
				}
				userResponse = getSelectFormResponse();

			}
			else if (userResponse == 8) {
				System.out.println("Please enter the city of contacts you are searching for: ");
				Scanner userInput = new Scanner(System.in);
				String userInputString = userInput.nextLine();
				for (int i = 0; i < phoneBook.length; i++) {
					if (phoneBook[i].getAddress().getCity().equalsIgnoreCase(userInputString)) {
						System.out.println(phoneBook[i].toString());
					}
				}
				userResponse = getSelectFormResponse();
			}
			} catch(InputMismatchException e) {
				System.out.println("Please enter a number that matches a valid operation of this phonebook (1-10)");
				getSelectFormResponse();
			}
		}	
	}
	public static void deleteRecord (String phoneNumber) {
		int index = 0;
		Person [] updatedPhoneBook = new Person[phoneBook.length-1]; 
		for (int i = 0; i < phoneBook.length; i++) {
			if  ((phoneBook[i].getPhoneNumber().getNumberProvided().equals(phoneNumber.trim()))==false) {
				updatedPhoneBook[index] = phoneBook[i];
				index++;
			}
			else{
				System.out.println("you have deleted: "+phoneBook[i].toString());
			}
		}
		phoneBook = updatedPhoneBook;
	}
// find record by phone number
	public static Person findByPhoneNumber (String phoneNumber) {
		PhoneNumber phoneNumberToFind = new PhoneNumber(phoneNumber);
		Person personToReturn = new Person ();
		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].getPhoneNumber().equals(phoneNumberToFind)) {
				personToReturn = phoneBook[i]; 
			}
		}
		return personToReturn;
	}
	//find record by first name
	public static Person findByFirstName (String firstName) {
		Person personToReturn = new Person ();
		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].getFirstName().equalsIgnoreCase(firstName)) {
				personToReturn = phoneBook[i]; 
			}
		}
		return personToReturn;
	//find record by last name
	}	
	public static Person findByLastName (String lastName) {
		Person personToReturn = new Person();
		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].getLastName().equalsIgnoreCase(lastName)) {
				personToReturn = phoneBook[i]; 
			}
		}
		return personToReturn;
	}
	//find record with matching first and last name
	public static Person findByFullName (String fullName) {
		Person personToReturn = new Person();
		String lastName = fullName.substring(fullName.lastIndexOf(" "));
		for (int i = 0; i < phoneBook.length - 1; i++) {
			if (phoneBook[i].getFirstName().equalsIgnoreCase(getFirstName(fullName)) && 
					phoneBook[i].getLastName().equalsIgnoreCase(lastName));
				personToReturn = phoneBook[i];
		}
		return personToReturn;
	}
//	add new record // options for 2-4 names provided
	public static void addNewRecord (String phoneNumber, String streetNumber, String streetName, String streetType, String city, String stateAbbreviation,
			String zipCode, String userInputNameOnly) {
		Person [] updatedPhoneBook = Arrays.copyOf(phoneBook, phoneBook.length+1);
		Address addressToAdd = new Address (streetNumber, streetName, streetType, city, stateAbbreviation, zipCode);
		PhoneNumber phoneNumberToAdd = new PhoneNumber (phoneNumber);
		if (countTheNames(userInputNameOnly) == 2) {
			Person personToAdd = new Person (addressToAdd, phoneNumberToAdd, getFirstName(userInputNameOnly), getLastName(userInputNameOnly));
//			updatedPhoneBook[phoneBook.length+1] = personToAdd;
			updatedPhoneBook[phoneBook.length] = personToAdd;
			phoneBook = updatedPhoneBook;
		}
		else if (countTheNames(userInputNameOnly) == 3) {
			Person personToAdd = new Person (addressToAdd, phoneNumberToAdd, getFirstName(userInputNameOnly), getMiddleName1(userInputNameOnly), getLastName(userInputNameOnly));
			updatedPhoneBook[phoneBook.length] = personToAdd;
			phoneBook = updatedPhoneBook;
		}
		else if (countTheNames(userInputNameOnly) == 4) {
			Person personToAdd = new Person (addressToAdd, phoneNumberToAdd, getFirstName(userInputNameOnly), getMiddleName1(userInputNameOnly), getMiddleName2(userInputNameOnly), 
					getLastName(userInputNameOnly));
			updatedPhoneBook[phoneBook.length] = personToAdd;
			phoneBook = updatedPhoneBook;
		}
	}
	public static int countTheNames (String nameString) {
		int spaces = 0;
		for (int i = 0; i < nameString.length() - 1; i++) {
			if (nameString.charAt(i) == ' ') {
				spaces++;
			}
		}
		return spaces + 1;		
	}
	public static int getSelectFormResponse () {
		System.out.println(userOpMenu);
		Scanner userInput = new Scanner(System.in);
		return userInput.nextInt();
	}
	public static String getNameFromInput (String userString) {
		String nameString = ""; 
		for (int i = 0; i < userString.length()-1; i++) {
			if (userString.charAt(i) != 42 && userString.charAt(i) <= 47 || userString.charAt(i) >= 58) {
				nameString = userString.substring(0, i);
			}
			else {
				break;
			}
		}
		return nameString;
	}
	public static String getFirstName (String nameString) {
		return nameString.substring(0, nameString.indexOf(" ")); 
	}
	public static String getLastName (String nameString) {
		return nameString.substring(nameString.lastIndexOf(" ")+1, nameString.lastIndexOf(","));
	}
	public static String getMiddleName1 (String nameString) {
		String leftOverName = nameString.substring(nameString.indexOf(" ")+1);
		return leftOverName.substring(0, leftOverName.indexOf(" "));
	}
	public static String getMiddleName2 (String nameString) {
		String leftOverName = nameString.substring(nameString.indexOf(" ")+1);
		String leftOverName2 = leftOverName.substring(leftOverName.indexOf(" ")+1);
		return leftOverName2.substring(0, leftOverName2.indexOf(" "));
	}
	public static String getAddressInfo (String userData) {
		String addressString = ""; 
		for (int i = 0; i < userData.length()-1; i++) {
			if (userData.charAt(i) > 47 && userData.charAt(i) < 58) {
				addressString = userData.substring(i);
				return addressString;
			}
		}
		return "no address provided";
	}
	public static String getStreetNumber(String addressString)	{
		return addressString.substring(0, addressString.indexOf(" ")); 
	}
	public static String getStreetName(String addressString) {
		int beginIndex = getStreetNumber(addressString).length();
		String choppedStreetNumber = addressString.substring(beginIndex).trim();
		return choppedStreetNumber.substring(0, choppedStreetNumber.indexOf(" "));
	}
	public static String getStreetType (String addressString) {
		int beginIndex = getStreetNumber(addressString).length() + 1 + getStreetName(addressString).length() + 1;
		String choppedStreetName = addressString.substring(beginIndex);
		return choppedStreetName.substring(0, choppedStreetName.indexOf(","));
	}
	public static String getCity (String addressString) {
		int beginIndex = getStreetNumber(addressString).length() + 1 + getStreetName(addressString).length() + 1 + getStreetType(addressString).length() + 1;
		String choppedStreetType = addressString.substring(beginIndex);
		return choppedStreetType.substring(0, choppedStreetType.indexOf(","));	
	}
	public static String getState (String addressString) {
		int beginIndex = getStreetNumber(addressString).length() + 1 + getStreetName(addressString).length() + 1 + getStreetType(addressString).length() + 1 + getCity(addressString).length() + 1;
		String choppedCity = addressString.substring(beginIndex);
		return choppedCity.substring(0, choppedCity.indexOf(","));	
	}
	public static String getZip (String addressString) {
		int beginIndex = getStreetNumber(addressString).length() + 1 + getStreetName(addressString).length() + 1 + getStreetType(addressString).length() + 1 + getCity(addressString).length() + 1 + getState(addressString).length() + 1;
		String choppedState = addressString.substring(beginIndex);
		return choppedState.substring(0, choppedState.indexOf(","));
	}
	public static String getPhoneNumber (String userInputString) {
		String userString = userInputString; 
		String phoneNumber = "";
		for (int i = userString.length()-1; userString.charAt(i) > 47 && userString.charAt(i) < 58; i--) {
			phoneNumber = userString.substring(i);
		}
		return phoneNumber;
	}
}
