import java.util.Arrays;
import java.util.ArrayList;

public class basics {
    //loop for 1-255
    public void oneTo255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    //loop for odd numbers 1-255
    public void oddTo255() {
        for (int i = 1; i <= 255; i+=2) {
                System.out.println(i);
            
        }
    }

    //Return Sum of 255
    public static int sum() {
        int sum = 0;
        for (int i = 1; i <= 255; i++) {
            sum = i + sum;
        }
        // System.out.println("The sum is " + sum ); do not print? Return would be
        return sum;
    }

    // Iterating through an Array
    public void iterateArray() {
        int[] iterateArray= {1,3,5,7,9,13};
        for (int i : iterateArray) {
            System.out.println(i);
        }
    }

    //Find Max
    public void maxArrayValue() {
        int [] arr = new int []{-3, -5, -7, 17};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            System.out.println("Max value is: " + max);
        }
    }

    //Array with Odd Numbers
    public void oddArray() {
        ArrayList <Integer> oddArrList = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i+=2) {
            oddArrList.add(i);
        }
        System.out.println(oddArrList);
    }
    }

