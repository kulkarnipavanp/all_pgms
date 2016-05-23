package WordCount_R;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class wordCount {

	public static class yourmapper extends Mapper<LongWritable, Text, Text, IntWritable> {


		Text word = new Text();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens()) {
				word.set(tokenizer.nextToken());
				context.write(word, new IntWritable(1));
			}
		}
	}

	/*public static class Mypartion extends Partitioner<Text, IntWritable> {

		@Override
		public int getPartition(Text arg0, IntWritable arg1, int arg2) {
			// TODO Auto-generated method stub

			if (arg0.toString().equals("india")) {
				return arg2 - 1;
			}

			return arg2 - 1;
		}
	 */


	public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

			int sum = 0;

			for (IntWritable val : values) {

				sum += val.get();

			}
			context.write(key, new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws IOException {
		try {
			Configuration conf = new Configuration();

			String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
			/*conf.set("filter", "india");
			conf.set("ParameterPath", otherArgs[0].toString());
			DistributedCache.addCacheFile(new URI(otherArgs[0].toString()), conf);
			// DistributedCache.addCacheFile(new URI(otherArgs[1].toString()),
			 */			// conf);
			Job job = new Job(conf, "Word Count Example");

			job.setJarByClass(wordCount.class);

			job.setMapperClass(yourmapper.class);
			//job.setPartitionerClass(Mypartion.class);
			//job.setCombinerClass(MyReducer.class);
			job.setReducerClass(MyReducer.class);
			// job.setNumReduceTasks(3);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

			// Boolean complete = job.waitForCompletion(true);
			System.exit(job.waitForCompletion(true) ? 0 : 1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
