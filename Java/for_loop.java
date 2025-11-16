public class for_loop {
    public static void main(String[] args) {
        /* Δεν χρειάζεται να κάνουμε αρχικοποίηση της μεταβλιτής μέσα στη for */
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "\n");
        }

        /* Ο τελεστή += δουλεύει όπως στην php */
        for (int j = 0; j <= 10; j += 2) {
            System.out.println(j + "\n");
        }

        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        for (String i : cars) {
            System.out.println(i);
        }
    }

}
