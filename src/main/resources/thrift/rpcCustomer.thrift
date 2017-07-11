namespace java com.zph.demo.customer.rpc.model

typedef i32 int
typedef i64 long
struct RpcCustomer {
	1 : long customerId,
	2 : int point,
	3 : int todayPoint,
	4 : int consume
}