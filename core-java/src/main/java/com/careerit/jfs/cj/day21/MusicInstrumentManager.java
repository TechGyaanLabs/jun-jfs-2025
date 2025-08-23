package com.careerit.jfs.cj.day21;

import java.util.concurrent.ThreadLocalRandom;

interface MusicInstrument {
    void play();
}

class Guitar implements MusicInstrument {
    @Override
    public void play() {
        System.out.println("TITIN TITIN TITIN TITIN");
    }
}
class Piano implements MusicInstrument {
    @Override
    public void play() {
        System.out.println("PEPE PEEPE PEEPE PEEPE");
    }
}

class Flute implements MusicInstrument {
    @Override
    public void play() {
        System.out.println("FEEE FEEEEE FEEEEE FEEEEE FEEEEE");
    }
}
public class MusicInstrumentManager {

    public static void main(String[] args) {
        MusicInstrument[] instruments = getInstruments(20);
        // Count the number of piano object
        int pianoCount = 0;
        for(MusicInstrument instrument : instruments){
            if(instrument instanceof Piano){
                pianoCount++;
            }
        }
        System.out.println("Piano count: " + pianoCount);

        for(MusicInstrument instrument : instruments) {
            instrument.play();
        }
    }

    private static MusicInstrument[] getInstruments(int num) {
        MusicInstrument[] instruments = new MusicInstrument[num];
        int index = 0;
        for(int i = 0; i < num; i++){
            int randNum = ThreadLocalRandom.current().nextInt(1,4);
            if(randNum == 1){
                instruments[index++] = new Guitar();
            }else if(randNum == 2){
                instruments[index++] = new Piano();
            }else if(randNum == 3){
                instruments[index++] = new Flute();
            }
        }
        return instruments;
    }
}
