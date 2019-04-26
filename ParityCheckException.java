package lab11;

import java.util.IllegalFormatFlagsException;

public class ParityCheckException
	extends IllegalFormatFlagsException {
	public ParityCheckException(String message)
	{
		super(message);
	}
}
