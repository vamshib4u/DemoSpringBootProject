package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExcuteCommand {
	
	public void excuteCmdScript() {
		Process p;
		try {
			List<String> cmdList = new ArrayList<String>();
            // adding command and args to the list
			///Users/vamshidhar/git/DemoSpringBootProject/src/main/resources/static/shellScript.sh
			
			cmdList.add("/bin/bash");
			cmdList.add("/Users/vamshidhar/git/DemoSpringBootProject/src/main/resources/static/shellScript.sh");
//            cmdList.add("cd /Users/vamshidhar/dev");
//            cmdList.add("mkdir sample");
            ProcessBuilder pb = new ProcessBuilder(cmdList);
            p = pb.start();
                
            p.waitFor(); 
            BufferedReader reader=new BufferedReader(new InputStreamReader(
            p.getInputStream())); 
            String line; 
            while((line = reader.readLine()) != null) { 
                System.out.println(line);
            } 
			
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
