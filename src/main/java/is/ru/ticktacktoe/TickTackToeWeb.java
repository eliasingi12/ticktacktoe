package is.ru.ticktacktoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TickTackToeWeb implements SparkApplication
{
	private TickTackToe game;

	public static void main(String[] args)
	{
		staticFileLocation("/public");
        SparkApplication TickTackToeWeb = new TickTackToeWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        TickTackToeWeb.init();
	}

	@Override
	public void init()
	{
		get("/hello", (req, res) -> "Hello World");
	}
}