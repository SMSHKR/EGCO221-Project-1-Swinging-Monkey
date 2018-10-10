import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfTree = 0;
        while (numberOfTree == 0) numberOfTree = inputTree();

    }

    private static int inputTree() {
        // FIXME NoSuchElementException
        int numberOfTree;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("#Trees : ");
            numberOfTree = scan.nextInt();
            if (numberOfTree < 0) throw new Exception();
        } catch (Exception e) {
            // e.printStackTrace();
            numberOfTree = 0;
            System.err.println("Invalid Input, Please Try Again.");
        }

        return numberOfTree;

    }

}
