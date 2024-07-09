package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder   //생성자의 단점을 해결하기 위한 패턴
public class SangpumDto {
	private String code, sang, su, dan;
	
	
}
