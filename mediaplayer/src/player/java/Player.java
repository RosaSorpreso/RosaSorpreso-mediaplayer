package player.java;

import java.util.Scanner;

public class Player {
    /*creo un nuovo array di media, in quale verranno inseriti oggetti con le proprietà specifiche per ogni
      media creato in precedenz l'array avrà una lunghezza di 5, come richiesto dall'esercizio */

    private Media[] array = new Media[5];

    /* questo metodo serve per la creazione del programma vero e proprio, ciclando la lunghezza dell'array media
     chiedo all'utente come prima istruzione, il tipo di media che vuole inserire (di tipo string), questo genererà differenti casi nello switch */

    public  void insertData(){

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di contenuto multimediale");
            String tipe = scanner.nextLine();
            switch(tipe){
                case "audio":
                    System.out.println("Inserisci il titolo della traccia audio");
                    String title = scanner.nextLine();
                    System.out.println("Inserisci il volume che vuoi impostare");
                    int volume = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la durata della traccia");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new Audio(title,volume,duration);
                    break;

                case "video":
                    System.out.println("Inserisci il titolo del video");
                    String title2 = scanner.nextLine();
                    System.out.println("Inserisci il volume che vuoi impostare");
                    int volume2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la durata del video");
                    int duration2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la luminosità del video");
                    int lum = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new Video(title2,volume2,duration2,lum);
                    break;

                case "image":
                    System.out.println("Inserisci il titolo dell'immagine");
                    String title3 = scanner.nextLine();
                    System.out.println("Inserisci la luminosità del immagine");
                    int bright2 = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new Image(title3,bright2);
                    break;

                default:System.out.println("Hai inserito un media non accettato!!");


            }

        }

        /* tramite questo do while chiedo all'utente quale media vuole riprodurre, scegliendo tra i 5 inseriti in precedenza.
         Se l'utente preme 0 invece, termina il programma */

        int i = 0;
        do {
            System.out.println("Inserisci un numero di contenuto multimediale");
            int element = scanner.nextInt();
            if (element == 0){
                break;
            }
            array[element].playMedia();
            i++;

        }while (true);


    }

}
