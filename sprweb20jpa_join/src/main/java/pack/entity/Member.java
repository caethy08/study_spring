package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.dto.MemberDto;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER_TBL") //물리적 테이블 명이어서 _사용해도 괜찮음
public class Member { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	private String name;
	private String addr;
	
	//dto를 entity로 변환하기
	public static Member toEntity(MemberDto dto) {
		return Member.builder().num(dto.getNum()).name(dto.getName()).addr(dto.getAddr()).build();
	}
}
