package wanted.ecommerce.product.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "slug")
	})
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "seller_id",
		nullable = false)
	private Long sellerId;

	@Column(name = "brand_id",
		nullable = false)
	private Long brandId;

	@Column(name = "name",
		nullable = false)
	private String name;

	@Column(name = "slug",
		nullable = false,
		unique = true,
		length = 255)
	private String slug;

	@Column(name = "short_description",
		nullable = true,
		length = 500)
	private String shortDescription;

	@Lob
	@Column(name = "full_description",
		nullable = true)
	private String fullDescription;

	@Column(name = "status",
		nullable = false,
		length = 20)
	private String status;

	@Column(name = "created_at",
		updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at",
		updatable = true)
	private LocalDateTime updatedAt;

	@OneToOne(mappedBy = "product",
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private ProductDetail productDetail;

	@OneToOne(mappedBy = "product",
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private ProductPrice productPrice;

	@OneToMany(mappedBy = "product",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<ProductImage> productImages = new ArrayList<>();

	@OneToMany(mappedBy = "product",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<ProductOptionGroup> productOptionGroups = new ArrayList<>();

	@OneToMany(mappedBy = "product",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<ProductCategory> productCategories = new ArrayList<>();

	@OneToMany(mappedBy = "product",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<ProductTag> productTags = new ArrayList<>();
}
