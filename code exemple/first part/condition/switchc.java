public class switchc {
    public static void main( String [] args ) {
        int note = 20;

        switch(note)
        {
            case 20:
                System.out.println("Superbe note !");
                break;

            case 15:
                System.out.println("15 bravo !");
                break;

            case 10:
                System.out.println("10, la moyenne, sa passe...");
                break;

            case 5:
                System.out.println("5, ah oof, ratrate toi !");
                break;

            case 0:
                System.out.println("Aie retravaille !");
                break;

            default:
                System.out.println("Note iconnu");
        }
    }
}