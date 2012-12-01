package com.ALC.SC2BOAserver.tests;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import javax.persistence.Entity;

import org.junit.Test;
import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

import com.ALC.SC2BOAserver.util.DEBUG;

public class RandomTest {
	@Test
    public void findAnnotations() throws IOException {
        URL[] urls = ClasspathUrlFinder.findClassPaths(); // scan java.class.path
        System.out.println("size of urls="+urls.length);
        for (URL url : urls) {
        	System.out.println("url=" + url);
        }
        AnnotationDB db = new AnnotationDB();
        db.scanArchives(urls);
        Set<String> entities = db.getAnnotationIndex().get(Entity.class.getName());
        for (String entity : entities) {
            System.out.println("entity=" + entity);
        }
    }
	

}
