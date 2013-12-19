package chat.bot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.bot.controller.ChatBotController;
import chat.bot.model.ChatBot;

/**
 * 
 * @author nduc4538
 * @version 1.1 10/23/13 Added setupPanel, setupLayout helper methods.
 */

public class ChatBotPanel extends JPanel
{
	private ChatBotController baseController;
	private ChatBot appBot;
	private SpringLayout baseLayout;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private int clickCount;
	
	/**
	 * Creates a ChatBotPanel with a linked ChatBotController object.
	 * 
	 * @param baseController
	 *            The referenced Controller.
	 */
	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;

		this.appBot = baseController.getAppBot();

		submitChatButton = new JButton("Click here to enter your text to the ChatBot!");

		baseLayout = new SpringLayout();
		
		userTextField = new JTextField(30);

		chatArea = new JTextArea(10, 30);

		chatPane = new JScrollPane(chatArea);
		
		clickCount = 0;


		setupPanel();
		setupLayout();
		setupListeners();

		setupChat();
	}

	/**
	 * Starts the ChatBot chat screen with a topic.
	 */
	private void setupChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}

	/**
	 * Loads all components into the panel and sets the layout manager and
	 * color.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLACK);

		this.add(submitChatButton);
		this.add(userTextField);
		this.add(chatPane);
			
				
						chatArea.setWrapStyleWord(true);
						chatArea.setLineWrap(true);

	}

	/**
	 * Setup how we deal with interaction such as a button click. Listeners
	 * checks for user input.
	 */
	private void setupListeners()
	{
		/**
		 * Adds a listener for the clicks.
		 */
		submitChatButton.addActionListener(new ActionListener()
		{
			/**
			 * Do this when the button is clicked. This method is required for a
			 * button to work.
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();
				String first =  appBot.getFirstName();
				String middle = appBot.getMiddleName();
				String last = appBot.getLastName();
				
				if(clickCount % 7 == 0)
				{
					String currentPhrase = baseController.dominateTheConversation();
					
					if(currentPhrase.length() != 0)
					{
						chatArea.append("\n");
						chatArea.append("\n" + currentPhrase);
						clickCount--;
					}
				}
				else if(clickCount == 3)
				{
					JOptionPane.showMessageDialog(null, "Boo! Did I scare you?");
				}
				else if(clickCount == 1)
				{
					setBackground(new Color(192, 192, 192));
				}
				else if(clickCount % 5 == 0)
				{
					chatArea.append("\n");
					chatArea.append(baseController.memeValidation(userInput));
				}
				else if(clickCount % 9 == 0)
				{
					chatArea.append("\n");
					chatArea.append(baseController.foodValidation(userInput));
				}
				else
				{
					chatArea.append("\n" + userInput);
					
					String processedInput = baseController.processUserInput(userInput);
					chatArea.append(processedInput);
					
					userTextField.setText("");
					chatArea.append("\n" + appBot.getRandomTopic());
				}

//this should be a method in the controller that would be returned as a string to place in the chatArea.
//				String me, you, other;
//				me = "Cody";
//				you = "Ryan";
//				other = "Devin";
//				chatArea.append(appBot.putNameinAlphabeticOrder(me, you, other));
				
				
			}
		});

	}

	/**
	 * Places all objects with the computer-generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 24, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -6, SpringLayout.NORTH, submitChatButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -41, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 241, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 101, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 0, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, userTextField, 0, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, userTextField, 6, SpringLayout.SOUTH, submitChatButton);
	}
}
