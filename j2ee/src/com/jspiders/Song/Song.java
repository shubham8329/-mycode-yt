package com.jspiders.Song;
import java.util.Scanner;

import com.jspiders.multiplayer.Multiplayer;
public class Song
{//SongOpearation
	static boolean loop =true;
	static Multiplayer player = new Multiplayer();
    public static void main(String[] args)
    {
    	musicMenu();
    	while(loop){
    		musicMenu();
    	}
    }
        public static void musicMenu() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("******Menu*****");
			System.out.println("1.Add/Remove \n2.Play Song \n3.Edit Song \n4.Exit");
			System.out.println("Enter choice");
			
			int choice = sc.nextInt();
			//String song=sc.next();
			 switch(choice) {
			 case 1:{
			     System.out.println("******Menu*****\n1.Add a song \n2.Remove a Song \n3.Go Back");
			     System.out.println("Enter choice");
			     choice = sc.nextInt();
			     switch(choice) {
			     case 1: {
				    player.addSong();		 
						break;
						}
				case 2: {
				  player.removeSong();
						}
				case 3: {
					break;
					  	}
				}
				loop = true;
				musicMenu();
				break;
			 	}
			 case 2:{
				 System.out.println("\n1.Play all songs \n2.Choose Song \n3.Shuffle \n4.Back");
			     System.out.println("Enter choice");
			     choice = sc.nextInt();
			     int choice1 = sc.nextInt();
			     switch (choice1) {
				case 1:
					player.Playall_Song();
					break;
				case 2:
					player.PickSong_toplay();
					break;
				case 3:
					player.Shuffle();
					break;
				case 4:
					musicMenu();
					loop=false;
					break;
			     }
				}
			 		loop = false;
			 		musicMenu();
			 		break;

			 case 3:{
			     player.Update();
			     loop=false;
			     musicMenu();
			     break;
			 }
			 case 4:{
				 loop=false;
				 System.out.println("thanks for listening songs");
			 		} 
			 	}
		}
        }
		public void setSong_ID(int Song_ID) {
			// TODO Auto-generated method stub
			
		}
		public void setSong_Name(String Song_Name) {
			// TODO Auto-generated method stub
			
		}
		public void setSinger(String Singer) {
			// TODO Auto-generated method stub
			
		}
		public void setLyricist(String Lyricist) {
			// TODO Auto-generated method stub
			
		}
		public void setMovie_Name(String Movie_Name) {
			// TODO Auto-generated method stub
			
		}
		public void setduration(double duration) {
			// TODO Auto-generated method stub
			
		}
		public String getSong_ID() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getSong_Name() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getSinger() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getLyricist() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getMovie_Name() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getduration() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}

