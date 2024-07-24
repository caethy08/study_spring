package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dept { //스캔에 의해 테이블 생성
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	//FetchType.LAZY : Dept 사용 중 Emp는 필요할 때 지연 로딩(필요할 때 천천히 로딩 된다)(메모리 효율적 사용 가능). 
	//세션이 열려있는 동안 세션관리가 필요하며 LazyInitializationException 조치 필요
	//FetchType.EAGER : Dept 사용 중 Emp는 즉시 로딩(메모리가 약간 낭비)
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default //Emp 엔티티가 생성될 때 list를 초기화함. 
 	private List<Emp> list = new ArrayList<Emp>();
}
