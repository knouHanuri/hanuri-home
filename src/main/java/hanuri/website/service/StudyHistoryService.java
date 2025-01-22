package hanuri.website.service;

import hanuri.website.dto.history.RegisterStudyHistoryRequest;
import hanuri.website.dto.history.FindAllByStudyIdResponse;
import hanuri.website.dto.history.UpdateStudyHistoryRequest;
import hanuri.website.dto.history.UpdateStudyHistoryResponse;

import java.util.List;

public interface StudyHistoryService {
    int register(RegisterStudyHistoryRequest requestDTO);
    int findLastRoundByStudyId(int studyId);
    int countRoundByStudyId(int studyId);
    List<FindAllByStudyIdResponse> findAllByStudyId(int studyId);
    UpdateStudyHistoryResponse update(UpdateStudyHistoryRequest requestDTO);
}