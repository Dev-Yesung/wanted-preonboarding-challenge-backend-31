package wanted.ecommerce.catalog.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "categories",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "slug")
	})
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",
		nullable = false)
	private Long id;

	@Column(name = "name",
		nullable = false,
		length = 100)
	private String name;

	@Column(name = "slug",
		nullable = false,
		unique = true,
		length = 100)
	private String slug;

	@Lob
	@Column(name = "description",
		nullable = true,
		columnDefinition = "TEXT")
	private String description;

	@Column(name = "level",
		nullable = false)
	private Integer level;

	@Column(name = "image_url",
		nullable = false,
		length = 255)
	private String imageUrl;

	// 부모 카테고리
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id",
		nullable = true)
	private Category parent;

	// 자식 카테고리 목록
	@OneToMany(mappedBy = "parent",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<Category> children;
}
