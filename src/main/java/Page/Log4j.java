package Page;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 31.05.2019.
 */
public class Log4j {
    WebDriver driver;
    private static Logger Log;

   public Log4j(WebDriver b) {
       this.driver = b;
       DOMConfigurator.configure("log4j.xml");
       Log = Logger.getLogger(Log4j.class.getName());
   }

    public Logger GetLogger(){
       return Log;
    }

}
