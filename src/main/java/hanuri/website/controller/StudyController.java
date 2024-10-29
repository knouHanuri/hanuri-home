package hanuri.website.controller;

import hanuri.website.domain.EStudyStatus;
import hanuri.website.dto.Study;
import hanuri.website.service.StudyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class  StudyController {
    private final StudyService studyService;

    @Autowired
    public StudyController(StudyService studyService) { this.studyService = studyService; }

    @GetMapping("/study/list")
    public String studyList(Model model){
        List<Study> studyList = studyService.studyListAll();
        model.addAttribute("status", EStudyStatus.values());
        model.addAttribute("studyList",studyList);
        return "study/studyList";
    }

    @GetMapping("/study/form")
    public String studyForm(@RequestParam(required = false) Long studyId, Model model){
        Optional<Study> optionalStudy = Optional.empty();
        if(studyId != null) optionalStudy = studyService.findById(studyId);
        model.addAttribute("status", EStudyStatus.values());
        model.addAttribute("study", optionalStudy.orElseGet(Study::new));
        return "study/studyForm";
    }

    @PostMapping("/study/formSave")
    public String create(@ModelAttribute @Valid Study studyForm, RedirectAttributes redirectAttributes, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패 시, 다시 폼으로 돌아감
            return "/study/form";
        }

        //study.setEstablishedBy("현재 사용자"); //나중에 현재 로그인 한 사용자로 저장

        String msg = "등록";
        if(studyForm.getStudyId() != null) {
            studyService.update(studyForm);
            msg = "수정";
        }
        else studyService.save(studyForm);

        redirectAttributes.addFlashAttribute("message", String.format("스터디가 %s되었습니다.", msg));
        return "redirect:/study/list";
    }

    @DeleteMapping("/study/delete/{studyId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long studyId) {
        int deleteCount = studyService.delete(studyId);
        if(deleteCount == 1) return ResponseEntity.noContent().build();
        else return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
