package by.telecom.task.server.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	/*
	 * Returns list of entities
	 */
	List<T> getAll(Class<T> classT);

}
