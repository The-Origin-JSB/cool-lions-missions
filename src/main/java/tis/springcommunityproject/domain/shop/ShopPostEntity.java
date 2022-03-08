package tis.springcommunityproject.domain.shop;

import tis.springcommunityproject.domain.community.BoardPostEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SHOP")
public class ShopPostEntity extends BoardPostEntity {
}
