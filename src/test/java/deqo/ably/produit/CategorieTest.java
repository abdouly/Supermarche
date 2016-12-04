package deqo.ably.produit;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 04/12/2016.
 */
public class CategorieTest {
    Categorie categorie;
    @Before
    public void setUp() throws Exception {
        categorie = new Categorie("fruits");
        System.out.println("creation de la categorie");
    }

    @org.junit.Test
    public void getCopy() throws Exception {
        assertTrue(categorie.toString().equals("fruits"));
        assertTrue(categorie.getCopy() instanceof  Categorie);
    }

    @Test
    public void setNom() throws Exception {
        categorie.setNom("legume");
        assertTrue(categorie.toString().equals("legume"));
    }

    @Test
    public void getCategories() throws Exception {

    }

    @Test
    public void equals() throws Exception {

    }
}