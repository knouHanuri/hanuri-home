package hanuri.website.controller;

import hanuri.website.dto.Study;
import hanuri.website.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudyController {
    private final StudyService studyService;

    @Autowired
    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/study/list")
    public String studyList(){
        return "study/studyList";
    }

    @GetMapping("/study/form")
    public String studyForm(){
        return "study/studyForm";
    }

    @PostMapping("/study/formSave")
    public String create(Study studyForm)
    {
        Study study = new Study();
        study.setSubjectCode(studyForm.getSubjectCode());
        study.setTitle(studyForm.getTitle());
        study.setStatus(studyForm.getStatus());
        study.setSchedule(studyForm.getSchedule());
        study.setStartDate(studyForm.getStartDate());
        study.setEndDate(studyForm.getEndDate());
        study.setEstablishedBy(studyForm.getEstablishedBy());
        studyService.save(study);
        return "redirect:/";
    }
}
