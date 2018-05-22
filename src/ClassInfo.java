import java.lang.Throwable;

public class ClassInfo
{
	private static final int CURRENT_INDEX  = 2;
	private static final int PREVIOUS_INDEX = 3;

	public static String GetCurrFileName()
	{
		return GetFileName(CURRENT_INDEX);
	}

	public static String GetPrevFileName()
	{
		return GetFileName(PREVIOUS_INDEX);
	}

	public static String GetCurrClassName()
	{
		return GetClassName(CURRENT_INDEX);
	}

	public static String GetPrevClassName()
	{
		return GetClassName(PREVIOUS_INDEX);
	}

	public static int GetCurrLineNumber()
	{
		return GetLineNumber(CURRENT_INDEX);
	}

	public static int GetPrevLineNumber()
	{
		return GetLineNumber(PREVIOUS_INDEX);
	}

	public static String GetCurrFilePosition()
	{
		return GetFilePosition(CURRENT_INDEX);
	}

	public static String GetPrevFilePosition()
	{
		return GetFilePosition(PREVIOUS_INDEX);
	}

	public static String GetFileName(int depth)
	{
		return new Throwable().getStackTrace()[depth].getFileName();
	}

	public static String GetClassName(int depth)
	{
		return new Throwable().getStackTrace()[depth].getClassName();
	}

	public static int GetLineNumber(int depth)
	{
		return new Throwable().getStackTrace()[depth].getLineNumber();
	}

	public static String GetFilePosition(int depth)
	{
		StackTraceElement element = new Throwable().getStackTrace()[depth];
		return ("[FILE:"+element.getFileName()+", LINE:"+element.getLineNumber()+"]");
	}
}

