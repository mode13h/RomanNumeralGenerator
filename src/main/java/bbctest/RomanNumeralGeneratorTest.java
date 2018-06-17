package bbctest;

/**
 * Test harness for RomanNumeralGeneratorImpl 
 * <p>
 * We generate a series of numbers (including those outside
 * the range of 1-3999) and use them as inputs to the 
 * roman numeral generator instance.  We either get a valid
 * roman numeral back. or an IllegalArgumentException is thrown 
 * when we input invalid numbers.
 *
 */
public class RomanNumeralGeneratorTest {
	
	public static void main(String[] args) {
		RomanNumeralGeneratorImpl rng = new RomanNumeralGeneratorImpl();
	
		for(int i = 0; i < 100; i++)
		{
			int randomNumber = (int)Math.floor(Math.random() * 5000);
		
			try {
				System.out.println(randomNumber + " = " + rng.generate(randomNumber));
			}
			catch(IllegalArgumentException e) {
				System.out.println("Invalid input value " + randomNumber + " - " + e.getMessage());
			}
		}
	}
}