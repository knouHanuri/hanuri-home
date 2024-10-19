package hanuri.website.dto;

public class Subject {
    private int subjectCode;    // 과목 코드
    private String subjectName; // 과목명
    private byte grade;         // 학년
    private byte semester;      // 학기
    private String professor;   // 담당 교수명
    private boolean studyOpened; // 과목 개설 여부


    // getter와 setter
    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    public byte getSemester() {
        return semester;
    }

    public void setSemester(byte semester) {
        this.semester = semester;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public boolean isStudyOpened() {
        return studyOpened;
    }

    public void setStudyOpened(boolean studyOpened) {
        this.studyOpened = studyOpened;
    }
}
