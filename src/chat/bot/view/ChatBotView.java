package chat.bot.view;

import javax.swing.JOptionPane;
import chat.bot.model.ChatBot;

public class ChatBotView
{
	/**
	 * Declaration section for a new ChatBot.
	 */
	private ChatBot myChatBot;
	
	public ChatBotView()
	{
		myChatBot = new ChatBot();
	}
	
	public void showApp()
	{

		String input = "Keep going.";
		
		while(input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myChatBot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		//myChatBot.testLoop();
		myChatBot.conversationPiece();
	}
	/**
	 * Captures the users input based on a question.
	 * @return The String object typed by the user.
	 */
	private String getInput()
	{
		String input = "";
		
		input = JOptionPane.showInputDialog("What would you like to talk about?");
		
		return input;
	}
	
	/**
	 * Displays the input into a String.
	 * @param userInput The String of the user input is plugged into here.
	 */
	private void useInput(String userInput)
	{
		if(myChatBot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput + " is a meme.");
		}
		else if(myChatBot.foodChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, userInput + " is actually my favorite food.");

		}
		else
		{
		JOptionPane.showMessageDialog(null, "I don't know what " + userInput + " is..");
		}
	}
}
