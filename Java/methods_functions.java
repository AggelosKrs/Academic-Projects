
/* Στους μεθόδους μπορούμε να δηλώσουμε ορίσματα μέσα */
public class methods_functions {
    static void sum(String y, int x){
        System.out.println(y + (20 + x));
    }

    /* Μπορούμε να δημιουργήσουμε κλάσεις ανάλογα και να δέχονται συγκεκριμένο τύπο */

    static int intNumber(int c, int d){
        return c + d;
    }

    static double doubleNumber(double e, double f){
        return e + f;
    }

    static char Character(char g, char h){
        return g;
    }


    public static void main (String[] args){
        /* Μπορούμε να καλέσουμε όσες φορές θέλουμε την κάθε μέθοδο */
        sum("Tο άθρισμα είναι: ",10);
        sum("Tο άθρισμα είναι: ",20);
    }

}
