package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.model.Item;
import java.util.List;

public class HbnTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
        .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession())
        {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        try (Session session = sf.openSession())
        {
            session.beginTransaction();
            session.update(id, item);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        try (Session session = sf.openSession())
        {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from ru.job4j.tracker.model.Item").list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from ru.job4j.tracker.model.Item where name ='" + key + "'").list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.get(Item.class, Integer.valueOf(id));
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
