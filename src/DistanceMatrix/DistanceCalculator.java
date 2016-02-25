package DistanceMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DistanceCalculator 
{
 static String beg, end;
 static StringBuffer start=new StringBuffer(), stop=new StringBuffer();
 static float[] totDistance, totDistance1;
 public static void main(String args[])
 {
  DistanceInterface ji=new DistanceInterface();

  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  try
  {
   System.out.println("Enter the Source Place : ");
   beg=br.readLine();
   System.out.println("Enter the Destination Place : ");
   end=br.readLine();
   start.append(beg);
 
   stop.append(end);
   
   for(int i=0; i<start.length(); i++)
   {
    if(start.charAt(i)==' ')
    {
     start.deleteCharAt(i);
     start.insert(i, "%20");
    }
   }
   for(int i=0;i<stop.length();i++)
   {
    if(stop.charAt(i)==' ')
    {
     stop.deleteCharAt(i);
     stop.insert(i, "%20");
    }
   }
   totDistance=ji.calcDistance(start,stop, "driving");
   totDistance1=ji.calcDistance(start,stop, "walking");
   System.out.println("Road distance: "+beg+" to "+end+" is = "+totDistance[0] + " miles and Time: " + totDistance[1] + "min" + "||" + "Walking Distance: "+totDistance1[0] + " miles and Time: " + totDistance1[1] + "mins");
  }
  catch(IOException e)
  {
   System.out.println("Improper place value set..");
   e.printStackTrace();
  }
  catch(Exception e)
  {
   System.out.println("Json type exception");
   e.printStackTrace();
  }
 }
}