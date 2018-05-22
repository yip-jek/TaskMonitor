import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}

