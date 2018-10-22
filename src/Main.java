import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class EmptyInputException extends Exception {
    EmptyInputException() { super(); }
}

public class Main {

    public static void main(String[] args) {

        String choice;

        do {

            System.out.print(" ---- \n" +
                             "/    \\ \n" +
                             "\\    /\n" +
                             " ---- \n" +
                             "  ||  \n");

            int numberOfTree = inputTree();
            ArrayList<Integer> treeHeight = inputHeight(numberOfTree);

            ArrayDeque<int []> swingingPath = new ArrayDeque<>();
            ArrayDeque<Integer> indexStack = new ArrayDeque<>();

            for (int index = 0; index < treeHeight.size(); index++) {
                calculatePath(swingingPath, indexStack, treeHeight, index);
                indexStack.push(index);
            }

            boolean output = outputPrompt();
            if (output) printPath(swingingPath, treeHeight);
            System.out.printf("\n   Total Swinging Path = %,d\n", swingingPath.size());

            choice = inputContinue();

        } while (choice.equalsIgnoreCase("Y"));

    }

    private static void printPath(ArrayDeque<int []> swingingPath, ArrayList<Integer> treeHeight) {
        if (swingingPath.size() == 0) return;
        System.out.println();
        int count = 0;
        for (int [] path : swingingPath) {
            count++;
            System.out.printf("%5d)   Tree #%-5d (%3d-ft) <--> Tree #%-5d (%3d-ft)\n",
                              count, path[0] + 1, treeHeight.get(path[0]), path[1] + 1, treeHeight.get(path[1]));
        }
    }

    private static void calculatePath(ArrayDeque<int []> swingingPath, ArrayDeque<Integer> indexStack, ArrayList<Integer> treeHeight, int index) {
        if (indexStack.isEmpty()) return;
        int [] path = {indexStack.peek(), index};
        swingingPath.add(path);
        if (treeHeight.get(path[0]) < treeHeight.get(path[1])) {
            do { indexStack.pop(); }
            while (!indexStack.isEmpty() && treeHeight.get(indexStack.peek()).equals(treeHeight.get(path[0])));
            calculatePath(swingingPath, indexStack, treeHeight, index);
        }
    }

    private static boolean outputPrompt() {

        String choice;
        boolean output = false;
        Scanner scan = new Scanner(System.in);

        do {
            try {
                System.out.print("\nDo you want output ? (Y/N) : ");
                choice = scan.nextLine();
                choice = choice.trim();
                if (choice.equalsIgnoreCase("Y")) output = true;
                else if (!choice.equalsIgnoreCase("N")) throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid Input, Please Try Again.");
                choice = "";
            }
        } while (choice.equalsIgnoreCase(""));

        return output;

    }

    private static ArrayList<Integer> inputHeight(int numberOfTree) {

        ArrayList<Integer> treeHeight = new ArrayList<>();

        System.out.println();
        System.out.println("    1. Random Tree Height");
        System.out.println("    2. Manual Input Height");

        int choice = inputChoice();

        if (choice == 2) {
            System.out.println("    Tree height support range : 1 ~ 999");
            System.out.println("    Leave field empty to Random the rest.");
            System.out.println();
        }

        for (int i = 1; i <= numberOfTree; i++) {

            int height;

            if (choice == 1) {
                Random rand = new Random();
                height = rand.nextInt(999) + 1;
                System.out.printf("    Tree #%-5d Height = %d\n", i, height);
                treeHeight.add(height);
            }
            else {
                do {
                    try {
                        System.out.printf("    Tree #%-5d Height = ", i);
                        Scanner scan = new Scanner(System.in);
                        String medium = scan.nextLine();

                        if (medium.equals("")) throw new EmptyInputException();

                        height = Integer.parseInt(medium.trim());
                        if (height > 999 || height < 1) throw new Exception();
                        treeHeight.add(height);

                    } catch (EmptyInputException e) { choice = 1; i--; break; }
                      catch (Exception e) { height = 0; }
                } while (height == 0);
            }

        }

        return treeHeight;

    }

    private static int inputChoice() {

        int choice;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("\nChoice = ");
            choice = scan.nextInt();
            if (choice > 2 || choice < 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.");
            choice = inputChoice();
        }

        System.out.println();

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
            if (numberOfTree < 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.\n");
            numberOfTree = inputTree();
        }

        return numberOfTree;

    }

}
