package practise;

import io.dropwizard.Configuration;
import practise.config.MessagesBundle;


public class ApplicationConfig extends Configuration {

	private MessagesBundle messages;

	public MessagesBundle getMessages() {
		return messages;
	}

	public void setMessages(MessagesBundle messages) {
		this.messages = messages;
	}
	
}
