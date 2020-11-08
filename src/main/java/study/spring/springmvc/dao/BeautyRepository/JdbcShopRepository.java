package study.spring.springmvc.dao.BeautyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", designer.getName());
        parameters.put("specialty", designer.getSpecialty());
        parameters.put("beautyShop_id", designer.getBeautyShop().getDB_Id());
        jdbcInsert.execute(parameters);
    }

    @Override
    public void beautyShopSave(BeautyShop beautyShop) {
        // 이 부분 조금 애매함 미용실 저장 메소드인데 디자이너를 넘겨주는 행동 같이하고 있음.
        // 나중에 컨트롤러에서 서비스로 보내면서 분리하여 해결하면 더 좋을듯 함
        List<Designer> designerList = beautyShop.getDesignerList();
        for (Designer designer : designerList)
            designerSave(designer);

        //미용실 저장부분
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("BeautyShop").usingGeneratedKeyColumns("db_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("store_name", beautyShop.getStoreName());
        parameters.put("local", beautyShop.getLocal());
        parameters.put("tel_number", beautyShop.getPhoneNumber());
        parameters.put("menu", beautyShop.getMenu().getDB_id());

        // 어떻게 저장해야될지  잘몰르겠음..
        parameters.put("Designer_list", beautyShop.getDesignerList());
        parameters.put("Member_list", beautyShop.getMemberList());
        jdbcInsert.execute(parameters);

    }

    @Override
    public void menuSave(Menu menu) {

    }

    @Override
    public List<BeautyShop> getAllBeautyShopList() {
        String sql = "select * from BeautyShop";
        return template.query(sql, beautyShopRowMapper());
    }

    private RowMapper<BeautyShop> beautyShopRowMapper() {
        return (resultSet, i) -> {
            BeautyShop beautyShop = new BeautyShop();
            beautyShop.setStoreName(resultSet.getString("store_name"));
            beautyShop.setLocal(resultSet.getString("local"));
            beautyShop.setPhoneNumber(resultSet.getString("tel_number"));
            beautyShop.setDB_Id(resultSet.getLong("db_id"));
            // 아래부터 디자이너 리스트 , 회원 목록 , 메뉴가져와야함
            /*beautyShop.setMemberList();
            beautyShop.setMenu();
            beautyShop.setDesignerList();*/
            return beautyShop;
        };
    }
}
