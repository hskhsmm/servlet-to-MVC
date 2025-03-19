package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public String newForm() {
        return "new-form"; //스프링 애노테이션 기반의 컨트롤러는 모델 앤 뷰를 반환해도 되고 문자를 반환해도 됨.
        //그럼 view 이름으로 알고 프로세스가 진행됨.
    }

    @RequestMapping("/save")
    //HttpServletRequest request, HttpServletResponse response 대신 RequestParam으로 받을 수 있음
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
