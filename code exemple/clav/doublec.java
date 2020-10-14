import java.util.Scanner;

public class doublec {
    public static void main( String [] args ) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Saisissez un nombre à virgule : ");
        double nbr;
        nbr = clavier.nextDouble();
        System.out.println("Vous avez saisie : " + nbr);
    }
}
