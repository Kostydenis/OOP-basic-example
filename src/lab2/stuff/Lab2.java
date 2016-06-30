package lab2.stuff;

import java.util.Scanner;
import lab2.Zoo;

/**
 *
 * @author Денис
 */
public class Lab2 {

    /**
     * Зоопарк.
     * 
     * Можно создавать котиков(львов/тигров/зебр), кормить, лечить, а потом убивать.
     * 
     * @param args "g" - graphic interface; "c" - console interface
     */
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        
        try {
            if ("c".equalsIgnoreCase(args[0])) {
                Console.start(zoo);
            } else {
                if ("g".equalsIgnoreCase(args[0])) {
                    GUI gui = new GUI(zoo);
                } else {
                    System.out.println("argument \"g\" is for graphic version, \"c\" is for console");
                    System.out.println("Enter to exit");
                    new Scanner(System.in).nextLine();
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("argument \"g\" is for graphic version, \"c\" is for console");
            System.out.println("Enter to exit");
            new Scanner(System.in).nextLine();
        }

    }
}
