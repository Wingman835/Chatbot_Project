package chat.bot.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatBotRunner
{

	public static void main(String[] args)
	{
		ChatBotController chatApp = new ChatBotController();
		chatApp.start();

		JPanel myApp = new JPanel();
		myApp.setSize(300, 300);
		myApp.setVisible(true);
	}

}
