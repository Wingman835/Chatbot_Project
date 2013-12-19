package chat.bot.view;

import javax.swing.JFrame;

import chat.bot.controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotController baseController;
	private ChatBotPanel basePanel;
	
	/**
	 * Create's a new ChatBot Panel.
	 * @param baseController variable name of the controller
	 */
	public ChatBotFrame(ChatBotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatBotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Initializes the frame and adds it's content pane.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
