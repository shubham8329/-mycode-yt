package com.jspiders.songoperation;
public class SongOperation 
{//song
		
		int Song_ID;
		private String Song_Name;//data
		String Singer;
		String Lyricist;
		private String Movie_Name;
		double duration;
		public int getSong_ID()
		{
			return Song_ID;
		}
		public void setSong_ID(int Song_ID)
		{
			this.Song_ID=Song_ID;
		}
		//NSM:getter method of Song_Name
		public String getSong_Name()
		{
			return Song_Name;
		}
		public void setSong_Name(String Song_Name)
		{
			 this.Song_Name=Song_Name;
		}
		public String getSinger()
		{
			return Singer;
		}
		public void setSinger(String Singer)
		{
			this.Singer=Singer;
		}
		public String getLyricist()
		{
			return Lyricist;
		}
		public void setLyricist(String Lyricist)
		{
			this.Lyricist=Lyricist;
		}
		//NSM:setter method of Song_Name
	
		public String getMovie_Name()
		{
			return Movie_Name;
		}
		//NSM:setter method of Movie_Name
		public void setMovie_Name(String Movie_Name)
		{
			this.Movie_Name=Movie_Name;	
		}
		public double getduration() {
			return duration;
		}
		public void setduration(double duration) {
			this.duration=duration;
		}
		
		public String toString() {
			return "" + Song_ID + "|" + Song_Name + "|" + Singer + "|" +  Lyricist + "|" +  Movie_Name+ "|" + duration + "\n";
		}

		
}