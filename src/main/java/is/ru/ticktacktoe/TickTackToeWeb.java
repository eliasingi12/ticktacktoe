package is.ru.ticktacktoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TickTackToeWeb implements SparkApplication{
	public TickTackToe game;

	public static void main(String[] args){
		staticFileLocation("/public");
        SparkApplication web = new TickTackToeWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        web.init();
	}

	@Override
	public void init(){
		final TickTackToe tick = new TickTackToe();    
        post("/cell", (req, res) -> tick.pushCell(req.queryParams("cell")));
        post("/winner", (req, res) -> tick.checkIfWinning());
        post("/restart", (req, res) -> tick.restart());
	}
}