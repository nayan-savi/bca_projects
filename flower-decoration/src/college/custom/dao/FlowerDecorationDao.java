package college.custom.dao;

import college.custom.model.Decoration;
import college.custom.model.DecorationOrder;
import college.custom.model.Flower;
import college.custom.model.FlowerOrder;

import java.util.List;

public interface FlowerDecorationDao {
    int save(Flower flower);
    int saveFlowerRequest(FlowerOrder flowerOrder);
    int saveDecorationRequest(DecorationOrder decorationOrder);
    List<Flower> getAllFlowers();
    List<Decoration> getAllDecorations();
    List<FlowerOrder> viewFlowerOrder(String username, int employeeId);
    List<DecorationOrder> viewDecorationOrder(String username, int employeeId);
    List<FlowerOrder> getPendingFlowerOrderManager();
    List<DecorationOrder> getPendingDecorationOrderManager();
    int modifyFlowerOrderManager(FlowerOrder flowerOrder);
    FlowerOrder getFlowerOrder(int orderId);
    DecorationOrder getDecorationOrder(int orderId);
    int modifyDecorationOrderManager(DecorationOrder decorationUpdateOrder);
}
