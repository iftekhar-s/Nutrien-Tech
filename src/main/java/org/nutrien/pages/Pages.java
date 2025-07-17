package org.nutrien.pages;

import java.util.Map;

public class Pages {
    private static final Map<String, String> PAGE_URLS = Map.of(
            "A/B Testing", "abtest",
            "Add/Remove Elements", "add_remove_elements",
            "Basic Auth", "basic_auth"
            // I can add more mapping as needed
    );

    public static String getExpectedUrl(String pageName) {
        String path = PAGE_URLS.getOrDefault(pageName,
                pageName.toLowerCase()
                        .replace(" ", "_")
                        .replace("/", ""));
        return "https://the-internet.herokuapp.com/" + path;
    }
}
