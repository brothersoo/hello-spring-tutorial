package Brothersoo.hellospringtutorial.controller;

import Brothersoo.hellospringtutorial.domain.Member;
import Brothersoo.hellospringtutorial.repository.MemberRepository;
import Brothersoo.hellospringtutorial.repository.MemoryMemberRepository;
import Brothersoo.hellospringtutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

  /**
   * Constructor Injection
   *
   * Mostly recommended injection
   */
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }


  /**
   * Field Injection
   *
   * Field injection is not recommended due to lack of scalability
   */
//  @Autowired private MemberService memberService;

  /**
   * Setter Injection
   *
   * Setter injection is also not recommended due to unnecessary public setter method
   */
//  private MemberService memberService;
//
//  @Autowired
//  public void setMemberService(MemberService memberService) {
//    this.memberService = memberService;
//  }

  @GetMapping("/members/new")
  public String createForm() {
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String joinMember(MemberForm form) {

    Member member = new Member();
    member.setName(form.getName());
    memberService.join(member);

    return "redirect:/";
  }
}
