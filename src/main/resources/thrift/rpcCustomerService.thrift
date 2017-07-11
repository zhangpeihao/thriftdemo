namespace java com.zph.demo.customer.rpc.service

include "rpcCustomer.thrift"

typedef i32 int
typedef i64 long

service RpcCustomerService {
	void save(1 : rpcCustomer.RpcCustomer rpcCustomer);

}