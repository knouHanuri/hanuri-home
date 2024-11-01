package hanuri.website.dto.history;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public class RegisterStudyHistoryRequest {
    @Min(value = 1, message = "스터디 ID가 0 또는 음수입니다.")
    private int studyId;
    @PastOrPresent(message = "스터디 진행내역 날짜는 오늘 혹은 이전날짜가 필요합니다.")
    private LocalDate studyDate;
    @NotBlank(message = "제목이 누락되었습니다.")
    private String title;
    private String presenter;
    private String notes;
}