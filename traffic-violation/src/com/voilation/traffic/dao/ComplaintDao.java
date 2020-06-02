package com.voilation.traffic.dao;

import java.util.List;

import com.voilation.traffic.model.Complaint;

public interface ComplaintDao {
	int saveComplaint(Complaint complaint);
	
	List<Complaint> viewComplaints();

	List<Complaint> getPaidComplaints();
	
	Complaint getComplaintById(String parameter);

	int updateComplaint(Complaint complaint);
	
	List<Complaint> viewUserComplaints(String regNo, String status);
}
