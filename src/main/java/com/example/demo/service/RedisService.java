package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by macro on 2018/8/7.
 */
public interface RedisService {

    //存储数据
    void set(String key, Object value);
    //存储数据
    void set(String key, Object value, Long time);
    //获取数据
    Object get(String key);
    //删除数据
    Boolean del(String key);
    //批量删除
    Long del(List<String> keys);
    //设置过期时间
    boolean expire(String key, long time);
    //获取过期时间
    Long getExpire(String key);
    //判断key是否存在
    Boolean hasKey(String key);
    //自增操作，步长delta
    Long incr(String key, long delta);
    //自减操作，步长delta
    Long decr(String key, long delta);
    //获取hash结构中的数据
    Object hGet(String key, String hashKey);
    //向hash结构中存入数据
    void hSet(String key, String hashKey, Object value);
    //向hash结构中存入数据
    Boolean hSet(String key, String hashKey, Object value, long time);
    //获取整个hash结构
    Map<Object, Object> hGetAll(String key);
    //设置整个hash结构
    void hSetAll(String key, Map<Object, Object> map);
    //设置整个hash结构
    Boolean hSetAll(String key, Map<Object, Object> map, Long time);
    //删除hash结构中数据
    void hDel(String key, Object... hashKey);
    //判断hash结构中是否存在属性
    Boolean hHasKey(String key, String hashKey);
    //hash结构中属性递增
    Long hIncr(String key, String hashKey, Long delta);
    //hash结构中属性递减
    Long hDecr(String key, String hashKey, Long delta);
    //获取set结构
    Set<Object> sMembers(String key);
    //向set结构中添加属性
    Long sAdd(String key, Object... values);
    //向set结构中添加属性
    Long sAdd(String key, Long time, Object... values);
    //是否为set结构中的属性
    Boolean sIsMember(String key, Object value);
    //获取set结构的长度
    Long sSize(String key);
    //删除set中的属性
    Long sRemove(String key, Object... values);
    //获取list结构中的属性
    List<Object> lRange(String key, Long start, Long end);
    //获取list结构长度
    Long lSize(String key);
    //根据下标获取list结构中的属性
    Object lIndex(String key, Long index);
    //向list结构中添加属性
    Long lPush(String key, Object value);
    //向list结构中添加属性
    Long lPush(String key, Object value, Long time);
    //向list结构中批量添加属性
    Long lPushAll(String key, Object... values);
    //向list结构中批量添加属性
    Long lPushAll(String key, Long time, Object... values);
    //从list结构中删除属性
    Long lRemove(String key, Long count, Object value);
























}
