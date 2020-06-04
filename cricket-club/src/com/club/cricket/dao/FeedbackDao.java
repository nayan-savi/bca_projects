package com.club.cricket.dao;

import java.util.List;

import com.club.cricket.model.Feedback;

public interface FeedbackDao {
	int saveFeedback(Feedback feedback);
	
	 List<Feedback> viewFeedbacks();

}
