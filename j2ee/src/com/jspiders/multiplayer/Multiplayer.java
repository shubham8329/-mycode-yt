package com.jspiders.multiplayer;
import java.util.ArrayList;
import java.util.Scanner;
import com.jspiders.Song.Song;
public class Multiplayer {
		private static final int x = 0;
		ArrayList<Song> music =  new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		static double y;
		
		Song song = new Song();
		
		public void addSong() {
			try {
				System.out.println("How many song you want to add?");
				int count = sc.nextInt();
				for (int i = 0; i < count; i++) {
					
					//Song song = new Song();
					
					System.out.println("Enter Song_ID:");
					int Song_ID = sc.nextInt();
					song.setSong_ID(Song_ID);
					
					System.out.println("Enter Song_Name:");
					String Song_Name = sc.next();
					song.setSong_Name(Song_Name);
					
					System.out.println("Enter Singer:");
					String Singer = sc.next();
					song.setSinger(Singer);
					
					System.out.println("Enter Lyricist");
					String Lyricist = sc.next();
					song.setLyricist(Lyricist);
					
					System.out.println("Enter Movie_Name:");
					String Movie_Name = sc.next();
					song.setMovie_Name(Movie_Name);
					
					System.out.println("Enter duration");
					double duration = sc.nextDouble();
					song.setduration(duration);
					
					music.add(song);
					System.out.println( "song added successfully...!!!");
					System.out.println("\n----------------------------------------------------------------------");
//					music.add(i) new Song();
//					music.get(i).setSong_ID(i + 1);
//					music.get(i).setSong_Name(str1);
//					music.get(i).setSinger(str2);
//					music.get(i).setLyricist(str3);
//					music.get(i).setMovie_Name(str4);
//					music.get(i).setduration(duration);
				}
			} catch (Throwable t) {
				System.out.println("Invalid Input");
			}	
		}
		public void displayAllSong() {
			if (music.isEmpty()== true) {
				System.out.println("Nothing here...!");
				throw new NullPointerException();
			}else 
			for(int k = 1; k < music.size(); k++) {
				System.out.println(music.get(k).getSong_ID() +"" + music.get(k).getSong_Name() + music.get(k).getSinger() + music.get(k).getLyricist() + music.get(k).getMovie_Name() + music.get(k).getduration());	
				
			}
		}
		@SuppressWarnings("unlikely-arg-type")
		public void removeSong() {
			try{
			this.displayAllSong();
			System.out.println("Remove song No:");
			int z = sc.nextInt();
			music.remove(z -1);
			System.out.println("Song Removed..!");
			for (int i = z - 1; i < music.size(); i++) {
				music.get(i).setSong_ID(i + 1);
				music.remove(song.getSong_Name());
				System.out.println(song.getSong_Name() + "song removed successfully...!!!");
			}
		
		}catch (NullPointerException e) {
			System.out.println("Nothing here to play....first add song in list!!");
		}catch(Throwable e1) {
			System.out.println("Nothing in list...!!!");
			}
		}
		public void Playall_Song() {
			if (music.isEmpty()) {
				System.out.println("Nothing in list...!!!");
			}else
				for (int i = 0; i < music.size(); i++) {
					System.out.println(music.get(i).getSong_Name() + "-->Song Played...");
				}
		}
		public void PickSong_toplay() {
			try {
				this.displayAllSong();
				System.out.println("Pick no to play song:");
				int a = sc.nextInt();
				try {
					System.out.println(music.get(a -1).getSong_Name() + "Song is playing");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Sorry...No song found");
				}
			} catch (NullPointerException e) {
				System.out.println("Nothing here to play....first add song in list!!");
			}catch(Throwable e) {
				System.out.println("Invalid Input");
			}		
		}

		public void Shuffle() {
			try {
				if (music.isEmpty()) {
					System.out.println("Nothing in list...!!!");
				}else
					y = (int)((Math.random() * (music.size() - 0 + 1)) + 0);
				System.out.println(music.get((int)x).getSong_Name() + "Song is now playing");
			} catch (Throwable t) {
				// TODO: handle exception
			}			
		}
		public void Update() {
			try {
				displayAllSong();
				System.out.println("Pick Song_ID");
				int s = sc.nextInt();
				System.out.println("1.Song_ID \n 2.Song_Name \n 3.movie name \n 4.lyricist \n 5.duration \n 6.Back");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					System.out.println("Enter New Song_ID");
					music.get(s - 1).setSong_ID(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter New Song_Name");
					music.get(s - 1).setSong_Name(sc.next());
					break;
				case 3:
					System.out.println("Enter New setSinger");
					music.get(s - 1).setSinger(sc.next());
					break;
				case 4:
					System.out.println("Enter New Lyricist");
					music.get(s - 1).setLyricist(sc.next());
					break;
				case 5:
					System.out.println("Enter New Movie_Name");
					music.get(s - 1).setMovie_Name(sc.next());
					break;
				case 6:
					System.out.println("Enter New Duration");
					music.get(s - 1).setduration(sc.nextDouble());
					break;
				case 7:
					break;
				}
			} catch (NullPointerException e) {
				System.out.println("--*Invalid Input*--");
			}catch(Throwable e) {
				System.out.println("--*Invalid Input*--");
		}
	}		
}
