package hanuri.website.dto;

import hanuri.website.domain.EStudyStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Study {
    private Long studyId;
    private Long subjectCode;
    private String title;
    private EStudyStatus status;
    private String schedule;
    private Date startDate;
    private Date endDate;
    private Long establishedBy;
}
