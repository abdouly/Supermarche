package deqo.ably.produit;

//Ce n'est pas une classe abstraite au sens de l'objet, y'a pas d'"abstract"
//C'est une classe m�re utilis�e pour la g�n�ricit�

public class Produit {
	private String nom;
	
	public Produit(String n){
		this.nom = n;
	}
	
	public String toString(){
		return this.nom;
	}
	
	public String getNom(){
		return this.nom;
	}
}
