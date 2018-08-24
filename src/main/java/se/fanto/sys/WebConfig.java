package se.fanto.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class WebConfig {

	@WebListener
	public static class Chapter07ContextListener implements ServletContextListener {

		@Override
		public void contextInitialized(ServletContextEvent sce) {
		}

		@Override
		public void contextDestroyed(ServletContextEvent sce) {
		}
	}

}
