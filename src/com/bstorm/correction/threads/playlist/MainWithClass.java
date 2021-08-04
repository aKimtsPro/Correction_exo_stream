package com.bstorm.correction.threads.playlist;

import java.util.Scanner;

public class MainWithClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Playlist p = new Playlist(new String[]{
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
        });
        Thread t = new Thread( p );
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
                        t = new Thread( p );
                        t.start();
                    }
                    else
                        System.out.println("!!!play avant pause!!!");
                    break;
                case "reset":
                    p.next();
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
}
