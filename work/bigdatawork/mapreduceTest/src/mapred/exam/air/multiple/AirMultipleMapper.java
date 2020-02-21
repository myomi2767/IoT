package mapred.exam.air.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//하둡을 입력할 때 사용자가 입력하는 옵션을 Mapper내부에서 사용할 수 있도록 옵션이 어떤 값으로 입력되었냐에 따라 다른 작업을 할 수 있도록 척리
public class AirMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			String month = line[1];
			if(line!=null&line.length>0){
				//출발지연
				if(!line[15].equals("NA")&&Integer.parseInt(line[15])>0) {
					outputKey.set("departure,"+month);
					context.write(outputKey, outputVal);
				}else if(line[15].equals("NA")) {
					outputKey.set("departureNA,"+month);
					context.write(outputKey, outputVal);
				}
				if(!line[14].equals("NA")&&Integer.parseInt(line[14])>0) {
					//도착지연
					outputKey.set("arrival,"+month);
					context.write(outputKey, outputVal);
				}else if(line[14].equals("NA")) {
					outputKey.set("arrivalNA,"+month);
					context.write(outputKey, outputVal);
				}
			}
		}
	}
	
	

}
