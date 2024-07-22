package pack.model;

import lombok.Data;

@Data
public class JikwonDto {//필요한 것만 가져오기
	private int jikwon_no, buser_num, jikwon_pay;
	private String jikwon_name, jikwon_jik, jikwon_rating;

}
