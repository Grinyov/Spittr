package com.grinyov.springinaction.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * Configuring DispatcherServlet
 *
 * Любой класс, который наследуется от AbstractAnnotationConfigDispatcherServletInitializer автоматически
 используется для настройки DispatcherServlet
 *
 * AbstractAnnotationConfigDispatcherServletInitializer создает два контекста DispatcherServlet and a ContextLoaderListener.
 */

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Map DispatcherServlet to /
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    /** когда стартует DispatcherServlet он создает Spring application context и загружает бины
     *  из конфигурационных файлов или прописанных классов с помощью Java config.
     *  С помощью getServletConfigClasses() загружаются бины для web - controllers, view resolvers, and handler mappings
     *  А в свою очередь ContextLoaderListener загружает бины приложения - middle-tier and data-tier components
    */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     *  Т.е. классы аннотированные @Configuration и которые возвращает getServletConfigClasses() будут определять бины DispatcherServlet
     *  А классы аннотированные @Configuration и которые возвращает getRootConfigClasses() будут определять бины ContextLoaderListener
     *
     *  И это есть аналогом и заменой(или возможно и дополнением если необходимо) конфигурации через web.xml
     *
     */

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}