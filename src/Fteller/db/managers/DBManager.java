package Fteller.db.managers;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import javax.sql.DataSource;



public abstract class DBManager {

	protected DataSource Source;

	
	
	/*
	* Enum used to represent matching type for SQL statement.
	*/
	protected enum MatchType {
			EXACT, LIKE
	};
	
	
	public DBManager(DataSource Source) {
		this.Source = Source;
	}
	
	
	
	
	public void changeDataSource(DataSource newSource) {
		this.Source = newSource;
	}
	
	
	protected void executeInsert(String tableName, List<String> values) {
		executeInsert(tableName, new ArrayList<String>(), values);
	}
	
	
	protected void executeInsert(String tableName, List<String> columnNames,
			List<String> values) {
		try {
			Connection con = Source.getConnection();
			String query = generateInsertQuery(tableName, columnNames, values);
			PreparedStatement statement = con.prepareStatement(query);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void executeSimpleUpdate(String tableName, List<String> columns,
			List<String> values, String whereCol, String whereVal) {
	
		List<String> whereCols = new ArrayList<String>();
		List<String> whereVals = new ArrayList<String>();
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		whereCols.add(whereCol);
		whereVals.add(whereVal);
		matchTypes.add(MatchType.EXACT);
		executeUpdate(tableName, columns, values, whereCols, whereVals,
				matchTypes);
	}
	
	
	protected void executeSimpleUpdate(String tableName, String column,
			String value, String whereCol, String whereVal) {
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<String> whereCols = new ArrayList<String>();
		List<String> whereVals = new ArrayList<String>();
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		columns.add(column);
		values.add(value);
		whereCols.add(whereCol);
		whereVals.add(whereVal);
		matchTypes.add(MatchType.EXACT);
		executeUpdate(tableName, columns, values, whereCols, whereVals,
				matchTypes);
	}
	
	protected void executeUpdate(String tableName, List<String> columns,
			List<String> values, List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		try {
			Connection con = Source.getConnection();
			String query = generateUpdateQuery(tableName, columns, values,
					whereCols, whereVals, matchTypes);
			PreparedStatement statement = con.prepareStatement(query);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void executeSimpleDelete(String tableName, String whereCol,
			String whereVal) {
		List<String> whereCols = new ArrayList<String>();
		List<String> whereVals = new ArrayList<String>();
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		whereCols.add(whereCol);
		whereVals.add(whereVal);
		matchTypes.add(MatchType.EXACT);
		executeDelete(tableName, whereCols, whereVals, matchTypes);
	}
	
	
	protected void executeDelete(String tableName, List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		try {
			Connection con = Source.getConnection();
			String query = generateDeleteQuery(tableName, whereCols, whereVals,
					matchTypes);
			PreparedStatement statement = con.prepareStatement(query);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected String generateInsertQuery(String tableName,
			List<String> columnNames, List<String> values) {
		StringBuilder builder = new StringBuilder("INSERT INTO ");
		builder.append(tableName + " ");
		builder.append(generateColumnsString(columnNames));
		builder.append("VALUES (");
		if (!values.isEmpty()) {
			for (int i = 0; i < values.size(); ++i) {
				if (values.get(i) != null)
					builder.append("\"" + values.get(i) + "\"");
				else
					builder.append("null");
				if (i != values.size() - 1)
					builder.append(", ");
			}
		}
		builder.append(");");
		return builder.toString();
	}
	
	
	protected String generateUpdateQuery(String tableName,
			List<String> columns, List<String> values, List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder();
		builder.append(generateUpdateSetPart(tableName, columns, values));
		builder.append(generateComplexWhere(whereCols, whereVals, matchTypes));
		return builder.toString();
	}
	
	
	protected String generateSimpleSelectQuery(String tableName,
			List<String> columns, String whereCol, String whereVal) {
		List<String> whereCols = new ArrayList<String>();
		List<String> whereVals = new ArrayList<String>();
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		whereCols.add(whereCol);
		whereVals.add(whereVal);
		matchTypes.add(MatchType.EXACT);
		return generateSelectQuery(tableName, columns, whereCols, whereVals,
				matchTypes);
	}
	
	
	protected String generateSelectQuery(String tableName,
			List<String> columns, List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder("SELECT ");
		if (columns.isEmpty())
			builder.append("* ");
		else
			builder.append(generateColumnsString(columns));
		builder.append("FROM " + tableName);
		builder.append(generateComplexWhere(whereCols, whereVals, matchTypes));
		return builder.toString();
	}
	
	
	protected String generateDeleteQuery(String tableName,
			List<String> whereCols, List<String> whereVals,
			List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder("DELETE FROM ");
		builder.append(tableName);
		builder.append(generateComplexWhere(whereCols, whereVals, matchTypes));
		return builder.toString();
	}
	
	
	private String generateUpdateSetPart(String tableName,
			List<String> columns, List<String> values) {
		StringBuilder builder = new StringBuilder("UPDATE ");
		builder.append(tableName + " ");
		builder.append("SET ");
		for (int i = 0; i < columns.size(); ++i) {
			builder.append(columns.get(i) + " = ");
			if (values.get(i) != null)
				builder.append("\"" + values.get(i) + "\"");
			else
				builder.append("null");
			if (i != values.size() - 1)
				builder.append(", ");
		}
		return builder.toString();
	}
	
	
	private String generateColumnsString(List<String> columnNames) {
		StringBuilder builder = new StringBuilder();
		if (!columnNames.isEmpty()) {
			builder.append("(");
			for (int i = 0; i < columnNames.size(); ++i) {
				builder.append(columnNames.get(i));
				if (i != columnNames.size() - 1)
					builder.append(", ");
			}
			builder.append(") ");
		}
		return builder.toString();
	}
	
	
	private String generateComplexWhere(List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder(" WHERE ");
		for (int i = 0; i < whereCols.size(); ++i) {
			builder.append(whereCols.get(i) + " ");
			// building for partial matching
			if (matchTypes.get(i) == MatchType.LIKE) {
				builder.append("LIKE ");
				if (whereVals.get(i) != null)
					builder.append("\"%" + whereVals.get(i) + "%\"");
				else
					builder.append("null");
			} else {
				// building for exact matching
				builder.append("= ");
				if (whereVals.get(i) != null)
					builder.append("\"" + whereVals.get(i) + "\"");
				else
					builder.append("null");
			}
			// supporting only "AND" conjunction
			if (i != whereCols.size() - 1)
				builder.append(" AND ");
		}
		builder.append(";");
		return builder.toString();
	}
	
	
	
}