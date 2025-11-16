public class methods {
    /* Οι μέθοδοι δημιουργούντε με τον ίδιος τρόπο όπως οι functions
     * όμως μπορούμε να δημιουργήσουμε και αντικήμενα μέσα από αυτές  
     */

    static void myName(String name){
        System.out.println("My name is: " + name);
    }

    static void myLast(){
        System.out.println("Karras");
    }
    public static void main (String[] args){
        methods person = new methods();
        person.myName("Aggrlos");
        person.myLast();
    }
    
}
