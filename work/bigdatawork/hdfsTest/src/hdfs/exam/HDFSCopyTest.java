package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSCopyTest {
	public static void main(String[] args) {
		//1. hdfs를 제어하기 위해서 설정 파일을 읽어서 사용해야 하므로
		//	 hadoop 설치 폴더의 설정 파일을 접근하기 위해 제공되는 클래스
		Configuration conf = new Configuration();
		//2. HDFS를 접근하기 위해서 제공되는 객체생성 - HDFS객체
		FileSystem hdfs = null;
		//3. HDFS로부터 input하기 위해 스트림객체
		
		FSDataInputStream hdfsin = null;
		FSDataOutputStream hdfsout = null;
		try {
			hdfs = FileSystem.get(conf);
			Path path1 = new Path(args[0]);
			Path path2 = new Path(args[1]);
			hdfsin = hdfs.open(path1);
			hdfsout = hdfs.create(path2);
			hdfsout.writeUTF(hdfsin.readUTF());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
