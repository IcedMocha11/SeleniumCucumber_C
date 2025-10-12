package utilities;

public class Environment {
    public String getBaseUrl(String environment) {
        // Fallback to the default URL
        return switch (environment) {
            case "dev" -> "https://www.saucedemo.com/v1/";
            case "ing" -> "https://www.ing.com/Home.htm";
            case "rahul_home" -> "https://www.rahulshettyacademy.com/";
            case "rahul_GreenKart" -> "https://rahulshettyacademy.com/seleniumPractise/#/";
            //default -> properties.getProperty("default.base.url"); // Fallback to the default URL
            default -> "https://www.facebook.com/";
        };
    }

}
