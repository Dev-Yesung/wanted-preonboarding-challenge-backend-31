package wanted.ecommerce.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_categories")
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "category_id",
		nullable = false)
	private Long categoryId;

	@Column(name = "is_primary",
		nullable = false,
		columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean isPrimary = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",
		nullable = false)
	private Product product;
}
