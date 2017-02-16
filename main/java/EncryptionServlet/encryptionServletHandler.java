

public class encryptionServletHandler implements IRequestHandler {

    @Override
    public HttpResponse handlePost(HttpRequest request, ServerContext context) {
        HttpResponse response;
        // Handling POST request here
        String message = request.get(msg);

        String output = rot13(message);

        response = HttpResponseFactory.create200OK(null, output);
        response.setBody("Message: " + output);

        return response;
    }

    private String rot13(String message) {
        String output = "";
        for (int i = 0; i < message.length; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                c += 13;
            } else {
                c -= 13;
            }
        }
        return output;
    }
}
