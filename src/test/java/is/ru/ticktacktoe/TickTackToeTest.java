package is.ru.ticktacktoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//for Exception
import org.junit.Rule;
import org.junit.rules.ExpectedException;




public class TickTackToeTest {


	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.ticktacktoe.TickTackToeTest.java");
    }

	@Test
	public void testInitializeBoard() {
		TickTackToe tick = new TickTackToe();
		tick.initializeBoard();

		int n = 1;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				assertEquals(n, TickTackToe.board[i][j]);
				n++;
			}
		}
	}

	@Test
	public void testGetPlayer(){
		TickTackToe tick = new TickTackToe();
		assertEquals('X', tick.getPlayer(TickTackToe.MARK_X));
		assertEquals('O', tick.getPlayer(TickTackToe.MARK_O));
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

	
	}
}