package data.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Info.LocalInfo;

public class MapData {
	
	private static String path="files/mapInfo.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello map!!!");
	}
	/**
	 * 获取地图数据及人员分布信息
	 * @return Map形式数据
	 */
	public Map<String,LocalInfo> getMapData(){
		Map<String,LocalInfo> map=new HashMap<String,LocalInfo>();
		
		String line;
		LocalInfo localInfo;
		
		try {
			
			BufferedReader br =new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null){
				if(line.contains(":")){
					String info[]=line.split(":");
					String local[]=info[1].split(",");
					localInfo=new LocalInfo(local[0],Double.parseDouble(local[1]),
							Double.parseDouble(local[2]), Integer.parseInt(local[3]));
					map.put(info[0], localInfo);
//					System.out.println(info[1]);
				}
				
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	/**
	 * 设置地图数据
	 * @param map
	 * @return 是否设置成功
	 */
	public boolean setMapData(Map<String,LocalInfo> map){
		LocalInfo localInfo;
		String key;
		String line;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
			for (Entry<String, LocalInfo> entry: map.entrySet()) {
			    key = entry.getKey();
			    localInfo = entry.getValue();
			    line=key+":"+localInfo.getSite()+","+String.valueOf(localInfo.getLongtitude()+","+
			    String.valueOf(localInfo.getLatitude())+","+String.valueOf(localInfo.getWorkerNumber())+"\n");
			    
			    bw.write(line);
			}
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return true;
	}
	
}
