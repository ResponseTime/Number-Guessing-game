package number;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Num extends Application{
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Number Guessing game");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
