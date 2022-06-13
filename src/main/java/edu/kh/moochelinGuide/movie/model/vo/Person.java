package edu.kh.moochelinGuide.movie.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	private int personNo;
	private String personName;
	private String personJob;
	private String personImage;
	private List<Movie> movieList;

}
