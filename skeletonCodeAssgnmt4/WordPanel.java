package skeletonCodeAssgnmt4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class WordPanel extends JPanel implements Runnable {
		public static volatile boolean done;
		private WordRecord[] words;
		private int noWords;
		private int maxY;
	    private int index = 0; //tracks which thread gets which wordRecord. All threads will call this run method at different times
	                                 //(ensured by a very short delay in the main class) , therefore they will get a different index



		public void paintComponent(Graphics g) {
		    int width = getWidth();
		    int height = getHeight();
		    g.clearRect(0,0,width,height);
		    g.setColor(Color.red);
		    g.fillRect(0,maxY-10,width,height);

		    g.setColor(Color.black);
		    g.setFont(new Font("Helvetica", Font.PLAIN, 26));
		   //draw the words
		   //animation must be added



		    for (int i=0;i<noWords;i++){
				//g.drawString(word.getWord(),word.getX(),word.getY());
		    	g.drawString(words[i].getWord(),words[i].getX(),words[i].getY());  //y-offset for skeleton so that you can see the words
		    }
		   
		  }
		
		WordPanel(WordRecord[] words, int maxY) {
			this.words=words; //will this work?
			noWords = words.length;
			done=false;
			this.maxY=maxY;		
		}



		public void run() {
			//add in code to animate this
            done = false;
			WordRecord word = words[index];
			System.out.println(word.getWord());
			index+=1;

			while(!done){  //continue to animate and check for matching word until done.

				if(WordApp.score.getMissed()==WordApp.totalWords){ //check if total number of allowed words have dropped
					done=true;
					checkFinished.done=true; //set this to true to show the JOptionPane alert (once and not for every thread
					word.resetWord(); //clear screen effectively and reset
					break;
				}

				//ANIMATION
				word.drop(10);
				try{
					Thread.sleep(word.getSpeed());
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
                repaint();

				if(word.dropped()){  //check if word has reached the red zone
					word.resetWord();
					WordApp.score.missedWord();
					WordApp.updateGUI();
				}

				//check if word has been captured (typed correctly)
				String text = WordApp.text;
				if(text.equals(word.getWord())){
					WordApp.score.caughtWord(word.getWord().length());
					word.resetWord();
					WordApp.updateGUI();
				}

				if (done){ //clear screen and set index to zero to allow for the game to be restarted
					word.resetWord();
					index=0;
				}
			}

		}

	}


