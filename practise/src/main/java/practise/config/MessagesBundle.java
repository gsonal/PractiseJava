package practise.config;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MessagesBundle {

	private String hello;
	
	private String timeLogMsg;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public String getTimeLogMsg() {
		return timeLogMsg;
	}

	public void setTimeLogMsg(String timeLogMsg) {
		DateTime dateTimeVal = new DateTime(DateTimeZone.forID("IST"));
		StringBuffer timeStr = new StringBuffer(timeLogMsg).append(dateTimeVal.toString());
		this.timeLogMsg = timeStr.toString();
	}
	
}
