import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/*
 * Efter vi har snakket om unchecked vs check exceptions er planen følgende;:
 *
 * 1)først får I lige en demo af det er.
 * 2) Læreren minder jeg lige om dogmet om at man kun må skriv ud til terminalen fra main.(mind ham lige om det)
 * 3) så laver vi en række pakke som vi trækker nogen af funktionerne ud .
 * 4) så laver vi vores egen fejlmeddelelse og ser hvad den giver os af muligheder.
  *
  * */

public class Main {

    public static void main(String[] args) {
        // write your code here

// filnavnet acceptere alt undtagen de tomme streng.
        System.out.println(callWriteToFile("palle", 22, 23.5, ""));


        System.out.println("Hurra vi nåede igennem main");
    }

    

    public static String callWriteToFile(String name, int age, double temp, String fileName)  {
        // TODO: 05/12/2018 skal faktoriseres ud i en pakke skal faktoriseres ud i en pakke vi kalder logik

        try {
           writeToFile(name,age,temp,  fileName);

        } catch (Exception e) {
            //e.printStackTrace();
            return e.getMessage();
        }
        return "filen er gemt";
    }

    public static void writeToFile(String navn, int age, double bodyTemp, String filename ) throws Exception {

        // TODO: 05/12/2018 Skal faktoriseres ud i en pakke vi kalder "persistence" :


        FileWriter fw;
       try {
            fw = new FileWriter(new File(filename));

            fw.write(String.format(" navn : %s.", navn));
            fw.write(System.lineSeparator()); //new line
            fw.write(String.format("Alder anslået %d år", age));
            fw.write(System.lineSeparator()); //new line
            fw.write(String.format("kropstemperatur  %.2f celcius" , bodyTemp));
            fw.write(System.lineSeparator()); //new line
            fw.close();
        } catch (IOException ex) {
//            ex.printStackTrace();
            throw new  MissingFileName("mangler filnavn, prøv igen");
        }




    }



    public static void callCopyFile(String org, String copy) {
        // TODO: 05/12/2018 skal faktoriseres ud i pakken logik

        copyFile(org,copy);

    }


    private static void copyFile(String kilde, String nyCopi) {
        // TODO: 05/12/2018 skal faktoriseres ud i pakke "persistence"
        Path original = Paths.get("",kilde);
        Path copi = Paths.get("",nyCopi);


        try {
            Files.copy(original,copi, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("fil er lavet"); // TODO: 05/12/2018  Der skal ikke skrives til skærmen herfra.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    public static int a() throws ArithmeticException, InterruptedException {


        Thread.sleep(100);
        return 4;
    }
        /*ovenstående throws er unchecked exceptions, og det er ikke krævet at man nævner dem i signaturen*/

    public static int b() {


        return c();


    }

    public static int c() throws ArithmeticException {
        /*ovenstående throws er unchecked exceptions, og det er ikke krævet at man nævner dem i signaturen*/




        return 5;


    }


}
