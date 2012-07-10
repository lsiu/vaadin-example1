package com.example.ui;

import com.example.model.Expense;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ExpenseTable extends CustomComponent {
	
	private VerticalLayout mainLayout;

	private Table table;
	
	private BeanItemContainer<Expense> container = new BeanItemContainer<Expense>(Expense.class);
	
	public ExpenseTable() {
		initMainLayout();
		this.setCompositionRoot(mainLayout);
		
		table = buildTable();
		mainLayout.addComponent(table);
		
	}

	private Table buildTable() {
		table = new Table();
		table.setContainerDataSource(container);
		return table;
	}

	private void initMainLayout() {
		mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
	}
}
