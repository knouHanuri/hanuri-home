package hanuri.website.service;

import hanuri.website.dto.history.StudyHistoryRegisterRequestDTO;

public interface StudyHistoryService {
    int register(StudyHistoryRegisterRequestDTO requestDTO);
    int findLastRoundByStudyId(int studyId);
    int countRoundByStudyId(int studyId);
}