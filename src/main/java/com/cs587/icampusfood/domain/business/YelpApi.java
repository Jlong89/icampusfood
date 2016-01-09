/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.domain.business;

import com.cs587.icampusfood.dataAccess.FoodLocationServiceImpl;
import com.cs587.icampusfood.persistence.businessMappers.FoodLocationMapper;
import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;
import com.cs587.icampusfood.util.DateTimeUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 */
public class YelpApi {

    private static final String API_HOST = "api.yelp.com";
    private static final String DEFAULT_TERM = "dinner";
    private static final String DEFAULT_LOCATION = "San Francisco, CA";
    private static final int SEARCH_LIMIT = 3;
    private static final String SEARCH_PATH = "/v2/search";
    private static final String BUSINESS_PATH = "/v2/business";

    /*
     * Update OAuth credentials below from the Yelp Developers API site:
     * http://www.yelp.com/developers/getting_started/api_access
     */
    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";
    private static final String TOKEN = "";
    private static final String TOKEN_SECRET = "";

    OAuthService service;
    Token accessToken;

    /**
     * Setup the Yelp API OAuth credentials.
     *
     * @param consumerKey Consumer key
     * @param consumerSecret Consumer secret
     * @param token Token
     * @param tokenSecret Token secret
     */
    public YelpApi(String consumerKey, String consumerSecret, String token, String tokenSecret) {
        this.service
                = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey)
                .apiSecret(consumerSecret).build();
        this.accessToken = new Token(token, tokenSecret);
    }

    public YelpApi() {}

    /**
     * Creates and sends a request to the Search API by term and location.
     * <p>
     * See
     * <a href="http://www.yelp.com/developers/documentation/v2/search_api">Yelp
     * Search API V2</a>
     * for more info.
     *
     * @param term <tt>String</tt> of the search term to be queried
     * @param location <tt>String</tt> of the location
     * @return <tt>String</tt> JSON Response
     */
    private String searchForBusinessesByLocation(String term, String location) {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
        return sendRequestAndGetResponse(request);
    }

    /**
     * Creates and sends a request to the Business API by business ID.
     * <p>
     * See
     * <a href="http://www.yelp.com/developers/documentation/v2/business">Yelp
     * Business API V2</a>
     * for more info.
     *
     * @param businessID <tt>String</tt> business ID of the requested business
     * @return <tt>String</tt> JSON Response
     */
    private String searchByBusinessId(String businessID) {
        OAuthRequest request = createOAuthRequest(BUSINESS_PATH + "/" + businessID);
        return sendRequestAndGetResponse(request);
    }

    //path=?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=chinese
    private String seatchByGet(String path) {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH + "/" + path);
        return sendRequestAndGetResponse(request);
    }

    /**
     * Creates and returns an {@link OAuthRequest} based on the API endpoint
     * specified.
     *
     * @param path API endpoint to be queried
     * @return <tt>OAuthRequest</tt>
     */
    private OAuthRequest createOAuthRequest(String path) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + path);
        return request;
    }

    /**
     * Sends an {@link OAuthRequest} and returns the {@link Response} body.
     *
     * @param request {@link OAuthRequest} corresponding to the API request
     * @return <tt>String</tt> body of API response
     */
    private String sendRequestAndGetResponse(OAuthRequest request) {
        System.out.println("Querying " + request.getCompleteUrl() + " ...");
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }

    /**
     * Queries the Search API based on the command line arguments and takes the
     * first result to query the Business API.
     *
     */
    /*private static void queryAPI(YelpAPICLI yelpApiCli) {
        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String searchResponseJSON
                = yelpApi.searchForBusinessesByLocation(yelpApiCli.term, yelpApiCli.location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();
        System.out.println(String.format(
                "%s businesses found, querying business info for the top result \"%s\" ...",
                businesses.size(), firstBusinessID));

        // Select the first business and display business details
        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        System.out.println(String.format("Result for business \"%s\" found:", firstBusinessID));
        System.out.println(businessResponseJSON);
    }*/
    
    public YelpBusinessEntity queryYelpBusinessEntityByBusinessId(String businessId){
        YelpBusinessEntity e = new YelpBusinessEntity();
        YelpApi yelpApi = new YelpApi(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String searchResponseJSON = yelpApi.searchByBusinessId(businessId);
        JSONParser parser = new JSONParser();
        JSONObject response = null;

        response = parseJson( response,  searchResponseJSON);

        e.setName((String) response.get("name"));
        e.setPhone((String) response.get("phone"));
        e.setRating((Double) response.get("rating"));
        e.setReviewNumber((Long) response.get("review_count"));
        e.setUrl((String) response.get("url"));
        return e;
    }

    private JSONObject parseJson(JSONObject response, String searchResponseJSON){
        JSONParser parser = new JSONParser();
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            return null;
        }
        return response;
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /*
    Food type:
    "1": "fast food",
    "2": "italian",
    "3": "chinese",
    "4": "mexican",
    "5": "snack",
    "6": "bar/cafe,",
    "7": "japanese"
     */
    private List<FoodLocationDBDO> parseLocations(String searchResponseJSON, int foodType){
        List<FoodLocationDBDO> ret = new LinkedList<>();
        JSONObject response = null;
        response = parseJson( response,  searchResponseJSON);
        if(response==null) return ret;
        JSONArray locations = (JSONArray) response.get("businesses");
        //System.out.println("******************************************************");
        for(int i=0;i<locations.size();i++){
            JSONObject loc = (JSONObject)locations.get(i);
            double longitude = (Double)((JSONObject)((JSONObject)loc.get("location")).get("coordinate")).get("longitude");
            double latitude = (Double)((JSONObject)((JSONObject)loc.get("location")).get("coordinate")).get("latitude");
            //System.out.println("name="+loc.get("name")+", rating="+loc.get("rating")+", rating="+loc.get("rating")+", longitude"+longitude+", latitude="+latitude);
            if(map.containsKey(longitude)){
                if(map.get(longitude)==latitude) continue;
            }else map.put(longitude,latitude);
            FoodLocationDBDO dbdo = new FoodLocationDBDO();
            dbdo.setName((String)loc.get("name"));
            dbdo.setFoodType(foodType);
            dbdo.setAvgFoodRating((double)loc.get("rating"));
            dbdo.setAvgServiceRating(round(Math.random()*5,1));
            dbdo.setOpenTime(DateTimeUtil.getRandomOpenTime());
            dbdo.setCloseTime(DateTimeUtil.getRandomCloseTime());
            dbdo.setStartDate(DateTimeUtil.getRandomStartDate());
            dbdo.setEndDate(null);
            Point newPoint = new Point(longitude, latitude);
            dbdo.setLocation(new PGgeometry(newPoint));
            dbdo.setAvgCrowdedness(round(Math.random()*5,1));
            ret.add(dbdo);
        }
        //System.out.println("######################################################");
        return ret;
    }

    private static final String SNACK_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=desserts";
    private static final String FASTFOOD_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=hotdogs";
    private static final String CHINESE_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=chinese";
    private static final String ITALIAN_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=italian";
    private static final String MEXICAN_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=mexican";
    private static final String CAFES_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=cafes";
    private static final String JAPANESE_PATH = "?term=food&location=90089&limit=20&radius_filter=3000&actionlinks=true&category_filter=japanese";
    private Map<Double, Double> map = new HashMap<>();

    public List<FoodLocationDBDO> queryYelpFoodByGet(){
        List<FoodLocationDBDO> ret = new LinkedList<>();
        YelpApi yelpApi = new YelpApi(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String searchResponseJSON = yelpApi.seatchByGet(CHINESE_PATH);
        ret.addAll(parseLocations(searchResponseJSON,3));
        searchResponseJSON = yelpApi.seatchByGet(ITALIAN_PATH);
        ret.addAll(parseLocations(searchResponseJSON,2));
        searchResponseJSON = yelpApi.seatchByGet(MEXICAN_PATH);
        ret.addAll(parseLocations(searchResponseJSON,4));
        searchResponseJSON = yelpApi.seatchByGet(CAFES_PATH);
        ret.addAll(parseLocations(searchResponseJSON,6));
        searchResponseJSON = yelpApi.seatchByGet(JAPANESE_PATH);
        ret.addAll(parseLocations(searchResponseJSON,7));
        searchResponseJSON = yelpApi.seatchByGet(FASTFOOD_PATH);
        ret.addAll(parseLocations(searchResponseJSON,1));
        searchResponseJSON = yelpApi.seatchByGet(SNACK_PATH);
        ret.addAll(parseLocations(searchResponseJSON,5));
        return ret;
    }
}
