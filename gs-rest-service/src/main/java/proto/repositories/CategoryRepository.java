package proto.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;
import proto.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}