package number.analyzer;
import javax.swing.JOptionPane;

/*
 * Project Scope:
 * Write a generic class with a type parameter constrained to the
 * Number class or any subclass of Number. The constructor should accept an
 * array of such objects. The class should have methods that return the highest
 * and lowest values in the array, the total of the elements, and the average
 * value of all the elements. Demonstrate the class in an application.
 * 
 * Project File Name: Main.java
 * Project Date: 2/24/18
 * Author: Damian Ayres
 * @author dayre
 */
public class Main {

    public static void main(String[] args) {
        //initialize the number array as a reference type for the generic class
        Integer[] numbers = {5, 6, 5, 4, 3, 2, 1, 1, 9};
        //JOptionPane variables
        String input;
        int num;
        //return variable for getter methods
        Integer val;
        
        //begin processing
        num = JOptionPane.showConfirmDialog(null, "Enter your own numbers?");
        switch (num) {
        //yes
            case 0:
                input = JOptionPane.showInputDialog("Enter the size of the array");
                try{
                    Integer[] userArr = new Integer[Integer.parseInt(input)];
                    if (userArr.length != 0){   //check if length is > 0
                        JOptionPane.showMessageDialog(null, "Array size is " + Integer.parseInt(input));
                        for (int i = 0; i < userArr.length; i++){
                            input = JOptionPane.showInputDialog("Enter a number for position " + i);
                            try{    //check is a real number is entered, then set the number in the array
                            userArr[i] = Integer.parseInt(input);
                            } catch (NumberFormatException ex){
                                JOptionPane.showMessageDialog(null, "Not a number");
                                userArr[i] = 0;
                            }
                            JOptionPane.showMessageDialog(null, "You entered " + userArr[i]);               
                        }
                        //initialize new number analysis object
                        NumberAnalyzer<Integer> userNum = new NumberAnalyzer<>(userArr);
                        userNum.setArr(userArr);    //setting array to private field in NumberAnalyzer class
                        userNum.highVal();          //check for highest value
                        val = userNum.getVal();     //return the highest value
                        JOptionPane.showMessageDialog(null, "The highest value is " + val);
                        userNum.lowVal();           //check for lowest value
                        val = userNum.getVal();     //return the lowest value
                        JOptionPane.showMessageDialog(null, "The lowest value is " + val);
                        userNum.sum();              //find the sum of the values in the array
                        val = userNum.getSum();     //return the sum of the values
                        JOptionPane.showMessageDialog(null, "The sum of the array is " + val);
                        userNum.mean();             //find the average of the values in the array
                        val = userNum.getMean();    //return the average value of the array
                        JOptionPane.showMessageDialog(null, "The average of the values is " + val);
                        break;                    
                    } else {
                        JOptionPane.showMessageDialog(null, "You entered zero, that won't work");
                        break;
                    }                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You didn't enter a number");
                        break;
                }


        //no
            case 1:
                JOptionPane.showMessageDialog(null, "Using default numbers");
                JOptionPane.showMessageDialog(null, "Default set is: ");
                JOptionPane.showMessageDialog(null, numbers);
                //initialize new number analysis object
                NumberAnalyzer<Integer> defaultNum = new NumberAnalyzer<>(numbers);
                defaultNum.setArr(numbers);     //setting array to private field in NumberAnalyzer class
                defaultNum.highVal();           //check for highest value
                val = defaultNum.getVal();      //return the highest value
                JOptionPane.showMessageDialog(null, "The highest value is" + val);
                defaultNum.lowVal();            //check for lowest value
                val = defaultNum.getVal();      //return the lowest value
                JOptionPane.showMessageDialog(null, "The lowest value is " + val);
                defaultNum.sum();               //find the sum of the values in the array
                val = defaultNum.getSum();      //return the sum of the values
                JOptionPane.showMessageDialog(null, "The sum of the array is " + val);
                defaultNum.mean();              //find the average of the values in the array
                val = defaultNum.getMean();     //return the average value
                JOptionPane.showMessageDialog(null, "The average of the values is " + val);                
                break;
                
                
        //cancel
            case 2:
            default:
                break;
        }        
    }    
}
