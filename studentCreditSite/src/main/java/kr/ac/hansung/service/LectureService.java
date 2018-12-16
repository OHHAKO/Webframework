package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;
import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.LectureList;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDao;
	
	public List<Lecture> getRecodes(){
		return lectureDao.getLectures();
	}

	public List<LectureList> getLectureList() {
		return lectureDao.getAlignedLectureList();
	}

	public void insert(Lecture lecture) {
		lectureDao.insert(lecture);
	}

	public List<Lecture> getNewLectures() {
		return lectureDao.getNewLecture();
	}

	public List<Lecture> getSelectedLectures(String id) {
		return lectureDao.getSelectedLecture(id);
	}
}
