import org.capslv.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

public class HibernateTest {
    // Session 工厂  Session: 数据库会话，代码持久化操作数据库的一个桥梁
    private SessionFactory sf;

    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        // 构建session factory
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testAdd() {
        // 进行创建数据库的会话，持久化操作
        try(Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer cus = new Customer();
            cus.setCustomerName("lmh");
            session.save(cus);
            // 事务提交
            transaction.commit();
        }
    }

    @Test
    public void testGet() {
        try(Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Customer customer = session.find(Customer.class, 1L);   // get load都可以查询，load是软加载，什么时候用才查询
            tx.commit();
            System.out.println(customer);
        }
    }

    @Test
    public void testUpdate() {
        try(Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustomerAddress("hunan");
            customer.setCustomerName("lmh");
            customer.setCustomerId(1L);
            session.saveOrUpdate(customer);
            tx.commit();
        }
    }

    @Test
    public void testDelete() {
        try(Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustomerId(2L);
            // 需要传入一个pojo类
            session.delete(customer);
            tx.commit();
        }
    }
}
