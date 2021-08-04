package com.bstorm.correction.threads.theatre;

import java.util.Random;

public class GenerateurPhrase extends Thread {

    private final long interval;
    private final Script forScript;
    private final Random r = new Random();
    private final static String[] sujet = {
            "Paul",
            "Le Macumba Club",
            "Un incroyable désir de pâte au pesto",
            "Le pitoresque village de Saint-Turquoin-les-Bains",
            "Une éponge"
    };
    private final static String[] verbe = {
            "chante",
            "dance",
            "écrit",
            "annihile",
            "embelli"
    };
    private final static String[] complement = {
            "une mélodie",
            "la macarena",
            "une paëlla",
            "une fête",
            "la lumière"
    };
    private final static String[] adjectif = {
            "sourde",
            "sombre",
            "épicée",
            "sordide",
            "bof"
    };

    public GenerateurPhrase(long interval, Script forScript, String name, ThreadGroup threadGroup) {
        super(threadGroup,name);
        this.interval = interval;
        this.forScript = forScript;
        start();
    }

    private String generateSentence(){
        return sujet[r.nextInt(sujet.length)]+" "+
                verbe[r.nextInt(verbe.length)]+" "+
                complement[r.nextInt(complement.length)]+" "+
                adjectif[r.nextInt(adjectif.length)];
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                Thread.sleep(interval);
                String line = generateSentence();
                forScript.addLigne(line);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
