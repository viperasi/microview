package com.xu81.microview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@ImportResource(locations = {"classpath:application-goods.xml"})
public class GoodsApplication implements EmbeddedServletContainerCustomizer {


    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(GoodsApplication.class);
        application.setWebEnvironment(true);
        application.run(args);
        System.out.println("===============microview goods started===============");
        new CountDownLatch(1).await();
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

        configurableEmbeddedServletContainer.setPort(8081);
    }
}
