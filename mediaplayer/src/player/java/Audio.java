package player.java;

public class Audio extends Media implements Playable {

    /* creo la classe audio che estende media (da cui eredita la proprietà title tramite il super costruttore)
    e implementa l'interfaccia 'playable' dato che è un media riproducibile */

    private int volume;
    private final int duration;
    private static final int min = 0;
    private static final int max = 10;

    public Audio(String title, int volume, int duration){
        super(title);
        this.volume = switchSign(volume);
        this.duration = switchSign(duration);
        setVolume(volume);
    }


    // creo un metodo che permette di impostare il volume con un valore numerico in input

    private void setVolume(int volume) {
        if (volume >= min && volume <= max) {
            this.volume = volume;
        } else {
            System.out.println("Il volume deve essere compreso tra " + min + " e " + max);
        }
    }

    // creo un metodo per rendere positivo il valore

    private int switchSign(int value){
        if(value < 0) value = -value;
        return value;
    }

    // faccio un overriede del metodo per alzare il volume

    @Override
    public void volumeUp(){
        if (volume < 10) {
            volume++;
            System.out.println("Volume alzato a " + volume);
        } else {
            System.out.println("Volume già al massimo");
        }
    }

    // faccio un overriede del metodo che abbassa il volume

    @Override
    public void volumeDown() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume abbassato a " + volume);
        } else {
            System.out.println("Volume già al minimo");
        }
    }

    // faccio un overriede del metodo play presente nell'interfaccia playable

    @Override
    public void play() {
        String volumeLevel = "";

        for (int i=0; i<volume; i++) {
            volumeLevel += "!";
        }
        for (int i=0; i<duration; i++){
            System.out.println(title + ": " + volumeLevel);
        }

    }

    // faccio un override del metodo proveniente dalla classe astratta

    @Override
    public void playMedia() {
        play();
    }
}
