public class arrays {
    public static void main(String[] args) {
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        System.out.println(cars[0]);// Με το μηδέν δηλώνουμε την πρώτη μεταβλιτή του πίνακα
        System.out.println(cars.length);// Μέγεθος του πίνακα

        /*Πρώτα μετράμε το μέγεθος του πίνακα και μετά εμφανίζουμε τα στοιχεία */
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        for(String j : cars){/* Θα πρέπει η μεταβλιτή να είναι ίδιο τύπο με τα στοιχεία του πίνακα  */
            System.out.println(j);
        }
    }

}
