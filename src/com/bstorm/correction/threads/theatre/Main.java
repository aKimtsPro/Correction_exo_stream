package com.bstorm.correction.threads.theatre;

import static com.bstorm.correction.threads.theatre.Acteur.Parole.*;

public class Main {

    public static void main(String[] args) {

        Script script = new Script();
        ThreadGroup tg = new ThreadGroup("TG");

        Acteur a1 = new Acteur(script, BAVARD,"Jean", tg);
        Acteur a2 = new Acteur(script, BAVARD,"Pol", tg);
        Acteur a3 = new Acteur(script, BAVARD,"Marie", tg);

        GenerateurPhrase gp1 = new GenerateurPhrase(2000,script,"GP-1", tg);
        GenerateurPhrase gp2 = new GenerateurPhrase(2000,script,"GP-2", tg);
        GenerateurPhrase gp3 = new GenerateurPhrase(2000,script,"GP-3", tg);

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException ignored) {}
        System.out.println("FIN DE LA PIECE");
        tg.interrupt();

    }

}
