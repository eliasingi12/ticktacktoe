package is.ru.ticktacktoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TickTackToeWeb implements SparkApplication{
	private TickTackToe game;

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

		Spark.post("/cell", new Route()
		{
			@Override
			public Object handle(final Request request, final Response response)
			{
				int pos = Integer.valueOf(request.queryParams("cell"));
				char currPlayer = game.getPlayer();
				updateBoard(pos);
				changePlayer();
				return currPlayer;
			}
		});

/*
        post("/cell", (req, res) -> {
        	tick.getPlayer();
        	tick.changePlayer();
        	char player = getPlayer();
        	res.send(player);
        	return res;
        });*/


        post("/newGame", (req, res) -> {
			res.status(200);
			tick.initializeBoard();
        	tick.game();
			return res;
		});
        
	}

}