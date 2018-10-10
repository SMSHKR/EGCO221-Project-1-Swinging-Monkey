import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfTree = 0;
        while (numberOfTree == 0) numberOfTree = inputTree();

    }

    private static int inputTree() {

        int numberOfTree;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("#Trees : ");
            numberOfTree = scan.nextInt();
            if (numberOfTree < 0) throw new Exception();
        } catch (Exception e) {
            // e.printStackTrace();
            numberOfTree = 0;
            System.out.println("Invalid Input, Please Try Again.\n");
        }

        return numberOfTree;

    }

}
