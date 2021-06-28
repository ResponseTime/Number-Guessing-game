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
import java.sql.*;

public class controller {
    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    TextField user;
    @FXML
    PasswordField pass;
    String username;
    String password;
   
    public void change(ActionEvent e) throws IOException{
        username = user.getText();
        password = pass.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/aayush", "root","root");
            System.out.println("connected");
            Statement st = con.createStatement();
            String query = "INSERT INTO LOGIN_INFO"+"VALUES(%s,%s)"+username+password;
            st.executeUpdate(query);
        }
        catch(Exception ev){
            ev.printStackTrace();
        }
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
        
        
        
    }
    
}
