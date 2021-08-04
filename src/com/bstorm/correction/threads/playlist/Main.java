package com.bstorm.correction.threads.playlist;

import java.util.Scanner;

public class Main {

    static int currentSong = 0;
    static String[] chansons =
            {
                    "chanson0",
                    "chanson1",
                    "chanson2",
                    "chanson3",
                    "chanson4",
                    "chanson5",
                    "chanson6",
                    "chanson7",
                    "chanson8",
                    "chanson9"
            };
    // static List<String> playlist = Arrays.asList(chansons);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Thread t = new Thread( Main::action );
        //boolean paused = false;

        t.start();
        String cmd = null;
        do{
            cmd = sc.nextLine();
            switch (cmd){
                case "pause":
                    t.interrupt();
                    System.out.println("Playlist mise en pause");
                    break;
                case "play":
                    //if( paused )
                    if (t.getState() == Thread.State.TERMINATED) {
                        System.out.println("Playlist remise en play");
                        t = new Thread( createAction() );
                        t.start();
                    }
                    else
                        System.out.println("!!!play avant pause!!!");
                    break;
                case "reset":
                    currentSong = 0;
                    System.out.println("Playlist reset");
                    break;
                default:
                case "stop":
                    t.interrupt();
                    System.out.println("Playlist stoppée");
                    break;
            }

        }while (!cmd.equals("stop"));
    }

    static Runnable createAction(){
        return () -> {
            while(!Thread.interrupted()){
                try{
                    Thread.sleep(5000);
                    //System.out.println("NOW PLAYING - " + playlist.get(currentSong));
                    System.out.println("NOW PLAYING - " + chansons[currentSong]);
                    //if(currentSong == playlist.size()-1)
                    if(currentSong == chansons.length-1)
                        currentSong = 0;
                    else
                        currentSong++;
                }catch (InterruptedException e){
                    return;
                }
            }
        };
    }


    static void action(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(5000);
                //System.out.println("NOW PLAYING - " + playlist.get(currentSong));
                System.out.println("NOW PLAYING - " + chansons[currentSong]);
                //if(currentSong == playlist.size()-1)
                if(currentSong == chansons.length-1)
                    currentSong = 0;
                else
                    currentSong++;
            }catch (InterruptedException e){
                return;
            }
        }
    }

}
