
import java.util.*;

public class OnlineShoppingCartSystem {

    // List - stores products in cart
    static List<String> cart = new ArrayList<>();

    // Set - stores unique product categories
    static Set<String> categories = new HashSet<>();

    // Map - stores Product ID and Product Name
    static Map<Integer, String> products = new HashMap<>();

    // Queue - stores orders
    static Queue<String> orderQueue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. View Categories");
            System.out.println("5. Place Order");
            System.out.println("6. Process Order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Product Category: ");
                    String category = sc.nextLine();

                    // Add product to Map
                    products.put(id, name + " - Rs." + price);

                    // Add product to List
                    cart.add(name);

                    // Add category to Set
                    categories.add(category);

                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product Name to remove: ");
                    String removeProduct = sc.nextLine();

                    if (cart.remove(removeProduct)) {
                        System.out.println("Product removed successfully.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                    break;

                case 3:
                    System.out.println("\nProducts in Cart:");

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (String product : cart) {
                            System.out.println(product);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nProduct Categories:");

                    for (String categoryName : categories) {
                        System.out.println(categoryName);
                    }
                    break;

                case 5:
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty. Cannot place order.");
                    } else {
                        orderQueue.add(customer);
                        System.out.println("Order placed successfully.");
                    }
                    break;

                case 6:
                    if (orderQueue.isEmpty()) {
                        System.out.println("No pending orders.");
                    } else {
                        String customerName = orderQueue.poll();
                        System.out.println(
                            "Order processed for customer: " + customerName
                        );
                    }
                    break;

                case 7:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}


