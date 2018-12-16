package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.LectureList;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;

	@RequestMapping("/lectures")
	public String showLectures(Model model) {

		List<LectureList> lectureList = lectureService.getLectureList();
		model.addAttribute("lectureList", lectureList);
		// view 이름 수정필요
		return "lectures";
	}

	@RequestMapping("/registerlecture")
	public String showRegisterLectures(Model model) {

		return "registerlecture";
	}

	@RequestMapping("/dolecturecreate")
	public String doCreate(Model model, Lecture lecture) {
		
		// controller 에서는 service 호출
		lectureService.insert(lecture);
		
		return "lecturecreated";
	}
	
	@RequestMapping("/registeredlecture")
	public String showRegistedLectures(Model model) {
		
		List<Lecture> newLectureList = lectureService.getNewLectures();
		model.addAttribute("newLectureList", newLectureList);
		
		return "registeredlecture";
	}
	
	
	
	@RequestMapping(value="/selectedlecture",method=RequestMethod.GET)
	public String showSelectedLectures(@RequestParam(value="lecId") String id,Model model) {
		
		System.out.println("this is selected id : "+id);
		
		List<Lecture> selectedLectures = lectureService.getSelectedLectures(id);
		model.addAttribute("selectedLectures",selectedLectures);
		
		return "registeredlecture";
	}

}
