/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.universome.radio.RadioUVM;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * - https://stackoverflow.com/questions/2215536/java-dynamic-properties
 * @author gianluca
 */
public class ResponseManager implements Iterable<JSONObject>, Iterator<JSONObject>{
    
    private JSONObject response = null;
    public JSONArray response_array = null;
    private int count = 0;
    
    public ResponseManager(Object response){
        
        if (response instanceof JSONObject){
            System.out.println("Is a JSON Object");
            this.response = (JSONObject) response;
            
        }
        else if (response instanceof JSONArray){
            System.out.println("Response is a JSON Array");
            this.response_array = (JSONArray) response;
        }
        else {
            System.out.println("Not Recognized");
        }
    }
    
    // Methods for response JSONArray
    /*
    public JSONObject next() {
        
        if (response_array.isNull(0)){
            System.out.println("No elements in response");
            return null;
        }
        
        
    }*/
    
    @Override
    public boolean hasNext() {
        if (this.count < this.response_array.length())
            return true;
        else
            return false;
    }
    
    public JSONObject next() {
        if (this.count == this.response_array.length())
            throw new NoSuchElementException();

        this.count++;
        return this.response_array.getJSONObject(count - 1);
    }
    
    
    public Iterator<JSONObject> iterator() {
        return this;
    }
    
    // Methods for response JSONObject
    public String getProperty(String property) {
        if (this.response != null) {
            System.out.println("Raise JSON Array Exception");
            return "";
        }else{
            try {
                return String.valueOf(this.response.get(property));
            }catch (Exception e){
                System.out.println("Invalid Property");
            }
        }
        return null;
    }

    
    
}
