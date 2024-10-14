import java.util.Scanner;
import java.util.regex.Pattern;
 
public class TechOne {
    public static void main(String[] args) {
Scanner numscan = new Scanner(System.in);
        int option;
 
        do {
            
            System.out.println("ALL-IN-ONE SYSTEM");
            System.out.println("[1] Add Record");
            System.out.println("[2] Grade Calculator");
            System.out.println("[0] Exit");
            System.out.print("Option: ");
            while (!numscan.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                numscan.next();
            }
            option = numscan.nextInt();
            
            numscan.nextLine(); 
 
            switch (option) {
                case 1:
                    Records(numscan);
                    break;
                case 2:
                    Calculator(numscan);
                    break;
                case 3:
                    System.out.println("Exiting the Program");
                    break;
                default:
                    System.out.println("Invalid Input Please choose from [1][2][3].");
            }
        } while (option != 0);
 
        
    }
 
    
    public static void Records(Scanner records) {
        System.out.println("STUDENT PROFILE");
 
        String StudentID = ValidateStudentNum(records, "Student ID: ");
        String StudentName = ValidateString(records, "Name: ");
        String StudentCourse = ValidateString(records, "Course: ");
        String StudentYearLevel = ValidateYear(records, "Year Level: ");
        String StudentContactNo = ValidateContact(records, "Contact No.: ");
        String StudentEmail = ValidateString(records, "Email: ");
 
        System.out.println("Record Added Successfully!");
        System.out.println("Student ID: " + StudentID + ", Name: " + StudentName + ", Course: " + StudentCourse +
                ", Year Level: " + StudentYearLevel + ", Contact No.: " + StudentContactNo + ", Email: " + StudentEmail);
    }
 
 
    public static void Calculator(Scanner scanner) {
        System.out.println("MIDTERM GRADE CALCULATOR");
 
        
        System.out.println("CS0070 LECTURE (70%)");
        double LECClassStanding = CalculateClassStanding(scanner);
        double LecMidtermExam = ValidationInput(scanner, "Midterm Exam (40%)");
 
        double lectureMidtermGrade = (LECClassStanding * 0.60) + (LecMidtermExam * 0.40);
        System.out.printf("CS0070 MIDTERMS Grade: %.2f\n", lectureMidtermGrade);
 
       
        System.out.println("CS0070L LABORATORY (30%)");
        double LabClassStanding = CalculateClassStanding(scanner);
        double LabMidtermExam = ValidationInput(scanner, "Midterm Practical Exam (40%)");
 
        double labMidtermGrade = (LabClassStanding * 0.60) + (LabMidtermExam * 0.40);
        System.out.printf("CS0070L MIDTERMS Grade: %.2f\n", labMidtermGrade);
 
   
        double CombinedMidtermGrade = (lectureMidtermGrade * 0.70) + (labMidtermGrade * 0.30);
        System.out.printf("Combined Midterm Grade: %.2f\n", CombinedMidtermGrade);
 
       
        String remark = CombinedMidtermGrade >= 70 ? "PASSED" : "FAILED";
        double equivalentGrade = GradesConverter(CombinedMidtermGrade);
        System.out.println("Remark: " + remark);
        System.out.printf("Equivalent Grade: %.1f\n", equivalentGrade);
    }
 
    
    private static double CalculateClassStanding(Scanner scanner) {
        System.out.println("Class Standing (60%)");
 
        
        System.out.println("Long Quizzes (50%)");
        double longq1 = ValidationInput(scanner, "Long Quiz 1");
        
        double longq2 = ValidationInput(scanner, "Long Quiz 2");
        
        double longq3 = ValidationInput(scanner, "Long Quiz 3");
        
        double avgLongQuizzes = (longq1 + longq2 + longq3) / 3;
        
        System.out.printf("Average Long Quizzes: %.2f\n", avgLongQuizzes);
 
      
        System.out.println("Short Quizzes (20%)");
        double shortq1 = ValidationInput(scanner, "Short Quiz 1");
        
        double shortq2 = ValidationInput(scanner, "Short Quiz 2");
        
        double shortq3 = ValidationInput(scanner, "Short Quiz 3");
        
        double avgShortQuizzes = (shortq1 + shortq2 + shortq3) / 3;
        
        System.out.printf("Average Short Quizzes: %.2f\n", avgShortQuizzes);
 
        
        System.out.println("SAR (20%)");
        double seatwork = ValidationInput(scanner, "Seatwork");
        
        double assignment = ValidationInput(scanner, "Assignment");
        
        double recitation = ValidationInput(scanner, "Recitation");
        
        double avgSAR = (seatwork + assignment + recitation) / 3;
        
        System.out.printf("Average SAR: %.2f\n", avgSAR);
 
        
        double TeacherEvaluation = ValidationInput(scanner, "Teacher Evaluation (10%)");
 
        double TotalClassStanding = (avgLongQuizzes * 0.50) + (avgShortQuizzes * 0.20) + (avgSAR * 0.20) + (TeacherEvaluation * 0.10);
        
        System.out.printf("Total Class Standing: %.2f\n", TotalClassStanding);
        
 
        return TotalClassStanding;
    }
 
    private static double GradesConverter(double grade) {
        if (grade >= 95.8) return 4.0;
        else if (grade >= 91.5) return 3.5;
        else if (grade >= 87.5) return 3.0;
        else if (grade >= 82.9) return 2.5;
        else if (grade >= 78.6) return 2.0;
        else if (grade >= 74.3) return 1.5;
        else if (grade >= 70.0) return 1.0;
        else return 0.5;
    }
    
    private static double ValidationInput(Scanner InputString, String prompt) {
        double value;
        do {
            System.out.print(prompt + ": ");
            while (!InputString.hasNextDouble()) {
                System.out.println("Invalid input Please enter a number ranging between 0 and 100");
                InputString.next();
            }
            value = InputString.nextDouble();
            if (value < 0 || value > 100) {
                System.out.println("Invalid input Please enter a number ranging between 0 and 100");
            }
        } while (value < 0 || value > 100);
        return value;
    }
 
    private static String ValidateStudentNum(Scanner StudentNum, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = StudentNum.nextLine();
            if (!input.matches("\\d{9}")) { 
                System.out.println("Invalid Student Number, Please enter a 9 digit number");
            }
        } while (!input.matches("\\d{9}"));
        return input;
    }
    
     
    private static String ValidateYear(Scanner YearLevel, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = YearLevel.nextLine();
            if (!input.matches("\\d{1}")) { 
                System.out.println("Invalid Year level, Please enter a 1-4");
            }
        } while (!input.matches("\\d{1}"));
        return input;
    }
    
   private static String ValidateString(Scanner String, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = String.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Invalid input! Please enter a valid value");
            }
        } while (input.trim().isEmpty());
        return input;
      }
   
   private static String ValidateContact(Scanner contact, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = contact.nextLine();
            if (!input.matches("\\d{10,11}")) { 
                System.out.println("Invalid input! Please enter a numbers from ranging 10-11");
            }
        } while (!input.matches("\\d{10,11}"));
        return input;
    }
    
    }
