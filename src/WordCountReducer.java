import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException{

            int count = 0;
            Iterator valuesIt = values.iterator();
            while(valuesIt.hasNext()){
                valuesIt.next();
                count ++;
            }

            context.write(key, new IntWritable(count));

    }



}