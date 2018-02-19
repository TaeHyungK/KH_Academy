package kr.spring.finalp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.finalp.domain.MemberCommand;
import kr.spring.finalp.service.MemberService;

@Controller
public class MemberController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;

	//커맨드 객체(자바빈) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}

	//회원가입 폼
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String writeForm() {
		return "memberWrite";
	}

	//회원가입
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	//	뒤에오는 자바빈의 에러 메시지를 @Valid에 저장함
	public String writeSubmit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		if(result.hasErrors()) {
			return writeForm();
		}


		//회원 가입
		memberService.insert(memberCommand);
		return "redirect:/main/main.do";
	}

	//로그인 폼
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "memberLogin";
	}

	//로그인
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String loginSubmit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result,HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		//id,passwd필드만 체크
		if(result.hasFieldErrors("m_id")||result.hasFieldErrors("m_pw")) {
			return loginForm();
		}
		//로그인 체크
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getM_id());
			boolean check = false;
			System.out.println(member);
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPasswd(memberCommand.getM_pw());
				System.out.println(memberCommand.getM_pw());

				System.out.println("check"+check);
			}
			if(check) {
				//인증 성공,로그인 처리
				session.setAttribute("user_id", memberCommand.getM_id());
				session.setAttribute("user_num", memberCommand.getM_num());
				session.setAttribute("user_num1", memberCommand.getM_phone());
				session.setAttribute("user_group", member.getM_group());
				return "redirect:/main/main.do";
			}else {
				//인증,로그인 실패시 catch로 넘김
				System.out.println("인증실패");
				throw new Exception();
			}
		}catch(Exception e) {
			result.reject("invalidIdOrPassword");
			System.out.println("실패");
			//인증 실패로 폼 호출
			return loginForm();
		}
	}
	//로그 아웃
	@RequestMapping("/member/logout.do")
	public String process(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}
	//회원 정보
	@RequestMapping("/member/detail.do")
	public String process(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");
		MemberCommand member = memberService.selectMember(id);
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + member);
		}
		model.addAttribute("member",member);
		return "memberView";
	}

	//회원 정보 수정 폼
	@RequestMapping(value="/member/modify.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		MemberCommand member = memberService.selectMember(id);
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + member);
		}
		model.addAttribute("command",member);
		System.out.println("modifyFormController");
		return "memberModify";
	}

	//회원 정보 수정
	@RequestMapping(value="/member/modify.do",method=RequestMethod.POST)
	public String modifySubmit(@ModelAttribute("command")@Valid MemberCommand memberCommand,BindingResult result) {
		System.out.println("??");
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		if(result.hasErrors()) {
			return "memberModify";
		}
		//회원 정보 수정
		memberService.update(memberCommand);
		return "redirect:/member/detail.do";
	}
	
	//회원 삭제 폼
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String deleteForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		MemberCommand member = memberService.selectMember(id);
		member.setM_id(id);
		model.addAttribute("command",member);
		return "memberDelete";
	}
	
	//회원 삭제
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String deleteSubmit(@ModelAttribute("command")@Valid MemberCommand memberCommand,BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		//비밀번호 일치 여부 체크
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getM_id());
			boolean check = false;
			System.out.println(member);
			if(member!=null) {
				check = member.isCheckedPasswd(memberCommand.getM_pw());
				System.out.println("delete check"+check);
			}
			//인증 성공
			if(check) {
				memberService.delete(memberCommand.getM_num());
				//로그아웃
				session.invalidate();
				System.out.println("탈퇴성공");
				return "redirect:/main/main.do";
			}else {
				//인증 실패
				throw new Exception();
			}
		}catch(Exception e) {
			//error 값 넘기기
			result.rejectValue("m_pw", "invalidPassword");
			return "memberDelete";
		}
	}


}





