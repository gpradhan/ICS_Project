package com.info.config;

import com.info.filter.CORSFilter;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   protected Class<?>[] getRootConfigClasses() {
      return new Class[]{HibernateConfig.class};
   }

   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{WebMvcConfig.class};
   }

   protected String[] getServletMappings() {
      return new String[]{"/"};
   }

   protected Filter[] getServletFilters() {
      return new Filter[]{new CORSFilter()};
   }
   
   private String TMP_FOLDER = "/tmp"; 
   private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
    
//   @Override
//   public void onStartup(ServletContext sc) throws ServletException {
//        
//       ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", new DispatcherServlet(
//         new GenericWebApplicationContext()));
//
//       appServlet.setLoadOnStartup(1);
//        
//       MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, 
//         MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//        
//       appServlet.setMultipartConfig(multipartConfigElement);
//   }
}