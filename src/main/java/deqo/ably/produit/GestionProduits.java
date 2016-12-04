package deqo.ably.produit;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// Pour éviter de devoir écrire une classe gestionAlimentaire, gestionMultimedia, gestionNettoyage, etc. on fait une classe générique
public class GestionProduits<T extends Produit> {
	private LinkedList<SousCatProd<T>> ensembleSsCatProds = new LinkedList<SousCatProd<T>>();

	//il réle parce qu'il n'a pas d'infos sur le type T, qui ne peut pas étre vérifié. Le compilo ne peut pas prouver qu'il n'y
	//aura pas de classe cast exception, si T n'hérite pas de Produit...
	public void ajouterSousCatProduits(SousCatProd<T>... tabSsCats){
		for (SousCatProd<T> natureAplacer : tabSsCats) {
			int indexDernierElement=-1;
			int index=0;
			for (SousCatProd<T> natureEnCours : ensembleSsCatProds) {
				if(natureEnCours.getCategorie() == natureAplacer.getCategorie())indexDernierElement=index;
				index++;
			}
			if (indexDernierElement!=-1) ensembleSsCatProds.add(indexDernierElement+1, natureAplacer);
			else ensembleSsCatProds.add(natureAplacer);	
		}
	}

	public String ajouterProduit(SousCatProd<T> nature,T... tabProduit){
		String validation="";
		if (!ensembleSsCatProds.contains(nature)){
			validation="La nature du produit n'est pas connu";
		}
		else {
			for (T produit : tabProduit) {
				
				for (SousCatProd<T> natureEnCours : ensembleSsCatProds) {
					if (natureEnCours.equals(nature)) natureEnCours.ajouterProduit(produit);
				}
				validation+="L'aliment "+produit+" a bien été ajouté\n";
			}
		}
		
		return validation;
	}
	public String affichageBaseProduit (){
		Categorie categorie = ensembleSsCatProds.get(0).getCategorie();
		String affichage ="Categorie "+categorie+" : \n";
		for (SousCatProd<T> natureEnCours : ensembleSsCatProds) {
			Categorie categorieEnCours = natureEnCours.getCategorie();
			if (categorieEnCours!= categorie) {
				categorie = categorieEnCours;
				affichage+="\nCategorie "+categorie+" : \n";
			}
			affichage+=natureEnCours.toString()+"\n";
		}
		return affichage;
	}
	
	public void supprimerSousCat(SousCatProd<T> nature){
		//méthode 1 : éa marche alors que éa devrait pas, parce que le equals fonctionne alors qu'il devrait pas!! en tous cas on l'a pas redéfinit
		/*for(SousCatProd<T> ssCat : ensembleSsCatProds){
			if(ssCat.getNom() == nature.getNom()){
				//ensembleSsCatProds.remove(ensembleSsCatProds.indexOf(ssCat));
				ensembleSsCatProds.remove(ssCat);
			}
		}*/
		//éa marche parce qu'il y a pas d'accés concurrents !!! marche que si c'est le méme pointeur si méthode equals pas overridée
		ensembleSsCatProds.remove(nature);

		/*Iterator<SousCatProd<T>> i = ensembleSsCatProds.iterator();
		while(i.hasNext()){
			SousCatProd<T> sscat = (SousCatProd<T>)i.next();
			if(sscat.getNom() == nature.getNom()){
				//méthode 2 : pas d'action sur la liste en dehors de l'itérateur, sinon liste modifiée par un autre thread (autre itérateur...) 
				//ensembleSsCatProds.remove(sscat);
				// méthode 3
				i.remove();
			}
		}*/
	}
	
	public List<SousCatProd<T>> listSousCategorie(Categorie nature){
		if(ensembleSsCatProds.size() ==0 ) return null;
		
		int premier =-1 , dernier = -1;
		String currentCat, catRecherchee = nature.toString();
		boolean trouvee = false, fin = false;
		int i = 0;
		while(i<ensembleSsCatProds.size() && !fin){
			currentCat = ensembleSsCatProds.get(i).getCategorie().toString();
			if(currentCat == catRecherchee && !trouvee){
				trouvee = true;
				premier = i;
			}
			else if(currentCat != catRecherchee && trouvee){
				fin = true;
				dernier = i-1;
			}
			i++;
		}
		//System.out.println(premier + " " + dernier);
		return ensembleSsCatProds.subList(premier, dernier);
	}
	
	public String affichageCategories(){
		String str = "";
		if(ensembleSsCatProds.size() == 0) return str;
		
		String currentCat = ensembleSsCatProds.get(0).getCategorie().toString(), nextCat;
		str += currentCat;
		for(int i = 1; i<ensembleSsCatProds.size(); i++){
			nextCat = ensembleSsCatProds.get(i).getCategorie().toString();
			if(currentCat != nextCat){
				currentCat = nextCat;
				str +=  " - " + currentCat;
			}
		}
		
		return str;
	}
	
	public String affichageSousCategories(Categorie cat){
		if(ensembleSsCatProds.size() ==0 ) return null;
		
		String currentCat, catRecherchee = cat.toString(), str = "";
		boolean trouvee = false, fin = false;
		int i = 0;
		while(i<ensembleSsCatProds.size() && !fin){
			currentCat = ensembleSsCatProds.get(i).getCategorie().toString();
			if(currentCat == catRecherchee){
				trouvee = true;
				str += ensembleSsCatProds.get(i).getNom() + " ";
			}
			else if(currentCat != catRecherchee && trouvee){
				fin = true;
			}
			i++;
		}
		return str;
	}
	
	//retourne les produits d'une souscatégorie
	public String affichageProduit(SousCatProd<T> ssCat){
		return ensembleSsCatProds.get(ensembleSsCatProds.indexOf(ssCat)).affichageProduit();
	}
	

	public boolean supprimerProduit(SousCatProd<T> nature, int index){
		if(ensembleSsCatProds.size() == 0 || index < 0 || index >= ensembleSsCatProds.size()) return false;
		
		int indexSscat = ensembleSsCatProds.indexOf(nature);
		return ensembleSsCatProds.get(indexSscat).supprimerProduit(index);
	}
}
