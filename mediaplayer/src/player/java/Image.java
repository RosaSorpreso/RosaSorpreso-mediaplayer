package player.java;

public class Image extends Media implements Viewable {

    /* creo la classe image che estende media (da cui eredita la proprietà title tramite il super costruttore)
        e implementa l'interfaccia 'viewable' (dato che è un media visibile) */

    private int brightness;
    private static final int minBright = 1;
    private static final int maxBright = 5;

    public Image(String title, int brightness){
        super(title);
        this.brightness = switchSign(brightness);
        setBrightness(brightness);
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

    // creo un metodo che mostra il livello di luminosità

    public void show() {
        String brightnessLevel = "";

        for (int i=0; i<brightness; i++) {
            brightnessLevel += "*";

        }
        System.out.println(title + ": " + brightnessLevel);
    }

    // faccio un override del metodo proveniente dalla classe astratta

    @Override
    public void playMedia() {
        show();
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
