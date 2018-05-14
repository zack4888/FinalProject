package application;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import org.jsoup.Jsoup;
//import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Controller {

		    @FXML
		    private TextField TextBox;

		    @FXML
		    private Button EnterButton;

		    @FXML
		    private AreaChart<?, ?> graph;

		    @FXML
		    private Label StockPriceLabel;

		    @FXML
		    private Label ChangeLabel;

		    @FXML
		    private Label PercentLabel;

		    @FXML
		    private ImageView GreenArrow;

		    @FXML
		    private ImageView RedArrow;

		    @FXML
		    private Button CloseButton;

		    @FXML
		    private Button SaveButton;

		    @FXML
		    private CheckBox TodayCheckbox;

		    @FXML
		    private CheckBox MonthTextBox;

		    @FXML
		    private CheckBox YearCheckBox;

		    @FXML
		    private CheckBox LifeTimeCheckBox;

		    @FXML
		    private Label CompanyNameLabel;
		    
		    @FXML
		    private WebView WebView1;

		    
		    @FXML
		    public void Closeclicker() {
		    	System.out.println("Success!");
		    	
		    	
		    }
		    public void EnterClick() {
		    	try {
		    		String test2;
		    		String test;
		    	    String Thing1;
		    	    String Thing2 = TextBox.getText();
		    	    
		    		Document Doc = Jsoup.connect("https://finance.yahoo.com/quote/"+Thing2+"?p="+Thing2).get();
		    	    
		    	    
		    	    	
		    	    
		    		Elements Price =Doc.getElementsByClass("D(ib) Mend(20px)");
		    		
		    		
		    		test = Price.first().text();
		    		System.out.println(test);
		    		
		    		
		    		Elements Company = Doc.getElementsByClass("D(ib) Fz(18px)");
		    		//Elements Percent = Doc.getElementsByClass("Trsdu(0.3s) Fw(500) Pstart(10px) Fz(24px) C($dataGreen)");
		    		//Thing1 = Price.get(1).text();
		    		
		    		//ChangeLabel.setText(Thing1);
		    		if (Price.text().contains("+")) {
		    			GreenArrow.setVisible(true);
		    			StockPriceLabel.setTextFill(Color.web("00ff00"));
		    			System.out.println("Worked");
		    		}
		    		else {
		    			GreenArrow.setVisible(false);
		    		}
		    		if(Price.text().contains("-")) {
		    			RedArrow.setVisible(true);
		    			StockPriceLabel.setTextFill(Color.web("ff0000"));
		    			
		    		}
		    		else {
		    			RedArrow.setVisible(false);
		    		}
		    		test2 = Company.text();
		    		System.out.println(test2);
		    		
		    		StockPriceLabel.setText(test);
		    		CompanyNameLabel.setText(test2);
		    		
		    		System.out.println("success");
		    		WebView1.setVisible(true);
		    		graph.setVisible(false);
		    		WebEngine Engine = WebView1.getEngine();
		    		Engine.load("https://finance.yahoo.com/quote/"+Thing2+"?p="+Thing2);
		    		Engine.loadContent(Doc.getElementsByAttribute("smartphone_Mt(40px)").html());
		    		
		    		}
		    	
		    	    catch(NullPointerException e) {
		    	    	JOptionPane.showMessageDialog(null, "Could not find a company matching that ticker.");
		    	    	e.printStackTrace();
		    	    }
		    		catch(Exception e) {
		    			e.printStackTrace();
		    		}
		    		
		    		
		    	
		    		
		    		
		    		
		    	}
		    public void SaveClick() {
		    	try {
		    		Connection MyConn = DriverManager.getConnection("jdbc:mysql://dunwoody1234.cqnu4iqybkyl.us-east-2.rds.amazonaws.com:3306/Dunwoody","Zack4888","Password01");
					System.out.println("database connected ");
					
					
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }
		    }

		
	


