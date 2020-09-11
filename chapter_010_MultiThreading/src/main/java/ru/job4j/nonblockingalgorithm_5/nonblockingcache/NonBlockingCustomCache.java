package ru.job4j.nonblockingalgorithm_5.nonblockingcache;

// 1. Необходимо сделать кеш для хранение моделей. в кеше должны быть методы
//add(Base model), update(Base model) delete(Base model),
//2. . Для хранения данных в кеше нужно использовать ConcurrentHashMap<Integer, Base>.
//В качестве ключа используйте int id. в качестве значения Base модель
//3. В кеше должна быть возможность проверять актуальность данных. Для этого в модели данных должно быть после int version.
//Это поле должно увеличиваться на единицу каждый раз, когда произвели изменения данных в модели.
//Например. Два пользователя прочитали данные task_1
//первый пользователь изменил поле имя и второй сделал тоже самое. нужно перед обновлением данных проверить.
// что текущий пользователь не затер данные другого пользователя. если данные затерты
// то выбросить OptimisticException - такая реализация достигается за счет введение в модель поля version.
// Перед обновлением данных необходимо проверять текущую версию и ту что обновляем и увеличивать
// на единицу каждый раз, когда произошло обновление. Если версии не равны -  кидать исключение.
//Исключение - OptimisticException нужно сделать самостоятельно.

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class NonBlockingCustomCache {
    @GuardedBy("this")
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public boolean add(Base model) {
        return this.cache.put(model.getId(), model) != null;
    }

    public boolean update(Base model){
        return cache.computeIfPresent(model.getId(), (key, oldModel) ->
            {
                int oldVersion = oldModel.getVersion().get();
                if (model.getVersion().get() != oldModel.getVersion().get()) {
                    throw new OptimisticException();
                } else {
                    model.getVersion().set(oldVersion + 1);
                }
                return model;
            }) != null;
    }

    public boolean delete(Base model){
        return this.cache.remove(model.getId()) != null;
    }

    public Base get(int id) {
        return this.cache.get(id);
    }

}
