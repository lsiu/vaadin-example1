package com.example.ui;

import com.example.model.Expense;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ExpenseForm extends CustomComponent implements ClickListener {
	
	private VerticalLayout mainLayout;
	private Form form;
	private Button saveButton = new Button("Save", this);
	private BeanItem<Expense> expenseItem;

	public ExpenseForm(BeanItem<Expense> expenseItem) {
		this.expenseItem = expenseItem;
		
		initMainLayout();
		this.setCompositionRoot(mainLayout);
		
		form = buildForm();
		mainLayout.addComponent(form);
		
		Layout buttonPane = buildButtonPane();
		mainLayout.addComponent(buttonPane);
		mainLayout.setComponentAlignment(buttonPane, Alignment.MIDDLE_CENTER);
	}
	
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == saveButton) {
			Expense expense = expenseItem.getBean();
			String msg = String.format("Date: %s, Summary: %s, Amount: %s", 
					expense.getTransactionDate(),
					expense.getSummary(),
					expense.getAmount());
			getWindow().showNotification("Expense Saved", msg);
		}
	}

	private Layout buildButtonPane() {
		HorizontalLayout pane = new HorizontalLayout();
		pane.addComponent(saveButton);
		return pane;
	}

	private Form buildForm() {
		form = new Form();
		form.setFormFieldFactory(new ExpenseFieldFactory());
		form.setItemDataSource(expenseItem);
		form.setVisibleItemProperties(new Object[] { "transactionDate", "summary", "amount"});
		form.setValidationVisible(true);
		form.setImmediate(true);
		return form;
	}

	private void initMainLayout() {
		mainLayout = new VerticalLayout();
		mainLayout.setWidth("400px");
	}
}
