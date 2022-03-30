package lab2_2geo.lab2_2geo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class findAddressForLocationTest {
    
    @DisplayName("Good Address")
    @Test
    public void whenGoodAddress() throws ParseException, IOException, URISyntaxException {
        ISimpleHttpClient mockedhttpClient = mock(ISimpleHttpClient.class);

        String resultjson="{\"info\":{\"statuscode\":0,\"copyright\": {\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Rua do Sal\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Aveiro\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3810-200\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.645100,\"lng\":-8.662100},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-98728279\",\"roadMetadata\":null}]}]}";

        AddressResolver resolver = new AddressResolver(mockedhttpClient);


        when(mockedhttpClient.doHttpGet(contains("location=40.645100%2C-8.662100"))).thenReturn(resultjson);

        Address result = resolver.findAddressForLocation(40.6451, -8.6621);

        assertEquals( result, new Address( "Rua do Sal", "Centro", "Aveiro", "3810-200", null) );

    }
}
