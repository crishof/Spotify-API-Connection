package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class ApiConnection {

    public HttpResponse<String> getArtistInfo(HttpClient httpClient, String accessToken, String artistId) {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.spotify.com/v1/artists/" + artistId)).header("Authorization", "Bearer " + accessToken).GET().build();

        try {

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                return response;
            } else {
                throw new RuntimeException("Error al obtener la info: " + statusCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al relizar la peticion HTTP ", e);
        }
    }


    public void getTrackInfo(HttpClient httpClient, String accessToken, String trackId) {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.spotify.com/v1/tracks/" + trackId)).header("Authorization", "Bearer " + accessToken).GET().build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

//            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken(String clientId, String clientSecret) {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://accounts.spotify.com/api/token")).header("Content-Type", "application/x-www-form-urlencoded").header("Authorization", "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes())).POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials")).build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String accessToken = response.body().split("\"access_token\":\"")[1].split("\"")[0];
            return accessToken;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
