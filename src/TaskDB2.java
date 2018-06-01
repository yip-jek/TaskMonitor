import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.log4j.Logger;

public class TaskDB2
{
	private static Logger s_logger = Logger.getLogger("TaskDB2");

	public static final String DB_NAME_KEY = "DB.Name";
	public static final String DB_USER_KEY = "DB.User";
	public static final String DB_PWD_KEY  = "DB.Password";

	private String m_dbName = null;
	private String m_dbUsr  = null;
	private String m_dbPwd  = null;

	private Connection m_db2Conn = null;

	public TaskDB2(Properties prop) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		m_dbName = GetDBProperty(prop, DB_NAME_KEY);
		m_dbUsr  = GetDBProperty(prop, DB_USER_KEY);
		m_dbPwd  = GetDBProperty(prop, DB_PWD_KEY);

		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
	}

	private String GetDBProperty(Properties prop, String key) throws IOException
	{
		String str_val = prop.getProperty(key);

		if ( null == str_val )
		{
			throw new IOException("The property (KEY="+key+") not found! "+ClassInfo.GetCurrFilePosition());
		}

		return str_val;
	}

	public String GetDBName()
	{
		return m_dbName;
	}

	public String GetDBUser()
	{
		return m_dbUsr;
	}

	public String GetDBPassword()
	{
		return m_dbPwd;
	}

	public void Connect() throws SQLException
	{
		String url = "jdbc:db2:" + m_dbName;
		s_logger.info("Connect to <"+url+"> ...");

		m_db2Conn = DriverManager.getConnection(url, m_dbUsr, m_dbPwd);
		s_logger.info("Connect to <DB2:"+m_dbName+"> OK.");
	}

	public void Disconnect() throws SQLException
	{
		if ( m_db2Conn != null && !m_db2Conn.isClosed() )
		{
			m_db2Conn.close();
		}

		s_logger.info("<DB2:"+m_dbName+"> disconnected!");
	}

	public void TestSelectSQL(String sel_sql) throws SQLException
	{
		s_logger.info("Execute SQL: "+sel_sql);

		PreparedStatement pstm = m_db2Conn.prepareStatement(sel_sql);
		ResultSet         rs   = pstm.executeQuery();

		StringBuffer      s_buf;
		ResultSetMetaData rs_md = rs.getMetaData();

		final int MAX_COLUMN_COUNT = rs_md.getColumnCount();
		for ( int i = 1; i <= MAX_COLUMN_COUNT; ++i )
		{
			s_buf = new StringBuffer(i+") ");
			s_buf.append("[Label="+rs_md.getColumnLabel(i)+"] ");
			s_buf.append("[Name="+rs_md.getColumnName(i)+"] ");
			s_buf.append("[Type="+rs_md.getColumnType(i)+"] ");
			s_buf.append("[TypeName="+rs_md.getColumnTypeName(i)+"] ");
			s_logger.info(s_buf.toString());
		}

		int rs_count = 0;
		while ( rs.next() )
		{
			// 清空
			s_buf = new StringBuffer(++rs_count+") ");

			for ( int i = 1; i <= MAX_COLUMN_COUNT; ++i )
			{
				s_buf.append("["+rs.getString(i)+"] ");
			}

			s_logger.info(s_buf.toString());
		}
	}
}

