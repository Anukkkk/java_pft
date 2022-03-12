package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.ObjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("77.88.55.88");
        assertEquals(geoIP, "<GeoIP><Country>RU</Country><State>53</State></GeoIP>");
    }
}
