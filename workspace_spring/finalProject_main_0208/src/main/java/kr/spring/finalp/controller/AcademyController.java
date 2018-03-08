package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.service.AcademyService;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class AcademyController {

	private Logger log = Logger.getLogger(this.getClass());


	private int rowCount =10;
	private int pageCount = 10;


	@Resource
	private AcademyService academyService;


	//Ŀ�ǵ� ��ü �ʱ�ȭ
	@ModelAttribute("command")
	public AcademyCommand initCommand() {
		return new AcademyCommand();

	}
	//�п� �Ұ� ����(����Ʈ ����)
	@RequestMapping("/academy/academyMain.do")
	public ModelAndView academyMain(@RequestParam(value="pageNum",defaultValue="1")int currentPage,@RequestParam(value="keyfield",defaultValue="a_name")String keyfield,@RequestParam(value="keyword",defaultValue="")String keyword) {

		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�� ���� ���� �Ǵ� �˻��� ���� ����
		int count = academyService.getRowCount(map);
		if(count>0) {

		}
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"academyMain.do");
		map.put("start", page.getStartCount());
		map.put("end",page.getEndCount());

		List<AcademyCommand> list = null;
		if(count>0) {
			list = academyService.listAcademy(map);
		}

		List<AcademyCommand> topList = null;
		if(count>0) {
			topList = academyService.topListAcademy(map);
		}


		ModelAndView mav = new ModelAndView();
		mav.setViewName("academyMain");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("topList", topList);
		mav.addObject("pagingHtml",page.getPagingHtml());

		System.out.println(page.getPagingHtml());

		return mav;

	}
	//�п� �Ұ� �� ����
	@RequestMapping("/academy/academyDetail.do")
	public ModelAndView academyDetail(@RequestParam("a_num") int a_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + a_num);
		}

		AcademyCommand academy = academyService.selectAcademyDetail(a_num);
		academy.setA_name(StringUtil.useBrNoHtml(academy.getA_name()));
		academy.setA_content(StringUtil.useBrNoHtml(academy.getA_content()));

		return new ModelAndView("academyDetail", "academy", academy);
	}

	//�� �п� ���� �� ����
	   @RequestMapping("/academy/academyInfo.do")
	   public String academyInfo(HttpSession session,Model model) {
	     
	      String id = (String)session.getAttribute("user_id");
		   
	      AcademyCommand academy = academyService.selectAcademy(id);
	      System.out.println(academy);
	      model.addAttribute("academy",academy);
	      
	      return "academyInfo";
	   }



	//�п� ��� ��
	@RequestMapping(value="/academy/insert.do",method=RequestMethod.GET)
	public String insertForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");

		System.out.println("ID"+(String)session.getAttribute("user_id"));
		AcademyCommand academy = academyService.selectAM(id);

		model.addAttribute("command",academy);
		System.out.println(academy);
		return "academyInsert";
	}



	//�п� ���
	@RequestMapping(value="/academy/insert.do",method=RequestMethod.POST)
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String insertSubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<academyCommand>> : " + academyCommand);
		} 
		/*if(result.hasErrors()) {
			return insertForm(); 
		}
		 */

		//�п� ���
		academyService.insertAcademy(academyCommand);
		return "redirect:/main/main.do";
	}

	//�п� ���� ��
	@RequestMapping(value="/academy/modify.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		System.out.println("id"+id);
		AcademyCommand academy = academyService.selectAcademy(id);

		model.addAttribute("command",academy);
		System.out.println(academy);
		return "academyModify";
	}
	
	//�п� ����
	@RequestMapping(value="/academy/modify.do",method=RequestMethod.POST)
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String modifySubmit(@ModelAttribute("command") @Valid AcademyCommand academyCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<academyCommand>> : " + academyCommand);
		} 
		/*if(result.hasErrors()) {
				return insertForm(); 
			}
		 */
		System.out.println("?");

		//�п� ���
		academyService.updateAcademy(academyCommand);
		return "redirect:/main/main.do";
	}

}
