# RomanNumeralGenerator
A program to convert values from 1 - 3999 into Roman numerals

# Build instructions

Ensure that Gradle and a Java compiler is installed on your machine.  If you have a working build environment, then  
```
gradle build 
```
will build a .jar file, which will then be located in `build/libs`.  To run the test harness, do 
```
java -jar RomanNumeralGenerator
```
The test harness will attempt to generate 100 Roman numerals, with some values being deliberately passed in outside the range of 1 - 3999 to see how the program handles errors.

To create documentation for the source code, do 
```
gradle javadoc
```
and the documentation will be generated in `build/docs`

