package study.spring.springmvc.service.BeautyShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.springmvc.dao.BeautyRepository.BeautyShopRepository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;

@Service
public class BeautyShopService {
    private BeautyShopRepository beautyShopRepository;

    @Autowired
    public BeautyShopService(BeautyShopRepository beautyShopRepository) {
        this.beautyShopRepository = beautyShopRepository;
    }

    //Service 에서 미용실 다 받은 뒤 여기서 분배..
    public void saveBeautyShopService(BeautyShop shop){
        beautyShopRepository
    }
}
