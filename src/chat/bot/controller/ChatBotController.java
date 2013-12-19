package chat.bot.controller;

import java.util.ArrayList;

import chat.bot.model.ChatBot;
import chat.bot.view.ChatBotFrame;

/**
 * 
 * @author nduc4538
 * @version 1.3 10/23/13 Adding model to the project and changed GUI load. Added a getter for the chatBot.
 * Removed the references to the popup view. Added documentation.
 */

public class ChatBotController
{
	/**
	 * The application frame for the chatbot program.
	 */
	private ChatBotFrame appFrame;
	
	/**
	 * The main ChatBot for the application.
	 */
	private ChatBot appBot;
	    
		/**
	     * Creates a ChatBotController and initializes the ChatBot model instance.
	     */
	public ChatBotController()
	{
		//	chatAppView = new ChatBotView();
			appBot = new ChatBot();
	}
	/**
	 * Getter method for the ChatBot Instance.
	 * @return The ChatBot for the application.
	 */
	public ChatBot getAppBot()
	{
			return appBot;
	}

	/**
	 * Initializes the ChatBotFrame for the GUI.
	 */
	public void start()
	{
		appFrame = new ChatBotFrame(this);
	}

	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talking about the memes!";
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is the coolest meme ever.";
		}
		return memeReaction;
	}
	
	public String foodValidation(String currentInput)
	{
		String foodReaction = "I love food more then you do.";	
		if(appBot.foodChecker(currentInput))
		{
			foodReaction = "I had " + currentInput + " for breakfast today." + "\n But I really love " + appBot.getRandomFoodItem();
		}
		return foodReaction;
				
	}
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());

		return currentConversationPiece;
	}
	
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if (appBot.memeChecker(currentInput))
		{
			response = "I hate memes.";
		}
		
		else if(appBot.foodChecker(currentInput))
		{
			response = (currentInput + " is nasty. " + "I like " + appBot.getRandomFoodItem() + " better.");
		}
		return "\n" + response ;
	}
}
