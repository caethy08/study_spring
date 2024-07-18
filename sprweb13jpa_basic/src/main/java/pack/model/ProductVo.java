package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product") //믈리적인 테이블 명 = product
public class ProductVo { //product_vo
	@Id
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
}
