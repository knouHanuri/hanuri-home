package hanuri.website.dto.history;

import lombok.AllArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
public class FindAllByStudyIdResponse {
    private String studyTitle;
    private int week;
    private Date studyDate;
    private String studyHistoryTitle;
}
