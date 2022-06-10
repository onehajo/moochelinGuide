package edu.kh.moochelinGuide.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Follow {
	
	private int memberNo;
	private String memberName;
	private int targetNo;
	private int evaluationCount;
	private String profileImage;

}
