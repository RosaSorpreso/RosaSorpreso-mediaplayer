package player.java;

public class Video extends Media implements Playable, Viewable{

     /* creo la classe video che estende media (da cui eredita la proprietà title tramite il super costruttore)
        e implementa l'interfaccia 'playable' (dato che è un media riproducibile) e l'interfaccia 'viewable'
        (dato che è un media visibile) */

    private int volume;
    private int duration;
    private int brightness;
    private static final int minVol = 0;
    private static final int maxVol = 10;
    private static final int minBright = 1;
    private static final int maxBright = 5;

    public Video(String title, int volume, int duration, int brightness){
        super(title);
        this.volume = switchSign(volume);
        this.duration = switchSign(duration);
        this.brightness = switchSign(brightness);
        setBrightness(brightness);
        setVolume(volume);
    }

    // creo un metodo che permette di impostare il volume con un valore numerico in input

    private void setVolume(int volume) {
        if (volume >= minVol && volume <= maxVol) {
            this.volume = volume;
        } else {
            System.out.println("Il volume deve essere compreso tra " + minVol + " e " + maxVol);
        }
    }

    // creo un metodo che permette di impostare la luminosità con un valore numerico in input

    private void setBrightness(int brightness) {
        if (brightness >= minBright && brightness <= maxBright) {
            this.brightness = brightness;
        } else {
            System.out.println("La luminosità deve essere compresa tra " + minBright + " e " + maxBright);
        }
    }

    // creo un metodo per rendere positivo il valore

    private int switchSign(int value){
        if(value < 0) value = -value;
        return value;
    }

    // faccio un override del metodo proveniente dalla classe astratta

    @Override
    public void playMedia() {
        play();
    }

    // faccio un overriede del metodo play presente nell'interfaccia playable

    @Override
    public void play() {
        String volumelevel = "";
        String brightnessLevel = "";

        for (int i=0; i<volume; i++) {
            volumelevel += "!";
        };
        for(int i=0; i<brightness; i++){
            brightnessLevel += "*";
        }
        for (int i=0; i<duration; i++){
            System.out.println(title + ": " + volumelevel + ", " + brightnessLevel);
        }

    }

    // faccio un overriede del metodo per alzare il volume

    @Override
    public void volumeUp() {
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

    // faccio un overriede del metodo che alza la luminosità

    @Override
    public void brightnessUp() {
        if (brightness < 5) {
            brightness++;
            System.out.println("Luminosità alzata a " + brightness);
        } else {
            System.out.println("Luminosità al massimo");
        }
    }

    // faccio un overriede del metodo che abbassa la luminosità

    @Override
    public void brightnessDown() {
        if (brightness > 1) {
            brightness--;
            System.out.println("Luminosità abbassata a " + brightness);
        } else {
            System.out.println("Luminosità già al minimo");
        }
    }
}
