package by.telecom.task.client.presenter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import by.telecom.task.client.service.EmployeeService;
import by.telecom.task.client.service.EmployeeServiceAsync;
import by.telecom.task.client.service.TaskService;
import by.telecom.task.client.service.TaskServiceAsync;
import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class PlanTabPresenter implements Presenter {

	public interface Display {
		void setEmployeeList(List<Employee> employeeData);

		void setPlanList(List<Task> taskData, int day);

		void setMonthList(List<String> monthList);

		HasChangeHandlers getEmployeeComboBox();

		HasChangeHandlers getMonthComboBox();

		int getChangedEmployee();

		int getMonthRow();

		Widget asWidget();
	}

	private static final int YEAR = 2015;
	private static final String[] MONTHS = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Ноябрь", "Декабрь" };
	private final Display display;
	private List<Employee> employeeAll;
	private EmployeeServiceAsync emplRpcService = GWT.create(EmployeeService.class);
	private TaskServiceAsync taskRpcService = GWT.create(TaskService.class);
	private static final Logger logger = Logger.getLogger(PlanTabPresenter.class.getName());

	public PlanTabPresenter(Display display) {
		this.display = display;
	}

	@Override
	public void go(HasWidgets container) {
		container.add(display.asWidget());
		fetchEmployeeAll();
		setMonthOfYear();
		bind();

	}

	private void fetchEmployeeAll() {
		emplRpcService.getAll(new AsyncCallback<List<Employee>>() {
			public void onFailure(Throwable caught) {
				logger.info("Async callback don`t work");
			}

			public void onSuccess(List<Employee> emplAll) {
				logger.info("Async callback is working");
				display.setEmployeeList(emplAll);
				employeeAll = emplAll;
				chooseSelectedEmployeeMonth(0, 0);
			}
		});
	}

	private void bind() {

		ChangeHandler changeHandler = new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				chooseSelectedEmployeeMonth(display.getChangedEmployee(), display.getMonthRow());
			}
		};

		display.getEmployeeComboBox().addChangeHandler(changeHandler);
		display.getMonthComboBox().addChangeHandler(changeHandler);

	}

	private void chooseSelectedEmployeeMonth(int selectedRow, int month) {
		Employee employee = employeeAll.get(selectedRow);
		Date firstDay = getFirstDay(month);
		Date lastDay = getLastDay(month);
		final int day = lastDay.getDate();
		taskRpcService.getByEmployeeMonth(employee, firstDay, lastDay, new AsyncCallback<List<Task>>() {
			public void onFailure(Throwable caught) {
				Window.alert("Error deleting selected contacts");
			}

			@Override
			public void onSuccess(List<Task> result) {
				display.setPlanList(result, day);
			}
		});
	}

	private void setMonthOfYear() {
		display.setMonthList(Arrays.asList(MONTHS));
	}

	private Date getFirstDay(int month) {
		Date firstDay = new Date(YEAR - 1900, month, 1); // формат года для объекта Data (текущий год - 1900)
		return firstDay;
	}

	private Date getLastDay(int month) {
		Date lastDay = new Date(YEAR - 1900, month + 1, 0);
		return lastDay;
	}
}
