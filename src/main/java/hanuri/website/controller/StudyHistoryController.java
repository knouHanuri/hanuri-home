package hanuri.website.controller;

import hanuri.website.dto.history.StudyHistoryRegisterRequestDTO;
import hanuri.website.service.StudyHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/study/history")
public class StudyHistoryController {
    private StudyHistoryService studyHistoryService;

    @Autowired
    public StudyHistoryController(StudyHistoryService studyHistoryService) {
        this.studyHistoryService = studyHistoryService;
    }

    @GetMapping
    public String registerForm() {
        return "/studyHistory/registerForm";
    }

    @PostMapping
    public String register(@Valid StudyHistoryRegisterRequestDTO requestDTO) {
        studyHistoryService.register(requestDTO);
        return "redirect:/";
    }

    @GetMapping("/{studyId}")
    public String findAllByStudyId(Model model, int studyId) {
//        try {
//
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @PutMapping
    public String update() {
        return "redirect:/";
    }

    @DeleteMapping
    public String delete() {
        return "redirect:/";
    }
}
