package number;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.Random;


public class control {
    
    @FXML
    Random rand = new Random();
    int random = rand.nextInt(100);
    @FXML
    TextField Num;
    public int numoftime =0;
    @FXML
    Label result;
    @FXML
    Label num_of_time;
    @FXML
    Label best;
    int bestof;
    Statement state;
    String user;
    String pwd;
    
    public void play(ActionEvent e) throws Exception{
       controller cont = new controller();
        user = cont.username;
        pwd = cont.password;
        numoftime++;
        int num = Integer.parseInt(Num.getText());
        if(num == random){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conc = DriverManager.getConnection("jdbc:mysql://localhost:3308/aayush", "root","root");
                System.out.println("connected");
                state = conc.createStatement();
            }
            catch(Exception eve){
                eve.printStackTrace();
            }
         
            result.setText("You guessed the number right");
            if(numoftime<5){
                best.setText("200");
                bestof+=200;
                state.executeUpdate("INSERT INTO LOGIN_INFO (BEST_SCORE) VALUES('"+bestof+"')");
            }
            else if(numoftime<10){
                best.setText("100");
                bestof+=100;
                state.executeUpdate("INSERT INTO LOGIN_INFO (BEST_SCORE) VALUES('"+bestof+"')");
            }
            else if(numoftime>=10&&numoftime<=15){
                best.setText("50");
                bestof+=50;
                state.executeUpdate("INSERT INTO LOGIN_INFO (BEST_SCORE) VALUES('"+bestof+"')");
            }
            else if(numoftime>15 && numoftime<=20){
                best.setText("25");
                bestof+=25;
                state.executeUpdate("INSERT INTO LOGIN_INFO (BEST_SCORE) VALUES('"+bestof+"')");
            }
        

        }
        if(num<random){
            result.setText("The number you guessed is smaller");
        }
        if(num>random){
            result.setText("The number you guessed is larger");
        }
        num_of_time.setText(String.valueOf(numoftime));
    }
    
}
