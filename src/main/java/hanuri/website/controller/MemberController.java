package hanuri.website.controller;

import hanuri.website.domain.EEnrollmentStatus;
import hanuri.website.domain.EGender;
import hanuri.website.domain.dto.Member;
import hanuri.website.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm(Model model)
    {
        model.addAttribute("member", new Member());
        model.addAttribute("gender", EGender.values());
        model.addAttribute("enrollmentStatus", EEnrollmentStatus.values());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@ModelAttribute Member member)
    {
        System.out.println(member.getPassword());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model)
    {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

    @GetMapping("members/detail/{id}")
    public String detail(@PathVariable int id, Model model)
    {
        Optional<Member> member = memberService.findOne(id);
        model.addAttribute("member",member);
        model.addAttribute("gender", EGender.values());
        model.addAttribute("enrollmentStatus", EEnrollmentStatus.values());

        return "members/memberDetail";
    }

    @PostMapping("members/modify")
    public String modify(@ModelAttribute Member member)
    {
        memberService.modify(member);
        return "redirect:/";
    }
}
