import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        System.out.println("Bienvenue dans ClavGame !\nMerci de bien cuivre les instructions donné.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Entré votre nom : ");
        String name;
        name = sc.nextLine();
        System.out.println("Entré votre age : ");
        int age;
        age = sc.nextInt();
        System.out.println("Vous vous appelez " + name + " et vous avez " + age);
    }
}