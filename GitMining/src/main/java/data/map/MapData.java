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

import Info.AddressInfo;

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
	public Map<String,AddressInfo> getMapData(){
		Map<String,AddressInfo> map=new HashMap<String,AddressInfo>();
		
		String line;
		AddressInfo addressInfo;
		
		try {
			
			BufferedReader br =new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null){
				if(line.contains(":")){
					String info[]=line.split(":");
					String local[]=info[1].split(",");
					addressInfo=new AddressInfo(local[0],Double.parseDouble(local[1]),
							Double.parseDouble(local[2]), Integer.parseInt(local[3]));
					map.put(info[0], addressInfo);
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
	public boolean setMapData(Map<String,AddressInfo> map){
		AddressInfo addressInfo;
		String key;
		String line;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
			for (Entry<String, AddressInfo> entry: map.entrySet()) {
			    key = entry.getKey();
			    addressInfo = entry.getValue();
			    line=key+":"+addressInfo.getSite()+","+String.valueOf(addressInfo.getLongtitude()+","+
			    String.valueOf(addressInfo.getLatitude())+","+String.valueOf(addressInfo.getWorkerNumber())+"\n");
			    
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
