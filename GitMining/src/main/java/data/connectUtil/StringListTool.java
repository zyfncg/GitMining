package data.connectUtil;

import java.util.ArrayList;
import java.util.List;

public class StringListTool {
	
	public  List<String> getStringList(String listString){
		List<String> list=new ArrayList<String>();
		listString=listString.substring(1, listString.length()-1);
		String[] slist=listString.split(",");
		for(int i=0;i<slist.length;i++){
			slist[i]=slist[i].substring(1, slist[i].length()-1);
			list.add(slist[i]);
		}
		return list;
	}
}
