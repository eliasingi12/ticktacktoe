package is.ru.ticktacktoe;

public class TickTackToe {

    public static final int MARK_X = -1;
    public static final int MARK_O = -2;
    public static final int SIZE = 3;

    public void initializeBoard(int tac[][]){
        int n = 1;
        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                tac[i][j] = n;
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
}