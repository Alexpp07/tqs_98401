package lab2_2geo.lab2_2geo;

import org.apache.http.ParseException;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

public class AddressResolver {
    ISimpleHttpClient iSimpleHttpClient;

    public AddressResolver(ISimpleHttpClient iSimpleHttpClient){
        this.iSimpleHttpClient = iSimpleHttpClient;
    }

    public Address findAddressForLocation(double latitude, double longitude) throws URISyntaxException, IOException, ParseException, org.json.simple.parser.ParseException{


        URIBuilder uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.6451,-8.6621&includeRoadMetadata=true");

        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f", latitude, longitude).toString());
        uriBuilder.addParameter("includeRoadMetadata", "true");

        String response = this.iSimpleHttpClient.doHttpGet(uriBuilder.build().toString());

        JSONObject obj = (JSONObject) new JSONParser().parse(response);
        obj =(JSONObject)((JSONArray) obj.get("results")).get(0);
        JSONObject address =(JSONObject)((JSONArray) obj.get("locations")).get(0);

        String road = (String) address.get("street");
        String state = (String) address.get("adminArea3");
        String city = (String) address.get("adminArea5");
        String zio = (String) address.get("postalCode");

        return new Address(road, state, city, zio, null);
    }
}
