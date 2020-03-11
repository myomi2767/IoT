package mapreduce.product;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer extends Reducer<MyKey, Text, MyKey, Text>{
	Text resultVal = new Text();
	MyKey resultKey = new MyKey();
	
	@Override
	protected void reduce(MyKey key, Iterable<Text> values,
			Reducer<MyKey, Text, MyKey, Text>.Context context) throws IOException, InterruptedException {
		int userSum = 1;
		int clickSum = 0;
		StringBuffer sb = new StringBuffer();
		String beforeUserId = key.getUserId();
		
		for (Text value : values) {
			if(!beforeUserId.equals(key.getUserId())) {
				userSum++; //userSum += value.get();
			} 
			clickSum++;
			beforeUserId = key.getUserId();
		}
		resultKey.setProductId(key.getProductId());
		sb.append(userSum).append("	").append(clickSum);
		resultVal.set(sb.toString());
		context.write(resultKey, resultVal);
		
	}
}
