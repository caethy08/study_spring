package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void getList(Model model) {
		/*
		// 방법 1: member 전체 자료 반환, model을 통해 반환: 기본 메소드 사용
		//Member 엔티티를 MemberDto객체로 전달
		List<Member> entityList = memberRepository.findAll(); //읽음
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto); //memberdto가 담김
		}
		*/
		
		// 방법 2: List<Member>를 Stream(람다때 언급)으로 변경해서 map()을 사용 List<MemberDTO>로 변경하기
		List<MemberDto> list = memberRepository.findAllByOrderByNumDesc()
												.stream()
												.map(item -> MemberDto.toDto(item)).toList();
		
		/*
		// 방법 2-1 : 람다 표현식을 메소드 참조 표현식으로 기술  클래스명 :: 메소드명
		List<MemberDto> list2 = memberRepository.findAllByOrderByNumDesc()
												.stream()
												.map(MemberDto::toDto).toList();
		*/
		
		model.addAttribute("list", list); //컨트롤러에 MemberDto가 담긴 list를 전달한다
		
	}
	
	@Override
	public void insert(MemberDto dto) {
		// 추가용 메소드. JPA 작업 영역 내로 들어 갈 때 일반 자료 전달용 객체(dto, formbean)를 대응되는 엔티티로 변환 
		memberRepository.save(Member.toEntity(dto));
		
		
	}
	
	//수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		// TODO Auto-generated method stub
		Member m = memberRepository.findById(num).get();
		
		model.addAttribute("dto", MemberDto.toDto(m));
	}
	
	@Override
	public void update(MemberDto dto) {
		//엔티티로 변환
		memberRepository.save(Member.toEntity(dto)); 
	
	}
	
	@Override
	public void update2(MemberDto dto) {
		
	}
	
	@Override
	public void delete(Long num) {
		memberRepository.deleteById(num);
		
	}
	
	
}
