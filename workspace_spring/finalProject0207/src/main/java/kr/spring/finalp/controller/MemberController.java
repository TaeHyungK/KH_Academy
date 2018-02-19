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

	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}

	//ȸ������ ��
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String writeForm() {
		return "memberWrite";
	}

	//ȸ������
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String writeSubmit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		if(result.hasErrors()) {
			return writeForm();
		}


		//ȸ�� ����
		memberService.insert(memberCommand);
		return "redirect:/main/main.do";
	}

	//�α��� ��
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "memberLogin";
	}

	//�α���
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String loginSubmit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result,HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		//id,passwd�ʵ常 üũ
		if(result.hasFieldErrors("m_id")||result.hasFieldErrors("m_pw")) {
			return loginForm();
		}
		//�α��� üũ
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getM_id());
			boolean check = false;
			System.out.println(member);
			if(member!=null) {
				//��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(memberCommand.getM_pw());
				System.out.println(memberCommand.getM_pw());

				System.out.println("check"+check);
			}
			if(check) {
				//���� ����,�α��� ó��
				session.setAttribute("user_id", memberCommand.getM_id());
				session.setAttribute("user_num", memberCommand.getM_num());
				session.setAttribute("user_num1", memberCommand.getM_phone());
				session.setAttribute("user_group", member.getM_group());
				return "redirect:/main/main.do";
			}else {
				//����,�α��� ���н� catch�� �ѱ�
				System.out.println("��������");
				throw new Exception();
			}
		}catch(Exception e) {
			result.reject("invalidIdOrPassword");
			System.out.println("����");
			//���� ���з� �� ȣ��
			return loginForm();
		}
	}
	//�α� �ƿ�
	@RequestMapping("/member/logout.do")
	public String process(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}
	//ȸ�� ����
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

	//ȸ�� ���� ���� ��
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

	//ȸ�� ���� ����
	@RequestMapping(value="/member/modify.do",method=RequestMethod.POST)
	public String modifySubmit(@ModelAttribute("command")@Valid MemberCommand memberCommand,BindingResult result) {
		System.out.println("??");
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		if(result.hasErrors()) {
			return "memberModify";
		}
		//ȸ�� ���� ����
		memberService.update(memberCommand);
		return "redirect:/member/detail.do";
	}
	
	//ȸ�� ���� ��
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String deleteForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		MemberCommand member = memberService.selectMember(id);
		member.setM_id(id);
		model.addAttribute("command",member);
		return "memberDelete";
	}
	
	//ȸ�� ����
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String deleteSubmit(@ModelAttribute("command")@Valid MemberCommand memberCommand,BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		//��й�ȣ ��ġ ���� üũ
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getM_id());
			boolean check = false;
			System.out.println(member);
			if(member!=null) {
				check = member.isCheckedPasswd(memberCommand.getM_pw());
				System.out.println("delete check"+check);
			}
			//���� ����
			if(check) {
				memberService.delete(memberCommand.getM_num());
				//�α׾ƿ�
				session.invalidate();
				System.out.println("Ż�𼺰�");
				return "redirect:/main/main.do";
			}else {
				//���� ����
				throw new Exception();
			}
		}catch(Exception e) {
			//error �� �ѱ��
			result.rejectValue("m_pw", "invalidPassword");
			return "memberDelete";
		}
	}


}





