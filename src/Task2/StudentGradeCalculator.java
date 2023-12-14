package Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;

        do {
            try {      
                System.out.print("Enter the number of subjects: ");
                int numSubjects = scanner.nextInt();

                if (numSubjects <= 0) {
                    throw new IllegalArgumentException("Number of subjects must be greater than 0.");
                }

                int totalMarks = 0;
                	for (int i = 1; i <= numSubjects; i++) {
                    System.out.print("Enter marks for Subject " + i + ": ");

                    try {
                        int subjectMarks = scanner.nextInt();
                        if (subjectMarks < 0 || subjectMarks > 100) {
                            throw new IllegalArgumentException("Invalid marks. Marks must be between 0 and 100.");
                        }
                        totalMarks += subjectMarks;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for marks. Please enter a valid number.");
                        scanner.next(); 
                        i--; 
                    }
                }
                double averagePercentage = (double) totalMarks / numSubjects;

                
                String grade;
                if (averagePercentage >= 90) {
                    grade = "A++";
                } else if (averagePercentage >= 80) {
                    grade = "A";
                } else if (averagePercentage >= 70) {
                    grade = "B";
                } else if (averagePercentage >= 60) {
                    grade = "C";
                } else if (averagePercentage >= 50) {
                    grade = "D";
                }else if (averagePercentage >= 40) {
                    grade = "E";
                } else {
                    grade = "FAIL";
                }

                
                System.out.println("\nResults:");
                System.out.println("Total Marks: " + totalMarks);
                System.out.println("Average Percentage: " + averagePercentage);
                System.out.println("Grade: " + grade);

                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the number of subjects.");
                scanner.next(); // clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);

        scanner.close();
    }
}