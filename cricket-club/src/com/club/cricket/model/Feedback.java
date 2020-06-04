package com.club.cricket.model;

public class Feedback {
	private int feedbackId;
	private String eventName;
	private String feedbackBy;
	private String emailId;
	private int rating;
	private String comments;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getFeedbackBy() {
		return feedbackBy;
	}
	public void setFeedbackBy(String feedbackBy) {
		this.feedbackBy = feedbackBy;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
