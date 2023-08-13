package servicebyservletshibernamte.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import servicebyservletshibernamte.entity.Customer;
import servicebyservletshibernamte.util.HibernateUtil;

import java.util.List;

public class CustomerRepositoryImpl extends HibernateUtil implements CustomerRepository {

    public void addCustomer(Customer customer) {

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(customer);
        transaction.commit();

        session.close();

    }

    public void deleteCustomer(Customer customer) {

        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(customer);
        transaction.commit();

        session.close();
    }

    public Customer findCustomerById(Long id) {

        Session session = getSessionFactory().openSession();

        Customer customer = (Customer) session.get(Customer.class, id);

        session.close();

        return customer;
    }

    public List<Customer> findAllCustomers() {

        Session session = getSessionFactory().openSession();
        return session.createQuery("from Customer").list();
    }
}
