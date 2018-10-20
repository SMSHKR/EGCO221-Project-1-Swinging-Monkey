import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String choice;

        do {

            int numberOfTree = inputTree();
            ArrayList<Integer> treeHeight = inputHeight(numberOfTree);
            ArrayDeque<int []> swingingPath = calculatePath(treeHeight);

            System.out.println("\nTotal Swinging Path = " + swingingPath.size());

            choice = inputContinue();

        } while (choice.equalsIgnoreCase("Y"));

    }

    private static ArrayDeque<int []> calculatePath(ArrayList<Integer> treeHeight) {

        System.out.println();

        ArrayDeque<int []> swingingPath = new ArrayDeque<>();
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < treeHeight.size(); i++) {
            if (indexStack.isEmpty()) indexStack.push(i);
            else {
                calculatePath(swingingPath, indexStack, treeHeight, i);
                indexStack.push(i);
            }
        }

        return swingingPath;

    }

    private static void calculatePath(ArrayDeque<int []> swingingPath, ArrayDeque<Integer> indexStack, ArrayList<Integer> treeHeight, int i) {
        if (indexStack.isEmpty()) return;
        int [] path = {indexStack.peek(), i};
        swingingPath.add(path);
        printPath(swingingPath.size(), path, treeHeight);
        if (treeHeight.get(indexStack.peek()) < treeHeight.get(i)) {
            indexStack.pop();
            calculatePath(swingingPath, indexStack, treeHeight, i);
        }
        /*
        while (!indexStack.isEmpty() && indexStack.peek() < height) {
            indexStack.pop();
            if (!indexStack.isEmpty()) {
                numberOfSwingingPath++;
                System.out.printf("%3d.   From %3d-ft tree to %3d-ft tree\n", numberOfSwingingPath, indexStack.peek(), height);
            }
        }
        */
    }

    private static void printPath(int count, int [] path, ArrayList<Integer> treeHeight) {
        System.out.printf("%3d.   From %3d-ft tree to %3d-ft tree\n", count, treeHeight.get(path[0]), treeHeight.get(path[1]));
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
