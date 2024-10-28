package hanuri.website.dao;

import hanuri.website.model.StudyHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyHistoryMapper {

    int save(StudyHistory studyHistory);

    // 마지막 회차를 찾기위한 쿼리
    int findLastRoundByStudyId(int studyId);

    // 해당 스터디가 진행된 횟수를 확인하는 쿼리
    int countRoundByStudyId(int studyId);
}