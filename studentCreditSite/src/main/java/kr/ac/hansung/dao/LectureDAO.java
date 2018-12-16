package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.model.LectureList;

@Repository
public class LectureDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired // DataSource를 가진 빈을 자동으로 주입해준다.
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 레코드가 총 몇개있는지 조회
	public int getRowCount() {
		String sqlStatement = "select count(*) from lecture";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class); // 두번째 인자는 리턴값이 넘어오는 타입
	}

	// 모든강의 출력
	public List<Lecture> getLectures() {

		String sqlStatement = "select * from Lecture";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 레코드개수대로 수행됨

				Lecture lecture = new Lecture();
				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setName(rs.getString("name"));
				lecture.setType(rs.getString("type"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;

			}
		});
	}

	public List<LectureList> getAlignedLectureList() {

		String sqlStatement = "select year, semester, SUM(credit) from lecture group by year,semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<LectureList>() {
			@Override
			public LectureList mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 레코드개수대로 수행됨

				LectureList lectureList = new LectureList();
				lectureList.setYear(rs.getInt("year"));
				lectureList.setSemester(rs.getInt("semester"));
				lectureList.setCredit(rs.getInt("SUM(credit)"));

				return lectureList;
			}
		});

	}

	public boolean insert(Lecture lecture) {

		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String code = lecture.getCode();
		String name = lecture.getName();
		String type = lecture.getType();
		int credit = lecture.getCredit();

		String sqlStatement = "insert into lecture (year,semester,code,name,type,credit) values(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, name, type, credit }) == 1);
	}

	public List<Lecture> getNewLecture() {
		String sqlStatement = "select * from Lecture where year=2019";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 레코드개수대로 수행됨
				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setName(rs.getString("name"));
				lecture.setType(rs.getString("type"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;

			}
		});
	}

	public List<Lecture> getSelectedLecture(String id) {
		
		System.out.println(id);
		String sqlStatement2 = "select * from Lecture where year=?,semester=?";
		
		String sqlStatement = "select * from Lecture where year=2019";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 레코드개수대로 수행됨
				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCode(rs.getString("code"));
				lecture.setName(rs.getString("name"));
				lecture.setType(rs.getString("type"));
				lecture.setCredit(rs.getInt("credit"));

				return null;

			}
		});
	}


}
