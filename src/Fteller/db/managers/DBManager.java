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
	
	/**
	 * Constructor for DbManager object with provided DataSource object.
	 * 
	 * @param Source
	 *            DataSource object representing connection pool.
	 */
	public DBManager(DataSource Source) {
		this.Source = Source;
	}
	
	
	
	/**
	 * Changes internal DataSource object with the new provided one.
	 * 
	 * @param newSource
	 *            New Source object representing connection pool.
	 */
	public void changeDataSource(DataSource newSource) {
		this.Source = newSource;
	}
	
	/*
	 * Executes INSERT statement from given table name and values for all
	 * columns.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param values The list containing values for all columns.
	 */
	protected void executeInsert(String tableName, List<String> values) {
		executeInsert(tableName, new ArrayList<String>(), values);
	}
	
	/*
	 * Executes INSERT statement from given table name, column names and values
	 * for selected column names.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param columnNames The list containing column names for insertion.
	 * 
	 * @param values The list containing values for selected column names.
	 */
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
	
	/*
	 * Executes a very simple (single where condition with exact match) UPDATE
	 * statement from given table name, column names to be affected, values for
	 * selected column names and where clause. Default matching type is EXACT
	 * matching.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param columns The list containing column names to be updated.
	 * 
	 * @param values The list containing values for selected column names.
	 * 
	 * @param whereCol Column name for where clause.
	 * 
	 * @param whereVal Column value for where clause.
	 */
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
	
	/*
	 * Executes a very simple (single where condition with exact match) UPDATE
	 * statement from given table name, column names to be affected, values for
	 * selected column names and where clause. Default matching type is EXACT
	 * matching.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param column Column name to be updated.
	 * 
	 * @param value Value for selected column names.
	 * 
	 * @param whereCol Column name for where clause.
	 * 
	 * @param whereVal Column value for where clause.
	 */
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
	
	/*
	 * Executes UPDATE statement from given table name, column names to be
	 * affected, values for selected column names and column names, column
	 * values and match types for where clause.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param columns The list containing column names to be updated.
	 * 
	 * @param values The list containing values for selected column names.
	 * 
	 * @param whereCols The list containing column names for where clause.
	 * 
	 * @param whereVals The list containing column values for where clause.
	 * 
	 * @param matchTypes The list containing match types for where clause.
	 */
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
	
	/*
	 * Executes a very simple (single where condition with exact match) DELETE
	 * statement from given table name and where clause. Default matching type
	 * is EXACT matching.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param whereCol Column name for where clause.
	 * 
	 * @param whereVal Column value for where clause.
	 */
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
	
	/*
	 * Executes DELETE statement from given table name and column names, column
	 * values and match types for where clause.
	 * 
	 * @param tableName The name of the table to be affected.
	 * 
	 * @param whereCols The list containing column names for where clause.
	 * 
	 * @param whereVals The list containing column values for where clause.
	 * 
	 * @param matchTypes The list containing match types for where clause.
	 */
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
	
	/*
	 * Generates INSERT query from given table name, column names and values for
	 * selected column names.
	 */
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
	
	/*
	 * Generates UPDATE query from given table name, column names to be
	 * affected, values for selected column names and column names, column
	 * values and match types for where clause.
	 */
	protected String generateUpdateQuery(String tableName,
			List<String> columns, List<String> values, List<String> whereCols,
			List<String> whereVals, List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder();
		builder.append(generateUpdateSetPart(tableName, columns, values));
		builder.append(generateComplexWhere(whereCols, whereVals, matchTypes));
		return builder.toString();
	}
	
	/*
	 * Generates simple SELECT query from given table name, column names to be
	 * retrieved and simple where clause with EXACT match by default.
	 */
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
	
	/*
	 * Generates SELECT query from given table name, column names to be
	 * retrieved, where clause and match types for where clause.
	 */
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
	
	/*
	 * Generates DELETE query from given table name and column names, column
	 * values and match types for where clause.
	 */
	protected String generateDeleteQuery(String tableName,
			List<String> whereCols, List<String> whereVals,
			List<MatchType> matchTypes) {
		StringBuilder builder = new StringBuilder("DELETE FROM ");
		builder.append(tableName);
		builder.append(generateComplexWhere(whereCols, whereVals, matchTypes));
		return builder.toString();
	}
	
	/*
	 * Generates the UPDATE table_name SET field1=new-value1, field2=new-value2,
	 * ..., fieldn=new-valuen part for the UPDATE query.
	 */
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
	
	/*
	 * Generates a query string representing a sequence of column names in
	 * (col1, col2, col3, col4, ... , coln) format.
	 */
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
	
	/*
	 * Generates complex WHERE part of the query. Note: it doesn't support
	 * different conjunctions at the time, only "AND" conjunction (no "OR").
	 */
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