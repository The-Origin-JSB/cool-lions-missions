package tis.springcommunityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tis.springcommunityproject.domain.UserEntity;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
	@Override
	<S extends UserEntity> S save(S entity);

	@Override
	Optional<UserEntity> findById(Long aLong);

	@Override
	boolean existsById(Long aLong);

	@Override
	void deleteById(Long aLong);
}