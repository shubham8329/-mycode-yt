package com.jspiders.hibernate8multiplayerCSE.Main;
	

	import java.util.Scanner;

	import com.jspiders.hibernate8multiplayerCSE.dao.Operations;



	public class MusicPlayerMain {
		private static int choice;
		private static int choice1 = 0;
		private static Scanner sc = new Scanner(System.in);

		public static void main(String args[]) {
			do {
				System.out.println("===============MENU=============");
				System.out.println("Enter your choice:");
				System.out.println("1:Add/remove song\n2:Play song\n3:Edit song\n4:Exit");
				choice = sc.nextInt();
				switch (choice) {
				case 1:

					do {
						Operations.addOrRemoveSong();

					} while (choice1 != 3);

					break;

				case 2:
					do {
						Operations.playSong();

					} while (choice1 != 4);

					break;

				case 3:
					do {
					Operations.editSongs();
					} while (true);

				case 4:
					System.out.println("*********THANK YOU********");
					System.exit(0);

				default:
					System.out.println("invalid choice ...\nTry again....!!");

					break;
				}
			} while (choice != 4);
		}

	}

