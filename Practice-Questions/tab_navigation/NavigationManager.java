package com.tab_navigation;

public interface NavigationManager {
	void visit(String url);
    String back();
    String forward();
    String current();
}
