package hanuri.website.dao;

import hanuri.website.dto.Study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//import java.util.Optional;

@Mapper
public interface StudyMapper {
    void save(Study study);
//    Optional<Member> findBySeq(Long seq);
//    Optional<Member> findById(String id);
    List<Study> studyListAll();
    int delete(long studyId);
}
