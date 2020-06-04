package com.club.cricket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.club.cricket.model.Feedback;
import com.club.cricket.util.ConnectionDb;

public class FeedbackDaoImpl implements FeedbackDao {

	private Statement stmt;

    public FeedbackDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int saveFeedback(Feedback feedback) {
		try {
            String query = "INSERT INTO FEEDBACK (EVENTNAME,FEEDBACKBY,EMAILID,RATING,COMMENTS) VALUES ('" +feedback.getEventName()+ "','" +feedback.getFeedbackBy()+ "','" +feedback.getEmailId()+ "','" +feedback.getRating()+ "','" +feedback.getComments()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            return 0;
        }
	}

	@Override
    public List<Feedback> viewFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            String query = "SELECT * FROM FEEDBACK";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackId(rs.getInt("FEEDBACKID"));
				feedback.setEventName(rs.getString("EVENTNAME"));
				feedback.setFeedbackBy(rs.getString("FEEDBACKBY"));
				feedback.setEmailId(rs.getString("EMAILID"));
				feedback.setRating(rs.getInt("RATING"));
				feedback.setComments(rs.getString("COMMENTS"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

}

