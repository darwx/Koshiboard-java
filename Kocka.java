//Import balíčka Random
import java.util.Random;

//Trieda kocka
public class Kocka {
    //Metoda hodKockou
    public static int hodKockou(){
  
        //Vytvorenie objektu Random
        Random rand = new Random();
  
        //Metoda rand vygeneruje nahodny integer od 0 do 5 a pripocita 1 (vysledne cislo bude od 1 do 6). Potom to cislo hodi do premennej vysledok
        return rand.nextInt(6) + 1;  //Vracia sa vysledok hodu
    }
}
