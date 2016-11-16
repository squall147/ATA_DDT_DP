package utils;

/**
 * Created by Robert_Kaszubowski on 11/16/2016.
 */
public enum UrlProvider {

    PAGE_URL("http://newtours.demoaut.com");

    private final String baseUrl;

    private UrlProvider(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return String.format(baseUrl);
    }
}
