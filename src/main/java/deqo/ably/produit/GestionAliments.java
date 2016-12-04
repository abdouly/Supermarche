package deqo.ably.produit;
import java.util.LinkedList;


public class GestionAliments {
	private LinkedList<SousCategorie> ensembleSousCatAliments = new LinkedList<SousCategorie>();
	
	public GestionAliments(){
		
	}
	
	// on peut aussi le faire avec un itérateur qui fait du previous c'est plus malin ;)
	// ajoute une sous-catégorie é la LinkedListe. Les sous-catégories sont rangées par catégorie
	public void ajouterSousCategorieAliments(SousCategorie ssCat){
		int indexDernierElem = -1;
		
		// PAS PROPRE BOUHH !! get recrée un itérateur qui parcoure une deuxiéme fois la liste (parce que c'est une liste liée pas accessible sur les index...)
		for(int indexCourant = 0; indexCourant < ensembleSousCatAliments.size(); indexCourant++){
			if(ensembleSousCatAliments.get(indexCourant).getCategorie().equals(ssCat.getCategorie())) indexDernierElem= indexCourant;
		}
		if(indexDernierElem != -1) ensembleSousCatAliments.add(indexDernierElem+1, ssCat);
		else ensembleSousCatAliments.add(ssCat);
	}
	
	// ajoute un aliment é la sous catégorie de la LinkedListe SI la sous catégorie existe
	public void ajouterAliment(SousCategorie ssCat, Aliment alim){
		if(ensembleSousCatAliments.contains(ssCat)){
			for(SousCategorie ssCatCourante : ensembleSousCatAliments){
				if(ssCatCourante.equals(ssCat)) ssCatCourante.ajouterAliment(alim);
			}
		}
	}
	
	public String affichageBaseAlimentaire(){
		Categorie categorieCourante = ensembleSousCatAliments.get(0).getCategorie();
		String affichage = "Categorie \"" + categorieCourante.toString() + "\"\n";
		
		for(SousCategorie ssCatCourante : ensembleSousCatAliments){
			if(!ssCatCourante.getCategorie().equals(categorieCourante)){
				categorieCourante = ssCatCourante.getCategorie();
				affichage += "\nCategorie \"" + categorieCourante.toString() + "\"\n";
			}
			affichage += ssCatCourante.toString() + "\n";
		}
		
		return affichage;
		
	}
	
	/*------------ Méthodes é arguments variables  -----------*/
	// ajoute un aliment é la sous catégorie de la LinkedListe SI la sous catégorie existe
		public void ajouterAliments(SousCategorie ssCat, Aliment... tabAliments){
			if(ensembleSousCatAliments.contains(ssCat)){
				for(SousCategorie ssCatCourante : ensembleSousCatAliments){
						if(ssCatCourante.equals(ssCat)){
							for(Aliment a : tabAliments){
								ssCatCourante.ajouterAliment(a);
						}
					}
				}
			}
		}
		
		public void ajouterSousCategories(SousCategorie... tabSousCats){
			//Pourquoi pas ? on a déjé codé la méthode, pas besoin de faire du copier/coller
			for(SousCategorie ssCat : tabSousCats){
				this.ajouterSousCategorieAliments(ssCat);
			}
		}
}
