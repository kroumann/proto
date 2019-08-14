package proto;

import javafx.stage.Screen;

public class ProtoConstants {

	public static final String CSS_PATH = "/styles/bootstrap3.css";
	public static final String PROJECT_TITLE = "Proto server View";

	public static final Double HEIGHT = Screen.getPrimary().getVisualBounds().getHeight() / 1.5;
	public static final Double WIDTH = Screen.getPrimary().getVisualBounds().getWidth() / 1.5;

	static final String API_BASE_URL = "https://localhost:8080/";
    //static final String API_VERSION_SPEC = "application/vnd.github.v3+json";
    static final String JSON_CONTENT_TYPE = "application/json";

}