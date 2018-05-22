import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TaskMonitor
{
	public  static final String VERSION   = "Version 2.0.0";
	private static       Logger s_logger = Logger.getLogger("TaskMonitor");

	private String  m_cfgFile = null;
	private Properties m_cfgProp = null;
	private TaskDB2 m_taskDB2 = null;

	public static Logger GetLogger()
	{
		return s_logger;
	}

	public static String GetPID()
	{
		return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	}

	public TaskMonitor(String cfg_file)
	{
		m_cfgFile = cfg_file;
	}

	public void Init() throws ClassNotFoundException, FileNotFoundException, IOException, InstantiationException, IllegalAccessException, SQLException
	{
		ReadConfig();
		InitDB2();

		s_logger.info("Init OK.");
	}

	private void ReadConfig() throws FileNotFoundException, IOException
	{
		FileInputStream file_input = new FileInputStream(m_cfgFile);

		m_cfgProp = new Properties();
		m_cfgProp.load(file_input);
		//s_logger.info(m_cfgProp);
	}

	private void InitDB2() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, SQLException
	{
		m_taskDB2 = new TaskDB2(m_cfgProp);
		m_taskDB2.Connect();
		m_taskDB2.Disconnect();
	}

	public static void main(String[] argv)
	{
		if ( argv.length != 2 )
		{
			System.out.println("[usage] LOG_PROPERTIES CONFIGURATION_FILE");
			return;
		}

		// 初始化日志配置
		PropertyConfigurator.configure(argv[0]);

		Logger logger = TaskMonitor.GetLogger();
		logger.info(TaskMonitor.VERSION+" [PID="+TaskMonitor.GetPID()+"]");

		TaskMonitor tm = new TaskMonitor(argv[1]);

		try
		{
			tm.Init();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			logger.error(e.getMessage());
			return;
		}

		logger.info("TaskMonitor quit. [PID="+TaskMonitor.GetPID()+"]");
	}
}

