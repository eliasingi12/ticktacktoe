package is.ru.ticktacktoe;

import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TickTackToe {

    public static final int MARK_X = -1;
    public static final int MARK_O = -2;
    public static final int SIZE = 3;
    public static int currPlayer = MARK_X;
    public static int [][] board = new int [SIZE][SIZE];
    private InputStream inStream;
    private PrintStream outStream;

    TickTackToe(){
        currPlayer = MARK_X;
        this.inStream  = System.in;
        this.outStream = System.out;
    }

    public void initializeBoard(){
        int n = 1;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = n;
                n++;
            }
        }          
    }

    public void setInputStream(InputStream inputStreamToUse){
        this.inStream = inputStreamToUse;
    }

    public void setOutputStream(ByteArrayOutputStream outputStreamToUse){
         
        this.outStream = new PrintStream(outputStreamToUse);
    }
   
    public char getPlayer(){
        if(currPlayer == MARK_X){
            return 'X';
        }else{
            return 'O';
        }
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

    public boolean checkIfWinning(){
        if(checkDiagonal()){
            return true;
        }

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                if(checkLines(i) || checkColumns(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public void changePlayers(int count){
        if(count%2 == 0){
            currPlayer = MARK_X;
        }else{
            currPlayer = MARK_O;
        }
    }

    public void changePlayer(){
        if(currPlayer == MARK_O){
            currPlayer = MARK_X;
        }else{
            currPlayer = MARK_O;
        }
    }

    //Nýtt fall
    public char pushCell(String x){
        int y = currPlayer;
        updateBoard(Integer.parseInt(x));
        changePlayer();
        return getPlayer();
    }

    public int restart(){
        initializeBoard();
        currPlayer = MARK_X;
        return 1;
    }

    public int convertToLine(int pos){
        return (pos  - 1)/SIZE;
    }

    public int convertToColumn(int pos){
        return (pos - 1)%SIZE;
    }

    public void updateBoard(int pos){
        int line = convertToLine(pos);
        int column = convertToColumn(pos);
        board[line][column] = currPlayer;
    } 

    public boolean isLegal(int pos){
        int line = convertToLine(pos);
        int column = convertToColumn(pos);
        
        return!((pos < 1 || pos > SIZE*SIZE) || (board[line][column] == MARK_X ||  board[line][column] == MARK_O));
    }

    public int getPosition(){
        Scanner in = new Scanner(this.inStream);
        outStream.print(getPlayer() + " position: ");
        int pos = in.nextInt();
        outStream.println(Integer.toString(pos));
        while(!isLegal(pos)){
            outStream.println("Illegal move! ");
            outStream.println(getPlayer() + " position: ");
            pos = in.nextInt();
        }
        return pos;
    }

    public String getLines(int i){
        String line = "";
        for(int j = 0; j < SIZE; j++){
            if(board[i][j] == MARK_X){
                line+=" X ";
            }else if (board[i][j] == MARK_O){
                line+=" O ";
            }else{
                line+=" " + board[i][j] + " ";
            }
            line+="|";
        }
        return line;
    }

    public void print(){
        outStream.println("+---+---+---+");
        for(int i = 0; i < SIZE; i++){           
            outStream.print("|");
            outStream.print(getLines(i));
            outStream.println();
            outStream.println("+---+---+---+");         
        }
    }

    public boolean game(){
        for(int i = 0; i < SIZE*SIZE && !checkIfWinning(); i++){
            changePlayers(i);
            updateBoard(getPosition());
            print();
            outStream.println();
        }
        return checkIfWinning();
    }

    public void getResult(boolean result){
        if(result){
            outStream.println("Winner is: " + getPlayer());
        }else{
            outStream.println("Draw!");
        }
    }


    public static void main(String[] args) {
        TickTackToe game = new TickTackToe();
        game.initializeBoard();
        game.print();
        boolean result = game.game();
        game.getResult(result);    
    }
}