package edu.kh.moochelinGuide.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Movie {

	private int movieNo;
	private String movieTitle;
	private String PosterImage;
	private int releaseYear;
	private String country;
	private String nowShowingFlag;
	private int ticketing;
	private int audience;
	private String sysnopsis;
	private String detailImage;
	private String runningTime;
	
	private float starRating;
	
	
}
