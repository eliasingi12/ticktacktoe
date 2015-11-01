package is.ru.ticktacktoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;

//for Exception
//import org.junit.Rule;
//import org.junit.rules.ExpectedException;




public class TickTackToeTest {


    public static void main(String[] args) {
      org.junit.runner.JUnitCore.main("is.ru.ticktacktoe.TickTackToeTest.java");
    }

	@Test
	public void testInitializeBoard() {
		TickTackToe tick = new TickTackToe();
		tick.initializeBoard();

		int n = 1;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				assertEquals(n, TickTackToe.board[i][j]);
				n++;
			}
		}
	}

	@Test
	public void testGetPlayer(){	
		TickTackToe tick = new TickTackToe();

		assertEquals('X', tick.getPlayer());
		tick.currPlayer = tick.MARK_O;
		assertEquals('O', tick.getPlayer());
	}

	@Test
	public void testCheckLines(){
		TickTackToe tick = new TickTackToe();
		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[0][1] = TickTackToe.MARK_X;
		TickTackToe.board[0][2] = TickTackToe.MARK_X;

		assertEquals(true, tick.checkLines(0));

		TickTackToe.board[1][0] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_O;
		TickTackToe.board[1][2] = TickTackToe.MARK_O;

		assertEquals(true, tick.checkLines(1));

		TickTackToe.board[2][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][1] = TickTackToe.MARK_O;
		TickTackToe.board[2][2] = TickTackToe.MARK_O;
		assertEquals(false, tick.checkLines(2));
		TickTackToe.board[2][0] = TickTackToe.MARK_O;
		TickTackToe.board[2][1] = TickTackToe.MARK_O;
		TickTackToe.board[2][2] = TickTackToe.MARK_X;
		assertEquals(false, tick.checkLines(2));
	}

	@Test
	public void testCheckColumns(){
		TickTackToe tick = new TickTackToe();
		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[1][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][0] = TickTackToe.MARK_X;

		assertEquals(true, tick.checkColumns(0));

		TickTackToe.board[0][1] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_O;
		TickTackToe.board[2][1] = TickTackToe.MARK_O;

		assertEquals(true, tick.checkColumns(1));

		TickTackToe.board[0][2] = TickTackToe.MARK_X;
		TickTackToe.board[1][2] = TickTackToe.MARK_O;
		TickTackToe.board[2][2] = TickTackToe.MARK_O;
		assertEquals(false, tick.checkColumns(2));

		TickTackToe.board[0][2] = TickTackToe.MARK_O;
		TickTackToe.board[1][2] = TickTackToe.MARK_O;
		TickTackToe.board[2][2] = TickTackToe.MARK_X;
		assertEquals(false, tick.checkColumns(2));
	}

	@Test
	public void testCheckDiagonal(){
		TickTackToe tick = new TickTackToe();
		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[1][1] = TickTackToe.MARK_X;
		TickTackToe.board[2][2] = TickTackToe.MARK_X;

		assertEquals(true, tick.checkDiagonal());

		TickTackToe.board[0][2] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_O;
		TickTackToe.board[2][0] = TickTackToe.MARK_O;

		assertEquals(true, tick.checkDiagonal());

		TickTackToe.board[0][0] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_X;
		TickTackToe.board[2][2] = TickTackToe.MARK_X;
		assertEquals(false, tick.checkDiagonal());
	}

	@Test
	public void testCheckIfWinning(){
		TickTackToe tick = new TickTackToe();
		
		// This is the board when x is winning diagonal
		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[0][1] = TickTackToe.MARK_O;
		TickTackToe.board[0][2] = TickTackToe.MARK_X;
		TickTackToe.board[1][0] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_X;
		TickTackToe.board[1][2] = TickTackToe.MARK_O;
		TickTackToe.board[2][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][1] = TickTackToe.MARK_O;
		TickTackToe.board[2][2] = TickTackToe.MARK_X;
		assertEquals(true, tick.checkIfWinning());

		// This it the board when o is winning with lines.
		TickTackToe.board[0][0] = TickTackToe.MARK_O;
		TickTackToe.board[0][1] = TickTackToe.MARK_O;
		TickTackToe.board[0][2] = TickTackToe.MARK_O;
		TickTackToe.board[1][0] = TickTackToe.MARK_X;
		TickTackToe.board[1][1] = TickTackToe.MARK_X;
		TickTackToe.board[1][2] = 1;
		TickTackToe.board[2][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][1] = 1;
		TickTackToe.board[2][2] = 1;
		assertEquals(true, tick.checkIfWinning());

		// No one is winning
		TickTackToe.board[0][0] = 1;
		TickTackToe.board[0][1] = 2;
		TickTackToe.board[0][2] = 3;
		TickTackToe.board[1][0] = TickTackToe.MARK_O;
		TickTackToe.board[1][1] = TickTackToe.MARK_X;
		TickTackToe.board[1][2] = 6;
		TickTackToe.board[2][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][1] = 8;
		TickTackToe.board[2][2] = 9;
		assertEquals(false, tick.checkIfWinning());

		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[0][1] = TickTackToe.MARK_X;
		TickTackToe.board[0][2] = TickTackToe.MARK_X;
		TickTackToe.board[0][0] = TickTackToe.MARK_X;
		TickTackToe.board[1][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][0] = TickTackToe.MARK_X;
		TickTackToe.board[2][0] = 7;
		TickTackToe.board[2][1] = 8;
		TickTackToe.board[2][2] = 9;

		assertEquals(true, tick.checkIfWinning());
	}

	@Test
	public void testChangePlayers(){
		TickTackToe tick = new TickTackToe();
		// After even number of rounds X is the current player
		tick.changePlayers(2);
		assertEquals(TickTackToe.currPlayer, TickTackToe.MARK_X);

		// After odd number of rounds O is the current player
		tick.changePlayers(1);
		assertEquals(TickTackToe.currPlayer, TickTackToe.MARK_O);
	}

	@Test
	public void testConvertToLine(){
		TickTackToe tick = new TickTackToe();
		assertEquals(1, tick.convertToLine(5));
		assertEquals(2, tick.convertToLine(9));
	}

	@Test
	public void testConvertToColumn(){
		TickTackToe tick = new TickTackToe();
		assertEquals(0, tick.convertToColumn(4));
		assertEquals(2, tick.convertToColumn(9));
	}

	@Test
	public void testUpdateBoard(){
		TickTackToe tick = new TickTackToe();
		tick.updateBoard(1);
		assertEquals(tick.MARK_X, tick.board[0][0]);

		tick.currPlayer = tick.MARK_O;
		tick.updateBoard(9);
		assertEquals(tick.MARK_O, tick.board[2][2]);
	}

	@Test
	public void testIsLegal(){
		TickTackToe tick = new TickTackToe();
		assertEquals(false, tick.isLegal(-1));
		assertEquals(false, tick.isLegal(10));

		TickTackToe.board[0][0] = 1;
		assertEquals(true, tick.isLegal(1));

		TickTackToe.board[0][0] = tick.MARK_X;
		assertEquals(false, tick.isLegal(1));

		TickTackToe.board[0][1] = tick.MARK_O;
		assertEquals(false, tick.isLegal(2));
	}

	InputStream mockInput(String str){
		
		InputStream is;
		try{
				is = new ByteArrayInputStream( str.getBytes("UTF-8") );
				return is;
			}catch(IOException ex){
					System.out.println ("Error: Could not create an mocInput");
    				System.out.println (ex.toString());
		}
		return null;
	}

	@Test
	public void testGetPosition(){
		TickTackToe tick = new TickTackToe();
		tick.setInputStream(mockInput("2"));
		assertEquals(2, tick.getPosition(tick.currPlayer));

		tick.setInputStream(mockInput("1"));
		tick.currPlayer = tick.MARK_O;
		assertEquals(1, tick.getPosition(tick.currPlayer));

		tick.setInputStream(mockInput("0\n3"));
		tick.currPlayer = tick.MARK_X;
		assertEquals(3, tick.getPosition(tick.currPlayer));		
	}

	@Test
	public void testOutput(){
	ByteArrayOutputStream outStream = new ByteArrayOutputStream();		
		TickTackToe tick = new TickTackToe();
		tick.setInputStream(mockInput("7"));
		tick.setOutputStream(outStream);

		tick.currPlayer = tick.MARK_X;
		tick.getPosition(tick.currPlayer);

		String content = outStream.toString();
		assertEquals("X position: 7" + getEndln(), content);		
	}

	public static String getEndln(){
        if (System.getProperty("os.name").contains("Windows")){
            return "\r\n";
        }else{
            return "\n";
        }
    }
}
