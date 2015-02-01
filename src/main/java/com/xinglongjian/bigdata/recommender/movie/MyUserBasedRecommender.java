package com.xinglongjian.bigdata.recommender.movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class MyUserBasedRecommender {
	private static String writeFilePath=null;
	
	private static void CreateCsvRatingsFile() throws FileNotFoundException, IOException {
		ClassLoader cl=MyUserBasedRecommender.class.getClassLoader();
		String readfilepath=cl.getResource("movies/ml-1m/ratings.dat").getFile();
		writeFilePath=cl.getResource("movies/ml-1m/").getPath()+"ratings.csv";
		//+"movies/ml-1m/ratings.csv"
		BufferedReader br = new BufferedReader(new FileReader(readfilepath));    
		BufferedWriter bw = new BufferedWriter(new FileWriter(writeFilePath)); 
		
		String line = null;  
		String line2write = null;  
		String[] temp;  
		int i = 0;  
		while ((line = br.readLine()) != null&&i < 10000) {  
			i++;  
			temp = line.split("::");  
			line2write = temp[0] + "," + temp[1]+","+temp[2];  
			bw.write(line2write);  
			bw.newLine();  
			bw.flush();    
			}          
		br.close();  
		bw.close(); 
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, TasteException {
		CreateCsvRatingsFile();
		// create data source (model) - from the csv file
	    File ratingsFile = new File(writeFilePath);          
		DataModel model = new FileDataModel(ratingsFile); 
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		
		List<RecommendedItem> recommendations = recommender.recommend(2, 3);
		
		for (RecommendedItem recommendation : recommendations) {
		  System.out.println(recommendation);
		}
	}
}
