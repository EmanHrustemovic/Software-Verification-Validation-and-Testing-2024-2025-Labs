import java.util.Arrays;

public class Calculator {

    private int age ;

    public int add(int a , int b){
        return a+b;
    }

    public int subtract(int a , int b){
        return a-b;
    }

    public int multiply(int a , int b){
        return a*b;
    }

    public int divide(int a , int b){
        if (b==0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a/b;
    }

    /*TASK 1*/

    public int factorial(int a) {
        if (a <0) {
            throw new IllegalArgumentException("Negative numbers cannot have factorials");
        }
        int re = 1;

        for(int i =1;i<=a;i++){
            re *= i;

        }
        return  re;
    }


    public String [] wordsArray(String  words ) {

        if(words==null){
            return null;
        }
        else {
            return words.trim().split("\\s+");
        }

    }

    public boolean isAdult(int age){
        if(age>=18){
            return true;
        }
        else {
            return false;
        }
    }

    public int[] sortingArray(int[] numbers){

        Arrays.sort(numbers);
        return numbers;

    }
}

