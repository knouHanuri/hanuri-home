package hanuri.website.dao;

import hanuri.website.dto.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SubjectMapper {

    // 과목 저장
    void save(Subject subject);

    // 특정 과목을 코드로 조회
    Optional<Subject> findByCode(Long subjectCode);

    // 전체 과목 조회
    List<Subject> findAll();
}
