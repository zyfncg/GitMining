package data.connectUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestUtil {
	/** 
     * 通过url返回数据的字符串
     * 
     * @param requestUrl 
     * @return  数据字符串
     */ 
    public static String httpRequest(String requestUrl)throws Exception { 
        StringBuffer sb = new StringBuffer(); 
        InputStream ips = getInputStream(requestUrl); 
        InputStreamReader isreader = null; 
        
        if(ips==null){	
    		System.out.println("Connnet Wrong");
    		return null;
//    		throw new Exception();
    	}
        
        try { 
        	
            isreader = new InputStreamReader(ips, "utf-8"); 
        } catch (UnsupportedEncodingException e) { 
//            e.printStackTrace();
            throw e;
        } 
        BufferedReader bufferedReader = new BufferedReader(isreader); 
        String temp = null; 

        try { 
            while ((temp = bufferedReader.readLine()) != null) { 
                sb.append(temp); 
            } 
            bufferedReader.close(); 
            isreader.close(); 
            ips.close(); 
            ips = null; 
        } catch (IOException e) { 
            e.printStackTrace();
            return null;
        } 
        return sb.toString(); 
    }
    
    /** 
     * 通过URL获得输入流
     * @param requestUrl 
     * @return InputStream 
     */ 
    private static InputStream getInputStream(String requestUrl) throws Exception{ 
        URL url = null; 
        HttpURLConnection conn = null; 
        InputStream in = null; 

        try { 
            url = new URL(requestUrl); 
        } catch (MalformedURLException e) { 
            e.printStackTrace();
            throw e;
        } 
        try { 
            conn = (HttpURLConnection) url.openConnection(); 
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);
            conn.setDoInput(true); 
            conn.setRequestMethod("GET"); 
            conn.connect(); 

            in = conn.getInputStream(); 
        } catch (IOException e) { 
//            e.printStackTrace();
            return null;
        } 
        return in; 
    }
}
