/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Colin Mitchell
 */

package ex27;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first name: ");
        String first_name = input.nextLine();

        System.out.print("Enter the last name: ");
        String last_name = input.nextLine();

        System.out.print("Enter the ZIP code: ");
        String zip_code = input.nextLine();

        System.out.print("Enter the employee ID: ");
        String employee_id = input.nextLine();

        validateInput(first_name, last_name, employee_id, zip_code);
    }

    public static void validateInput(String first_name, String last_name, String employee_id, String zip_code) {
        int error_found = 0;

        switch(validateName(first_name)) {
            case 0:
                break;
            case 1:
                System.out.println("The first name must be filled in.");
                error_found = 1;
                break;
            case 2:
                System.out.println("The first name must be at least 2 characters long.");
                error_found = 1;
                break;
            case 3:
                System.out.println("The first name must be at least 2 characters long.");
                System.out.println("The first name must be filled in.");
                error_found = 1;
                break;
        }

        switch(validateName(last_name)) {
            case 0:
                break;
            case 1:
                System.out.println("The last name must be filled in.");
                error_found = 1;
                break;
            case 2:
                System.out.println("The last name must be at least 2 characters long.");
                error_found = 1;
                break;
            case 3:
                System.out.println("The last name must be at least 2 characters long.");
                System.out.println("The last name must be filled in.");
                error_found = 1;
                break;
        }

        switch(validateEmployeeID(employee_id)) {
            case 0:
                break;
            case 1:
                System.out.println("The employee ID must be in the format of AA-1234.");
                error_found = 1;
                break;
        }

        switch(validateZIPCode(zip_code)) {
            case 0:
                break;
            case 1:
                System.out.println("The zipcode must be a 5 digit number.");
                error_found = 1;
                break;
        }

        if(error_found == 0) {
            System.out.println("There were no errors found.");
        }
    }

    public static int validateName(String name) {
        if(name.length() < 2 && name.equals("")) {
            return 3;
        }
        else if(name.length() < 2) {
            return 2;

        }
        else if(name.equals("")) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int validateEmployeeID(String employee_id) {
        char[] id = employee_id.toCharArray();
        char dash = '-';
        if(employee_id.length() == 7) {
            if(Character.isLetter(id[0]) && Character.isLetter(id[1]) && id[2] == dash && Character.isDigit(id[3]) && Character.isDigit(id[4]) && Character.isDigit(id[5]) && Character.isDigit(id[6])) {
                return 0;
            }else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }

    public static int validateZIPCode(String zip_code) {
        if(zip_code.length() != 5) {
            return 1;
        }

        try{
            int num = parseInt(zip_code);
            return 0;
        }catch(NumberFormatException e) {
            return 1;
        }
    }
}