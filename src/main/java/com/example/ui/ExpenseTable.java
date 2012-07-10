package com.example.ui;

import com.example.model.Expense;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ExpenseTable extends CustomComponent implements Handler {
	
	private VerticalLayout mainLayout;

	private Table table;
	
	private BeanItemContainer<Expense> container = new BeanItemContainer<Expense>(Expense.class);
	
	private final Action addAction = new Action("Add Expense");
	
	private final Action[] actions = new Action[] { addAction };
	
	public ExpenseTable() {
		initMainLayout();
		this.setCompositionRoot(mainLayout);
		
		table = buildTable();
		mainLayout.addComponent(table);
		
	}

	private Table buildTable() {
		table = new Table();
		table.setContainerDataSource(container);
		table.addActionHandler(this);
		return table;
	}

	private void initMainLayout() {
		mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
	}

	public Action[] getActions(Object target, Object sender) {
		return actions;
	}

	public void handleAction(Action action, Object sender, Object target) {
		if (action == addAction) {
            Window newWindow = new Window("Add Expense Form");
            newWindow.setModal(true);
            newWindow.addComponent(new ExpenseForm());
            newWindow.getContent().setSizeUndefined();
            getWindow().addWindow(newWindow);
		}
	}
}
