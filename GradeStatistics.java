import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int NUMBER_OF_GRADES = 10;

        double grade;
        double total = 0;
        double maximum = 0;
        double minimum = 0;
        double average;

        System.out.println("Grade Statistics Program");
        System.out.println("------------------------");

        for (int gradeNumber = 1; gradeNumber <= NUMBER_OF_GRADES; gradeNumber++) {

            System.out.print("Enter grade " + gradeNumber + ": ");
            grade = input.nextDouble();

            total = total + grade;

            if (gradeNumber == 1) {
                maximum = grade;
                minimum = grade;
            } else {
                if (grade > maximum) {
                    maximum = grade;
                }

                if (grade < minimum) {
                    minimum = grade;
                }
            }
        }

        average = total / NUMBER_OF_GRADES;

        System.out.println();
        System.out.println("Grade Statistics");
        System.out.println("----------------");
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Maximum: %.2f%n", maximum);
        System.out.printf("Minimum: %.2f%n", minimum);

        input.close();
    }
}