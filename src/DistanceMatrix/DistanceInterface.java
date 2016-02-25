package DistanceMatrix;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;


public class DistanceInterface 
{
 Integer tem;
 Float dist;
 Float dur;
 


 private static String readAll(Reader rd) throws IOException 
 {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) 
    {
      sb.append((char) cp);
    }
    return sb.toString();
 }
 
 public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException 
 {
    InputStream is = new URL(url).openStream();
    try 
    {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    }
    finally 
    {
      is.close();
    }
 }


 public float[] calcDistance(StringBuffer beg, StringBuffer end, String mode) 
 {
  JSONObject json=null;
  try 
  {
  
   //System.out.print("build url is" +"https://maps.googleapis.com/maps/api/distancematrix/json?origins="+beg+"&destinations="+end+"&mode="+mode+"&sensor=false");
   json = readJsonFromUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+beg+"&destinations="+end+"&mode="+mode+"&sensor=false");
   json.get("rows");
   JSONArray arr=null;
   arr = json.getJSONArray("rows");
   tem=(Integer)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getInt("value");
   dur = (float) arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getInt("value") / 60;
   dist=(float)tem/1609;
  }
  
  catch (JSONException e) 
  {
   e.printStackTrace();
  } 
  catch (IOException e)
  {
     e.printStackTrace();
  }
    float[] rv = new float[2];
    rv[0] = dist;
    rv[1] = dur;
    return rv;
    
  }
}