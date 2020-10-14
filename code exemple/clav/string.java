import java.util.Scanner;

public class string {
    public static void main( String [] args ) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Saisissez un nom : ");
        String name;
        name = clavier.nextLine();
        System.out.println("Vous avez saisie : " + name);
    }
}
