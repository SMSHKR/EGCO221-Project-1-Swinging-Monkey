import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String choice;

        do {

            int numberOfTree = inputTree();

            choice = inputChoice();

        } while (choice.equalsIgnoreCase("Y"));


    }

    private static String inputChoice() {

        String choice;
        Scanner scan = new Scanner(System.in);

        do {
            try {
                System.out.print("\nDo you want to continue ? (Y/N) : ");
                choice = scan.nextLine();
                choice = choice.trim();
                if (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"))
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid Input, Please Try Again.");
                choice = "";
            }
        } while (choice.equalsIgnoreCase(""));

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
            System.out.println("Invalid Input, Please Try Again.\n");
            numberOfTree = inputTree();
        }

        return numberOfTree;

    }

}
