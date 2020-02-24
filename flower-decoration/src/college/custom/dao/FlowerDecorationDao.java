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
    List<Flower> getActiveFlowers();
    List<Decoration> getActiveDecorations();
    List<FlowerOrder> viewFlowerOrder(String username, int employeeId);
    List<DecorationOrder> viewDecorationOrder(String username, int employeeId);
    List<FlowerOrder> getPendingFlowerOrderManager();
    List<DecorationOrder> getPendingDecorationOrderManager();
    int modifyFlowerOrderEmployee(FlowerOrder flowerOrder);
    FlowerOrder getFlowerOrder(int orderId);
    DecorationOrder getDecorationOrder(int orderId);
    int modifyDecorationOrderEmployee(DecorationOrder decorationUpdateOrder);

    int deleteFlowerOrderById(String orderId);

    int deleteDecorationOrderById(String orderIdQuery);

    List<FlowerOrder> viewDoneFlowerOrder(String username, int employeeId);

    List<DecorationOrder> viewDoneDecorationOrder(String username, int employeeId);

    List<Flower> getAllFlowers();
    List<Decoration> getAllDecorations();

    int updateFlower(Flower flower, String id);

    int updateDecoration(Decoration decoration, String id);

    Flower getFlowerById(String flowerId);

    Decoration getDecorationById(String decorationId);
}
