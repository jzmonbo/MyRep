/*
 * Copyright 2011 Navin Peiris <navin.peiris@gmail.com>, Melbourne, Australia.
 * All Rights Reserved.
 */

package com.renben.hros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Main application entry point for the Vaadin-Spring Demo Application.
 * 
 * @author Navin Peiris
 * @since 1.0.0
 */
@SuppressWarnings("serial")
@Configurable
public class VaadinSpringDemoApplication extends Application {

    public static final String APPLICATION_TITLE = "Vaading-Spring Demo";
    
    private Window win = new Window("aaa");
    
    @Override
    public void init() {
    	buildWin();
        setMainWindow(win);
    }
    
    private void buildWin() {
    	final Form form = new Form();
    	win.addComponent(form);
    	Person person = new Person();
    	form.setFormFieldFactory(new PersonFieldFactory());
    	BeanItem<Person> personItem = new BeanItem<Person>(person);
    	form.setItemDataSource(personItem);
    	form.setInvalidCommitted(false);
    	
    	Button btnCommit = new Button("commit1");
    	win.addComponent(btnCommit);
    	btnCommit.addListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				form.commit();
			}
		});
    }
    
    private class PersonFieldFactory extends DefaultFieldFactory {
    	@Override        
    	public Field createField(Item item, Object propertyId,                
    			Component uiContext) {            
    		Field f;
//    		f = super.createField(item, propertyId, uiContext);
    		f = new TextDate();
			return f;
    	}
    }

}
