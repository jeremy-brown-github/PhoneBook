
public class PhoneNumber {
	private String numberProvided; 
	private String areaCode;
	private String first3;
	private String last4;
	
	public PhoneNumber (String numberProvided) {
		this.numberProvided = numberProvided;
	}
	public String toString() {
		setAreaCode(numberProvided.substring(0, 3));
		setFirst3(numberProvided.substring(3, 6));
		setLast4(numberProvided.substring(6));
		return "(" + areaCode + ")-" + first3 + "-" + last4;
	}
	public String getNumberProvided() {
		return numberProvided.trim();
	}
	public void setNumberProvided(String numberProvided) {
		this.numberProvided = numberProvided;
	}
	public String getAreaCode() {
		return areaCode.trim();
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((first3 == null) ? 0 : first3.hashCode());
		result = prime * result + ((last4 == null) ? 0 : last4.hashCode());
		result = prime * result + ((numberProvided == null) ? 0 : numberProvided.hashCode());
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
		PhoneNumber other = (PhoneNumber) obj;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (first3 == null) {
			if (other.first3 != null)
				return false;
		} else if (!first3.equals(other.first3))
			return false;
		if (last4 == null) {
			if (other.last4 != null)
				return false;
		} else if (!last4.equals(other.last4))
			return false;
		if (numberProvided == null) {
			if (other.numberProvided != null)
				return false;
		} else if (!numberProvided.equals(other.numberProvided))
			return false;
		return true;
	}
	public String getFirst3() {
		return first3.trim();
	}
	public void setFirst3(String first3) {
		this.first3 = first3;
	}
	public String getLast4() {
		return last4.trim();
	}
	public void setLast4(String last4) {
		this.last4 = last4; 
	}
	
}
