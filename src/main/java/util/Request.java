package util;

import java.util.Map;

public class Request {
    private String method;
    private String path;
    private Map<String, String> params;

    public Request(String method, String path) {
        this.method = method;
        this.path = path;
        this.params = null;
    }

    public Request(String method, String path, String params) {
        this.method = method;
        this.path = path;
        this.params = HttpRequestUtils.parseQueryString(params);
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
