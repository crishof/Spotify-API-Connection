import com.google.gson.Gson;
import model.Artist;
import service.ApiConnection;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) {

        ApiConnection apiConnection = new ApiConnection();
        HttpClient httpClient = HttpClient.newHttpClient();

        String accessToken = apiConnection.getAccessToken(System.getenv("CLIENT_ID"), System.getenv("CLIENT_SECRET"));

        String trackId = "7snQQk1zcKl8gZ92AnueZW?si=18c7b281188f4a7e";
        apiConnection.getTrackInfo(httpClient, accessToken, trackId);

        String artistId = "3qm84nBOXUEQ2vnTfUTTFC?si=AJfcNby0RJmRY3_NuiWF3w";
        HttpResponse<String> response = apiConnection.getArtistInfo(httpClient, accessToken, artistId);

        Gson gson = new Gson();
        Artist artist = gson.fromJson(response.body(), Artist.class);

        System.out.println(artist);
    }
}