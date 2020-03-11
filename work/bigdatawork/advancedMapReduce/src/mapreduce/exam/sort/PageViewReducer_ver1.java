package mapreduce.exam.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer_ver1 extends Reducer<MyKey, IntWritable, Text, IntWritable>{
	IntWritable resultVal = new IntWritable();
	Text resultKey = new Text();
	
	@Override
	protected void reduce(MyKey key, Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int clickSum = 0; //하나의 상품이 클릭된 총 횟수
		String beforeUserId = key.getUserId();
		
		for (IntWritable value : values) {
			System.out.println(key.toString());
			if(!beforeUserId.equals(key.getUserId())) {
				
			} 
			clickSum+= value.get();
			beforeUserId = key.getUserId();
		}
		resultKey.set(key.getProductId());
		resultVal.set(clickSum);
		context.write(resultKey, resultVal);
		
	}
}
