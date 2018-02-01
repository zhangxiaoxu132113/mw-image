/**
 * 参考资料
 * http://blog.csdn.net/chen7253886/article/details/52779471
 *
 * Created by admin on 2018/1/29.
 */
package com.water.image.client.pool;

/**
 * TSocket.isOpen()方法只能检测到连接是否打开，在已打开的情况下然后网络中断或服务宕机，
 * 该方法是无法检测到连接的可用性，所以整个工作需要我们自己来维护，
 */