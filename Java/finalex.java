import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class finalex {
    //Φτιάξε ένα ατνικείμενα string έτσι ώστε να μην μπορεί να μεταβλιθεί
    public static final String in = "Για κάθε φρούτο από τα επόμενα θα πρέπει να"
            + "αποφασίσετε ποιο είναι το χρώμα του. Αν δεν το γνωρίζετε μην βάλετε κάποιο χρώμα στην τύχη."
            + "Σε αυτή την περίπτωση επιλέξτε «δεν γνωρίζω». Λανθασμένες απαντήσεις έχουν αρνητική επίδραση στη βαθμολογία."
            + ":{(κόκκινο;πορτοκαλί;πράσινο;κίτρινο;πρασινο-κόκκινο;κοκκινο-κίτρινο;σκούρο κόκκινο;δεν γνωρίζω);(πορτοκάλι;μήλο;αχλάδι;βερίκοκο;πεπόνι;καρπούζι;ροδάκινο;δαμάσκηνο;κυδώνι;ρόδι;κεράσι;σύκο)}";

    public static void main(String[] args) {

        String[] tokens = in.split(":");//Κώβει το string εκεί που υπάρχει :
        String ariki = tokens[0];//το ένα κομμάτι πριν το : καταχωρείτε εδώ
        String times = tokens[1];//Και το υπόλοιπο εδώ 

        // Οι επιλογές
        String[] options = times.split("\\);\\(");//κόψε το ένα κομμάτι εκεί που αρχίζει με ); και το άλλο εκεί που αρχίζει με (
        String variable_values = options[0].substring(2);//Ξεκίνα από τον δεύτερο χαρακτήρα 
        String variable_names = options[1].substring(0, options[1].length() - 2);//ενώ εδώ ξεκίνα από την αρχή και τελείωσε για χαρακτήρες πλυν 2

        //Κόψε τα ερωτιματικά 
        String[] variable_values_array = variable_values.split(";");
        String[] variable_names_array = variable_names.split(";");

        //Δημιουργία του html σκελετού
        System.out.println("<html>\n <head>\n<title>Βάζω έναν τίτλό</title>\n</head>\n<body>\n" + ariki);
        System.out.println("<form name=\"f1\" method=\"get\" action=\"ActionT05.asp\">\n\n<table>");

        for (String i : variable_names_array) {//Φτιάξε μου έναν πίνακα με τις τιμές 
            System.out.println("<tr><td>" + i );
            for (String j : variable_values_array) {//Φτιάξε έναν πίνακα με τις επιλογές των τιμών
                System.out.println("<option value=\\\"class\"" + j + "</options>"+ "</td>");

            }

        }
        System.out.println("</table>\n\n<input type=submit value=\"προσδιορίστε\">\n</form>\n</body>\n</html>");

    }

}
