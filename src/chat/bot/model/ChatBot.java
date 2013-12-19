package chat.bot.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Model for the Chatbot project. Contains methods for evaluating Strings.
 * @author nduc4538
 * @version 1.6 10/30/13
 */
public class ChatBot
{
	/**
	 * Declaration Section to define new ArrayLists.
	 */
	private ArrayList<String> myMemes;
	
	private ArrayList<String> myFoods;
	
	private ArrayList<String> myRandomList;
	
	private ArrayList<String> conversationList;
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	/**
	 * A chatbot Constructor.
	 */
	public ChatBot()
	{
		myMemes = new ArrayList<String>();
		myFoods = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		
		fillTheRandomList();
		fillTheMemeList();
		fillTheFoodList();
		fillTheConversationList();
	}
	
	/**
	 * Helper method to fill the myRandomList with Strings.
	 */
	private void fillTheRandomList()
	{
		myRandomList.add("Penguins");
		myRandomList.add("Something random?");
		myRandomList.add("You don't want that?");
		myRandomList.add("Cat's are cool I guess.");
		myRandomList.add("Is it monday?");
		myRandomList.add("I shouldn't say.");
		myRandomList.add("I like apples.");
	}
	
	/**
	 * Takes the newly created arrays and adds items to it's list.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("My jimmies are rustled.");
		myMemes.add("smile.jpg");
		myMemes.add("iamdisappoint");
		myMemes.add("troll");
		myMemes.add("cats");
		myMemes.add("philosoraptor");
		myMemes.add("dolan");
		
	}
	
	/**
	 * Same as above, except the items are a different category.
	 */
	private void fillTheFoodList()
	{
		myFoods.add("Pizza");
		myFoods.add("Taco");
		myFoods.add("Pineapple");
		myFoods.add("Fruit");
		myFoods.add("Meat");
		myFoods.add("Milk");
		myFoods.add("Bread");
		myFoods.add("Yogurt");
		myFoods.add("Banana");
		myFoods.add("Strawberry");
		myFoods.add("Wheat");
		myFoods.add("Pie");
		myFoods.add("Cake");
		myFoods.add("Burger");
		myFoods.add("Fries");
		myFoods.add("Steak");
		myFoods.add("Chicken");
		myFoods.add("Soda");
		myFoods.add("Water");
		myFoods.add("Pasta");
		myFoods.add("Pancake");
		myFoods.add("Toast");
		myFoods.add("Watermelon");
		myFoods.add("Cheese");
		myFoods.add("Chocolate");
	}
	
	private void fillTheConversationList()
	{
		conversationList.add("Let's talk about video games.");
		conversationList.add("Stop keyboard smashing.");
		conversationList.add("What do you know anyways?");
		conversationList.add("Tell me something I don't know.");
		conversationList.add("I am hillarious.");
		conversationList.add("That's very interesting...");
		conversationList.add("Oh, I do that all the time.");
		conversationList.add("Stop lying to yourself.");
	}
	
	
	/**
	 * Checks whether or not the typed String is in the Meme list.
	 * @param currentPhrase The user input
	 * @return Tells the user if isMeme is true or false.
	 */
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false;
		
		if(currentPhrase !=null)
		{
			for(String currentMeme : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		}
		
		return isMeme;
	}
	
	/**
	 * Checks whether or not the typed String is in the Food list.
	 * @param currentPhrase The user input
	 * @return Tells the user if isMeme is true or false.
	 */
	public boolean foodChecker(String currentPhrase)
	{
		boolean isFood = false;
		
		if(currentPhrase !=null)
		{
			for(String currentFood : myFoods)
			{
				if(currentPhrase.equalsIgnoreCase(currentFood))
				{
					isFood = true;
				}
			}
		}
		
		return isFood;
	}
	
	/**
	 * Method to retrieve a random value from the myRandomList.
	 * @return The String value randomly selected from the list.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandomNumber = Math.random();
		int myRandomListPosition = (int)(myRandomNumber * myRandomList.size());
		randomTopic = myRandomList.get(myRandomListPosition);
		
		return randomTopic;
	}
	
	/**
	 * Gets a set of string(names) and sorts them alphabetically.
	 * @param first - First Name
	 * @param middle - Middle Name
	 * @param last - Last Name
	 * @return The new sorted string.
	 */
	public String putNameinAlphabeticOrder(String first, String middle, String last)
	{
		String sortedName ="";
		
		if(first.compareTo(middle) < 0)
		{
			if(first.compareTo(last) < 0)
			{
				if(middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if(last.compareTo(first) < 0)
				{
					sortedName = middle + ", " + last + ", " + first;
				}
				else
				{
					sortedName = middle + ", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last + ", " + middle + ", " + first;
			}
		}
		
		return sortedName;
	}
	
	/**
	 * Gets user input and returns a value based on it.
	 * @param current - The user's input is stored here.
	 * @return The answer given based on user input.
	 */
	public String usesContent(String current)
	{
		String processedString = "";
		if(current.contains("boo"))
		{
			processedString = "Woo scary";
		}
		else
		{
			processedString = "boooooorrrring";
		}
		return processedString;
	}
	
	/**
	 * Grabs a random item out of the Food Array list.
	 * @return - the value of the random item chosen.
	 */
	public String getRandomFoodItem()
	{
		String randomItemList = "";
		
		double myRandomItem = Math.random();
		int myRandomItemPosition = (int)(myRandomItem * myFoods.size());
		randomItemList = myFoods.get(myRandomItemPosition);
		
		return randomItemList;
	}
	
	public ArrayList<String> conversationPiece()
	{

		return conversationList;
	}
	
	/**
	 * A simple test loop method that will run through the Message 10 times.
	 */
	public void testLoop()
	{
		int loopCount = 1;
		while(loopCount < 10)
		{
			JOptionPane.showMessageDialog(null, "This is the " + loopCount + "'th time around the loop.");
			loopCount++;
		}
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	

}
