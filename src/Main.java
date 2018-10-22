import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

            printPath(swingingPath, treeHeight);
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

    private static ArrayList<Integer> inputHeight(int numberOfTree) {

        System.out.println();
        System.out.println("    1. Random Tree Height");
        System.out.println("    2. Manual Input Height");

        int choice = inputChoice();
        System.out.println();
        ArrayList<Integer> treeHeight = new ArrayList<>();

        if (choice == 1) {
            Random rand = new Random();
            for (int i = 1; i <= numberOfTree; i++) {
                int height = rand.nextInt(999) + 1;
                treeHeight.add(height);
                System.out.println("    Tree #" + i + " Height = " + height);
            }
        } else {
            for (int i = 1; i <= numberOfTree; i++) {
                int height;
                do {
                    try {
                        Scanner scan = new Scanner(System.in);
                        System.out.print("    Tree #" + i + " Height [1-999] = ");
                        height = scan.nextInt();
                        if (height > 999 || height < 1) throw new Exception();
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
            System.out.print("\nChoice = ");
            choice = scan.nextInt();
            if (choice > 2 || choice < 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.");
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
            if (numberOfTree < 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again.\n");
            numberOfTree = inputTree();
        }

        return numberOfTree;

    }

}
