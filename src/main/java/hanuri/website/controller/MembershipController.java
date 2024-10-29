package hanuri.website.controller;

import hanuri.website.dto.Membership;

import hanuri.website.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MembershipController {
    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    //회비납부내역 등록
    @GetMapping("/membership/new")
    public String createForm(Model model){
        List<Membership> members = membershipService.findAllMembers();
        model.addAttribute("members", members);
        return "Membership/MembershipCreate";
    }
    @PostMapping("/membership/new")
    public String createForm(Membership membership) {

        membershipService.save(membership);
        return "redirect:/membership/success";
    }

    //회비납부내역 조회
    @GetMapping("/membership/list")
    public String list(Model model) {
        List<Membership> membership = membershipService.findMembership();
        model.addAttribute("membership", membership);
        return "Membership/MembershipList";
    }

    //회비납부내역 수정
    @GetMapping("/membership/modify")
    public String modify(Model model) {
        List<Membership> membership = membershipService.findAllMembers();
        model.addAttribute("membership", membership);
        return "Membership/MembershipModify";
    }

    @PostMapping("/membership/modify")
    public String modify(Membership membership) {
        membershipService.modify(membership);
        return "redirect:/membership/success";
    }

    //회비납부내역 삭제
    @GetMapping("/membership/delete")
    public String delete(Model model){
        List<Membership> membership = membershipService.findAllMembers();
        model.addAttribute("membership", membership);
        return "Membership/MembershipDelete";
    }
    @PostMapping("/membership/delete")
    public String delete(Membership membership){
        membershipService.delete(membership);
        return "redirect:/membership/success";
    }

    @GetMapping("membership/success")
    public String success(){ return "Membership/MembershipFeePaymentSuccess";
    }
}
