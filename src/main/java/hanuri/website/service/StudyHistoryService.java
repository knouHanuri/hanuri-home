package hanuri.website.service;

import hanuri.website.dto.history.RegisterStudyHistoryRequest;

public interface StudyHistoryService {
    int register(RegisterStudyHistoryRequest requestDTO);
    int findLastRoundByStudyId(int studyId);
    int countRoundByStudyId(int studyId);
}