package com.tab_navigation;

public class MobileBrowserTab extends BrowserTab {
    public MobileBrowserTab(String homepage) {
        super(homepage);
    }

    // You can override visit/back/forward with mobile-specific features
    @Override
    public void visit(String url) {
        System.out.println("📱 Mobile browsing: ");
        super.visit(url);
    }
}