package study.spring.springmvc.dto.beautyShop.img;


public class BeautyShopInfoImage {
    private Long DB_Id;
    private Long BeautyShopID;
    private String imgPath;

    public BeautyShopInfoImage(Long DB_Id, Long beautyShopID, String imgPath) {
        this.DB_Id = DB_Id;
        this.BeautyShopID = beautyShopID;
        this.imgPath = imgPath;
    }

    public Long getDB_Id() {
        return DB_Id;
    }

    public void setDB_Id(Long DB_Id) {
        this.DB_Id = DB_Id;
    }

    public Long getBeautyShopID() {
        return BeautyShopID;
    }

    public void setBeautyShopID(Long beautyShopID) {
        BeautyShopID = beautyShopID;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
