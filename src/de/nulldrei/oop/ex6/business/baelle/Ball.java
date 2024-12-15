package de.nulldrei.oop.ex6.business.baelle;

import de.nulldrei.oop.ex5.business.Sportartikel;

public class Ball extends Sportartikel{
	
	private String material;
	private String sportart;
	private String status;
	private String nutzung;
	
	public Ball(int einkaufsdatum, String material, String sportart,
		String status, String nutzung, double preis) 
	 	throws Exception {
		super(einkaufsdatum, preis);
		this.material = material;
		this.sportart = sportart;
		this.status = status;
		this.nutzung = nutzung;
	}
	 
	public boolean ueberpruefeSportart(){
	    if(this.sportart == null){
	    	return false;
	    }
	    else
	    	return true;
	}		
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getSportart() {
		return sportart;
	}
	
	public void setSportart(String sportart) {
		this.sportart = sportart;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNutzung() {
		return nutzung;
	}
	
	public void setNutzung(String nutzung) {
		this.nutzung = nutzung;
	}
	
	public boolean checkSportart() {
		return sportart != null;
	}
	
	public double calculatePricePerArticle(int articleBuyingCount) throws IllegalArgumentException {
		
		double ergebnisProz = 100;	
		int[] anzArtikel = new int[]{0, 500, 1000};
		int[] preisJeStueckProz = new int[]{100, 75, 60};
		int pos = 1;
		if(articleBuyingCount <= 0) {
			throw new IllegalArgumentException("Man muss mehr als einen Ball kaufen");
		}
		if(articleBuyingCount >= 1000){
		 	ergebnisProz = 60;
		}
		else{	
			while(anzArtikel[pos] < articleBuyingCount) {
				pos++;
			}    
			ergebnisProz =  
				     ((preisJeStueckProz[pos] - preisJeStueckProz[pos-1]) * 1.0  
				                     / (anzArtikel[pos] - anzArtikel[pos-1]))  
				     * (articleBuyingCount - anzArtikel[pos-1])  
				     +  preisJeStueckProz[pos-1]; 
		}
	    return (ergebnisProz / 100) * this.getPreis();
	    
		/*
		double price = getPreis();
		if(articleBuyingCount <= 0) {
			throw new IllegalArgumentException("Man muss mehr als einen Ball kaufen");
		} else {
			if(articleBuyingCount >= 500) {
				price = price - (price * 0.25);
			} 
			if(articleBuyingCount >= 1000) {
				price = getPreis();
				price = price -(price * 0.4);
			}
			
		}
		return price;
		*/
	}
	
	@Override	
	public String gibZurueck(char trenner) {
		return (super.gibZurueck(trenner) + trenner + this.getMaterial() + trenner
		+ this.getSportart() + trenner + this.getStatus() + trenner
		+ this.getNutzung());
	}
	
}
