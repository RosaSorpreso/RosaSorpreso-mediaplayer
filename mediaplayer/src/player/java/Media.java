package player.java;

import javax.swing.table.TableRowSorter;

public abstract class Media {

    /* creo una classe astratta Media (genitore) che avrà in comune la proprietà 'title'
    e il metodo 'play' con le classi figlie (audio, video e immagine) */

    protected String title;

    public Media(String title) {
        this.title = title;
    }

    public abstract void playMedia();

}
