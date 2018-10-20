import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String choice;

        do {

            int numberOfTree = inputTree();
            ArrayList<Integer> treeHeight = inputHeight(numberOfTree);

            choice = inputContinue();

        } while (choice.equalsIgnoreCase("Y"));


    }

    private static ArrayList<Integer> inputHeight(int numberOfTree) {

        System.out.println("    1. Random Tree Height");
        System.out.println("    2. Manual Input Height");

        int choice = inputChoice();
        ArrayList<Integer> treeHeight = new ArrayList<>();

        if (choice == 1) {
            Random rand = new Random();
            for (int i = 1; i <= numberOfTree; i++) {
                int height = rand.nextInt(100) + 1;
                treeHeight.add(height);
                System.out.println("    Tree #" + i + " Height = " + height);
            }
        } else {
            for (int i = 1; i <= numberOfTree; i++) {
                int height;
                do {
                    try {
                        Scanner scan = new Scanner(System.in);
                        System.out.print("    Tree #" + i + " Height [1-100] = ");
                        height = scan.nextInt();
                        if (height > 100 || height < 1) throw new Exception();
                    } catch (Exception e) { height = 0; }
                } while (height == 0);
                treeHeight.add(height);
            }
        }

        return treeHeight;

    }

    private static int inputChoice() {

        int choice;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Choice = ");
            choice = scan.nextInt();
            if (choice > 2 || choice < 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.\n");
            choice = inputChoice();
        }

        return choice;

    }

    private static String inputContinue() {

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
