package pack.dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpListDto {

	private Integer empno;
	private String ename;
	private Integer deptno;
	private String dname;
	private String job;
	
	//entity를 dto로 변환
	public static EmpListDto toDto(Emp emp) {
		return EmpListDto.builder() //생성자를 통해서 값을 주입하는데 builder을 이용해서 
				.empno(emp.getEmpno())
				.ename(emp.getEname())
				.deptno(emp.getDept().getDeptno())
				.dname(emp.getDept().getDname())
				.job(emp.getJob())
				.build();
	}
}
