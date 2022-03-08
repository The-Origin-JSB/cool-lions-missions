package tis.springcommunityproject.domain.shop;

import tis.springcommunityproject.domain.UserEntity;
import tis.springcommunityproject.domain.area.AreaEntity;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class ShopEntity {

	@Id
	@GeneratedValue
	@Column(name = "shop_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Embedded
	private AreaEntity area;

	@Enumerated
	private Category category;

	protected ShopEntity() {
	}

	private ShopEntity(Long id, UserEntity user, AreaEntity area, Category category) {
		this.id = id;
		this.user = user;
		this.area = area;
		this.category = category;
	}

	public static ShopEntity of(Long id, UserEntity user, AreaEntity area, Category category) {
		return new ShopEntity(id, user, area, category);
	}

}
