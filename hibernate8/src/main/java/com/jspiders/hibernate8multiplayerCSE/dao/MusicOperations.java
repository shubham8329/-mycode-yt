package com.jspiders.hibernate8multiplayerCSE.dao;


	

	import java.util.List;
	import java.util.Scanner;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	import com.jspiders.hibernate8multiplayerCSE.dto.Songs;
	public class MusicOperations {

		private static EntityManagerFactory factory;
		private static EntityManager manager;
		private static EntityTransaction transaction;
		private static Scanner scanner = new Scanner(System.in);
		private static int id;
		private static String songName;
		private static String singer;
		private static String album;
		private static double duration;
		private static String lyricsist;
		private static String composer;
		private static Query query;
		private static String jpqlQuery;
		private static List<Songs> resultList;
		private static int choice;

		private static void openConnection() {

			factory = Persistence.createEntityManagerFactory("musicplayer");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

		}

		private static void closeConnection() {

			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
			if (transaction.isActive()) {
				transaction.rollback();
			}

		}

		public static void addSongs() {

			openConnection();
			transaction.begin();
			Songs songs = new Songs();
			
			System.out.println("Enter song id:");
			id = scanner.nextInt();
			scanner.nextLine();
			songs.setSongid(id);

			System.out.println("Enter song name :");
			songName = scanner.nextLine();
			songs.setSongName(songName);

			System.out.println("Enter singer name:");
			singer = scanner.nextLine();
			songs.setSinger(singer);

			System.out.println("Enter album/movie name:");
			album = scanner.nextLine();
			songs.setAlbum(album);

			System.out.println("Enter duration of the song:");
			duration = scanner.nextDouble();
		
			songs.setDuration(duration);

			System.out.println("Enter lyricsist name:");
			scanner.nextLine();
			lyricsist = scanner.nextLine();
			songs.setLyricsist(lyricsist);

			System.out.println("Enter composer name:");
			composer = scanner.nextLine();
			songs.setComposer(composer);
			manager.persist(songs);

			transaction.commit();
			System.out.println(songName + " added to the list successfully");
			
			closeConnection();

		}

		@SuppressWarnings("unchecked")
		public static void removeSongs() {

			openConnection();
			transaction.begin();

			jpqlQuery = "from Songs";
			query = manager.createQuery(jpqlQuery);

			resultList = query.getResultList();

			for (Songs songs : resultList) {
				System.out.println(songs);
			}

			System.out.println("Which song you want to delete:\nEnter Id");
			id = scanner.nextInt();

			Songs songs = manager.find(Songs.class, id);
			manager.remove(songs);

			transaction.commit();
			closeConnection();

		}

		@SuppressWarnings("unchecked")
		public static void chooseSong() {

			openConnection();
			transaction.begin();

			jpqlQuery = "from Songs";
			query = manager.createQuery(jpqlQuery);

			resultList = query.getResultList();

			for (Songs songs : resultList) {
				System.out.println(songs);
			}

			System.out.println("Choose song:\nEnter id:");
			id = scanner.nextInt();

			Songs songs = manager.find(Songs.class, id);

			String str = songs.getSongName() + " is playing.....";
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {

				System.out.print(arr[i]);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			transaction.commit();
			closeConnection();

		}

		@SuppressWarnings("unchecked")
		public static void playAll() {

			openConnection();
			transaction.begin();

			jpqlQuery = "from Songs";
			query = manager.createQuery(jpqlQuery);

			resultList = query.getResultList();

			for (Songs songs : resultList) {
				String str = songs.getSongName() + " is playing...";
				System.out.println(str);

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			transaction.commit();
			closeConnection();

		}

		@SuppressWarnings("unchecked")
		public static void editSong() {

			openConnection();
			transaction.begin();
			
			jpqlQuery = "from Songs";
			query = manager.createQuery(jpqlQuery);

			resultList = query.getResultList();

			for (Songs songs : resultList) {
				System.out.println(songs);
			}

			System.out.println("enter song id");
			id = scanner.nextInt();

			Songs songs = manager.find(Songs.class, id);

			System.out.println("Which fiels you want to update" + "\n 1: Song name" + "\n 2:Singer name" + "\n 3:Album name"
					+ "\n 4:Duration" + "\n 5:Composer name");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter new song name :");
				songName = scanner.nextLine();
				songs.setSongName(songName);
			break;
			
			case 2:
				System.out.println("Enter new singer name :");
				singer = scanner.nextLine();
				songs.setSinger(singer);
			break;
			
			case 3:
				System.out.println("Enter new album/movie  name :");
				album = scanner.nextLine();
				songs.setAlbum(album);
			break;
			
			case 4:
				System.out.println("Enter new duration :");
				duration = scanner.nextDouble();
				songs.setDuration(duration);
			break;
			
			case 5:
				System.out.println("Enter new lyricsist name :");
				lyricsist = scanner.nextLine();
				songs.setLyricsist(lyricsist);
			break;
			
			case 6:
				System.out.println("Enter new composer name :");
				composer = scanner.nextLine();
				songs.setComposer(composer);
			break;
			
			case 7:
				MusicOperations.editSong();
				
			default:
				System.out.println("--------Invalid choice--------");
			break;

			}

			transaction.commit();
			closeConnection();

		}
		
		@SuppressWarnings("unchecked")
		public static void shuffleSongs() {
			
			openConnection();
			transaction.begin();
			
			jpqlQuery = "from Songs";
			query = manager.createQuery(jpqlQuery);

			resultList = query.getResultList();

			for (Songs songs : resultList) {
				System.out.println(songs);
			}
			
			int rand = (int) (Math.random() * resultList.size()) + 1;
			System.out.println(rand);
			
			Songs songs = manager.find(Songs.class, rand);

			String str = songs.getSongName() + " is playing.....";
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {

				System.out.print(arr[i]);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			
			transaction.commit();
			closeConnection();
			
		}
	}


