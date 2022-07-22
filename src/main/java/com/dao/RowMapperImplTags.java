package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entities.Tasks;

public class RowMapperImplTags  implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return rs.getString(1);
	}

}
