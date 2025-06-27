package tttn_2025.phoneShop.handlers.endPoints.products.selft.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tttn_2025.phoneShop.common.entities.audit.AuditableEntity;
import tttn_2025.phoneShop.handlers.endPoints.brands.selft.entity.BrandEntity;
import tttn_2025.phoneShop.handlers.endPoints.productStatus.entity.ProductStatusEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productLineLinks.entity.ProductLineLinkEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.entity.ProductVariantEntity;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProductEntity extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uid;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "photo_url", nullable = true)
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_uid", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_STATUS"))
    private ProductStatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_uid", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_BRAND"))
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private List<ProductLineLinkEntity> productLineLinks;

    @OneToMany(mappedBy = "product")
    private List<ProductVariantEntity> variants;
}
