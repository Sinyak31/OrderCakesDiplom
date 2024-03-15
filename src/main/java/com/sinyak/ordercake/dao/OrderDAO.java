

package com.sinyak.ordercake.dao;

import com.sinyak.ordercake.entity.Client;
import org.springframework.transaction.annotation.Transactional;

public interface OrderDAO {

    public void saveOrder(Client client);
}
