import java.util.Scanner;

// O will represent the empty seat
// X will represent the taken seat

public class MovieTheater {

    // Creating 2D array for movie theater sitting
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static char[][] seats = new char[ROWS][COLS];

    public static void main(String[] args) {
        initializeSeats();

        // Create menu/switch case for viewing, reserving, returning seats
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n Movie Theater Reservation System");
            System.out.println("1. View seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewSeatingChart();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelSeat(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }


    // Initialize the seats, all are empty
    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = 'O';
            }
        }
    }

    // View the current seating chart
    private static void viewSeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }


    // Reserve a seat if available
    private static void reserveSeat(Scanner scanner) {
        System.out.println("Enter the row (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter the column (1-" + COLS + "): ");
        int col = scanner.nextInt() - 1;

        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            if (seats[row][col] == 'O') {
                seats[row][col] = 'X';
                System.out.println("Seat reserved successfully!");
            } else {
                System.out.println("Sorry, this seat is already taken.");
                suggestAvailableSeat();
            }
        } else {
            System.out.println("Invalid seat position. Please try again.");
        }
    }

    // Suggest an available seat if the requested one is taken
    private static void suggestAvailableSeat() {
        System.out.println("Available seats are:");
        boolean found = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (seats[i][j] == 'O') {
                    System.out.println("Seat at Row " + (i + 1) + ", Column " + (j + 1));
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Sorry, no seats are available.");
        }
    }

    // Cancel a reservation
    private static void cancelSeat(Scanner scanner) {
        System.out.println("Enter the row (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter the column (1-" + COLS + "): ");
        int col = scanner.nextInt() - 1;

        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            if (seats[row][col] == 'X') {
                seats[row][col] = 'O';
                System.out.println("Reservation canceled successfully.");
            } else {
                System.out.println("This seat is not reserved. Please verify that it is the right seat. ");
            }
        } else {
            System.out.println("Invalid seat position. Please try again.");
        }
    }
}
