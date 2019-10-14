package com.tws.refactoring.extract_variable;

public class BannerRender {
    public String renderBanner(String platform, String browser) {
        boolean platformContainsMac = platform.toUpperCase().contains("MAC");
        boolean browserContainsIE = browser.toUpperCase().contains("IE");

        if (platformContainsMac && browserContainsIE) {
            return "IE on Mac?";
        }
        return "banner";
    }
}
