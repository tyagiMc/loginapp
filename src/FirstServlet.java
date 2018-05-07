import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {
	static String ip;
//	public String getClientIpAddress(HttpServletRequest request) {
//	    String xForwardedForHeader = request.getHeader("X-Forwarded-For");
//	    if (xForwardedForHeader == null) {
	    	//ip = xForwardedForHeader;
	        
//	        return request.getRemoteAddr();
//	    } else {
	    	//ip = xForwardedForHeader;
	     
	    	 
//	    	return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
//	    }
//	}
	
	
	private static Logger logger = Logger.getLogger(FirstServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		BasicConfigurator.configure();
		String n=request.getParameter("username");
		String p=request.getParameter("userpass");
	
		ip = request.getHeader("host");
		String ip1 = request.getRemoteAddr();
		String browser = request.getHeader("user-agent");
		
		
		
		if(LoginDao.validate(n, p , ip)){
			logger.info(" INFO "+ ip1 + " " + n + " " + ip + " "+ browser);
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			rd.forward(request,response);
		}
		else{
			logger.info(" ERROR "+ ip1 + " " + n +" " + ip + " " + browser + " password Incorrect ");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		out.close();
	}
}