//package com.juaracoding._01JavaWeb.configuration;
//
//import com.juaracoding._01JavaWeb.formatters.MenuHeaderFormatter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
////@ComponentScan(value = {"com.juaracoding._01JavaWeb.controller"})
//@Configuration
//@EnableWebMvc
//@ComponentScan(value = {"controller"})
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    //Formatters
//
//    @Autowired //Without autowire, this solution may not work
//    private MenuHeaderFormatter menuHeaderFormatter;
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(menuHeaderFormatter);
//    }
//}