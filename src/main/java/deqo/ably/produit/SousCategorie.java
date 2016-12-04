package deqo.ably.produit;
import java.util.ArrayList;


public class SousCategorie {

	private final Categorie categorie;
	private final String nom;
	private ArrayList<Aliment> aliments = new ArrayList<Aliment>();
	
	public SousCategorie(Categorie c, String nom){
		this.categorie = c;
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public Categorie getCategorie(){
		return this.categorie;
	}
	
	public ArrayList<Aliment> getAliments(){
		return this.aliments;
	}
	
	public String toString(){
		String str = "Les aliments concernant <" +this.getNom()+"> sont :";
		str += this.aliments.toString();	
		
		return str;
	}
	
	public void ajouterAliment(Aliment a){
		this.aliments.add(a);
	}
	
	 @Override
	    public boolean equals(Object obj) {
	       if (!(obj instanceof SousCategorie))
	            return false;
	        if (obj == this)
	            return true;

	        SousCategorie cat = (SousCategorie) obj;
	        return (cat.getNom() == this.getNom() && this.categorie.toString() == cat.categorie.toString());
	    }
	
}
