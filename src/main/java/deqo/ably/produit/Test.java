package deqo.ably.produit;


public class Test {
	
	/*
	 * 
	 * JAVA NE PASSE EN PARAMETRE QUE DES PRIMITIVES (valeurs) OU DES REFERENCES A DES 
	 * D'OBJETS !!!!!!
	 * - ne pas confondre : une instance d'un objet (ensemble des valeurs), et la référence é cette instance
	 * - Objet o = new Objet(); =>> o est une référence é l'instance objet correspondante
	 * 
	 *  LES FONCTIONS EN JAVA NE PASSENT QUE PAR VALEUR ; COMME IL N'Y A QUE DES PRIMITES
	 *  OU DES REFERENCES D'OBJETS, ON NE PASSE DANS UNE FONCTION QUE DES PRIMITIVES PAR VALEUR
	 *  OU DES REFERENCES PAR VALEUR !!! donc dans une fonction on a soit une copie d'une valeur primitive,
	 *  soit une copie d'une référence é un objet, mais ce n'est pas la référence d'origine !!!
	 *  c'est é dire qu'on peut modifier l'objet pointé (en paramétre), mais on ne peut pas changer
	 *  lé ou pointe la référence d'origine quand on sort de la fonction (cf. code ci-dessous)
	 * 
	 */

	
	public static void main(String[] args) {

		Categorie cremerie = new Categorie("cremerie");
		Categorie boucherie = new Categorie("boucherie");
		/*SousCategorie fromage = new SousCategorie(cremerie,"les fromages");
		SousCategorie yaourt = new SousCategorie(cremerie,"les yaourts");
		SousCategorie boeuf = new SousCategorie(boucherie, "la viande de boeuf");
		GestionAliments gestionAliments= new GestionAliments();
		*/
		
		/*gestionAliments.ajouterSousCategorieAliments(fromage);
		gestionAliments.ajouterSousCategorieAliments(boeuf);
		gestionAliments.ajouterSousCategorieAliments(yaourt);
		gestionAliments.ajouterAliment(fromage, new Aliment("fromage de chévre"));
		gestionAliments.ajouterAliment(yaourt,new Aliment("yaourt SousCatProd"));
		gestionAliments.ajouterAliment(boeuf,new Aliment("steak haché"));
		gestionAliments.ajouterAliment(fromage, new Aliment("fromage bleu"));
		gestionAliments.ajouterAliment(yaourt,new Aliment("yaourt au fruits"));*/
		
		// Avec méthodes é arguments Variables
		/*gestionAliments.ajouterSousCategories(fromage, boeuf, yaourt);
		gestionAliments.ajouterAliments(fromage, new Aliment("fromage de chévre"), new Aliment("fromage bleu"));
		gestionAliments.ajouterAliments(yaourt, new Aliment("yaourt SousCatProd"), new Aliment("yaourt aux fruits"));
		gestionAliments.ajouterAliments(boeuf, new Aliment("steak haché")); */
		
		//Avec les types génériques
		/*SousCatProd<Aliment> fromage = new SousCatProd<Aliment>(cremerie,"les fromages");
		SousCatProd<Aliment> yaourt = new SousCatProd<Aliment>(cremerie,"les yaourts");
		SousCatProd<Aliment> boeuf = new SousCatProd<Aliment>(boucherie, "la viande de boeuf");
		GestionProduits<Aliment> gestionAliment= new GestionProduits<Aliment>();
		gestionAliment.ajouterSousCatProduits(fromage,boeuf,yaourt);
		gestionAliment.ajouterProduit(fromage, new Aliment("fromage de chévre"),new Aliment("fromage bleu"));
		gestionAliment.ajouterProduit(yaourt,new Aliment("yaourt nature"),new Aliment("yaourt au fruits"));
		gestionAliment.ajouterProduit(boeuf,new Aliment("steak haché"));

		Categorie televiseur = new Categorie("Téléviseur");
		SousCatProd<MultiMedia> televiseurLed = new SousCatProd<MultiMedia>(televiseur,"technologie led");
		GestionProduits<MultiMedia> gestionMultiMedia= new GestionProduits<MultiMedia>();
		gestionMultiMedia.ajouterSousCatProduits(televiseurLed);
		gestionMultiMedia.ajouterProduit(televiseurLed, new MultiMedia("troisQuart"));
		gestionMultiMedia.ajouterProduit(televiseurLed, new MultiMedia("seizeNeuviéme"));
		
		System.out.println(gestionMultiMedia.affichageBaseProduit());
		System.out.println(gestionAliment.affichageBaseProduit());
		
		//Suppression sous cat : OK

		SousCatProd<Aliment> fromage2 = new SousCatProd<Aliment>(cremerie, "les fromages");
		gestionAliment.supprimerSousCat(fromage2);

		System.out.println(gestionAliment.affichageBaseProduit());*/
		
		//Retour de liste, OK ! 
		//System.out.println(gestionAliment.listSousCategorie(cremerie));
		
		//Affichage catégories OK
		//System.out.println(gestionAliment.affichageCategories());
		
		//Affichage sous catégories OK
		//System.out.println(gestionAliment.affichageSousCategories(cremerie));
		
		//Affichage des produits OK. Mais faudrait implémenter equals...
		//System.out.println(gestionMultiMedia.affichageProduit(televiseurLed));
		
		//suppression Produit OK
		//System.out.println(gestionAliment.supprimerProduit(yaourt, 0));
		//System.out.println(gestionAliment.affichageBaseProduit());
		

	}

}
