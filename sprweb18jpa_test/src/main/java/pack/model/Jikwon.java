package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	private int jikwon_no;
	
	private int jikwon_pay;
	
	@Column(name = "buser_num")
	private int buserNum;
	
	private String jikwon_name;
	
	private String jikwon_jik;
	
	@Column(name = "jikwon_rating")
	private String jikwonRating;
}
