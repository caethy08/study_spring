package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor //여기까진 loombok
@Entity(name="mem")  // DB의 특정 테이블과 매핑 여기는 hibernate
public class MemDto {  //camel 케이스로 작성하면 자동으로 underscore naming convention을 따름

	@Id
	@Column(name="num") //number로 원본테이블과 다르기 때문에 사용ㄴ
	private int num;
	//private int number; 
	
	@Column(name="name", nullable = true)
	private String name;
	
	private String addr;
}
