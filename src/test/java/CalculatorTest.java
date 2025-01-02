import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    @BeforeAll

    public  static void setUpBeforeClass(){
        System.out.println("Before all tests :");

    }

    @BeforeEach

    public void setUp() {

        System.out.println("Before each tests :");
    }

    @Test

    public void testAddition(){ //Positivity test

        Calculator calculator = new  Calculator();
        int result = calculator.subtract(10,5);

        assertEquals(5,result,"10 - 5 should be equal 5");

        //System.out.println("Test addition : ");
    }

    @Test

    public void testAdditionNegative(){

        Calculator calculator = new Calculator();
        int result = calculator.add(2,3);

        assertNotEquals(6,result,"2 + 3 should not be equal 6");

    }

    @Test

    public void testFactorialPositive(){

        Calculator calculator = new Calculator();
        int result = calculator.factorial(5);

        assertEquals(120,result,"Factorial of number 5 should be 120");
    }

    @Test

    public void testFactorialNegative(){

        Calculator calculator = new Calculator();
        int result = calculator.factorial(5);
        System.out.println(result);

        assertNotEquals(4,result,"Factorial of certain number " + "cannot be less than that number");

        //assertThrows(IllegalArgumentException.class,()-> calculator.factorial(-1));
    }

    @Test

    public void testArray(){
        String[] actual  = {"Hello", "JUnit", "Framework"};
        String[] expected = { "Hello", "JUnit", "Framework" };

        assertArrayEquals(actual, expected);
    }

    @Test

    public void testBoolean(){
        assertFalse(1 > 2);
        assertTrue(2 > 1);
    }

    @Test

    public void assertNullsAndNotNulls() {
        String s = null;
        assertNull(s);


        s = "Hello";
        assertNotNull(s);
    }

    @Test

    public void testStringPositive(){
        Calculator calculator = new Calculator();

        String s = null;

        assertNull(calculator.wordsArray(null));
    }

    @Test

    public void testStringNegative(){
        Calculator calculator = new Calculator();

        String a = "I am at SVVT labs";

        assertNotNull(calculator.wordsArray(a));
    }

    @Test

    public void testBooleanPositive(){
        Calculator calculator = new Calculator();

        assertTrue(calculator.isAdult(20));
    }

    @Test

    public void testBooleanNegative(){
        Calculator calculator = new Calculator();

        assertFalse(calculator.isAdult(5));
    }

    @Test

    public void positiveSorting(){
        Calculator calculator = new Calculator();

        int arr [] ={10,12,-1,30 ,1000};
        int numbers[]={-1,10,12,30,1000};

        assertArrayEquals(calculator.sortingArray(arr),numbers);
    }

    @Test

    public void emptySorting(){
        Calculator calculator = new Calculator();

        int arr [] ={};
        int numbers[]={};

        assertArrayEquals(calculator.sortingArray(arr),numbers);

    }

    @AfterEach

    public void tearDown(){
        System.out.println("After each test :");
    }

    @AfterAll

    public static void tearDownAfterClass(){
        System.out.println("After all tests :");
    }

}