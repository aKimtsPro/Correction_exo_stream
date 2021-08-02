package com.bstorm.correction.threads.exo2;

public class Playlist implements Runnable {

    private int currentSong = 0;
    private String[] songs;

    public Playlist(String[] songs) {
        this.currentSong = currentSong;
        this.songs = songs;
    }

    public void next(){
        currentSong++;
    }

    public int getCurrentSong() {
        return currentSong;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try{
                Thread.sleep(5000);
                //System.out.println("NOW PLAYING - " + playlist.get(currentSong));
                System.out.println("NOW PLAYING - " + songs[currentSong]);
                //if(currentSong == playlist.size()-1)
                if(currentSong == songs.length-1)
                    currentSong = 0;
                else
                    currentSong++;
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
