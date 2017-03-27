package com.mentoringproject.soapwebservice;

import com.mentoringproject.soapwebservice.net.webservicex.GeoIP;
import com.mentoringproject.soapwebservice.net.webservicex.GeoIPService;
import com.mentoringproject.soapwebservice.net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder 
{
	public static void findLocation(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("You need to pass in one IP address");
		}
		else 
		{
			String ipAddress = args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
			System.out.println(geoIP.getCountryName());
		}
	}
}
