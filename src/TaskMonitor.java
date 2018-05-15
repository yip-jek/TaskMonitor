//import java.lang.Exception;

class TaskMonitor
{
	public static void main(String[] str) throws Exception
	{
		if ( str.length != 2 )
		{
			throw new Exception("[usage] LOG_ID CONFIGURATION_FILE");
		}

		System.out.println("LOG_ID: "+str[0]);
		System.out.println("CONFIG: "+str[1]);
	}
}

