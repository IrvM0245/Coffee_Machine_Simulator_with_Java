package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //0 = Water, 1 = Milk, 2 = Coffee, 3 = cups, 4 money
        int[] ingredients = {400, 540, 120, 9, 550};
        //printIngredientsInCoffeeMachine(ingredients);
        boolean menu = false;
        while (!menu) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String buyingOption = scanner.next();
                if (!buyingOption.equals("back")) {
                   String result = prepareCoffee(Integer.parseInt(buyingOption), ingredients);
                   if(result.length()  > 10){
                       System.out.println(result);
                   }else{
                       System.out.printf("Sorry, not enough %s!\n",result);
                   }
                    System.out.println();
                }
            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                ingredients[0] += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                ingredients[1] += scanner.nextInt();
                System.out.println("Write how many grams of beans you want to add:");
                ingredients[2] += scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                ingredients[3] += scanner.nextInt();
                System.out.println();
            } else if (action.equals("take")) {
                System.out.println();
                System.out.printf("I gave you $%d\n", ingredients[4]);
                ingredients[4] = 0;
                System.out.println();
            } else if (action.equals("remaining")) {
                System.out.println();
                printIngredientsInCoffeeMachine(ingredients);
                System.out.println();
            } else if (action.equals("exit")) {
                menu = true;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void calculateIngridients(int cups, int currentWater, int currentMilk, int currentCoffee) {
        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int COFFEE_BEANS_PER_CUP = 15;
        final int WATER_NEEDED = WATER_PER_CUP * cups;
        final int MILK_NEEDED = MILK_PER_CUP * cups;
        final int COFFEE_NEEDED = COFFEE_BEANS_PER_CUP * cups;
        final int WATER_FOR_CUPS = currentWater / WATER_PER_CUP;
        final int MILK_FOR_CUPS = currentMilk / MILK_PER_CUP;
        final int COFFEE_FOR_CUPS = currentCoffee / COFFEE_BEANS_PER_CUP;
        int minimumOfCups = WATER_FOR_CUPS;
        if (MILK_FOR_CUPS < WATER_FOR_CUPS) {
            minimumOfCups = MILK_FOR_CUPS;
        }
        if (MILK_FOR_CUPS > COFFEE_FOR_CUPS) {
            minimumOfCups = COFFEE_FOR_CUPS;
        }
        if (minimumOfCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (minimumOfCups < cups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", minimumOfCups);
        } else if (currentWater > WATER_NEEDED & currentMilk > MILK_NEEDED & currentCoffee > COFFEE_NEEDED) {
            int difference = minimumOfCups - cups;
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", difference);
            System.out.println();
        }
    }

    private static String prepareCoffee(int coffeeType, int[] ingredients) {
        //0 = Water, 1 = Milk, 2 = Coffee, 3 = cups, 4 money
        switch (coffeeType) {
            case 1: {
                if (ingredients[0] < 250) {
                    return "Water";
                } else if (ingredients[2] < 16) {
                    return "Coffee";
                } else if (ingredients[3] < 1) {
                    return "Cups";
                } else {
                    ingredients[0] -= 250;
                    ingredients[2] -= 16;
                    ingredients[3] -= 1;
                    ingredients[4] += 4;
                    return "I have enough resources, making you a coffee!";
                }
            }
            case 2: {
                if (ingredients[0] < 350) {
                    return "Water";
                } else if (ingredients[1] < 75) {
                    return "Milk";
                } else if (ingredients[2] < 20) {
                    return "Coffee";
                } else if (ingredients[3] < 1) {
                    return "Cups";
                } else {
                    ingredients[0] -= 350;
                    ingredients[1] -= 75;
                    ingredients[2] -= 20;
                    ingredients[3] -= 1;
                    ingredients[4] += 7;
                    return "I have enough resources, making you a coffee!";
                }

            }
            case 3: {
                if (ingredients[0] < 200) {
                    return "Water";
                } else if (ingredients[1] < 100) {
                    return "Milk";
                } else if (ingredients[2] < 12) {
                    return "Coffee";
                } else if (ingredients[3] < 1) {
                    return "Cups";
                } else {
                    ingredients[0] -= 200;
                    ingredients[1] -= 100;
                    ingredients[2] -= 12;
                    ingredients[3] -= 1;
                    ingredients[4] += 6;
                    return "I have enough resources, making you a coffee!";
                }
            }
        }
        return "";
    }

    private static void printIngredientsInCoffeeMachine(int[] ingredients) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", ingredients[0]);
        System.out.printf("%d ml of milk\n", ingredients[1]);
        System.out.printf("%d g of coffee beans\n", ingredients[2]);
        System.out.printf("%d disposable cups\n", ingredients[3]);
        System.out.printf("$%d of money\n", ingredients[4]);
    }
}
