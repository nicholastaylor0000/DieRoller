package com.company;

import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Nicholas Taylor
 * DND Die Roller
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char state = 'r';
        while(state == 'r') {
            System.out.println("DND Die Roller :: Nicholas Taylor");
            System.out.println(":::::::::::::::::::::::::::::::::");
            System.out.print("\nEnter the amount of dice to roll: ");
            int diceAmount = sc.nextInt();

            System.out.print("Enter the amount of sides on each die: ");
            int diceSides = sc.nextInt();

            boolean rollingSame = true;
            int count = 0;
            
            while(rollingSame) {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                count++;
                System.out.println("\n************");
                System.out.println("Rolling Dice at " + dtf.format(now));
                System.out.println("Roll " + count + " of Dice");
                System.out.println("************\n");

                int totalRoll = 0;

                for (int i = 0; i < diceAmount; ++i) {
                    Die d = new Die(diceSides);
                    int dieRoll = roll(d);
                    System.out.println("Die " + (i + 1) + " rolled a " + dieRoll);
                    totalRoll += dieRoll;
                }

                System.out.println("\nTotal: " + totalRoll);
                System.out.print("\nRoll Same Dice Again? (Y/N): ");

                String again = "";
                again = sc.next();
                if(again.contains("N")){
                    rollingSame = false;
                    System.out.println();
                }
            }
        }
    }

    /**
     * Used to roll die
     * @param d - die
     * @return int of user roll for die
     */
    public static int roll(Die d){
        int value = 0;
        value = (int) (Math.random() * (d.getSides()) + 1);
        return value;
    }

}
