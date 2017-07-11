#!/bin/bash

docker pull thrift:0.9.3

docker run --rm -v "$PWD:/data" thrift:0.9.3 thrift -o /data --gen java /data/rpcCustomer.thrift

docker run --rm -v "$PWD:/data" thrift:0.9.3 thrift -o /data --gen java /data/rpcCustomerService.thrift