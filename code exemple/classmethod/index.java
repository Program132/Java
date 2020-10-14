public class index {
    public static void main(String[] args)
    {
        String c = "jazihrairarreurhzuggzhzh";
        int n;
        n = c.indexOf('j'); 
        System.out.println(n); // Print la position du premier j
        n = c.indexOf('h');
        System.out.println(n);  // Print la position du premier h
        n = c.lastIndexOf('j'); 
        System.out.println(n); // Print la position du dernier j
        n = c.lastIndexOf('h');
        System.out.println(n); // Print la position du dernier h
    }
}
