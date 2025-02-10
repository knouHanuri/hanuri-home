package hanuri.website.dto;

import hanuri.website.domain.EStudyStatus;
import hanuri.website.dto.image.EImageType;
import hanuri.website.dto.image.ImageDTO;
import hanuri.website.model.ImageSource;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Study implements ImageSource {
    private Long studyId;
    private Long subjectCode;
    private String title;
    private EStudyStatus status;
    private String schedule;
    private String goal;
    private Date startDate;
    private Date endDate;
    private Long establishedBy;
    private ImageDTO imageDTO;

    @Override
    public Long getObjectId() {
        return studyId;
    }

    @Override
    public EImageType getImageType() {
        return EImageType.study;
    }
}
