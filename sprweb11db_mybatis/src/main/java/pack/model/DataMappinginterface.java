package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMappinginterface {
	@Select("select * from sangdata")
	List<SangpumDto> selectAll();
	
	@Select("select code, sang, su, dan from sangdata where sang like concat('%',#{searchValue},'%')")//mySQL, mariaDB
	//@Select("select code, sang, su, dan from sangdata where sang like '%'||#{searchValue}||'%'")
	List<SangpumDto> selectSearch(FormBean bean);
}
