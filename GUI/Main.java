package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application  {

//    Stage window;
//    Scene stateNum, stateAssign;
//    TextField text1;

//    TitledPane newState;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FSM Creator");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }

//    @Override
//    public void handle(ActionEvent event){
//        if(event.getSource()==text1){
//
//        }
//    }


}
