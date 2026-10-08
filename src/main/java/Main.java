/** Runs the program. */
public final class Main {

  private static final double FIRST_GRADE = 95.0;
  private static final double SECOND_GRADE = 72.5;
  private static final double OUT_OF_RANGE_GRADE = 150.0;

  private Main() {
  }

  /** Main method. */
  public static void main(final String[] args) {
    Student student = new Student("S001", "Ana");
    tryAddGrade(student, FIRST_GRADE);
    tryAddGrade(student, SECOND_GRADE);
    tryAddGrade(student, OUT_OF_RANGE_GRADE);
    student.reportCard();

    tryCreateStudent("", "Luis");
    tryCreateStudent("S002", " ");
  }

  private static void tryAddGrade(final Student student, final double grade) {
    try {
      student.addGrade(grade);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void tryCreateStudent(final String id, final String name) {
    try {
      new Student(id, name);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
