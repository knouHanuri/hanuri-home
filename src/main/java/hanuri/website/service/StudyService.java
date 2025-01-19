package hanuri.website.service;

import hanuri.website.dao.StudyMapper;
import hanuri.website.dto.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyService {
    private final StudyMapper studyMapper;

    @Autowired
    public StudyService(StudyMapper studyMapper) {
        this.studyMapper = studyMapper;
    }

    /* 저장 */
    public void save(Study study){
        //중복 회원 확인
        //validateDuplicateMember(member);
        studyMapper.save(study);
        //return member.getSeq();
    }

    /* 수정 */
    public void update(Study study){
        studyMapper.update(study);
    }

//    private void validateDuplicateMember(Study member){
//        studyMapper.findById(member.getId())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }
//
    /* 전체 조회 */
    public List<Study> studyListAll() {
        return studyMapper.studyListAll();
    }
    /* 일정 수 조회 */
    public List<Study> studyListLimited(int limit) { return studyMapper.studyListLimited(limit); }
    /* studyId로 조회 */
    public Optional<Study> findById(long studyId) { return studyMapper.findById(studyId); }
    /* 삭제 */
    public int delete(long studyId) { return studyMapper.delete(studyId); }
}
