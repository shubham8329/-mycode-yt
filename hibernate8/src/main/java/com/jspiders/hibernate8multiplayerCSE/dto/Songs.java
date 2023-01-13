package com.jspiders.hibernate8multiplayerCSE.dto;


	import javax.persistence.Entity;
	import javax.persistence.Id;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor

	public class Songs {
		
		@Id
		private int songid;
		private String songName;
		private String singer;
		private  String album;
		private  double duration;
		private  String lyricsist;
		private  String composer;
		

	}


