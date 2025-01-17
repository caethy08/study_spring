package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class JickwonDto {
	private String jikwon_no, jikwon_name, buser_name, jikwon_ibsail, jikwon_num, jikwon_pay;
}
