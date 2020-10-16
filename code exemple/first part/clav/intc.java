import java.util.Scanner;

public class intc {
    public static void main( String [] args ) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Saisissez un entier : ");
        int nbr;
        nbr = clavier.nextInt();
        System.out.println("Vous avez saisie : " + nbr);
    }
}
