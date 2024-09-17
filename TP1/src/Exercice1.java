import java.util.Arrays;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
/*
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise1Test {

    @Test
    void testAgrandirTab1() {
        assertNull(Exercice1.agrandirTab(null));
    }

    @Test
    void testAgrandirTab2() {
        String[] a = new String[1];
        a[0] = "hello";
        Assertions.assertTrue(Exercice1.agrandirTab(a)[0].equals("hello"));
    }

    @Test
    void testAgrandirTab22() {
        String[] a = new String[2];
        a[0] = "hello";
        a[1] = "world";
        Assertions.assertTrue(Exercice1.agrandirTab(a)[0].equals("hello"));
        Assertions.assertTrue(Exercice1.agrandirTab(a)[1].equals("world"));
    }

    @Test
    void testAgrandirTab3() {
        String[] a = new String[1];
        a[0] = "hello";
        assertNull(Exercice1.agrandirTab(a)[1]);
    }

    @Test
    void testAgrandirTab4() {
        String[] a = new String[1];
        a[0] = "hello";
        Assertions.assertEquals(Exercice1.agrandirTab(a).length, a.length + 1);
    }

    @Test
    void testAgrandirTab5() {
        String[] a = new String[2];
        a[0] = "hello";
        Assertions.assertEquals(Exercice1.agrandirTab(a).length, a.length + 1);
    }

    @Test
    void testTrier1() {
        String[] a = { "add", "fee", "zed" };
        String[] b = Exercice1.trier(a);
        assertArrayEquals(a, b);

    }

    @Test
    void testTrier2() {
        String[] a = { "zed", "fee", "add" };
        String[] b = Exercice1.trier(a);
        String[] expected = { "add", "fee", "zed" };
        assertArrayEquals(expected, b);
    }

    @Test
    void testTrier3() {
        String[] a = {};
        String[] b = Exercice1.trier(a);
        assertArrayEquals(a, b);
    }

    @Test
    void testTrier4() {
        String[] a = { null };
        String[] b = Exercice1.trier(a);
        assertArrayEquals(a, b);
    }

	/*
	@Test
	void testLireMots() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
	      // Prepare the input you want to simulate
        String input = "add\nfee\nstop\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // Replace System.in with a custom input stream
        System.setIn(inputStream);

        // Call the method that reads from System.in and prints to System.out
        devoir.Exercice1.lireMots();

        // Capture the printed output
        String printedOutput = outContent.toString().trim();
                // Perform your test on the captured output
        assertEquals("add\nfee\n", printedOutput);
        System.setOut(originalOut);
        System.out.println(printedOutput);
	}
	*/

}

/**
 * Classe pour l'Exercise1 du IFT1025 Programmation 2, Automne 2024.
 */
public class Exercice1 {

    /**
     * Cette fonction prend un tableau de Strings en paramètre et retourne un
     * nouveau tableau contenant les mêmes éléments, avec une case disponible de
     * plus.
     * @param tab un tableau de Strings
     * @return un tableau de Strings avec tout contenu de l'entrée, 
     * plus une case avec la valeur null à la fin. 
     * Si l'entrée est null, la fonction retourne null aussi.
     */
    public static String[] agrandirTab(String[] tab) {

        if (tab == null) {
            return null;
        }

        String[] nouveauTab = new String[tab.length+1];

        for (int i = 0; i < tab.length; i++) {
            nouveauTab[i] = tab[i];
        }
        nouveauTab[nouveauTab.length-1] = null;

        return nouveauTab;
    }

    /**
     * Cette fonction lit des mots sur la ligne de commande et les retourne dans
     * un tableau de Strings. Chaque "mot" est définit comme une ligne complète,
     * du début de la ligne entrée jusqu'au prochain \n.
     * Ne changez pas cette fonction!
     * @return un tableau avec tous les mots lus sauf "stop".
     */
    public static String[] lireMots() {
    	Scanner s = new Scanner(System.in);
    	
    	String[] mots = new String[1];
    	
    	String next = s.nextLine();
    	while(!next.equalsIgnoreCase("stop")) {
    		mots[mots.length-1]=next;
    		mots = agrandirTab(mots);
    		next = s.nextLine();
    	}
    	s.close();
    	
        return mots;
    }

    /**
     * Cette fonction prend en paramètre un tableau de mots et retourne un
     * nouveau tableau contenant ces mots triés en ordre croissant.
     * Ne changez pas cette fonction!
     * @param mots le tableau à trier
     * @return copie du tableau d'entrée, dont les éléments sont triés
     */
    public static String[] trier(String[] mots) {
    	String[] copy = Arrays.copyOf(mots, mots.length);
    	Arrays.sort(copy);
        return copy;
    }

    /**
     * Fonction principale du programme.
     * Ne changez pas cette fonction!
     * @param args paramètres de ligne de commande
     */
    public static void main(String[] args) {
        System.out.println("Veuillez entrer les mots:");
    	String[] mots = lireMots();
    	
    	mots = Arrays.copyOf(mots, mots.length-1);
    	
    	mots = trier(mots);
    	    	
    	for(String m : mots)
    		System.out.println(m);

    }
}
