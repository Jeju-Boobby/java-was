package util;

import db.DataBase;
import model.User;

import java.util.Map;

public class RequestHandleUtils {
    public static String requestHandle(Request request, Map<String, String> requestBody) {
        String destination = request.getPath();
        if (request.getMethod().equals("POST") && request.getPath().equals("/create")) {
            User newUser = new User(requestBody.get("userId"), requestBody.get("password"), requestBody.get("name"), requestBody.get("email"));
            DataBase.addUser(newUser);
        }

        return destination;
    }
}
