package edu.kh.moochelinGuide.coment.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Coment {
	private int comentNo;
	private String comnetContent;
	private String comentDate;
	private String comentST;
	private String memberNickname;
}
