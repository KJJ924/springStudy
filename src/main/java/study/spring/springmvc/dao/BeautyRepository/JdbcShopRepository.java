package study.spring.springmvc.dao.BeautyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcShopRepository implements BeautyShopRepository {
    private final JdbcTemplate template;

    @Autowired
    public JdbcShopRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void designerSave(Designer designer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("designer").usingGeneratedKeyColumns("id");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("name",designer.getName());
        parameters.put("specialty",designer.getSpecialty());
        parameters.put("beautyShop_id",designer.getBeautyShop().getDB_Id());
    }

    @Override
    public void beautyShopSave(BeautyShop beautyShop) {

    }

    @Override
    public void menuSave(Menu menu) {

    }

    @Override
    public List<BeautyShop> getAllBeautyShopList() {
        return null;
    }
}
