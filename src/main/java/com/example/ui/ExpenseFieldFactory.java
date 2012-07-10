package com.example.ui;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ExpenseFieldFactory extends DefaultFieldFactory {

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		Field field = super.createField(item, propertyId, uiContext);
		if (field instanceof TextField)
			((TextField) field).setNullRepresentation("");
		return field;
	}
}
