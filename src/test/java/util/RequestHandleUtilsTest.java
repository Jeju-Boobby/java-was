package util;

import db.DataBase;
import model.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RequestHandleUtilsTest {
    @Test
    public void create() {
        Request request = new Request(
                "POST",
                "/create"
        );

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userId", "Boobby");
        requestBody.put("name", "boo");
        requestBody.put("password", "test");
        requestBody.put("email", "boo@boo.bo");

        String path = RequestHandleUtils.requestHandle(request, requestBody);

        User savedUser = DataBase.findUserById("Boobby");

        assertThat(path, is(request.getPath()));
        assertNotNull(savedUser);
        assertThat(savedUser.getEmail(), is("boo@boo.bo"));
        assertThat(savedUser.getName(), is("boo"));
        assertThat(savedUser.getPassword(), is("test"));
    }
}