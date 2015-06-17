package ui.kpi.pti.task4.data;

public class StudentCourse {

    private Long studentId;
    private Long courseId;

    private Score score;
    private String feedback;

    private Student student;

    public StudentCourse() {
    }

    public StudentCourse(Long studentId, Long courseId, Score score, String feedback) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
        this.feedback = feedback;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
