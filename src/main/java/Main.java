import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		Javalin app = Javalin.create()
				.start(getHerokuAssignedPort()).get("/", ctx -> ctx.result("Hello! You have crossed CORS policy")); 
				app.enableCorsForOrigin("http://localhost:8050");
	}

	private static int getHerokuAssignedPort() {
		String herokuPort = System.getenv("PORT");
		if (herokuPort != null) {
			return Integer.parseInt(herokuPort);
		}
		return 7000;
	}

}