package de.nulldrei.oop.ex6.main;


import de.nulldrei.oop.ex6.gui.baelle.BaelleControl;
import de.nulldrei.oop.ex6.gui.sportartikel.SportartikelControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		BaelleControl baelleControl = new BaelleControl(primaryStage);
		Stage fensterSportartikel = new Stage();
 		new SportartikelControl(fensterSportartikel, baelleControl);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
	
	
}
