package com.csc;

import java.util.Scanner;

public class Menu {

    /*
     * This function is intended to be a generalized menu input function which can be customized
     * later by the programmers needs. For now, it returns the user input's number if it is within the range.
     * If it is not within the range, then it continues to prompt the user until correct.
     * @param lowerbound, upperbound, prompt, errorMessage
     */
    public static int validateMenuInteger(Integer lowerBound, Integer upperBound, String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        Integer userInput;

        while(true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if ((lowerBound == null || userInput >= lowerBound) && (upperBound == null || userInput <= upperBound)) {
                    return userInput;
                } 
                else {
                    System.out.println(errorMessage);
                }
            } 
            else {
                System.out.println(errorMessage);
                scanner.next(); 
            }
        }
    }

    public static void main(String[] args) {
        int result = validateMenuInteger(10, 100, "Enter an integer between 10 and 100: ", "Invalid input. Please try again");
        System.out.println("You entered: " + result);
    }
}
