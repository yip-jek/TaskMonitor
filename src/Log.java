import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log
{
	private static String _s_log_prop;
	private static Logger _s_logger = null;

	public static void SetProp(String log_prop)
	{
		_s_log_prop = log_prop;
	}

	public static Logger Instance()
	{
		if ( null == _s_logger )
		{
			PropertyConfigurator.configure(_s_log_prop);
			_s_logger = Logger.getLogger("TaskMonitor");
		}

		return _s_logger;
	}
}

