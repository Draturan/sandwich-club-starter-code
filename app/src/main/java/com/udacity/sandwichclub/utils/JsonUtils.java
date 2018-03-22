package com.udacity.sandwichclub.utils;

import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException{
        JSONObject jsonSandwich = new JSONObject(json);
        JSONObject name = jsonSandwich.getJSONObject("name");

        //Creating and setting up all the data inside the Sandwich object
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(name.optString("mainName"));

        // Parsing List nameAlsoKnownAs
        List<String> nameAlsoKnownAs = new ArrayList<>();
        JSONArray alsoKnownArray = name.optJSONArray("alsoKnownAs");
        for (int i = 0; i < alsoKnownArray.length();i++){
            nameAlsoKnownAs.add((String) alsoKnownArray.get(i));
        }
        sandwich.setAlsoKnownAs(nameAlsoKnownAs);

        sandwich.setPlaceOfOrigin(jsonSandwich.optString("placeOfOrigin"));
        sandwich.setDescription(jsonSandwich.optString("description"));
        sandwich.setImage(jsonSandwich.optString("image"));

        // Parsing List ingredients
        List<String> ingredients = new ArrayList<>();
        JSONArray ingredientsArray = jsonSandwich.optJSONArray("ingredients");
        for (int i=0; i<ingredientsArray.length();i++){
            ingredients.add((String) ingredientsArray.get(i));
        }
        sandwich.setIngredients(ingredients);

        return sandwich;
    }
}
