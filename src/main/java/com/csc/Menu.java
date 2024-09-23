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
        String stringInput;
        int defaultInt = 100;

        while(true) {
            System.out.println(prompt);
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
                stringInput = scanner.nextLine();
                if(stringInput.equals("default")) {
                    return defaultInt;
                }
                else if (stringInput.equals("exit")) {
                    System.out.println("Have a nice day! ");
                    System.exit(0);
                }
                else {
                    System.out.println(errorMessage);
                }
            }   
        }
    }

    public static void main(String[] args) {
        // Portfolio Add-On: Default Values
        System.out.println("Portfolio Add-On One");
        int defaultOption = validateMenuInteger(null, null, "Please enter a value. Enter \"default\" to use the default value of 100.", "Invalid input. Please try again.");
        System.out.println("The default value chosen by the user is " + defaultOption);

        // Scenario 1: No bounds (any integer is valid)
        System.out.println("\nScenario 1: No bounds (any integer is valid)");
        int result1 = validateMenuInteger(null, null, "Enter any integer: ", "Invalid input. Please try again.");
        System.out.println("You entered: " + result1);
        
        // Scenario 2: Lower bound only
        System.out.println("\nScenario 2: Lower bound only");
        int result2 = validateMenuInteger(10, null, "Enter an integer greater than or equal to 10: ", "Invalid input. Please try again.");
        System.out.println("You entered: " + result2);
        
        // Scenario 3: Upper bound only
        System.out.println("\nScenario 3: Upper bound only");
        int result3 = validateMenuInteger(null, 50, "Enter an integer less than or equal to 50: ", "Invalid input. Please try again.");
        System.out.println("You entered: " + result3);
        
        // Scenario 4: Both lower and upper bounds
        System.out.println("\nScenario 4: Both lower and upper bounds");
        int result4 = validateMenuInteger(10, 100, "Enter an integer between 10 and 100: ", "Invalid input. Please try again.");
        System.out.println("You entered: " + result4);
        
        // Scenario 5: Invalid input type
        System.out.println("\nScenario 5: Invalid input type (enter a non-integer)");
        int result5 = validateMenuInteger(1, 10, "Enter an integer between 1 and 10: ", "Invalid input. Please try again.");
        System.out.println("You entered: " + result5);

        // Portfolio Add-On: Aborting Entry
        System.out.println("\nPortfolio Add-On Two");
        validateMenuInteger(null, null, "Please enter a value. Enter \"exit\" to leave the menu.", "Invalid input. Please try again.");
    }
}
