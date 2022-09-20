import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le Launcher !");
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if (inp != "quit"){
                System.out.println("Unknown command");
        }
    }
}