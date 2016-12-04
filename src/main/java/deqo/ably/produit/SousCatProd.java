package deqo.ably.produit;
import java.util.ArrayList;

public class SousCatProd <T extends Produit> {
	private final Categorie categorie;
	private final String nom;
	private ArrayList<T> produits;
	
	public SousCatProd(Categorie categorie, String nom) {
		this.categorie=categorie;
		this.nom=nom;
		this.produits=new ArrayList<T>();
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public String getNom() {
		return nom;
	}
	public ArrayList<T> getProduits() {
		return produits;
	}
	//TODO changement ajouterAliment prend un aliment en param�tre
	public void ajouterProduit(T produit){
		produits.add(produit);
	}

	public boolean supprimerProduit(int indexAlimentToSupresse) {
		T produit=produits.remove(indexAlimentToSupresse);
		return produit!=null;		
	}
	public String affichageProduit(){		
		String affichage="";
		for (T produit : produits) {
			affichage+=produit+"\n";
		}
		return affichage;
	}
	public String toString() {
		return "Les produits concernant "+nom+" sont : "+produits;
	}
	
	@Override
    public boolean equals(Object obj) {
       if (!(obj instanceof SousCatProd<?>))
            return false;
        if (obj == this)
            return true;

        SousCatProd<?> cat = (SousCatProd<?>) obj; //utiliser le point d'interrogation car type g�n�rique = osef
        return (cat.getNom() == this.getNom() && this.categorie.toString() == cat.categorie.toString());
    }
}
