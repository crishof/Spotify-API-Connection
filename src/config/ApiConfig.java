//package config;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.Base64;
//
//public class ApiConfig {
//
//            String clientId = "7827900439f0413bb9043c120d469ceb";
//            String clientSecret = "6e1f32ac0ab84a39824e97fb205eec9e";
//
//            HttpClient httpClient = HttpClient.newHttpClient();
//
//            // Realizar el flujo de Client Credentials
//            String accessToken = getAccessToken(clientId, clientSecret);
//
//            if (accessToken != null) {
//                // Utilizar el token de acceso para obtener información sobre una pista
//                String trackId = "7snQQk1zcKl8gZ92AnueZW?si=18c7b281188f4a7e";
//                getTrackInfo(httpClient, accessToken, trackId);
//            }
//
//            if (accessToken != null) {
//                // Utilizar el token de acceso para obtener información sobre un artista
//                String artistId = "3qm84nBOXUEQ2vnTfUTTFC?si=AJfcNby0RJmRY3_NuiWF3w";
////            getArtistInfo(httpClient, accessToken, artistId);
//            }
//
//
//        }
//
//        private static void getArtistInfo(HttpClient httpClient, String accessToken, String artistId) {
//
//
//            // Configurar la solicitud para obtener información sobre un artista
//            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.spotify.com/v1/artists/" + artistId))
//                    .header("Authorization", "Bearer " + accessToken).GET().build();
//
//            try {
//                // Enviar la solicitud y obtener la respuesta
//                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//                // Imprimir la información del artista
//                System.out.println(response.body());
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        private static void getTrackInfo(HttpClient httpClient, String accessToken, String trackId) {
//
//            // Configurar la solicitud para obtener información sobre una pista
//            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.spotify.com/v1/tracks/" + trackId))
//                    .header("Authorization", "Bearer " + accessToken).GET().build();
//
//            try {
//                // Enviar la solicitud y obtener la respuesta
//                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//                // Imprimir la información de la pista
//                System.out.println(response.body());
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        private static String getAccessToken(String clientId, String clientSecret) {
//            HttpClient httpClient = HttpClient.newHttpClient();
//
//            // Configurar la solicitud para obtener el token de acceso
//            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://accounts.spotify.com/api/token"))
//                    .header("Content-Type", "application/x-www-form-urlencoded")
//                    .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes()))
//                    .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials")).build();
//
//            try {
//                // Enviar la solicitud y obtener la respuesta
//                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//                // Analizar la respuesta JSON y extraer el token de acceso
//                String accessToken = response.body().split("\"access_token\":\"")[1].split("\"")[0];
//                return accessToken;
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//    }