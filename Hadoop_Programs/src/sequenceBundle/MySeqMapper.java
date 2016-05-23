package sequenceBundle;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sequenceBundle.LogWriter;

public class MySeqMapper extends Mapper<Text, Text, Text, NullWritable> {

	private static final Log LOG = LogFactory.getLog(MySeqMapper.class);

	// Fprivate Text videoName = new Text();

	public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
		try {

			InputStream is = new ByteArrayInputStream(value.toString().getBytes());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("employee");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					String name = eElement.getElementsByTagName("username").item(0).getTextContent();
					//String age = eElement.getElementsByTagName("age").item(0).getTextContent();

					// System.out.println(id + "," + name + "," + gender);
					context.write(new Text(id + "," + name ), NullWritable.get());

				}
			}
		} catch (Exception e) {
			LogWriter.getInstance().WriteLog(e.getMessage());
		}

	}
}