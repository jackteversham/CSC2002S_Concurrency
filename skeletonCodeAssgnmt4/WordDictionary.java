package skeletonCodeAssgnmt4;

public class WordDictionary {
	int size;
	static String [] theDict= {"litchi","banana","apple","mango","pear","orange","strawberry",
		"cherry","lemon","apricot","peach","guava","grape","kiwi","quince","plum","prune",
		"cranberry","blueberry","rhubarb","fruit","grapefruit","kumquat","tomato","berry",
		"boysenberry","loquat","avocado"}; //default dictionary
	
	WordDictionary(String [] tmp) { //replaces the default word dictionary with the passed in tmp dictionary
		size = tmp.length;
		theDict = new String[size];
		for (int i=0;i<size;i++) {
			theDict[i] = tmp[i];
		}
		
	}
	
	WordDictionary() { //generic constructor for default dictionary
		size=theDict.length;
	}
	
	public synchronized String getNewWord() {
		int wdPos= (int)(Math.random() * size);
		return theDict[wdPos];
	}
	
}
