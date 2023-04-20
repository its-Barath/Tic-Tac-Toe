import java.util.*;
public class TicTacToeGame {
    public static void main(String[] args) {
        int pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 , Enter your name : ");
        String p1 = sc.nextLine();
        System.out.println("Player 2 , Enter your name : ");
        String p2 = sc.nextLine();

        TicTacToe(p1,p2);

    }
    public static void TicTacToe(String p1,String p2){
        int pos;
        Scanner sc=new Scanner(System.in);
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        boolean isPlayer1 =true;
        boolean gameEnded = false;

        while(!gameEnded){
            printBoard(board);

            char symbol = ' ';
            if(isPlayer1)
                symbol = 'X';
            else
                symbol = 'O';

            if(isPlayer1)
                System.out.println(p1+ "'s turn [X] , enter pos (1-9) : ");
            else
                System.out.println(p2+ "'s turn [o] , enter pos (1-9) : ");

            while(true) {
                pos=sc.nextInt();
                if(pos<1 || pos>9)
                    System.out.println("enter valid position (1-9) ");
                else
                    break;

            }
            gameBoard(board,pos,symbol);

            if(hasWon(board)=='X') {
                System.out.println(p1 + " has Won");
                gameEnded =true;
            }
            else if(hasWon(board)=='O') {
                System.out.println(p2 + " has Won");
                gameEnded = true;
            }
            else{
                if(hasTied(board)) {
                    System.out.println("Its a Tie");
                    gameEnded = true;
                }
                else
                    isPlayer1 = !isPlayer1;
            }
        }

        printBoard(board);


        System.out.println("Do you wanna Restart the game (Y/N)");
        char game=sc.next().charAt(0);
        if(game=='Y' || game=='y')
            TicTacToe(p1,p2);
        else {
            System.out.println("Have a great day");
        }

    }
    public static void printBoard(char[][] board){
        System.out.println("-------------");

        for(char[] row:board){
            System.out.print("| ");
            for(char c:row){
                System.out.print(c);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void gameBoard(char[][] board,int pos,char symbol){
        switch(pos){
            case 1:
                board[0][0]=symbol;
                break;
            case 2:
                board[0][1]=symbol;
                break;
            case 3:
                board[0][2]=symbol;
                break;
            case 4:
                board[1][0]=symbol;
                break;
            case 5:
                board[1][1]=symbol;
                break;
            case 6:
                board[1][2]=symbol;
                break;
            case 7:
                board[2][0]=symbol;
                break;
            case 8:
                board[2][1]=symbol;
                break;
            case 9:
                board[2][2]=symbol;
                break;

        }
    }

    public static char hasWon(char[][] board){
        for(int i=0;i<3;i++){
           if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0]!=' ')
               return board[i][0];
        }
        for (int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j]!=' ')
                return board[0][j];
        }

        if((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]!=' ') || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]!=' '))
            return board[1][1];

        return ' ';

    }

    public static boolean hasTied(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                if(board[i][j]==' ')
                    return false;
            }
        }
        return true;
    }







































































}
