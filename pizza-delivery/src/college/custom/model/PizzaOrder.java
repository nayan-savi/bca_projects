package college.custom.model;

public class PizzaOrder {
    private int orderId;
    private String pizzaName;
    private String pizzaCost;
    private String requestDate;
    private String deliveredDate;
    private String orderBy;
    private String assignedTo;
    private String status;
    private String bargaining;
    private String finalRate;
    private String comment;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(String pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBargaining() {
		return bargaining;
	}
	public void setBargaining(String bargaining) {
		this.bargaining = bargaining;
	}
	public String getFinalRate() {
		return finalRate;
	}
	public void setFinalRate(String finalRate) {
		this.finalRate = finalRate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

    
}
