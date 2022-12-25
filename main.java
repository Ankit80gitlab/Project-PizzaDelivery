import java.util.Scanner;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int pizzaPrice=0;
        int priceOfCrust=0;
        int priceOfToppings=0;
        int priceOfBread=0;
        int priceOfDrinks=0;

        connection.establishConnection();
        connection.createDatabase();
        connection.createTableAndKey();
        connection.dataInsertion();
        System.out.println("SUCCESSFULLY CONNECTED");
        System.out.println("------------------------------------------------------------------");
        System.out.println("WELCOME,PLEASE ENTER DETAILS TO CONTINUE");
        System.out.println("ENTER YOUR NAME");
        String name = sc.next();
        System.out.println("ENTER YOUR CONTACT NUMBER");
        long phoneNo = sc.nextLong();
        System.out.println("THANK YOU FOR PROVIDING INFORMATION");
        String input3="";
        while(!input3.equalsIgnoreCase("no"))
        {
            operations.displayingItem();
            System.out.println("ENTER S.NO. TO SELECT");
            int input = sc.nextInt();
            if (input == 1) {
                operations.displayingPizza();
                System.out.println("ENTER S.NO. TO SELECT");
                int pizzaChoice = sc.nextInt();
                System.out.println("ENTER SIZE - S,M,L");
                char pizzaSize = sc.next().charAt(0);

                if (pizzaChoice == 1) {
                    if (pizzaSize == 'R') {
                        pizzaPrice = 0;
                    } else if (pizzaSize == 'M') {
                        pizzaPrice = 350;
                    } else if (pizzaSize == 'L') {
                        pizzaPrice = 450;
                    }
                } else if (pizzaChoice == 2) {
                    if (pizzaSize == 'R') {
                        pizzaPrice = 0;
                    } else if (pizzaSize == 'M') {
                        pizzaPrice = 300;
                    } else if (pizzaSize == 'L') {
                        pizzaPrice = 400;
                    }
                } else if (pizzaChoice == 3) {
                    if (pizzaSize == 'R') {
                        pizzaPrice = 250;
                    } else if (pizzaSize == 'M') {
                        pizzaPrice = 350;
                    } else if (pizzaSize == 'L') {
                        pizzaPrice = 450;
                    }
                } else if (pizzaChoice == 4) {
                    if (pizzaSize == 'R') {
                        pizzaPrice = 200;
                    } else if (pizzaSize == 'M') {
                        pizzaPrice = 300;
                    } else if (pizzaSize == 'L') {
                        pizzaPrice = 400;
                    }
                } else if (pizzaChoice == 5) {
                    if (pizzaSize == 'R') {
                        pizzaPrice = 175;
                    } else if (pizzaSize == 'M') {
                        pizzaPrice = 375;
                    } else if (pizzaSize == 'L') {
                        pizzaPrice = 500;
                    }
                }
                operations.displayingCrust();
                System.out.println("ENTER S.NO. TO SELECT");
                int result2 = sc.nextInt();
                if (result2 == 0) {
                    priceOfCrust = 0;
                } else if (result2 == 1) {
                    priceOfCrust = 60;
                } else if (result2 == 2) {
                    priceOfCrust = 80;
                } else if (result2 == 3) {
                    priceOfCrust = 70;
                }
                operations.displayingTopping();
                System.out.println("ENTER S.NO. TO SELECT");
                int result3 = sc.nextInt();
                if (result3 == 0) {
                    priceOfToppings = 0;
                } else if (result3 == 1) {
                    priceOfToppings = 80;
                } else if (result3 == 2) {
                    priceOfToppings = 120;
                }
            } else if (input == 2) {
                operations.displayingGarlic();
                System.out.println("ENTER S.NO. TO SELECT");
                int result4 = sc.nextInt();
                if (result4 == 0) {
                    priceOfBread = 0;
                } else if (result4 == 1) {
                    priceOfBread = 90;
                } else if (result4 == 2) {
                    priceOfBread = 80;
                }
            } else if (input == 3) {
                operations.displayingBeverage();
                System.out.println("ENTER S.NO. TO SELECT");
                int result5 = sc.nextInt();
                if (result5 == 0) {
                    priceOfDrinks = 0;
                } else if (result5 == 1) {
                    priceOfDrinks = 60;
                } else if (result5 == 2) {
                    priceOfDrinks = 60;
                }
            }
            int total = pizzaPrice + priceOfCrust + priceOfToppings + priceOfBread + priceOfDrinks;
            System.out.println("YOUR TOTAL BILL IS " + total + " RUPPESS");
            connection.customerData(input, name, phoneNo, total);
            System.out.println("WOULD YOU LIKE TO ORDER AGAIN - YES/NO");
            input3 = sc.next();
            if(input3.equalsIgnoreCase("NO"))
                break;
            if(input3.equalsIgnoreCase("YES"))
            {
                total=0;
                pizzaPrice=0;
                priceOfCrust=0;
                priceOfToppings=0;
                priceOfBread=0;
                priceOfDrinks=0;
            }
        }
        System.out.println("THANK YOU FOR ORDERING FOOD, HAVA A GREAT DAY AHEAD");

    }
}
