import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char X = 'x';
    final char O = '0';
    final char empty = '.';
    char[][] matrix;
    Random comp;
    Scanner scan;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();
    }

    TicTacToe() {
        comp = new Random();
        scan = new Scanner(System.in);
        matrix = new char[3][3];
    }

    void initMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = empty;
            }
        }
    }

    void printMx() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    void human() {
        int x, y;
        do {
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!checkMx(x, y));
        if (matrix[x][y] == empty)
            matrix[x][y] = X;
        else {
            System.out.println("Wrong move. Please try again");
            human();
        }
    }

    void comp() {
        int x, y;
        do {
            x = comp.nextInt(3);
            y = comp.nextInt(3);
        } while (!checkMx(x, y));
        if (matrix[x][y] == empty)
            matrix[x][y] = O;
        else {
            System.out.println("Wrong move.Comp try again");
            comp();
        }
    }

    void human2() {
        int x, y;
        do {
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!checkMx(x, y));
        if (matrix[x][y] == empty)
            matrix[x][y] = O;
        else {
            System.out.println("Wrong move Human2. Please try again");
            human2();
        }
    }

    boolean checkMx(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) return false;
        return empty == matrix[y][x];
    }

    boolean winner(char type) {
        for (int i = 0; i < 3; i++)
            if ((matrix[i][0] == type && matrix[i][1] == type &&
                    matrix[i][2] == type) ||
                    (matrix[0][i] == type && matrix[1][i] == type &&
                            matrix[2][i] == type))
                return true;
        if ((matrix[0][0] == type && matrix[1][1] == type &&
                matrix[2][2] == type) ||
                (matrix[2][0] == type && matrix[1][1] == type &&
                        matrix[0][2] == type))
            return true;
        return false;
    }

    boolean isNotWinners() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == empty)
                    return false;
        return true;
    }

    void startGame() {
        initMatrix();
        while (true) {
            System.out.println("First gamer`s turn");
            human();
            if (winner(X)) {
                System.out.println("First gamer win! ");
                break;
            }
            if (isNotWinners()) {
                System.out.println("We haven`t winner (");
                break;
            }
            printMx();
            System.out.println("Second gamer`s turn");
            //You can replace to human2
            comp();
            printMx();
            if (winner(O)) {
                System.out.println("Second gamer win!");
                break;
            }
            if (isNotWinners()) {
                System.out.println("We have not winner (");
                break;
            }
        }
        System.out.println("GAME OVER!");
        printMx();
    }
}