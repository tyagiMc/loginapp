import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoginDao {

final static Logger logger = Logger.getLogger(LoginDao.class);	
	
static String myUser = "cjptech123";
static String myPass = "12345";
public static boolean validate(String name,String pass , String ip)
{
	BasicConfigurator.configure();
	if ((name.equals(myUser)) && (pass.equals(myPass)))
	{
		System.out.println(name + " ---- "+ pass);
//		logger.debug(" SUCCESS " + ip +" "+ name );
		return true;
	}
	else
		//logger.debug("ERROR " + ip +" "+name);
		//LoginDao l1 = new LoginDao();
		//l1.runMe("Error");
		return false;
}
private void runMe(String parameter){

	if(logger.isDebugEnabled()){
		logger.debug("This is debug : " + parameter);
	}

	if(logger.isInfoEnabled()){
		logger.info("This is info : " + parameter);
	}

	logger.error("This is error : " + parameter);

}
}
