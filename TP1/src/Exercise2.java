import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class Exercise2Test {

    @Test
    void taille1() {
        String testString = "Hello, my name is Banana Monkey";
        int length = 31;
        Assertions.assertEquals(length, Exercise2.taille(testString));
    }

    @Test
    void taille2() {
        String testString = "Hello, my name is Monkey Banana";
        int length = 31;
        Assertions.assertEquals(length, Exercise2.taille(testString));
    }

    @Test
    void premierCharacter1() {
        String testString = "Hello, my name is Monkey Banana";
        char charTest = 'H';
        Assertions.assertEquals(charTest, Exercise2.PremierCharacter(testString));
    }

    @Test
    void premierCharacter2() {
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        Assertions.assertEquals(c, Exercise2.PremierCharacter(String.valueOf(c)));
    }

    @Test
    void souschaine() {
        String testString = "Hello, my name is Monkey Banana";
        String subString = "my name is Mon"; // 7-21 (excluding the 21st char)
        Assertions.assertEquals(subString, Exercise2.souschaine(testString, 7, 21));
    }

    @Test
    void majuscule1() {
        String testString = "Hello, my name is Monkey Banana";
        String oracle = "HELLO, MY NAME IS MONKEY BANANA";
        Assertions.assertEquals(oracle, Exercise2.majuscule(testString));
    }

    @Test
    void majuscule2() {
        String testString = "HELLO, MY NAME IS MONKEY BANANA";
        Assertions.assertEquals(testString, Exercise2.majuscule(testString));
    }

    @Test
    void minuscule() {
        String testString = "Hello, my name is Monkey Banana";
        String oracle = "hello, my name is monkey banana";
        Assertions.assertEquals(oracle, Exercise2.minuscule(testString));
    }

    @Test
    void minuscule2() {
        String testString = "hello, my name is banana monkey";
        String oracle = "hello, my name is banana monkey";
        Assertions.assertEquals(oracle, Exercise2.minuscule(testString));
    }

    @Test
    void changerCharacter() {
        String testString = "Hello, my name is Monkey Banana";
        char oldChar = 'a';
        char newChar = 'e';
        String oracle = "Hello, my neme is Monkey Benene";
        Assertions.assertEquals(oracle, Exercise2.ChangerCharacter(testString, oldChar, newChar));
    }

    @Test
    void sansString() {
        String testString = "      Hello, my name is Monkey Banana      ";
        String oracle = "Hello, my name is Monkey Banana";
        Assertions.assertEquals(oracle, Exercise2.SansString(testString));
    }

    @Test
    void prefix1() {
        String testString = "Hello, my name is Monkey Banana";
        String prefix = "Hell";
        boolean oracle = true;
        Assertions.assertEquals(oracle, Exercise2.Prefix(testString, prefix));
    }

    @Test
    void prefix2() {
        String testString = "Hello, my name is Monkey Banana";
        String prefix = "Manana";
        boolean oracle = false;
        Assertions.assertEquals(oracle, Exercise2.Prefix(testString, prefix));
    }
}

public class Exercise2 {

    // 1. méthode pour retourner le nombre de caractères dans la chaîne.
    public static int taille(String str) {
        return str.length();
    }

    // 2. méthode pour retourner le premier caractère de la chaîne.
    public static char PremierCharacter(String str) {
        return str.charAt(0);
    }

    // 3. méthode pour retourner une partie de la chaîne de caractères. Notez que le caractère à l'index de fin n'est pas inclus.
    public static String souschaine(String str, int start, int end) {
        return str.substring(start, end);
    }

    // 4. méthode pour convertir la chaîne en lettres majuscules.
    public static String majuscule(String str) {
        return str.toUpperCase();
    }

    // 5. méthode pour convertir la chaîne en lettres minuscules.
    public static String minuscule(String str) {
        return str.toLowerCase();
    }

    // 6. methode pour remplacer toutes les occurrences de oldChar par newChar.
    public static String ChangerCharacter(String str, char oldChar, char newChar) {
        //on traverse notre chaine de chars
        for (int i = 0; i < str.length(); i++) {
            //on a trouve notre char
            if (str.charAt(i) == oldChar) {
                //on le remplace
                str = str.substring(0, i) + newChar + str.substring(i + 1);
            }
        }
        return str;
    }

    // 7. méthode pour supprimer les espaces de début et de fin de la chaîne.
    public static String SansString(String str) {
        //mettre le pointeur au debut (1er char)
        int pos = 0;
        while (str.charAt(pos) == ' ') {  //tant qu'on trouve des espaces on avance
            pos++;
        }
        //on enleve la premiere partie vide
        str = str.substring(pos,str.length());

        //mettre notre pointeur a la fin (dernier char)
        pos = str.length()-1;
        while (str.charAt(pos) == ' ') {
            pos--;
        }
        //on enleve la derniere partie vide
        str = str.substring(0,pos+1); //notre pointeur n'est pas vide, donc il faut l'inclure
        return str;
    }

    // 8. méthode pour vérifier si la chaîne commence par le préfixe spécifié.
    public static boolean Prefix(String str, String prefix) {
        if (str.indexOf(prefix) == 0){
                return true;
        }
        else{
            return false;
        }
    }

    
    public static void main(String[] args) {
        String example = "  Hello, World!  ";

        
        System.out.println("Length of the string: " + taille(example));

       
        System.out.println("First character of the string: " + PremierCharacter(example));

        
        System.out.println("Substring (9, 14): " + souschaine(example, 9, 14));

        
        System.out.println("Uppercase: " + majuscule(example));

     
        System.out.println("Lowercase: " + minuscule(example));

       
        System.out.println("Replacing 'o' with '0': " + ChangerCharacter(example, 'o', '0'));

        
        System.out.println("Trimmed string: '" + SansString(example) + "'");

       
        System.out.println("Starts with '  Hel': " + Prefix(example, "  Hel"));
        System.out.println("Length of the string: " + taille(example));
    }
}
