package wanted.ecommerce.product.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_details")
@Entity
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",
		nullable = false)
	private Long id;

	@Column(name = "weight",
		precision = 10,
		scale = 2)
	private BigDecimal weight;

	@Column(name = "dimensions",
		columnDefinition = "JSONB")
	private String dimensions;

	@Column(name = "materials",
		columnDefinition = "TEXT")
	private String materials;

	@Column(name = "country_of_origin",
		length = 100)
	private String countryOfOrigin;

	@Column(name = "warranty_info",
		columnDefinition = "TEXT")
	private String warrantyInfo;

	@Column(name = "care_instructions",
		columnDefinition = "TEXT")
	private String careInstructions;

	@Column(name = "additional_info",
		columnDefinition = "JSONB")
	private String additionalInfo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",
		nullable = false)
	private Product product;
}
