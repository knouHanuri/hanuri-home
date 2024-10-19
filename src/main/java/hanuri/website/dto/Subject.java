package hanuri.website.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {
    private int subjectCode;    // 과목 코드
    private String subjectName; // 과목명
    private byte grade;         // 학년
    private byte semester;      // 학기
    private String professor;   // 담당 교수명
    private boolean studyOpened; // 과목 개설 여부
}
