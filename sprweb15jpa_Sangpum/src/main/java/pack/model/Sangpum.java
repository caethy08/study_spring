package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sangdata")
public class Sangpum {
	@Id
	private int code;
	
	@Column(nullable = false)
	private String sang;
	
	private int su;
	private int dan;
	//private int ff; //원본테이블에 없는 값을 덧붙일 수 있다.
	
}
