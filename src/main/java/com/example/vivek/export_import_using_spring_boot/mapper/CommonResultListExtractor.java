package com.example.vivek.export_import_using_spring_boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CommonResultListExtractor<T> implements ResultSetExtractor<List<T>> {

	private CommonRowMapper<T> rowMapper;

	private int rowNumber = 0;

	public CommonResultListExtractor(CommonRowMapper<T> mongOrderListingRowMapper) {
		this.rowMapper = mongOrderListingRowMapper;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	@Override
	public List<T> extractData(ResultSet rs) throws SQLException, DataAccessException {
		rowNumber = 0;
		while (rs.next()) {
			rowMapper.mapRow(rs, rowNumber++);
		}
		return new ArrayList<>(rowMapper.getList());
	}

}