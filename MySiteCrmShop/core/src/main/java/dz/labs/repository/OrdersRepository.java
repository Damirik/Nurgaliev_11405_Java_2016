package dz.labs.repository;

import dz.labs.model.Orders;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    public void deleteOrder(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete Orders o where o.id = :id")
                .setLong("id", id).executeUpdate();
    }

    public Orders getOrderById(Long id) {
        return (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);
    }
}
