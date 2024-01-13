package org.commerceproject.ecommerceprodcutservice.Repository;

import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CateogryRepository  extends JpaRepository<Cateogry, UUID >{

}
