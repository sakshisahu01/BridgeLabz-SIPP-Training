package com.tab_navigation;

import java.util.Stack;

public class BrowserTab implements NavigationManager {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentUrl;

    public BrowserTab(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentUrl = homepage;
    }

    @Override
    public void visit(String url) {
        if (currentUrl != null) {
            backStack.push(currentUrl);
        }
        currentUrl = url;
        forwardStack.clear();
        System.out.println("🌐 Visited: " + url);
    }

    @Override
    public String back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
        } else {
            System.out.println("⚠️ No pages to go back to.");
        }
        return currentUrl;
    }

    @Override
    public String forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentUrl);
            currentUrl = forwardStack.pop();
        } else {
            System.out.println("⚠️ No pages to go forward to.");
        }
        return currentUrl;
    }

    @Override
    public String current() {
        return currentUrl;
    }
}