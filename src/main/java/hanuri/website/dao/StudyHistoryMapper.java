package hanuri.website.dao;

import hanuri.website.dto.history.FindAllByStudyIdResponse;
import hanuri.website.model.StudyHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyHistoryMapper {

    int save(StudyHistory studyHistory);

    // 마지막 회차를 찾기위한 쿼리
    int findLastRoundByStudyId(int studyId);

    // 해당 스터디가 진행된 횟수를 확인하는 쿼리
    int countRoundByStudyId(int studyId);

    List<FindAllByStudyIdResponse> findAllByStudyId(int studyId);

}