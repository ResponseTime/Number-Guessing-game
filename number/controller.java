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
    int k = 1;
    int l = 1;
    String array [] = new String [k];
    String arr [] = new String[l];
    String username;
    String password;
   
    public void change(ActionEvent e) throws IOException{
        
        username = user.getText();
        password = pass.getText();
        if(username.length()==0 || password.length() == 0){
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.close();
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ui2.fxml"));
            root = loader.load();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }
        
        array = new String[k++];
        for(int i =0;i<array.length;i++){
            array[i] = username;
        }
        arr = new String[l++];
        for(int j = 0;j<arr.length;j++){
            arr[j]= password;
        }
        for(String r:array){
            System.out.println(r);
        }
        for(String t:arr){
            System.out.println(t);
        }
        
    }
    
}
