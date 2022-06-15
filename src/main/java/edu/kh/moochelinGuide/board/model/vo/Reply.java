package edu.kh.moochelinGuide.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reply {
	private String memberNm;
	private String content;
	private int boardNo;
	private int replyNo;
	private int memberNo;
	private String memberType;
}
