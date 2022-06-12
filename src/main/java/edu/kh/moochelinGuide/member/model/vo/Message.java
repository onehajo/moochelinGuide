package edu.kh.moochelinGuide.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Message {

	private int messageNo;
	private String messageContent;
	private String enrollDate;
	private String readFlag;
	private int TargetNo;
	private int MemberNo;
	
	private String memberName;
	private String profileImage;
	
}
