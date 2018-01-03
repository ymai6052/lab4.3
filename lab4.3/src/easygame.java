/*
 * Name:Derek Yu, Yiren Mai
 * Date:1/3/18
 */
import java.awt.event.MouseEvent;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
 
public class easygame extends Application {
    static int counter;
    static boolean shown;
    public static void main(String[] args) {
    	counter=0;
    	boolean shown=false;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Cookie Clicker");
        
        long duration=10000000000L;
        
        long endNanoTime = System.nanoTime()+duration;
        btn.setOnAction((e)->
        {
        	long currentNanoTime=System.nanoTime();
        	if(currentNanoTime<endNanoTime)
        	{
        		counter++;
        	}
        	else if(shown==false)
        	{
        		shown=true;
        		System.out.println(counter);
        	}
        });
        	StackPane root = new StackPane();
	        root.getChildren().add(btn);
	        primaryStage.setScene(new Scene(root, 300, 250));
	        primaryStage.show();

    }
}
		
