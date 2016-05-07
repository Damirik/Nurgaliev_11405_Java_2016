package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Carts;
import ru.kpfu.itis.model.OrderGoods;
import ru.kpfu.itis.model.Orders;
import ru.kpfu.itis.repository.OrderGoodsRepository;

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
