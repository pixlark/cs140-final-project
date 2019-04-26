package lab11;

import java.util.Arrays;

public class Memory {
	public static final int DATA_SIZE = 512;
	private int[] data = new int[DATA_SIZE];

	int[] getData()
	{
		return data;
	}
	
	int[] getData(int min, int max)
	{
		if (min < 0 || min >= DATA_SIZE ||
			max < 0 || max >= DATA_SIZE) {
			throw new DataAccessException("Out of bounds.");
		}
		return Arrays.copyOfRange(data, min, max);
	}

	int getData(int index)
	{
		if (index < 0 || index >= DATA_SIZE) {
			throw new DataAccessException("Out of bounds.");
		}
		return data[index];
	}

	void setData(int index, int value)
	{
		if (index < 0 || index >= DATA_SIZE) {
			throw new DataAccessException("Out of bounds.");
		}
		data[index] = value;
	}

	void clearData()
	{
		for (int i = 0; i < DATA_SIZE; i++) {
			data[i] = 0;
		}
	}
}
