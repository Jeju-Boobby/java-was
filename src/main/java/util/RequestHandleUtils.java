package util;

import db.DataBase;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestHandleUtils {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandleUtils.class);

    public static String requestHandle(Request request, Map<String, String> requestBody) {
        String destination = request.getPath();
        if (request.getMethod().equals("POST") && request.getPath().equals("/user/create")) {
            User newUser = new User(requestBody.get("userId"), requestBody.get("password"), requestBody.get("name"), requestBody.get("email"));
            DataBase.addUser(newUser);

            return "redirect:/index.html";
        }

        return destination;
    }


}
