package com.shinowit.messageboard.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapObject<E> {
	public E mapping(ResultSet rs) throws SQLException;
}
