package de.nulldrei.oop.ex6.gui.sportartikel;


import de.nulldrei.oop.ex6.business.baelle.BaelleModel;
import de.nulldrei.oop.ex6.gui.baelle.BaelleView;
import de.nulldrei.oop.ex6.ownUtil.MeldungsfensterAnzeiger;
import de.nulldrei.oop.ex6.ownUtil.Observable;
import de.nulldrei.oop.ex6.ownUtil.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SportartikelView implements Observer {
	
	private SportartikelControl sportartikelControl;
  	private BaelleModel baelleModel;
	private BaelleView baelleView;
	
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane = new  Pane();
    private Label lblAnzeigeTrikots    		= new Label("Anzeige Trikots");
    private Label lblAnzeigeBaelle          = new Label("Anzeige B�lle");
    private TextArea txtAnzeigeTrikots      = new TextArea();
    private TextArea txtAnzeigeBaelle       = new TextArea();  
    private Button btnAnzeigeBaelle         = new Button("Anzeige");
    //-------Ende Attribute der grafischen Oberflaeche-------
     
    public SportartikelView(SportartikelControl sportartikelControl, 
    	Stage stage, BaelleModel baelleModel, BaelleView baelleView){
    	Scene scene = new Scene(this.pane, 640, 340);
    	stage.setScene(scene);
    	stage.setTitle("Anzeige von Sportartikeln");
		this.baelleView = baelleView;
		// Aufgabe 4.3.3 Wenn das Fenster geschlossen wird, entferne den Observer
		stage.setOnHiding(e -> {
				baelleView.removeObserver(this);
				System.out.println("Observer removed");
			}
		);
    	stage.show();
    	this.sportartikelControl = sportartikelControl;
    	this.baelleModel = baelleModel;
		this.initKomponenten();
		this.initListener();
		baelleView.addObserver(this);
   	}

	private void initKomponenten(){
    	// Label
 	    Font font = new Font("Arial", 20);
 	    lblAnzeigeTrikots.setLayoutX(20);
        lblAnzeigeTrikots.setLayoutY(40);
        lblAnzeigeTrikots.setFont(font);
        lblAnzeigeTrikots.setStyle("-fx-font-weight: bold;"); 
        lblAnzeigeBaelle.setLayoutX(310);
        lblAnzeigeBaelle.setLayoutY(40);
        lblAnzeigeBaelle.setFont(font);
        lblAnzeigeBaelle.setStyle("-fx-font-weight: bold;"); 
        pane.getChildren().addAll(lblAnzeigeTrikots, lblAnzeigeBaelle);    
      	// Textbereiche	
    	txtAnzeigeTrikots.setEditable(false);
       	txtAnzeigeTrikots.setLayoutX(20);
       	txtAnzeigeTrikots.setLayoutY(90);
       	txtAnzeigeTrikots.setPrefWidth(220);
       	txtAnzeigeTrikots.setPrefHeight(185);
       	txtAnzeigeBaelle.setEditable(false);
       	txtAnzeigeBaelle.setLayoutX(310);
       	txtAnzeigeBaelle.setLayoutY(90);
       	txtAnzeigeBaelle.setPrefWidth(300);
       	txtAnzeigeBaelle.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeBaelle);        	
       	// Buttons
       	btnAnzeigeBaelle.setLayoutX(310);
       	btnAnzeigeBaelle.setLayoutY(290);
		// Wir müssen hier den Button entfernen
       	//pane.getChildren().add(btnAnzeigeBaelle);
    }
   
    private void initListener() {
    	btnAnzeigeBaelle.setOnAction(e -> {
    		zeigeBaelleAn();
    	});
    }
   
    public void zeigeBaelleAn(){
   		String text = "";
   		for(int i = 0; i < baelleModel.holeBaelle().getAnzahlSportartikel(); i++) {
   		    text = text + baelleModel.holeBaelle().getSportartikel(i).gibZurueck('|') + "\n";
   		}
   		txtAnzeigeBaelle.setText(text);
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
 		new MeldungsfensterAnzeiger(AlertType.INFORMATION,
 			"Information", meldung).zeigeMeldungsfensterAn();
    }


	@Override
	public void update() {
		// Wenn der Observer ein Update erhält, zeige die Baelle an
		zeigeBaelleAn();
		zeigeInformationsfensterAn("Baelle wurden geladen!");
	}
}
