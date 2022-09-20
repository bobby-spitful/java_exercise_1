import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le Launcher !");
        Scanner sc = new Scanner(System.in);
        while(true) {
            switch(sc.nextLine()){
                case "quit":
                    return;
                case "fibo":
                    System.out.println("Entrez l'index du nombre que vous chercher dans la séquence de fibo ");
                    int inp2 = Integer.parseInt(sc.nextLine());
                    System.out.println("le résultat est "+fibo(inp2));
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
    public static int fibo(int n){
        if (n <= 1)
            return n;
        return fibo(n-1) + fibo(n-2);
    }
}