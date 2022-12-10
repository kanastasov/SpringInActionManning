package com.tacocloud.kirilanastasoff.tacocloud.repository;

import com.tacocloud.kirilanastasoff.tacocloud.model.TacoOrder;

public interface OrderRepository {
	TacoOrder save(TacoOrder order);
}
