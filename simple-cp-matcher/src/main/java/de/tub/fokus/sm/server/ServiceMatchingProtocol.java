package de.tub.fokus.sm.server;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOExceptionWithCause;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServiceMatchingProtocol {
	
    public String processInput(String input) throws IOException {
    	String output = null;
    	JSONParser parser = new JSONParser();

    	try {
    		JSONObject root = (JSONObject) parser.parse(input);
    		if(!root.containsKey("action") ||
    		   !root.containsKey("parameter")) {
    			throw new IOException("Request invalid. Specify action and parameter.");
    		} else {
    			String action = (String) root.get("action");
    			if(action.equalsIgnoreCase("QUERY")) {
    				output = "QUERY DETECTED.";
    			} else if(action.equalsIgnoreCase("ADD-TO-REPOSITORY")) {
    				output = "ADD-TO-REPOSITORY DETECTED.";
    			}
    		}		
		} catch (ParseException e) {
			JSONObject obj = new JSONObject();
			obj.put("error", e.getMessage());			
			StringWriter out = new StringWriter();
		    obj.writeJSONString(out);
		    output = out.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		
    	}
		return output;
    }

	private void raiseJsonMailFormedException() {
		// TODO Auto-generated method stub
		
	}
    

}
