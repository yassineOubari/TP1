import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise3Test {

    @Test
    void generateWoow() {
        String wow = "Woooooooooooooooooooooooooooow";
        Assertions.assertEquals(wow, Exercise3.generateWoow(28));
    }

    @Test
    void generateWoow2() {
        String wow = "Wooooow";
        Assertions.assertEquals(wow, Exercise3.generateWoow(5));
    }

    @Test
    void generateWoow3() {
        String wow = "Wooooooooooooooooooooooooooooooooooooooooooooooooow";
        Assertions.assertEquals(wow, Exercise3.generateWoow(49));
    }

    @Test
    void generateWoow4() {
        String wow = "Wow";
        Assertions.assertEquals(wow, Exercise3.generateWoow(1));
    }
}
public class Exercise3 {

    // Fonction a completer qui génère le mot avec 'x' nombre de o
    public static String generateWoow(int x) {
        String wow = "Wooooooooooooooooooooooooooooooooooooooooooooooooo"; //lol
        return wow.substring(0,x+1) + "w";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lecture de la valeur x
        System.out.println("Veuillez entrer un nombre entre 1 et 49:");
        int x = scanner.nextInt();

        // Assurez-vous que x est dans la plage autorisée
        if (x > 0 && x < 50) {
            // Appel de la fonction generateWoow et affichage du résultat
            String result = generateWoow(x);
            System.out.println(result);
        } else {
            System.out.println("Veuillez entrer un nombre entre 1 et 49.");
        }
        
        scanner.close();
    }
}
