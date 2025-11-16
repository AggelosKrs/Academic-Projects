import java.io.*;
import java.util.*;

public class theoria {
    /* Το public static finala String 
     * δηλώνεται πάντα σαν object και δε μπορεί να μεταβληθεί 
     */

    public static final String txt1 = "asdasd.asdoh,aisugd({})";
    public static void main(String[] args) {

        /*
         * Για να μπορούμε να φτιάξουμε στο σκελετό της HTML ποιό εύκολα
         * μπορούμε απλά να φτιάξουμε ένα Buffer.
         * Κάνουμε τη δημιουργλι ενός πίνακα
         * και κάθε φορά προσθέτουμε το σκελετό στο σημείο που θέλουμε
         * buffer.add("HTML κώδικα")
         */
        List<String> buffer = new ArrayList<>();//Το δηλώνουμε ότι είναι String ArrayList
        /* παράδειγμα
         *Το buffer δέχεται μόνο συμβολοσειρές και δεν μεταβάλει τιμές όσο προσθέτουμε
        */
        buffer.add("<html>\n<head>\n<title>'γρφουμε ότι θέλουμε ή την τιμή του στρινγ'</title>\n</head>\n");
        buffer.add("<body>\n</body>\n</html>");//Βολεύει μαζί τα </body></html>
        // Προσθήκη κουμπιών
        buffer.add("<input tupe='submit' value='ότι τιμή είναι να μπεί εδώ'>");
        //Για δημειουρφεία πίνακα σε HTML 
        buffer.add("<table>");//Αρχή πίνακα
        buffer.add("<tr><td>");//Δημιουργεία columns
        buffer.add("</td></tr>");//Το td πρέπει να κλείσει πρώτο από το tr
        buffer.add("</table>");
        //Options
        buffer.add("<label for='onoma'></label>");
        buffer.add("<select name='onomata'>\n<option>" + txt1 +"</option></select>");

        /*Για να κόψουμε ένα string όπως το πιό πάνω
         * το split() μασ βοηθάει όταν θέλουμε να φτιάξουμ ένα μενού από μία συμβολοσειρά 
        */
        String[] title = txt1.split(".");//έχει κοπεί σε δυο μέρη
        String titlos = title[0];//Εδώ αποθηκεύεται οτιδήποτε είναι πίσω από την πρώτη τελία 
        String epomeno = title[1];//Εδω ότι είναι μετά την πρώτη τελία

        
        // Ξεκινάμε να διαβάζουμε το αρχείο
        try {
            File myObj = new File("filename.txt");// Άνοιγμα αρχείου
            Scanner myReader = new Scanner(myObj); // Διάβασμα αρχείου
            while (myReader.hasNextLine()) {// Όσο έχει και άλλη γραμμή
                if( myReader.nextLine() == "Quit"){//
                    myReader.close();
                    break;
                }
                String data = myReader.nextLine();//Πάει και αποθηκεύει την κάθε γραμμή από το αρχειο που διαβάζει
                System.out.println(data);//Το αρχείο αποθηκεύεται στη μεταβλητη data άρα μπορεί να χρησιμοποιήθει και εκτός της loop
            }
            myReader.close();// Κλείσημο αρχείου
        } catch (FileNotFoundException e) {
            System.out.println("Message");
            e.printStackTrace();
        }

        // Για να μπορούμε να δημιουργήσουμε ένα αρχείο αρκεί να το κάνουμε με το buffer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("index.html", true))) {
            // To buffer περιμένει να διαβάζει τις μεταβλιτές. Θα πάρουμε την συνθίκη
            // foreach
            for (String kati : buffer) {
                
                writer.write(kati);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
