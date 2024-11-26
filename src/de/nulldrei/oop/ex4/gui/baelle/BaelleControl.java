package de.nulldrei.oop.ex4.gui.baelle;


import de.nulldrei.oop.ex4.business.baelle.BaelleModel;
import de.nulldrei.oop.ex4.business.baelle.BaelleModelSingleton;
import javafx.stage.Stage;

public class BaelleControl {
	
	private BaelleView baelleView;
	private BaelleModel baelleModel;

	public BaelleControl(Stage primaryStage){
		this.baelleModel = BaelleModelSingleton.getInstance().getObject();
		this.baelleView = new BaelleView(this, primaryStage, 
			baelleModel);
	}

	/*
	 Wir müssen den BaelleView den wir hier erstellen zurückgeben können damit wir den Observer
	 Später registrieren können.
	 */
	public BaelleView getBaelleView() {
		return baelleView;
	}
	
	void leseBaelleAusDatei(){
	   	try{
   			baelleModel.leseBaelleAusDatei();
   			baelleView.zeigeInformationsfensterAn(
   				"Die B�lle wurden gelesen!");
	    } 
		catch(Exception exc){
			baelleView.zeigeFehlermeldungsfensterAn("",
				"Unbekannter Fehler beim Lesen!");
		}
    }

}
