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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
 
public class easygame extends Application {
	private static int counter;
    private static boolean shown;
    public static void main(String[] args) {
    	PrintWriter pw = null;
    	try 
    	{
    		pw = new PrintWriter(new File("results.csv"));
    	}
    	catch(FileNotFoundException e)
    	{
    		System.err.println(e);
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append("Name,High Score\n");
    	sb.append("Derek,60\n");
    	sb.append("Yiren,50\n");
    	sb.append("Other,40\n");
    	pw.write(sb.toString());
    	pw.close();
    	counter=0;
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
		
