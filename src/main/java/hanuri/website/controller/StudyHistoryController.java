package hanuri.website.controller;

import hanuri.website.dto.history.RegisterStudyHistoryRequest;
import hanuri.website.dto.history.FindAllByStudyIdResponse;
import hanuri.website.dto.history.UpdateStudyHistoryRequest;
import hanuri.website.dto.history.UpdateStudyHistoryResponse;
import hanuri.website.service.StudyHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/study-history")
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
    public String register(@Valid RegisterStudyHistoryRequest requestDTO) {
        studyHistoryService.register(requestDTO);
        return "redirect:/";
    }

    @GetMapping("/{studyId}")
    public String findAllStudyHistoryByStudyId(Model model, @PathVariable int studyId) {
        List<FindAllByStudyIdResponse> responseDTO = studyHistoryService.findAllByStudyId(studyId);
        model.addAttribute("responseDTO", responseDTO);
        return "redirect:/";
    }

    @PutMapping
    public String update(UpdateStudyHistoryRequest requestDTO) {
        UpdateStudyHistoryResponse responseDTO = studyHistoryService.update(requestDTO);
        return "redirect:/";
    }

    @DeleteMapping
    public String delete() {
        return "redirect:/";
    }
}
