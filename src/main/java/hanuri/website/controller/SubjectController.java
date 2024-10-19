package hanuri.website.controller;

import hanuri.website.dto.Subject;
import hanuri.website.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // 과목 추가 폼을 보여주는 메서드
    @GetMapping("/subjects/new")
    public String createForm() {
        return "subjects/createSubjectForm";  // 새로운 과목 추가 폼
    }

    // 과목 추가 요청을 처리하는 메서드
    @PostMapping("/subjects/new")
    public String create(SubjectForm form) {
        Subject subject = new Subject();
        subject.setSubjectName(form.getSubjectName());
        subject.setGrade(Byte.parseByte(form.getGrade()));
        subject.setSemester(Byte.parseByte(form.getSemester()));
        subject.setProfessor(form.getProfessor());
        subject.setStudyOpened(Boolean.parseBoolean(form.getStudyOpened()));

        subjectService.save(subject); // 과목 저장
        return "redirect:/subjects"; // 과목 목록 페이지로 리다이렉트
    }

    // 과목 목록을 보여주는 메서드
    @GetMapping("/subjects")
    public String list(Model model) {
        List<Subject> subjects = subjectService.findSubjects(); // 과목 목록 조회
        model.addAttribute("subjects", subjects);
        return "subjects/subjectList";  // 과목 목록을 보여주는 뷰
    }

    // 특정 과목의 상세 정보를 보여주는 메서드
    @GetMapping("/subjects/{code}")
    public String detail(@PathVariable("code") Long subjectCode, Model model) {
        Subject subject = subjectService.findByCode(subjectCode);
        model.addAttribute("subject", subject);
        return "subjects/subjectDetail";  // 과목 상세 정보를 보여주는 뷰
    }
}
