
import java.util.Scanner;

public class GradeStatistics {

    // Number of grades required for each calculation
    private static final int NUMBER_OF_GRADES = 10;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String continueChoice;

        System.out.println("===== GRADE STATISTICS PROGRAM =====");

        do {

            // Create an array to store ten grades
            double[] grades = new double[NUMBER_OF_GRADES];

            // Collect and validate the grades
            getGrades(input, grades);

            // Calculate the grade statistics
            double average = calculateAverage(grades);
            double maximum = calculateMaximum(grades);
            double minimum = calculateMinimum(grades);

            // Display the calculated results
            displayResults(average, maximum, minimum);

            // Ask whether the user wants another calculation
            System.out.print("\nCalculate another set of grades? (yes/no): ");
            continueChoice = input.nextLine().trim();

        } while (continueChoice.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for using the Grade Statistics Program.");

        input.close();
    }

    // Method to collect and validate ten grades
    public static void getGrades(Scanner input, double[] grades) {

        for (int i = 0; i < grades.length; i++) {

            while (true) {

                System.out.print("Enter grade " + (i + 1) + ": ");
                String entry = input.nextLine().trim();

                try {
                    double grade = Double.parseDouble(entry);

                    if (!Double.isFinite(grade)) {
                        System.out.println(
                            "Invalid entry. Please enter a number.");
                    } else if (grade < 0 || grade > 100) {
                        System.out.println(
                            "The grade value must be between 0 and 100. Please try again.");
                    } else {
                        grades[i] = grade;
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Invalid entry. Please enter a grade.");
                }
            }
        }
    }

    // Method to calculate the average grade
    public static double calculateAverage(double[] grades) {

        double total = 0;

        for (double grade : grades) {
            total += grade;
        }

        return total / grades.length;
    }

    // Method to calculate the highest grade
    public static double calculateMaximum(double[] grades) {

        double maximum = grades[0];

        for (double grade : grades) {
            if (grade > maximum) {
                maximum = grade;
            }
        }

        return maximum;
    }

    // Method to calculate the lowest grade
    public static double calculateMinimum(double[] grades) {

        double minimum = grades[0];

        for (double grade : grades) {
            if (grade < minimum) {
                minimum = grade;
            }
        }

        return minimum;
    }

    // Method to display the grade statistics
    public static void displayResults(
            double average, double maximum, double minimum) {

        System.out.println("\n===== GRADE STATISTICS RESULTS =====");
        System.out.println("Number of Grades: " + NUMBER_OF_GRADES);
        System.out.printf("Average Grade:    %.2f%n", average);
        System.out.printf("Maximum Grade:    %.2f%n", maximum);
        System.out.printf("Minimum Grade:    %.2f%n", minimum);
        System.out.println("====================================");
    }
}