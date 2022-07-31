package com.eiscolombia.testcatbreeds.classcat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DummyCat {

    public static ArrayList<Cat> listCat;

    public DummyCat(JSONArray jsonArray) throws JSONException {
        //Cantidad de razas de gatos
        int _lengt = jsonArray.length();
        listCat = new ArrayList<Cat>(_lengt);

        for(int i  = 0; i < _lengt; i++){
            JSONObject jsonCat = jsonArray.getJSONObject(i);
            Cat cat = new Cat();
            //Asignación de valores
            if(jsonCat.has("id")) {
                cat.setId(jsonCat.getString("id"));
            }
            if(jsonCat.has("name")) {
                cat.setNamerace(jsonCat.getString("name"));
            }
            if(jsonCat.has("origin")) {
                cat.setOrigin(jsonCat.getString("origin"));
            }
            if(jsonCat.has("description")) {
                cat.setDescription(jsonCat.getString("description"));
            }
            if(jsonCat.has("life_span")) {
                cat.setLife_span(jsonCat.getString("life_span"));
            }
            if(jsonCat.has("adaptability")) {
                cat.setAdaptability(jsonCat.getInt("adaptability"));
            }
            if(jsonCat.has("intelligence")) {
                cat.setIntelligence(jsonCat.getInt("intelligence"));
            }
            if(jsonCat.has("image")) {
                if(jsonCat.getJSONObject("image").has("url")) {
                    cat.setImage_url(jsonCat.getJSONObject("image").getString("url"));
                }
            }

            //cat.setWeight_imperial(jsonCat.getJSONObject("weight").getString("imperial"));
            //cat.setWeight_metric(jsonCat.getJSONObject("weight").getString("metric"));
            //cat.setCfa_url(jsonCat.getString("cfa_url"));
            //cat.setVetstreet_url(jsonCat.getString("vetstreet_url"));
            //cat.setVcahospitals_url(jsonCat.getString("vcahospitals_url"));
            //cat.setTemperament(jsonCat.getString("temperament"));
            //cat.setCountry_codes(jsonCat.getString("country_codes"));
            //cat.setCountr_code(jsonCat.getString("country_code"));
            //cat.setIndoor(jsonCat.getInt("indoor"));
            //cat.setLap(jsonCat.getInt("lap"));
            //cat.setAlt_names(jsonCat.getString("alt_names"));
            //cat.setAffection_level(jsonCat.getInt("affection_level"));
            //cat.setChild_friendly(jsonCat.getInt("child_friendly"));
            //cat.setDog_friendly(jsonCat.getInt("dog_friendly"));
            //cat.setEnergy_level(jsonCat.getInt("energy_level"));
            //cat.setGrooming(jsonCat.getInt("grooming"));
            //cat.setHealth_issues(jsonCat.getInt("health_issues"));
            //cat.setShedding_level(jsonCat.getInt("shedding_level"));
            //cat.setSocial_needs(jsonCat.getInt("social_needs"));
            //cat.setStranger_friendly(jsonCat.getInt("stranger_friendly"));
            //cat.setVocalisation(jsonCat.getInt("vocalisation"));
            //cat.setExperimental(jsonCat.getInt("experimental"));
            //cat.setHairless(jsonCat.getInt("hairless"));
            //cat.setNatural(jsonCat.getInt("natural"));
            //cat.setRare(jsonCat.getInt("rare"));
            //cat.setRex(jsonCat.getInt("rex"));
            //cat.setSuppressed_tail(jsonCat.getInt("suppressed_tail"));
            //cat.setShort_legs(jsonCat.getInt("short_legs"));
            //cat.setWikipedia_url(jsonCat.getString("wikipedia_url"));
            //cat.setHypoallergenic(jsonCat.getInt("hypoallergenic"));
            //cat.setReference_image_id(jsonCat.getString("reference_image_id"));
            //cat.setImage_id(jsonCat.getJSONObject("image").getString("id"));
            //cat.setImage_width(jsonCat.getJSONObject("image").getInt("width"));
            //cat.setImage_height(jsonCat.getJSONObject("image").getInt("height"));

            listCat.add(cat);

        }

        //this.namerace = name;
    }
}
