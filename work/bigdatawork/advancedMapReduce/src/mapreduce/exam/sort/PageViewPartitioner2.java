package mapreduce.exam.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PageViewPartitioner2 extends Partitioner<MyKey, Text>{
	@Override
	public int getPartition(MyKey key, Text value, int numPartitions) {
		return key.getProductId().hashCode() % numPartitions;
	}

}
