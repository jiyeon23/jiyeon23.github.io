package examples.springbootcrud.repository;


import examples.springbootcrud.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> { //primary 키가 long이다.

}
