package by.telecom.task.client;

import by.telecom.task.client.presenter.PlanTabPresenter;
import by.telecom.task.client.presenter.Presenter;
import by.telecom.task.client.presenter.TaskTabPresenter;
import by.telecom.task.client.ui.PlanTabView;
import by.telecom.task.client.ui.TaskTabView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Task implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TaskTabView taskView = new TaskTabView();
		PlanTabView planView = new PlanTabView();
		Presenter taskPresenter = new TaskTabPresenter(taskView);
		Presenter planPresenter = new PlanTabPresenter(planView);

		TabPanel tabPanel = new TabPanel();

		VerticalPanel t1 = new VerticalPanel();
		VerticalPanel t2 = new VerticalPanel();
		tabPanel.add(t1, "Задачи");
		tabPanel.add(t2, "План");
		tabPanel.selectTab(0);
		taskPresenter.go(t1);
		planPresenter.go(t2);
		RootPanel.get("task").add(tabPanel);
	}
}
