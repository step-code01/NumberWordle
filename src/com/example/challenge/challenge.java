package com.example.challenge;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class challenge {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Local Time: " + currentTime);

        System.out.println("Welcome to Number Guessing Game! ");
        System.out.println("What is your name, user?: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        String greet;
        boolean isBefore = currentTime.isBefore(LocalTime.parse("12:00"));
        if (isBefore) greet = "Morning";
        else {
            boolean isBefore2 = currentTime.isBefore(LocalTime.parse("16:00"));
            if (isBefore2) greet = "Afternoon";
            else greet = "Evening";
        }

        System.out.println("Good " + greet + " " + name);

        System.out.println(name + "," + "should we start the game? [Y/n]");
        char response = sc.next().toLowerCase().charAt(0); //there isn't any nextChar(); in java
        if (response != 'y') { System.out.println("Have a great day! "); return; } //return type of main() class is void! imp (psvm!)

        System.out.println("Give a range you want your random number to be in ");
        System.out.println("(The higher the range, higher the difficulty) ");
        int range = sc.nextInt();

        Random rn = new Random();
        int number = rn.nextInt(range) + 1 ;

        System.out.println("Okay, the random number has been generated, take a guess between 0 and " + range + ": ");
        for (int i=1;i<=5;i++){ //beside the first time said, do while se can?
            int r = sc.nextInt();
            if (r == number) { System.out.println("Congratulations! You guessed it right in " + i + " try/tries! "); return;}
            else {
                System.out.println("No, try again!");   //TODO diff var of "no" dene hote toh kya karte
                if (r<number) System.out.println("(Hint: Try Higher)");
                else System.out.println("(Hint: Try Lower)");
            }
        }
        System.out.println("Sorry! your 5 tries are over! Game over..");
        System.out.println("The number was: " + number);
    }
}
