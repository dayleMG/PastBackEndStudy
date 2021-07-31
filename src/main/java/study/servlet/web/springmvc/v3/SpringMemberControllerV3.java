package study.servlet.web.springmvc.v2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.servlet.domain.member.Member;
import study.servlet.domain.member.MemberRepo;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return  "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age, Model model) {

        Member member = new Member(username, age);
        memberRepo.save(member);

        model.addAttribute("member", member);
        return "save-result";

    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepo.findAll();

        model.addAttribute("members", members);
        return "members";
    }


}
