package deqo.ably.produit;

public class Aliment extends Produit {
	
	//plus besoin avec héritage
	//private String nom;
	
	public Aliment(String nom){
		//anciennement avant héritage de produit
		//this.nom = nom; 
		super(nom);
	}
	
	//pas besoin avec héritage
	/*public String toString(){
		return this.nom;
	}*/
}
