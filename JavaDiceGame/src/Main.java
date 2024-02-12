import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---   Start game   ---");

        int countUser = 0;
        int countComp = 0;

        int computer = 0;
        int userNum=0;


        for (int round = 1; round < 4; round++) {
            System.out.println("Round: " + round);

            System.out.print("Predicted amount of points (2...12):");
            //int userNum = 0;
            userNum = scanner.nextInt();
            while (userNum < 2 || userNum > 12) {
                System.out.println("Invalid input ! Predicted amount of points (2...12)::");
                userNum = scanner.nextInt();
            }
            System.out.println("User rolls the dices...");
            int playerRoll = rollTheDice(random);
            //int countUser = 0;
            countUser += calculateScore(playerRoll, userNum);



            computer = random.nextInt(2, 12);
            System.out.println("Computer predicted " + computer + " points...\nComputer rolls the dices...");
            int computerRoll = rollTheDice(random);

            countComp += calculateScore(computerRoll, computer);

        }


        System.out.println("---------- Curent score ---------\n" +
                " | User   | Computer |\n" +
                " +--------+----------+\n" +
                " | " + countUser + "     | " + countComp + "      |");


        if (countUser > countComp) {

            System.out.println("User win " + (countUser - countComp) + " points more.");
        } else if (countUser < countComp) {

            System.out.println("Computer is ahead by " + (countComp - countUser) + " points");
        } else {
            System.out.println(" == ");

        }
        System.out.println("\n-----------Finish game--------------------\n" +
                "| Round  | User         | Computer       |\n" +
                "+-------+---------------+-----------------+\n" +
                "|       | Predicted: "+userNum+"  | Predicted: " + computer + "  |\n" +
                "| - 1 - | Dice:         | Dice:         |\n" +
                "|       | Result:       | Result:       |\n" +
                "+-------+---------------+---------------+\n" +
                "|       | Predicted: "+userNum+"  | Predicted: " + computer + "  |\n" +
                "| - 2 - | Dice:         | Dice:         |\n" +
                "|       | Result:       | Result:       |\n" +
                "+-------+---------------+---------------+\n"+
                "|       | Predicted: "+userNum+"  | Predicted: " + computer + "  |\n" +
                "| - 3 - | Dice:         | Dice:         |\n" +
                "|       | Result:       | Result:       |\n" +
                "+-------+---------------+---------------+\n");


    }


    public static void printDice(int a) {
        switch (a) {
            case 1:
                System.out.println("""
                        \n  +-------+
                          |       |
                          |   #   |
                          |       |
                          +-------+
                           """);

                break;
            case 2:
                System.out.println("""
                        \n   +-------+
                           | #     |
                           |       |
                           |     # |
                           +-------+
                           """);

                break;
            case 3:
                System.out.println("""
                        \n  +-------+
                          | #     |
                          |   #   |
                          |     # |
                          +-------+
                          """);
                break;
            case 4:
                System.out.println("""
                        \n  +-------+
                          | #   # |
                          |       |
                          | #   # |
                          +-------+
                          """);

                break;
            case 5:
                System.out.println("""
                        \n  +-------+
                          | #   # |
                          |   #   |
                          | #   # |
                          +-------+
                          """);

                break;
            case 6:
                System.out.println("""
                        \n  +-------+
                          | #   # |
                          | #   # |
                          | #   # |
                          +-------+
                          """);

                break;
            default:
                break;
        }
    }

    public static int calculateScore(int a, int b) {
        int result = a - Math.abs(a - b) * 2;
        System.out.println("On the dice fell " + a + " points.");
        System.out.println("Result is " + a + "-abs(" + a + "-" + b + ") * 2: " + result + " points\n");
        return result;
    }

    public static int rollTheDice(Random random) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            int b = random.nextInt(1, 7);
            printDice(b);
            count += b;

        }
        return count;


    }
}