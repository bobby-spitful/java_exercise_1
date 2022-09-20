import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le Launcher !");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String inp = sc.nextLine();
            if ("quit".equals(inp)) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}