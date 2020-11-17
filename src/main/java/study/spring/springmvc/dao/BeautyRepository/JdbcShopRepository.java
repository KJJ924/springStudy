package study.spring.springmvc.dao.BeautyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;
import study.spring.springmvc.dto.beautyShop.Order;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class JdbcShopRepository implements BeautyShopRepository {
    private final JdbcTemplate template;

    @Autowired
    public JdbcShopRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void designerSave(List<Designer> designers, BeautyShop shop) {
        /*SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("designer").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", designer.getName());
        parameters.put("specialty", designer.getSpecialty());
        parameters.put("beautyShop_id", designer.getBeautyShop().getDB_Id());
        jdbcInsert.execute(parameters);*/
        String sql = "insert into designer (name,specialty,beautyShopName) values(?,?,?) ";
        template.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,designers.get(i).getName());
                    ps.setString(2,designers.get(i).getSpecialty());
                    ps.setString(3,shop.getStoreName());
            }
            @Override
            public int getBatchSize() {
                return designers.size();
            }
        });
    }

    @Override
    public void beautyShopSave(BeautyShop beautyShop) {
        // 이 부분 조금 애매함 미용실 저장 메소드인데 디자이너를 넘겨주는 행동 같이하고 있음.
        // 나중에 컨트롤러에서 서비스로 보내면서 분리하여 해결하면 더 좋을듯 함
        // service 로 이동
        /*List<Designer> designerList = beautyShop.getDesignerList();
        for (Designer designer : designerList)
            designerSave(designer);*/

        //미용실 저장부분
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("BeautyShop").usingGeneratedKeyColumns("db_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("store_name", beautyShop.getStoreName());
        parameters.put("local", beautyShop.getLocal());
        parameters.put("tel_number", beautyShop.getPhoneNumber());
//        parameters.put("menu", beautyShop.getMenu().getDB_id());

        // 어떻게 저장해야될지  잘몰르겠음..
//        parameters.put("Designer_list", beautyShop.getDesignerList());
//        parameters.put("Member_list", beautyShop.getMemberList());
        jdbcInsert.execute(parameters);

    }
    @Override
    public void menuSave(Menu menu) {
        // DB 구조 생각좀 해야될듯 ? ->  메뉴 이름 , 가격인데 테이블 한 로우 한번에포함?
        // 아니면 로우 계속생성?
        BeautyShop beautyShop = menu.getBeautyShop();
        Map<String, Integer> menu1 = menu.getMenu();
        List<String> menuItems = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        //일단 뷰티샵 ID 저장할때 바로 못가져오니깐 0으로 선언하고 KEY값 변경 생각해봐야됨
        String sql = "insert into menu(menu_item,price,beautyShopName)  values (?,?,?)";
        for (final Map.Entry<String, Integer> entry : menu1.entrySet()) {
            menuItems.add(entry.getKey());
            prices.add(entry.getValue());
        }

        template.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,menuItems.get(i));
                ps.setLong(2,prices.get(i));
                // 참조키 미용실 이름으로 변경 - > 원래 이렇게 하면안됨 미용실 이름이 중복될수 있어서
                // 가정 -> 미용실 이름은 중복되지 않는다.
                ps.setString(3,beautyShop.getStoreName());
            }
            @Override
            public int getBatchSize() {
                return menu1.size();
            }
        });
    }

    @Override
    public void orderSave(Order order) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("order_list").usingGeneratedKeyColumns("DB_iD");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Shop_id", order.getShopId());
        parameters.put("menu_name", order.getMenuName());
        parameters.put("price", order.getPrice());
        parameters.put("member_id", order.getMemberId());
        parameters.put("order_date", order.getOrderDate());
        parameters.put("cancel", order.isCancel());
        parameters.put("reservation_date", order.getReservationDate());
        jdbcInsert.executeAndReturnKey(parameters);
    }

    @Override
    public List<BeautyShop> getAllBeautyShopList() {

        // 가져 올때 조인 써서 한번에 다 가져와야됨  RowMapper 다시만들어야함
        String sql = "select * from BeautyShop";
        return template.query(sql, beautyShopRowMapper());

        // 일단 그냥 미용실 테이블 만 가져와서 목록 만들어보세여(BeautyShop 객체를 만들라는 뜻
        // ->미용실 이름, 로컬, 핸드폰번호만) 일단 !
        // -> 목록에 뿌려질떄는 1 .미용실 이름 - >클릭하면 미용실 주소와 핸드폰 번호가 보이는
        // 상세페이지 구현
        // 1. BeautyShop 객체를 만든다 ->  DB에 접근해서 모든 미용실 객체를 List 담는다.
        // 2. 생성한 List 반환 -> BeautyShopService 로 가져간다
        // 3. BeautyShopService 에서 List 받은후  컨트롤러로  전달
        // 4. 컨트롤러 에서 받은 List 를 Model and view 생성하여 Jsp 넘기는데  1번 확인
        // 5. get요청으로 게시판을 클릭 했을때 다시 컨트롤러에 요청 보낸뒤 클릭한 미용실에 맞는
        // 6. 상세 정보를 가져온뒤 보여준다.
        // 7. getBeautyShop 만든다 (select * from BeautyShop where Db_id = ?)
        // 8. 가져온 BeautyShop 을 다시 서비스로 보낸다.(getBeautyShop 맞는 서비스생성)
        // 9. 컨트롤러에서 가져온 미용실을 jsp model 에 담아서 전달.

        // 추가 . 로그인한 손님만 미용실 리스트를 보여준다 -> 세션활용(핸들러 인터셉터) 하면좋아요 ㅎ
    }

    @Override
    public BeautyShop getBeautyShop(Long db_ID) {
        // db_ID를 어디서 가져오지??

        String sql = "select * from BeautyShop where DB_Id = ?";

        List<BeautyShop> query = template.query(sql, beautyShopRowMapper(), db_ID);
        // ?? 이게뭐지 findany, get>?????????? -> java 8 optional 보시면되요
        // return type 은 optional 로 한번 감싸서 보내는게 안전해요
        // 만약 null 값이 return 되면 nullPoint 오류 떠서 안전하게 한번 랩핑하는 것
        return query.stream().findAny().get();
    }

    @Override
    public List<Designer> getDesignerList(String shopName) {
        String sql = "select * from Designer where beautyShopName = ?";
        return template.query(sql, designerRowMapper(), shopName);
    }

    private RowMapper<Designer> designerRowMapper(){
        return ((resultSet, i) -> {
            Designer designer = new Designer();
            designer.setId(resultSet.getLong("id"));
            designer.setSpecialty(resultSet.getString("Specialty"));
            designer.setName(resultSet.getString("name"));
            return designer;
        });
    }

    @Override
    public List<Menu> getMenu(String shopName) {
        String sql = "select * from menu where beautyShopName = ?";

        return template.query(sql,menuRowMapper(),shopName);

    }
    private RowMapper<Menu> menuRowMapper() {
        // 설계 잘못해서 망함 ㅋ
        return (resultSet, i) -> {
            Menu menu = new Menu();
            Map<String, Integer> map = new HashMap<>();
            map.put(resultSet.getString("menu_item"),
                    resultSet.getInt("price"));
            menu.setMenu(map);
            return menu;
        };
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
