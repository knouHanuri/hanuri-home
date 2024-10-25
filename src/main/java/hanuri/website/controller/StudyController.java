package hanuri.website.controller;

import hanuri.website.dto.Study;
import hanuri.website.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class  StudyController {
    private final StudyService studyService;

    @Autowired
    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/study/list")
    public String studyList(Model model){
        List<Study> studyList = studyService.studyListAll();
        model.addAttribute("studyList",studyList);
        return "study/studyList";
    }

    @GetMapping("/study/form")
    public String studyForm(){
        return "study/studyForm";
    }

    @PostMapping("/study/formSave")
    public String create(Study studyForm, RedirectAttributes redirectAttributes)
    {
        Study study = new Study();
        study.setSubjectCode(studyForm.getSubjectCode());
        study.setTitle(studyForm.getTitle());
        study.setStatus(studyForm.getStatus());
        study.setSchedule(studyForm.getSchedule());
        study.setStartDate(studyForm.getStartDate());
        study.setEndDate(studyForm.getEndDate());
        study.setEstablishedBy(studyForm.getEstablishedBy()); //나중에 현재 로그인 한 사용자로 저장
        studyService.save(study);

        redirectAttributes.addFlashAttribute("message", "스터디가 등록되었습니다.");
        return "redirect:/study/list";
    }
}
