package hanuri.website.controller;

public class SubjectForm {
    private String subjectName;  // 과목명
    private String grade;        // 학년
    private String semester;     // 학기
    private String professor;    // 교수명
    private String studyOpened;  // 강의 개설 여부

    // Getter 및 Setter 메서드
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getStudyOpened() {
        return studyOpened;
    }

    public void setStudyOpened(String studyOpened) {
        this.studyOpened = studyOpened;
    }
}
