package com.example.projetgithub;

import javafx.scene.Node;

import java.util.Timer;
import java.util.TimerTask;

class RealiserAlert extends TimerTask {
    private Node node ;
    private Timer timer;

    RealiserAlert(Node node, Timer timer) {
        this.node = node;
        this.timer = timer;
    }

    @Override
    public void run() {
        node.setOpacity(0);
        timer.cancel();
    }
}
