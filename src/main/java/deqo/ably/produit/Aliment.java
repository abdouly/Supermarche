package deqo.ably.produit;

public class Aliment extends Produit {
	
	//plus besoin avec h�ritage
	//private String nom;
	
	public Aliment(String nom){
		//anciennement avant h�ritage de produit
		//this.nom = nom; 
		super(nom);
	}
	
	//pas besoin avec h�ritage
	/*public String toString(){
		return this.nom;
	}*/
}
