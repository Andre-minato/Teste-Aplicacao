package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static Object[][] getJsonData(String path, String data, int attributes) throws IOException, ParseException {
        Object objet = new JSONParser().parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) objet;
        JSONArray jsonArray = (JSONArray) jsonObject.get(data);
        Object[][] arrayObject = new String[jsonArray.size()][attributes];
        for (int i = 0; i < jsonArray.size(); i++){
            JSONObject object1 = (JSONObject) jsonArray.get(i);
            arrayObject[i][0] = String.valueOf(object1.get("TaskName"));
            arrayObject[i][1] = String.valueOf(object1.get("TaskDesc"));
        }
        return arrayObject;
    }
}
