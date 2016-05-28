package dz.labs.services;

import dz.labs.model.Carts;
import dz.labs.model.Orders;
import dz.labs.repository.OrderGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dz.labs.model.OrderGoods;

import java.util.List;

@Service
public class OrderGoodsService {

    @Autowired
    OrderGoodsRepository orderGoodsRepository;

    @Transactional
    public void addOrderGoods(Orders orders, List<Carts> carts) {
        for (Carts c : carts)
            orderGoodsRepository.add(new OrderGoods(c.getCount(), orders, c.getGoods()));
    }

}
