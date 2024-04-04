/*
Q4:Write a Java Program to find the duplicate characters in a string.
*/
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String:");
        String input = sc.nextLine();

        duplicateChar(input);
    }

    public static void duplicateChar(String input) {
        int count;

        //Converts given string into character array
        char string[] = input.toCharArray();

        System.out.println("\nDuplicate characters in a given string: ");
        //Counts each character present in the string
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    string[j] = '0';
                }
            }

            if(count > 1 && string[i] != '0') {
                System.out.println(string[i]);

            }



        }
    }
}
