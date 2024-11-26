package de.nulldrei.oop.ex4.gui.sportartikel;


import de.nulldrei.oop.ex4.business.baelle.BaelleModel;
import de.nulldrei.oop.ex4.business.baelle.BaelleModelSingleton;
import de.nulldrei.oop.ex4.gui.baelle.BaelleControl;
import de.nulldrei.oop.ex4.gui.baelle.BaelleView;
import javafx.stage.Stage;

public class SportartikelControl {
	
	private SportartikelView sportartikelView;
	
	private BaelleModel baelleModel;

	public SportartikelControl(Stage stage, BaelleControl baelleControl){
		/*
		 Wir müssen hier BaelleControls übergeben um den darin gespeicherten View
		 abrufen zu können.
		 Wir benötigen wiederum den BaelleView in SportartikelView um den Observer in BaelleView
		 zu registrieren.
		 */
		BaelleModel baelleModel = BaelleModelSingleton.getInstance().getObject();
		this.sportartikelView = new SportartikelView(this, stage, 
			baelleModel, baelleControl.getBaelleView());
	}

}
