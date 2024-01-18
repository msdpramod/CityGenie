package org.commerceproject.ecommerceprodcutservice.Repository;

import org.commerceproject.ecommerceprodcutservice.Models.Cateogry;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository @Lazy
public interface CateogryRepository  extends JpaRepository<Cateogry, UUID >{
    Optional<Cateogry> findById(UUID uuid);

    @Override
    List<Cateogry> findAllById(Iterable<UUID> uuids);
}
