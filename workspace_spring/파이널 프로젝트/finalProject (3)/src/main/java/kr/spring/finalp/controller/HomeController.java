package kr.spring.finalp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.TeacherCommand;
import kr.spring.finalp.service.AcademyService;
import kr.spring.finalp.service.HomeService;
import kr.spring.finalp.service.TeacherService;


@Controller
public class HomeController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private HomeService homeService;
	@Resource
	private AcademyService academyService;
	@Resource
	private TeacherService teacherService;
	
	//커맨드 객체 초기화
	@ModelAttribute("command")
	public AcademyCommand initCommand() {
		return new AcademyCommand();
	}
	
	@RequestMapping("/main/main.do")
	public ModelAndView callMain(HttpSession session) {
		
		String user_id = (String) session.getAttribute("user_id");
		if(user_id == null) user_id = "";
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("keyfield", "a_name");
		aMap.put("keyword", "");
		Map<String, Object> tMap = new HashMap<String, Object>();
		tMap.put("keyfield", "");
		tMap.put("keyword", "");
		tMap.put("m_id", user_id);
		
		int aCount = academyService.getRowCount(aMap);
		
		int tCount = teacherService.getRowCount(tMap);
		
		
		if(log.isDebugEnabled()) {
			log.debug("<<aCount>> : " + aCount);
			log.debug("<<tCount>> : " + tCount);
		}
		
		List<AcademyCommand> academyTopList = null;
		if(aCount > 0) {
			academyTopList = homeService.academyRank(aMap);
		}
		List<TeacherCommand> teacherTopList = null;
		if(tCount > 0) {
			teacherTopList = homeService.teacherRank(tMap);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("aCount", aCount);
		mav.addObject("tCount", tCount);
		mav.addObject("academyTopList", academyTopList);
		mav.addObject("teacherTopList", teacherTopList);
		
		if(academyTopList != null) System.out.println("academyTopList Size : " + academyTopList.size());
		if(teacherTopList != null) System.out.println("teacherTopList Size : " + teacherTopList.size());
		
		return mav;
	}
	
	//학원 랭크 이미지 출력
	@RequestMapping("/main/imageView.do")
	public ModelAndView viewImage(@RequestParam("a_num") int a_num) {
		
		AcademyCommand academy = academyService.getAcademy(a_num);
		
		if(a_num!=-1) academy = academyService.getAcademy(a_num);
		
		System.out.println("academy for imageView : " + academy);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("upload", academy.getUploadfile());
		mav.addObject("filename", academy.getA_logo());
		return mav;
	}
	
	//강사 랭크 이미지 출력
	@RequestMapping("/main/t_imageView.do")
	public ModelAndView t_viewImage(@RequestParam("t_num") int t_num) {
		
		TeacherCommand teacher = teacherService.selectTea(t_num);
		
		if(t_num!=-1) teacher = teacherService.selectTea(t_num);
		
		System.out.println("teacher for imageView : " + teacher);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("upload", teacher.getUploadfile());
		mav.addObject("filename", teacher.getT_image());
		
		return mav;
	}
	
}
