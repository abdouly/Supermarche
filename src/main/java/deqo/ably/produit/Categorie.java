package deqo.ably.produit;
import java.util.ArrayList;


public class Categorie {
	private String nom;
	private static ArrayList<String> listeCategories = new ArrayList<String>();
	
	public Categorie(String nom){
		this.nom = nom;
		listeCategories.add(nom);
	}
	
	//autre possibilité : constructeur par copie
	public Categorie getCopy(){
		return new Categorie(this.nom);
	}
	
	public void setNom(String n){
		this.nom = n;
	}
	
	public static ArrayList<String> getCategories(){
		return listeCategories;
	}
	
	public String toString(){
		return this.nom;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Categorie))
             return false;
         if (obj == this)
             return true;

         Categorie cat = (Categorie) obj;
         return cat.toString().equals(this.toString());
     }
}
