package study.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.servlet.domain.member.Member;
import study.servlet.domain.member.MemberRepo;
import study.servlet.web.frontcontroller.ModelView;

import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListControllerV1 {

    private final MemberRepo memberRepo = MemberRepo.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process( ) {
        List<Member> members = memberRepo.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
