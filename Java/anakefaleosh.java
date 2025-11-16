import java.io.*;
import java.util.*;

public class anakefaleosh {
    //Δημιουργία μη μεταβαλόμενης φράσης
    public static final String in = "kasd.{(dkjhasd;jhkdjh;)}";


    public static void main(String[] args) {
        //bUffered list πάντα εντώς της main 
        List<String> buffer = new ArrayList<>();


        //Κόψε τη βράση και αποθήκευσε τα κομμένα σημεία 
        String[] komatia = in.split(".");
        String komati1 = komatia[0];
        String komati2 = komatia[1];

        String komatia1_sketo = komati2.replace("\\{(\\;)}", "");//Για να μποορέσουμε να κόψουμε χαρακτήρες
        buffer.add(komatia1_sketo);

        //Διάβασμα αρχείου και γραψιμο
        //Δημιουργία αρχείου
        try
        {
            FileWriter wrt = new FileWriter("dokimh.txt");
            for(String i : buffer){//To i παίρνει τη τιμή του buffer αλλα δε μας χαλλάει το αρχικό 
                wrt.write(i);
                wrt.close();//Καλό είναι πάντα να κλείνουμε το file read / write
            }
            //Σε περίπτωση που δεν μπει το ioexception δεν μπορεί να τρέξει το fileread/filewrite
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Διάβασμα αρχείου
        try
        {
            File new_file = new File("dokimh.txt");
            Scanner myScanner = new Scanner(new_file);
            while(myScanner.hasNextLine()){
                String data = myScanner.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    
}
