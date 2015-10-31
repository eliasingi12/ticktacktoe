package is.ru.ticktacktoe;

public class TickTackToe {

    public void initializeBoard(int tac[][]){
        int n = 1;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                tac[i][j] = n;
                n++;
            }
        }          
    }
    public static int uncovered() {
    	System.out.println("I am an uncovered function");
        return 0;
    }

   public static void main(String[] args) {
        System.out.println("Hello TickTackToe");
        for(String param: args)
            System.out.println("Parameter : "+param);
    }
}