import org.apache.log4j.Logger;

public class TaskMonitor
{
	private Logger m_logger = Log.Instance();
	private String m_cfgfile;

	public TaskMonitor(String cfg_file)
	{
		m_logger.info("CFG_FILE: "+cfg_file);
	}

	public String GetCfgFile()
	{
		return m_cfgfile;
	}

	public static void main(String[] argv)
	{
		if ( argv.length != 2 )
		{
			System.out.println("[usage] LOG_PROPERTIES CONFIGURATION_FILE");
			return;
		}

		Log.SetProp(argv[0]);
		Log.Instance().info("Version 2.00");

		TaskMonitor tm = new TaskMonitor(argv[1]);
	}
}

