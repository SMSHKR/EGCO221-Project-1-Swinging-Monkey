import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String choice;

        do {

            int numberOfTree = 0;
            while (numberOfTree == 0) numberOfTree = inputTree();

            choice = inputChoice();

        } while (choice.equalsIgnoreCase("Y"));


    }

    private static String inputChoice() {

        String choice;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Do you want to continue ? (Y/N) : ");
            choice = scan.next();
            choice = choice.trim();
            if (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"))
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.\n");
            choice = inputChoice();
        }

        return choice;

    }

    private static int inputTree() {

        int numberOfTree;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("#Trees : ");
            numberOfTree = scan.nextInt();
            if (numberOfTree <= 0) throw new Exception();
        } catch (Exception e) {
            numberOfTree = 0;
            System.out.println("Invalid Input, Please Try Again.\n");
        }

        return numberOfTree;

    }

}
