/**
 * represents an Address class
 * @author Steven Maggio
 *
 */
public class Address {
	private String street; //holds address
	private String city; //holds city name
	private String state; //holds state name
	private String zipcode; //holds zipcode value
	
	
	/**
	 * constructs Address and initializes field variables
	 * @param str
	 * @param c
	 * @param sta
	 * @param z
	 */
	public Address(String str,String c,String sta,String z) {
		street=str; //initialize address
		city=c; //initialize city
		state=sta; //initialize state
		zipcode=z; //initializes zipcode
		
	}
	
	/**
	 * returns address values
	 * @return address values
	 */
	public String toString() {
		return (street+" "+city+" "+state+" "+zipcode);
	}
	
}
