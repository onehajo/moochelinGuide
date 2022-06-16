package edu.kh.moochelinGuide.member.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

	private int memberNo;
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private String profileImage;
	private String profileBackImage;
	private String enrollDate;
	private String secessionFlag;
	
	private int followerCount;
	private int followingCount;
	
	private String memberType;
	
	
	// 관리자 인덱스 인포
	private String va;
	private int co;
	
	
}
