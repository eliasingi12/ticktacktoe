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
	public void testintRet() {

		int [][] test = new int[3][3];
		TickTackToe tick = new TickTackToe();
		tick.initializeBoard(test);

		int n = 1;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				assertEquals(1, test[0][0]);
				n++;
			}
		}
	}

	@Test
	public void runMain() {
		String[] params = new String[]{"p1","p2","p3"};
		TickTackToe tick = new TickTackToe();
		tick.main(params);
		
	}

}