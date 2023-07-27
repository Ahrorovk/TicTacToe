import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char X = 'x';
    final char O = '0';
    final char empty = '.';
    char [][] matrix;
    Random comp;
    Scanner scan;
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.game();
        System.out.println("Hello world!");
    }
    TicTacToe(){
        comp = new Random();
        scan = new Scanner(System.in);
        matrix = new char[3][3];
    }

    void initMatrix(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                matrix[i][j] = empty;
            }
        }
    }
    void printMx(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
    }
    void human() {
        int x,y;
        do {
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!checkMx(x,y));
        if(matrix[x][y]==empty)
            matrix[x][y] = X;
        else {
            System.out.println("Wrong move. Please try again");
            human();
        }
    }
    void comp(){
        int x,y;
        do {
            x = comp.nextInt(3);
            y = comp.nextInt(3);
        }while (!checkMx(x,y));
        if(matrix[x][y]==empty)
            matrix[x][y] = O;
        else {
            System.out.println("Wrong move.Comp try again");
            comp();
        }
    }
    boolean checkMx(int x,int y){
        if(x<0 || y<0 || x>=3 || y>=3) return false;
        return empty == matrix[y][x];
    }
    boolean winner(char type){
        int fSide=0,sSide=0,thSide=0,frSide=0,ffSide=0;
        for (int i=0;i<3;i++){
                if(matrix[0][i]==type){
                    fSide++;
                }
                if(matrix[i][0]==type){
                    sSide++;
                }
                if(matrix[i][i]==type){
                    thSide++;
                }
                if(matrix[2][i]==type){
                    frSide++;
                }
                if(matrix[i][2]==type){
                    ffSide++;
                }
        }
        return fSide==3 || sSide==3 || thSide==3 || frSide==3 || ffSide==3;
    }
    boolean isNotWinners(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == empty)
                    return false;
        return true;
    }
    void game(){
        initMatrix();
        while (true) {
            human();
            if(winner(X)){
                System.out.println("You win! :)");
                break;
            }
            if(isNotWinners()){
                System.out.println("We haven`t winner (");
                break;
            }
            comp();
            printMx();
            if(winner(O)){
                System.out.println("Comp win! :(");
                break;
            }
            if(isNotWinners()){
                System.out.println("We have not winner (");
                break;
            }
        }
        System.out.println("GAME OVER!");
        printMx();
    }
}