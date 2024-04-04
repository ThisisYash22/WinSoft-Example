/*
 Q3:Write a Java Program to count the number of words in a string using HashMap.
*/
import java.util.HashMap;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        String input = "This is a sample string with repeated words, sample string";
        wordsCount(input);
    }

    public static void wordsCount(String input) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        input = input.toLowerCase();
        String[] words = input.split("[\\s,]+");
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("Word Counts:");
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }

    }
}
