package data.download.connectUtil;

import java.util.ArrayList;
import java.util.List;

public class StringListTool {
	
	public  List<String> getStringList(String listString){
		List<String> list=new ArrayList<String>();	
		if(listString==null){
			return list;
		}
	
		listString=listString.substring(1, listString.length()-1);
		String[] slist=listString.split(",");
		for(int i=0;i<slist.length;i++){
			try {
				slist[i]=slist[i].substring(1, slist[i].length()-1);
			} catch (Exception e) {
				System.out.println(slist[i]);
			}
			list.add(slist[i]);
		}
		return list;
	}
}
