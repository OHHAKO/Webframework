package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lecture {

	private int year;
	private int semester;
	private String code;
	private String name;
	private String type;
	private int credit;
}
