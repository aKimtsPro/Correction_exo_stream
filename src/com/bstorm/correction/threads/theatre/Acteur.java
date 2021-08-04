package com.bstorm.correction.threads.theatre;

public class Acteur extends Thread {

    private final Script withScript;
    private final long interval;

    public enum Parole{
        BAVARD(1000),
        MOYEN(2000),
        TACITURNE(4000);

        private final long interval;

        Parole(long interval) {
            this.interval = interval;
        }

        public long getInterval() {
            return interval;
        }
    }

    public Acteur(Script withScript, Parole parole, String name, ThreadGroup threadGroup) {
        super(threadGroup,name);
        this.withScript = withScript;
        this.interval = parole.getInterval();
        start();
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                Thread.sleep(interval);
                String line = withScript.getFirstLigne();
                if(!Thread.interrupted())
                    System.out.println(getName() + " - " + line);
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
