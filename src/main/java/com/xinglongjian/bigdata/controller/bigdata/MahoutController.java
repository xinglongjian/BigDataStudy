package com.xinglongjian.bigdata.controller.bigdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinglongjian.bigdata.recommender.movie.MyUserBasedRecommender;
import com.xinglongjian.bigdata.web.site.FrontUtils;
import com.xinglongjian.bigdata.web.site.SiteUtils;
import com.xinglongjian.bigdata.web.site.StudySite;

@Controller
public class MahoutController {

	@RequestMapping(value = "/mahout/movie", method = RequestMethod.GET)
	public String index(Locale locale, ModelMap model,
			HttpServletRequest request) {
		StudySite site = SiteUtils.getSiteFromRequest(request);
		FrontUtils.frontData(request, model, site);
		ClassLoader cl = MahoutController.class.getClassLoader();
		String writeFilePath = cl.getResource("movies/ml-1m/ratings.csv")
				.getFile();
		File ratingsFile = new File(writeFilePath);
		try {
			DataModel data = new FileDataModel(ratingsFile);
			LongPrimitiveIterator lp = data.getUserIDs();
			List<Long> userIds = new ArrayList<Long>();
			while (lp.hasNext()) {
				userIds.add(lp.next());
			}
			model.addAttribute("userIds", userIds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("menu", "bigdata");
		model.addAttribute("ddmenu", "mahout");
		model.addAttribute("submenu", "movie");
		return "mahout/movie";
	}

	@RequestMapping(value = "/mahout/recommender.json", method = RequestMethod.GET)
	public String recommender(Locale locale, ModelMap model,
			HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String nums = request.getParameter("nums");
		String similarityStr = request.getParameter("similarity");
		String neighborhoodStr = request.getParameter("neighborhood");
		String recommenderStr = request.getParameter("recommender");

		ClassLoader cl = MahoutController.class.getClassLoader();
		String writeFilePath = cl.getResource("movies/ml-1m/ratings.csv")
				.getFile();
		File ratingsFile = new File(writeFilePath);
		try {
			DataModel dataModel = new FileDataModel(ratingsFile);

			if (recommenderStr.equals("GenericUserBased")) {
				UserSimilarity similarity = null;
				if (similarityStr.equals("PearsonCorrelation")) {
					similarity = new PearsonCorrelationSimilarity(dataModel);
				} else if (similarityStr.equals("EuclideanDistance")) {
					similarity = new EuclideanDistanceSimilarity(dataModel);
				} else {
					similarity = new UncenteredCosineSimilarity(dataModel);
				}

				UserNeighborhood neighborhood = null;
				if (neighborhoodStr.equals("neiNearestn")) {
					neighborhood = new NearestNUserNeighborhood(
							Integer.parseInt(nums), similarity, dataModel);
				} else {
					neighborhood = new ThresholdUserNeighborhood(0.1,
							similarity, dataModel);
				}

				UserBasedRecommender userrecommender = null;
				userrecommender = new GenericUserBasedRecommender(dataModel,
						neighborhood, similarity);
				List<RecommendedItem> recommendations = userrecommender
						.recommend(Long.parseLong(userId),
								Integer.parseInt(nums));
				model.addAttribute("orders", recommendations);
			} else {
				ItemSimilarity itemSimilarity = null;
				if (similarityStr.equals("PearsonCorrelation")) {
					itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
				} else if (similarityStr.equals("EuclideanDistance")) {
					itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
				} else {
					itemSimilarity = new UncenteredCosineSimilarity(dataModel);
				}

				ItemBasedRecommender itemrecommender = null;
				itemrecommender = new GenericItemBasedRecommender(dataModel,
						itemSimilarity);

				List<RecommendedItem> recommendations = itemrecommender
						.recommend(Long.parseLong(userId),
								Integer.parseInt(nums));
				model.addAttribute("orders", recommendations);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "json";
	}

}
