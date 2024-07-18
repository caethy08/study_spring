package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
//추상메소드인 datainterface를 읽을 수 있는
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInterface dataMapperInterface;  //hikari pool이 자동으로 지원됨
	
	//전체 자료 읽기
	public List<MemDto> getDataAll() {
		List<MemDto> list = dataMapperInterface.selectAll();
		logger.info("전체 자료 크기 : " + list.size());
		return list;
	}
	
	//부분 자료 읽기
	public MemDto getData(String num) {
		MemDto dto = dataMapperInterface.selectPart(num);
		return dto;
	}
	//추가
	   public boolean insert(MemBean bean) {
		      // 번호 중복 방지, 번호 자동 증가 등 작업 필요
		      return dataMapperInterface.insertData(bean) > 0 ? true : false;
		   }
	
	//수정
	   public boolean update(MemBean bean) {
		   int re = dataMapperInterface.update(bean);
		   if(re > 0)
			   return true;
		   else 
			   return false;
	   }
	   
	   //삭제
	   public boolean delete(String num) {
		   return dataMapperInterface.deleteData(num) > 0? true:false;
	   }
	
}
