package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DataMapInterface {
	List<JikwonDto> selectBuser(int buser_num);
	List<JikwonDto> selectValue(@Param("buser_num") int buser_num, @Param("jikwon_rating") String jikwon_rating);
	

}
