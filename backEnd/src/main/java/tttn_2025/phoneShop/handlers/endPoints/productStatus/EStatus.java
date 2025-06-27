package tttn_2025.phoneShop.handlers.endPoints.productStatus;

public enum EStatus {

    DRAFT("Bản nháp"),
    ACTIVE("Đang hiển thị"),
    IN_ACTIVE("Ẩn khỏi website"),
    COMING_SOON("Sắp có hàng"),
    OUT_OF_STOCK("Hết hàng"),
    DISCONTINUED("Ngừng kinh doanh");

    private String label;

    private EStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return name();
    }
}
