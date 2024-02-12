/*
 * Author: Leoro, Pamela Angel B.
 * Version@01/22/24
 * Fundamentals of Programming: Final Project
 * A program that computes and presents the student’s average grade, considering their grades across various subjects.
 */

 import java.util.Scanner;

 public class averageCalculator {
     public static void main(String[] args) {
         System.out.println("WELCOME!\n");

         // Scanner for integer input
         Scanner input1 = new Scanner(System.in);
         // Scanner for string input
         Scanner input2 = new Scanner(System.in);

         // Ask for full name
         System.out.print("Full name: ");
         String studentName = input2.nextLine(); // Store student's full name

         // Ask for age
         System.out.print("Age: ");
         int studentAge = 0;
         while (true) {
             // Check if the input is an integer
             while (!input1.hasNextInt()) {
                 System.out.println("Invalid input. Please enter an integer only.");
                 System.out.print("\nAge: ");
                 input1.nextLine();
             }
             studentAge = input1.nextInt();
             // Check if age is positive
             if (studentAge <= 0) {
                 System.out.println("Invalid input. Age must be a positive integer.");
                 System.out.print("\nAge: ");
                 input1.nextLine();
                 continue;
             }
             break;
         }
         // Ask for sex
         System.out.print("Sex (F/M): ");
         String studentSex;
         while (true) {
             studentSex = input2.nextLine();
             // Convert input to standard format
             switch (studentSex.toLowerCase()) {
                 case "f":
                 case "female":
                     studentSex = "Female";
                     break;
                 case "m":
                 case "male":
                     studentSex = "Male";
                     break;
                 default:
                     System.out.println("Invalid input. Please enter 'F' for female or 'M' for male.");
                     System.out.print("\nSex: ");
                     continue;
             }
             break;
         }
         // Ask for course and year
         System.out.print("Course and Year: ");
         String studentYear = input2.nextLine(); // Store student's course and year

         System.out.println();
         int numSub;
         do {
             // Ask for the number of subjects
             System.out.print("Enter the number of subjects you want to calculate the average (maximum of 8 subjects only).\nInput: ");
             // This loop will continue until the user enters a valid integer
             while (!input1.hasNextInt()) {
                 System.out.println("Invalid input. Please enter a valid integer.\n");
                 System.out.print("Input: ");
                 input1.next();
             }
             numSub = input1.nextInt(); // Read the integer input provided by the user

             // Check if the number of subjects entered is within the range of 1-8
             if (!(numSub > 0 && numSub <= 8)) {
                 System.out.println("Invalid range. Number of subjects should be 1-8 only.\n");
                 continue;
             }
             break;
         } while (!(numSub > 0 && numSub <= 8));

         // Arrays to store information about each subject
         String subject[] = new String[8];
         double grade[] = new double[8];
         double equiUnivGrade[] = new double[8];
         int units[] = new int[8];

         // Loop to get input grade scores, subjects, and equivalent university grades
         for (int i = 0; i < numSub; i++) {
             System.out.print("\nSubject " + (i + 1) + ": ");
             // Store the name of the subject in the array
             subject[i] = input2.nextLine();

             // Scanner for double input
             Scanner input3 = new Scanner(System.in);
             System.out.print("Grade Score: ");
             while(true){
                // Check if the input is an integer
                 while (!input3.hasNextInt()) {
                     input3.nextLine();
                     System.out.println("Invalid input. Please enter an integer only.");
                     System.out.print("\nGrade Score: ");
                 }
                 grade[i] = input3.nextDouble();

                 if(grade [i]>= 50 && grade[i] <= 100){
                     //Assigning an equivalent university grade based on the given score range and storing it to the array called equiUnivGrade
                     if (grade[i] >= 97.00 && grade[i] <= 100) {
                         equiUnivGrade[i] = 1.00;
                     } else if (grade[i] >= 94.00 && grade[i] <= 96.99) {
                         equiUnivGrade[i] = 1.25;
                     } else if (grade[i] >= 91.00 && grade[i] <= 93.99) {
                         equiUnivGrade[i] = 1.50;
                     } else if (grade[i] >= 88.00 && grade[i] <= 90.99) {
                         equiUnivGrade[i] = 1.75;
                     } else if (grade[i] >= 85.00 && grade[i] <= 87.99) {
                         equiUnivGrade[i] = 2.00;
                     } else if (grade[i] >= 82.00 && grade[i] <= 84.99) {
                         equiUnivGrade[i] = 2.25;
                     } else if (grade[i] >= 80.00 && grade[i] <= 81.99) {
                         equiUnivGrade[i] = 2.50;
                     } else if (grade[i] >= 78.00 && grade[i] <= 79.99) {
                         equiUnivGrade[i] = 2.75;
                     } else if (grade[i] >= 75.00 && grade[i] <= 77.99) {
                         equiUnivGrade[i] = 3.00;
                     } else if (grade[i] >= 72.00 && grade[i] <= 74.99) {
                         equiUnivGrade[i] = 3.25;
                     } else if (grade[i] >= 69.00 && grade[i] <= 71.99) {
                         equiUnivGrade[i] = 3.50;
                     } else if (grade[i] >= 66.00 && grade[i] <= 68.99) {
                         equiUnivGrade[i] = 3.75;
                     } else if (grade[i] >= 63.00 && grade[i] <= 65.99) {
                         equiUnivGrade[i] = 4.00;
                     } else if (grade[i] >= 50.00 && grade[i] <= 62.99) {
                         equiUnivGrade[i] = 5.00;
                     }
                     units[i] = 3; //setting units to 3 for each subject
                     break;
                 } else{
                     System.out.println("The grade score must range from 50 to 100 only. Enter again.\n");
                     System.out.print("Grade Score: ");
                     input3.nextLine();
                     continue;
                 }
             }
         }
         // Calculate the average of the university equivalent grades
         double sum = 0;
         int totalUnits = 0;
         for (int i = 0; i < numSub; i++) {
             sum += equiUnivGrade[i] * units[i];
             totalUnits += units[i];
         }
         double average = sum / totalUnits;

         // Check how many subjects the student scored above the average
         int aboveAverageSub = 0;
         for (int i = 0; i < numSub; i++) {
             // Check if the grade is above the average
             if (equiUnivGrade[i] < average) {
                 aboveAverageSub++;
             }
         }
         // Print the outputs in a table
         // Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
         // Print the header
         System.out.println("|\t\t\t   STUDENT INFORMATION\t\t\t       |");
         // Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
         // Display the student's information
         System.out.println(" Name: " + studentName);
         System.out.println(" Age: " + studentAge);
         System.out.println(" Sex: " + studentSex);
         System.out.println(" Year: " + studentYear);
         // Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
         // Print header for the subject, grade score, and equivalent university grade
         System.out.printf("| %-20s | %-20s | %-22s |\n", "Subject", "Grade Score", "Equivalent Univ. Grade");
         // Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
         //Print the suject's name with its corresponding grade score and equivalent university grade
         for (int i = 0; i < numSub; i++) {
             System.out.printf("| %-20s | %-20.2f | %-22.2f |\n", subject[i], grade[i], equiUnivGrade[i]);
         }
         //Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
         // Print average with 2 decimal points
         System.out.printf("| Average: %.2f", average);
         //Conditional statement to determine the remarks of the average
             if (average >= 1.00 && average <= 3.0) {
                 System.out.println(" (PASSED)\t\t\t\t\t       |");
             } else if (average >= 3.25 && average <= 4.00) {
                 System.out.println(" (CONDITIONAL)\t\t\t\t\t       |");
             } else if (average >= 5.00) {
                 System.out.println(" (FAILED)\t\t\t\t\t       |");
             }
         //Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         //Print the subjects in which the student scored above the average
         System.out.println();
         System.out.println("| Subjects in which the student scored above the average: " + aboveAverageSub + "\t       |");
         //Print a border
         for (int i = 1; i <= 72; i++) {
             System.out.print("-");
         }
         System.out.println();
     }
 }
