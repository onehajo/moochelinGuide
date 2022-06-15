package edu.kh.moochelinGuide.board.model.vo;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {
	private int boardNo;
	private String boardTit;
	private String content;
	private String createDate;
	private String updateDate;
	private int readCount;
	private String boardSt;
	private int memberNo;
	private int boardCode;
	private String memberNm;
	private long dateCalcul;
	private long dateCalcul2;
	private String msg;
	private String msg2;
	private List<BoardImage> imageList;
	private String link;
}
