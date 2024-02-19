package school.hei.sary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school.hei.sary.repository.model.Transformation;

import java.util.Optional;

@Repository
public interface TransformationRepository extends CrudRepository<Transformation, String> {
    @Override
    Optional<Transformation> findById(String id);
}
