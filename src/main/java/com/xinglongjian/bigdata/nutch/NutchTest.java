package com.xinglongjian.bigdata.nutch;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.LocalJobRunner;
import org.apache.nutch.crawl.InjectorJob;
import org.apache.nutch.metadata.Nutch;

public class NutchTest {
	
	public static void main(String[] args) throws IllegalArgumentException, Exception {
		
		Configuration conf=new Configuration();
		conf.set(Nutch.CRAWL_ID_KEY, "TestCrawl");
		InjectorJob job=new InjectorJob(conf);
		
		NutchTest nt=new NutchTest();
		ClassLoader cl=nt.getClass().getClassLoader();
		String readfilepath=cl.getResource("nutch/urls/seek.txt").getFile();
		job.inject(new Path(readfilepath));
		System.out.println("Finished!");
		
		LocalJobRunner d;
	}

}
