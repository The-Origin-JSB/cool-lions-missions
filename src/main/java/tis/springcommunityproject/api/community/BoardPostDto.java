package tis.springcommunityproject.api.community;

import tis.springcommunityproject.api.UserDto;
import tis.springcommunityproject.domain.PostEntity;

import java.time.LocalDateTime;


public class BoardPostDto {
	private String title;

	private String content;

	private UserDto user;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;

	public BoardPostDto() {
	}

	public BoardPostDto(PostEntity source) {
		this(source.getTitle(), source.getContent(), new UserDto(source.getUser()), source.getCreateAt(), source.getUpdateAt());
	}

	public BoardPostDto(String title, String content, UserDto user, LocalDateTime createAt, LocalDateTime updateAt) {
		this.title = title;
		this.content = content;
		this.user = user;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public BoardPostDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public PostEntity newPostEntity() {
		return PostEntity.of(title, content);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public UserDto getUser() {
		return user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
}