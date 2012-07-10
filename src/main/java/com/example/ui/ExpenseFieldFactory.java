package com.example.ui;

import com.vaadin.data.Item;
import com.vaadin.data.validator.DoubleValidator;
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
			field.setRequired(true);
			field.setRequiredError("Summary of expense is required");
			return field;
		}
		Field field = super.createField(item, propertyId, uiContext);
		if ("amount".equals(propertyId)) {
			field.setRequired(true);
			field.setRequiredError("A valid expense amount is required");
			field.addValidator(new DoubleValidator("Invalid value for Amount field"));
		} else if ("transactionDate".equals(propertyId)) {
			field.setRequired(true);
			field.setRequiredError("A valid transaction date for the expense is required");
		}
		if (field instanceof TextField)
			((TextField) field).setNullRepresentation("");
		return field;
	}
}
