package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormBean {

	private int jikwon_no, jikwon_pay, buser_num;
	private String jikwon_name, jikwon_jik, jikwon_rating;
	private String searchBuser, searchValue;
}
