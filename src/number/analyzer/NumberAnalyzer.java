package number.analyzer;
import java.util.*;

/* 
 * Project File Name: NumberAnalyzer.java
 * Project Date: 2/24/18
 * Author: Damian Ayres
 * @author dayre
 * Project Scope:
 * 1.   Write a generic class with a type parameter constrained to the number
 *      class or any subclass of Number [x]
 * 2.   The constructor should accept an array of such objects [x]
 * 3.   The class should have a method that returns the highest 
 *      value in the array [x]
 * 4.   The class should have a method that returns the lowest 
 *      value in the array [x]
 * 5.   The class should have a method that returns the total value of the 
 *      elements in the array [x]
 * 6.   The class should have a method that returns the average value of the 
 *      elements in the array [x]
 */

public class NumberAnalyzer<E extends Number> {
    private E[] numArr; //used with setter method for number array
    private E   val;    //return variable for min and max values
    private int sum;    //return variable the sum
    private int mean;   //return variable for the average

    /**
     * CONSTRUCTOR
     * @param numbers[] The number array
    */
    public NumberAnalyzer(E numbers[]){
        
    }
   
    //setter method
    public void setArr(E arr[]){
        numArr = arr;
    }
    
    //getter method to return single value from number array
    public E getVal(){
        return val;
    }
    //getter method to return the sum as an int
    public int getSum(){
        return sum;
    }
    //getter method to return the mean as an int
    public int getMean(){
        return mean;
    }
        
    //finds the highest value in the array
    public void highVal(){
        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr));
        val = numArr[numArr.length - 1];
        System.out.println(val);
    }
    
    //finds the lowest value in the array
    public void lowVal(){
        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr));
        val = numArr[0];
        System.out.println(val);
    }
    
    //finds the total of the elements in the array
    public void sum(){
        List<? extends Number> sumList = Arrays.asList(numArr);
        sum = sumList
                .stream()
                .mapToInt(Number::intValue)
                .sum();
        System.out.println(sum);
    }
    
    //finds the average value of the elements in the array
    public void mean(){
        List<? extends Number> meanList = Arrays.asList(numArr);
        mean = meanList
                .stream()
                .mapToInt(Number::intValue)
                .sum() / meanList.size();
        System.out.println(mean);
    }
}
