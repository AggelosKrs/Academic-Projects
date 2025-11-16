public class Main{
    public static void main(String[] args){
        /* 
        Η δήλωση των μεταβλιτών θα πρέπει να δηλώνετε με τον τύπο 
        και το όνομα της μεταβλιτής 
         */
        int number = 50; /* Αναφερόμαστε για ακέραιο  */
        float dekadikos = 50.34f;/* στα φλοατ χρειάζετε και τον τελεστή f */
        char gramma = 'C';/* Αναφερόμαστε μόνο για έναν χαρακτήρα και δηώνετε με μονά αφτάκια */
        boolean true_f = true; /* Αληθές ψευδές */
        String x = "World"; /* Αναγνωρίζει και καινό μεταξύ χαρακτήρων */
        byte test = 100;/* Μέχρι τρία μπιτ */
        System.out.println("Hello\n" + x);
        System.out.println(3 * 5);
        System.out.print(gramma + x +"\n");
        System.out.print(gramma + number);
        System.out.println(number + dekadikos);
         /*
        1. Ο τελεστής της νέας γραμμής δουλεύει κανονικά όπως στην C
        2. Μπορούμε να προσθέσουμε string μέσα στο println
        3. Μπορούμε να κάνουμε αριθιτικές πράξεις
        4. Μπορούν να πραγματοποιηθούν πράξεις sting + char ;αλλά και πράξεις με άλλους τ
            τύπους αρχείων
        5. Μπορούμε να κάνουε αριθμιτικές πράξεις κανονικά
        */
    }
}