package is.ru.ticktacktoe;

public class TickTackToe {

    public static final int MARK_X = -1;
    public static final int MARK_O = -2;
    public static final int SIZE = 3;
    public static int [][] board = new int [SIZE][SIZE];

    public void initializeBoard(){
        int n = 1;
        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                board[i][j] = n;
                n++;
            }
        }          
    }

    public char getPlayer(int n){
        if(n == -1)
            return 'X';
        else
            return 'O';
    }

    public boolean checkLines(int i){
        return ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]));
    }

    public boolean checkColumns(int j){
        return ((board[0][j] == board[1][j]) && (board[0][j] == board[2][j]));
    }

    public boolean checkDiagonal(){
        return (((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]))
                        || ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0])));
    }
}