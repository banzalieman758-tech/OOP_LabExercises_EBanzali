import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Collections; 
import java.time.LocalDate; 
import java.lang.Math; 

public class BuiltIn {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
       
        ArrayList<String> products = new ArrayList<>();
        products.add("Rice");
        products.add("Corn");
        products.add("Banana");

        Collections.sort(products);
 
        LocalDate today = LocalDate.now();

        double price = 45.0;
        double discount = Math.round(price * 0.9); 

        System.out.println("\nHello, " + name + "!");
        System.out.println("Today's date: " + today);
        System.out.println("Available products (sorted): " + products);
        System.out.println("Discounted price of Rice: ₱" + discount);

        sc.close();
    }
}