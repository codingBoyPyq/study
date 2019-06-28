package com.pyq.study;

import javazoom.jl.player.Player;
import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Alarm extends Applet implements Runnable{
    public static String sound = "/Users/pangyueqiang/Music/alarmClock.mp3";
    @Override
    public void run() {
        try{
            loopPlay();
        }
        catch (Exception e){}
    }
    private Player initPlayer() throws Exception{
        File file = new File(sound);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream stream = new BufferedInputStream(fis);
        return new Player(stream);
    }
    private  void loopPlay() throws Exception{
        Player player = initPlayer();
        Thread t = new Thread(new ClockThread(player));
        t.start();
        while(true){
            if(player.isComplete() && !t.isAlive()){
                player = initPlayer();
                t = new Thread(new ClockThread(player));
                t.start();
            }
        }
    }
}
