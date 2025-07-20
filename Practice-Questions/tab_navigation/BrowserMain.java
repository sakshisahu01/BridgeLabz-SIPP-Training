package com.tab_navigation;

public class BrowserMain {
    public static void main(String[] args) {
        NavigationManager tab = new BrowserTab("google.com");

        tab.visit("youtube.com");
        tab.visit("openai.com");
        tab.visit("github.com");

        System.out.println("🔙 Back: " + tab.back());     // openai.com
        System.out.println("🔙 Back: " + tab.back());     // youtube.com
        System.out.println("🔜 Forward: " + tab.forward()); // openai.com
        tab.visit("stackoverflow.com"); // Forward stack is cleared
        System.out.println("🔜 Forward: " + tab.forward()); // Nothing to forward
        System.out.println("📌 Current: " + tab.current()); // stackoverflow.com
    }
}