public class if_while_statement {
    public static void main(String[] args) {
        int x = 16;
        int x1 = 19;
        float y1 = 15.00f;
        float y = 15.00f;
        char z = 'A';
        String h = "Μωράκι";

        if (x1 > x) {
            System.out.println("Είσαι καραγιόζης");
        }
        /* Στην συνθήκη if πρέπει να ελέγχουμε μόνο ίδιες μεταβλιτές */

        if (z == z)

        {
            System.out.println("Είσαι μεγάλος μάγκας");
        }
        /* Μπορούμε να δούμε εαν δυο χαρακτίρες είναι ιδιοι. */

        if ( y > y1){
            System.out.println("Το y1 μεγαλήτερο του y");
        }else{
            System.out.println("Το y μεγαλήτερο από το y1 κατά: " + (y1 - y));
        }

        if ( y > y1){
            System.out.println("Το y1 μεγαλήτερο του y");
        }else if (y < y1){
            System.out.println("Το y μεγαλήτερο από το y1 κατά: " + (y1 - y));
        }else{
            System.out.println("Τα y,y1 είναι ίσα");
        }

        while(x < 20){/* Θέλουμε και έναν μετριτή για να μπορεί η loop να τερματίζει */
            System.out.println("Ο αρθμός είναι ο: "+ x );
            x++;
            /* υπάρχει και το x--; το οποίο μειώνει τον αριθμό */
        }
    }

}
