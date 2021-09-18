package com.yangrui.shark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SharkApplication extends SpringBootServletInitializer {

  private static Logger logger = LoggerFactory.getLogger(SpringBootServletInitializer.class);


  public static void main(String[] args) {

    SpringApplication.run(SharkApplication.class, args);
/*    logger.trace("这是trace日志");
    logger.debug("这个debug日志");
    logger.info("这个info日志");
    logger.warn("这是warn日志");
    logger.error("这是error日志");*/
    logger.error("启动成功");
  }
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SharkApplication.class);
	}
}
