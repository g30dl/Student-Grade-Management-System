import java.util.ArrayList;

/** A student with grades. */
public final class Student {

  private static double HONOR_ROLL = 90.0;
  private static double APPROVED = 60.0;

  private String id;
  private String name;
  private ArrayList<Double> grades;

  /** Creates a student. */
  public Student(String studentId,String studentName) {

    if (studentId == null || studentId.isBlank()) {
      throw new IllegalArgumentException("Student ID must not be empty.");
    }

    if (studentName == null || studentName.isBlank()) {
      throw new IllegalArgumentException("Student name must not be empty.");
    }

    this.id = studentId;
    this.name = studentName;
    this.grades = new ArrayList<>();
  }

  /** Adds a grade. */
  public void addGrade(double grade) {
    
    if (Double.isNaN(grade) || grade < 0.0 || grade > 100) {
      throw new IllegalArgumentException(
          "Grade " + grade + " is out of range (0-100).");
    }
    grades.add(grade);
  }

  /** Returns the average. */
  public double average() {
    if (grades.isEmpty()) {
      return 0;
    }

    double total = 0;
    for (double grade : grades) {
      total += grade;
    }
    return total / grades.size();
  }

  /** Returns the letter grade. */
  public char letterGrade() {
    double average = average();
    
    if (average >= 90.0) {
      return 'A';
    }
    if (average >= 80.0) {
      return 'B';
    }
    if (average >= 70.0) {
      return 'C';
    }
    if (average >= 60.0) {
      return 'D';
    }
    return 'F';
  }

  /** Returns Passed or Failed. */
  public String passStatus() {
    if (average() >= APPROVED) {
      return "Passed";
    }
    return "Failed";
  }

  /** Returns true if on the honor roll. */
  public boolean isHonorRoll() {
    return average() >= HONOR_ROLL;
  }

  /** Prints the report card. */
  public void reportCard() {
    System.out.println("Student: " + name);
    System.out.println("ID: " + id);
    System.out.println("Grades: " + grades);
    System.out.println("Average: " + average());
    System.out.println("Letter Grade: " + letterGrade());
    System.out.println("Status: " + passStatus());
    System.out.println("Honor Roll: " + isHonorRoll());
  }
}
