package practise;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestApplication extends Application<ApplicationConfig>  {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

	@Override
	public void initialize(Bootstrap<ApplicationConfig> appConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(ApplicationConfig appConfig, Environment env) throws Exception {
		if(appConfig != null) {
			System.out.println("Greeting User: " + appConfig.getMessages().getHello());
			System.out.println("Log Time: " + appConfig.getMessages().getTimeLogMsg());
		}
		
	}

}
