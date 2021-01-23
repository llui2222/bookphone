package com.aleksei.repository;

import com.aleksei.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone,Long> {
}
