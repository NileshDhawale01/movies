package com.nsd.movies.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;

public class EntityUtils {
	private EntityUtils() {

	}

	/**
	 * This method returns total columns of a given entity.
	 * 
	 * @param entityClass
	 * @return ColumnsCount
	 */
	public static int getColumnsCount(Class<?> entityClass) {
		if (entityClass.isAnnotationPresent(Entity.class)) {
			Field[] fields = entityClass.getDeclaredFields();
			return fields.length;
		} else {
			throw new IllegalArgumentException("Class is not a JPA entity.");
		}
	}

	/**
	 * This method returns column names of a given entity.
	 * 
	 * @param entityClass
	 * @return columnNames
	 */
	public static List<String> getColumnNames(Class<?> entityClass) {
		if (entityClass.isAnnotationPresent(Entity.class)) {
			Field[] fields = entityClass.getDeclaredFields();
			List<String> columnNames = new ArrayList<>();

			for (Field field : fields) {
				if (!field.isSynthetic()) { // Exclude synthetic fields
					columnNames.add(field.getName());
				}
			}
			return columnNames;
		} else {
			throw new IllegalArgumentException("Class is not a JPA entity.");
		}
	}
}
