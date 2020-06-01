package com.voilation.traffic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.voilation.traffic.model.Complaint;
import com.voilation.traffic.util.ConnectionDb;



public class ComplaintDaoImpl implements ComplaintDao {
	
	private Statement stmt;

    public ComplaintDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int saveComplaint(Complaint complaint) {
		try {
            String query = "INSERT INTO COMPLAINT (REGNO,PAYMENTTYPE,PAYMENTDATE,FEE,REASON,STATUS,COMMENT) VALUES ('"+
            				complaint.getRegNo()+ "','" +complaint.getPaymentType()+ "','" +complaint.getPaymentDate()+ "','" +
            				complaint.getFee()+ "','" +complaint.getReason()+ "','" +complaint.getStatus()+ "','" +complaint.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public List<Complaint> viewComplaints() {
		List<Complaint> complaints = new ArrayList<>();
        try {
            String query = "SELECT * FROM COMPLAINT WHERE STATUS IN ('NotPaid')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Complaint complaint = new Complaint();
                complaint.setComplaintId(rs.getInt("COMPLAINTID"));
				complaint.setRegNo(rs.getString("REGNO"));
				complaint.setPaymentType("");
				complaint.setPaymentDate("");
				complaint.setFee(rs.getDouble("FEE"));
				complaint.setReason(rs.getString("REASON"));
				complaint.setStatus(rs.getString("STATUS"));
				complaint.setComment(rs.getString("COMMENT"));
                complaints.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
	}
	
	@Override
	public List<Complaint> getPaidComplaints() {
		List<Complaint> complaints = new ArrayList<>();
        try {
            String query = "SELECT * FROM COMPLAINT WHERE STATUS IN ('Paid')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Complaint complaint = new Complaint();
                complaint.setComplaintId(rs.getInt("COMPLAINTID"));
				complaint.setRegNo(rs.getString("REGNO"));
				complaint.setPaymentType(rs.getString("PAYMENTTYPE"));
				complaint.setPaymentDate(rs.getString("PAYMENTDATE"));
				complaint.setFee(rs.getDouble("FEE"));
				complaint.setReason(rs.getString("REASON"));
				complaint.setStatus(rs.getString("STATUS"));
				complaint.setComment(rs.getString("COMMENT"));
                complaints.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
	}

	@Override
	public Complaint getComplaintById(String id) {
		Complaint complaint = new Complaint();
        try {
            String query = "SELECT * FROM COMPLAINT WHERE COMPLAINTID = ('"+id+"')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                complaint.setComplaintId(rs.getInt("COMPLAINTID"));
				complaint.setRegNo(rs.getString("REGNO"));
				complaint.setPaymentType("");
				complaint.setPaymentDate("");
				complaint.setFee(rs.getDouble("FEE"));
				complaint.setReason(rs.getString("REASON"));
				complaint.setStatus(rs.getString("STATUS"));
				complaint.setComment(rs.getString("COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaint;
	}

	@Override
	public int updateComplaint(Complaint complaint) {
		try {
            String query = "update complaint set paymenttype = '"+complaint.getPaymentType()+"', paymentDate = '"+complaint.getPaymentDate()
            +"', status = '"+complaint.getStatus()+"', comment= '"+complaint.getComment()+"' where complaintId = '"+complaint.getComplaintId()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}
	
	
	

	
}
