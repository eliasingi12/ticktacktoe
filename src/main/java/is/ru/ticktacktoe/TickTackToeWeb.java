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

		Spark.post("/thisID", new Route(){
			
			@Override
			public Object handle(final Request request, final Response response){
				int pos = Integer.valueOf(request.queryParams("thisID"));
				char currPlayer = game.getPlayer();
				game.updateBoard(pos);
				return currPlayer;
			}
		});
	}

}