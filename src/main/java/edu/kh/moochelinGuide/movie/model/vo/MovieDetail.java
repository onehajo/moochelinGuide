package edu.kh.moochelinGuide.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieDetail {
	
	private int movieNo;
	private String movieTitle ;
	private int releaseYear;
	private String country;
	private String synopsis;
	private String producer;
	private String actor;
	private String posterImage;
	private String detailImage;
	private float starRating;
	
}
