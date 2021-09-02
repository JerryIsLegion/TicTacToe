import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // creating two-dimensional array with 4x4 size because first element will be '1' not '0'
        char[][] grid = new char[4][4];
        // filling two-dimensional array with ' ' characters
        for (char[] line : grid) {
            Arrays.fill(line, ' ');
        }
        int justCounter = 0;
        System.out.println("Enter the coordinates: ");
        for (int i = 0; i < 9; i++) {
            while (true) {
                try {
                    int lineCords = scanner.nextInt();
                    int columnCords = scanner.nextInt();
                    // checks if variable lineCords or columnCords equal to 0 or array element not occupied by X or O
                    while (lineCords == 0 || columnCords == 0 || grid[lineCords][columnCords] != ' ') {
                        if (grid[lineCords][columnCords] != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            System.out.println("Coordinates should be from 1 to 3!");
                        }
                        lineCords = scanner.nextInt();
                        columnCords = scanner.nextInt();
                    }
                    // This condition changes current player to X or O
                    if (justCounter % 2 == 0) {
                        grid[lineCords][columnCords] = 'X';
                    } else {
                        grid[lineCords][columnCords] = 'O';
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                }
            }
            int xCounter = 0;
            int oCounter = 0;
            justCounter++;
            // This loop print updated field
            System.out.println("---------");
            for (int line = 1; line <= 3; line++) {
                System.out.print("| ");
                for (int column = 1; column <= 3; column++) {
                    System.out.print(grid[line][column] + " ");
                }
                System.out.print("|" + '\n');
            }
            System.out.println("---------");
            // checks if left or right diagonal line was filled with X or O
            String firstDiagonal = grid[1][1] + "" + grid[2][2] + grid[3][3];
            String secondDiagonal = grid[1][3] + "" + grid[2][2] + grid[3][1];
            if (firstDiagonal.equals("XXX") || secondDiagonal.equals("XXX")) {
                System.out.println("X wins");
                System.exit(0);
            } else if (firstDiagonal.equals("OOO") || secondDiagonal.equals("OOO")) {
                System.out.println("O wins");
                System.exit(0);
            }
            // checks if there was any filled vertical line with X or O
            for (int line = 1; line <= 3; line++) {
                for (int column = 1; column <= 3; column++) {
                    if (grid[line][column] == 'X') {
                        xCounter++;
                    } else if (grid[line][column] == 'O') {
                        oCounter++;
                    }
                }
                if (xCounter == 3 || oCounter == 3) {
                    if (xCounter == 3) {
                        System.out.println("X wins");
                        System.exit(0);
                    } else if (oCounter == 3) {
                        System.out.println("O wins");
                        System.exit(0);
                    }
                } else {
                    xCounter = 0;
                    oCounter = 0;
                }
            }
            // checks if there was any filled horizontal line with X or O
            for (int line = 1; line <= 3; line++) {
                for (int column = 1; column <= 3; column++) {
                    if (grid[column][line] == 'X') {
                        xCounter++;
                    } else if (grid[column][line] == 'O') {
                        oCounter++;
                    }
                }
                if (xCounter == 3 || oCounter == 3) {
                    if (xCounter == 3) {
                        System.out.println("X wins");
                        System.exit(0);
                    } else if (oCounter == 3) {
                        System.out.println("O wins");
                        System.exit(0);
                    }
                }
                xCounter = 0;
                oCounter = 0;
            }
            // print "Draw" if that was last iteration and not a single line was filled with just X or O
            if (i == 8) {
                System.out.println("Draw");
                System.exit(0);
            }
        }
    }
}
