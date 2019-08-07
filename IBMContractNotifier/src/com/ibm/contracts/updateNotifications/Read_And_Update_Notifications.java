package com.ibm.contracts.updateNotifications;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.Contract;
import com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.Notification;

public class Read_And_Update_Notifications {
	
	private Map<String, Integer> numOfNotificationMap = new HashMap<String, Integer>();

	public Contract[] set_no_of_notifications(Contract[] contracts){
		
		read_file_at_map();
				
		for(int i=0;i<contracts.length;i++) {
				
			if(numOfNotificationMap.get(contracts[i].getAccoundID()) != null) {
				int value = numOfNotificationMap.get(contracts[i].getAccoundID());
				
				contracts[i].setNumberOfNotifications(value);
			}
			else {
				
				contracts[i].setNumberOfNotifications(0);
			}
		}
			

		return contracts;
		
	}
	
	private void read_file_at_map(){
		
		File file =new File("notifications");
		BufferedReader br;
		FileReader fr;
		
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
						
			String line = br.readLine();
			
			while (line != null) {

				String[] fields = line.split(",");
				numOfNotificationMap.put(fields[0], Integer.parseInt(fields[1]));
				line = br.readLine();
				
			} 
			br.close();
			fr.close();
			
		} catch (Exception e) {
			
			
		}
		
	}
	
	public void update_file(Notification[] notifications) {
		
		for(int i=0;i<notifications.length;i++) {
			if (!notifications[i].getTarget().equals("")) {
				if(numOfNotificationMap.get(notifications[i].getAccountId()) != null) {
					
					int value = numOfNotificationMap.get(notifications[i].getAccountId()) + 1;
					numOfNotificationMap.put(notifications[i].getAccountId(), value);
				}
				else {
					
					numOfNotificationMap.put(notifications[i].getAccountId(), 1);
				}
			}
		}
		
		write_at_file();
		
	}
	
	
	private void write_at_file() {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("notifications"), "utf-8"));
		    
	    
			for (Map.Entry<String, Integer> entry : numOfNotificationMap.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue());
				writer.write(System.lineSeparator());
			}
		    
			writer.close();
		} catch (IOException ex) {
		  
		} finally {
				try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
	
}





