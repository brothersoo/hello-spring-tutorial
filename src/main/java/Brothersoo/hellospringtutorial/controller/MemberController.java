package Brothersoo.hellospringtutorial.controller;

import Brothersoo.hellospringtutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
