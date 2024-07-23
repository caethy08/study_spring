package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataRepository dataRepository;

	public List<Board> list() { // 전체 자료 읽기
		List<Board> list = dataRepository.findAll();
		logger.info("list size : " + list.size());

		return list;
	}

	public List<Board> search(BoardBean bean) { // 전체 자료 읽기
		List<Board> slist = null;

		if (bean.getSearchName().equals("author")) {
			slist = dataRepository.searchLike(bean.getSearchValue());
		} else {
			slist = dataRepository.searchLike(bean.getSearchValue());
		}

		return slist;
	}
	
	@Transactional  //proxy 객체는 해당 메소드가 처리될 때 commit or rollback 을 수행한다
	//checedexception 또는 예외가 없는경우 commit 수행
	//uncheckedexception이 발생하면 Rollback 수행
	public String insertData(BoardBean bean) {
		try {
			//새 글을 입력 시 가장 큰 번호를 얻어 +1
			int max = dataRepository.maxNum();
			
			Board dto = new Board();
			dto.setNum(max + 1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			
			dataRepository.save(dto);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e.getMessage();
		}
	}
	@Transactional //readcnt업데이트용
	public Board detail(int num) { //상세보기 용
		//조회수 증가
		dataRepository.updateReadcnt(num);
		
		//Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다
		//spring Data JPA를 사용할 때 Repository에서 findById()의 반환값은 Optional 타입
		Optional<Board> board = dataRepository.findById(num); //optional객체변수 board
		logger.info("board :: {}", board.get());
		
		if (board.isPresent()) {
			return board.get(); //board는 optional이어서 board를 리턴하는게 아닌 .get을 리턴한다
		}else {
			return new Board();
		}
	}
	
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			
			//조회수도 수정에 참여하기 위한 선행작업
			Optional<Board> board = dataRepository.findById(bean.getNum());
			Board imsi = board.get();
			/*
			Board dto = new Board();
			dto.setNum(bean.getNum()); //이미 등록된 번호를 넣어주는 것이기때문에 수정이 된다
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setReadcnt(0);
			
			dataRepository.save(dto);
			*/
			//save 없이 수정하는 방법(수정 하고 싶은 요소만 쓰면 그 부분만 수정된다)
			//imsi.setAuthor(bean.getAuthor()); //이러면 글쓴이는 수정되지 못한다
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			//imsi.setReadcnt(bean.getReadcnt());
			
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e.getMessage();
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			dataRepository.deleteById(num);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e.getMessage();
		}
	}

}
