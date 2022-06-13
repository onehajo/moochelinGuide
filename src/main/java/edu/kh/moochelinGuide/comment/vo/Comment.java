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
	private int comentNo;
	private String comnetContent;
	private String comentDate;
	private String comentST;
	private String memberNickname;
}
