package edu.kh.moochelinGuide.comment.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comment {
	private int commentNo;
	private String commentContent;
	private String commentDate;
	private String commentST;
	private String memberNickname;
	private String profileImage;
	private int memberNo;
}
