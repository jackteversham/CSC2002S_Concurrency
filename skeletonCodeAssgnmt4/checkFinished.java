package skeletonCodeAssgnmt4;

import javax.swing.*;

/**
 * Created by jackteversham on 2019/09/26.
 */
public class checkFinished implements Runnable {

    public static volatile boolean done;

    public checkFinished(){}

    public void run(){
        done=false;

        while(true){ //check continuously on this thread to see if word limit has been reached
            if (done){ //done is updated dynamically by the threads allocated to each falling word
                JOptionPane.showMessageDialog(null,"Game Over! You've run out of words\n" +
                        "You scored: "+ WordApp.score.getScore() +" points\n"+
                        WordApp.score.getCaught()+"  words were caught\n" +
                        WordApp.score.getMissed()+" words were missed"+
                        "\nPress start to play again"); //display message
                WordApp.score.resetScore(); //resets all game metrics to zero
                WordApp.updateGUI(); //sets Jlabels to zero
                WordApp.startB.setEnabled(true);
                break;  //get out of loop
            }
        }
    }

}
