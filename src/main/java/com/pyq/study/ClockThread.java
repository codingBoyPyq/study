package com.pyq.study;

import javazoom.jl.player.Player;

public class ClockThread implements Runnable{

    public Player player;

    public ClockThread(Player player) {
        this.player = player;
    }
    @Override
    public void run() {
        try{
            player.play();
            player.close();
        }catch (Exception e){
        }
    }
}
