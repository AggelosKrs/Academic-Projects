/*Το όνομα της κλάσεις πρέπει να είναι ιδιο 
 * όνομα με το εκτελέσιμο αρχείο 
 */
public class example{
    public static void main (String[] args){
        String name = "Aggelos";
        String lastname = "Karras";
        int age = 27;
        float heigh = 1.73f;

        System.out.println("Name    " + name);
        System.out.println("Lastname " + lastname);
        System.out.println("Age " + age);
        System.out.println("Heigh " + (int) heigh);
        /* Παρατηρούμε ότι καταλαβένει το πλύθος των καινών 
         * όταν δηλώνουμε Int πριν από μία float μεταβλιτή την μετατρέπει σε ακέραια
        */
    }

}