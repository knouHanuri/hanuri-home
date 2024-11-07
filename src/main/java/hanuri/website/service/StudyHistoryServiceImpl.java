package hanuri.website.service;

import hanuri.website.dao.StudyHistoryMapper;
import hanuri.website.dto.history.FindAllByStudyIdResponse;
import hanuri.website.model.StudyHistory;
import hanuri.website.dto.history.RegisterStudyHistoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudyHistoryServiceImpl implements StudyHistoryService{

    private final StudyHistoryMapper studyHistoryMapper;

    public StudyHistoryServiceImpl(StudyHistoryMapper studyHistoryMapper) {
        this.studyHistoryMapper = studyHistoryMapper;
    }

    /* 추가로 필요한 처리로직 :
       3회차 스터디내역을 입력시 2회차의 날짜보다 빠른 날로 입력하려한다면 어떻게 할까?
       3회차를 2회차로 변경 + 2회차를 3회차로 변경하는 작업이 필요할 듯.
     */
    @Override
    @Transactional
    public int register(RegisterStudyHistoryRequest requestDTO) {
        // 회차를 카운트하고 +1 해준다.
        int newRoundNo = (countRoundByStudyId(requestDTO.getStudyId()) + 1);

        return studyHistoryMapper.save(StudyHistory.register()
                                                    .studyId(requestDTO.getStudyId())
                                                    .round(newRoundNo)
                                                    .title(requestDTO.getTitle())
                                                    .presenter(requestDTO.getPresenter())
                                                    .studyDate(requestDTO.getStudyDate())
                                                    .notes(requestDTO.getNotes())
                                                    .build());
    }

    /**
     * deprecated
     */
    @Override
    public int findLastRoundByStudyId(int studyId) {
        return studyHistoryMapper.findLastRoundByStudyId(studyId);
    }

    @Override
    public int countRoundByStudyId(int studyId) {
        return studyHistoryMapper.countRoundByStudyId(studyId);
    }

    @Override
    public List<FindAllByStudyIdResponse> findAllByStudyId(int studyId) {
        List<FindAllByStudyIdResponse> responseDTO = studyHistoryMapper.findAllByStudyId(studyId);
        return responseDTO;
    }
}