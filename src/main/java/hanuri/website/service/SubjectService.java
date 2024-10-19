package hanuri.website.service;

import hanuri.website.dao.SubjectMapper;
import hanuri.website.dto.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectMapper subjectMapper;

    @Autowired
    public SubjectService(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    /*
     * 과목 저장
     */
    public void save(Subject subject) {
        // 중복 과목 확인 (예: 과목명이 중복되는지 확인할 수 있음)
        validateDuplicateSubject(subject);
        subjectMapper.save(subject);
    }

    /*
     * 중복 과목 검증
     */
    private void validateDuplicateSubject(Subject subject) {
        subjectMapper.findByCode((long) subject.getSubjectCode())
                .ifPresent(s -> {
                    throw new IllegalStateException("이미 존재하는 과목입니다.");
                });
    }

    /*
     * 전체 과목 조회
     */
    public List<Subject> findSubjects() {
        return subjectMapper.findAll();
    }

    /*
     * 특정 과목 조회 (subject_code 기준)
     */
    public Subject findByCode(Long subjectCode) {
        return subjectMapper.findByCode(subjectCode)
                .orElseThrow(() -> new IllegalArgumentException("해당 과목을 찾을 수 없습니다: " + subjectCode));
    }
}
