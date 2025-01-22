package hanuri.website.model;


import lombok.*;
import org.springframework.util.Assert;

import java.time.LocalDate;

@ToString
@Getter
public class StudyHistory {

    private int studyId;
    private int round;
    private String title;
    private String presenter;
    private LocalDate studyDate;
    private String notes;
    @Builder(builderMethodName = "register", builderClassName = "StudyHistoryBuilder")
    public StudyHistory(int studyId, int round, String title, String presenter, LocalDate studyDate, String notes) {
        Assert.isTrue(round > 0, "회차는 최소 1부터 입력됩니다.");
        Assert.hasText(presenter, "발표자 정보가 없습니다.");
        Assert.notNull(studyDate, "날짜 정보가 필요합니다.");

        this.studyId = studyId;
        this.round = round;
        this.title = title;
        this.presenter = presenter;
        this.studyDate = studyDate;
        this.notes = notes;
    }
}