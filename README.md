# Falling Words Concurrency Game

This game provides a GUI in which words fall concurrently from the top of the display to the bottom at different speeds. When they touch the bottom they disappear
and the number of words missed is incremented. If a word on the screen is typed correctly in the field before reaching the bottom of the display, the number of
words caught is incremented -- the aim of the game being to catch more words than are missed, up to a specified maximum number of total words in the game.

Notes on how to run this code:

1. cd into src directory (location of the makefile)
2. run the command 'make' to compile the code.
3. cd into the bin directory
4. run the command 'java -classpath . skeletonCodeAssgnmt4.WordApp 10 5 example_dict.txt'
     - 10 represents the first command line paramter - maximum number of words to be caught/missed
     - 5 represents the second command line parameter - number of words visible on the screen
     - example_dict.txt represents the third command line paramter - the input text file

Email me at jacktevers@gmail.com if you have any issues.
Thanks, Jack.
