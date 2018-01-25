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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class easygame extends Application {
	private static int counter;
    private boolean shown;
    private static String name;
    private static String playerscore;
    private static StringBuilder sb=new StringBuilder();
    private static PrintWriter pw;
    
    public static void main(String[] args) throws IOException {
    	System.out.println("Hello there what should I call you?");
    	Scanner sc = new Scanner(System.in);
        String i = sc.next();
        name=i;
        
    	
        System.out.println("High Score List");  	
    	String csvFile ="results.csv";
    	BufferedReader br = null;
    	br = new BufferedReader(new FileReader(csvFile));
    	String line="";
    	
    	
    	while ((line = br.readLine()) != null)
    	{

            // use comma as separator
    		 String[] board = line.split(",");
             System.out.println(board[0]+ "  "+board[1]);
            sb.append(board[0]+ ","+board[1]+"\n");
        }
    	
    	pw=new PrintWriter(new File("results.csv"));
    	
    	System.out.println("How many times can u click the button in 10 seconds?");
    	System.out.println("Press the Start button to Start!");
    	counter=0;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("CLICK THE COOKIE!");
        Button btn = new Button();
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        btn.setText("Cookie Clicker");
        btn.isDisabled();
        
        /*Button btn1= new Button();
        btn1.setLayoutX(200);
        btn1.setLayoutY(50);
        btn1.setText("Start");*/
      
        Text text = new Text(50, 50, playerscore);  
        playerscore = "Score: " + counter;
        text.setText(playerscore);
        
        long duration=10000000000L;
      /* if(btn1.isPressed()==true)
       {
    	   btn1.isDisabled();
       }*/
	        long endNanoTime = System.nanoTime()+duration;
	        btn.setOnAction((e)->
	        {
	        	long currentNanoTime=System.nanoTime();
	        	if(currentNanoTime<endNanoTime)
	        	{
	        		int changex = 100+(int)(Math.random() * 200);
	            	int changey = 100+(int)(Math.random() * 200);
	            	btn.setLayoutX(changex);
	                btn.setLayoutY(changey);
	        		counter++;
	        		playerscore = "Score: " + counter;
	                text.setText(playerscore);
	        	}
	        	else if(shown==false)
	        	{
	        		shown=true;
	        		System.out.println("In 10 seconds you have clicked it "+counter+ " times");
	        		sb.append(name+","+ Integer.toString(counter)+"\n");
	        		pw.write(sb.toString());
	            	pw.close();
	            	
	        	}
	        });
        
	        	Pane root = new Pane();
		        root.getChildren().add(btn);
		        //root.getChildren().add(btn1);
		        root.getChildren().add(text);
		        primaryStage.setScene(new Scene(root, 400, 400,Color.BLUE));
		        primaryStage.show();
	
	    }


}
		
