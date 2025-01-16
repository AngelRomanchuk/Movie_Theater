import java.util.Scanner;

// O will represent the empty seat
// X will represent the taken seat

public class MovieTheater {

//    Creating 2D array for movie theater sitting
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static char[][] seats = new char[ROWS][COLS];

    public static void main(String[] args) {
        initializeSeats();

//        Create menu/switch case for viewing, reserving, returning seats
        Scanner scanner = new Scanner(System.in);
        int option;


    }

    // Initialize the seats, all are empty
    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = 'O';
            }
        }
    }


}
