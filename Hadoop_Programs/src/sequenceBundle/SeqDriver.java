package sequenceBundle;

import java.io.IOException;
import java.net.URISyntaxException;

//import mrd.training.sample.MyMapper;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

//import sequenceBundle.LogWriter;
import sequenceBundle.MySeqMapper;

public class SeqDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Configuration conf = new Configuration();
			// conf.setInt(FixedLengthInputFormat.FIXED_RECORD_LENGTH, 2048);

			// OR alternatively you can set it this way, the name of the
			// property is
			// "mapreduce.input.fixedlengthinputformat.record.length"
			// conf.setInt("mapreduce.input.fixedlengthinputformat.record.length",
			// 2048);
			String[] arg = new GenericOptionsParser(conf, args).getRemainingArgs();

			Job job = new Job(conf, "Seq Processing Processing");
			job.setJarByClass(SeqDriver.class);
			job.setMapperClass(MySeqMapper.class);

			job.setNumReduceTasks(0);

			job.setInputFormatClass(SequenceFileInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			//job.setOutputValueClass(TextOutputFormat.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(NullWritable.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(NullWritable.class);

			SequenceFileInputFormat.addInputPath(job, new Path(args[0]));
			// FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));

			job.waitForCompletion(true);

		} catch (Exception e) {
			LogWriter.getInstance().WriteLog("Driver Error: " + e.getMessage());
			System.out.println(e.getMessage().toString());
		}
		// job.setReducerClass(ClickReducer.class);

	}

}
