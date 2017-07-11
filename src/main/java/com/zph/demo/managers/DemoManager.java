package com.zph.demo.managers;

import com.zph.demo.customer.rpc.service.RpcCustomerService;
import com.zph.demo.interfaces.IDemoManager;

/**
 * Created by zhangpeihao on 17/7/10.
 */
public class DemoManager implements IDemoManager{
    public void save(com.zph.demo.customer.rpc.model.RpcCustomer rpcCustomer) throws org.apache.thrift.TException {
        System.out.println("DemoManager.save");
    }
}
