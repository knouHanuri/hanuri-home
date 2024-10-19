package hanuri.website.service;

import hanuri.website.dao.StudyMapper;
import hanuri.website.dto.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyService {
    private final StudyMapper studyMapper;

    @Autowired
    public StudyService(StudyMapper studyMapper) {
        this.studyMapper = studyMapper;
    }

    /*
    * 저장
    * */
    public void save(Study study){
        //중복 회원 확인
        //validateDuplicateMember(member);
        studyMapper.save(study);
        //return member.getSeq();
    }

//    private void validateDuplicateMember(Study member){
//        studyMapper.findById(member.getId())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }
//
//    /*
//     * 전체 조회
//     * */
//    public List<Member> findMembers() {
//        return memberMapper.findAll();
//    }
}
