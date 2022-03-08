package tis.springcommunityproject.domain;

import tis.springcommunityproject.domain.area.AreaEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String name;

	//TODO 등록일자와 수정일자는 공통으로 처리 가능하다.
	@Column(updatable = false, nullable = false)
	private LocalDateTime createAt;

	@Column(insertable = false)
	private LocalDateTime updateAt;

	@Embedded
	private AreaEntity area;

	protected UserEntity() {
	}

	private UserEntity(String name) {
		this(null, name, null, null);
	}

	private UserEntity(Long id, String name, LocalDateTime updateAt, AreaEntity area) {

		// 유효성 검사
		this.id = id;
		this.name = name;
		this.createAt = now();
		this.updateAt = updateAt;
		this.area = area;
	}

	public static UserEntity of(Long id, String name, LocalDateTime updateAt, AreaEntity area) {
		return new UserEntity(id, name, updateAt, area);
	}

	public static UserEntity of( String name) {
		return new UserEntity(name);
	}


	public void updateAt() {
		this.updateAt = now();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void updateName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserEntity user = (UserEntity) o;
		return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}
}
