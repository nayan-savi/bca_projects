package college.custom.model;

public class FlowerOrder {
    private int orderId;
    private String flowerName;
    private String flowerCost;
    private String requestDate;
    private String deliveredDate;
    private String username;
    private int employeeId;
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

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerCost() {
        return flowerCost;
    }

    public void setFlowerCost(String flowerCost) {
        this.flowerCost = flowerCost;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
