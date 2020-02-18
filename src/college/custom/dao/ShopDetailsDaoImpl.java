package college.custom.dao;

import college.custom.model.ShopDetails;
import college.custom.util.ConnectionDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopDetailsDaoImpl implements ShopDetailsDao {

    @Override
    public int save(ShopDetails shopDetails, String anchor) {
        try {
            Connection connection = ConnectionDb.getConnection();
            Statement statement = connection.createStatement();
            String shopQuery;
            if(anchor.equals("save")) {
                shopQuery = "INSERT INTO SHOPDETAILS (SHOP_NAME, ADDRESS, CITY, STATE, COUNTRY. PINCODE, STARTDATE) " +
                        "VALUES ('" + shopDetails.getShopName() + "','" + shopDetails.getAddress()
                        + "','" + shopDetails.getCity() + "','" + shopDetails.getState()
                        + "','" + shopDetails.getCountry() + "','" + shopDetails.getPincode() + "','" + shopDetails.getStartdate() + "')";
            } else if(anchor.equals("update")) {
                shopQuery = "INSERT INTO SHOPDETAILS (SHOP_NAME, ADDRESS, CITY, STATE, COUNTRY. PINCODE, STARTDATE) " +
                        "VALUES ('" + shopDetails.getShopName() + "','" + shopDetails.getAddress()
                        + "','" + shopDetails.getCity() + "','" + shopDetails.getState()
                        + "','" + shopDetails.getCountry() + "','" + shopDetails.getPincode() + "','" + shopDetails.getStartdate() + "')";
            }
            return statement.executeUpdate(shopQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
