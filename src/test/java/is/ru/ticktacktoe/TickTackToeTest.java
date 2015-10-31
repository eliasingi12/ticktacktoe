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
				assertEquals(1, TickTackToe.board[0][0]);
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
}