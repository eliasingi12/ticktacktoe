package is.ru.ticktacktoe;

public class TickTackToe {

    public static final int MARK_X = -1;
    public static final int MARK_O = -2;
    public static final int SIZE = 3;
    public static int currPlayer = MARK_X;
    public static int [][] board = new int [SIZE][SIZE];

    TickTackToe(){
        currPlayer = MARK_X;
    }

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
   
    public char getPlayer()
    {
        if(currPlayer == MARK_X)
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

    public boolean checkIfWinning()
    {
        if(checkDiagonal())
            return true;

        for(int i = 0; i < 3; i ++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(checkLines(i) || checkColumns(j))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void changePlayers(int count){
        if(count%2 == 0)
            currPlayer = MARK_X;
        else
            currPlayer = MARK_O;
    }

    public int convertToLine(int pos){
        return (pos  - 1)/SIZE;
    }

    public int convertToColumn(int pos){
        return (pos - 1)%SIZE;
    }    
}