package hanuri.website.controller;

import hanuri.website.dto.Membership;
import hanuri.website.dto.MembershipCreate;
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

    @GetMapping("/membership/new")
    public String createForm(){return "Membership/MembershipCreate";}

    @PostMapping("/membership/new")
    public String createForm(MembershipCreate create)
    {
        Membership membership = new Membership(
                0,
                create.getMemberId(),
                null,null,
                create.getPaymentDate(),
                create.getAmount(),
                create.getExpirationDate()
    );
        membershipService.join(membership);
        return "redirect:/membership/success";
    }


    @GetMapping("/membership/list")
    public String list(Model model) {
        List<Membership> membership = membershipService.findMembership();
        model.addAttribute("membership", membership);
        return "Membership/MembershipList";
    }


//    @GetMapping("/membership/modify")
//    public String modify(){return "Membership/MembershipModify";}
//
//    @PostMapping("/membership/modify")
//    public String modify(membership)



    @GetMapping("membership/success")
    public String success(){ return "Membership/MembershipFeePaymentSuccess";
    }
}
