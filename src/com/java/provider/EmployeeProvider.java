package com.java.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebService;

import com.java.domain.*;

@WebService
public class EmployeeProvider {

	public EmployeeProvider() {
		loadEmployeeMap();
	}

	private Map<Integer, Employee> employeeMap;

	private HashMap<Integer, Employee> loadEmployeeMap() {
		employeeMap = new HashMap<>();
		employeeMap.put(1, new Employee(1, "praveen", "plano"));
		employeeMap.put(2, new Employee(2, "richard", "irving"));
		employeeMap.put(3, new Employee(3, "champak", "richardson"));

		return (HashMap<Integer, Employee>) employeeMap;

	}

	public Collection<Employee> list() {
		return employeeMap.values();
	}

	public boolean findEmployee(int id) {
		if (employeeMap.containsKey(id))
			return true;
		else
			return false;
	}

	public Collection<Employee> findByName(String name) {

		List<Employee> list = new ArrayList<>();
		for (Entry<Integer, Employee> entry : employeeMap.entrySet()) {
			if (entry.getValue().getName().equals(name))
				list.add(entry.getValue());
		}
		return list;
	}

	public Boolean add(int id, String name, String address) {
		if (employeeMap.containsKey(id)) {
			return false;
		}
		employeeMap.put(id, new Employee(id, name, address));
		return true;
	}

	public Boolean update(int id, String name, String address) {
		if (employeeMap.containsKey(id)) {
			employeeMap.put(id, new Employee(id, name, address));
			return true;
		}
		return false;

	}

	public Boolean remove(int id) {
		if (employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return true;
		}
		return false;

	}

}
