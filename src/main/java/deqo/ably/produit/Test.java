package deqo.ably.produit;


public class Test {
	
	/*
	 * 
	 * JAVA NE PASSE EN PARAMETRE QUE DES PRIMITIVES (valeurs) OU DES REFERENCES A DES 
	 * D'OBJETS !!!!!!
	 * - ne pas confondre : une instance d'un objet (ensemble des valeurs), et la r�f�rence � cette instance
	 * - Objet o = new Objet(); =>> o est une r�f�rence � l'instance objet correspondante
	 * 
	 *  LES FONCTIONS EN JAVA NE PASSENT QUE PAR VALEUR ; COMME IL N'Y A QUE DES PRIMITES
	 *  OU DES REFERENCES D'OBJETS, ON NE PASSE DANS UNE FONCTION QUE DES PRIMITIVES PAR VALEUR
	 *  OU DES REFERENCES PAR VALEUR !!! donc dans une fonction on a soit une copie d'une valeur primitive,
	 *  soit une copie d'une r�f�rence � un objet, mais ce n'est pas la r�f�rence d'origine !!!
	 *  c'est � dire qu'on peut modifier l'objet point� (en param�tre), mais on ne peut pas changer
	 *  l� ou pointe la r�f�rence d'origine quand on sort de la fonction (cf. code ci-dessous)
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
		gestionAliments.ajouterAliment(fromage, new Aliment("fromage de ch�vre"));
		gestionAliments.ajouterAliment(yaourt,new Aliment("yaourt SousCatProd"));
		gestionAliments.ajouterAliment(boeuf,new Aliment("steak hach�"));
		gestionAliments.ajouterAliment(fromage, new Aliment("fromage bleu"));
		gestionAliments.ajouterAliment(yaourt,new Aliment("yaourt au fruits"));*/
		
		// Avec m�thodes � arguments Variables
		/*gestionAliments.ajouterSousCategories(fromage, boeuf, yaourt);
		gestionAliments.ajouterAliments(fromage, new Aliment("fromage de ch�vre"), new Aliment("fromage bleu"));
		gestionAliments.ajouterAliments(yaourt, new Aliment("yaourt SousCatProd"), new Aliment("yaourt aux fruits"));
		gestionAliments.ajouterAliments(boeuf, new Aliment("steak hach�")); */
		
		//Avec les types g�n�riques
		/*SousCatProd<Aliment> fromage = new SousCatProd<Aliment>(cremerie,"les fromages");
		SousCatProd<Aliment> yaourt = new SousCatProd<Aliment>(cremerie,"les yaourts");
		SousCatProd<Aliment> boeuf = new SousCatProd<Aliment>(boucherie, "la viande de boeuf");
		GestionProduits<Aliment> gestionAliment= new GestionProduits<Aliment>();
		gestionAliment.ajouterSousCatProduits(fromage,boeuf,yaourt);
		gestionAliment.ajouterProduit(fromage, new Aliment("fromage de ch�vre"),new Aliment("fromage bleu"));
		gestionAliment.ajouterProduit(yaourt,new Aliment("yaourt nature"),new Aliment("yaourt au fruits"));
		gestionAliment.ajouterProduit(boeuf,new Aliment("steak hach�"));

		Categorie televiseur = new Categorie("T�l�viseur");
		SousCatProd<MultiMedia> televiseurLed = new SousCatProd<MultiMedia>(televiseur,"technologie led");
		GestionProduits<MultiMedia> gestionMultiMedia= new GestionProduits<MultiMedia>();
		gestionMultiMedia.ajouterSousCatProduits(televiseurLed);
		gestionMultiMedia.ajouterProduit(televiseurLed, new MultiMedia("troisQuart"));
		gestionMultiMedia.ajouterProduit(televiseurLed, new MultiMedia("seizeNeuvi�me"));
		
		System.out.println(gestionMultiMedia.affichageBaseProduit());
		System.out.println(gestionAliment.affichageBaseProduit());
		
		//Suppression sous cat : OK

		SousCatProd<Aliment> fromage2 = new SousCatProd<Aliment>(cremerie, "les fromages");
		gestionAliment.supprimerSousCat(fromage2);

		System.out.println(gestionAliment.affichageBaseProduit());*/
		
		//Retour de liste, OK ! 
		//System.out.println(gestionAliment.listSousCategorie(cremerie));
		
		//Affichage cat�gories OK
		//System.out.println(gestionAliment.affichageCategories());
		
		//Affichage sous cat�gories OK
		//System.out.println(gestionAliment.affichageSousCategories(cremerie));
		
		//Affichage des produits OK. Mais faudrait impl�menter equals...
		//System.out.println(gestionMultiMedia.affichageProduit(televiseurLed));
		
		//suppression Produit OK
		//System.out.println(gestionAliment.supprimerProduit(yaourt, 0));
		//System.out.println(gestionAliment.affichageBaseProduit());
		

	}

}
