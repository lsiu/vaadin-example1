package com.example.ui;

import com.example.model.Expense;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ExpenseForm extends CustomComponent {
	
	private Layout mainLayout;
	private Form form;

	public ExpenseForm() {
		initMainLayout();
		this.setCompositionRoot(mainLayout);
		
		form = buildForm();
		mainLayout.addComponent(form);
	}

	private Form buildForm() {
		form = new Form();
		form.setItemDataSource(new BeanItem<Expense>(new Expense()));
		return form;
	}

	private void initMainLayout() {
		mainLayout = new VerticalLayout();
		mainLayout.setMargin(true);
		mainLayout.setWidth("400px");
	}
}
