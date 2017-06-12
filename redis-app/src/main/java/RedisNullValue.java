import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by zdpwilliam on 17-3-13.
 */
public class RedisNullValue {


    public static void main(String[] args) {
        removeKeys();
    }

    public static void removeKeys() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.select(1);
        Set<String> keys = jedis.keys("wo-group:*");
        if(keys != null && keys.size() > 0) {
            Iterator<String> keysIterator = keys.iterator();
            while (keysIterator.hasNext()) {
                String key = keysIterator.next();
                System.out.println("key " + key + " has been deleted");
                jedis.del(key);
            }
        }
        jedis.close();
    }
}
