package number;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controller {
    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    TextField user;
    @FXML
    PasswordField pass;

   
    public void change(ActionEvent e) throws IOException{
        String username = user.getText();
        String password = pass.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui2.fxml"));
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
