import java.nio.file.Paths;
import java.util.*;

public class Launcher {
    public interface Command{
        String name();
        Boolean run(Scanner scanner);
    }
    public static void main(String[] args){
            List<Command> command = new ArrayList<>();
            command.add(new Quit(){});
            command.add(new Fibo(){});
            command.add(new Freq(){});
            System.out.println("Bienvenue sur le Launcher !");
            Scanner sc = new Scanner(System.in);
            while (true) {
                String inp = sc.nextLine();
                int u = 0;
                for (Command value : command) {
                    if (value.name().equals(inp)) {
                        if (value.run(sc)) {
                            System.out.println("Bonne journée");
                            return;
                        }else {
                            u++;
                        }
                    }
                }
                if (u==0){
                    System.out.println("Unknown command");
                }
            }

    }
}

abstract class Quit implements Launcher.Command {
    public String name () {return "Quit";}
    public Boolean run(Scanner scanner){
        return true;
    }
}

abstract class Fibo implements Launcher.Command{
    public String name () {return "Fibo";}
    public Boolean run(Scanner scanner){
        System.out.println("Entrez l'index du nombre que vous chercher dans la séquence de fibo : ");
        int n = Integer.parseInt(scanner.nextLine());
        if(n <= 1) {
            System.out.println("Le résultat est "+n);
            return false;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        System.out.println("Le résultat est "+fib);
        return false;
    }
}

abstract class Freq implements Launcher.Command{
    public String name () {return "Freq";}
    public Boolean run(Scanner scanner){
        System.out.println("Entrez le path du fichier que vous voulez traiter (connaitre les 3 mots les plus courants) : ");
        Scanner sc = new Scanner(System.in);
        String inpf = (sc.nextLine());
        try {
            String fc = java.nio.file.Files.readString(Paths.get(inpf));
            fc = fc.replaceAll("\\p{Punct}", " ");
            fc = fc.toLowerCase();
            String[] fct = fc.split(" ");
            ArrayList<String> fct2 = new ArrayList<>();
            for (String word : fct){
                if(!word.isBlank()){
                    fct2.add(word);
                }
            }
            Map<String,Integer> map_res = new HashMap<>();
            int i;
            for (String word : fct2){
                i=0;
                for (String wordc : fct2){
                    if(word.equals(wordc)){
                        i++;
                    }
                }
                map_res.put(word,i);
            }
            for(int c=0; c<3; c++) {
                int maxValueInMap = (Collections.max(map_res.values()));
                for (Map.Entry<String, Integer> map : map_res.entrySet()) {
                    if (map.getValue() == maxValueInMap) {
                        System.out.print(map.getKey()+" ");
                        map_res.remove(map.getKey());
                        break;
                    }
                }
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Unreadable file: "+e);
        }
        return false;
    }
}
