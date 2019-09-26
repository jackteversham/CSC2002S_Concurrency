package skeletonCodeAssgnmt4;

import javax.swing.*;

/**
 * Created by jackteversham on 2019/09/26.
 */
public class checkFinished implements Runnable {

    public static volatile boolean done;

    public checkFinished(){}

    public void run(){
        System.out.println("STARTED");
        done=false;

        while(true){ //check continuously on main thread to see if word limit has been reached, could implement this with another THREAD
            if (done){
                JOptionPane.showMessageDialog(null,"Game Over! You've run out of words\nPress start to play again");
                WordApp.score.resetScore(); //resets all game metrics to zero
                WordApp.updateGUI(); //sets Jlabels to zero
                break;
            }

        }
    }

}
