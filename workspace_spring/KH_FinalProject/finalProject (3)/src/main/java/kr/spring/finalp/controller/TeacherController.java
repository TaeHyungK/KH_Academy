package kr.spring.finalp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.finalp.domain.ClassCommand;
import kr.spring.finalp.domain.LikedTeacherCommand;
import kr.spring.finalp.domain.TeacherCommand;
import kr.spring.finalp.service.TeacherService;
import kr.spring.util.PagingUtil;

@Controller
public class TeacherController {

	private Logger log = Logger.getLogger(this.getClass());


	private int rowCount =10;
	private int pageCount = 10;


	@Resource
	private TeacherService teacherService;

	//���� ��� ����
	@RequestMapping("/teacher/teacherMain.do")
	public ModelAndView teacherMain(HttpSession session,Model model, TeacherCommand teacherCommand, 
			@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam(value="keyfield",defaultValue="t_name")String keyfield,
			@RequestParam(value="keyword",defaultValue="")String keyword){


		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}

		//���ӵǾ��ִ� ���̵� ���ϱ�
		String id = (String)session.getAttribute("user_id");

		System.out.println("ID"+(String)session.getAttribute("user_id"));

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("m_id", id);
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
		int count = teacherService.getRowCount(map);

		System.out.println(count);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}


		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"teacherMain.do");
		map.put("start", page.getStartCount());
		map.put("end",page.getEndCount());


		List<TeacherCommand> list = null;


		if(count>0) {
			list = teacherService.listTeacher(map);
			System.out.println(list);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("teacherMain");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		System.out.println(mav);

		return mav;
	}


	//���� ��� ��
	@RequestMapping(value="/teacher/insert.do",method=RequestMethod.GET)
	public String insertForm(HttpSession session,Model model, TeacherCommand teacherCommand) {
		String id = (String)session.getAttribute("user_id");

		System.out.println("ID"+(String)session.getAttribute("user_id"));

		TeacherCommand teacher = teacherService.selectTM(id);

		model.addAttribute("teacher",teacher);
		System.out.println(teacher);
		return "teacherInsert";
	}



	//���� ���
	@RequestMapping(value="/teacher/insert.do",method=RequestMethod.POST)
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String insertSubmit(@ModelAttribute("teacher") @Valid TeacherCommand teacherCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<teacherCommand>> : " + teacherCommand);
		} 
		
		if(result.hasErrors()) {
			return "teacherInsert"; 
		}
		 
		//���� ���
		teacherService.insertTeacher(teacherCommand);
		return "redirect:/teacher/teacherMain.do";
	}

	//���� ���� ��
	@RequestMapping(value="/teacher/updateTeacher.do",method=RequestMethod.GET)
	public String updateForm(HttpSession session,Model model, ClassCommand classCommand, @RequestParam("t_num") int t_num,
			@RequestParam("a_num") int a_num) {

		System.out.println("a"+a_num);

		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("a_num", a_num);
		map.put("t_num", t_num);

		//�ش��п� �ҷ�����
		TeacherCommand teacher = teacherService.selectTea(t_num);


		model.addAttribute("teacher",teacher);
		System.out.println(teacher);

		return "teacherUpdate";
	}

	//���� ����
	@RequestMapping(value="/teacher/updateTeacher.do",method=RequestMethod.POST)
	public String updateSubmit(HttpSession session,Model model, TeacherCommand teacherCommand, @RequestParam("t_num") int t_num,
			@RequestParam("a_num") int a_num) {


		System.out.println("a"+a_num);

		//�ش簭�� ����
		teacherService.updateTeacher(teacherCommand);

		return "redirect:/teacher/teacherMain.do";
	}

	//���� ����
	@RequestMapping("/teacher/deleteTeacher.do")
	public String deleteSubmit(HttpSession session,Model model, TeacherCommand teacherCommand, @RequestParam("t_num") int t_num,
			@RequestParam("a_num") int a_num) {

		System.out.println("a"+a_num);
		System.out.println("t"+t_num);

		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("t_num", t_num);
		map.put("a_num",a_num);

		//�ش��п� ����
		teacherService.deleteTeacher(map);
		System.out.println("ff");
		return "redirect:/teacher/teacherMain.do";
	}




	//������
	@RequestMapping("/teacher/teacherInfo.do")
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String teacherInfo(Model model, TeacherCommand teacherCommand) {

		List<Integer> list = teacherService.selectA_teacher();

		if(log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);      
		}

		List<List<TeacherCommand>> listByAnum = new ArrayList<List<TeacherCommand>>();
		System.out.println("a_num list : "+list);

		for(int a_num : list) {

			listByAnum.add(teacherService.selectAllTeacher(a_num));       
		}
		if(log.isDebugEnabled()) {
			log.debug("<<listByAnum>> : " + listByAnum);
			log.debug("<<list>> : " + list);

		}
		model.addAttribute("list",list);
		model.addAttribute("listByAnum",listByAnum);

		return "teacherInfo";
	}
	//���� �̹��� ���
	@RequestMapping("/teacher/t_imageView.do")
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

	//���� �󼼺���
	@RequestMapping("/teacher/teacherInfoDetail.do")
	//	�ڿ����� �ڹٺ��� ���� �޽����� @Valid�� ������
	public String teacherInfoDetail(Model model, TeacherCommand teacherCommand,
			@RequestParam("t_num") int t_num,HttpSession session) {

		Integer m_num = (Integer)session.getAttribute("user_num");
		if(m_num == null) m_num = 0;

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("m_num", m_num);
		map.put("t_num", t_num);

		System.out.println(map);
		TeacherCommand teacher = teacherService.getTeacher(map);
		System.out.println(teacher);
		model.addAttribute("teacher", teacher);
		return "teacherInfoDetail";
	}

	//���ƿ� ��ư Ajax
	@RequestMapping("/teacher/likedTeacher.do")
	@ResponseBody
	public Map<String,Object> onLikedBtn(final @RequestParam("t_num") int t_num, @RequestParam("currentClass") String currentClass, HttpSession session, HttpServletRequest request,
			Model model){
		System.out.println("AcademyController in Ajax method !!");

		Map<String, Object> map = new HashMap<String, Object>();


		if(log.isDebugEnabled()) {
			log.debug("<<t_num>> : " + t_num);
			log.debug("<<currentClass>> : " + currentClass);
		}

		Integer m_num = (Integer)session.getAttribute("user_num");
		System.out.println("<<m_num>> : " + m_num);


		if(m_num == null) {
			//�α��� �ȵ�
			map.put("result", "logout");
		}else {
			System.out.println("outer start!");

			LikedTeacherCommand likedTeacher  = teacherService.getLikedTeacher(m_num, t_num);

			System.out.println(likedTeacher);

			if(likedTeacher == null) {
				System.out.println("if block!");

				teacherService.updateLike(t_num,m_num);
				map.put("changeClass", "fas fa-thumbs-up");



			}else{
				System.out.println("else if block!");
				teacherService.updateLikeMinus(t_num,m_num);
				map.put("changeClass", "far fa-thumbs-up");

			}

			System.out.println("outer block!");

			TeacherCommand teacher = teacherService.selectTea(t_num);

			System.out.println("t_good >> "+teacher.getT_good());

			map.put("result", "success");
			map.put("likedCount", teacher.getT_good());

		}

		return map;
	}

}
