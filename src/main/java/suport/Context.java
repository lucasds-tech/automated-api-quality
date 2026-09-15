package suport;

import io.restassured.response.Response;

public class Context {

    private Response response;
    private String token;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
