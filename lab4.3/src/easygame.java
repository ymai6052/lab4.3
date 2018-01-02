import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class easygame extends Application {
    static int counter=0;
    public static void main(String[] args) {
    	counter=0;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        long duration=10000000000L;
        
        long endNanoTime = System.nanoTime()+duration;
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            	long t=currentNanoTime-endNanoTime; 
            	if(t>0)
            	{
            		System.out.println(counter);
            		stop();
            	}
            	counter++;
            }
        }.start();
   
        	StackPane root = new StackPane();
	        root.getChildren().add(btn);
	        primaryStage.setScene(new Scene(root, 300, 250));
	        primaryStage.show();

    }
}
		
