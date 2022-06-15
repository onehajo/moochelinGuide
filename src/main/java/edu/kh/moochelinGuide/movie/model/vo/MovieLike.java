package edu.kh.moochelinGuide.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieLike {
	private int movieLikeNo;
	private int enrollDate;
	private int movieNo;
	private int memberNo;
}
