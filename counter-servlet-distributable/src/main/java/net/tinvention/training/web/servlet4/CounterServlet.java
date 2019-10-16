// @formatter:off
/*******************************************************************************
 *    Copyright 2018, Tinvention SRL
 *    This project includes software developed by Tinvention SRL .
 *    http://tinvention.net/
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the Licens
 *    
 *******************************************************************************/
// @formatter:on
package net.tinvention.training.web.servlet4;

import java.io.IOException;
import java.net.InetAddress;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class CounterServlet extends HttpServlet {
	
	private static final String SESSION_COUNTER_KEY = "SESSION_COUNTER";
	private AtomicInteger applicationCounter = new AtomicInteger(); 

	private final Logger LOGGER = Logger.getLogger(CounterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	LOGGER.info("called");
    	LOGGER.fine("called by : " + request.getRemoteHost());
    	
    	// @formatter:off
    	String stringPageTemplate = 
    			"	<!DOCTYPE HTML>" +
    			"	<html>" + 
    			"    	<head><title>Distributable Servlet 4.0 Demo</title></head>" + 
    			"    	<body>" + 
    			"    	    <h1>This is a Distributable Servlet 4.0 Example</h1>" + 
    			"    	    </br>" + 
    			"    	    <p>Server Host Name: {0}</p>" + 
    			"    	    </br>" + 
    			"    	    <p>Calls from current browser: {1}</p>" + 
    			"    	    </br>" + 
    			"    	    <p>Total Calls on this node: {2}</p>" + 
    			"    	</body>" + 
    			"    	</html>";
    	
    	Integer sessCounter = 
    			request.getSession().getAttribute(SESSION_COUNTER_KEY) == null ? 
    					Integer.valueOf(0) : (Integer)request.getSession().getAttribute(SESSION_COUNTER_KEY);  	
    	request.getSession().setAttribute(SESSION_COUNTER_KEY, ++sessCounter);
 
		String outputBodycontent = MessageFormat.format(
				stringPageTemplate, 
				InetAddress.getLocalHost().getCanonicalHostName(), 
				sessCounter, applicationCounter.incrementAndGet()); 
		// @formatter:on

		//Send contents to browser
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(outputBodycontent); 

    }
}