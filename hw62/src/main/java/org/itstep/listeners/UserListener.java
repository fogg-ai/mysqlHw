package org.itstep.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserListener implements HttpSessionListener {
    private static int count = 0;

    public static int getCount(){
        return count;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ++count;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        --count;
    }
}
