package machine;

import java.util.Scanner;
import java.lang.Math;

public class CoffeeMachine {

    private static int money = 550;
    private static int waterLeft = 400;
    private static int milkLeft = 540;
    private static int coffeeBeansLeft = 120;
    private static int disposableCups = 9;
    private final static int WATER_FOR_ESPRESSO = 250;
    private final static int WATER_FOR_LATTE = 350;
    private final static int WATER_FOR_CAPPUCCINO = 200;
    private final static int MILK_FOR_LATTE = 75;
    private final static int MILK_FOR_CAPPUCCINO = 100;
    private final static int COFFEE_BEANS_FOR_ESPRESSO = 16;
    private final static int COFFEE_BEANS_FOR_LATTE = 20;
    private final static int COFFEE_BEANS_FOR_CAPPUCCINO = 12;
    private final static int PRICE_ESPRESSO = 4;
    private final static int PRICE_LATTE = 7;
    private final static int PRICE_CAPPUCCINO = 6;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String s = "";
        do {
            System.out.println("Write action (buy, fill, take, reamining, exit): ");
            s = sc.next();
            chooseAction(s);
        } while (!("exit".equals(s)));
    }

    private static void printProcess() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

    private static void printLeftIngredients() {
        System.out.println("\nThe coffee machine has: ");
        System.out.println(waterLeft + " ml of water");
        System.out.println(milkLeft + " ml of milk");
        System.out.println(coffeeBeansLeft + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    private static void makeCoffee(int coffeeType) {
        if (disposableCups == 0) {
            System.out.println("Sorry, not enought disposable cups!");
            return;
        }
        switch (coffeeType) {
            case 1:
                if (waterLeft < WATER_FOR_ESPRESSO) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeansLeft < COFFEE_BEANS_FOR_ESPRESSO) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterLeft -= WATER_FOR_ESPRESSO;
                    coffeeBeansLeft -= COFFEE_BEANS_FOR_ESPRESSO;
                    disposableCups--;
                    money += PRICE_ESPRESSO;
                }
                break;
            case 2:
                if (waterLeft < WATER_FOR_LATTE) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkLeft < MILK_FOR_LATTE) {
                    System.out.println("Sorry, not enough milk");
                } else if (coffeeBeansLeft < COFFEE_BEANS_FOR_LATTE) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterLeft -= WATER_FOR_LATTE;
                    milkLeft -= MILK_FOR_LATTE;
                    coffeeBeansLeft -= COFFEE_BEANS_FOR_LATTE;
                    disposableCups--;
                    money += PRICE_LATTE;
                }
                break;
            case 3:
                if (waterLeft < WATER_FOR_CAPPUCCINO) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkLeft < MILK_FOR_CAPPUCCINO) {
                    System.out.println("Sorry, not enough milk");
                } else if (coffeeBeansLeft < COFFEE_BEANS_FOR_CAPPUCCINO) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterLeft -= WATER_FOR_CAPPUCCINO;
                    milkLeft -= MILK_FOR_CAPPUCCINO;
                    coffeeBeansLeft -= COFFEE_BEANS_FOR_CAPPUCCINO;
                    disposableCups--;
                    money += PRICE_CAPPUCCINO;
                }
                break;
        }
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeans = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cups = sc.nextInt();
        waterLeft += water;
        milkLeft += milk;
        coffeeBeansLeft += coffeeBeans;
        disposableCups += cups;
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void chooseAction(String s) {
        if ("buy".equals(s)) {
            System.out.println("What do you want to buy? 1 - espresso, "
                    + "2 - latte, 3 - cuppuccino, back - to main menu:");
            String coffeeType = sc.next();
            if ("1".equals(coffeeType) || "2".equals(coffeeType)
                    || "3".equals(coffeeType)) {
                makeCoffee(Integer.parseInt(coffeeType));
            } else {
                return;
            }
        } else if ("fill".equals(s)) {
            fillMachine();
        } else if ("take".equals(s)) {
            takeMoney();
        } else if ("remaining".equals(s)) {
            printLeftIngredients();
        }
    }
}
