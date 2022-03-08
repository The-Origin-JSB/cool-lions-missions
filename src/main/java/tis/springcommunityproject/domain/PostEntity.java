package tis.springcommunityproject.domain;

import tis.springcommunityproject.domain.community.BoardPostEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type")
public class PostEntity {
	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	private String title;

	private String content;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(updatable = false, nullable = false)
	private LocalDateTime createAt;

	@Column(insertable = false)
	private LocalDateTime updateAt;

	protected PostEntity() {
	}

	private PostEntity(Long id, String title, String content, UserEntity user, LocalDateTime updateAt) {

		// 유효성 검사

		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
		this.createAt = now();
		this.updateAt = updateAt;
	}

	public PostEntity(String title, String content) {
		this(null, title, content, null, null);
	}

	public static PostEntity of(Long id, String title, String content, UserEntity user, LocalDateTime updateAt) {
		return new PostEntity(id, title, content, user, updateAt);
	}

	public static PostEntity of(String title, String content) {
		return new PostEntity(title, content);
	}

	public void updateContent(String content) {
		this.content = content;
	}

	public void updateTitle(String title) {
		this.title = title;
	}

	public void updateAt() {
		this.updateAt = now();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public UserEntity getUser() {
		return user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoardPostEntity post = (BoardPostEntity) o;
		return Objects.equals(getId(), post.getId()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getContent(), post.getContent()) && Objects.equals(getUser(), post.getUser()) && Objects.equals(getCreateAt(), post.getCreateAt()) && Objects.equals(getUpdateAt(), post.getUpdateAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTitle(), getContent(), getUser(), getCreateAt(), getUpdateAt());
	}

	public void updateUser(UserEntity user) {
		this.user = user;
	}
}
