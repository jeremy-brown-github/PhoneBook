
public class Address {
	private String streetNumber;
	private String streetName; 
	private String streetType;
	private String city;
	private String stateAbbreviation; 
	private String zipCode;
	
	public Address (String streetNumber, String streetName, String streetType, String city, String stateAbbreviation, String zipCode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetType = streetType;
		this.city = city;
		this.stateAbbreviation = stateAbbreviation;
		this.zipCode = zipCode;
	}
	public String toString () {
		return streetNumber+" "+streetName+" "+streetType+","+ city+","+stateAbbreviation+","+zipCode;	
	}
	public String getStreetNumber() {
		return streetNumber.trim();
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName.trim();
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetType() {
		return streetType.trim();
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getCity() {
		return city.trim();
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation.trim();
	}
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	public String getZipCode() {
		return zipCode.trim();
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}