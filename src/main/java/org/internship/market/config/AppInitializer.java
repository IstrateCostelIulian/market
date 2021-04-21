package org.internship.market.config;

import org.internship.market.controller.AccountingController;
import org.internship.market.controller.RawMaterialController;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RawMaterialController.class, AccountingController.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
