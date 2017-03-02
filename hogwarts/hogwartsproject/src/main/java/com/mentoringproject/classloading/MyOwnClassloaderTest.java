package com.mentoringproject.classloading;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO;

@RunWith(MockitoJUnitRunner.class)
public class MyOwnClassloaderTest {
	
	@Test
	public void shouldInvokeMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		MyOwnClassLoader loader = new MyOwnClassLoader();
		Class<?> c = loader.findClass("com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO");

		Object ob = c.newInstance();
		Method md = c.getMethod("equals");
		md.invoke(ob);
	}

	@Test
	public void shouldLoadClassOutFromClassPath() throws InstantiationException, IllegalAccessException {
		// Create a File object on the root of the directory containing the
		// class file
		File file = new File("\\outerClasses\\User.class");

		try {
			// Convert File to a URL
			URL url = file.toURI().toURL(); // file:/c:/myclasses/
			URL[] urls = new URL[] { url };

			// Create a new class loader with the directory
			ClassLoader cl = new URLClassLoader(urls);

			// Load in the class; User.class should be located in
			// the directory outerClasses
			Class cls = cl.loadClass("com.corejava.classloading.User");

			HogwartsDeveloperDTO user = (HogwartsDeveloperDTO) cls.newInstance();
			user.getFirstName();
			System.out.println(user.getFirstName());

		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

}
