package com.zph.demo.services;

import com.zph.demo.customer.rpc.service.RpcCustomerService;
import com.zph.demo.managers.DemoManager;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by zhangpeihao on 17/7/10.
 */
public class ThriftServer extends Thread {
    private DemoManager manager;

    public ThriftServer(WebApplicationContext context) {
        System.out.println("ThriftServer");
        this.manager = (DemoManager)context.getBean("manager");
    }

    public void init() {
        System.out.println("ThriftServer::init");
        TServer server = null;
        try {
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            processor.registerProcessor("demoService", new RpcCustomerService.Processor<RpcCustomerService.Iface>(this.manager));

            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(new TNonblockingServerSocket(7766));;
            tnbArgs.processor(processor);
            tnbArgs.transportFactory(new TFramedTransport.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());
            tnbArgs.maxReadBufferBytes=102400L;
            server = new TNonblockingServer(tnbArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
            if (server != null)
            {
                server.stop();
            }
        }
    }

    @Override
    public void run() {
        init();
    }

}
