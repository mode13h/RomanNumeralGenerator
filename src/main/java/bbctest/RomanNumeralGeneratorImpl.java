package bbctest;

import java.util.TreeMap;


/**
 * Implementation of RomanNumeralGenerator interface
 *
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
	
	private TreeMap<Integer, String> numeralMap;		//TreeMap preserves natural ordering of key-value pairs unlike HashMap
	
	/**
	 * Constructor
	 * <p>
	 * Creates and initialises a TreeMap containing key-value pairs 
	 * 	representing the values of Roman numerals as keys, and the Roman 
	 * 	numeral representations of the same as values. 
	 * 
	 */
	public RomanNumeralGeneratorImpl() {
		
		numeralMap = new TreeMap<Integer, String>();
		
		numeralMap.put(1000, "M");
		numeralMap.put(900, "CM");
		numeralMap.put(500, "D");
		numeralMap.put(400, "CD");
		numeralMap.put(100, "C");
		numeralMap.put(90, "XC");
		numeralMap.put(50,  "L");
		numeralMap.put(40, "XL");
		numeralMap.put(10, "X");
		numeralMap.put(9, "IX");
		numeralMap.put(5, "V");
		numeralMap.put(4, "IV");
		numeralMap.put(1, "I");
	}

	
	/**
	 * Implementation of RomanNumeralGenerator interface
	 * <p>
	 * 	Algorithm for building a Roman numeral is:
	 *	<p> 	
	 *	1:  find the nearest value of a Roman numeral to the input number
	 *<br>
	 *	2:  Subtract the value of the Roman numeral from the input number
	 *		and append the Roman numeral representation to the output string,
	 *		and repeat from step 1.
	 * <p>
	 *		Eventually the input number will become zero, at which point our 
	 *		output string is complete.
	 * <p>
	 * @param number A number between 1 and 3999 to convert into a Roman numeral
	 * @return A string containing the Roman numeral representation of the input value
	 * @throws IllegalArgumentException if the input value falls outside the range 1 - 3999
	 */
	public String generate(int number) {
		
		if(number < 1 || number > 3999) {
			throw new IllegalArgumentException("The input value must be between 1 and 3999");
		}

		StringBuilder romanNumeralString = new StringBuilder("");	//Use a StringBuilder instead of String for efficiency reasons

		//Examine our Roman numerals from the highest value to the lowest
		//	(hence, the use of TreeMap and descendingKeySet()) and determine
		//	how many times to repeat each Roman numeral in the output string.
		for(int romanNumeralValue : numeralMap.descendingKeySet()) {		
			while(number >= romanNumeralValue) {
				romanNumeralString.append(numeralMap.get(romanNumeralValue));
				number -= romanNumeralValue;
			}
		}
		
		return romanNumeralString.toString();	
	}
}
