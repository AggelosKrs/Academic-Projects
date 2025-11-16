public class objects {
    /* Γράφοντας εδώ μπορούμε να δημιουργήσουμε αντικήμενα */
    int x = 15;

    String fname = "Aggelos";
    String flast = "Karras";


    public static void main(String[] args) {
        objects obj1 = new objects();//Προσοχή η παρένθεση
        System.out.println(obj1.x);//Πρέπει να προσδιορίσζουμε το αντικήμενο 
        objects obj2 = new objects();
        obj2.x = 25;//Μπορούμε να αλλάξουμε τη τιμή του αντικειμένου
        System.out.println(obj2.x);

        System.out.println("First name: " + obj1.fname + "\n" + "Last name: " + obj1.flast);
    }

    
}
