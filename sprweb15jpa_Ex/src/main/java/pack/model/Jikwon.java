package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jikwon ")
public class Jikwon {
	@Id
	private int jikwon_no;
	
	@Column(nullable = false)
	private String jikwon_name;
	private int buser_num;
	
	@Column(name = "jikwon_jik")
	private String jik;
	
	private int jikwon_pay;
	private String jikwon_ibsail;
	private String jikwon_gen;
	private String jikwon_rating;
}
