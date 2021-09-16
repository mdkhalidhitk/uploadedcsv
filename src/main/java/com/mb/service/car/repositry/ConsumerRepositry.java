package com.mb.service.car.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.service.car.model.Consumer;

@Repository
public interface ConsumerRepositry extends JpaRepository<Consumer,Long> {

}
