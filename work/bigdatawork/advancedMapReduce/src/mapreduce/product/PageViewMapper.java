package mapreduce.product;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper extends Mapper<LongWritable, Text, MyKey, Text>{
	//static final IntWritable outputVal = new IntWritable(1);
	Text outputVal = new Text();
	MyKey outputKey = new MyKey();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, Text>.Context context)
			throws IOException, InterruptedException {
		String[] line = value.toString().split("	"); //총 11개
		outputKey.setProductId(line[2]);
		outputKey.setUserId(line[9]);
		outputVal.set(outputKey.getUserId());
		context.write(outputKey, outputVal);
		
	}
}
