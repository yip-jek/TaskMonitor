import org.apache.log4j.*;

public class TaskMonitor
{
	private long   m_logID = 0;
	private String m_cfgfile;

	public void SetLogID(String str_logid)
	{
		m_logID = Long.valueOf(str_logid);
	}

	public void SetCfgFile(String str_cfg)
	{
		m_cfgfile = str_cfg;
	}

	public long GetLogID()
	{
		return m_logID;
	}

	public String GetCfgFile()
	{
		return m_cfgfile;
	}

	private static Logger logger = LogManager.getLogger(TaskMonitor.class.getName());

	public static void main(String[] str)
	{
		if ( str.length != 2 )
		{
			System.out.println("[usage] LOG_ID CONFIGURATION_FILE");
			return;
		}

		PropertyConfigurator.configure("/home/ej/files/workspaces/TaskMonitor/etc/log4j2.properties");
		Logger logger = LogManager.getLogger(TaskMonitor.class.getName());

		logger.debug("Debug message.");
		logger.error("Error message!");

		//System.out.println("[IN] LOG_ID: "+str[0]);
		//System.out.println("[IN] CONFIG: "+str[1]);

		//TaskMonitor tm = new TaskMonitor();
		//tm.SetLogID(str[0]);
		//tm.SetCfgFile(str[1]);

		//System.out.println("[OUT] LOG_ID: "+tm.GetLogID());
		//System.out.println("[OUT] CONFIG: "+tm.GetCfgFile());
	}
}

