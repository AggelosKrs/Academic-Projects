public class array_list {

    public static void main(String[] args) {

        /* Είναι μια for each η οποία μας εμφανίζει τα σοιχεία του πίνακα */
        String[] brakia = { "slipaki", "strigkaki", "tagka", "mpokseraki" };
        for (String i : brakia) {
            System.out.println(i);
        }


        /* Δεν μπορεί να τρέχει γιατί τα ορίσματα του πίνακα είναι χαρακτίρες και η μεταβλητή int */
        for (int a; a < brakia.length; a++){
            System.out.println(a);
        }//Άρα ο μόνος τρόπος για να μπορέσουμε να εμφανίσουμε τον πίνακα με όνοματα είναι η foreach

        String[][] onomata = { { "Aggelos", "Kostas" }, { "Maria", "Popi" } };
        System.out.println(brakia);// Βλέπουμε ότι δεν μπορούμε να καλέσουμε τον πίνακα όπως σε άλλεσ γλωσεσ με []

    }
}
