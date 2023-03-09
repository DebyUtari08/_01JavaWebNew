//package com.juaracoding._01JavaWeb.formatters;
//
//import com.juaracoding._01JavaWeb.model.MenuHeader;
//import com.juaracoding._01JavaWeb.service.MenuHeaderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Service;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//@Service
//public class MenuHeaderFormatter implements Formatter<MenuHeader> {
//
//    @Autowired
//    MenuHeaderService menuHeaderService;
//
//    @Override
//    public MenuHeader parse(String text, Locale locale) throws ParseException {
//        Long id = Long.valueOf(text);
//        MenuHeader menuHeader = (MenuHeader) this.menuHeaderService.findById(id).get("data");
//        return menuHeader==null?new MenuHeader():menuHeader;
//    }
//
//    @Override
//    public String print(MenuHeader object, Locale locale) {
//        return (object != null ? object.getIdMenuHeader().toString() : "");
//    }
//}
