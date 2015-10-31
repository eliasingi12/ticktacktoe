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
}