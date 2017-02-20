package com.mentoringproject.troubleshooting;

import java.util.HashMap;
import java.util.Map;

public class TestMemoryLeak {
	
	static class Key
	{
	      Integer id;
	 
	      Key(Integer id) {
	         this.id = id;
	      }
	 
	      @Override
	      public int hashCode() {
	         return id.hashCode();
	      }
	      
//	      @Override
//	      public boolean equals(Object object)
//	      {
//	         boolean response = false;
//	         
//	         if (object instanceof Key) 
//	         {
//	            response = (((Key) object).id).equals(this.id);
//	         }
//	         
//	         return response;
//	      }
	}
	
	public static void populateMap()
	{
		Map<Key, String> map = new HashMap<Key, String>();
	      while (true)
	      {
	    	  for (int i = 0; i < 10; i++)
	    	  {
	    		  if (!map.containsKey(new Key(i)))
	    		  {
	    			 map.put(new Key(i), "Number:" + i); 
	    			 System.out.println(map);
	    		  }	               
	    	  }	            
	      } 
	}

}
