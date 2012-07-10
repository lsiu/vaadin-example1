package com.example.ui;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ExpenseFieldFactory extends DefaultFieldFactory {

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		if ("summary".equals(propertyId)) {
			TextArea field = new TextArea("Summary");
			field.setPropertyDataSource(item.getItemProperty(propertyId));
			field.setNullRepresentation("");
			field.setWidth("100%");
			return field;
		}
		Field field = super.createField(item, propertyId, uiContext);
		if (field instanceof TextField)
			((TextField) field).setNullRepresentation("");
		return field;
	}
}
