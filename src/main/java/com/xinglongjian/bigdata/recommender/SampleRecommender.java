package com.xinglongjian.bigdata.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.mapreduce.Counter;
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

/**
 * mahout 5 minutes example 
 * @author root
 *
 */
public class SampleRecommender {

	public static void main(String[] args) throws IOException, TasteException {
		// TODO Auto-generated method stub
		
		SampleRecommender sample=new SampleRecommender();
		ClassLoader cl=sample.getClass().getClassLoader();
		
		DataModel model = new FileDataModel(new File(cl.getResource("dataset.csv").getFile()));
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		List<RecommendedItem> recommendations = recommender.recommend(2, 3);
		for (RecommendedItem recommendation : recommendations) {
		  System.out.println(recommendation);
		}
		
	}

}
