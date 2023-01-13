package com.jspiders.hibernate8multiplayerCSE.dao;

import java.util.Scanner;

import com.jspiders.hibernate8multiplayerCSE.Main.MusicPlayerMain;

public class Operations {
	
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void addOrRemoveSong() {

		do {
			System.out.println("================Select an action==============");
			System.out.println("Enter your choice:");
			System.out.println("1:Add song\n2:Removesong\n3:Back");
			System.out.println("-------------------------------------------------");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:

				MusicOperations.addSongs();

				break;

			case 2:
				MusicOperations.removeSongs();
				break;

			case 3:
				MusicPlayerMain.main(null);

			default:
				System.out.println("==========Invalid input========\n Try again  !!");
				break;
			}
		} while (choice != 3);
	}

	public static void playSong() {

		do {
			System.out.println("\n================Select an action==============");
			System.out.println("Enter your choice:");
			System.out.println("1:play all song\n2:choose song\n3:shuffle\n4:back");
			System.out.println("-------------------------------------------------");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:

				MusicOperations.playAll();
				break;

			case 2:
				MusicOperations.chooseSong();
				break;

			case 3:
				MusicOperations.shuffleSongs();
				break;

			case 4:
				MusicPlayerMain.main(null);

			default:
				System.out.println("==========Invalid input========\n Try again  !!");
				break;
			}
		} while (choice != 4);
	}
	
	public static void editSongs() {
		
		MusicOperations.editSong();
		
	}
	
}

