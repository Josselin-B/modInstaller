import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void moveFile(File[] t, Path arr){

      try {
          for(File f: t){

              Files.copy(f.toPath(),arr.resolve(f.getName()));
          }
      }catch (Exception e){
            System.out.println(e+" MoveFile ");
      }
    }

    public static void deletFold(File[]t,Path mod){
        for(File f : t){
            f.delete();
        }
    }


    public static void main(String[] args) {
        String foldprop =System.getProperty("user.home");           //recupe le chemin d'acce appdata contenant le user
        String chmacc = foldprop+"\\AppData\\Roaming\\.minecraft\\mods";   //va jusqu'au dossier mod à partir du disque C:
        Path mod = Paths.get(chmacc);                                       //le converti en Path

        Path depart = Paths.get("mod");                                 //recup le dossier des mods à changer dans le jar
        File dirmod = depart.toFile();                                      //le converti en la class File(pour les méthodes)
        File[] tab= dirmod.listFiles();                                     //cree un tableau de tous les fichiers à envoyer
        File[] tabmodancien = mod.toFile().listFiles();

        try{
        if(Files.exists(mod)){
        System.out.println("ok");
        deletFold(tabmodancien,mod);
        moveFile(tab,mod);
        }else {
            System.out.println("Forge pas installé");
        }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}